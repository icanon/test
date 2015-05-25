package wm.stat;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.front.FrontPage;
import pages.wm.office.dashboard.WmDashboardPage;
import pages.wm.stat.StatPage;
import roles.OAuthUser;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Severity;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.model.SeverityLevel;
import setup.Utils;
import wm.login.BaseTest;

@Test
@Features("Статистика новая По Офферам")
public class StatByOffersAdditionalParameterTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private StatPage stat;
    private final String section = "/webmaster/statistika/standard/offers";
    private Spinners spin;
    private BasePage page;


    @DataProvider
    public Object[][] addParameterAndDynamic() {
        return new Object[][] {
                {"Типы офферов","Тип оффера", "Показы"},
                {"Вертикали", "Вертикаль", "Хиты"},
                {"Категории","Категория", "Клики"},
                {"Подкатегории","Подкатегория", "Back URL"},
                {"Категория промо","Категория промо", "Открытые лиды"},
                {"Формат кода","Формат кода", "Одобренные лиды"},
                {"Тип ссылки","Тип ссылки", "Все лиды"},
                {"Тип размера","Тип размера", "Открытые продажи"},
                {"Размер промо","Размер промо", "Одобренные продажи"}
        };
    }


    @BeforeClass
    public void setUp(){

        driver = super.getDriver();
        utils = super.getUtils();
        front = new FrontPage(driver);
        dashboard = new WmDashboardPage(driver);
        stat = new StatPage(driver);
        spin = new Spinners(driver);
        page = new BasePage(driver);
        OAuthUser user = new OAuthUser();
        utils.goToAuthStand();
        front.login(user);
        dashboard.waitLogo();
        utils.goToAuthStandSection(section);

    }

    @BeforeMethod
    public void waitPageLoad(){
        stat.waitOverview();
        spin.waitSpinner();
    }



    @Test(dataProvider = "addParameterAndDynamic")
    @Stories("добавление и прогруз доп параметра и динамики")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOffersAddParameterTest(String add_parameter, String thName, String dynamic_parameter) throws Exception {

        stat.setAddParam(add_parameter);
        page.checkPopupNotVisible();
        stat.checkAddParameterThVisible(thName);

        stat.checkDynamicContainer();
        stat.setDynamics(dynamic_parameter);
        stat.checkDynamicThText(dynamic_parameter);
        stat.checkFirstDynamicTdVisible();

    }





    @AfterMethod
    public void clearState(){
        utils.refreshPage();
    }

    @AfterClass
    public void closebrowser(){
        driver.quit();
    }

}
