package page.obitel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static page.dafault.MethodsToDefault.waitTimeoutFluent;
import static page.dafault.MethodsToDefault.waitToVisibility;

public class RegisterPage {
    private WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }
     private By registredAuto = By.xpath("//*[contains(text(), \"Создать учётную запись\")]");
     private By setName = By.id("firstname");
     private By setLast = By.id("lastname");
     private By setClick = By.id("is_subscribed");
     private By setEmail = By.id("email_address");
     private By setPassword = By.id("password");
     private By setDoublPassword = By.id("password-confirmation");
     private By setErrorLastName = By.id("lastname-error");
     private By setErrorMail = By.id("email_address-error");
     private By setErrorPass = By.id("password-error");
     private By setErrorDoublPass = By.id("password-confirmation-error");
     private By setButton = By.xpath("//button[starts-with(@title, \"Создать\")]");

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

     public void clickMethod() {
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
         WebElement errorLastName =  driver.findElement(setErrorLastName);
         waitToVisibility(driver, 7, errorLastName);
         return errorLastName.getText();
     }

     public String errorMailSet() {
         return driver.findElement(setErrorMail).getText();
     }

     public String errorPassSet() {
         return driver.findElement(setErrorPass).getText();
     }

     public String errorDoublPassSet() {
         WebElement elem = driver.findElement(setErrorDoublPass);
         waitToVisibility(driver, 5, elem);
         return elem.getText();
     }

     public RegisterPage waitButton() {
        waitTimeoutFluent(driver, 15, 9, setButton);
        WebElement ol = driver.findElement(setButton);
        ol.click();
        return this;
     }
}
