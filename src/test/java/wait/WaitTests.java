package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DynamicLoadingExample1Page;
import pages.DynamicLoadingExample2Page;

import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {
    @Test
    public void testWaitUntilHidden() {
        DynamicLoadingExample1Page dynamicLoadingExample1Page = homePage.clickDynamicLoading().clickExample1();

        dynamicLoadingExample1Page.clickStart();

        assertEquals(dynamicLoadingExample1Page.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }

    @Test
    public void testWaitUntilVisible() {
        DynamicLoadingExample2Page dynamicLoadingExample2Page = homePage.clickDynamicLoading().clickExample2();

        dynamicLoadingExample2Page.clickStart();

        assertEquals(dynamicLoadingExample2Page.getLoadedText(), "Hello World!", "Loaded text is incorrect");
    }
}