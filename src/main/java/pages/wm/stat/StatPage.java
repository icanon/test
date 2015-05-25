package pages.wm.stat;

import api.assertions.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.BlueTable;
import pages.wm.PopupBlack;
import pages.wm.Spinners;
import pages.wm.office.elements.LeftMenu;
import pages.wm.stat.elements.*;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.Printer;

/**
 * Created by a.hodakov on 11.03.2015.
 */

public class StatPage extends BasePage {


    private WebDriver driver;
    private Spinners spin;
    private WebElementHelper helper;
    private LeftMenu leftmenu;
    private SelectChart select;
    private SelectList selectList;
    private SelectChartCompare selectChartCompare;
    private GraphLegendTypes graphLegendTypes;
    private HighchartsContainer highchartsContainer;
    private BlueTable table;
    private Dynamic dynamic;
    private PopupBlack popup;
    private AddParameter addParameter;
    private CalendarStat calendarStat;


    private By realtimeGraph = By.xpath("(//div[@class='highcharts-container'])[1]");
    private By realtimeGraph2 = By.xpath("(//div[@class='highcharts-container'])[2]");
    private By userName = By.xpath("//div[@class='ca-bar__item ca-bar__item--owner']");
    private By calendar = By.xpath("//a[contains(@class,'label-icon icon-datepicker')]");


    public StatPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.helper = new WebElementHelper(driver);
    }

    @FindBy(id = "period")
    private TextInput period;

    @FindBy(id = "statExportButton")
    private Link export;

    @Name("/div[@class='subinput compare_text']")
    @FindBy(xpath = "//div[@class='subinput compare_text']")
    private WebElement compareDiv;

    @Step("получаем div от сравнения под календарем")
    public WebElement getCompareDiv() {
        return compareDiv;
    }

    @Step("ждем появления реалтайм графика")
    public void waitRealTime(){
        helper.fluentWait(realtimeGraph);
        helper.fluentWait(realtimeGraph2);
    }

    @Step
    public void checkUser(String name) {
        String user = driver.findElement(userName).getText();
        Assertions.assertObjectsEquals(name,user);
    }

    @Step("проверка выпадающего списка селекта")
    public void checkSelectList(){
        select.clickSelect();
        Assertions.assertTrue(selectList.isVisible());
    }

    @Step("проверка выпадающего списка сравнения селекта")
    public void checkCompareSelectList(){
        selectChartCompare.clickSelect();
        Assertions.assertTrue(selectList.isVisible());
    }

    @Step("проверка линейного типа графика")
    public void checkLinearGraphType(){
        graphLegendTypes.clickLinear();
        Assertions.checkWebElementExists(graphLegendTypes.getLinear());
        Assertions.checkWebElementExists(highchartsContainer);

    }

    @Step("проверка наличия блока Динамика над таблицей")
    public void checkDynamicContainer(){
        Assertions.checkWebElementExists(dynamic);
    }

    @Step
    public void setDynamics(String parameter){
        dynamic.clickShowDynamic();
        popup.fillInput(parameter);
        popup.clickText(parameter);
        spin.waitDynamics();
        spin.waitJquery();

    }

    @Step
    public void setAddParam(String parameter){
        Printer.println("ADD PARAM "+parameter);
        addParameter.clickShowAddParam();
        popup.fillInput(parameter);
        popup.clickText(parameter);
        spin.waitSpinner();
        spin.waitJquery();

    }

    @Step("ждем появления сводных показателей")
    public void waitOverview() {
        helper.fluentWait(By.xpath("//div[@class='grid-justify']/div[@class='ib v-top']"));
    }

    @Step
    public void checkDynamicThText(String parameter){
        Assertions.assertStringContains(table.getDynamicThText(),parameter);
    }



    @Step("проверка видимости первого td динамики")
    public void checkFirstDynamicTdVisible(){
        Assertions.checkWebElementVisible(table.getDynamicTd());
    }

    @Step("проверка видимости контейнера графика")
    public void checkHighchartsContainner() {
        Assertions.checkWebElementVisible(highchartsContainer);
    }

    @Step("запуск выгрузки в эксель")
    public void export() {
        export.click();
        Assertions.checkWebElementVisible(popup);
        popup.clickSubmit();
        Assertions.checkWebElementNotVisible(popup);

    }

    @Step("проверка что th доп параметра в отчете по офферам видим")
    public void checkAddParameterThVisible(String thName) {
        Assertions.checkWebElementHasText(table.getAddParamTh(), thName);
    }

    @Step("проверка что в таблице нет текста Неизвестно")
    public void checkTableHasNotText(String text){
        Assertions.assertStringNotContains(table.getTableBodyText(), text);
    }

    @Step("клик по дате загрузки")
    public void clickByLoadDate() {
        evaluateJavascript("$('a[data-date-type=\"sale_event_time\"]').click();");
    }

    @Step("установить дату в календаре")
    public void setCalendarDate() {
        helper.fluentWait(calendar);
        driver.findElement(calendar).click();
        calendarStat.clickSelectPeriod();
        Assertions.checkWebElementVisible(selectList);
        selectList.clickToday();
        calendarStat.submit();
    }

    @Step("установить дату сравнения сегодня - вчера в  календаре")
    public void setCalendarCompareDate() {
        helper.fluentWait(calendar);
        driver.findElement(calendar).click();
        calendarStat.clickSelectPeriod();
        Assertions.checkWebElementVisible(selectList);
        selectList.clickToday();
        calendarStat.clickCompareCheckbox();
        calendarStat.clickSelectPeriod();
        Assertions.checkWebElementVisible(selectList);
        selectList.clickYesturday();
        calendarStat.submit();
    }



    @Step
    @Attachment
    public String getPeriod(){
        return period.getEnteredText();
    }
}
