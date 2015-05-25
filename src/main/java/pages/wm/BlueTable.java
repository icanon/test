package pages.wm;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;


@Name("Синяя таблица")
@Block(@FindBy(xpath = "//table[contains(@class,'blue_table')]"))
public class BlueTable extends HtmlElement {

    @Name("th столбца динамики .//th[@col_name='dynamics']")
    @FindBy(xpath = ".//th[@col_name='dynamics']")
    private WebElement dynamicTh;

    @Name("td динамики первый .//td/div[@class='dynamics _hasGraphWidget']/div")
    @FindBy(xpath = ".//td/div[@class='dynamics _hasGraphWidget']/div")
    private WebElement dynamicTd;

    @Name("индикатор загрузки динамики  .//div[@class='dynamics']")
    @FindBy(xpath=".//div[@class='dynamics']")
    private WebElement dynamicGif;

    @FindBy(xpath=".//tbody")
    private WebElement tbody;

    @Name("th столбца доп параметра в отчете по офферам .//tr[@row_number='1']/th[contains(@class,'hardBorder') and contains(@class,'fixBorder')]/div")
    @FindBy(xpath = ".//tr[@row_number='1']/th[contains(@class,'hardBorder') and contains(@class,'fixBorder')]/div")
    private WebElement addParamTh;


    @Step
    public String getDynamicThText() {
       return dynamicTh.getText();
    }

    @Step
    public boolean dynamicTdIsVisible(){
        return dynamicTd.isDisplayed();
    }

    @Step
    public WebElement getDynamicTd() {
        return dynamicTd;
    }

    public WebElement getDynamicGif() {
        return dynamicGif;
    }

    public WebElement getAddParamTh() {
        return addParamTh;
    }

    @Step
    @Attachment
    public String getTableBodyText(){
        return tbody.getText();
    }
}
