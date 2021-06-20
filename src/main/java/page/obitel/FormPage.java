package page.obitel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FormPage {
    private WebDriver driver;

    public FormPage(WebDriver driver) {
        this.driver = driver;
    }
    private By setFormPage = By.xpath("//a[contains(text(), \"Обратная связь\")]");
    private By setProEmail = By.id("inputEmail");
    private By setQueston = By.id("f_question");
    private By setAuthor = By.id("f_author");
    private By setEmailLink = By.xpath("//label[contains(text(), \"E-mail\")]");
    private By setErrortext = By.xpath("//div[@style = \"color: red\"]");
    private By setButton = By.xpath("//input[@value = \"отправить\"]");

    public FormPage openForm() {
        driver.findElement(setFormPage).click();
        return this;
    }

    public FormPage email(String email) {
        driver.findElement(setProEmail).sendKeys(email);
        return this;
    }

    public FormPage firstQueston(String queston) {
        driver.findElement(setQueston).sendKeys(queston);
        return this;
    }

    public FormPage firstAuthor(String author) {
        driver.findElement(setAuthor).sendKeys(author);
        return this;
    }

    public  FormPage emailQuestonsAuthor(String email, String queston, String author) {
        this.email(email);
        this.firstQueston(queston);
        this.firstAuthor(author);
        return this;
    }

    public FormPage clickButton() {
        driver.findElement(setButton).click();
        return this;
    }

    public String newEmail() {
       return driver.findElement(setEmailLink).getText();
    }

    public String erroland() {
        return driver.findElement(setErrortext).getText();
    }
}
