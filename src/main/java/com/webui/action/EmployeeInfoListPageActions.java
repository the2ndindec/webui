package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.EmployeeInfoListPage;
import com.webui.utils.*;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
    FunctionUtil functionUtil = new FunctionUtil();
    IdCardGenerator idCardGenerator = new IdCardGenerator();

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
     * @param: []
     * @return: void
     * @Description: 点击重置按钮, 重置查询条件
     * @throws:
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
     * @param: [postNumber 在岗编号]
     * @return: void
     * @Description: 根据在岗编号执行查询操作
     * @throws:
     */
    public void searchByPostNumber(String postNumber) throws IOException {
        elementAction.type(employeeInfoListPage.search_postNumber_textarea(), postNumber);
        doSearch();
    }

    /**
     * @param: [retireNumber 退休编号]
     * @return: void
     * @Description: 根据退休编号执行查询操作
     * @throws:
     */
    public void searchByRetireNumber(String retireNumber) throws IOException {
        elementAction.type(employeeInfoListPage.search_retireNumber_textarea(), retireNumber);
        doSearch();
    }

    /**
     * @param: [name 姓名]
     * @return: void
     * @Description: 根据姓名执行查询操作
     * @throws:
     */
    public void searchByName(String name) throws IOException {
        elementAction.type(employeeInfoListPage.search_name_textarea(), name);
        doSearch();
    }

    /**
     * @param: [cardNumber 身份证号]
     * @return: void
     * @Description: 根据身份证号执行查询操作
     * @throws:
     */
    public void searchByCardNumber(String cardNumber) throws IOException {
        elementAction.type(employeeInfoListPage.search_cardNumber_textarea(), cardNumber);
        doSearch();
    }

    /**
     * @param: []
     * @return: void
     * @Description: 点击录入按钮, 打开录入界面
     * @throws:
     */
    public void goAdd() throws IOException {
        elementAction.click_left(employeeInfoListPage.add_Button());
        swFrame(employeeInfoListPage.iframe_goAdd());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 档案号不输入内容, 用于验证该字段是否可以为空
     * @throws:
     */
    public void setfileNo() throws IOException {
        elementAction.type(employeeInfoListPage.fileNo_textarea(), "");
        elementAction.fireEventBlur(employeeInfoListPage.fileNo_textarea());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 在岗编号不输入内容, 用于验证该字段是否可以为空
     * @throws:
     */
    public void setPostNumber() throws IOException {
        elementAction.type(employeeInfoListPage.postNumber_textarea(), "");
        elementAction.fireEventBlur(employeeInfoListPage.fileNo_textarea());
    }

    /**
     * 输入档案号
     *
     * @param: [fildNo 档案号值]
     * @return: void
     * @throws:
     */
    public void typefileNo(String fildNo) throws IOException {
        elementAction.type(employeeInfoListPage.fileNo_textarea(), fildNo);
        elementAction.fireEventBlur(employeeInfoListPage.fileNo_textarea());
    }

    /**
     * @param: [postNumber 在岗编号]
     * @return: void
     * @Description: 输入在岗编号
     * @throws:
     */
    public void typePostNumber(String postNo) throws IOException {
        elementAction.type(employeeInfoListPage.postNumber_textarea(), postNo);
        elementAction.fireEventBlur(employeeInfoListPage.fileNo_textarea());
    }

    /**
     * 输入退休编号
     *
     * @param retireNo 退休编号
     * @return: void
     * @throws:
     * @Date:2018/12/6 11:33
     */
    public void typeRetireNumber(String retireNo) throws IOException {
        elementAction.type(employeeInfoListPage.retireNumber_textarea(), retireNo);
    }

    /**
     * 选择职工性别
     *
     * @param
     * @return: void
     * @throws:
     * @Date:2018/12/6 11:43
     */
    public void selectGender() throws IOException {
        if (functionUtil.getI() == 2) {
            elementAction.selectByValue(employeeInfoListPage.gender_textarea(), "1");
        } else {
            elementAction.selectByValue(employeeInfoListPage.gender_textarea(), "0");
        }
    }

    /**
     * 输入姓名
     *
     * @param name 姓名
     * @return: void
     * @throws:
     * @Date:2018/12/6 11:41
     */
    public void typeName(String name) throws IOException {
        elementAction.type(employeeInfoListPage.name_textarea(), name);
    }

    /**
     * 输入身份证号码
     *
     * @param cardNo 身份证号码
     * @return: void
     * @throws:
     * @Date:2018/12/6 11:47
     */
    public void typeCardNumber(String cardNo) throws IOException {
        elementAction.type(employeeInfoListPage.cardNumber_textarea(), cardNo);
    }

    /**
     * 输入参加工作时间
     *
     * @param workdate 工作时间, 格式为:%y-%M-%d
     * @return: void
     * @throws:
     * @Date:2018/12/6 13:09
     */
    public void typePartiWorkDate(String workdate) throws IOException {
        elementAction.type(employeeInfoListPage.partiWorkDate_textarea(), workdate);
    }

    /**
     * 输入现工作单位
     *
     * @param workUnits 工作单位
     * @return: void
     * @throws:
     * @Date:2018/12/6 13:12
     */
    public void typeCurrWorkUnits(String workUnits) throws IOException {
        elementAction.type(employeeInfoListPage.currWorkUnits_textarea(), workUnits);
    }

    /**
     * 输入现从事工种
     *
     * @param currTrade 从事工种
     * @return: void
     * @throws:
     * @Date:2018/12/6 13:14
     */
    public void typeCurrTrade(String currTrade) throws IOException {
        elementAction.type(employeeInfoListPage.currTrade_textarea(), currTrade);
    }

    /**
     * 输入接触职业危害种类
     *
     * @param jobHazardCategory 接触职业危害种类
     * @return: void
     * @throws:
     * @Date:2018/12/6 13:15
     */
    public void typeJobHazardCategory(String jobHazardCategory) throws IOException {
        elementAction.type(employeeInfoListPage.jobHazardCategory_textarea(), jobHazardCategory);
    }

    /**
     * 选择岗位类别
     *
     * @param
     * @return: void
     * @throws:
     */
    public void selectPostCategory() throws IOException {
        elementAction.selectByValue(employeeInfoListPage.postCategory_textarea(), "1"); //1表示管理岗,2表示工人岗
    }

    /**
     * 选择岗位状态
     *
     * @param
     * @return: void
     * @throws:
     */
    public void selectPostStatus() throws IOException {
        elementAction.selectByValue(employeeInfoListPage.postStatus_textarea(), "1");//1表示在岗,2表示在职离岗,3表示离岗
    }

    /**
     * 点击确定按钮
     *
     * @param
     * @return: void
     * @throws:
     */
    public void doConfirm() throws IOException {
        elementAction.switchToDefaultFrame();
        elementAction.click_left(employeeInfoListPage.confirm_btn());
    }

    /**
     * 点击关闭按钮
     *
     * @param
     * @return: void
     * @throws:
     */
    public void doClose() throws IOException {
        elementAction.switchToDefaultFrame();
        elementAction.click_left(employeeInfoListPage.close_btn());
    }

    /**
     * 点击取消按钮
     *
     * @param
     * @return: void
     * @throws:
     */
    public void doCancel() throws IOException {
        elementAction.switchToDefaultFrame();
        elementAction.click_left(employeeInfoListPage.cancel_btn());
    }

    /**
     * @param: [locator iframe对象信息]
     * @return: void
     * @Description: 切换iframe
     * @throws:
     */
    public void swFrame(Locator locator) {
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(locator);
    }


    public int getTempNum() {
        return tempNum;
    }

    public void setTempNum(int tempNum) {
        this.tempNum = tempNum;
    }

    public int tempNum;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //生成姓名
    private String name = functionUtil.generatorName();

    public String getIdNo() {
        return idNo;
    }

    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }

    // 生成身份证号码
    private String idNo = idCardGenerator.getRandomID();
    // 生成时间
    private String dateString = functionUtil.formatterDate("yyyyMMdd");

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }


    /**
     * @param: [fieldStr 需要获取值的字段]
     * @return: java.util.List<java.lang.String> 数据列表, text
     * @Description: 获取查询结果中指定字段值
     * @throws:
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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    //生成随机四位数
    private String number = generateNum();

    //生成随机四位数
    public static String generateNum() {
        return RandomStringUtils.random(4, "0123456789");
    }

}
