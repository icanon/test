package pages.wm.stat.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by s.lugovskiy on 15.04.2015 11:29.
 */
@Name("календарь")
@Block(@FindBy(xpath = "//div[@class='calendar']"))
public class CalendarStat extends HtmlElement {

    @FindBy(xpath = ".//div[contains(@class,'datepicker-range-select period')]")
    private WebElement periodSelect;

    @FindBy(xpath = ".//div[contains(@class,'datepicker-range-select compare')]")
    private WebElement periodSelectCompare;


    @FindBy(xpath = ".//div[contains(@class,'datepicker-range-select period')]")
    private WebElement periodCompareSelect;

    @FindBy(xpath = ".//a[contains(@class,'button_submit')]")
    private WebElement submit;

    @FindBy(xpath = ".//label[preceding-sibling::input[contains(@class,'compare')]]")
    private WebElement compareCheckbox;


    @Step("клик на селект выбора периода")
    public void clickSelectPeriod(){
        periodSelect.click();
    }

    @Step("клик на селект выбора периода сравнения")
    public void clickSelectComparePeriod(){
        periodSelectCompare.click();
    }

    @Step("клик на применить в календаре")
    public void submit(){
        submit.click();
    }

    @Step("клик на Сравнить С")
    public void clickCompareCheckbox(){
        compareCheckbox.click();
    }





}