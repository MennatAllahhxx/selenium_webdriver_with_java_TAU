package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.NestedFramesPage;

import static org.testng.Assert.assertEquals;

public class NestedFramesTests extends BaseTests {
    @Test
    public void testBottomFrameBody() {
        NestedFramesPage nestedFramesPage = homePage.clickFrames().clickNestedFrames();

        nestedFramesPage.switchToBottomFrame();
        String text = nestedFramesPage.getFrameText();
        nestedFramesPage.switchToMainFrame();

        assertEquals(text, "BOTTOM");
    }

    @Test
    public void testLeftFrameBody() {
        NestedFramesPage nestedFramesPage = homePage.clickFrames().clickNestedFrames();

        nestedFramesPage.switchToTopFrame();
        nestedFramesPage.switchToLeftFrame();
        String text = nestedFramesPage.getFrameText();
        nestedFramesPage.switchToMainFrame();
        nestedFramesPage.switchToMainFrame();

        assertEquals(text, "LEFT");
    }
}