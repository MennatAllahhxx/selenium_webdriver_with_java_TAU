package base;

import com.google.common.io.Files;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;

import java.io.File;
import java.io.IOException;


public class BaseTests {
    private EventFiringWebDriver driver;
    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        driver = new EventFiringWebDriver(new ChromeDriver(getChromeOptions()));

        driver.register(new EventReporter());
        driver.manage().window().maximize();

        goHome();

        setCookie();

        System.out.println("Cookies before deletion: ");
        getWebsiteCookies();
        System.out.println("-------------------------");

        deleteCookie();

        System.out.println("Cookies after deletion: ");
        getWebsiteCookies();
        System.out.println("-------------------------");
    }

    @BeforeMethod
    public void goHome() {
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (ITestResult.FAILURE == result.getStatus()) {
            var camera = (TakesScreenshot)driver;

            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/" + result.getName() + ".png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public WindowManager getWindowManager() {
        return new WindowManager(driver);
    }

    private ChromeOptions getChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("disable-infobars", "--remote-allow-origins=*");
        //chromeOptions.setHeadless(true);

        return chromeOptions;
    }

    private void setCookie() {
        Cookie cookie = new Cookie.Builder("tau", "123").
                domain("the-internet.herokuapp.com").
                build();

        driver.manage().addCookie(cookie);
    }

    private void deleteCookie() {
        Cookie cookie = new Cookie.Builder("optimizelyBuckets", "%7B%7D").
                domain("the-internet.herokuapp.com").
                build();
        driver.manage().deleteCookie(cookie);
    }

    public void getWebsiteCookies() {
        driver.manage().getCookies().forEach(cookie-> System.out.println(cookie.getName()));
    }
}