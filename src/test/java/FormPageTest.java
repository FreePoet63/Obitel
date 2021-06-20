import org.junit.Assert;
import org.junit.Test;
import page.basepage.DriverObitelPageSettings;
import page.obitel.FormPage;

import static page.settings.TestConfig.*;
import static page.settings.TestDate.*;

public class FormPageTest extends DriverObitelPageSettings {

    @Test
    public void startForm() {
        formPage.openForm();
        formPage.emailQuestonsAuthor(EMAIL, QUESTON, AUTHOR);
    }

    @Test
    public void text() {
        FormPage xp = formPage.openForm();
        String Mail  = xp.newEmail();
        Assert.assertEquals(EMAIL_VALUE_FORM_PAGE, Mail);
    }

    @Test
    public void error() {
        formPage.openForm();
        formPage.emailQuestonsAuthor(EMAIL, "..", "..");
        FormPage aut = formPage.clickButton();
        String Error = aut.erroland();
        Assert.assertEquals(ERROR_FORM_PAGE, Error);
    }
}
