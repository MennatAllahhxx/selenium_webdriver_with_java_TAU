package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    private void clickLink(String linkText) {
        driver.findElement(By.linkText(linkText)).click();
    }

    public LoginPage clickFormAuthentication() {
        clickLink("Form Authentication");

        return new LoginPage(driver);
    }

    public DropdownPage cliclDropdown() {
        clickLink("Dropdown");

        return new DropdownPage(driver);
    }

    public ForgotPasswordPage clickForgotPassowrd() {
        clickLink("Forgot Password");

        return new ForgotPasswordPage(driver);
    }
}