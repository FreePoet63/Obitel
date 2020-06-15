import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    private WebDriver driver;

    public OrderPage (WebDriver driver) {
        this.driver = driver;
    }
     private By fieldName = By.xpath("//*[@id=\"wpforms-2357-field_0\"]");
     private By fieldMiddle = By.xpath("//*[@id=\"wpforms-2357-field_0-middle\"]");
     private By fieldLast = By.xpath("//*[@id=\"wpforms-2357-field_0-last\"]");
     private By fieldCountry = By.xpath("//*[@id=\"wpforms-2357-field_3\"]");
     private By fieldMail = By.xpath("//*[@id=\"wpforms-2357-field_1\"]");
     private By fieldPhone = By.xpath("//*[@id=\"wpforms-2357-field_4\"]");
     private By fieldMans = By.xpath("//*[@id=\"wpforms-2357-field_2\"]");
     private By clickField = By.xpath("//*[@id=\"wpforms-2357-field_6_5\"]");
     private By fieldData = By.xpath("//*[@id=\"wpforms-2357-field_5\"]");
     private By fieldTextClick = By.xpath("//*[@id=\"text-3\"]/div/a");
     private By fieldButton = By.xpath("//*[@id=\"wpforms-submit-2357\"]");
     private By errorName = By.xpath("//*[@id=\"wpforms-2357-field_0-error\"]");
     private By errorLast = By.xpath("//*[@id=\"wpforms-2357-field_0-last-error\"]");
     private By ErrorMail = By.xpath("//*[@id=\"wpforms-2357-field_1-error\"]");
     private By ErrorPhone = By.xpath("//*[@id=\"wpforms-2357-field_4-error\"]");
     private By ErrorMans = By.xpath("//*[@id=\"wpforms-2357-field_2-error\"]");
     private By errorMailText = By.xpath("//*[@id=\"wpforms-2357-field_1-error\"]");
     private By headerOrder = By.xpath("/html/body/div[1]/div/div[1]/a/img");
     private By HeaderCustomer = By.xpath("/html/body/div[2]/div/section/article/header/h1");


     public OrderPage Name1(String name) {
         driver.findElement(fieldName).sendKeys(name);
         return this;
     }
     public OrderPage Middle(String middle) {
         driver.findElement(fieldMiddle).sendKeys(middle);
         return this;
     }
     public OrderPage Last(String last) {
         driver.findElement(fieldLast).sendKeys(last);
         return this;
     }
     public OrderPage Country(String country) {
         driver.findElement(fieldCountry).sendKeys(country);
         return this;
     }
     public OrderPage Mail(String mail) {
         driver.findElement(fieldMail).sendKeys(mail);
         return this;
     }
     public OrderPage Phone(String phone) {
         driver.findElement(fieldPhone).sendKeys(phone);
         return this;
     }
     public  OrderPage Mans(String mans) {
         driver.findElement(fieldMans).sendKeys(mans);
         return this;
     }
     public void Click1() {
         driver.findElement(clickField).click();
     }
     public OrderPage Data(String data) {
         driver.findElement(fieldData).sendKeys(data);
         return this;
     }
     public void TextClick() {
         driver.findElement(fieldTextClick).click();
     }
     public String nameError() {
         return driver.findElement(errorName).getText();
     }
     public String lastError() {
         return driver.findElement(errorLast).getText();
     }
     public String mailError() {
         return driver.findElement(ErrorMail).getText();
     }
     public String phoneError() {
         return driver.findElement(ErrorPhone).getText();
     }
     public String mansError() {
         return driver.findElement(ErrorMans).getText();
     }
     public OrderPage Button1() {
         driver.findElement(fieldButton).click();
         return this;
     }
     public String MailTextErrow() {
         return driver.findElement(errorMailText).getText();
     }
     public String orderHeader() {
         return driver.findElement(HeaderCustomer).getText();
     }
     public void clickHeader() {
         driver.findElement(headerOrder).click();
     }
     public OrderPage headerOrder() {
         driver.get("http://palomniki-obitel.ru/bronirovanie-nomerov/");
         return this;
     }

}
