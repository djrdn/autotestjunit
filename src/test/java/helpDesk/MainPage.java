package helpDesk;

import core.BaseSeleniumPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import readProperties.ConfigProvider;

public class MainPage extends BaseSeleniumPage {
//    private final By queueList = By.xpath("//select[@id='id_queue']");
//    private WebElement webElement = driver.findElement(queueList);

    @FindBy(xpath = "//select[@id='id_queue']")
    private WebElement queueList;

    @FindBy(xpath = "//select[@id='id_queue']//option[@value = 1]")
    private WebElement queueValue;

    @FindBy(id = "id_title")
    private WebElement title;

    @FindBy(id = "id_body")
    private  WebElement body;

    @FindBy(id = "id_due_date")
    private WebElement dateField;

    @FindBy(xpath = "//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[4]/td[6]/a")
    private WebElement dateValue;

    @FindBy(id = "id_submitter_email")
    private WebElement email;

    @FindBy(xpath="//*[@id=\"content-wrapper\"]/div/div/div/div[2]/div/div/form/button")
    private WebElement submitButton;


    public MainPage() {
        driver.get(ConfigProvider.URL);
        PageFactory.initElements(driver, this);
    }

    public MainPage createTicket(String titleValue, String bodyValue, String emailValue){
        queueList.click();
        queueValue.click();
        body.sendKeys(bodyValue);
        title.sendKeys(titleValue);
        dateField.click();
        dateValue.click();
        email.sendKeys(emailValue);
        submitButton.click();
        return this;
    }
}
