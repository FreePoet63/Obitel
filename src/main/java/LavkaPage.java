import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LavkaPage {

    private static WebDriver driver;

    public LavkaPage(WebDriver driver) {
        this.driver = driver;
    }
    private By setShop = By.xpath("//nav//li//span[normalize-space(.)='Утварь']/..");
    private By setObject = By.xpath("//*[@id=\"narrow-by-list\"]/div[1]/div[2]/ol/li[9]/a");
    private By setCustomer = By.xpath("//*[@id=\"maincontent\"]/div[4]/div[1]/div[3]/ol/li[4]");
    private By setFieldnumber = By.xpath("//*[@id=\"qty\"]");
    private By setButtoncustom = By.xpath("//*[contains(text(), \"Выбрать\")]");
    private By setWindowfield = By.xpath("//a[@class=\"action showcart\"]");
    private By setDeleteCustom = By.xpath("//a[@class=\"action delete\"]");
    private By setAllert = By.xpath("//button[@class=\"action-primary action-accept\"]");
    private By setCustometfirst = By.xpath("/html/body/div[2]/header/div[2]/div[1]/a/span[2]/span[1]");
    private By setFieldmoney = By.xpath("//*[@id=\"minicart-content-wrapper\"]/div[2]/div[2]/div/span/span");
    private By setnumber = By.xpath("//*[@id=\"cart-item-8729-qty\"]");



    public void fieldUtvar() {
        driver.findElement(setShop).click();
    }

    public void fieldChetki() {
        driver.findElement(setObject).click();
    }

    public LavkaPage fieldTovar() {
        driver.findElement(setCustomer).click();
        return this;
    }

    public String numberCustom() {
        return driver.findElement(setCustometfirst).getText();
    }

    public void fieldNumber() {
        driver.findElement(setFieldnumber).clear();
    }

    public LavkaPage fielfSetNumber(String number) {
        driver.findElement(setFieldnumber).sendKeys(number);
        return this;
    }

    public LavkaPage buttonCustomer() {
        System.out.println(driver.findElement(setFieldnumber).getText());
        driver.findElement(setButtoncustom).click();
        return this;
    }

    public LavkaPage fieldWindow() {
        driver.findElement(setWindowfield).click();
        return this;
    }

    public void fieldDelete() {
        driver.findElement(setDeleteCustom).click();
    }

    public void fieldAlert() {
        driver.findElement(setAllert).click();
    }

    public String money() {
        return driver.findElement(setFieldmoney).getText();
    }

    public void summaAuto() {
        driver.findElement(setnumber).clear();
    }

    public void autoSumma(String summa) {
        driver.findElement(setnumber).sendKeys(summa);
    }


    public static void formatOption(String name) {
        System.out.println(driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name))).getText());
        driver.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", name))).click();

    }
}