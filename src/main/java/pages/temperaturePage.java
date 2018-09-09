package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import java.util.List;


@Name("Cтраница проосмотра погоды")
public class temperaturePage extends AkitaPage {

        @FindBy(xpath = ".//*[(@class=\"input__control\")]")
        @Name("Поиск Города")
        public SelenideElement searchYandexField;

        @Optional
        @FindBy(xpath = ".//*[(@class=\"link forecast-briefly-old__header-button\")][2]")
        @Name("Кнопка прогноз на месяц")
        public SelenideElement searchYandexButton;

        @Optional
        @FindBy(xpath = ".//*[(@class=\"suggest2-item__link\")]")
        @Name("Найденный город")
        private SelenideElement resultPage1;

        @FindBy(xpath = ".//*[(@class='title title_level_1')]")
        @Name("Активный город")
        private SelenideElement resultPage;

        @FindBy(xpath = "//div[@class='temp climate-calendar-day__temp-day']/span[@class='temp__value']")
        @Name("Температура днем")
        private List<SelenideElement> listTemprature;



}
