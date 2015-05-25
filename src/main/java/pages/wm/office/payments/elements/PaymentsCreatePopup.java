package pages.wm.office.payments.elements;

import api.assertions.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.annotations.Block;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.util.List;

/**
 * Created by a.hodakov on 18.05.2015.
 */
@Name("Поп-ап создания счета")
@Block(@FindBy(xpath = "//div[contains(@class,'popup modal white')]"))
public class PaymentsCreatePopup extends HtmlElement {


    @FindBy(xpath = "//div[contains(@class,'head')]/div[contains(@class,'_close_place')]/a")
    private Link headerClose;

    @FindBy(xpath = "//div[contains(@class,'head')]/div[1]/div")
    private WebElement popupHeader;

    @FindBy(xpath = "//div[contains(@class,'_buttons_place')]/a[contains(@class,'submit')]")
    private Link applyButton;

    @FindBy(xpath = "//div[contains(@class,'_buttons_place')]/a[2]")
    private Link cancellButton;

    @FindBy(xpath = "//div[@data-name='account_name']/input")
    private TextInput paymentname;

    @FindBy(xpath = "//div[contains(@class,'_select change')]/div[@class='select-choose pointer']")
    private WebElement selectMainAccount;

    @FindBy(xpath = "//div[@data-step='1']")
    private WebElement datastep1;

    @FindBy(xpath = "//div[@data-step='2']")
    private WebElement datastep2;

    @FindBy(xpath = "//div[@data-step='3']")
    private WebElement datastep3;

    @FindBy(xpath = "//div[@data-step='4']")
    private WebElement datastep4;

    @FindBy(xpath = "//div[@data-step='5']")
    private WebElement datastep5;
    @FindBy(xpath = "//div[@data-step='6']")
    private WebElement datastep6;
    @FindBy(xpath = "//div[@data-step='7']")
    private WebElement datastep7;

    @FindBy(xpath = "//span[@data-country='RU']")
    private WebElement rucountry;

    @FindBy(xpath = "//span[@data-country='BR']")
    private WebElement brlcountry;

    @FindBy(xpath = "//span[@data-country='CN']")
    private WebElement cncountry;

    @FindBy(xpath = "//div[@data-name='person_status']/div/label[descendant::input[@value='0']]")
    private WebElement personTypeFiz;

    @FindBy(xpath = "//div[@data-name='person_status']/div/label[descendant::input[@value='1']]")
    private WebElement personTypeUR;

    @FindBy(xpath = "//div[@data-name='person_status']/div/label[descendant::input[@value='2']]")
    private WebElement personTypeIP;

    @FindBy(xpath = "//div[@data-name='residency']/div/label[descendant::input[@value='1']]")
    private WebElement offshore;

    @FindBy(xpath = "//div[@data-name='residency']/div/label[descendant::input[@value='2']]")
    private WebElement onshore;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='5' or @value='9']])[1]")
    private WebElement bank;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='6']])[1]")
    private WebElement wmr;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='4']])[1]")
    private WebElement wmz;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='1']])[1]")
    private WebElement paypall;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='10']])[1]")
    private WebElement vk;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='20']])[1]")
    private WebElement mail;

    @FindBy(xpath = "(//div[@data-name='payout_method']/label[preceding-sibling::input[@value='30']])[1]")
    private WebElement yandex;

    @FindBy(xpath = "//div[preceding-sibling::select[@name='currency']]/div[@class='select-choose pointer']")
    private WebElement selectcurrency;

    @FindBy(xpath = "//a[@data-id='1']")
    private Link currency;

    @FindBy(xpath = "//label[contains(@class,'radio pointer') and parent::div[not(@class='hide')]]")
    private List<WebElement> labels3step;

    @FindBy(xpath = "//label[contains(@for,'payout-method')]")
    private List<WebElement> labels4step;

    @FindBy(xpath = "//a[contains(@class,'select-item') and @data-id>0]")
    private List<WebElement> curencys;



    public void selectcurrency(){
        selectcurrency.click();
    }

    @FindBy(xpath = "//div[@data-name='wallet_id']/input")
    private TextInput paynumber;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='vk_user_id' or @name='tm_email']")
    private TextInput vknumberormail;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='company_name' or @name='full_name']")
    private TextInput contacts;

    @FindBy(xpath = "//div[@data-name='company_name']/input")
    private TextInput companyname;


    @FindBy(xpath = "//input[@name='inn']")
    private TextInput innweb;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='ogrn' or @name='ogrnip']")
    private TextInput ogrnweb;

    @FindBy(xpath = "//input[@name='bic']")
    private TextInput bicweb;

    @FindBy(xpath = "//input[@name='bank']")
    private WebElement banknameweb;

    @FindBy(xpath = "(//span[@class='_auto_items pointer'])[1]")
    private WebElement banknamewebauto;


    @FindBy(xpath = "//input[@name='bank_office']")
    private TextInput bank_officeweb;

    @FindBy(xpath = "//input[@name='bank_adress_province']")
    private TextInput bank_adress_provinceweb;

    @FindBy(xpath = "//input[@name='bank_adress_city']")
    private TextInput bank_adress_cityweb;

    @FindBy(xpath = "//input[@name='bank_adress_district']")
    private TextInput bank_adress_districtweb;

    @FindBy(xpath = "//input[@name='bank_adress_street']")
    private TextInput bank_adress_streetweb;

    @FindBy(xpath = "//input[@name='bank_adress_index']")
    private TextInput bank_adress_indexweb;



    @FindBy(xpath = "//input[@name='bank_adress']")
    private TextInput bank_adressweb;

    @FindBy(xpath = "//input[@name='correspondent_account']")
    private TextInput correspondent_accountweb;

    @FindBy(xpath = "//input[@name='cc']")
    private TextInput ccweb;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='cnpj']")
    private TextInput cnpj;


    @FindBy(xpath = "//input[@name='swift']")
    private TextInput swiftweb;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='company_name' or @name='full_name']")
    private TextInput full_nameweb;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='person_address' or @name='legal_address']")
    private TextInput person_addressweb;


    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='company_name' or @name='full_name']")
    private TextInput full_namewebur;

    @FindBy(xpath = "//input[@name='legal_address']")
    private TextInput person_addresswebur;

    @FindBy(xpath = "//div[not(contains(@class,'hide'))]/input[@name='personal_number' or @name='chinese_ur_id']")
    private TextInput personal_number;

    @FindBy(xpath = "//input[@type='file'and @name='passport_scan']")
    private TextInput passport_scan;

    @FindBy(xpath = "//input[@type='file'and @name='passport_scan2']")
    private TextInput passport_scan2;



    @FindBy(xpath = "//div[not(contains(@class, 'hide'))and contains(@class,'margin-bottom-small') and @data-name]/input[not(contains(@type, 'hidden'))]")
    private List<WebElement> inputsbank;







    @Step("заполняем название счета")
    public void fillAccountName(String name){

        paymentname.sendKeys(name);

    }



    @Step("выбираем страну - Бразилия")
    public void clickCountruBRL(){
        brlcountry.click();

    }

    @Step("выбираем страну -Китай")
    public void clickCountruCN(){
        cncountry.click();

    }

    @Step("выбираем страну - Россия")
    public void clickCountruRU(){
        rucountry.click();


    }

    @Step("Проверяем кол-во юрисдикций и типов контрагентов на странице")
    public void check3stStepLabelsCount(int num){
        Assertions.assertTrue(labels3step.size() == num, "Количество юрисдикций и контрагентов не равно" + num + ", сейчас "+ labels3step.size()+"");;
    }

    @Step("Проверяем кол-во типов оплаты на странице")
    public void check4stStepLabelsCount(int num){
        Assertions.assertTrue(labels4step.size() == num, "Кол-во типов оплаты не равно" + num + ", сейчас "+ labels4step.size()+"");;
    }

    @Step("Проверяем кол-во валюты на странице")
    public void check4stStepCurrencyCount(int num){
        Assertions.assertTrue(curencys.size() == num, "Кол-во валюты не равно" + num + ", сейчас "+ curencys.size()+"");;
    }

    @Step("Проверяем кол-во импутов на странице")
    public void check6stStepInputsCount(int num){
        Assertions.assertTrue(inputsbank.size() == num, "Кол-во валюты не равно" + num + ", сейчас "+ inputsbank.size()+"");;
    }


    @Step("выбираем юрисдикцию платежа - Onshore")
    public void clickresidencyOnshore(){
        onshore.click();
    }

    @Step("выбираем юрисдикцию платежа - Offshore")
    public void clickresidencyOffshore(){
        offshore.click();
    }


    @Step("выбираем тип контрагента - Физическое лицо")
    public void clickPersonFiz(){
        personTypeFiz.click();

    }

    @Step("выбираем тип контрагента - Индивидуальный предприниматель")
    public void clickPersonIP(){
        personTypeIP.click();

    }

    @Step("выбираем тип контрагента - Юридическое лицо")
    public void clickPersonUL(){
        personTypeUR.click();

    }

    @Step("выбираем тип оплаты - Paypall")
    public void clickPaypall(){
        paypall.click();

    }

    @Step("выбираем тип оплаты - Bank")
    public void clickBank(){
        bank.click();

    }


    @Step("выбираем тип оплаты - WMR")
    public void clickWmr(){
        wmr.click();

    }

    @Step("выбираем тип оплаты - WMZ")
    public void clickWmz(){
        wmz.click();

    }

    @Step("выбираем тип оплаты - VK")
    public void clickVK(){
        vk.click();

    }
    @Step("выбираем тип оплаты - Target Mail")
    public void clickMail(){
        mail.click();

    }
    @Step("заполняем Реквизиты счета")
    public void fillWalletNumber(String text){
        paynumber.sendKeys(text);
    }

    @Step("заполняем Реквизиты счета")
    public void fillWalletNumberSocnet(String text){
        vknumberormail.sendKeys(text);
    }


    @Step("заполняем Реквизиты счета для банка")
    public void fillWalletNumberBank(String inn,String bik,String name,String office,String adres,String correspondent,String cc,String ogrn){


        ogrnweb.sendKeys(ogrn);
        innweb.sendKeys(inn);
        bicweb.sendKeys(bik);
        banknameweb.sendKeys(name);
        bank_officeweb.sendKeys(office);
        bank_adressweb.sendKeys(adres);
        correspondent_accountweb.sendKeys(correspondent);
        ccweb.sendKeys(cc);

    }

    @Step("заполняем Реквизиты счета для банка")
    public void fillWalletNumberBank(String inn,String bik,String name,String office,String adres,String correspondent,String cc){



        innweb.sendKeys(inn);
        bicweb.sendKeys(bik);
        banknameweb.sendKeys(name);
        bank_officeweb.sendKeys(office);
        bank_adressweb.sendKeys(adres);
        correspondent_accountweb.sendKeys(correspondent);
        ccweb.sendKeys(cc);

    }


    @Step("заполняем Реквизиты счета для банка")
    public void fillWalletNumberBank(String name,String office,String adres,String correspondent,String cc,String swift){


        banknameweb.sendKeys(name);
        bank_officeweb.sendKeys(office);
        bank_adressweb.sendKeys(adres);
        correspondent_accountweb.sendKeys(correspondent);
        ccweb.sendKeys(cc);
        swiftweb.sendKeys(swift);

    }

    @Step("заполняем Реквизиты счета для банка c автозаполнением")
    public void fillWalletNumberBankautocomplit(String cnpjs, String office, String cc){

        banknameweb.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        banknamewebauto.click();
        bank_officeweb.sendKeys(office);
        ccweb.sendKeys(cc);
        cnpj.sendKeys(cnpjs);



    }


    @Step("заполняем Реквизиты счета для банка c автозаполнением")
    public void fillWalletNumberBankautocomplit(String office, String cc,String bank_adress_province,String bank_adress_city,String  bank_adress_district,String  bank_adress_street,String  bank_adress_index,String swift){

        banknameweb.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        banknamewebauto.click();
        bank_officeweb.sendKeys(office);
        bank_adress_provinceweb.sendKeys(bank_adress_province);
        bank_adress_cityweb.sendKeys(bank_adress_city);
        bank_adress_districtweb.sendKeys(bank_adress_district);
        bank_adress_streetweb.sendKeys(bank_adress_street);
        bank_adress_indexweb.sendKeys(bank_adress_index);
        swiftweb.sendKeys(swift);
        ccweb.sendKeys(cc);




    }

    @Step("заполняем Реквизиты счета для банка c автозаполнением")
    public void fillWalletNumberBankautocomplit(String office, String cc,String bank_adress_province,String bank_adress_city,String  bank_adress_district,String  bank_adress_street,String  bank_adress_index){

        banknameweb.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        banknamewebauto.click();
        bank_officeweb.sendKeys(office);
        bank_adress_provinceweb.sendKeys(bank_adress_province);
        bank_adress_cityweb.sendKeys(bank_adress_city);
        bank_adress_districtweb.sendKeys(bank_adress_district);
        bank_adress_streetweb.sendKeys(bank_adress_street);
        bank_adress_indexweb.sendKeys(bank_adress_index);

        ccweb.sendKeys(cc);




    }

    @Step("заполняем Реквизиты счета для банка c автозаполнением")
    public void fillWalletNumberBankautocomplit(String office, String cc, String adres,String corp,String swift){

        banknameweb.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        banknamewebauto.click();

        bank_officeweb.sendKeys(office);
        bank_adressweb.sendKeys(adres);
        correspondent_accountweb.sendKeys(corp);
        ccweb.sendKeys(cc);
        swiftweb.sendKeys(swift);




    }






    @Step("заполняем Контактые данные")
    public void fillContacts(String text){
        contacts.sendKeys(text);
    }

    @Step("заполняем Контактые данные")
    public void fillContacts(String text,String text2){
        contacts.sendKeys(text);
        person_addressweb.sendKeys(text2);
    }

    @Step("заполняем Контактые данные")
    public void fillContacts(String text,String text2,String text3){
        contacts.sendKeys(text);
        person_addressweb.sendKeys(text2);
        personal_number.sendKeys(text3);
    }

    @Step("заполняем Контактые данные")
    public void fillContacts(String text,String text2,String text3,String te){
        contacts.sendKeys(text);
        person_addressweb.sendKeys(text2);
        personal_number.sendKeys(text3);
    }

    @Step("заполняем Контактые данные юридического лица")
    public void fillContactsUR(String text,String text2){
        companyname.sendKeys(text);
        person_addresswebur.sendKeys(text2);
    }
    @Step("заполняем Контактые данные юридического лица")
    public void fillContactsUR(String text){
        companyname.sendKeys(text);

    }



    @Step("Сохраняем счет")
    public void submitForm(){
        applyButton.click();
    }










}
