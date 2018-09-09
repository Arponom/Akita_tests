package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.alfabank.alfatest.cucumber.annotations.Name;
import ru.alfabank.alfatest.cucumber.annotations.Optional;
import ru.alfabank.alfatest.cucumber.api.AkitaPage;

import java.util.List;

@Name("Список товаров")
public class smCatalogPage extends AkitaPage {

    @FindBy(xpath = "//div[@class='sm-category__item-actual-price tr']/div/span/sm-amount/span")
    @Name("Текущая цена")
    private List<SelenideElement> collectValue;

    @Optional
    @FindBy(xpath = "(//div[@class='sm-category__main-sorting_pseudoselect'])[1]")
    @Name("Выбор сортировки")
    private SelenideElement dropdown;

    @Optional
    @FindBy(xpath = "//div[@class='sm-category__main-sorting_pseudoselect active']/div[2]/a[3]")
    @Name("По убыванию")
    private SelenideElement chooseDropValue;

    @Optional
    @FindBy(xpath = "(//div[@class='sm-category__items-wrap clearfix']//div[@class='sm-category__item '])[2]")
    @Name("Товар")
    public SelenideElement clickFirst;
}
