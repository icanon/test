package setup;

import dataclass.FinanceSummary;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.Logs;
import org.openqa.selenium.remote.Augmenter;
import pages.wm.Spinners;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.core.IsNot.not;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;




public class Utils {

    public WebDriver driver;
    private Spinners spin;
    public Utils(WebDriver driver) {
        this.driver = driver;
        this.spin = new Spinners(driver);
    }



    @Attachment(value = "screenshot", type = "image/png")
    public byte[] takeScreenShoot() {
        try {
            WebDriver augmentedDriver = new Augmenter().augment(driver);
            File screenshot = ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.FILE);
            String nameScreenshot = getFileName(DataGenerator.getRandomNameWithDate());
            String path = getPath(nameScreenshot);
            File newScreen = new File(path);
            FileUtils.copyFile(screenshot, newScreen);
            Printer.println(String.valueOf(newScreen));

            BufferedImage bImage = ImageIO.read(screenshot);
            byte[] imageInByteArray;
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bImage, "png", baos);
            imageInByteArray = baos.toByteArray();
            baos.flush();

            return imageInByteArray;
        } catch (IOException ex) {
            Logger.getLogger(Utils.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public void close() {
        String curUrl = driver.getCurrentUrl();
        driver.quit();
    }

    @Step
    public void goToUrl(String url){
        Printer.println("GO TO URL "+url);
        driver.get(url);
    }


    @Step("переход на главную страницу приложения")
    @Attachment
    public String openMainPage(){
        String host = System.getProperty("baseUrl");
        driver.get(host);
        Printer.println("Go to "+host);
        driver.manage().window().maximize();
        return driver.getCurrentUrl();
    }

    @Step("переход на главную страницу вебмастера")
    public void openWMMainPage(){
        String host = System.getProperty("baseUrl");
        driver.get(host+"webmaster/office/dashboard");
        Printer.println("Go to "+host+"webmaster/office/dashboard");
        driver.manage().window().maximize();
        spin.waitSpinner();
    }


    @Step("переход на форму oauth")
    @Attachment
    public String openOauthForm(){
        String host = System.getProperty("oauth");
        driver.get(host);
        driver.manage().window().maximize();
        Printer.println("Go to "+host);
        driver.manage().window().maximize();
        return driver.getCurrentUrl();
    }

    @Step
    @Attachment
    public String printCurrentUrl(){
        Printer.println("CURRENT URL " + driver.getCurrentUrl());
        return driver.getCurrentUrl();
    }

    @Step
    @Attachment
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    private static String getFileName(String nameTest) {
        DateFormat dateFormat = new SimpleDateFormat("MM-dd-yyyy_hh.mm.ss");
        Date date = new Date();
        return dateFormat.format(date) + "_" + nameTest + ".png";
    }

    private static String getPath(String nameTest) throws IOException {
        File directory = new File(".");
        return directory.getCanonicalPath() + "/target/allure-results/" + getFileName(nameTest);
    }

    @Step("Проверяем логи консоли браузера")
    public void checkConsoleLog(){
        List<String> l = get_all_logs();
        check_array_has_errors(l);

    }

    @Step
    public List<String> get_all_logs(){
        List<String> l = new ArrayList<String>();
        Logs logs = driver.manage().logs();
        LogEntries logEntries = logs.get(LogType.BROWSER);
        for (LogEntry logEntry : logEntries) {
            Printer.println("Console output: "+logEntry.getMessage());
            l.add(logEntry.getMessage());
        }
        return l;
    }

    @Step
    public void check_array_has_errors(List<String> list){
        assertFalse(list.size() > 0,"Проверяем что в логах консоли нет сообщений уровня SEVERE " + list);
    }

    @Step("Сравниваем данные с финансовой сводной и из раздела Начисления")
    public void compareFinanceSummary(FinanceSummary summary1,FinanceSummary summary2){
        assertEquals(summary1,summary2);
    }

    @Step("Возращаемся на предыдущую страницу ")
    public void goBack() throws InterruptedException {
        Printer.println("Go back");
        driver.navigate().back();
        Thread.sleep(1500);
    }

    @Step
    public void checkStringContainsString(String str, String text){
        assertThat(str, containsString(text));
    }
    @Step
    public void checkStringNotContainsString(String str, String text){
        assertThat(str, not(containsString(text)));
    }

    @Step("Переходим в режим отладки по ссылке http://cityadspix.com/monitor/api/cnt-cookie-set?mode=xml")
    public void setDebugCookie() {
          driver.get("http://cityadspix.com/monitor/api/cnt-cookie-set?mode=xml");
    }

    @Step
    public void openUrl(String url) {
        driver.get(url);
    }


    @Step
    @Attachment
    public String getClickId(String txt){
        String re1="(\\d+)";	// Integer Number 1
        String re2="(-)";	// Any Single Character 1
        String re3="(\\d+)";	// Integer Number 2
        String re4="(-)";	// Any Single Character 2
        String re5="(\\d+)";	// Integer Number 3
        String re6="(-)";	// Any Single Character 3
        String re7="(\\d+)";	// Integer Number 4

        Pattern p = Pattern.compile(re1+re2+re3+re4+re5+re6+re7,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        if (m.find())
        {
            String int1=m.group(1);
            String c1=m.group(2);
            String int2=m.group(3);
            String c2=m.group(4);
            String int3=m.group(5);
            String c3=m.group(6);
            String int4=m.group(7);
            String clickId = (int1.toString()+c1.toString()+int2.toString()+c2.toString()+int3.toString()+c3.toString()+int4.toString());
            return clickId;
        }
        else return null;
    }

    @Step
    @Attachment
    public String getFinalUrl(String txt){

        String re1="((?:http|https)(?::\\/{2}[\\w]+)(?:[\\/|\\.]?)(?:[^\\s\"]*))";	// HTTP URL 1
        Pattern p = Pattern.compile(re1,Pattern.CASE_INSENSITIVE | Pattern.DOTALL);
        Matcher m = p.matcher(txt);
        String finalUrl = null;
        while (m.find())
        {
            String httpurl1 = m.group(1);
            finalUrl = (httpurl1.toString());
        }
        return finalUrl.split("<")[0];
    }

    @Step
    public String getDp(String url){
        return url.split("dp=")[1].split("_tp")[0];
    }

    @Step
    public void checkStringEquals(String clickId, String clickId2) {
        assertEquals(clickId, clickId2);
    }

    @Step
    public List<WebElement> getWebElementsWithJquery(String selector){

        JavascriptExecutor js = (JavascriptExecutor)driver;
        String get = "return $('"+selector+"').get()";
        Printer.println(get);
        List<WebElement> elements = (List<WebElement>)js.executeScript(get);
        return elements;

    }

    @Step
    public void goToAuthStandSection(String url) {
        String oauthStandUrl = System.getProperty("oauthCity");
        String testUrl = oauthStandUrl + url;
        String newtestUrl = testUrl.replaceAll("//","/");
        Printer.println("go to url " + newtestUrl);
        driver.get(newtestUrl);
        driver.manage().window().maximize();
    }

    @Step("переход на главную страницу")
    public void goToAuthStand() {
        String oauthStandUrl = System.getProperty("oauthCity");
        driver.get(oauthStandUrl);
    }

    @Step
    @Attachment
    public Cookie getCookieNamed(String name) {
        return driver.manage().getCookieNamed(name);
    }

    @Step
    public void deleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }

    @Step
    @Attachment
    public Set<Cookie> getAllCookies() {
        return driver.manage().getCookies();
    }

    @Step
    public void refreshPage() {
        driver.navigate().refresh();
    }

    @Step("удаление куки PHPSESSID c сервера авторизации")
    public void deletePhpAuthSession() {
        openOauthForm();
        getAllCookies();
        Cookie cookie = getCookieNamed("PHPSESSID");
        deleteCookie(cookie);
    }

    @Step
    public void runShellScript(String script) {
        try {
            Runtime rt = Runtime.getRuntime();
            BufferedReader input = null;
            Process pr = null;

            pr = rt.exec(script);
            input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line = null;

            while ((line = input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code " + exitVal);

        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }

    @Step
    public Set<String> get_window_handles(){
        Set<String> handleList = driver.getWindowHandles();
        return handleList;

    }

    @Step
    public String getLastWindowHandle(Set<String> set){
        String handle = driver.getWindowHandle();
        Iterator it = set.iterator();
        while(it.hasNext()){
            handle = it.next().toString();
        }
        return handle;
    }

    @Step
    public String getFirstWindowHandle(Set<String> set){
        String handle = driver.getWindowHandle();
        Iterator it = set.iterator();
        while(it.hasNext()){
            handle = it.next().toString();
            return handle;
        }
        return handle;

    }

    @Step("переключиться на окно открывшееся последним")
    public void switchToLastWindow(){
        Set<String> handleList = get_window_handles();
        String lastHandle = getLastWindowHandle(handleList);
        switchToLastWindow(lastHandle);
    }

    @Step("переключиться на окно открывшееся первым")
    public void switchToFirstWindows(){
        Set<String> handleList = get_window_handles();
        String firsthandle = getFirstWindowHandle(handleList);
        switchToFirstWindows(firsthandle);
    }

    private void switchToLastWindow(String handle){
        driver.switchTo().window(handle);
    }

    private void switchToFirstWindows(String handle){
        driver.switchTo().window(handle);
    }

    @Step
    @Attachment
    public  String getCurrentDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Date date = new Date();
        return dateFormat.format(date);

    }


}


