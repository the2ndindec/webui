package com.webui.Listener;

import com.webui.utils.AllureAttachments;
import com.webui.utils.TestBaseCase;
import org.testng.*;

/**
 * @author the2n
 * @date 2019/01/22 13:31
 */
public class AllureListener extends TestBaseCase implements ITestListener, ISuiteListener, IInvokedMethodListener {


    @Override
    public void beforeInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {
        String textMsg = "Completed executing following method : " + returnMethodName(iInvokedMethod.getTestMethod());
        Reporter.log(textMsg, false);
    }
    private String returnMethodName(ITestNGMethod method)
    {
        return method.getRealClass().getSimpleName() + "." + method.getMethodName();
    }

    @Override
    public void afterInvocation(IInvokedMethod iInvokedMethod, ITestResult iTestResult) {

    }

    @Override
    public void onStart(ISuite iSuite) {
        Reporter.log("Execution of the Suite '" + iSuite.getName() + "' Started!", false);
    }

    @Override
    public void onFinish(ISuite iSuite) {
        Reporter.log("Execution of the Suite '" + iSuite.getName() + "' Completed!", false);
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
        Reporter.log("\nSTARTED TESTING: " + iTestResult.getTestClass().getName() + "." + iTestResult.getMethod().getMethodName() + "\n", true);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        Reporter.log("\nSUCCESFULLY EXECUTED TEST: " + iTestResult.getTestClass().getName() + "." + iTestResult.getMethod().getMethodName() + "\n", true);
        Reporter.log("\n");
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        String Name = iTestResult.getTestClass().getName() + "." + iTestResult.getMethod().getMethodName() ;
        Reporter.log("\nFAILED TEST: " + iTestResult.getTestClass().getName() + "." + iTestResult.getMethod().getMethodName() + "\n", true);
        AllureAttachments.saveFullPageScreenshot(Name, driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        Reporter.log("\nSKIPPED TEST: " + iTestResult.getTestClass().getName() + "." + iTestResult.getMethod().getMethodName() + "\n", true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        Reporter.log("About to begin executing Test " + iTestContext.getName(), false);
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        Reporter.log("Completed executing test " + iTestContext.getName(), false);
    }
}
