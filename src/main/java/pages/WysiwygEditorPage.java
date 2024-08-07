package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WysiwygEditorPage {
    private WebDriver driver;
    private String editorIframeId= "mce_0_ifr";
    private By testArea = By.id("tinymce");
    private By decreaseIndentButton = By.cssSelector("#mceu_12 button");

    public WysiwygEditorPage(WebDriver driver) {
        this.driver = driver;
    }

    private void switchToEditArea() {
        driver.switchTo().frame(editorIframeId);
    }

    public void clearTextArea() {
        switchToEditArea();
        driver.findElement(testArea).clear();
        switchToMainArea();
    }

    public void setTextArea(String text) {
        switchToEditArea();
        driver.findElement(testArea).sendKeys(text);
        switchToMainArea();
    }

    public void decreaseIndentation() {
        driver.findElement(decreaseIndentButton).click();
    }

    public String getTextFromEditor() {
        switchToEditArea();
        String text = driver.findElement(testArea).getText();
        switchToMainArea();
        return text;
    }

    private void switchToMainArea() {
        driver.switchTo().parentFrame();
    }

}