import org.junit.Assert;
import org.junit.Test;
import page.basepage.DriverObitelTravelPage;
import page.obitel.OrderPage;
import page.settings.TestConfig;

import static page.settings.TestConfig.*;
import static page.settings.TestDate.*;

public class OrderPageTest extends DriverObitelTravelPage {

    @Test
    public void orderForm() {
        orderPage.getName(NAME);
        orderPage.getMiddle(MIDDLE);
        orderPage.getLast(LAST);
        orderPage.getCountry(COUNTRY);
        orderPage.getMail(EMAIL);
        orderPage.getPhone(PHONE);
        orderPage.getMans(MANS);
        orderPage.getClick1();
        orderPage.getData(DATA);
    }

    @Test
    public void orderError() {
        orderPage.getButton1();
        OrderPage autoOrder = orderPage.getButton1();
        String ErrorName = autoOrder.nameError();
        Assert.assertEquals(ALL_ERROR_ORDERPAGE, ErrorName);
        String ErrorLast = orderPage.lastError();
        Assert.assertEquals(ALL_ERROR_ORDERPAGE, ErrorLast);
        String ErrorMail = orderPage.mailError();
        Assert.assertEquals(ALL_ERROR_ORDERPAGE, ErrorMail);
        String ErrorPhone = orderPage.phoneError();
        Assert.assertEquals(ALL_ERROR_ORDERPAGE, ErrorPhone);
        String ErrorMans = orderPage.mansError();
        Assert.assertEquals(ALL_ERROR_ORDERPAGE, ErrorMans);
    }

    @Test
    public void mailTextRow() {
        orderPage.getMail(TestConfig.NULL_EMAIL);
        orderPage.getButton1();
        OrderPage mom = orderPage.getButton1();
        String mailblack = mom.mailTextErrow();
        Assert.assertEquals(ERROR_MAIL_ORDERPAGE, mailblack);
    }

    @Test
    public void HeaderOrderObitel() {
        OrderPage Mam = orderPage.headerOrder();
        String header = Mam.orderHeader();
        Assert.assertEquals(DATA_ORDERPAGE, header);
        orderPage.clickHeader();
    }
}