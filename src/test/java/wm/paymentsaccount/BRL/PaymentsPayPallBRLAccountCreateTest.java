package wm.paymentsaccount.BRL;

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
@Features("Создание счета paypall")
public class PaymentsPayPallBRLAccountCreateTest extends BaseTest {

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
    @Title("Создание кошелька paypall, Страна Бразилия, Юрисдикция onshore, Тип контрагента  Физ-лицо")
    @Stories("создание кошелька paypall")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOnshoreFizPaypallCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepBRL();
        paypage.fill3stStepOnshore();
        paypage.fill3stStepFIz();
        paypage.check4stStepLabels(3);
        paypage.fill4stStepPaypall();
        paypage.fill5stStepBRL(1);
        paypage.fill6and7stStep();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();

    }


    @Test
    @Title("Создание кошелька paypall, Страна Бразилия, Юрисдикция onshore, Тип контрагента Юридическое лицо")
    @Stories("создание кошелька paypall")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOnshoreULPaypallCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepBRL();
        paypage.fill3stStepOnshore();
        paypage.fill3stStepUL();
        paypage.check4stStepLabels(2);
        paypage.fill4stStepPaypall();
        paypage.fill5stStepBRL(1);
        paypage.fill6and7stStepUR();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }




    @Test
    @Title("Создание кошелька paypall, Страна Бразилия, Юрисдикция OFFshore, Тип контрагента  Юридическое лицо")
    @Stories("создание кошелька paypall")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOFFshoreURPaypallCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepBRL();
        paypage.fill3stStepOFFshore();
        paypage.fill3stStepUL();
        paypage.check4stStepLabels(2);
        paypage.fill4stStepPaypall();
        paypage.fill5stStepBRL(7);
        paypage.fill6and7stStepUR();
        paypage.savePaymentsInfo();
        paypage.fillverificationform();
    }

    @Test
    @Title("Создание кошелька paypall, Страна Бразилия, Юрисдикция OFFshore, Тип контрагента Физическое лицо")
    @Stories("создание кошелька paypall")
    @Severity(value = SeverityLevel.CRITICAL)
    public void PaymentsAccountOFFshoreFIZPaypallCreateTest() throws InterruptedException {
        office.goTopaymentsInfo();
        paypage.clickCreate();
        paypage.fill1stStep();
        paypage.fill2stStepBRL();
        paypage.fill3stStepOFFshore();
        paypage.fill3stStepFIz();
        paypage.check4stStepLabels(3);
        paypage.fill4stStepPaypall();
        paypage.fill5stStepBRL(7);
        paypage.fill6and7stStep();
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
