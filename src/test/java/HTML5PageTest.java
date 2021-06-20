import org.junit.Assert;
import org.junit.Test;
import page.basepage.DriverObitelPageSettings;

import static page.settings.TestConfig.LINKCOUNT_HTMLPAGE;

public class HTML5PageTest extends DriverObitelPageSettings {

    @Test
    public void links() {
        html5Page.openVideo();
        html5Page.openLinks();
            Assert.assertTrue(LINKCOUNT_HTMLPAGE > 200);
    }

    @Test
    public void findAllBrokenLinks() {
        html5Page.openVideo();
        html5Page.searchBrokenLinks();
    }

    @Test
    public void videoPlay() throws InterruptedException {
        html5Page.openVideo();
        html5Page.clickVideo();
        html5Page.videoFrame();
        html5Page.videoPlayer();
        Thread.sleep(20000);
        html5Page.videoPlayer();
    }
}
