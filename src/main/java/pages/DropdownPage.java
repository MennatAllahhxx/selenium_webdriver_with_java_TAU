package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {
    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    private Select findDropdownElememnt() {
        return new Select(driver.findElement(dropdown));
    }

    public void selectFromDropdown(String option) {
        findDropdownElememnt().selectByVisibleText(option);
    }

    public List<String> getSelectedOptions() {
        List<WebElement> selectedElements = findDropdownElememnt().getAllSelectedOptions();

        return selectedElements.stream().map(element->element.getText()).collect(Collectors.toList());
    }

    public void selectMultipleOptions() {
        JavascriptExecutor jsExecuter = (JavascriptExecutor)driver;
        String script = "arguments[0].setAttribute('multiple', '')";
        WebElement dropdownElement = driver.findElement(dropdown);

        jsExecuter.executeScript(script, dropdownElement);
    }
}