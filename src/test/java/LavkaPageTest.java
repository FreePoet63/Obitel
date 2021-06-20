import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import page.basepage.DriverLavkaPageSettings;
import page.obitel.LavkaPage;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

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
        List<String> itemsText = items24.stream().map(s -> s.getText()).collect(Collectors.toList());
        itemsText.forEach(System.out::println);
        assertThat(itemsText, hasItems(containsString("Набор свечей для детей"),
                containsString("Набор паломника"),
                containsString("Свечи для домашней молитвы")));
    }

    @Test
    public void itemsFlame() {
        lavkaPage.setUtvar();
        lavkaPage.candleField();
        List<WebElement> priceFlame = lavkaPage.itemsProduct();
        List<String> priceFlameText = priceFlame.stream().map(e -> e.getText()).collect(Collectors.toList());
        priceFlameText.forEach(System.out::println);
        assertThat(priceFlameText, hasItem("Свечи для домашней молитвы к святому" +
                " Спиридону Тримифунтскому (40 шт)\n" +
                "210 руб."));
        List<WebElement> candles = lavkaPage.candleProduct();
        List<String> candlesText = candles.stream().map(el -> el.getText()).filter(ol -> ol.contains("210 руб."))
                .collect(Collectors.toList());
        assertThat(candlesText, hasItem("210 руб."));
    }

    @Test
    public void fieldMenu() {
        lavkaPage.setUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> stringList = lavkaPage.stringListMenu();
        List<String> elementList = stringList.stream().map(d -> d.getText()).filter(elem -> elem.contains("Четки"))
                .collect(Collectors.toList());
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
        System.out.println(ellement.size());
        System.out.println(ellement.get(5).getText());
        Assert.assertTrue(ellement.get(5).getText().contains("126"));
    }

    @Test
    public void itemsTeam() {
        lavkaPage.setUtvar();
        lavkaPage.fieldChetki();
        List<WebElement> ellements = lavkaPage.itemsProduct();
        Set<String> ellementsText = ellements.stream().map(t -> t.getText())
                .collect(Collectors.toCollection(TreeSet::new));
        ellementsText.forEach(System.out::println);
        if (ellements.size() == 11){
            System.out.println("EllementTrue");
        } else System.out.println("Non");
        assertThat(ellementsText, hasItems(containsString("Браслет"),
                containsString("Четки")));
    }
}
