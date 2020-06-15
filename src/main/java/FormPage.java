import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }

    private By ProEmail = By.xpath("//*[@id=\"inputEmail\"]");
    private By Queston = By.xpath("//*[@id=\"f_question\"]");
    private By Author = By.xpath("//*[@id=\"f_author\"]");
    private By EmailLink = By.xpath("//div[@class=\"form-group\"]//label[contains(text(), \"E-mail\")]");
    private By Errortext = By.xpath("/html/body/div[3]/div[3]/div/div/div/div/div[2]/form/div[1]/div[4]");
    private By Button = By.xpath("//div[@class=\"input-group\"]//span");


    public FormPage openForm() {
        driver.findElement(By.xpath("/html/body/div[3]/footer/div/div[2]/div[2]/ul/li[3]/a")).click();
        return this;
    }
    public FormPage Email(String email) {
        driver.findElement(ProEmail).sendKeys(email);
        return this;
    }
    public FormPage Firstqueston(String queston) {
        driver.findElement(Queston).sendKeys(queston);
        return this;
    }
    public FormPage Firstauthor(String author) {
        driver.findElement(Author).sendKeys(author);
        return this;
    }
    public  FormPage EmailQuestonsAuthor(String email, String queston, String author) {
        this.Email(email);
        this.Firstqueston(queston);
        this.Firstauthor(author);
        return this;
    }
    public FormPage clickButton() {
        driver.findElement(Button).click();
        return this;
    }
    public String NewEmail() {
       return driver.findElement(EmailLink).getText();

    }
    public String erroland() {
        return driver.findElement(Errortext).getText();
    }




}
