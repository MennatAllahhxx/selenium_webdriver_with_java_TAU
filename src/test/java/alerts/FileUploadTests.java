package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.FileUploadPage;

import static org.testng.Assert.assertEquals;

public class FileUploadTests extends BaseTests {

    @Test
    public void testFileUpload() {
        FileUploadPage fileUploadPage = homePage.clickFileUpload();

        fileUploadPage.uploadFile("E:\\studies\\software_testing\\selenium_webdriver_with_java_TAU\\resources\\chromedriver.exe");

        assertEquals(fileUploadPage.getUploadedFiles(), "chromedriver.exe", "Upload is unsuccessful");
    }
}