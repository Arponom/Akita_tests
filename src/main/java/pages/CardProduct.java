package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;
import ru.alfabank.alfatest.cucumber.api.AkitaScenario;

import java.util.List;

@Name("Карточка товара")
public class CardProduct extends AkitaPage {

    @FindBy(xpath = "(//span[contains(.,'магазинах')])[2]")
    @Name("Забрать в магазине")
    public SelenideElement storeLink;

    @FindBy(xpath = "//*[@title='Средне']/../../../td[@class='ccrests__table__column-address']/div/a")
    @Name("Адреса компаний")
    public List<SelenideElement> address;
}
