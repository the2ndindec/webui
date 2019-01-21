package com.webui.Listener;

import com.webui.utils.TestBaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * @author the2n
 * @Description:
 * @Data 2019/01/21 16:02
 */
public class TestFailListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {
        takePhoto();
    }

    @Attachment(value = "screen shot",type = "image/png")
    public byte[] takePhoto() {
        byte[] screenshotAs = ((TakesScreenshot) TestBaseCase.driver).getScreenshotAs(OutputType.BYTES);
        return screenshotAs;
    }
}
