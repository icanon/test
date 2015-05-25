package pages.wm.office.payments.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.HtmlElement;

/**
 * Created by a.hodakov on 18.05.2015.
 */
@Name("Таблица внешних счетов")
@Block(@FindBy(id = "table_wm.payinfo"))
public class PaymentsInfoTable extends HtmlElement {

    @FindBy(xpath = "//tbody/tr/td")
    private Button tabledata;




}
