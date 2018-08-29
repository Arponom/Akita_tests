package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import javax.xml.xpath.XPath;
import java.util.List;

import static com.codeborne.selenide.Selenide.$$;

@Name("Просмотр температуры за месяц")
public class resultTownPage extends AkitaPage {



    @FindBy(xpath = ".//*[(@class=\"title title_level_1\")]")
    @Name("Выбранный город")
    private SelenideElement titleCountry;

    @FindBy(xpath = ".//*[(@class=\"graph-longterm__label-title\")]")
    @Name("температурные показатели")
    private List<SelenideElement> spisokTemperatury1;

    @FindBy(xpath = ".//*[(@class='title title_level_1')]")
    @Name("Активный город")
    private SelenideElement resultPage;

    @FindBy(xpath = "//div[@class='temp climate-calendar-day__temp-day']/span[@class='temp__value']")
    @Name("Температура днем")
    private List<SelenideElement> listTemprature;

}
