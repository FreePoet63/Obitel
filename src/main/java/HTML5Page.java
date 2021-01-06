import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HTML5Page {

    private WebDriver driver;

    public HTML5Page(WebDriver driver) {
        this.driver = driver;
    }
        private By setVideo = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[1]/div[5]/div[2]/div/a/img");
        private By setPlay = By.xpath("//*[@id=\"player\"]");
        private By setAudio = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[1]");
        private By setAction = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[5]/div[1]/a");
        private By setPlayAudio = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[5]/div[2]/div/div");
        private By setLinks = By.xpath("/html/body/div[3]/div[4]/div/a/img");
        private By setCross = By.xpath("/html/body/div[3]/div[3]/div/div[2]/div[2]/div/div/div[1]/div[3]/div/div/div[3]/div[2]/span");
        private By setX = By.xpath("/html/body/div[1]/div/div[23]/div[2]/div[1]/span/button");
        private By setY = By.xpath("/html/body/div[1]/div/div[23]/div[2]/div[1]/span/div/div/div");
        private By setWindowVideo = By.xpath("/html/body/div[1]/div/div[23]/div[2]/div[2]/button[7]");
        private By setFrame = By.xpath("/html/body/div[3]/div[3]/div/div[1]/div[1]/iframe");


        public void openVideo() {
            driver.findElement(setVideo).click();
        }
        public void videoFrame() {
            WebElement frramm = driver.findElement(setFrame);
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
            Actions actions777 = new Actions(driver);
            WebElement voise = driver.findElement(setPlayAudio);
            actions777.moveToElement(voise).build().perform();
            voise.click();
            voise.click();
        }
        public void fieldLinks() {
            driver.findElement(setLinks).click();
        }
        public void audioCross() {
            Actions actionsAudio = new Actions(driver);
            WebElement cross = driver.findElement(setCross);
            actionsAudio.dragAndDropBy(cross,80, 0).perform();

        }
        public void xVolume() {
            Actions eleActions = new Actions(driver);
            WebElement elemm = driver.findElement(setX);
            eleActions.moveToElement(elemm).build().perform();

        }
        public void dragSlay() {
            Actions actyVolume = new Actions(driver);
            WebElement acVolume = driver.findElement(setY);
            actyVolume.dragAndDropBy(acVolume,  -15, 0).perform();

        }
        public void windowVideo() {
            driver.findElement(setWindowVideo).click();
        }







}
