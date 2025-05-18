package helpDesk;

import core.BaseSeleniumPage;
import core.BaseSeleniumTest;
import org.junit.Test;

public class HelpTestDesk extends BaseSeleniumTest {
    @Test
    public void checkTicket(){
        String title = "Dmyto Andriyovich";
        String body = "Повідомлення через селеніум";
        String email = "testEmail@gmail.com";
        MainPage mainPage = new MainPage();
        mainPage.createTicket(title,body, email);
    }
}
