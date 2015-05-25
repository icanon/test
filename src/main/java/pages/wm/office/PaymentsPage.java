package pages.wm.office;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.WebElementHelper;
import pages.wm.BasePage;
import pages.wm.Spinners;
import pages.wm.office.dashboard.elements.Finance;
import pages.wm.office.dashboard.elements.FinanceHeader;
import pages.wm.office.dashboard.elements.HotOffers;
import pages.wm.office.elements.LeftMenu;
import pages.wm.office.payments.elements.PaymentsCreatePopup;
import pages.wm.office.payments.elements.PaymentsInfoHeader;
import pages.wm.office.payments.elements.PaymentsVerificationPopup;
import ru.yandex.qatools.allure.annotations.Step;
import ru.yandex.qatools.htmlelements.loader.HtmlElementLoader;
import setup.DataGenerator;
import setup.Utils;

import java.io.File;

/**
 * Created by a.hodakov on 11.03.2015.
 */

public class PaymentsPage extends BasePage {


    private WebDriver driver;
    private Spinners spin;
    private HotOffers hot;
    private Finance finance;
    private FinanceHeader fheader;
    private WebElementHelper helper;
    private Utils util;
    private LeftMenu leftmenu;
    private PaymentsInfoHeader payheader;
    private PaymentsCreatePopup paypopup;
    private PaymentsVerificationPopup verification;



    public PaymentsPage(WebDriver driver) {
        super(driver);
        HtmlElementLoader.populatePageObject(this, driver);
        this.driver = driver;
        this.spin = new Spinners(driver);
        this.util = new Utils(driver);
        this.helper = new WebElementHelper(driver);
    }



    @Step("клик по созданию счета")
    public void clickCreate(){
        payheader.clickCreate();
        spin.waitSpinner();

    }

    @Step("кликаем на контрол выбора валюты и проверяем кол-во валюты в контроле")
    public void clickCurrencyList(int num){
        paypopup.selectcurrency();
        paypopup.check4stStepCurrencyCount(num);
    }


    @Step("выбираем валюту счета")
    public void chooseCurrency(int num){
        driver.findElement(By.xpath("//a[@data-id='"+num+"']")).click();


    }

    @Step("Заполняем первый шаг")
    public void fill1stStep(){
        spin.waitJquery();
        String name = DataGenerator.getRandomString();
        spin.waitSpinner();
        paypopup.fillAccountName(name);
        ((JavascriptExecutor) driver).executeScript("$('[name=account_name]').blur()");
        spin.waitSpinner();


    }

    @Step("Заполняем второй шаг(Странна Россия))")
    public void fill2stStepRU(){
        spin.waitSpinner();
        spin.waitJquery();
        paypopup.clickCountruRU();
        spin.waitJquery();
        paypopup.check3stStepLabelsCount(5);

    }

    @Step("Заполняем второй шаг(Странна Бразилия))")
         public void fill2stStepBRL(){
        spin.waitSpinner();
        spin.waitJquery();
        paypopup.clickCountruBRL();
        spin.waitJquery();
        paypopup.check3stStepLabelsCount(4);

    }

    @Step("Заполняем второй шаг(Странна Китай))")
    public void fill2stStepCN(){
        spin.waitSpinner();
        spin.waitJquery();
        paypopup.clickCountruCN();
        spin.waitJquery();
        paypopup.check3stStepLabelsCount(5);

    }


    @Step("Заполняем третий шаг(Юрисдикция Onshore))")
    public void fill3stStepOnshore(){
        spin.waitSpinner();
        spin.waitJquery();
        paypopup.clickresidencyOnshore();

    }

    @Step("Заполняем третий шаг(Юрисдикция Onshore))")
    public void fill3stStepOFFshore(){
        spin.waitSpinner();
        spin.waitJquery();
        paypopup.clickresidencyOffshore();

    }

    @Step("Заполняем третий шаг(Тип контрагента Физ-лицо))")
    public void fill3stStepFIz(){
        spin.waitJquery();
        paypopup.clickPersonFiz();
    }

    @Step("Проверка кол-ва типов оплаты на странице")
    public void check4stStepLabels(int num){
        spin.waitJquery();
        paypopup.check4stStepLabelsCount(num);
    }


    @Step("Заполняем третий шаг(Тип контрагента Индивидуальный предприниматель))")
    public void fill3stStepIP(){
        spin.waitJquery();
        paypopup.clickPersonIP();

    }

    @Step("Заполняем третий шаг(Тип контрагента Юридическое лицо))")
    public void fill3stStepUL(){
        spin.waitJquery();
        paypopup.clickPersonUL();

    }

    @Step("Заполняем четвертый шаг(Paypall))")
    public void fill4stStepPaypall(){
        spin.waitJquery();
        spin.waitSpinner();
        paypopup.clickPaypall();

    }

    @Step("Заполняем четвертый шаг(WMR))")
    public void fill4stStepWMR(){
        spin.waitJquery();
        spin.waitSpinner();
        paypopup.clickWmr();

    }

    @Step("Заполняем четвертый шаг(WMZ))")
    public void fill4stStepWMZ(){
        spin.waitJquery();
        spin.waitSpinner();
        paypopup.clickWmz();

    }

    @Step("Заполняем четвертый шаг(VK))")
    public void fill4stStepVK(){
        spin.waitJquery();
        spin.waitSpinner();
        paypopup.clickVK();

    }

    @Step("Заполняем четвертый шаг(Target Mail))")
    public void fill4stStepMail(){
        spin.waitJquery();
        spin.waitSpinner();
        paypopup.clickMail();

    }

    @Step("Заполняем четвертый шаг(Bank))")
    public void fill4stStepBank(){
        spin.waitJquery();
        spin.waitSpinner();
        paypopup.clickBank();

    }


    @Step("Заполняем пятый шаг(RUB))")
    public void fill5stStepRUB(int num){
        spin.waitSpinner();
        spin.waitJquery();
        clickCurrencyList(num);
        chooseCurrency(1);
        spin.waitJquery();

    }

    @Step("Заполняем пятый шаг(USD))")
    public void fill5stStepUSD(int num){
        spin.waitSpinner();
        spin.waitJquery();
        clickCurrencyList(num);
        chooseCurrency(2);
        spin.waitJquery();

    }

    @Step("Заполняем пятый шаг(BRL))")
    public void fill5stStepBRL(int num){
        spin.waitSpinner();
        spin.waitJquery();
        clickCurrencyList(num);
        chooseCurrency(7);
        spin.waitJquery();

    }

    @Step("Заполняем пятый шаг(CN))")
    public void fill5stStepCN(int num){
        spin.waitSpinner();
        spin.waitJquery();
        clickCurrencyList(num);
        chooseCurrency(6);
        spin.waitJquery();

    }

    @Step("Заполняем шестой и седьмой шаг )")
    public void fill6and7stStep(){
        spin.waitSpinner();
        spin.waitJquery();
        String num = DataGenerator.getRandomIntNumber();
        String contacts = DataGenerator.getRandomString();
        paypopup.fillWalletNumber(num);
        paypopup.fillContacts(contacts);
    }

    @Step("Заполняем шестой и седьмой шаг )")
    public void fill6and7stStepWMRZ(){
        spin.waitSpinner();
        spin.waitJquery();
        String num = DataGenerator.getRandomIntNumberWMR();
        String contacts = DataGenerator.getRandomString();
        paypopup.fillWalletNumber(num);
        paypopup.fillContacts(contacts);
    }


    @Step("Заполняем шестой  шаг )")
         public void fill6Step(){
        spin.waitSpinner();
        spin.waitJquery();
        String num = DataGenerator.getRandomIntNumber();
        paypopup.fillWalletNumberSocnet(num);

    }

    @Step("Заполняем шестой  шаг )")
    public void fill6Step(String mail){
        spin.waitSpinner();
        spin.waitJquery();
        mail = DataGenerator.getRandomString() + "@mail.ru";
        paypopup.fillWalletNumberSocnet(mail);

    }

    @Step("Заполняем шестой и седьмой шаг)")
    public void fill6and7stStepBank(){
        spin.waitSpinner();
        spin.waitJquery();
        String inn = DataGenerator.getRandomIntNumber();
        String bik = DataGenerator.getRandomIntNumber();
        String name = DataGenerator.getRandomString();
        String office = DataGenerator.getRandomIntNumber();
        String adres = DataGenerator.getRandomIntNumber();
        String corresp = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();

        paypopup.fillWalletNumberBank(inn,bik,name,office,adres,corresp,cc);
        paypopup.fillContacts(nameclient,adresclient);
    }

    @Step("Заполняем шестой и седьмой шаг)")
    public void fill6and7stStepBankUL(){

        spin.waitSpinner();
        spin.waitJquery();
        String ogrn = DataGenerator.getRandomIntNumber();
        String inn = DataGenerator.getRandomIntNumber();
        String bik = DataGenerator.getRandomIntNumber();
        String name = DataGenerator.getRandomString();
        String office = DataGenerator.getRandomIntNumber();
        String adres = DataGenerator.getRandomIntNumber();
        String corresp = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();
        paypopup.fillWalletNumberBank(inn,bik,name,office,adres,corresp,cc,ogrn);
        paypopup.fillContactsUR(nameclient, adresclient);
    }




    @Step("Заполняем шестой и седьмой шаг)")
    public void fill6and7stStepBankIP(){
        spin.waitSpinner();
        spin.waitJquery();
        String ogrnip = DataGenerator.getRandomIntNumber();
        String inn = DataGenerator.getRandomIntNumber();
        String bik = DataGenerator.getRandomIntNumber();
        String name = DataGenerator.getRandomString();
        String office = DataGenerator.getRandomIntNumber();
        String adres = DataGenerator.getRandomIntNumber();
        String corresp = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();

        paypopup.fillWalletNumberBank(inn,bik,name,office,adres,corresp,cc,ogrnip);
        paypopup.fillContacts(nameclient, adresclient);
    }

    @Step("Заполняем шестой и седьмой шаг)")
    public void fill6and7stStepBankoffshore(){
        spin.waitSpinner();
        spin.waitJquery();

        String name = DataGenerator.getRandomString();
        String office = DataGenerator.getRandomIntNumber();
        String adres = DataGenerator.getRandomIntNumber();
        String corresp = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String swift = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();

        paypopup.fillWalletNumberBank(name,office,adres,corresp,cc,swift);
        paypopup.fillContacts(nameclient,adresclient);
    }

    @Step("Заполняем шестой и седьмой шаг c автокомплитом)")
    public void fill6and7stStepBankautocomplit(){
        spin.waitSpinner();
        spin.waitJquery();


        String office = DataGenerator.getRandomIntNumber();
        String cprf = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();

        paypopup.fillWalletNumberBankautocomplit(office,cc,cprf);
        paypopup.fillContacts(nameclient,adresclient);
    }

    @Step("Заполняем шестой и седьмой шаг c автокомплитом) Китай")
    public void fill6and7stStepBankautocomplitCN(){
        spin.waitSpinner();
        spin.waitJquery();


        String bank_office = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();
        String personid = DataGenerator.getRandomIntNumber();
        String bank_adress_province = DataGenerator.getRandomIntNumber();
        String bank_adress_city = DataGenerator.getRandomIntNumber();
        String bank_adress_district = DataGenerator.getRandomIntNumber();
        String bank_adress_street = DataGenerator.getRandomIntNumber();
        String bank_adress_index = DataGenerator.getRandomIntNumber();


        paypopup.fillWalletNumberBankautocomplit(cc,bank_office,bank_adress_province,bank_adress_city,bank_adress_district,bank_adress_street,bank_adress_index);
        paypopup.fillContacts(nameclient,adresclient,personid);
        this.uploadFile();
    }

    @Step("Заполняем шестой и седьмой шаг c автокомплитом) Китай без аплоуда")
    public void fill6and7stStepBankautocomplitCNwithotUpload(){
        spin.waitSpinner();
        spin.waitJquery();


        String bank_office = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();
        String personid = DataGenerator.getRandomIntNumber();
        String bank_adress_province = DataGenerator.getRandomIntNumber();
        String bank_adress_city = DataGenerator.getRandomIntNumber();
        String bank_adress_district = DataGenerator.getRandomIntNumber();
        String bank_adress_street = DataGenerator.getRandomIntNumber();
        String bank_adress_index = DataGenerator.getRandomIntNumber();


        paypopup.fillWalletNumberBankautocomplit(cc,bank_office,bank_adress_province,bank_adress_city,bank_adress_district,bank_adress_street,bank_adress_index);
        paypopup.fillContacts(nameclient,adresclient,personid);

    }

    @Step("Заполняем шестой и седьмой шаг c автокомплитом) Китай без аплоуда с свифтом")
    public void fill6and7stStepBankautocomplitCNwithotUploadswift(){
        spin.waitSpinner();
        spin.waitJquery();


        String bank_office = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String swift = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();

        String bank_adress_province = DataGenerator.getRandomIntNumber();
        String bank_adress_city = DataGenerator.getRandomIntNumber();
        String bank_adress_district = DataGenerator.getRandomIntNumber();
        String bank_adress_street = DataGenerator.getRandomIntNumber();
        String bank_adress_index = DataGenerator.getRandomIntNumber();


        paypopup.fillWalletNumberBankautocomplit(cc,bank_office,bank_adress_province,bank_adress_city,bank_adress_district,bank_adress_street,bank_adress_index,swift);
        paypopup.fillContacts(nameclient,adresclient);

    }

    @Step("Заполняем шестой и седьмой шаг c автокомплитом)")
    public void fill6and7stStepBankautocomplitoffshore() {
        spin.waitSpinner();
        spin.waitJquery();


        String office = DataGenerator.getRandomIntNumber();
        String cprf = DataGenerator.getRandomIntNumber();
        String cc = DataGenerator.getRandomIntNumber();
        String nameclient = DataGenerator.getRandomString();
        String adresclient = DataGenerator.getRandomIntNumber();
        String text1 = DataGenerator.getRandomIntNumber();
        String text12 = DataGenerator.getRandomIntNumber();

        paypopup.fillWalletNumberBankautocomplit(office, cc, cprf, text1, text12);
        paypopup.fillContacts(nameclient, adresclient);
    }

    @Step("Проверяем кол-во импутов на странице")
    public void checkInputsPayments(int num){
        spin.waitSpinner();
        spin.waitJquery();
        paypopup.check6stStepInputsCount(num);
    }


    @Step("Загружаем тестовые картинки")
    public void uploadFile(){
        File file = new File("src/main/resources/test.png");
        driver.findElement(By.xpath("//input[@type='file'and @name='passport_scan2']")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.xpath("//input[@type='file'and @name='passport_scan']")).sendKeys(file.getAbsolutePath());
    }


    @Step("Заполняем шестой и седьмой шаг юридического лица)")
    public void fill6and7stStepUR(){
        spin.waitSpinner();
        spin.waitJquery();
        String num = DataGenerator.getRandomIntNumber();
        String contacts = DataGenerator.getRandomString();
        paypopup.fillWalletNumber(num);
        paypopup.fillContactsUR(contacts);
    }

    @Step("Сохраняем форму создания счета")
    public void savePaymentsInfo(){
        spin.waitSpinner();
        paypopup.submitForm();
        spin.waitSpinner();
    }

    @Step("Заполняем форму верификации")
    public void fillverificationform(){
        spin.waitSpinner();
        verification.getsms();
        spin.waitSpinner();
        spin.waitJquery();
        verification.fillVerificationForm();
        spin.waitSpinner();
    }
    @Step("Удаляем всю платежную информацию")
    public void deleteAllPaymentsInfo(){
        spin.waitSpinner();
        spin.waitJquery();
        int count = 0;
        while(true) {
            if (!blue_table_data_check()) {
                spin.evaluateJavascript("$('._remove_btn').each(function () { $(this).click(); })");
                spin.waitJquery();
                spin.evaluateJavascript("$('._confirm_yes').each(function () { $(this).click(); })");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                spin.waitSpinner();
                spin.waitJquery();
                count ++;
                if(count>50){
                    break;
                }
            }
            else {
                check_blue_table_has_no_data();
                break;
            }
        }

    }

    @Step
    public boolean blue_table_data_check(){
        return (((driver.findElement(By.tagName("tbody")).getText().contains("Нет данных"))
                ||(driver.findElement(By.tagName("tbody")).getText().contains("Элементы не найдены"))));
    }

    @Step
    public void check_blue_table_has_no_data(){
        Assert.assertTrue((driver.findElement(By.tagName("tbody")).getText().contains("Нет данных"))
                || (driver.findElement(By.tagName("tbody")).getText().contains("Элементы не найдены")));
    }


}
