package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FormAuthenticationPage {

    private ChromeDriver driver;

    private String formAuthenticationLinkId = "Form Authentication";

    private String loginUsernameId = "username";
    private String loginPasswordId = "password";
    private String loginButtonId = "radius";
    private By statusAlert = By.id("flash");

    public FormAuthenticationPage(ChromeDriver driver){
        this.driver = driver;
    }

    public void navigateToFormAuthenticationPage(){
       driver.findElementByLinkText(formAuthenticationLinkId).click();
    }

    public void fillLoginForm(String username, String password) throws InterruptedException {
        WebElement usernameField = driver.findElementById(loginUsernameId);
        usernameField.sendKeys(username);

        WebElement passwordField = driver.findElementById(loginPasswordId);
        passwordField.sendKeys(password);

        driver.findElementByClassName(loginButtonId).click();
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }
}
