import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HTML5Page {

    private WebDriver driver;

    public HTML5Page(WebDriver driver) {
        this.driver = driver;
    }
        private By setVideo = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div[3]/div[1]/div[1]/div/div/a/img");
        private By setPlay = By.xpath("//*[@id=\"player\"]");
        private By setAudio = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[1]");
        private By setAction = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[5]/div[1]/a");
        private By setPlayAudio = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[5]/div[2]/div/div");



        public void openVideo() {
            driver.findElement(setVideo).click();
        }
        public void videoFrame() {
            WebElement frramm = driver.findElement(By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[1]/iframe"));
            driver.switchTo().frame(frramm);
        }
        public HTML5Page videoPlayer() {
            driver.findElement(setPlay).click();
            return this;
        }
        public void openAudio() {
            driver.findElement(setAudio).click();
        }
        public void openAction() {
            WebElement volume = driver.findElement(setAction);
            Actions actions9 = new Actions(driver);
            actions9.moveToElement(volume).build().perform();
        }
        public void volumePlay() {
            driver.findElement(setPlayAudio).click();
        }







}
