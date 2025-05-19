package helpDesk;

import core.BaseSeleniumTest;
import helpers.TestValues;
import org.junit.Assert;
import org.junit.Test;
import readProperties.ConfigProvider;



import static helpers.StringModifire.getUniqueString;

public class HelpTestDesk extends BaseSeleniumTest {
    @Test
    public void checkTicket(){
        String title = getUniqueString(TestValues.TEST_TITLE);
        String body = TestValues.TEST_BODY;
        String email = TestValues.TEST_EMAIL;

        TicketPage ticketPage =  new MainPage().createTicket(title,body, email).openLoginPage()
                .auth(ConfigProvider.DEMO_LOGIN, ConfigProvider.DEMO_PASSWORD)
                .findTicket(title);

        Assert.assertTrue(ticketPage.getTitle().contains(title));
        Assert.assertEquals(ticketPage.getBody(), TestValues.TEST_BODY);
        Assert.assertEquals(ticketPage.getEmail(), TestValues.TEST_EMAIL);
    }
}
