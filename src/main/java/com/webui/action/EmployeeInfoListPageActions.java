package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.EmployeeInfoListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author the2n
 * @description 职工个人基本信息页面上相关的操作
 * @Data 2018/12/05 13:57
 */
public class EmployeeInfoListPageActions extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DefultPageActions defultPageActions = new DefultPageActions();
    DefultPage defultPage = new DefultPage();
    EmployeeInfoListPage employeeInfoListPage = new EmployeeInfoListPage();

    /**
     * @param: []
     * @return: void
     * @Description: 切换页面
     * @throws:
     */
    public void modifyMenu() throws IOException {
        defultPageActions.openMenu(defultPage.fzgl(), defultPage.zyws(), defultPage.employeeInfoList());
        elementAction.switchToFrame(employeeInfoListPage.iframe_employeeInfoList());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 点击查询按钮
     * @throws:
     */
    private void doSearch() throws IOException {
        elementAction.sleep(1);
        elementAction.click_left(employeeInfoListPage.search_Button());
        elementAction.sleep(1);
    }

    /**
     *
     *@param: []
     *@return: void
     *@Description: 点击重置按钮,重置查询条件
     *@throws: 
     */
    public void doReset() throws IOException {
        elementAction.sleep(1);
        elementAction.click_left(employeeInfoListPage.reload_Button());
        elementAction.sleep(1);
    }

    /**
     * @param: [fileNo 档案号]
     * @return: void
     * @Description: 很具档案号执行查询操作
     * @throws:
     */
    public void searchByFileNo(String fileNo) throws IOException {
        elementAction.type(employeeInfoListPage.search_fileNo_textarea(), fileNo);
        doSearch();
    }

    /**
     *
     *@param: [postNumber 在岗编号]
     *@return: void
     *@Description: 根据在岗编号执行查询操作
     *@throws: 
     */
    public void searchByPostNumber(String postNumber) throws IOException {
      elementAction.type(employeeInfoListPage.search_postNumber_textarea(),postNumber);
      doSearch();
    }

    /**
     *
     *@param: [retireNumber 退休编号]
     *@return: void
     *@Description: 根据退休编号执行查询操作
     *@throws:
     */
    public void searchByRetireNumber(String retireNumber) throws IOException {
      elementAction.type(employeeInfoListPage.search_retireNumber_textarea(),retireNumber);
      doSearch();
    }

    /**
     *
     *@param: [name 姓名]
     *@return: void
     *@Description: 根据姓名执行查询操作
     *@throws:
     */
    public void searchByName(String name) throws IOException {
      elementAction.type(employeeInfoListPage.search_name_textarea(),name);
      doSearch();
    }

    /**
     *
     *@param: [cardNumber 身份证号]
     *@return: void
     *@Description: 根据身份证号执行查询操作
     *@throws: 
     */
    public void searchByCardNumber(String cardNumber) throws IOException {
      elementAction.type(employeeInfoListPage.search_cardNumber_textarea(),cardNumber);
      doSearch();
    }
    public int getTempNum() {
        return tempNum;
    }

    public void setTempNum(int tempNum) {
        this.tempNum = tempNum;
    }

    public int tempNum;

    /**
     *
     *@param: [fieldStr 需要获取值的字段]
     *@return: java.util.List<java.lang.String> 数据列表, text
     *@Description: 获取查询结果中指定字段值
     *@throws:
     */
    public List<String> getSearchData(String fieldStr) throws IOException {
        List<String> dataList = new ArrayList<>();
        switch (fieldStr) {
            case "档案号":
                if (elementAction.isElementDisplayedByLocator(employeeInfoListPage.data_tbody())) {
                    List<WebElement> fileNoElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='fileNo']/div"));
                    tempNum = fileNoElements.size();
                    for (int j = 0; j < fileNoElements.size(); j++) {
                        dataList.add(fileNoElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "在岗编号":
                if (elementAction.isElementDisplayedByLocator(employeeInfoListPage.data_tbody())) {
                    List<WebElement> postNumberElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='postNumber']/div"));
                    tempNum = postNumberElements.size();
                    for (int j = 0; j < postNumberElements.size(); j++) {
                        dataList.add(postNumberElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "退休编号":
                if (elementAction.isElementDisplayedByLocator(employeeInfoListPage.data_tbody())) {
                    List<WebElement> retireNumberElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='retireNumber']/div"));
                    tempNum = retireNumberElements.size();
                    for (int j = 0; j < retireNumberElements.size(); j++) {
                        dataList.add(retireNumberElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "姓名":
                if (elementAction.isElementDisplayedByLocator(employeeInfoListPage.data_tbody())) {
                    List<WebElement> nameElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='name']/div"));
                    tempNum = nameElements.size();
                    for (int j = 0; j < nameElements.size(); j++) {
                        dataList.add(nameElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "身份证号":
                if (elementAction.isElementDisplayedByLocator(employeeInfoListPage.data_tbody())) {
                    List<WebElement> cardNumberElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='cardNumber']/div"));
                    tempNum = cardNumberElements.size();
                    for (int j = 0; j < cardNumberElements.size(); j++) {
                        dataList.add(cardNumberElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
        }
        return dataList;
    }
}
