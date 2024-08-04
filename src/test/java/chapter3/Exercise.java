package chapter3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Exercise {
    private WebDriver driver;

    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(chromeOptions);

        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");

        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement example1 = driver.findElement(By.linkText("Example 1: Menu Element"));
        example1.click();

        List<WebElement> elements = driver.findElements(By.tagName("li"));
        System.out.println(elements.size());

        driver.quit();
    }

    public static void main(String[] args) {
        Exercise test = new Exercise();
        test.setUp();
    }
}