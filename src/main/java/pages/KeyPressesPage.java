package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage {
    private WebDriver driver;
    private By inputfield = By.id("target");
    private By result = By.id("result");

    public KeyPressesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(inputfield).sendKeys(text);
    }

    public void enterPi() {
        driver.findElement(inputfield).sendKeys(Keys.chord(Keys.ALT, "227") + "=3.14");
    }

    public String getResult() {
        return driver.findElement(result).getText();
    }
}