package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private String bottomFrame = "frame-bottom";
    private String topFrame = "frame-top";
    private String leftFrame = "frame-left";


    public NestedFramesPage(WebDriver driver) {
        this.driver = driver;
    }

    public void switchToBottomFrame(){
        driver.switchTo().frame(bottomFrame);
    }

    public void switchToTopFrame(){
        driver.switchTo().frame(topFrame);
    }

    public void switchToLeftFrame(){
        driver.switchTo().frame(leftFrame);
    }

    public void switchToMainFrame(){
        driver.switchTo().parentFrame();
    }

    public String getFrameText() {
        return driver.findElement(By.tagName("body")).getText();
    }
}