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
@Name("дополнительный параметр")
@Block(@FindBy(xpath = "//div[contains(@class,'table-buttons-left')]/div[descendant::simplegroupcheck[@name='q_data_sub_group']]"))
public class AddParameter extends HtmlElement {

    @FindBy(xpath = ".//div[contains(@class,'_dd_button')]")
    private WebElement showAddParam;

    @Step("виден ли контейнер доп параметра")
    public boolean isVisible(){
        return this.isDisplayed();
    }

    @Step("клик по кнопке показа доп параметра")
    public void clickShowAddParam(){
        showAddParam.click();
    }


}