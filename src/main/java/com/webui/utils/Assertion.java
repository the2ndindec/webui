package com.webui.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Assertion extends TestBaseCase {
    public static List<Error> errors = new ArrayList<Error>(); // 收集断言异常用于报表日志展示
    public static List<String> assertInfolList = new ArrayList<String>(); // 收集断言信息文本，用于报表展示
    public static List<String> messageList = new ArrayList<String>(); // 收集信息文本用于报表展示
    public static Integer errorIndex = 0; // 记录错误数量
    private static Log log = new Log(Assertion.class);

    private String actualStr;

    public static String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HHmmssSSS");
        return formatter.format(date).toString();
    }

    private static void snapshotInfo() {
        WebDriver driver = TestBaseCase.driver;
        ScreenShot screenShot = new ScreenShot(driver);
        // 设置截图名字
        Date nowDate = new Date();
        screenShot.setScreenName(Assertion.formatDate(nowDate));
        screenShot.takeScreenshot();
    }

    /**
     * 验证actual实际值是否包含预期值exceptStr
     * @param actual
     * @param exceptStr
     */
    public static void verityCationString(String actual, String exceptStr) {
        String verityStr = "Assert验证：{" + "实际值：" + actual + "," + "预期值：" + exceptStr + "} 实际值是否包含预期值";
        Boolean flagBoolean = actual.contains(exceptStr);
        log.info(verityStr);
        log.info(flagBoolean.toString());
        try {
            Assert.assertTrue(flagBoolean);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            errors.add(e);
            AssertFailedLog();
            assertInfolList.add(verityStr + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + actual + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证actual实际值是否包含预期值exceptStr
     * @param actual
     * @param exceptStr
     * @param Message
     */
    public static void verityCationString(String actual, String exceptStr, String Message) {
        String verityStr = "Assert验证：{" + "实际值：" + actual + "," + "预期值：" + exceptStr + "} 实际值是否包含预期值";
        Boolean flagBoolean = actual.contains(exceptStr);
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertTrue(flagBoolean);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errors.add(e);
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + actual + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证实际值actual与预期值exceptStr是否相等
     * @param actual    实际值
     * @param exceptStr 预期值
     */
    public static void verityString(String actual, String exceptStr) {
        String verityStr = "Assert验证：{" + "实际值：" + actual + "," + "预期值:" + exceptStr + "} 实际值与预期值是否一致";
        log.info(verityStr);
        try {
            Assert.assertEquals(actual, exceptStr);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(verityStr + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + actual + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证实际值actual与预期值exceptStr是否相等
     * @param actual
     * @param exceptStr
     * @param Message
     */
    public static void verityString(String actual, String exceptStr, String Message) {
        String verityStr = "Assert验证：{" + "实际值" + actual + "," + "预期值:" + exceptStr + "} 实际值与预期值是否一致";
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertEquals(actual, exceptStr);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + actual + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证页面是否出现某文本exceptStrs
     * @param exceptStr
     */
    public static void verityTextPresent(String exceptStr) {
        String verityStr = "【Assert验证】:" + "页面是否出现" + "【" + "预期值：" + exceptStr + "】" + "字符串";
        Boolean flag = false;
        log.info(verityStr);
        try {
            exceptStr = "//*[contains(text(),'" + exceptStr + "')]";
            log.info("定位信息：" + exceptStr);
            driver.findElements(By.xpath(exceptStr));
            if (driver.findElements(By.xpath(exceptStr)).size() > 0) {
                flag = true;
            } else {
                flag = false;
            }
        } catch (NoSuchElementException e) {
            flag = false;
            ElementAction.noSuchElementExceptions.add(e);
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(flag);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error f) {
            AssertFailedLog();
            errors.add(f);
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + exceptStr + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证页面是否没有出现文本exceptStr
     * @param: [exceptStr] 预期值
     * @return: void
     * @throws:
     */
    public static void verityNotTextPresent(String exceptStr) {
        String verityStr = "【Assert验证】:" + "页面是否没有出现" + "【" + exceptStr + "】" + "字符串";
        Boolean flag = false;
        log.info(verityStr);
        try {
            exceptStr = "//*[contains(text(),'" + exceptStr + "')]";
            driver.findElement(By.xpath(exceptStr));
            flag = false;
        } catch (NoSuchElementException e) {
            flag = true;
        }
        try {
            Assert.assertTrue(flag);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
            System.out.println(flag);
        } catch (Error f) {
            AssertFailedLog();
            errors.add(f);
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
            System.out.println(flag);
            f.printStackTrace();
        }
    }

    /**
     * 验证浏览器标题是否与预期值exceptTitle相同
     * @param exceptTitle 预期标题
     */
    public static void verityTitle(String exceptTitle) {

        String title = driver.getTitle();
        String verityStr = "Assert验证:页面title是否与预期值一致{" + "实际网页标题：" + title + "," + "预期网页标题：" + exceptTitle + "}";
        log.info(verityStr);
        try {
            Assert.assertEquals(title, exceptTitle);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errors.add(e);
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
            e.printStackTrace();
        }
    }

    /**
     * 验证浏览器标题是否与预期值exceptTitle相同
     * @param exceptTitle 预期标题
     * @param Message     验证中文描述
     */
    public static void verityTitle(String exceptTitle, String Message) {

        String title = driver.getTitle();
        String verityStr = "Assert验证:页面title是否与预期值一致{" + "实际网页标题：" + title + "," + "预期网页标题：" + exceptTitle + "}";
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertEquals(title, exceptTitle);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errors.add(e);
            errorIndex++;
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            Assertion.snapshotInfo();
            e.printStackTrace();
        }
    }

    /**
     * 验证某元素文本值是否与预期值exceptText一样
     * @param locator    元素定位信息
     * @param exceptText 预期文本值
     */
    public static void verityText(Locator locator, String exceptText) {
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String text = webElement.getText();
        String verityStr = "Assert验证：某文本值是否与预期值一致{" + "实际值：" + text + "," + "预期值：" + exceptText + "}";
        log.info(verityStr);
        try {
            Assert.assertEquals(text, exceptText);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertPassLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(verityStr + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + text + "\"]");
            Assertion.snapshotInfo();
        }
    }

    public static void verityTextByString(String text, String exceptText) {
        String verityStr = "Assert验证：某文本值是否与预期值一致{" + "实际值：" + text + "," + "预期值：" + exceptText + "}";
        log.info(verityStr);
        try {
            Assert.assertEquals(text, exceptText);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(verityStr + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + text + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某元素文本值是否与预期值exceptText一样
     * @param locator    元素定位信息
     * @param exceptText 预期文本值
     * @param Message    验证中文描述
     */
    public static void verityText(Locator locator, String exceptText, String Message) {
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String text = webElement.getText();
        String verityStr = "Assert验证：某文本值是否与预期值一致{" + "实际值：" + text + "," + "预期值:" + exceptText + "}";
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertEquals(text, exceptText);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertPassLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()=\"" + text + "\"]");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某元素某个属性值与预期值exceptAttributeValue 一样
     * @param locator              元素定位信息
     * @param AttributeName        元素属性名
     * @param exceptAttributeValue 预期值
     */
    public static void verityAttribute(Locator locator, String AttributeName, String exceptAttributeValue) {
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String attribute = webElement.getAttribute(AttributeName);
        String verityStr = "Assert验证：某属性值是否与预期值一致{" + "实际属性值：" + attribute + "," + "预期属性值：" + exceptAttributeValue
                + "}";
        try {
            Assert.assertEquals(attribute, exceptAttributeValue);
            log.info(verityStr);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某元素某个属性值与预期值exceptAttributeValue 一样
     * @param locator              元素定位信息
     * @param AttributeName        元素属性名
     * @param exceptAttributeValue 预期值
     * @param Message              验证中文描述
     */
    public static void verityAttribute(Locator locator, String AttributeName, String exceptAttributeValue,
                                       String Message) {
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String attribute = webElement.getAttribute(AttributeName);
        String verityStr = "Assert验证：某属性值是否与预期值一致{" + "实际属性值：" + attribute + "," + "预期属性值：" + exceptAttributeValue + "}";
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertEquals(attribute, exceptAttributeValue);
            log.info(verityStr);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某输入框是否不可编辑
     * @param locator 元素定位信息
     */
    public static void VertityNoEdit(Locator locator) {
        Boolean status = false;
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String value1 = webElement.getAttribute("disabled");
        String value2 = webElement.getAttribute("readOnly");
        String verityStr = "【Assert验证】:文本框是否不可编辑{" + "实际值：" + status.toString() + "，" + "预期值：false" + "}";
        if (value1.equals("true")) {
            status = true;
        } else if (value2.equals("true")) {
            status = true;
        } else {
            status = false;
        }
        log.info(verityStr);
        try {
            Assert.assertTrue(status);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某输入框是否不可编辑
     * @param locator 元素定位信息
     * @param Message 验证中文描述
     */
    public static void VertityNoEdit(Locator locator, String Message) {
        Boolean status = false;
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String value1 = webElement.getAttribute("disabled");
        String value2 = webElement.getAttribute("readOnly");
        if (value1.equals("true")) {
            status = true;
        } else if (value2.equals("true")) {
            status = true;
        } else {
            status = false;
        }
        String verityStr = "【Assert验证】:文本框是否不可编辑{" + "实际值：" + status.toString() + "，" + "预期值：false" + "}";
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertTrue(status);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errorIndex++;
            errors.add(e);
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某元素可编辑
     * @param locator 元素定位信息
     */
    public static void VertityEdit(Locator locator) {
        Boolean status = false;
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String value1 = webElement.getAttribute("disabled");
        String value2 = webElement.getAttribute("readOnly");
        String verityStr = "【Assert验证】:文本框是否可编辑{" + "实际值：" + status.toString() + "，" + "预期值：true" + "}";
        if (value1.equals("false")) {
            status = true;
        } else if (value2.equals("false")) {
            status = true;
        } else {
            status = false;
        }
        // AssertLog("true", status.toString());
        log.info(verityStr);
        try {
            Assert.assertTrue(status);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errors.add(e);
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证某元素可编辑
     * @param locator 元素定位信息
     * @param Message 验证中文描述
     */
    public static void VertityEdit(Locator locator, String Message) {
        Boolean status = false;
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        String value1 = webElement.getAttribute("disabled");
        String value2 = webElement.getAttribute("readOnly");
        String verityStr = "【Assert验证】:文本框是否可编辑{" + "实际值：" + status.toString() + "，" + "预期值：true" + "}";
        if (value1.equals("false")) {
            status = true;
        } else if (value2.equals("false")) {
            status = true;
        } else {
            status = false;
        }
        // AssertLog("true", status.toString());
        log.info(Message + ":" + verityStr);
        try {
            Assert.assertTrue(status);
            AssertPassLog();
            assertInfolList.add(Message + verityStr + ":pass");
            messageList.add(Message + ":pass");
        } catch (Error e) {
            AssertFailedLog();
            errors.add(e);
            errorIndex++;
            assertInfolList.add(Message + verityStr + ":failed");
            messageList.add(Message + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * 验证页面是否出现某文本--精确匹配
     * @param exceptStr 预期值 预期值
     */
    public static void verityTextPresentPrecision(String exceptStr) {
        String verityStr = "【Assert验证】:" + "页面是否出现" + "【" + "预期值：" + exceptStr + "】" + "字符串";
        Boolean flag = false;
        log.info(verityStr);
        try {
            exceptStr = ".//*[text()='" + exceptStr + "']";
            driver.findElement(By.xpath(exceptStr));
            flag = true;
        } catch (NoSuchElementException e) {
            flag = false;
            ElementAction.noSuchElementExceptions.add(e);
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(flag);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error f) {
            AssertFailedLog();
            errors.add(f);
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
        }
    }

    /**
     * @param: [exceptStr] 预期值
     * @return: void
     * @Description: 验证页面是否没有出现某文本--精确匹配
     * @throws:
     */
    public void verityNotTextPresentPrecision(String exceptStr) {
        String verityStr = "【Assert验证】:" + "页面是否没有出现" + "【" + "预期值：" + exceptStr + "】" + "字符串";
        Boolean flag = false;
        log.info(verityStr);
        try {
            exceptStr = "//*[text()=\"" + exceptStr + "\"]";
            driver.findElement(By.xpath(exceptStr));
            flag = false;
        } catch (NoSuchElementException e) {
            flag = true;
            ElementAction.noSuchElementExceptions.add(e);
            e.printStackTrace();
        }
        try {
            Assert.assertTrue(flag);
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } catch (Error f) {
            AssertFailedLog();
            errors.add(f);
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            Assertion.snapshotInfo();
        }
    }

    public boolean assertElementIsDispaly(Locator locator) {
        ElementAction elementAction = new ElementAction();
        Boolean flag;
        try {
            elementAction.findElement(locator);
            flag = false;
        } catch (NoSuchElementException e) {
            flag = true;
            ElementAction.noSuchElementExceptions.add(e);
            e.printStackTrace();
        }
        return flag;
    }

    // 断言失败日志内容
    private static void AssertFailedLog() {
        log.error("【Assert验证  failed!】");
    }

    // 断言成功日志内容
    private static void AssertPassLog() {
        log.info("【Assert验证  pass!】");
    }

    // 断言日志内容
    private static void AssertLog(String str1, String str2) {
        log.info("【Assert验证】:" + "判断[比较]" + "{" + str1 + "," + str2 + "}" + "是否一致[相等]");
    }

    /*
     * 判断用例是否含有验证失败的断言，如果有此方法会抛出异常，让testng监听器检测到， 如果没有不会抛出异常，testng监听器会认为用例成功
     */
    public static void VerityError() {
        Assert.assertEquals(errors.size(), 0);
        // 有找不到元素的异常也认为用例失败
        Assert.assertEquals(ElementAction.noSuchElementExceptions.size(), 0);
    }

    /**
     * Description: 时间比较。用于验证待验证的时间是否晚于比较的时间
     * @param searchTime
     * @param verifyTime
     * @return: void
     * @throws:
     */
    public static void verifyTime(String searchTime, String verifyTime) throws ParseException {
        String verityStr = "【Assert验证】:" + "查询结果中" + "【" + "预期值：" + verifyTime + "】" + "时间是否正确";
        log.info(verityStr);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bt = sdf.parse(searchTime);
        Date et = sdf.parse(verifyTime);
        if (bt.before(et) || bt.equals(et)) {
            AssertPassLog();
            assertInfolList.add(verityStr + ":pass");
        } else {
            AssertFailedLog();
            errorIndex++;
            assertInfolList.add(verityStr + ":failed");
            ElementAction ea = new ElementAction();
            ea.highlightElementByXpath(".//*[text()='" + verifyTime + "']");
            Assertion.snapshotInfo();
        }
    }

}
