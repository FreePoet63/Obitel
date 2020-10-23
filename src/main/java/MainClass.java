import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;



public class MainClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        FormPage formPage = PageFactory.initElements(driver, FormPage.class);
        OrderPage orderPage = PageFactory.initElements(driver, OrderPage.class);
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        LavkaPage lavkaPage = PageFactory.initElements(driver, LavkaPage.class);
        HTML5Page html5Page = PageFactory.initElements(driver, HTML5Page.class);
        driver.get("https://obitel-minsk.ru/");
        String mainTab = driver.getWindowHandle();
        html5Page.openVideo();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
             e.printStackTrace();
        }
        html5Page.videoFrame();
        html5Page.videoPlayer();
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.xVolume();
        html5Page.dragSlay();
        html5Page.windowVideo();
        try {
           Thread.sleep(15000);
       } catch (InterruptedException e) {
           e.printStackTrace();
        }
        html5Page.videoPlayer();
        driver.navigate().back();
        html5Page.openAudio();
        try {
            Thread.sleep(25000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        html5Page.audioCross();
        html5Page.openAction();
        html5Page.volumePlay();
        html5Page.openAudio();
        driver.navigate().to("https://obitel-minsk.ru/");
        mainPage.obitelSearch();
        mainPage.typeword("Батюшка");
        mainPage.clickSearch();
        for (String tab : driver.getWindowHandles()) {
            driver.switchTo().window(tab);
        }
        mainPage.YouTube();
        driver.switchTo().window(mainTab);
        mainPage.OK();
        mainPage.checkboxes();
        driver.switchTo().window(mainTab);
        mainPage.Link1();
        mainPage.Link2();
        mainPage.Link3();
        driver.navigate().to("https://obitel-minsk.ru/");
        mainPage.pagesObitel();
        mainPage.paginatsya();
        formPage.openForm();
        formPage.EmailQuestonsAuthor("gatelia@mail.ru", "Мира, Счастья, Добра", "Юрий, Минск, Беларусь");
        driver.navigate().back();
        driver.get("http://palomniki-obitel.ru/bronirovanie-nomerov/");
        String mainTab1 = driver.getWindowHandle();
        orderPage.Name1("Иван");
        orderPage.Middle("Васильевич");
        orderPage.Last("Терехов");
        orderPage.Country("Испания, Мадрид");
        orderPage.Mail("gatelia@mail.ru");
        orderPage.Phone("2346161");
        orderPage.Mans("3");
        orderPage.Click1();
        orderPage.Data("18 июля");
        orderPage.TextClick();
        driver.get("https://lavka-obitel.ru/");
        String mainTab2 = driver.getWindowHandle();
        registerPage.registration();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registerPage.nameSet("Наташа");
        registerPage.lastNameSet("Терехова");
        registerPage.Clickos();
        registerPage.emailSet("Nata@mail.ru");
        registerPage.passwordSet("77777Gospod");
        registerPage.doublePasswordSet("77777Gospod");
        driver.navigate().back();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldUtvar();
        lavkaPage.fieldNewObject();
        lavkaPage.fieldTovar();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldNumber();
        lavkaPage.fielfSetNumber("2");
        lavkaPage.buttonCustomer();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldWindow();
        lavkaPage.fieldDelete();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lavkaPage.fieldAlert();
        driver.quit();

        }




}