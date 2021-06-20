import org.junit.Assert;
import org.junit.Test;
import page.basepage.DriverLavkaPageSettings;
import page.obitel.RegisterPage;

import static page.settings.TestConfig.*;
import static page.settings.TestDate.*;

public class RegisterPageTest extends DriverLavkaPageSettings {

    @Test
    public void autorisation() {
        registerPage.registration();
        registerPage.nameSet(NAME_REGISTER);
        registerPage.lastNameSet(LASTNAME_REGISTER);
        registerPage.clickMethod();
        registerPage.emailSet(EMAIL_REGISTER);
        registerPage.passwordSet(PASSWORD);
        registerPage.doublePasswordSet(DOUBLEPASSWORD);
    }

    @Test
    public void errorRegistred() throws InterruptedException {
        registerPage.registration();
        registerPage.lastNameSet("");
        registerPage.emailSet("....");
        registerPage.passwordSet(PASSWORD);
        registerPage.doublePasswordSet(NOPASSWORD);
        RegisterPage vera = registerPage.waitButton();
        String Error = vera.errorLastNameSet();
        Assert.assertEquals(LASTNAME_ERROR_REGISTER, Error);
        String Error1 = vera.errorMailSet();
        Assert.assertEquals(EMAIL_ERROR_REGISTER, Error1);
        String Error2 = vera.errorPassSet();
        Assert.assertEquals(PASS_ERROR_REGISTER, Error2);
        String Error3 = vera.errorDoublPassSet();
        Assert.assertEquals(DOUBLEPASS_ERROR_REGISTER, Error3);
    }
}
