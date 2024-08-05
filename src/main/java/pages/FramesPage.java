package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage {
    private WebDriver driver;

    public FramesPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public NestedFramesPage clickNestedFrames() {
        clickLink("Nested Frames");

        return new NestedFramesPage(driver);
    }

}