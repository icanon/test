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
@Features("Создание счета банка")
public class PaymentsBankRusAccountCreateTest extends BaseTest {

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
    @Title("Создание кошелька банка, Страна Россия, Юрисдикция onshore, Тип контрагента  Физ-лицо")
    @Stories("создание кошелька банка")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOnshoreFizBankCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOnshore();
        paypage.fill3stStepFIz();
        paypage.check4stStepLabels(7);
        paypage.fill4stStepBank();
        paypage.fill5stStepRUB(1);
        paypage.checkInputsPayments(11);
        paypage.fill6and7stStepBank();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();

    }


    @Test
    @Title("Создание кошелька банка, Страна Россия, Юрисдикция onshore, Тип контрагента Юридическое лицо")
    @Stories("создание кошелька банка")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOnshoreULBankCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOnshore();
        paypage.fill3stStepUL();
        paypage.check4stStepLabels(2);
        paypage.fill4stStepBank();
        paypage.fill5stStepRUB(1);
        paypage.checkInputsPayments(13);
        paypage.fill6and7stStepBankUL();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }


    @Test
    @Title("Создание кошелька банка, Страна Россия, Юрисдикция onshore, Тип контрагента  Индивидуальный предприниматель")
    @Stories("создание кошелька банка")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOnshoreIPBankCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOnshore();
        paypage.fill3stStepIP();
        paypage.check4stStepLabels(2);
        paypage.fill4stStepBank();
        paypage.fill5stStepRUB(1);
        paypage.checkInputsPayments(12);
        paypage.fill6and7stStepBankIP();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }

    @Test
    @Title("Создание кошелька банка, Страна Россия, Юрисдикция OFFshore, Тип контрагента  Индивидуальный предприниматель")
    @Stories("создание кошелька банка")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOFFshoreIPBankCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOFFshore();
        paypage.fill3stStepIP();
        paypage.check4stStepLabels(2);
        paypage.fill4stStepBank();
        paypage.fill5stStepRUB(7);
        paypage.checkInputsPayments(8);
        paypage.fill6and7stStepBankoffshore();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }

    @Test
    @Title("Создание кошелька банка, Страна Россия, Юрисдикция OFFshore, Тип контрагента  Юридическое лицо")
    @Stories("создание кошелька банка")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOFFshoreURBankCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOFFshore();
        paypage.fill3stStepUL();
        paypage.check4stStepLabels(2);
        paypage.fill4stStepBank();
        paypage.fill5stStepRUB(7);
        paypage.checkInputsPayments(8);
        paypage.fill6and7stStepBankoffshore();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }

    @Test
    @Title("Создание кошелька банка, Страна Россия, Юрисдикция OFFshore, Тип контрагента Физическое лицо")
    @Stories("создание кошелька банка")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOFFshoreFIZBankCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepRU();
        paypage.fill3stStepOFFshore();
        paypage.fill3stStepFIz();
        paypage.check4stStepLabels(7);
        paypage.fill4stStepBank();
        paypage.fill5stStepRUB(7);
        paypage.checkInputsPayments(8);
        paypage.fill6and7stStepBankoffshore();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }

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
