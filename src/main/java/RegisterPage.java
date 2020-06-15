import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
     private By registredAuto = By.xpath("//*[contains(text(), \"Создать учётную запись\")]");
     private By setName = By.xpath("//*[@id=\"firstname\"]");
     private By setLast = By.xpath("//*[@id=\"lastname\"]");
     private By setClick = By.xpath("//*[@id=\"is_subscribed\"]");
     private By setEmail = By.xpath("//*[@id=\"email_address\"]");
     private By setPassword = By.xpath("//*[@id=\"password\"]");
     private By setDoublPassword = By.xpath("//*[@id=\"password-confirmation\"]");
     private By setErrorLastName = By.xpath("//*[@id=\"lastname-error\"]");
     private By setErrorMail = By.xpath("//*[@id=\"email_address-error\"]");
     private By setErrorPass = By.xpath("//*[@id=\"password-error\"]");
     private By setErrorDoublPass = By.xpath("//*[@id=\"password-confirmation-error\"]");
     private By clickFlag = By.xpath("/html/body/div[2]/div[3]/div[1]/div/div/span/div[1]");
     private By setButton = By.xpath("/html/body/div[1]/main/div[3]/div/form/div/div[1]/button/span");
     private By frameFrame = By.xpath("/html/body/div[1]/main/div[3]/div/form/fieldset[2]/div[4]/div/div[1]/div/div/iframe");


     public void registration() {
        driver.findElement(registredAuto).click();
    }
    public RegisterPage nameSet(String name) {
         driver.findElement(setName).sendKeys(name);
         return this;
    }
    public RegisterPage lastNameSet(String lastname) {
         driver.findElement(setLast).sendKeys(lastname);
         return this;
    }
    public void Clickos() {
         driver.findElement(setClick).click();
    }
    public RegisterPage emailSet(String email) {
         driver.findElement(setEmail).sendKeys(email);
         return this;
    }
    public RegisterPage passwordSet(String password) {
         driver.findElement(setPassword).sendKeys(password);
         return this;
    }
    public RegisterPage doublePasswordSet(String doublpassword) {
         driver.findElement(setDoublPassword).sendKeys(doublpassword);
         return this;
    }
    public String errorLastNameSet() {
         return driver.findElement(setErrorLastName).getText();
    }
    public String errorMailSet() {
         return driver.findElement(setErrorMail).getText();
    }
    public String errorPassSet() {
         return driver.findElement(setErrorPass).getText();
    }
    public String errorDoublPassSet() {
         return driver.findElement(setErrorDoublPass).getText();
    }
    public void flagClick() {
        WebElement frames = driver.findElement(frameFrame);
        driver.switchTo().frame(frames);
         driver.findElement(clickFlag).click();
    }
    public RegisterPage buttonSet() {
         driver.findElement(setButton).click();
        return this;
    }

}
