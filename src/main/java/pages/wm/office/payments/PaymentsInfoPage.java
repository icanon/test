package pages.wm.office.payments;

import org.openqa.selenium.WebDriver;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.office.dashboard.elements.HotOffers;
import pages.wm.office.elements.LeftMenu;
import pages.wm.office.payments.elements.PaymentsInfoHeader;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class PaymentsInfoPage extends BasePage{
    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;
    private WebElementHelper helper;
    private LeftMenu leftmenu;
    private PaymentsInfoHeader payheader;



    public PaymentsInfoPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }


    @Step("нажимаем создать счет")
    @Attachment
    public void clickCreate() {

    }


}
