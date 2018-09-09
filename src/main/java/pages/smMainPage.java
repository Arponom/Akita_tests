package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Главная страница Спормастер")
public class smMainPage extends AkitaPage{

    @FindBy(xpath = "//a[@data-selenium='open_city_menu']")
    @Name("Выбранный город сайта")
    private SelenideElement smMainpage;

    @FindBy(xpath = "//div[@class='newMenu__trigger' and contains(.,'Каталог товаров')]")
    @Name("Каталог товаров")
    private SelenideElement smCatalogFirstLevel;
}
