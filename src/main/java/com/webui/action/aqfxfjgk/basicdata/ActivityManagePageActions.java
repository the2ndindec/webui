package com.webui.action.aqfxfjgk.basicdata;

import com.webui.action.DefultPageActions;
import com.webui.pageObject.ActivityManagePage;
import com.webui.pageObject.DefultPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author the2n
 * @Description:作业管理页面相关方法
 * @Data 2018/12/26 15:02
 */
public class ActivityManagePageActions extends TestBaseCase {

    ElementAction ea = new ElementAction();
    DefultPageActions dpa = new DefultPageActions();
    DefultPage dp = new DefultPage();
    ActivityManagePage amp = new ActivityManagePage();

    FunctionUtil functionUtil = new FunctionUtil();
    /**
     * 格式化日期作为参数使用
     */
    public String dataStr = functionUtil.formatterDate("yyyyMMddHHmmss");


    /**
     * Description:切换frame
     * @param locator 需要切换的frame
     * @return: void
     * @throws:
     */
    public void modifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.visibilityOfElement(ea.findElement(locator));
        ea.switchToFrame(locator);
    }

    /**
     * Description:打开作业管理页面
     * @param
     * @return: void
     * @throws:
     */
    public void modifyMenu() throws IOException {
        dpa.openMenu(dp.aqfxfjgk_menu(), dp.jcsjgl_li(), dp.activityList());
        ea.switchToFrame(amp.iframe_activity());
    }

    /**
     * Description:录入作业活动
     * @param activityStr 作业活动字段
     * @return: void
     * @throws:
     */
    public void addActivity(String activityStr) throws IOException {
        ea.clickByJS(amp.add_Button());
        modifyFrame(amp.iframe_addOrUpdate()); //切换到录入弹窗
        ea.typeByJS(amp.activityName_area(), activityStr + dataStr);
        ea.switchToDefaultFrame();
        ea.clickByJS(amp.confirm_btn());
        ea.switchToFrame(amp.iframe_activity());
    }

    /**
     * Description:通过getActivityValue方法获取当前页面上已存在的作业活动，输入其中一个值
     * @param
     * @return: void
     * @throws:
     */
    public void addDupActivity() throws IOException {
        String activityStr = getActivityValue().get(functionUtil.random(getActivityValue().size()));
        ea.clickByJS(amp.add_Button());
        modifyFrame(amp.iframe_addOrUpdate()); //切换到录入弹窗
        ea.typeByJS(amp.activityName_area(), activityStr);
        ea.fireEventBlur(amp.activityName_area());//输入值后让该元素失去焦点，显示错误信息
    }

    /**
     * Description:根据作业名称执行查询
     * @param activityStr 查询的字符串
     * @return: void
     * @throws:
     */
    public void searchActivity(String activityStr) throws IOException {
        ea.typeByJS(amp.activityName_search_area(), activityStr);
        ea.clickByJS(amp.search_Button());

    }

    public String valueOfChooseActivity; //被选择的作业活动的值

    /**
     * Description:通过getActivityElement方法获取当前页面上随机一条作业活动数据，查看数据详情
     * @param
     * @return: void
     * @throws:
     */
    public void detailOfActivity() throws IOException {
        element = getActivityElement();
        element.click();
        valueOfChooseActivity = element.getText();
        ea.clickByJS(amp.detail_Button());
        modifyFrame(amp.iframe_addOrUpdate());
    }
    public void closeDetail() throws IOException {
      ea.switchToDefaultFrame();
      ea.clickByJS(amp.close_btn());
    }

    /**
     * Description:删除指定的作业活动。
     * @param activityStr	需要删除的数据的字段值
     * @return: void
     * @throws:
     */
    public void deleteActivityByValue(String activityStr) throws IOException {
        modifyFrame(amp.iframe_activity());
        getActivityElementByValue(activityStr).click();
        /**
         *  通过tempNum方法返回指定字段的行数，定位该数据所在行的删除按钮
         */
        ea.clickByJS(".//div[@class='datagrid-view2']/div[2]//tbody/tr["+tempNum(activityStr)+"]/td[@field='opt']//a[1]");
        ea.clickByJS(amp.del_confirm());
        /**
         * 删除查询条件
         */
        ea.clear(amp.activityName_search_area());
    }


    /**
     * Description:获取当前页面上作业活动字段值的集合
     * @param
     * @return: java.util.List<java.lang.String>
     * @throws:
     */
    public List<String> getActivityValue() throws IOException {
        List<String> activityList = new ArrayList<>();
        if (ea.isElementDisplayedByLocator(amp.data_tbody())) {//判断列表中是否存在数据
            List<WebElement> activityValueElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activityName']/div"));
            for (WebElement activityValueElement : activityValueElements) {
                activityList.add(activityValueElement.getText());
            }
        } else {
            log.info("暂无相关数据信息");
        }
        return activityList;
    }

    private List<WebElement> activityElements;
    private WebElement element;

    /**
     * Description:随机获取当前页面上一条作业活动数据
     * @param
     * @return: void
     * @throws:
     */
    public WebElement getActivityElement() throws IOException {
        if (ea.isElementDisplayedByLocator(amp.data_tbody())) {//判断列表中是否存在数据
            activityElements = driver.findElements(By.xpath(".//div[@class='datagrid-body']//td[@field='activityName']"));
            element = activityElements.get(functionUtil.random(activityElements.size()));
        } else {
            log.info("暂无相关数据信息");
        }
        return element;
    }

    /**
     * Description:返回指定值的元素对象
     * @param activityStr 字段值
     * @return: org.openqa.selenium.WebElement
     * @throws:
     */
    public WebElement getActivityElementByValue(String activityStr) {
        return driver.findElement(By.xpath(".//*[contains(text(),'" + activityStr + "')]"));
    }

    public int temp;

    public int tempNum(String activityStr) {

        List<WebElement> activityValueElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activityName']/div"));
        for (temp = 1; temp < activityValueElements.size(); temp++) {
            WebElement acElement = driver.findElement(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr[" + temp + "]/td[@field='activityName']/div"));
            if (acElement.getText().equalsIgnoreCase(activityStr)) {
                temp = temp;
                break;
            }
        }
        return temp;
    }
}
