package navigation;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertTrue;

public class NavigationTests extends BaseTests {
    @Test
    public void testNavigator() {
        homePage.clickDynamicLoading().clickExample1();
        getWindowManager().goBack();
        getWindowManager().refreshPage();
        getWindowManager().goForward();
        getWindowManager().goTo("https://www.google.com");
    }

    @Test
    public void testSwitchTab() {
        homePage.clickMultipleWindows().clickHere();
        getWindowManager().switchToTab("New Window");
    }

    @Test
    public void testSwitchToTabFromKeyboardKeys() {
        DynamicLoadingExample2Page dynamicLoadingExample2Page = homePage.clickDynamicLoading().righClickExample2();

        getWindowManager().switchToNewTab();

        assertTrue(dynamicLoadingExample2Page.startButtonIsDisplayed(), "The start button is not displayed");
    }
}