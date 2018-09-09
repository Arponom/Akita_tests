package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import java.util.List;

@Name("Cтраница проосмотра погоды за месяц")
public class monthPage extends AkitaPage {

    @FindBy(xpath = ".//*[(@class=\"graph-longterm__label-title\")]")
    @Name("температурные показатели")
    private List<SelenideElement> spisokTemperatury ;

    @FindBy(xpath = ".//*[(@class=\"link forecast-briefly__header-button\")][2]")
    @Name("Кнопка прогноз на месяц")
    public SelenideElement searchYandexButton;

}
