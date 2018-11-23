package com.webui.utils;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

public class TestListener extends TestListenerAdapter {
	Log log = new Log(this.getClass());
	// 输出失败结果详情
	public static StringBuffer stringBuffer1 = new StringBuffer(
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<failed>\n");
	String path = "test-output\\failed.xml";
	File file = new File(path);
	FileWriter fileWriter = null;
	// 输出成功结果详细信息
	public static StringBuffer stringBuffer2 = new StringBuffer(
			"<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<passed>\n");
	String path2 = "test-output\\passed.xml";
	File file2 = new File(path2);
	FileWriter fileWriter2 = null;

	FileManger fileManger = new FileManger();
	
	@Override
	public void onTestStart(ITestResult result) {
		// 方法开始前初始化报表描述信息
		Assertion.errors.clear();
		Assertion.errorIndex = 0;
		Assertion.messageList.clear();
		ElementAction.noSuchElementExceptions.clear();
		log.info("测试用例:" + result.getMethod().getDescription() + "---start");
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		TestBaseCase testBaseCase = (TestBaseCase) tr.getInstance();
		WebDriver driver = testBaseCase.driver;
		ScreenShot screenShot = new ScreenShot(driver);
		// 设置截图名字
		screenShot.setScreenName(tr.getMethod().getDescription() + Assertion.errorIndex.toString());
		log.error(Assertion.errorIndex.toString());
		screenShot.takeScreenshot();
		for (int i = 0; i < Assertion.messageList.size(); i++) {
			if (tr.getParameters().length > 0) {
				stringBuffer1.append("<err_assert_info" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "." + tr.getEndMillis() + "\">\n");
			} else {
				stringBuffer1.append("<err_assert_info" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "\">\n");
			}
			if (Assertion.messageList.get(i).contains("pass")) {
				stringBuffer1.append("<span class=\"pass_span\">" + Assertion.messageList.get(i) + "</span></br>\n");
			} else if (Assertion.messageList.get(i).contains("failed")) {
				stringBuffer1.append("<span class=\"err_span\">" + Assertion.messageList.get(i) + "</span></br>\n");
			} else if (Assertion.messageList.get(i).contains("点击查看大图")) {
				stringBuffer1.append("<span class=\"err_span\">" + Assertion.messageList.get(i) + "</span>\n");
			}
			stringBuffer1.append("</err_assert_info>\n");
		}
		for (Exception e : ElementAction.noSuchElementExceptions) {
			StackTraceElement[] errorTraces = e.getStackTrace();
			StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
			if (tr.getParameters().length > 0) {
				stringBuffer1.append("<err_assert_info_StackTrace" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "." + tr.getEndMillis() + "\">\n");
			} else {
				stringBuffer1.append("<err_assert_info_StackTrace" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "\">\n");
			}
			stringBuffer1.append("<span class=\"err_span\" >" + e.getMessage() + "</span></br>\n");
			for (int i = 0; i < et.length; i++) {
				stringBuffer1.append("<span class=\"err_span\">" + et[i].toString() + "</span></br>\n");
			}
			stringBuffer1.append("</err_assert_info_StackTrace>\n");

		}
		for (Error e : Assertion.errors) {
			StackTraceElement[] errorTraces = e.getStackTrace();
			StackTraceElement[] et = this.getKeyStackTrace(tr, errorTraces);
			if (tr.getParameters().length > 0) {
				stringBuffer1.append("<err_assert_info_StackTrace" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "." + tr.getEndMillis() + "\">\n");
			} else {
				stringBuffer1.append("<err_assert_info_StackTrace" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "\">\n");
			}
			stringBuffer1.append("<span class=\"err_span\" >" + e.getMessage() + "</span></br>\n");
			for (int i = 0; i < et.length; i++) {
				stringBuffer1.append("<span class=\"err_span\">" + et[i].toString() + "</span></br>\n");
			}

			stringBuffer1.append("</err_assert_info_StackTrace>\n");
		}
		if (file.exists()) {
			file.delete();
			;
		}
		fileManger.writeWithEncode(file, "utf-8", true, stringBuffer1.toString() + "</failed>");
		// log.error(sb.toString());
		// this.handAssertion(tr);
		log.error("测试用例: " + tr.getMethod().getDescription() + "--failed");
		log.info("测试用例:" + tr.getMethod().getDescription() + "---end");
	}

	private StackTraceElement[] getKeyStackTrace(ITestResult tr, StackTraceElement[] stackTraceElements) {
		List<StackTraceElement> ets = new ArrayList<StackTraceElement>();
		for (StackTraceElement stackTraceElement : stackTraceElements) {
			if (stackTraceElement.getClassName().equals(tr.getTestClass().getName())) {
				ets.add(stackTraceElement);
			}
		}
		StackTraceElement[] et = new StackTraceElement[ets.size()];
		for (int i = 0; i < et.length; i++) {
			et[i] = ets.get(i);
		}
		return et;
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		TestBaseCase testBaseCase = (TestBaseCase) tr.getInstance();
		WebDriver driver = testBaseCase.driver;
		ScreenShot screenShot = new ScreenShot(driver);
		// 设置截图名字
		screenShot.setScreenName(tr.getMethod().getDescription());
		screenShot.takeScreenshot();
		log.warn("测试用例: " + tr.getMethod().getDescription() + "--skipped");
		log.info("测试用例:" + tr.getMethod().getDescription() + "---end");
	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		for (int i = 0; i < Assertion.messageList.size(); i++) {
			if (tr.getParameters().length > 0) {
				stringBuffer2.append("<pass_assert_info" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "." + tr.getEndMillis() + "\">\n");
			} else {
				stringBuffer2.append("<pass_assert_info" + "   method=\"" + tr.getTestClass().getName() + "."
						+ tr.getMethod().getMethodName() + "\">\n");
			}
			stringBuffer2.append("<span class=\"pass_span\">" + Assertion.messageList.get(i) + "</span></br>\n");

			stringBuffer2.append("</pass_assert_info>\n");
		}
		if (file2.exists()) {
			file2.delete();
			;
		}
		fileManger.writeWithEncode(file2, "utf-8", true, stringBuffer2.toString() + "</passed>");
		log.info("测试用例: " + tr.getMethod().getDescription() + "--passed");
		log.info("测试用例:" + tr.getMethod().getDescription() + "---end");
	}
}
