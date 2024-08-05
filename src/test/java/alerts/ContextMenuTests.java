package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ContextMenuPage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    @Test
    public void testContextAlert() {
        ContextMenuPage contextMenuPage = homePage.clickContextMenu();

        contextMenuPage.rightClickContext();
        String text = contextMenuPage.alert_getAlertText();
        contextMenuPage.alert_clickToAccept();

        assertEquals(text, "You selected a context menu", "Invalid alert text");
    }
}