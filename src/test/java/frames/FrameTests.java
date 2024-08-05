package frames;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.WysiwygEditorPage;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {
    @Test
    public void testWysiwyg() {
        WysiwygEditorPage wysiwygEditorPage = homePage.clickWysiwygEditor();

        wysiwygEditorPage.clearTextArea();
        wysiwygEditorPage.setTextArea("Hello ");
        wysiwygEditorPage.decreaseIndentation();
        wysiwygEditorPage.setTextArea("world!");

        assertEquals(wysiwygEditorPage.getTextFromEditor(),"Hello world!", "Text from editor is incorrect");
    }

}