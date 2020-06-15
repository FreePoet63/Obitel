import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FormPageTest {
    private WebDriver driver;
    private FormPage formPage;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://obitel-minsk.ru/");
        formPage = new FormPage(driver);
    }
    @Test
    public void startForm() {
        formPage.openForm();
        formPage.EmailQuestonsAuthor("gatelia@mail.ru","Мира, Счастья, Добра","Юрий, Минск, Беларусь");
    }
    @Test
    public void text() {
        FormPage xp = formPage.openForm();
        String Mail  = xp.NewEmail();
        Assert.assertEquals("E-mail", Mail);
    }
    @Test
    public void error() {
        formPage.openForm();
        formPage.EmailQuestonsAuthor("gatelia@mail.ru", "..", "..");
        FormPage aut = formPage.clickButton();
        String Error = aut.erroland();
        Assert.assertEquals("Пожалуйста, заполните все поля правильно:\n" +
                "Это поле должно быть не меньше 5 символов.", Error);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

}
