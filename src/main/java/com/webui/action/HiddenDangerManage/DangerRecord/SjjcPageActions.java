package com.webui.action.HiddenDangerManage.DangerRecord;

import com.webui.pageObject.SjjcPage;
import com.webui.utils.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author the2n
 * @date 2019/01/25 11:38
 */
public class SjjcPageActions extends TestBaseCase {

    SjjcPage sjjcp = new SjjcPage();
    ElementAction ea = new ElementAction();
    FunctionUtil functionUtil = new FunctionUtil();
    ReadProperties rp = new ReadProperties();
    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";

    public void motifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.switchToFrame(locator);
    }

    /**
     * 切换页面，
     * @param btnLocator
     * @param frameLocator
     */
    public void switchPage(Locator btnLocator, Locator frameLocator) {
        ea.clickByJS(btnLocator);
        ea.sleep(1);
        motifyFrame(frameLocator);
    }


    /**
     * 根据开始时间查询数据。需输入正确格式的日期，2019-01-25.否则不会按照输入的日期进行查询
     * @param dateStr
     * @throws IOException
     */
    public void searchByexamDateBegin(String dateStr) throws IOException {
        /**isValidDate()方法判断输入的日期格式是否为正确的格式*/
        if (functionUtil.isValidDate(dateStr)) {
            ea.typeByJS(sjjcp.examDate_begin_area(), dateStr);
            ea.clickByJS(sjjcp.search_Button());
        } else {
            log.warn("输入的日期：【" + dateStr + "】格式不正确");
        }
    }

    /**
     * 根据结束时间查询数据。需输入正确格式的日期，2019-01-25.否则不会按照输入的日期进行查询
     * @param dateStr
     * @throws IOException
     */
    public void searchByexamDateEnd(String dateStr) throws IOException {
        /**isValidDate()方法判断输入的日期格式是否为正确的格式*/
        if (functionUtil.isValidDate(dateStr)) {
            ea.typeByJS(sjjcp.examDate_end_area(), dateStr);
            ea.clickByJS(sjjcp.search_Button());
        } else {
            log.warn("输入的日期：【" + dateStr + "】格式不正确");
        }
    }

    /**
     * 根据输入的时间段查询数据。需输入正确格式的日期，2019-01-25.否则不会按照输入的日期进行查询
     * @param begindate
     * @param endDate
     * @throws IOException
     * @throws ParseException
     */
    public void searchByexamDate(String begindate, String endDate) throws IOException, ParseException {
        /**
         * isValidDate()方法判断输入的日期格式是否为正确的格式
         * compareTime()方法用于比较输入的时间段是否正确
         */
        if (functionUtil.isValidDate(begindate) && functionUtil.isValidDate(endDate)) {
            if (functionUtil.compareTime(begindate, endDate)) {
                ea.typeByJS(sjjcp.examDate_begin_area(), begindate);
                ea.typeByJS(sjjcp.examDate_end_area(), endDate);
                ea.clickByJS(sjjcp.search_Button());
            } else {
                log.warn("输入的时间段错误。输入的开始时间为：【" + begindate + "】，输入的结束时间为：【" + endDate + "】");
            }
        } else {
            if (functionUtil.isValidDate(begindate))
                log.warn("输入的时间【" + begindate + "】格式不正确");
            if (functionUtil.isValidDate(endDate))
                log.warn("输入的时间【" + endDate + "】格式不正确");
        }
    }

    /**
     * 根据班次进行查询
     * @param shiftStr
     * @throws IOException
     */
    public void searchByShift(String shiftStr) throws IOException {
        ea.selectByText(sjjcp.shift_area(), shiftStr);
        ea.clickByJS(sjjcp.search_Button());
    }

    public void editExamDate() {

    }

    /**
     * 选择班次信息，1表示早班，2表示中班，3表示晚班
     * @param shift
     * @throws IOException
     */
    public void editShift(String shift) throws IOException {
        ea.clickByJS(sjjcp.shift_area());
        ea.selectByValue(sjjcp.shift_area(), shift);
    }

    /**
     * 随机选择班次
     * @throws IOException
     */
    public void editShift() throws IOException {
        ea.clickByJS(sjjcp.shift_area());
        ea.selectByValue(sjjcp.shift_area(), String.valueOf(functionUtil.random(3) + 1));
    }

    /**
     * 选择地点
     * @param address
     * @throws IOException
     */
    public void editAddress(String address) throws IOException {
        ea.clickByJS(sjjcp.magicsuggest());
        ea.clickByJS(".//*[@id='magicsuggest']//div[text()='" + address + "']");
    }

    /**
     * 编辑上级检查部门
     * @param dept
     * @throws IOException
     */
    public void editSjjcDept(String dept) throws IOException {
        ea.typeByJS(sjjcp.sjjcDept(), dept);
    }

    /**
     * 编辑检查人信息
     * @param sjjcCheckMan
     * @throws IOException
     */
    public void editsjjcCheckMan(String sjjcCheckMan) throws IOException {
        ea.typeByJS(sjjcp.sjjcCheckMan(), sjjcCheckMan);
    }

    /**
     * 选择危险源
     * @throws IOException
     */
    public void editDanger() throws IOException {
        ea.clickByJS(sjjcp.dangerName());
        motifyFrame(sjjcp.iframe_chooseDangerSource());
        chooseDataRand();
        ea.switchToDefaultFrame();
        ea.clickByJS(sjjcp.confirm_btn());  //选择危险源结束
        ea.switchToFrame(sjjcp.iframe_add());
    }

    /**
     * 选择责任单位
     * @param dutyUnit
     * @throws IOException
     */
    public void editDutyUnit(String dutyUnit) throws IOException {
        ea.clickByJS(sjjcp.dutyUnit());
        ea.clickByJS(".//*[@id='magicsuggestDutyUnitSel']//div[text()='" + dutyUnit + "']");
    }

    /**
     * 选择责任人
     * @param dutyMan
     * @throws IOException
     */
    public void editDutyMan(String dutyMan) throws IOException {
        ea.clickByJS(sjjcp.dutyMan());
        ea.clickByJS(".//*[@id='magicsuggestDutyMan']//div[text()='" + dutyMan + "']");
    }

    /**
     * 选择督办单位
     * @param SuperviseUnit
     * @throws IOException
     */
    public void editSuperviseUnit(String SuperviseUnit) throws IOException {
        ea.clickByJS(sjjcp.superviseUnit());
        ea.clickByJS(".//*[@id='magicsuggestSuperviseUnitSel']//div[text()='" + SuperviseUnit + "']");
    }

    /**
     * 选择督办人
     * @param SuperviseMan
     * @throws IOException
     */
    public void editSuperviseMan(String SuperviseMan) throws IOException {
        ea.clickByJS(sjjcp.superviseMan());
        ea.clickByJS(".//*[@id='magicsuggestSuperviseMan']//div[text()='" + SuperviseMan + "']");
    }

    /**
     * 选择隐患类别
     * @param hiddenCategory
     * @throws IOException
     */
    public void editHiddenCategory(String hiddenCategory) throws IOException {
        ea.clickByJS(sjjcp.hiddenCategory());
        ea.selectByText(sjjcp.hiddenCategory(), hiddenCategory);
    }

    /**
     * 选择隐患等级
     * @param hiddenNature
     * @throws IOException
     */
    public void editHiddenNature(String hiddenNature) throws IOException {
        ea.clickByJS(sjjcp.hiddenNature());
        ea.selectByText(sjjcp.hiddenNature(), hiddenNature);
    }

    /**
     * 选择隐患类型
     * @param hiddenType
     * @throws IOException
     */
    public void editHiddenType(String hiddenType) throws IOException {
        ea.clickByJS(sjjcp.hiddenType());
        ea.selectByText(sjjcp.hiddenType(), hiddenType);
    }

    /**
     * 编辑问题描述
     * @param problemDesc
     * @throws IOException
     */
    public void editProblemDesc(String problemDesc) throws IOException {
        if ((ea.getText(sjjcp.problemDesc())) == null)
            ea.typeByJS(sjjcp.problemDesc(), problemDesc);
    }

    /**
     * 编辑资金
     * @param fund
     * @throws IOException
     */
    public void editFund(String fund) throws IOException {
        ea.typeByJS(sjjcp.fund(), fund);
    }

    /**
     * 编辑预案
     * @param plan
     * @throws IOException
     */
    public void editPlan(String plan) throws IOException {
        ea.typeByJS(sjjcp.plan(), plan);
    }

    /**
     * 编辑备注
     * @param remark
     * @throws IOException
     */
    public void editRemark(String remark) throws IOException {
        ea.typeByJS(sjjcp.remark(), remark);
    }

    /**
     * 编辑期限日期
     * @param limitDate
     * @throws IOException
     */
    public void editLimitDate(String limitDate) throws IOException {
        if (functionUtil.isValidDate(limitDate)) {
            ea.typeByJS(sjjcp.limitDate(), limitDate);
        } else {
            log.warn("输入的时间【" + limitDate + "】格式不正确");
        }
    }

    /**
     * 选择处理方式为现场处理
     * @throws IOException
     */
    public void chooseDealType_xianchang() throws IOException {
        ea.clickByJS(sjjcp.dealType_xianchang());
    }

    /**
     * 选择复查人
     * @param reviewManName
     * @throws IOException
     */
    public void editReviewManName(String reviewManName) throws IOException {
        ea.clickByJS(sjjcp.reviewMan());
        ea.clickByJS(".//*[@id='reviewManNameSelect']//div[text()='" + reviewManName + "']");
    }

    /**
     * 整改措施
     * @param rectMeasures
     * @throws IOException
     */
    public void editRectMeasures(String rectMeasures) throws IOException {
        ea.typeByJS(sjjcp.rectMeasures(), rectMeasures);
    }

    /**
     * 复查情况
     * @param reviewReport
     * @throws IOException
     */
    public void editReviewReport(String reviewReport) throws IOException {
        ea.typeByJS(sjjcp.reviewReport(), reviewReport);
    }

    /**
     * 保存
     * @throws IOException
     */
    public void doDraft() throws IOException, InterruptedException {
        doCheckTips();
        ea.clickByJS(sjjcp.btn_draft());
    }

    /**
     * 此方法用于在提交或者保存前判断页面上必填内容是否存在空值的情况
     * 判断页面上是否有相应的提示信息
     * @throws InterruptedException
     * @throws IOException
     */
    public void doCheckTips() throws InterruptedException, IOException {
        while (ea.isElementsPresent(sjjcp.checkTip(), 1)) {
            List<WebElement> checkTips = ea.findElements(sjjcp.checkTip());
            if (checkTips.size() != 0) {
                for (WebElement tip : checkTips) {
                    String s = tip.getText();
                    switch (tip.getText()) {
                        case "请选择班次！":
                            editShift("1");
                            break;
                        case "请填写地点！":
                            editAddress("测试风险点1");
                            break;
                        case "请填写上级检查部门！":
                            editSjjcDept(rp.readPropertiesFile(filePath, "SjjcDept"));
                            break;
                        case "请填写责任单位！":
                            editDutyUnit("xx煤矿");
                            break;
                        case "请填写责任人！":
                            editDutyMan("管理员");
                            break;
                        case "请选择隐患类别！":
                            editHiddenCategory("隐患排查治理");
                            break;
                        case "请选择隐患等级！":
                            editHiddenNature("一般隐患B级");
                            break;
                        case "请选择隐患类型！":
                            editHiddenType("通风");
                            break;
                        case "请填写问题描述！":
                            editProblemDesc("aotu自动输入内容3");
                            break;
                        case "请填写限期日期！":
                            editLimitDate("2019-01-31");
                            break;
                    }
                }
            } else {
                log.info("未发现提示信息");
            }
        }
    }

    /**
     * 保存并上报
     * @throws IOException
     */
    public void doSubRep() throws IOException, InterruptedException {
        doCheckTips();
        ea.clickByJS(sjjcp.btn_subRep());
    }

    /**
     * 关闭.关闭当前界面
     * @throws IOException
     */
    public void doClose() throws IOException {
//        ea.clickByJS(sjjcp.close_btn());
        ea.clickByJS(".//div[@class='ui_buttons']/input[@id='btn_close']");
    }

    /**
     * 重置查询条件
     * @throws IOException
     */
    public void reset() throws IOException {
        ea.clear(sjjcp.examDate_begin_area());
        ea.clear(sjjcp.examDate_end_area());
        ea.resetSelect(sjjcp.shift_area());
    }


    /**
     * 针对当前页面上数据列表中的数据，随机选择一条数据
     */
    public void chooseDataRand() throws IOException {
        if (ea.isElementDisplayedByLocator(sjjcp.data_tbody())) {
            List<WebElement> dataList = ea.findElements(".//div[@class='datagrid-view2']/div[2]//tbody/tr");
            dataList.get(functionUtil.randomForElement(dataList.size())).click();
        } else {
            log.warn("暂无数据");
        }
    }

    /**
     * 选择指定字符串相关的数据
     * @param dataStr
     * @throws IOException
     */
    public void chooseData(String dataStr) throws IOException {
        if (ea.isElementDisplayedByLocator(sjjcp.data_tbody())) {
            List<WebElement> dataList = ea.findElements("");
            if (dataList.size() == 1) {
                dataList.get(0).click();
            } else if (dataList.size() > 1) {
                log.info("根据输入的字符串【" + dataStr + "】,查询到【" + dataList.size() + "】个相关的数据");
            } else {
                log.info("根据输入的字符串【" + dataStr + "】,未查询到相关的数据");
            }
        } else {
            log.warn("暂无数据");
        }
    }

    /**
     * 获取指定字符串的内容
     * @param fieldStr
     * @return
     * @throws IOException
     */
    public List<String> getSearchData(String fieldStr) throws IOException {
        List<String> dataList = new ArrayList<>();
        if (ea.isElementDisplayedByLocator(sjjcp.data_tbody())) {
            switch (fieldStr) {
                case "班次":
                    List<WebElement> shiftElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='shift']/div"));
                    for (int j = 0; j < shiftElements.size(); j++) {
                        dataList.add(shiftElements.get(j).getText());
                    }
                    break;

                case "日期":
                    List<WebElement> examDate = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='examDate']/div"));
                    for (int j = 0; j < examDate.size(); j++) {
                        dataList.add(examDate.get(j).getText());
                    }
                    break;
            }
        } else {
            log.info("根据查询条件>>无相关结果");
        }
        return dataList;
    }

    public Map<String, String> getDataMap() {
        return dataMap;
    }

    public void setDataMap(Map<String, String> dataMap) {
        this.dataMap = dataMap;
    }

    Map<String, String> dataMap = new HashMap<String, String>();

    public void viewDetail(String string) throws IOException {
        List<WebElement> elements = ea.getElementsByValue(string);
        if (elements.size() == 1) {
            elements.get(0).click();
            /**
             * 根据定位数据的所在行，查找相关列数据内容，即各字段及相关的内容值，已Map的形式存放
             * elementAction.getAttribute(headElements.get(i),"innerText") 获取Key值
             * elementAction.getAttribute(tdElements.get(i).findElement(By.tagName("div")),"innerText") 获取Value值
             * 其中 Elements.get(i) 表示第几列的内容
             */
            List<WebElement> headElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[1]//tbody/tr/td//span[1]"));
            List<WebElement> tdElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr[" + ea.getTrNum(string) + "]/td"));
            for (int i = 1; i < tdElements.size(); i++) {
                if ((FunctionUtil.replaceBlank((ea.getAttribute(driver.findElement(By.xpath(".//td[@field='reviewMan']")), "innerText"))).equalsIgnoreCase("复查人"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("隐患类别"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("下井时间开始"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("下井时间结束"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("限期班次"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("检查类型"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("创建人名称"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("创建人登录名称"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("创建日期"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("创建日期"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("更新人名称"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("更新人登录名称"))
                        || (FunctionUtil.replaceBlank((ea.getAttribute(headElements.get(i), "innerText"))).equalsIgnoreCase("更新日期")))
                    continue;
                String s1 = ea.getAttribute(headElements.get(i), "innerText");
                String s2 = ea.getAttribute(tdElements.get(i), "innerText");
                dataMap.put(ea.getAttribute(headElements.get(i), "innerText")
                        , ea.getAttribute(tdElements.get(i).findElement(By.tagName("div")), "innerText"));
            }
            ea.clickByJS(sjjcp.detail_Button());
            motifyFrame(sjjcp.iframe_update());
        } else if (elements.size() > 1) {
            log.warn("根据输入的字符串【" + string + "】找到" + elements.size() + "个对应的元素信息。不能执行查看操作！！");
        } else {
            log.warn("根据输入的字符串【" + string + "】未找到对应的元素信息。不能执行查看操作！！");
        }
    }
}
