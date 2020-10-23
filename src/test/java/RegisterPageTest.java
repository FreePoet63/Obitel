import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class RegisterPageTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://lavka-obitel.ru/");
        String mainTab2 = driver.getWindowHandle();
        registerPage = new RegisterPage(driver);
    }
    @Test
    public void autorisation() {
        registerPage.registration();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registerPage.nameSet("Наташа");
        registerPage.lastNameSet("Терехова");
        registerPage.Clickos();
        registerPage.emailSet("Nata@mail.ru");
        registerPage.passwordSet("77777gospod");
        registerPage.doublePasswordSet("77777gospod");
    }
    @Test
    public void errorRegistred() {
        registerPage.registration();
        try {
            Thread.sleep(15000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        registerPage.lastNameSet("");
        registerPage.emailSet("....");
        registerPage.passwordSet("4444");
        registerPage.doublePasswordSet("65789");
        registerPage.buttonSet();
        RegisterPage vera = registerPage.buttonSet();
        String Error = vera.errorLastNameSet();
        Assert.assertEquals("Это поле обязательно для заполнения.", Error);
        String Error1 = vera.errorMailSet();
        Assert.assertEquals("Пожалуйста, введите правильный адрес электронной почты (Пример: johndoe@domain.com).", Error1);
        String Error2 = vera.errorPassSet();
        Assert.assertEquals("Минимальная длина этого поля должна быть равна или больше 8 символов. Пробелы перед и после символов будут проигнорированы.", Error2);
        String Error3 = vera.errorDoublPassSet();
        Assert.assertEquals("Please enter the same value again.", Error3);
    }
    @After
    public void tearDown() {
        driver.quit();
    }


}
