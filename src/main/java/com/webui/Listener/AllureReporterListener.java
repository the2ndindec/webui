package com.webui.Listener;

import com.google.common.io.Files;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IHookCallBack;
import org.testng.IHookable;
import org.testng.ITestResult;

import java.io.File;

/**
 * @author the2n
 * @date 2019/01/25 10:18
 */
public class AllureReporterListener implements IHookable {
    @Override
    public void run(IHookCallBack callBack, ITestResult testResult) {
        callBack.runTestMethod(testResult);
        if (testResult.getThrowable() !=null){
            try{
                takeScreenShot(testResult.getMethod().getMethodName());
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    @Attachment(value = "Failure in method {0}", type = "image/png")
    private byte[] takeScreenShot(String methodName) throws Exception{
//        File screenshot = Screenshots.getLastScreenshot();
        byte[] screenshot = ((TakesScreenshot) TestBaseCase.driver).getScreenshotAs(OutputType.BYTES);
        return screenshot;
    }
}
