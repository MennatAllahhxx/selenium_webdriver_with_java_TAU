package horizontalSlider;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;

public class HorizontalSliderTests extends BaseTests {

    @Test
    public void testHorizontalSlider() {
        HorizontalSliderPage horizontalSliderPage = homePage.clickHorizontalSlider();

        int range = 3;

        horizontalSliderPage.setSlider(range);
        assertEquals(horizontalSliderPage.getRange(), Integer.toString(range), "Invalid range displayed");
    }
}