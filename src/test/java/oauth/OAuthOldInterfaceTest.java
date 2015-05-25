package oauth;

import api.assertions.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.mgr.dashboard.MgrDashboardPage;
import pages.oauth.OauthPage;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.stat.StatPage;
import roles.TestManager;
import roles.User;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("авторизация через Oauth")
public class OAuthOldInterfaceTest extends BaseTest {

    private OauthPage oauth;
    private Utils utils;
    private WebDriver driver;
    private BasePage page;
    private Spinners spin;
    private MgrDashboardPage mgr;
    private StatPage stat;

    @BeforeClass
    public void setUp(){

        driver = super.getDriver();
        utils = super.getUtils();
        oauth = new OauthPage(driver);
        page = new BasePage(driver);
        spin = new Spinners(driver);
        mgr = new MgrDashboardPage(driver);
        stat = new StatPage(driver);
        utils.openOauthForm();

    }


    @Test
    @Stories("авторизация менеджера старый интерфейс")
    @Severity(value = SeverityLevel.CRITICAL)
    public void oauthAuthorizeOldInterfaceTest() throws Exception {

        User user = new TestManager();
        oauth.oauthLogin(user);
        stat.waitOverview();
        spin.waitSmallSpinner();
        mgr.goToOldInterface();
        mgr.waitOldInterface();
        Assertions.assertObjectsEquals(user.getName(),mgr.getOldUserName());


    }


    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
