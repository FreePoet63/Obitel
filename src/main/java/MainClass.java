import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import page.obitel.*;


public class MainClass {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        MainPage mainPage = PageFactory.initElements(driver, MainPage.class);
        FormPage formPage = PageFactory.initElements(driver, FormPage.class);
        OrderPage orderPage = PageFactory.initElements(driver, OrderPage.class);
        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        LavkaPage lavkaPage = PageFactory.initElements(driver, LavkaPage.class);
        HTML5Page html5Page = PageFactory.initElements(driver, HTML5Page.class);
        driver.get("https://obitel-minsk.ru/");
    }
}