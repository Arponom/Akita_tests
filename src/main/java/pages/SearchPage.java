package pages;


import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

@Name("Страница поиска гугл")
public class SearchPage extends AkitaPage {

    @FindBy(xpath = ".//*[(@id='lst-ib')]")
    @Name("Поиск")
    public SelenideElement searchField;

    @Optional
    @FindBy(xpath = ".//*[(@class='lsbb')]" )
    @Name("Найти")
    public SelenideElement searchButton;

    @Optional
    @FindBy(xpath = "//*[@id=\"tads\"]/ol/li[1]/div[2]/cite" )
    @Name("Описание товара")
    public SelenideElement fieldSearch;

    @Optional
    @FindBy(xpath = "//*[@id=\"vn1s0p1c0\"]" )
    @Name("Описание товара2")
    public SelenideElement fieldSearch2;




}

