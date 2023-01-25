package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoggedInPage {

    private ChromeDriver driver;
    private By statusAlert = By.id("flash");

    public LoggedInPage(ChromeDriver driver){
        this.driver = driver;
    }

    public String getAlertText(){
        return driver.findElement(statusAlert).getText();
    }

}
