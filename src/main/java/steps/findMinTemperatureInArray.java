package steps;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;
import java.util.*;
import java.util.concurrent.TimeUnit;
import static com.codeborne.selenide.Selenide.$;
import static ru.alfabank.tests.core.helpers.PropertyLoader.tryLoadProperty;

@Slf4j
public class findMinTemperatureInArray {
    AkitaScenario akitaScenario = AkitaScenario.getInstance();

    @Тогда("^вывести минимальное значение из списка \"([^\"]*)\"$")
    public void selectRandomElementFromList(String listName) {
        try {
            TimeUnit.MILLISECONDS.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<SelenideElement> listOfElementsFromPage = akitaScenario.getCurrentPage().getElementsList(listName);
//        List<String> elementsListText = listOfElementsFromPage.stream()
//                .map(element -> element.getText().trim().toLowerCase().substring(1))
//                .collect(toList());
        List<Integer> listInt= new ArrayList<>();
        for(SelenideElement selenideElement: listOfElementsFromPage){
            listInt.add(Integer.parseInt(selenideElement.getText().substring(1)));
        }
        Integer minValue = Collections.min(listInt);
            int Herniua = listInt.indexOf(minValue);
        akitaScenario.write("Выведена минимальная температура выбранного месяца: число месяца - " + (Herniua+1) + "| +" + minValue);
        //listOfElementsFromPage.get(getRandom(listOfElementsFromPage.size())).shouldBe(Condition.visible).click();
//        List<Integer> listInt = new ArrayList<Integer>(elementsListText.size());
//        for (String current:elementsListText) {
//            listInt.add(Integer.parseInt(current));
//        }
        /*Integer elementForCompare = Integer.MAX_VALUE;
        for (SelenideElement selenideElement: listOfElementsFromPage){
            if (Integer.parseInt(selenideElement.getSearchCriteria().substring(1))<elementForCompare){
                elementForCompare=Integer.parseInt(selenideElement.getSearchCriteria().substring(1));
            }
        }*/
    }
    @И("^Сбор минимальной температуры за год из списка \"([^\"]*)\"$") //и вывести мин температуру "([^"]*)"
    public void collectTemperatureInYear( String listName){
        String[] monthValue = new String[]{
                                "Янв.","Февр.", "Март", "Апр.", "Май", "Июнь", "Июль",
                "Авг.", "Сент.", "Окт.", "Нояб.", "Дек."} ;
        Actions actions = new Actions(WebDriverRunner.getWebDriver());
        List<Integer> listInt= new ArrayList<>();
        Map<String, Integer> listOfYear = new HashMap<String, Integer>();

        for (String num : monthValue) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            actions.click($(By.xpath("//*[contains(text(),'"+num+"')]"))).build().perform();
            List<SelenideElement> listOfElementsFromPage = akitaScenario.getCurrentPage().getElementsList(listName);
            //начинаем сбор минимальных температур за год по месяцам
            for(SelenideElement selenideElement: listOfElementsFromPage){
                listInt.add(Integer.parseInt(selenideElement.getText().substring(1)));
            }
            Integer minValue = Collections.min(listInt);
            listOfYear.put(num,minValue);
        }
        akitaScenario.write("Температура по месяцам:" + listOfYear);
            //akitaScenario.write("список месяцев: " + (Arrays.toString(monthValue)));
    }

    @И("^выполнено нажатие на что то с текстом \"(.*)\"$")
    public void findElement(String text) {
        //$(By.xpath("//*[text()='" + getPropertyOrStringVariableOrValue(text) + "']")).click();
        $(By.xpath(".//*[contains (text(),'"+getPropertyOrStringVariableOrValue(text)+"')]")).click();
    }
    private int getRandom(int maxValueInRange) {
        return (int) (Math.random() * maxValueInRange);
    }

    public String getPropertyOrStringVariableOrValue(String propertyNameOrVariableNameOrValue) {
        String returnValue = tryLoadProperty(propertyNameOrVariableNameOrValue);
        if (returnValue == null) {
            akitaScenario.write("Переменная " + propertyNameOrVariableNameOrValue + " в property файле не найдена");
            returnValue = (String)akitaScenario.tryGetVar(propertyNameOrVariableNameOrValue);
            if (returnValue == null) {
                akitaScenario.write("Переменная сценария " + propertyNameOrVariableNameOrValue + " не найдена");
                returnValue = propertyNameOrVariableNameOrValue;
            }
        }

        return returnValue;
    }
}
