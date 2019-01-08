package com.webui.utils;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ElementAction extends TestBaseCase {
    private Log log = new Log(this.getClass());
    public static ArrayList<Exception> noSuchElementExceptions = new ArrayList<Exception>();

    public String formatDate(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HHmmssSSS");
        return formatter.format(date).toString();
    }

    /**
     * 查找一组元素
     * @param locator
     * @return
     */
    public List<WebElement> findElements(final Locator locator) {

        /**
         * 查找某个元素等待几秒
         */

        List<WebElement> webElements = null;
        try {
            webElements = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<List<WebElement>>() {
                @Override
                public List<WebElement> apply(WebDriver driver) {
                    List<WebElement> element = null;
                    element = getElements(locator);
                    return element;
                }
            });
            return webElements;
        } catch (NoSuchElementException e) {
            log.info("无法定位页面元素");
            e.printStackTrace();
            Assertion.assertInfolList.add(
                    "failed,找不到元素：[" + locator.getBy() + ":" + locator.getElement() + "等待:" + locator.getWaitSec());
            noSuchElementExceptions.add(e);
            Assertion.messageList.add("找不到所需页面元素[" + locator.getElement() + "]:failed");
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            return webElements;
        } catch (TimeoutException e) {
            log.info("查找页面元素超时");
            e.printStackTrace();
            Assertion.assertInfolList.add(
                    "failed,超时找不到元素：[" + locator.getBy() + ":" + locator.getElement() + "等待:" + locator.getWaitSec());
            noSuchElementExceptions.add(e);
            Assertion.messageList.add("超时找不到所需页面元素[" + locator.getElement() + "]:failed");
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            return webElements;
        } catch (ElementNotVisibleException e) {
            log.info("查找页面元素超时");
            e.printStackTrace();
            Assertion.assertInfolList.add(
                    "failed,页面元素不可视：[" + locator.getBy() + ":" + locator.getElement() + "等待:" + locator.getWaitSec());
            noSuchElementExceptions.add(e);
            Assertion.messageList.add("超时页面元素不可视[" + locator.getElement() + "]:failed");
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            return webElements;
        }
    }

    public WebElement findElement(final Locator locator) {
        /**
         * 查找某个元素等待几秒
         */
        // Waitformax(Integer.valueOf(locator.getWaitSec()));
        WebElement webElement = null;
        try {
            webElement = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<WebElement>() {
                @Override
                public WebElement apply(WebDriver driver) {
                    WebElement element = null;
                    element = getElement(locator);
                    return element;
                }
            });
            return webElement;
        } catch (NoSuchElementException e) {
            log.info("无法定位页面元素");
            e.printStackTrace();
            Assertion.assertInfolList.add(
                    "failed,找不到元素：[" + locator.getBy() + ":" + locator.getElement() + "等待:" + locator.getWaitSec());
            noSuchElementExceptions.add(e);
            Assertion.messageList.add("找不到所需页面元素[" + locator.getElement() + "]:failed");
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            log.info(this.formatDate(nowDate));
            return webElement;
        } catch (TimeoutException e) {
            log.info("超时无法定位页面元素");
            e.printStackTrace();
            Assertion.assertInfolList.add(
                    "failed,超时找不到元素：[" + locator.getBy() + ":" + locator.getElement() + "等待:" + locator.getWaitSec());
            noSuchElementExceptions.add(e);
            Assertion.messageList.add("超时找不到所需页面元素[" + locator.getElement() + "]:failed");
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            log.info(this.formatDate(nowDate));
            return webElement;
        } catch (ElementNotVisibleException e) {
            log.info("超时无法定位页面元素");
            e.printStackTrace();
            Assertion.assertInfolList.add(
                    "failed,超时找不到元素：[" + locator.getBy() + ":" + locator.getElement() + "等待:" + locator.getWaitSec());
            noSuchElementExceptions.add(e);
            Assertion.messageList.add("超时页面元素不可视[" + locator.getElement() + "]:failed");
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            log.info(this.formatDate(nowDate));
            return webElement;
        }
    }

    /**
     * 通过定位信息获取元素
     * @param locator
     * @return 返回WebElement
     */
    public WebElement getElement(Locator locator) {

        /**
         * locator.getElement(),获取对象库对象定位信息
         */
        log.info("查找元素：" + locator.getLocalorName() + ">>>方式:" + "[" + "By." + locator.getBy() + ":" + locator.getElement()
                + "]");
        WebElement webElement;
        switch (locator.getBy()) {
            case xpath:
                webElement = driver.findElement(By.xpath(locator.getElement()));
                break;
            case id:
                webElement = driver.findElement(By.id(locator.getElement()));
                break;
            case cssSelector:
                webElement = driver.findElement(By.cssSelector(locator.getElement()));
                break;
            case name:
                webElement = driver.findElement(By.name(locator.getElement()));
                break;
            case className:
                webElement = driver.findElement(By.className(locator.getElement()));
                break;
            case linkText:
                webElement = driver.findElement(By.linkText(locator.getElement()));
                break;
            case partialLinkText:
                webElement = driver.findElement(By.partialLinkText(locator.getElement()));
                break;
            case tagName:
                webElement = driver.findElement(By.tagName(locator.getElement()));
                break;
            default:
                webElement = driver.findElement(By.xpath(locator.getElement()));
                break;
        }
        return webElement;
    }

    /**
     * 通过定位信息获取一组元素
     * @param locator
     * @return 返回WebElement
     */

    public List<WebElement> getElements(Locator locator) {
        /**
         * locator.getElement(),获取对象库对象定位信息
         */
        log.info("查找一组元素：" + locator.getLocalorName() + " >>>方式:" + "[" + "By." + locator.getBy() + ":"
                + locator.getElement() + "]");
        List<WebElement> webElements;
        switch (locator.getBy()) {
            case xpath:
                webElements = driver.findElements(By.xpath(locator.getElement()));
                /**
                 * 出现找不到元素的时候，记录日志文件
                 */
                break;
            case id:
                webElements = driver.findElements(By.id(locator.getElement()));
                break;
            case cssSelector:
                webElements = driver.findElements(By.cssSelector(locator.getElement()));
                break;
            case name:
                webElements = driver.findElements(By.name(locator.getElement()));
                break;
            case className:
                webElements = driver.findElements(By.className(locator.getElement()));
                break;
            case linkText:
                webElements = driver.findElements(By.linkText(locator.getElement()));
                break;
            case partialLinkText:
                webElements = driver.findElements(By.partialLinkText(locator.getElement()));
                break;
            case tagName:
                webElements = driver.findElements(By.partialLinkText(locator.getElement()));
                break;
            default:
                webElements = driver.findElements(By.xpath(locator.getElement()));
                break;
        }
        return webElements;
    }

    // 2019-01-02
    /**
     * Description:通过xpath获取一组元素
     * @param locator	元素的xpath值
     * @return: java.util.List<org.openqa.selenium.WebElement>
     * @throws:
     */
    public List<WebElement> getElements(String locator){
        List<WebElement> webElements;
        webElements = driver.findElements(By.xpath(locator));
        return webElements;
    }
    public List<WebElement> findElements(final String locator){
        List<WebElement> webElements = null;
        try {
            webElements = (new WebDriverWait(driver, 20)).until(new ExpectedCondition<List<WebElement>>() {
                @Override
                public List<WebElement> apply(WebDriver driver) {
                    List<WebElement> element = null;
                    element = getElements(locator);
                    return element;
                }
            });
            return webElements;
        } catch (NoSuchElementException e) {
            log.info("无法定位页面元素");
            e.printStackTrace();
            noSuchElementExceptions.add(e);
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            return webElements;
        } catch (TimeoutException e) {
            log.info("查找页面元素超时");
            e.printStackTrace();
            noSuchElementExceptions.add(e);
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            return webElements;
        } catch (ElementNotVisibleException e) {
            log.info("查找页面元素超时");
            e.printStackTrace();
            noSuchElementExceptions.add(e);
            ScreenShot screenShot = new ScreenShot(driver);
            // 设置截图名字
            Date nowDate = new Date();
            screenShot.setScreenName(this.formatDate(nowDate));
            screenShot.takeScreenshot();
            return webElements;
        }
    }

    /**
     * 文本框输入操作
     * @param locator 元素locator
     * @param value   输入值
     */
    public void type(Locator locator, String value) {
        try {
            WebElement webElement = findElement(locator);
            webElement.clear();
            webElement.sendKeys(value);
            log.info("input输入：" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":" + locator.getElement()
                    + "value:" + value + "]");
        } catch (NoSuchElementException e) {
            log.error("找不到元素，input输入失败:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            e.printStackTrace();
        }
    }

    public void type_action(Locator locator, String value) {
        Actions actions = new Actions(driver);
        WebElement weElement = findElement(locator);
        actions.sendKeys(weElement, value);
    }

    /**
     * Description:通过js方法完成输入指定值
     * @param locator	输入框元素
     * @param value	要输入的值
     * @return: void
     * @throws:
     */
    public void typeByJS(Locator locator, String value) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement weElement = findElement(locator);
        jse.executeScript("return arguments[0].value='" + value + "'", weElement);
        log.info("输入参数>> " + value + " >成功");
    }

    /**
     * 失去焦点.通过js实现失去焦点的方法
     * @param: [locator] 需要操作的对象元素
     * @return: void
     * @throws:
     */
    public void fireEventBlur(Locator locator) {
        WebElement weElement = findElement(locator);
        click(locator);
        ((JavascriptExecutor) driver).executeScript("return arguments[0].blur()", weElement);
    }

    /**
     * 普通单击操作
     * @param locator 元素locator
     */
    public void click(Locator locator) {
        try {
            WebElement webElement = findElement(locator);
            webElement.click();
            log.info("click元素：" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":" + locator.getElement()
                    + "]成功！");
        } catch (NoSuchElementException e) {
            log.error("找不到元素，click失败:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @param locator 元素信息
     * @Description:通过js方法点击元素,locator定位元素
     * @return: void
     * @throws:
     */
    public void clickByJS(Locator locator) {
        try {
            WebElement webElement = findElement(locator);
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
            log.info("click元素：" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":" + locator.getElement() + "]成功！");
        } catch (NoSuchElementException e) {
            log.error("找不到元素，click失败:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @param string 元素的xpath
     * @Description:通过js方法点击元素,String定位元素
     * @return: void
     * @throws:
     */
    public void clickByJS(String string) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement webElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(string)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        } catch (NoSuchElementException e) {
            log.error("找不到元素，click失败:" + "]");
            e.printStackTrace();
            throw e;
        }
    }

    public void clickVisibilityOfElement(String string) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(string)));
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", webElement);
        } catch (Exception e) {
            log.error("找不到元素，click失败:" + "]");
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * @param: [string]
     * @return: void
     * @Description: 普通单击操作
     * @throws:
     */
    public void click(String string) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<WebElement>) webDriver -> webDriver.findElement(By.xpath(string))).click();
    }

    public void clickByWebDriverWait(Locator locator) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until((ExpectedCondition<WebElement>) webDriver -> {
            WebElement webElement = findElement(locator);
            return webElement;
        }).click();
    }

    /**
     * 选择下拉框操作
     * @param locator 元素locator
     * @param text    选择下拉值
     */
    public void selectByText(Locator locator, String text) {
        try {
            WebElement webElement = findElement(locator);
            Select select = new Select(webElement);
            log.info("选择select标签：" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            try {
                // select.selectByValue(value);
                select.selectByVisibleText(text);
                log.info("选择下拉列表项：" + text);

            } catch (NoSuchElementException notByValue) {
                log.info("找不到下拉值，选择下拉列表项失败 " + text);
                throw notByValue;
            }
        } catch (NoSuchElementException e) {
            log.error("找不到元素，选择select标签失败:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            throw e;
        }
    }

    /**
     * 选择下拉框操作
     * @param locator 元素locator
     * @param value   要选择的元素对应的value值
     */
    public void selectByValue(Locator locator, String value) {
        Select select;
        try {
            WebElement webElement = findElement(locator);
            select = new Select(webElement);
            log.info("选择select标签:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
        } catch (NoSuchElementException e) {
            log.error("找不到元素，选择select标签失败:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            throw e;
        }
        try {
            select.selectByValue(value);
            log.info("选择下拉列表项：" + value);
        } catch (NoSuchElementException notByValue) {
            log.info("找不到下拉值，选择下拉列表项失败 " + value);
            throw notByValue;
        }
    }

    /**
     * 通过下拉列表的index选择元素
     * @param locator
     * @param index   要选择的元素的序号
     */
    public void selectByIndex(Locator locator, int index) {
        Select select;
        try {
            WebElement webElement = findElement(locator);
            select = new Select(webElement);
            log.info("选择select标签:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
        } catch (NoSuchElementException e) {
            log.error("找不到元素，选择select标签失败" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            throw e;
        }
        try {
            select.selectByIndex(index);
            log.info("选择下拉列表项：" + index);

        } catch (NoSuchElementException notByindex) {
            log.info("找不到下拉值，选择下拉列表项失败 " + index);
            throw notByindex;
        }
    }

    /**
     * 获取下拉列表的value属性值
     * @param selectLocator 下拉列表 select标签定位信息
     * @param optinText     下拉列表文本值
     * @return 返回String
     */
    public String getSelectOptionValue(Locator selectLocator, String optinText) {
        WebElement webElement = driver
                .findElement(By.xpath(selectLocator.getElement() + "//option[text()='" + optinText + "']"));
        return webElement.getAttribute("value");
    }

    /**
     * @param: [selectLocator, 下拉框元素 optinValue 属性值]
     * @return: java.lang.String 返回下拉列表中 optionvalue 属性值
     * @Description: 返回optionvalue属性值
     * @throws:
     */
    public String getSelectOptionText(Locator selectLocator, String optinValue) {
        WebElement webElement = driver
                .findElement(By.xpath(selectLocator.getElement() + "//option[text()='" + optinValue + "']"));
        return webElement.getText();
    }

    /**
     * 随机获取select列表中某个option
     * @param: [locator] 下拉框
     * @return: int 下拉框中option的个数
     * @throws:
     */
    public int getOption(Locator locator) {
        Select select = new Select(findElement(locator));
        List<WebElement> webElements = select.getOptions();
//        List<String> downs = new ArrayList<>();
//        for (WebElement webElement : webElements
//        ) {
//            downs.add(webElement.getText());
//        }
        int num = webElements.size();
        Random random = new Random();
        return random.nextInt(num - 1) + 1;
    }

    /**
     * 点击确认按钮
     */
    public void alertConfirm() {
        Alert alert = driver.switchTo().alert();
        try {
            alert.accept();
            log.info("点击确认按钮");
        } catch (NoAlertPresentException notFindAlert) {
            log.error("找不到确认按钮");
            throw notFindAlert;
        }
    }

    /**
     * 点击取消按钮
     */
    public void alertDismiss() {
        Alert alert = driver.switchTo().alert();
        try {
            alert.dismiss();
            log.info("点击取消按钮");
        } catch (NoAlertPresentException notFindAlert) {
            log.error("找不到取消按钮");
            throw notFindAlert;
        }
    }

    /**
     * 获取对话框文本
     * @return 返回String
     */
    public String getAlertText() {
        Alert alert = driver.switchTo().alert();
        try {
            String text = alert.getText().toString();
            log.info("获取对话框文本：" + text);
            return text;
        } catch (NoAlertPresentException notFindAlert) {
            log.error("找不到对话框");
            throw notFindAlert;
        }
    }

    /**
     * 鼠标悬停操作
     * @param locator 元素locator
     */
    public void clickAndHold(Locator locator) {
        WebElement webElement = findElement(locator);
        Actions actions = new Actions(driver);
        actions.clickAndHold(webElement).perform();
    }

    /**
     * 鼠标左键单击,通过locator定位需要点击的元素
     * @param locator 元素locator
     */
    public void click_left(Locator locator) {
        WebElement webElement = findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(webElement).click().perform();
        log.info("click" + webElement.getText() + "suc");
    }

    /**
     * 鼠标右键操作
     * @param locator 元素locator
     */
    public void click_right(Locator locator) {
        WebElement webElement = findElement(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(webElement).perform();
        // actions.perform();
    }

    /**
     * 鼠标双击操作
     * @param locator 元素locator
     */
    public void click_double(Locator locator) {
        WebElement webElement = findElement(locator);
        Actions actions = new Actions(driver);
        actions.doubleClick(webElement).perform();
        // actions.perform();

    }

    /**
     * 清除文本框内容
     * @param locator 元素locator
     */
    public void clear(Locator locator) {
        try {
            WebElement webElement = findElement(locator);
            webElement.clear();
            log.info("清除input值:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":" + locator.getElement()
                    + "]");
        } catch (Exception e) {
            log.error("清除input值失败:" + locator.getLocalorName() + "[" + "By." + locator.getBy() + ":"
                    + locator.getElement() + "]");
            throw e;
        }
    }

    /**
     * 切换frame/iframe框架
     * @param locator 元素locator
     */
    public void switchToFrame(Locator locator) {
        WebElement frameElement = findElement(locator);
        driver.switchTo().frame(frameElement);
        log.info("切换frame成功");
    }

    /**
     * 切回默认窗口框架
     */
    public void switchToDefaultFrame() {
        driver.switchTo().defaultContent();
    }

    /**
     * 多窗口切换
     * @param i 第几个窗口
     */
    public void switchToWindow(int i) {
        String[] handls = new String[driver.getWindowHandles().size()];
        driver.getWindowHandles().toArray(handls);
        driver.switchTo().window(handls[i]);
    }

    /**
     * 隐式等待
     * @param t 最大等待时间，秒为单位
     **/
    public void Waitformax(int t) {
        driver.manage().timeouts().implicitlyWait(t, TimeUnit.SECONDS);
    }

    /**
     * 获取元素文本
     * @param locator 元素locator
     */
    public String getText(Locator locator) {
        WebElement webElement = findElement(locator);
        String text = webElement.getText();
        return text;
    }

    /**
     * @param: [locator] 被操作的元素
     * @return: java.lang.String 元素的值
     * @Description: 通过js方法获取元素的值
     * @throws:
     */
    public String getTextByJS(Locator locator) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement webElement = findElement(locator);
        String value = (String) js.executeScript("return arguments[0].value;", webElement);
        return value;
    }

    /**
     * 获取元素某属性的值
     * @param locator       元素locator
     * @param attributeName
     * @return 返回String
     */
    public String getAttribute(Locator locator, String attributeName) {
        WebElement webElement = findElement(locator);
        String value = webElement.getAttribute(attributeName);
        return value;
    }

    public String getAttribute(WebElement element, String attributeName) {
        String value = element.getAttribute(attributeName);
        return value;
    }

    /**
     * 获取当前url
     * @return
     */
    public String getUrl() {
        String url = driver.getCurrentUrl();
        return url;
    }

    /**
     * 获取当前网页标题
     * @return 返回String
     */
    public String getTitle() {
        String title = driver.getTitle();
        return title;
    }

    /**
     * 截屏方法
     * @param FileDriver 文件保存路径
     * @param Filename   文件名
     * @throws Exception 抛出Exception异常
     */
    public void Snapshot(String FileDriver, String Filename) throws Exception {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(scrFile, new File(FileDriver + Filename));
            System.out.println("错误截图：" + FileDriver + Filename);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    /**
     * 显式等待，程序休眠暂停
     * @param time 以秒为单位
     */
    public void sleep(long time) {
        try {
            Thread.sleep(time * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 显式等待 判断页面是否完全加载完成
     * @param time 已秒为单位
     */
    public void pagefoload(long time) {
        ExpectedCondition<Boolean> pageLoad = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait = new WebDriverWait(driver, time * 1000);
        wait.until(pageLoad);
    }

    public void executeJS(String js) {
        ((JavascriptExecutor) driver).executeScript(js);
        System.out.println("执行JS脚本：" + js);

    }

    /**
     * 使用JS滚动到该元素，当页面过长,当前页面上没有展示出该元素时,可使用此方法移动到制定元素
     * @param locator
     */
    public void moveToElement(Locator locator) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement webElement = findElement(locator);
        jse.executeScript("arguments[0].scrollIntoView()", webElement);
    }

    /**
     * 判断yi组元素是否存在
     * @param locator 一组元素定位信息
     * @param timeOut 超时时间 秒
     * @return 返回boolean true存在，false不存在
     * @throws InterruptedException
     */
    public boolean isElementsPresent(Locator locator, int timeOut) throws InterruptedException {
        log.info("等待" + timeOut + "秒判断元素：" + locator.getElement() + "是否存在");
        boolean isPresent = false;
        Thread.sleep(timeOut * 1000);
        List<WebElement> we = findElements(locator);
        if (we.size() != 0) {
            isPresent = true;
        }
        log.info("判断结果为：" + isPresent);
        return isPresent;
    }

    /**
     * 判断元素是否显示
     * @param locator 元素定位信息
     * @return 返回boolean true显示，false隐藏
     */
    public boolean isElementDisplayedByLocator(Locator locator) {
        ElementAction action = new ElementAction();
        WebElement webElement = action.findElement(locator);
        webElement.isEnabled();
        boolean flag = webElement.isDisplayed();
        return flag;
    }

    /**
     * 等待10秒让元素可见
     * @param locator
     */
    public void displayElement(String locator) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(locator)));
    }

    /**
     * 等待30s,等待元素出现
     * @param webElement 需要等待的元素对象
     * @return: void
     * @throws:
     */
    public void visibilityOfElement(WebElement webElement) {
        WebDriverWait webDriverWait = new WebDriverWait(driver, 30);
        webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    }

    /**
     * 实现翻页功能，当总数大于当前展示的数量时，执行翻页的操作
     * @param locator1 总数量的定位信息
     * @param locator2 翻页按钮的定位信息
     */
    public void getPageCountFlip(Locator locator1, Locator locator2) {
        WebElement tableInfoElement = findElement(locator1);
        String pageText = tableInfoElement.getText();
        if (Integer.valueOf(pageText.trim()) > 20) {
            WebElement lastpage = findElement(locator2);
            lastpage.click();
        }
    }

    public void highlightElementByLocator(Locator locator) {
        WebElement element = findElement(locator);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("element = arguments[0];" +
                "original_style = element.getAttribute('style');" +
                "element.setAttribute('style', original_style + \";" +
                "background: yellow; border: 2px solid red;\");" +
                "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
    }

    public void highlightElementByXpath(String xpath) {
        WebElement element = driver.findElement(By.xpath(xpath));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("element = arguments[0];" +
                "original_style = element.getAttribute('style');" +
                "element.setAttribute('style', original_style + \";" +
                "background: yellow; border: 2px solid red;\");" +
                "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
    }

    /**
     * Description:高亮显示某元素
     * @param element 需要高亮的元素对象
     * @return: void
     * @throws:
     */
    public void highlightElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("element = arguments[0];" +
                "original_style = element.getAttribute('style');" +
                "element.setAttribute('style', original_style + \";" +
                "background: yellow; border: 2px solid red;\");" +
                "setTimeout(function(){element.setAttribute('style', original_style);}, 1000);", element);
    }

    /**
     * Description:返回指定值的元素对象
     * @param elementValue	字段值
     * @return: org.openqa.selenium.WebElement
     * @throws:
     */
    public WebElement getElementByValue(String elementValue){
      return driver.findElement(By.xpath(".//*[contains(text(),'" + elementValue + "')]"));
    }
}
