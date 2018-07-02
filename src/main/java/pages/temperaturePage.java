package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;


@Name("Cтраница проосмотра погоды")
public class temperaturePage extends AkitaPage {

        @FindBy(xpath = ".//*[(@class=\"input__control\")]")
        @Name("Поиск Города")
        public SelenideElement searchYandexField;

    @FindBy(xpath = ".//*[(@class=\"link forecast-briefly__header-button\")][2]")
    @Name("Кнопка прогноз на месяц")
    public SelenideElement searchYandexButton;



        @Optional
    @FindBy(xpath = ".//*[(@class=\"suggest2-item__link\")]")
    @Name("Найденный город")
    private SelenideElement resultPage1;

}
