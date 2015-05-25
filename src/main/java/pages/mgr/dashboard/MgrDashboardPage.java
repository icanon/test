package pages.mgr.dashboard;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebElementHelper;
import pages.mgr.dashboard.elements.PageHeader;
import pages.wm.BasePage;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Utils;

/**
 * Created by a.hodakov on 11.03.2015.
 */
public class MgrDashboardPage extends BasePage{
    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private PageHeader header;
    private Utils utils;


    public MgrDashboardPage(WebDriver driver) {

        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
        this.utils = new Utils(driver);

    }

    @FindBy(id = "account_type_switch_to_old")
    private WebElement old;

    @FindBy(xpath = "//ul[@id='user_info']/li/a[@class='user']")
    private WebElement oldUser;

    @Step("переход в раздел Пользователи")
    public void goToUsers(){
        spin.waitSpinner();
        header.clickUsers();
        spin.waitSpinner();
        header.clickUsers2();
        spin.waitSpinner();

    }
    @Step("переход в финансы")
    public void goToFinance(){
        spin.waitSpinner();
        header.clickFinance();
        helper.fluentWait(By.xpath("//div[contains(@class,'ca-table')]"));
        spin.waitSmallSpinner();
    }


    @Step("переход в старый интерфейс")
    public void goToOldInterface() {
        String oldUrl = System.getProperty("old");
        String url = old.getAttribute("href").replace("http://cityads.ru",oldUrl);
        utils.goToUrl(url);
    }


    @Step("получаем имя пользователя со старого интерфейса")
    public String getOldUserName(){
        return oldUser.getText();
    }

    @Step("ждем загрузку старого интерфейса")
    public void waitOldInterface(){
        helper.fluentWait(By.xpath("//ul[@id='user_info']/li/a[@class='user']"));
    }



}
