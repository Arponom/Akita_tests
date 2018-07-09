package steps;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.By;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import java.sql.Time;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;
import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static ru.alfabank.tests.core.helpers.PropertyLoader.tryLoadProperty;

@Slf4j
public class findMinTemperatureInArray {
    AkitaScenario akitaScenario = AkitaScenario.getInstance();
//GitHubSearchPageHelper gitHubSearchPageHelper = new GitHubSearchPageHelper();

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
        //akitaScenario.write("Выведена минимальная температура выбранного месяца: + " + minValue);
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
