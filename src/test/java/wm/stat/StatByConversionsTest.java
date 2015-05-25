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
@Features("Статистика новая по Конверсиям")
public class StatByConversionsTest extends BaseTest {

    private FrontPage front;
    private WmDashboardPage dashboard;
    private Utils utils;
    private WebDriver driver;
    private StatPage stat;
    private final String section = "/webmaster/statistika/standard/conversions";
    private Spinners spin;
    private BasePage page;

    @DataProvider
    public Object[][] addParameter() {
        return new Object[][] {
                {"Типы офферов","Тип оффера"},
                {"Вертикали", "Вертикаль"},
                {"Категории","Категория"},
                {"Подкатегории","Подкатегория"},
                {"Категория промо","Категория промо"},
                {"Формат кода","Формат кода"},
                {"Тип ссылки","Тип ссылки"},
                {"Тип размера","Тип размера"},
                {"Размер промо","Размер промо"}
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

    @Test(dataProvider = "addParameter")
    @Stories("добавление и прогруз доп параметра")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByOffersAddParameterTest(String add_parameter, String thName) throws Exception {

        stat.setAddParam(add_parameter);
        page.checkPopupNotVisible();
        stat.checkAddParameterThVisible(thName);

    }


    @Test
    @Stories("проверка наличия шапки")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statByConversionsHeaderTest() throws Exception {
       page.checkHeader();
    }

    @Test
    @Stories("селект над графиком")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByConversionssSelectTest() throws Exception {
        stat.checkSelectList();
    }

    @Test
    @Stories("селект сравнения над графиком")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByConversionssSelectCompareTest() throws Exception {
        stat.checkCompareSelectList();
    }

    @Test
    @Stories("линейный тип графика")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByConversionssLinearGraphTest() throws Exception {
        stat.checkLinearGraphType();
    }

    @Test
    @Stories("проверка наличия шапки")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statByConversionssHeaderTest() throws Exception {
        page.checkHeader();
    }

    @Test
    @Stories("проверка наличия таблицы")
    @Severity(value = SeverityLevel.CRITICAL)
    public void statByConversionssTableTest() throws Exception {
        page.checkTable();
    }

    @Test
    @Stories("проверка наличия пагинатора")
    @Severity(value = SeverityLevel.NORMAL)
    public void statByConversionsspaginatorTest() throws Exception {
        page.checkpaginator();
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
