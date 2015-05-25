package pages.wm.stat.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;

/**
 * Created by s.lugovskiy on 15.04.2015 11:29.
 */
@Name("выпадающий список селекта")
@Block(@FindBy(xpath = "//div[@class='select-list']"))
public class SelectList extends HtmlElement {


    @FindBy(xpath = "//a[@class='select-item' and @data-id='today']")
    private Link today;

    @FindBy(xpath = "//a[@class='select-item' and @data-id='yesterday']")
    private Link yesterday;

    @Step("виден ли выпадающий список")
    public boolean isVisible(){
        return this.isDisplayed();
    }

    @Step("клик сегодня")
    public void clickToday(){
        today.click();
    }

    @Step("клик вчера")
    public void clickYesturday(){
        yesterday.click();
    }


}