package pages.wm.office.payments.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by a.hodakov on 18.05.2015.
 */
@Name("Таблица внешних счетов")
@Block(@FindBy(xpath = "//div[contains(@class,'grid2 margin-top')]"))
public class PaymentsInfoHeader extends HtmlElement {

    @FindBy(xpath = "./div[contains(@class,'text-right')]/button")
    private Button createButton;

    @Step("клик на создать счет")
    public void clickCreate(){
        createButton.click();
    }


}
