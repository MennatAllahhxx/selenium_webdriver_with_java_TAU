package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.DropdownPage;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption() {
        DropdownPage dropdownPage = homePage.cliclDropdown();
        String option = "Option 1";

        dropdownPage.selectFromDropdown(option);
        List<String> selectedOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(), 1, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option), "Option is not selected");
    }

    @Test
    public void testSelectMultipleOptions() {
        DropdownPage dropdownPage = homePage.cliclDropdown();
        String option1 = "Option 1";
        String option2 = "Option 2";

        dropdownPage.selectMultipleOptions();
        dropdownPage.selectFromDropdown(option1);
        dropdownPage.selectFromDropdown(option2);

        List<String> selectedOptions = dropdownPage.getSelectedOptions();

        assertEquals(selectedOptions.size(), 2, "Incorrect number of selections");
        assertTrue(selectedOptions.contains(option1), option1 +" is not selected");
        assertTrue(selectedOptions.contains(option2), option2 +" is not selected");
    }
}