package pages.wm.office.payments.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

/**
 * Created by a.hodakov on 18.05.2015.
 */
@Name("Поп-ап верификации телефона")
@Block(@FindBy(xpath = "//div[contains(@class,'black detached-buttons')]"))
public class PaymentsVerificationPopup extends HtmlElement {


    @FindBy(xpath = "//a[@class='_get_sms_code']")
    private Link getsms;

    @FindBy(xpath = "//input[@name='code']")
    private TextInput codeinput;

    @FindBy(xpath = "(//a[contains(@class,'button dark submit')])[2]")
    private Link submit;

    @Step("получаем смс")
    public void getsms(){
        getsms.click();
    }

    @Step("заполняем форму верифакации в тестовом режиме")
    public void fillVerificationForm(){
        codeinput.clear();
        codeinput.sendKeys("1234");
        submit.click();
    }


}
