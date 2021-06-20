package page.obitel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    public OrderPage (WebDriver driver) {
        this.driver = driver;
    }
     private By fieldName = By.id("wpforms-2357-field_0");
     private By fieldMiddle = By.id("wpforms-2357-field_0-middle");
     private By fieldLast = By.id("wpforms-2357-field_0-last");
     private By fieldCountry = By.id("wpforms-2357-field_3");
     private By fieldMail = By.id("wpforms-2357-field_1");
     private By fieldPhone = By.id("wpforms-2357-field_4");
     private By fieldMans = By.id("wpforms-2357-field_2");
     private By clickField = By.id("wpforms-2357-field_6_5");
     private By fieldData = By.id("wpforms-2357-field_5");
     private By fieldTextClick = By.id("text-3");
     private By fieldButton = By.id("wpforms-submit-2357");
     private By errorName = By.id("wpforms-2357-field_0-error");
     private By errorLast = By.id("wpforms-2357-field_0-last-error");
     private By errorMail = By.id("wpforms-2357-field_1-error");
     private By errorPhone = By.id("wpforms-2357-field_4-error");
     private By errorMans = By.id("wpforms-2357-field_2-error");
     private By errorMailText = By.id("wpforms-2357-field_1-error");
     private By headerOrder = By.xpath("//img[@class=\"custom-logo\"]");
     private By headerCustomer = By.xpath("//h1[contains(text(), \"Бронирование номеров\")]");

     public OrderPage getName(String name) {
         driver.findElement(fieldName).sendKeys(name);
         return this;
     }

     public OrderPage getMiddle(String middle) {
         driver.findElement(fieldMiddle).sendKeys(middle);
         return this;
     }

     public OrderPage getLast(String last) {
         driver.findElement(fieldLast).sendKeys(last);
         return this;
     }

     public OrderPage getCountry(String country) {
         driver.findElement(fieldCountry).sendKeys(country);
         return this;
     }

     public OrderPage getMail(String mail) {
         driver.findElement(fieldMail).sendKeys(mail);
         return this;
     }

     public OrderPage getPhone(String phone) {
         driver.findElement(fieldPhone).sendKeys(phone);
         return this;
     }

     public OrderPage getMans(String mans) {
         driver.findElement(fieldMans).sendKeys(mans);
         return this;
     }

     public void getClick1() {
         driver.findElement(clickField).click();
     }

     public OrderPage getData(String data) {
         driver.findElement(fieldData).sendKeys(data);
         return this;
     }

     public void textClick() {
         driver.findElement(fieldTextClick).click();
     }

     public String nameError() {
         return driver.findElement(errorName).getText();
     }

     public String lastError() {
         return driver.findElement(errorLast).getText();
     }

     public String mailError() {
         return driver.findElement(errorMail).getText();
     }

     public String phoneError() {
         return driver.findElement(errorPhone).getText();
     }

     public String mansError() {
         return driver.findElement(errorMans).getText();
     }

     public OrderPage getButton1() {
         driver.findElement(fieldButton).click();
         return this;
     }

     public String mailTextErrow() {
         return driver.findElement(errorMailText).getText();
     }

     public String orderHeader() {
         return driver.findElement(headerCustomer).getText();
     }

     public void clickHeader() {
         driver.findElement(headerOrder).click();
     }

     public OrderPage headerOrder() {
         driver.get("http://palomniki-obitel.ru/bronirovanie-nomerov/");
         return this;
     }
}
