package steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;

@Slf4j
public class smStep {
    AkitaScenario akitaScenario = AkitaScenario.getInstance();
    Actions actions = new Actions(WebDriverRunner.getWebDriver());
    WebDriver driver = WebDriverRunner.getWebDriver();

    @Тогда("^Навести курсор на элемент \"([^\"]*)\"$")
    public void moveTO(String item) {
        SelenideElement field = $(By.xpath("//div[@class='newMenu__trigger' and contains(.,'" + item + "')]"));

        actions.moveToElement(field).build().perform();
    }

    @Тогда("^Навести курсор на меню каталога \"([^\"]*)\"$")
        public void moveTo(String item){
            SelenideElement field =  $(By.xpath("//span[contains(.,'"+item+"')]"));
            actions.moveToElement(field).build().perform();
    }

    @Тогда("^Нажать курсор на меню каталога \"([^\"]*)\"$")
    public void moveTo2(String item){
        SelenideElement field =  $(By.xpath("//a[contains(.,'"+item+"')]"));
        actions.moveToElement(field).click().perform();
    }

    @Тогда("^В фасете \"([^\"]*)\" выбрать значение \"([^\"]*)\"$")
    public void choseFacet(String item, String item2){
        try {
            TimeUnit.MILLISECONDS.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement field1 = driver.findElement(By.xpath("//h3[@class='active'][contains(.,'"+item+"')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); return true;", field1);

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    //    SelenideElement field =  $(By.xpath("//h3[contains(.,'"+item+"')]/..//./div/a[contains(.,'"+item2+"')]"));
    //    WebElement field1 = driver.findElement(By.xpath("//h3[contains(.,'Цвет')]/.."));
   //     ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", field1);
        //actions.moveToElement(field).build().perform();
        //actions.moveToElement(field).click().build().perform();

        $(By.xpath("//h3[contains(.,'"+item+"')]/..//./div/a[contains(.,'"+item2+"')]")).click();
    }

    @Тогда("^В фасете Ветроустойчивость выбрать значение \"([^\"]*)\"$")
    public void choseFacet1(String item){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        $(By.xpath("(//a[@class='sm-category__facet-value ajax-facet-value updateFacet '][contains(.,'"+item+"')])[2]")).click();
    }
    @Тогда("^В фасете Водонипроницаемость выбрать значение \"([^\"]*)\"$")
    public void choseFacet2(String item){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        $(By.xpath("(//a[@class='sm-category__facet-value ajax-facet-value updateFacet '][contains(.,'"+item+"')])")).click();
    }
    @Тогда("^В фасете Количество мест выбрать значение \"([^\"]*)\"$")
    public void choseFacet3(String item){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement field1 = driver.findElement(By.xpath("//h3[@class='active'][contains(.,'Количество мест')]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(); return true;", field1);
        $(By.xpath("//h3[contains(.,'Количество мест')]/..//./div/a[contains(.,'"+item+"')]")).click();
    }
    @Тогда("^В фасете Тип товара выбрать значение \"([^\"]*)\"$")
    public void choseFacet4(String item){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        $(By.xpath("//a[@class='sm-category__facet-value ajax-facet-value updateFacet '][contains(.,'"+item+"')]")).click();
    }

    @Тогда("^Выбрать самое дешевое из списка \"([^\"]*)\"$")
    public void findMinValue(String listName){
        try {
            TimeUnit.MILLISECONDS.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<SelenideElement> listOfElementsFromPage = akitaScenario.getCurrentPage().getElementsList(listName);
        List<Integer> listInt= new ArrayList<>();
        for(SelenideElement selenideElement: listOfElementsFromPage){
            listInt.add(Integer.parseInt(selenideElement.getText().substring(0,6)));
        }
        Integer minValue = Collections.min(listInt);
        akitaScenario.write("Выведена минимальная температура выбранного месяца: число месяца - "+minValue+"");
    }

    @Тогда("^Сохранить адреса магазинов \"([^\"]*)\"$")
    public void saveAddress(String listName){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        List<SelenideElement> listOfElementsFromPage = akitaScenario.getCurrentPage().getElementsList(listName);
        List<String> listStr= new ArrayList<>();
        for(SelenideElement selenideElement: listOfElementsFromPage){
            listStr.add(selenideElement.getText());
        }
        List<String> haha = listStr;
        createAndWriteFile(haha);
        akitaScenario.write("Список адресов" + haha );

    }
    @И("^Выполнено нажатие на (?:кнопку|поле|блок) \"([^\"]*)\"$")
    public void clickOnElement(String elementName) {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        akitaScenario.getCurrentPage().getElement(elementName).click();
    }

    public void createAndWriteFile(List<String> item){
        try{
            // Create new file
           // List<String> content = item;
            String path="A:\\avtomation\\Alfa-Akita\\src\\test\\SaveFile\\Address.txt";
            File file = new File(path);

            // If file doesn't exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);

            // Write in file
            for (String str : item)
            {
              bw.write(str);
              bw.newLine();
            }
            //bw.write(content);

            // Close connection
            bw.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }

}
