package com.webui.action.aqfxfjgk.annualrisk;

import com.webui.action.DefultPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.DepartReportDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Features;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author the2n
 * @Description: 部门风险清单页面
 * @Data 2018/12/06 15:49
 */
public class DepartReportDangerListActions extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DefultPageActions defultPageActions = new DefultPageActions();

    DepartReportDangerListPage departReportDangerListPage = new DepartReportDangerListPage();
    DefultPage defultPage = new DefultPage();
    FunctionUtil functionUtil = new FunctionUtil();

    public void modifyMenu() throws IOException {
        defultPageActions.openMenu(defultPage.aqfxfjgk_menu(), defultPage.ndfxgl_list(), defultPage.departReportDangerList());
        elementAction.switchToFrame(departReportDangerListPage.iframe_departReportDangerList());
    }

    // 切换到主页面页面
    public void goDepartReportDangerList() throws IOException {
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(departReportDangerListPage.iframe_departReportDangerList());
    }

    // 切换到录入界面
    public void goAdd() throws IOException {
        elementAction.clickByJS(departReportDangerListPage.add_Button());
        switchFrame(departReportDangerListPage.iframe_goAddDepartDangerSource());
    }

    private void switchFrame(Locator locator) {
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(locator);
    }

    /**
     * 随机选择风险点类型
     * @param
     * @return: void
     * @throws:
     */
    public void selectAddressCate() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.addressCate_select(), elementAction.getOption(departReportDangerListPage.addressCate_select()));
    }

    /**
     * 根据当前时间输入辨识时间
     * @param
     * @return: void
     * @throws:
     */
    public void typeYeRecognizeTime() throws IOException {
        elementAction.type(departReportDangerListPage.yeRecognizeTime_textarea(), functionUtil.formatterDate("yyyy-MM-dd"));
    }

    /**
     * Description:验证辨识时间为空时是否有提示信息
     * @param
     * @return: void
     * @throws:
     */
    public void doCheckYeRecognizeTime() throws IOException {
        elementAction.fireEventBlur(departReportDangerListPage.yeRecognizeTime_textarea());
    }

    /**
     * 随机选择专业
     * @param
     * @return: void
     * @throws:
     */
    public void selectYeProfession() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.yeProfession_select(), elementAction.getOption(departReportDangerListPage.yeProfession_select()));
    }

    /**
     * Description:验证专业为空时是否有提示信息
     * @param
     * @return: void
     * @throws: IOException
     */
    public void doCheckYeProfession() throws IOException {
        elementAction.fireEventBlur(departReportDangerListPage.yeProfession_select());
    }

    /**
     * 指定选择危险源
     * @param hazardName 危险源值
     * @return: void
     * @throws:
     */
    public void selectHazardName(String hazardName) {
        elementAction.clickByJS(".//div[@id='hazardname']/div[2]/div");
        elementAction.clickByJS(".//*[@id='hazardname']//div[text()='" + hazardName + "']");
    }

    /**
     * 随机选择危险源
     * @param
     * @return: void
     * @throws:
     */
    public void selectHazardName() {
        elementAction.clickByJS(".//div[@id='hazardname']/div[2]/div");
        elementAction.sleep(1);
        List<WebElement> hazard = driver.findElements(By.xpath(".//*[@id='hazardname']/div[3]/div")); //获取危险源集合
        WebElement element = hazard.get(functionUtil.randomForElement(hazard.size()));
        element.click();
    }

    /**
     * 选择伤害类别:指定伤害类别
     * @param damageString 伤害类别字段值
     * @return: void
     * @throws:
     */
    public void checkDamageType(String damageString) {
        switch (damageString) {
            case "物体打击":
                WebElement element1 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='01']"));
                element1.click();
                break;
            case "车辆伤害":
                WebElement element2 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='02']"));
                element2.click();
                break;
            case "机械伤害":
                WebElement element3 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='03']"));
                element3.click();
                break;
            case "起重伤害":
                WebElement element4 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='04']"));
                element4.click();
                break;
            case "触电":
                WebElement element5 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='05']"));
                element5.click();
                break;
            case "淹溺":
                WebElement element6 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='06']"));
                element6.click();
                break;
            case "灼烫":
                WebElement element7 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='07']"));
                element7.click();
                break;
            case "火灾":
                WebElement element8 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='08']"));
                element8.click();
                break;
            case "高处坠落":
                WebElement element9 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='09']"));
                element9.click();
                break;
            case "坍塌":
                WebElement element10 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='10']"));
                element10.click();
                break;
            case "冒顶片帮":
                WebElement element11 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='11']"));
                element11.click();
                break;
            case "透水":
                WebElement element12 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='12']"));
                element12.click();
                break;
            case "放炮":
                WebElement element13 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='13']"));
                element13.click();
                break;
            case "瓦斯爆炸":
                WebElement element14 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='14']"));
                element14.click();
                break;
            case "火药爆炸":
                WebElement element15 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='15']"));
                element15.click();
                break;
            case "锅炉爆炸":
                WebElement element16 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='16']"));
                element16.click();
                break;
            case "容器爆炸":
                WebElement element17 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='17']"));
                element17.click();
                break;
            case "其他爆炸":
                WebElement element18 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='18']"));
                element18.click();
                break;
            case "中毒和窒息":
                WebElement element19 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='19']"));
                element19.click();
                break;
            case "其他伤害":
                WebElement element20 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='20']"));
                element20.click();
                break;
        }
    }

    /**
     * 随机选择伤害类别
     * @param
     * @return: void
     * @throws:
     */
    public void checkDamageType() {
        List<WebElement> webElements = driver.findElements(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]/label/input"));
        webElements.get(functionUtil.randomForElement(webElements.size())).click();
    }

    //  选择伤害类别:指定事故类别
    public void checkYeAccident(String yeAccident) {
        switch (yeAccident) {
            case "顶板":
                WebElement element1 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='1']"));
                element1.click();
                break;
            case "瓦斯":
                WebElement element2 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='2']"));
                element2.click();
                break;
            case "机电":
                WebElement element3 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='3']"));
                element3.click();
                break;
            case "运输":
                WebElement element4 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='4']"));
                element4.click();
                break;
            case "放炮":
                WebElement element5 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='5']"));
                element5.click();
                break;
            case "水害":
                WebElement element6 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='6']"));
                element6.click();
                break;
            case "火灾":
                WebElement element7 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='7']"));
                element7.click();
                break;
            case "其他":
                WebElement element8 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='8']"));
                element8.click();
                break;
        }
    }

    //  随机选择事故类别
    public void checkYeAccident() {
        List<WebElement> webElements = driver.findElements(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]/label/input"));
        webElements.get(functionUtil.randomForElement(webElements.size())).click();
    }

    //  输入风险描述
    public void typeYePossiblyHazard(String yePossiblyHazard) throws IOException {
        elementAction.type(departReportDangerListPage.yePossiblyHazard_textarea(), yePossiblyHazard);
    }

    public void doCheckYePossiblyHazard() throws IOException {
        elementAction.fireEventBlur(departReportDangerListPage.yePossiblyHazard_textarea());
    }

    public void checkYeProbability() {

    }

    /**
     * 用于验证在未选择数据的情况下执行相关操作是否出现提示信息
     * @throws IOException
     */
    public void toDoWithoutData(Locator locator) throws IOException {
       elementAction.clickByJS(locator);
    }

    /**
     * 指定选择风险可能性
     * @param yeProbability 风险可能性值
     * @return: void
     * @throws:
     */
    public void selectYeProbability(String yeProbability) throws IOException {
        elementAction.selectByText(departReportDangerListPage.yeProbability_select(), yeProbability);
    }

    /**
     * 随机选择风险可能性
     * @param
     * @return: void
     * @throws:
     */
    public void selectYeProbability() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.yeProbability_select(), elementAction.getOption(departReportDangerListPage.yeProbability_select()));
    }

    /**
     * 指定选择风险损失
     * @param yeCost 风险损失值
     * @return: void
     * @throws:
     */
    public void selectYeCost(String yeCost) throws IOException {
        elementAction.selectByText(departReportDangerListPage.yeCost_select(), yeCost);
    }

    /**
     * 随机选择风险损失
     * @param
     * @return: void
     * @throws:
     */
    public void selectYeCost() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.yeCost_select(), elementAction.getOption(departReportDangerListPage.yeCost_select()));
    }

    /**
     * 指定选择风险类型
     * @param yeHazardCate 风险类型值
     * @return: void
     * @throws:
     */
    public void selectYeHazardCate(String yeHazardCate) throws IOException {
        elementAction.selectByText(departReportDangerListPage.yeHazardCate_select(), yeHazardCate);
    }

    /**
     * 随机选择风险类型
     * @param
     * @return: void
     * @throws:
     */
    public void selectYeHazardCate() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.yeHazardCate_select(), elementAction.getOption(departReportDangerListPage.yeHazardCate_select()));
    }

    /**
     * 指定选择作业活动
     * @param activityname 作业活动值
     * @return: void
     * @throws:
     */
    public void selectActivityName(String activityname) throws IOException {
        elementAction.clickByJS(departReportDangerListPage.activityNameList());
        WebElement activity = driver.findElement(By.xpath(".//*[@id='activityname']//div[text()='" + activityname + "']"));
        activity.click();
    }

    /**
     * 随机选择作业活动
     * @param
     * @return: void
     * @throws:
     */
    public void selectActivityName() throws IOException {
        elementAction.clickByJS(departReportDangerListPage.activityNameList());
        elementAction.displayElement(".//*[@id='activityname']/div[3]/div");
        List<WebElement> act = driver.findElements(By.xpath(".//*[@id='activityname']/div[3]/div"));
        act.get(functionUtil.randomForElement(act.size())).click();
    }

    //  输入管控标准来源
    public void typeDocSource(String docSource) throws IOException {
        elementAction.type(departReportDangerListPage.docSource_textarea(), docSource);
    }

    //  输入章节条款
    public void typeSectionName(String sectionName) throws IOException {
        elementAction.type(departReportDangerListPage.ectionName_textarea(), sectionName);
    }

    //  输入标准内容
    public void typeYeStandard(String yeStandard) throws IOException {
        elementAction.type(departReportDangerListPage.yeStandard_textarea(), yeStandard);
    }

    //  输入管控措施
    public void typeManageMeasure(String manageMeasure) throws IOException {
        elementAction.type(departReportDangerListPage.manageMeasure_textarea(), manageMeasure);
    }

    /**
     * 指定选择责任岗位
     * @param postname 责任岗位名称
     * @return: void
     * @throws:
     */
    public void selectPostName(String postname) throws IOException {
        elementAction.clickByJS(departReportDangerListPage.postNameList());
        elementAction.clickByJS(".//*[@id='postname']//div[text()='" + postname + "']");
    }

    /**
     * 随机选择责任岗位
     * @param
     * @return: void
     * @throws:
     */
    public void selectPostName() throws IOException {
        elementAction.clickByJS(departReportDangerListPage.postNameList());
        elementAction.displayElement(".//*[@id='postname']/div[3]/div");
        List<WebElement> postName = driver.findElements(By.xpath(".//*[@id='postname']/div[3]/div"));
        elementAction.sleep(1);
        postName.get(functionUtil.randomForElement(postName.size())).click();
    }

    //  输入隐患描述
    public void typeYeMhazardDesc(String yeMhazardDesc) throws IOException {
        elementAction.type(departReportDangerListPage.yeMhazardDesc_textarea(), yeMhazardDesc);
    }

    /**
     * 指定选择隐患等级
     * @param hiddenLevel 隐患等级值
     * @return: void
     * @throws:
     */
    public void selectHiddenLevel(String hiddenLevel) throws IOException {
        elementAction.selectByText(departReportDangerListPage.hiddenLevel_select(), hiddenLevel);
    }

    /**
     * 随机选择隐患等级
     * @param
     * @return: void
     * @throws:
     */
    public void selectHiddenLevel() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.hiddenLevel_select(), elementAction.getOption(departReportDangerListPage.hiddenLevel_select()));
    }

    /**
     * 输入罚款金额
     * @param fineMoney 罚款金额
     * @return: void
     * @throws:
     */
    public void typeFineMoney(String fineMoney) throws IOException {
        elementAction.type(departReportDangerListPage.fineMoney_textarea(), fineMoney);
    }

    //  点击保存按钮
    public void doSave() throws IOException {
        elementAction.click_left(departReportDangerListPage.save_btn());
    }

    //  点击保存并提交按钮
    public void doSubRep() throws IOException {
        elementAction.click_left(departReportDangerListPage.subRep_btn());
    }

    //  点击关闭按钮
    public void doClose() throws IOException {
        elementAction.click_left(departReportDangerListPage.closeBtn());
    }

    /**
     * Description: 选择已上报状态
     * @param
     * @return: void
     * @throws:
     */
    public void checkReported() throws IOException {
        elementAction.clickByJS(departReportDangerListPage.beenReported_radio());
        if (elementAction.isRadioSelect(departReportDangerListPage.beenReported_radio())) {
            log.info("");
        } else {
            elementAction.clickByJS(departReportDangerListPage.beenReported_radio());
        }
    }

    /**
     * 选择待上报状态
     * @throws IOException
     */
    public void selecttoBeReported() throws IOException {
        elementAction.clickByJS(departReportDangerListPage.toBeReported_radio());
    }

    /**
     * 选择全部状态
     * @throws IOException
     */
    public void selectAll() throws IOException {
      elementAction.clickByJS(departReportDangerListPage.all_radio());
    }

    /**
     * Description: 重置查询条件
     * @param
     * @return: void
     * @throws:
     */
    public void doReset() throws IOException {
        elementAction.clear(departReportDangerListPage.s_yeRecognizeTime_begin_textarea());
        elementAction.clear(departReportDangerListPage.s_yeRecognizeTime_end_textarea());
        elementAction.clear(departReportDangerListPage.s_yeMhazardDesc_textarea());
        elementAction.selectByIndex(departReportDangerListPage.s_yeProfession_select(), 0);
        elementAction.selectByIndex(departReportDangerListPage.s_damageType_select(), 0);
        elementAction.clear(departReportDangerListPage.s_yePossiblyHazard_textarea());
        elementAction.selectByIndex(departReportDangerListPage.s_activityId_select(), 0);
        elementAction.selectByIndex(departReportDangerListPage.s_yeRiskGrade_select(), 0);
        elementAction.selectByIndex(departReportDangerListPage.s_yeHazardCate_select(), 0);
        elementAction.clear(departReportDangerListPage.s_docSource_textarea());
        elementAction.clear(departReportDangerListPage.s_yeStandard_textarea());
        elementAction.selectByIndex(departReportDangerListPage.s_hiddenLevel_select(), 0);
    }

    /**
     * Description: 根据辨识开始时间查询
     * @param yeRecognizeTime_begin 辨识开始时间
     * @return: void
     * @throws:
     */
    public void searchByyeRecognizeTime_begin(String yeRecognizeTime_begin) throws IOException {
        if (functionUtil.isValidDate(yeRecognizeTime_begin)) {
            elementAction.typeByJS(departReportDangerListPage.s_yeRecognizeTime_begin_textarea(), yeRecognizeTime_begin);
            elementAction.clickByJS(departReportDangerListPage.search_Button());
        } else {
            log.warn("输入的时间:【" + yeRecognizeTime_begin + "】格式不正确");
        }
    }

    /**
     * Description: 根据辨识结束时间查询
     * @param end 辨识结束时间
     * @return: void
     * @throws:
     */
    @Step("输入辨识结束时间:{0}")
    public void searchByyeRecognizeTime_end(String end) throws IOException {
        if (functionUtil.isValidDate(end)) {
            elementAction.typeByJS(departReportDangerListPage.s_yeRecognizeTime_end_textarea(), end);
            elementAction.clickByJS(departReportDangerListPage.search_Button());
        } else {
            log.warn("输入的时间:【" + end + "】格式不正确");
        }
    }

    /**
     * Description: 根据辨识时间段进行查询
     * @param yeRecognizeTime_begin 辨识开始时间
     * @param end                   辨识结束时间
     * @return: void
     * @throws:
     */
    @Step("输入辨识开始时间：{0}，输入辨识结束时间:{1}")
    public void searchByyeRecognizeTime(String yeRecognizeTime_begin, String end) throws IOException, ParseException {
        if (functionUtil.isValidDate(yeRecognizeTime_begin) && functionUtil.isValidDate(end)) {
            if (functionUtil.compareTime(yeRecognizeTime_begin, end)) {
                elementAction.typeByJS(departReportDangerListPage.s_yeRecognizeTime_begin_textarea(), yeRecognizeTime_begin);
                elementAction.typeByJS(departReportDangerListPage.s_yeRecognizeTime_end_textarea(), end);
                elementAction.clickByJS(departReportDangerListPage.search_Button());
            } else {
                log.warn("输入的时间段有误：【" + yeRecognizeTime_begin + "】,【" + end + "】");
            }
        } else {
            if (functionUtil.isValidDate(yeRecognizeTime_begin) == false)
                log.warn("输入的时间:【" + yeRecognizeTime_begin + "】格式不正确");
            if (functionUtil.isValidDate(end) == false)
                log.warn("输入的时间:【" + end + "】格式不正确");
        }
    }

    /**
     * Description: 根据隐患描述进行查询
     * @param yeMhazardDesc 隐患描述内容
     * @return: void
     * @throws:
     */
    @Step("输入隐患描述内容：{0}")
    public void searchByYeMhazardDesc(String yeMhazardDesc) throws IOException {
        elementAction.typeByJS(departReportDangerListPage.s_yeMhazardDesc_textarea(), yeMhazardDesc);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据专业进行查询
     * @param yeProfession 专业字段值
     */
    public void searchByyeProfession(String yeProfession) throws IOException {
        elementAction.selectByText(departReportDangerListPage.s_yeProfession_select(), yeProfession);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据伤害类别进行查询
     * @param damageType 伤害类别字段值
     * @throws IOException
     */
    public void searchBydamageType(String damageType) throws IOException {
        elementAction.selectByText(departReportDangerListPage.s_damageType_select(), damageType);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据风险描述进行查询
     * @param yePossiblyHazard 风险描述字段值
     * @throws IOException
     */
    public void searchByyePossiblyHazard(String yePossiblyHazard) throws IOException {
        elementAction.typeByJS(departReportDangerListPage.s_yePossiblyHazard_textarea(), yePossiblyHazard);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据作业活动进行查询
     * @param activity 作业活动字段值
     * @throws IOException
     */
    public void searchByactivity(String activity) throws IOException {
        elementAction.selectByText(departReportDangerListPage.s_activityId_select(), activity);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据风险等级查询
     * @param yeRiskGrade 风险等级
     * @throws IOException
     */
    @Step("Shuru:{0}")
    public void searchByyeRiskGrade(String yeRiskGrade) throws IOException {
        elementAction.selectByText(departReportDangerListPage.s_yeRiskGrade_select(), yeRiskGrade);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据风险类型查询
     * @param yeHazardCate 风险类型字段值
     * @throws IOException
     */
    public void searchByyeHazardCate(String yeHazardCate) throws IOException {
        elementAction.selectByText(departReportDangerListPage.s_yeHazardCate_select(), yeHazardCate);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据隐患等级查询
     * @param hiddenLevel 隐患等级字段值
     * @throws IOException
     */
    public void searchByhiddenLevel(String hiddenLevel) throws IOException {
        elementAction.selectByText(departReportDangerListPage.s_hiddenLevel_select(), hiddenLevel);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * 根据管控标准来源查询
     * @param docSource 管控标准来源字段值
     * @throws IOException
     */
    public void searchBydocSource(String docSource) throws IOException {
        elementAction.typeByJS(departReportDangerListPage.s_docSource_textarea(), docSource);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    /**
     * Description: 根据标准内容查询
     * @param yeStandard 标准内容
     * @return: void
     * @throws: IOException
     */
    public void searchByyeStandard(String yeStandard) throws IOException {
        elementAction.typeByJS(departReportDangerListPage.s_yeStandard_textarea(), yeStandard);
        elementAction.clickByJS(departReportDangerListPage.search_Button());
    }

    public int getTempNum() {
        return tempNum;
    }

    public void setTempNum(int tempNum) {
        this.tempNum = tempNum;
    }

    public int tempNum;

    /**
     * @param fieldStr 需要获取值的字段
     * @return 数据列表, text
     * @throws IOException
     * @throws InterruptedException
     * @description 获取查询结果中指定字段值
     */
    public List<String> getSearchData(String fieldStr) throws IOException {
        List<String> dataList = new ArrayList<>();
        if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
            switch (fieldStr) {
                case "风险点类型":

                    List<WebElement> addressCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='addressCate']/div"));
                    tempNum = addressCateElements.size();
                    for (int j = 0; j < addressCateElements.size(); j++) {
                        dataList.add(addressCateElements.get(j).getText());
                    }
                    break;
                case "隐患描述":

                    List<WebElement> yeMhazardDescElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeMhazardDesc']/div"));
                    tempNum = yeMhazardDescElements.size();
                    for (int j = 0; j < yeMhazardDescElements.size(); j++) {
                        dataList.add(yeMhazardDescElements.get(j).getText());
                    }
                    break;
                case "专业":
                    List<WebElement> yeProfessionElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeProfession']/div"));
                    tempNum = yeProfessionElements.size();
                    for (int j = 0; j < yeProfessionElements.size(); j++) {
                        dataList.add(yeProfessionElements.get(j).getText());
                    }
                    break;
                case "伤害类别":
                    List<WebElement> damageTypeElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='damageType']/div"));
                    tempNum = damageTypeElements.size();
                    for (int j = 0; j < damageTypeElements.size(); j++) {
                        dataList.add(damageTypeElements.get(j).getText());
                    }

                    break;
                case "风险描述":
                    List<WebElement> yePossiblyHazardElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yePossiblyHazard']/div"));
                    tempNum = yePossiblyHazardElements.size();
                    for (int j = 0; j < yePossiblyHazardElements.size(); j++) {
                        dataList.add(yePossiblyHazardElements.get(j).getText());
                    }
                    break;
                case "作业活动":
                    List<WebElement> activityidElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activity.id']/div"));
                    tempNum = activityidElements.size();
                    for (int j = 0; j < activityidElements.size(); j++) {
                        dataList.add(activityidElements.get(j).getText());
                    }

                    break;
                case "风险等级":
                    List<WebElement> yeRiskGradeTempElements = driver.findElements(By
                            .xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRiskGradeTemp']//input"));
                    tempNum = yeRiskGradeTempElements.size();
                    for (int j = 0; j < yeRiskGradeTempElements.size(); j++) {
                        dataList.add(elementAction.getAttribute(yeRiskGradeTempElements.get(j),"value"));
                    }

                    break;
                case "风险类型":
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeHazardCate']/div"));
                    tempNum = yeHazardCateElements.size();
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        dataList.add(yeHazardCateElements.get(j).getText());
                    }
                    break;

                case "管控标准来源":
                    List<WebElement> docSource = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='docSource']/div"));
                    tempNum = docSource.size();
                    for (int j = 0; j < docSource.size(); j++) {
                        dataList.add(docSource.get(j).getText());
                    }
                    break;
                case "标准内容":
                    List<WebElement> yeStandard = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeStandard']/div"));
                    tempNum = yeStandard.size();
                    for (int j = 0; j < yeStandard.size(); j++) {
                        dataList.add(yeStandard.get(j).getText());
                    }
                    break;

                case "辨识时间":
                    List<WebElement> yeRecognizeTime = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRecognizeTime']/div"));
                    for (int j = 0; j < yeRecognizeTime.size(); j++) {
                        dataList.add(yeRecognizeTime.get(j).getText());
                    }
                    break;
            }
        } else {
            log.info("根据查询条件>>无相关结果");
        }
        return dataList;
    }


}
