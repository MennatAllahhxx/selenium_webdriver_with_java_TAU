package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DynamicLoadingPage {
    private WebDriver driver;
    private String linkXpathFormat = ".//a[contains(text(), '%s')]";

    public DynamicLoadingPage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.xpath(linkText)).click();
    }

    public DynamicLoadingExample1Page clickExample1() {
        clickLink(String.format(linkXpathFormat, "1"));

        return new DynamicLoadingExample1Page(driver);
    }

    public DynamicLoadingExample2Page clickExample2() {
        clickLink(String.format(linkXpathFormat, '2'));

        return new DynamicLoadingExample2Page(driver);
    }
}