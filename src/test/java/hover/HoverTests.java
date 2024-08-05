package hover;

import base.BaseTests;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HoversPage;

import java.util.Base64;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {

    @Test
    public void testHoverUser1() {
        HoversPage hoversPage = homePage.clickHovers();
        HoversPage.FigureCaption figureCaption = hoversPage.hoverOverFigure(1);

        assertTrue(figureCaption.isCaptionDisplayed(), "Caption is not displayed");
        assertEquals(figureCaption.getTitle(), "name: user1", "Incorrect caption title");
        assertEquals(figureCaption.getLinkText(), "View profile", "Incorrect link text");
        assertTrue(figureCaption.getLink().endsWith("/users/1"), "Incorrect link");
    }
}