package wm.paymentsaccount.RUS;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.wm.front.FrontPage;
import pages.wm.offercard.OfferCardPage;
import pages.wm.office.OfficePage;
import pages.wm.office.PaymentsPage;
import pages.wm.office.dashboard.WmDashboardPage;
import roles.Webmaster;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Создание счета vk")
public class PaymentsVKRusAccountCreateTest extends BaseTest {

    private FrontPage front;

    private WmDashboardPage dashboard;
    private OfferCardPage card;
    private Webmaster wm;
    private Utils utils;
    private WebDriver driver;
    private OfficePage office;
    private PaymentsPage paypage;
    @BeforeClass
    public void setUp(){
        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);;
        card = new OfferCardPage(driver);
        office = new OfficePage(driver);
        paypage = new PaymentsPage(driver);
        wm = new Webmaster();
        utils.openMainPage();
        front.login(wm);
        dashboard.isOnDashboard();

    }







    @Test
    @Title("Создание кошелька vk, Страна Россия, Юрисдикция onshore, Тип контрагента  Физ-лицо")
    @Stories("создание кошелька vk")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOnshoreFizvkCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOnshore();
        paypage.fill3stStepFIz();
        paypage.check4stStepLabels(7);
        paypage.fill4stStepVK();
        paypage.fill5stStepRUB(1);
        paypage.fill6Step();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();

    }



/*    @Test
    @Title("Создание кошелька vk, Страна Россия, Юрисдикция OFFshore, Тип контрагента Физическое лицо")
    @Stories("создание кошелька vk")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOFFshoreFIZvkCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOFFshore();
        paypage.fill3stStepFIz();
        paypage.check4stStepLabels(7);
        paypage.fill4stStepVK();
        paypage.fill5stStepRUB(1);
        paypage.fill6Step();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }*/

    @AfterMethod
    public void goBack(){
        utils.openWMMainPage();


    }


    @AfterClass
    public void closebrowserAndDelete(){
        office.goTopaymentsInfo();
        paypage.deleteAllPaymentsInfo();
        driver.quit();


    }

}
