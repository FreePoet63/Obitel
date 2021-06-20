import org.junit.Test;
import page.basepage.DriverObitelPageSettings;

public class MainPageTest extends DriverObitelPageSettings {

    @Test
    public void obitelSearch() throws InterruptedException {
        mainPage.obitelSearch();
        mainPage.seeMenuOK();
        Thread.sleep(3000);
    }

    @Test
    public void obitel() {
        mainPage.pageLink1();
        mainPage.pageLink2();
        mainPage.pageLink3();
    }

    @Test
    public void pages() {
        mainPage.pagesObitel();
    }
}
