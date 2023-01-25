package base;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.FormAuthenticationPage;
import pages.LoggedInPage;
import static org.testng.AssertJUnit.assertTrue;

public class FormAuthenticationTests {

    private ChromeDriver driver;
    private FormAuthenticationPage formAuthenticationPage;


    @BeforeEach
    void setUp() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");

        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();

        formAuthenticationPage = new FormAuthenticationPage(driver);
        formAuthenticationPage.navigateToFormAuthenticationPage();
    }

    @Test
    public void testToVerifyOutcome_WhenUserLogsInWithValidUsernameAndPassword() throws InterruptedException {
        formAuthenticationPage.fillLoginForm("tomsmith", "SuperSecretPassword!");
        Thread.sleep(2000);

        LoggedInPage loggedInPage = new LoggedInPage(driver);

        String successMessage = "You logged into a secure area!";
        assertTrue(loggedInPage.getAlertText().contains(successMessage));
    }

    @Test
    public void testToVerifyOutcomeWhen_UserLogsInWithInValidUsernameAndPassword() throws InterruptedException {
        formAuthenticationPage.fillLoginForm("thomas", "SecretPassword!");
        Thread.sleep(2000);

        String errorMsg = "Your username is invalid!";

        assertTrue(formAuthenticationPage.getAlertText().contains(errorMsg));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}