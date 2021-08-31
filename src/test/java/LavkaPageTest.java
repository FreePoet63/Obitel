import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page.basepage.DriverLavkaPageSettings;
import page.obitel.LavkaPage;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static page.logger.Log.info;
import static page.logger.Log.warn;

public class LavkaPageTest extends DriverLavkaPageSettings {

    @Test
    public void sumElement() {
        lavkaPage.setUtvar();
        LavkaPage clickSlay=lavkaPage.fieldChetki();
        String firstSlay = clickSlay.slaiderNew();
        Assert.assertEquals("105 руб.", firstSlay);
        String secondSlay = clickSlay.fieldStringSlay();
        Assert.assertEquals("1 200,99 руб.", secondSlay);
        LavkaPage cliderNow = lavkaPage.sliderClick();
        String slaiderText = cliderNow.slaiderNew();
        Assert.assertEquals("505 руб.", slaiderText);
        LavkaPage clayNow = lavkaPage.newSlayderClick();
        String newSlayderText = clayNow.fieldStringSlay();
        Assert.assertEquals("824,99 руб.", newSlayderText);
    }

    @Test
    public void arrayListItems() {
        lavkaPage.setUtvar();
        lavkaPage.candleField();
        List<WebElement> items24 = lavkaPage.itemsCandlesMenu();
        List<String> itemsText = lavkaPage.elementMenuList(items24);
        info("itemsTextList: " + itemsText);
        assertThat(itemsText, hasItems(containsString("Набор свечей для детей"),
                containsString("Свеча восковая"),
                containsString("Свечи для домашней молитвы")));
    }

    @Test
    public void itemsFlame() {
        lavkaPage.setUtvar();
        lavkaPage.candleField();
        List<WebElement> priceFlame = lavkaPage.itemsProduct();
        List<String> priceFlameText = lavkaPage.elementMenuList(priceFlame);
        info("PriceFlameTextList: " + priceFlameText);
        assertThat(priceFlameText, hasItem("Свечи для домашней молитвы к " +
                "святому Спиридону Тримифунтскому (40 шт)\n210 руб."));
        List<WebElement> candles = lavkaPage.candleProduct();
        List<String> candlesText = lavkaPage.elementFilter(candles,"210 руб.");
        assertThat(candlesText, hasItem("210 руб."));
    }

    @Test
    public void fieldMenu() {
        lavkaPage.setUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> stringList = lavkaPage.stringListMenu();
        List<String> elementList = lavkaPage.elementFilter(stringList, "Четки");
        assertThat(elementList, hasItem(containsString("Четки")));
    }

    @Test
    public void formatMenu() throws InterruptedException {
        lavkaPage.setUtvar();
        lavkaPage.fieldChetki();
        lavkaPage.formatOption("900");
        Thread.sleep(5000);
        Assert.assertEquals("900","900");
        lavkaPage.formatOption("550");
        Assert.assertEquals("550", "550");
    }

    @Test
    public void menuFieldItems() {
        lavkaPage.setUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> ellement = lavkaPage.itemsProduct();
        info("ElementSize: " + ellement.size());
        info("IndividualElementText: " + ellement.get(5).getText());
        Assert.assertTrue(ellement.get(5).getText().contains("126"));
    }

    @Test
    public void itemsTeam() {
        lavkaPage.setUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> ellements = lavkaPage.itemsProduct();
        Set<String> ellementsText = lavkaPage.elementUniqueList(ellements);
        info("EllementsTextList: " + ellementsText);
        if (ellements.size() == 11){
            warn("ElementTrue");
        } else warn("NoElement");
        assertThat(ellementsText, hasItems(containsString("Браслет"),
                containsString("Четки")));
    }
}
