package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReviewDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @author the2n
 * @description 风险审核页面包含的功能
 * @Data 2018/11/27 14:00
 */
public class ReviewDangerListPageActions extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DefultPageActions defultPageActions = new DefultPageActions();

    ReviewDangerListPage reviewDangerListPage = new ReviewDangerListPage();
    DefultPage defultPage = new DefultPage();

    /**
     * @param locator
     * @throws IOException
     * @description 切换到风险审核页面
     */
    @Step(value = "切换到风险审核页面")
    public void modifyMenu(Locator locator) throws IOException {
        elementAction.switchToDefaultFrame();
        defultPageActions.openMenu(defultPage.reviewDangerList());
    }

    /**
     * @param addressCate 风险点字段值
     * @throws IOException
     * @description 根据风险点类型查询
     */
    @Step(value = "根据风险点类型查询")
    public void searchByAddressCate(String addressCate) throws IOException {
        elementAction.selectByText(reviewDangerListPage.addressCate_select(), addressCate);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRecognizeTime] 辨识开始时间
     * @return: void
     * @Description: 根据辨识开始时间查询
     */
    @Step(value = "输入辨识开始时间")
    public void searchByyeRecognizeTimeBegin(String yeRecognizeTime) throws IOException {
        elementAction.type(reviewDangerListPage.yeRecognizeTime_begin_textarea(), yeRecognizeTime);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRecognizeTime] 辨识结束时间
     * @return: void
     * @Description: 根据辨识开始结束查询
     */
    @Step(value = "输入辨识结束时间")
    public void searchByyeRecognizeTimeEnd(String yeRecognizeTime) throws IOException {
        elementAction.type(reviewDangerListPage.yeRecognizeTime_begin_textarea(), yeRecognizeTime);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRecognizeTime_begin, yeRecognizeTime_end] 辨识开始时间/结束时间
     * @return: void
     * @Description: 根据辨识时间段查询
     * @throws:
     */
    @Step(value = "输入辨识开始/结束时间")
    public void searchByRecognizeTime(String yeRecognizeTime_begin, String yeRecognizeTime_end) throws IOException, ParseException {

        if (compareTime(yeRecognizeTime_begin, yeRecognizeTime_end)) {
            elementAction.type(reviewDangerListPage.yeRecognizeTime_begin_textarea(), yeRecognizeTime_begin);
            elementAction.type(reviewDangerListPage.yeRecognizeTime_begin_textarea(), yeRecognizeTime_end);
            doSearch(reviewDangerListPage.search_Button(), 2);
        } else {
            log.info("输入的条件错误");
        }
    }

    /**
     * @param: [yeMhazardDesc] 隐患描述字段
     * @return: void
     * @Description: 根据隐患描述字段值查询
     * @throws:
     */
    @Step(value = "输入隐患描述")
    public void searchByYeMhazardDesc(String yeMhazardDesc) throws IOException {
        elementAction.type(reviewDangerListPage.yeMhazardDesc_textarea(), yeMhazardDesc);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeProfession] 专业字段值
     * @return: void
     * @Description: 根据专业查询
     * @throws:
     */
    @Step(value = "选择专业")
    public void searchByYeProfession(String yeProfession) throws IOException {
        elementAction.selectByText(reviewDangerListPage.yeProfession_select(), yeProfession);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [damageType]  伤害类别字段值
     * @return: void
     * @Description: 根据伤害类别查询
     * @throws:
     */
    @Step(value = "选择伤害类别")
    public void searchByDamageType(String damageType) throws IOException {
        elementAction.selectByText(reviewDangerListPage.damageType_select(), damageType);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yePossiblyHazard] 风险描述字段值
     * @return: void
     * @Description: 根据风险描述查询
     * @throws:
     */
    @Step(value = "输入风险描述")
    public void searchByYePossiblyHazard(String yePossiblyHazard) throws IOException {
        elementAction.type(reviewDangerListPage.yeProfession_select(), yePossiblyHazard);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [activityid] 作业活动字段值
     * @return: void
     * @Description: 根据作业活动查询
     * @throws:
     */
    @Step(value = "选择作业活动")
    public void searchByActivityid(String activityid) throws IOException {
        elementAction.selectByText(reviewDangerListPage.activityId_select(), activityid);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRiskGrade] 风险等级字段值
     * @return: void
     * @Description: 根据风险等级查询
     * @throws:
     */
    @Step(value = "选择风险等级")
    public void searchByYeRiskGrade(String yeRiskGrade) throws IOException {
        elementAction.selectByText(reviewDangerListPage.yeRiskGrade_select(), yeRiskGrade);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeHazardCate] 风险类型字段值
     * @return: void
     * @Description: 根据风险类型查询
     * @throws:
     */
    @Step(value = "选择风险类型")
    public void searchByYeHazardCate(String yeHazardCate) throws IOException {
        elementAction.selectByText(reviewDangerListPage.yeHazardCate_select(), yeHazardCate);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [docSource] 管控标准来源字段值
     * @return: void
     * @Description: 根据管控标准来源查询
     * @throws:
     */
    @Step(value = "输入管控标准来源")
    public void searchByDocSource(String docSource) throws IOException {
        elementAction.type(reviewDangerListPage.docSource_textarea(), docSource);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeStandard] 标准内容字段值
     * @return: void
     * @Description: 根据标准内容查询
     * @throws:
     */
    @Step(value = "输入标准内容")
    public void searchByYeStandard(String yeStandard) throws IOException {
        elementAction.type(reviewDangerListPage.yeStandard_textarea(), yeStandard);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [hiddenLevel] 隐患等级
     * @return: void
     * @Description: 根据隐患等级查询
     * @throws:
     */
    @Step(value = "选择隐患等级")
    public void searchByHiddenLevel(String hiddenLevel) throws IOException {
        elementAction.selectByText(reviewDangerListPage.hiddenLevel_select(), hiddenLevel);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }


    /**
     * @param: []
     * @return: void
     * @Description: 随机点击当前页面上的一条数据进行查看详情
     * @throws:
     */
    public void goDetailbByRandom() throws IOException {
        List<WebElement> trElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(trElements.size());
        trElements.get(temp).click(); //  根据当前页面上的数据,随机选择
        elementAction.click_left(reviewDangerListPage.detail_Button());
    }

    /**
     *
     *@param: [remark] 备注信息
     *@return: void
     *@Description: 审核通过
     *@throws:
     */
    public void goReviewPassByRandom(String remark) throws IOException {
        List<WebElement> trElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(trElements.size());
        trElements.get(temp).click(); //  根据当前页面上的数据,随机选择
        elementAction.click_left(reviewDangerListPage.goReview_Button());
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerSource());
        if (elementAction.getAttribute(reviewDangerListPage.check_pass_radio(), "checked").equals("checked")) {
            elementAction.type(reviewDangerListPage.check_remark_textarea(), remark);
            elementAction.switchToDefaultFrame();
            elementAction.click_left(reviewDangerListPage.check_confirm_btn());
        } else {
            elementAction.click_left(reviewDangerListPage.check_pass_radio());
            elementAction.type(reviewDangerListPage.check_remark_textarea(), remark);
            elementAction.switchToDefaultFrame();
            elementAction.click_left(reviewDangerListPage.check_confirm_btn());
        }
    }

    /**
     * @param: [yeRecognizeTime_begin, yeRecognizeTime_end]
     * @return: true 开始时间早于等于结束时间 false 开始时间晚于结束时间
     * @Description: 判断时间段是否正确
     * @throws:
     */
    public boolean compareTime(String yeRecognizeTime_begin, String yeRecognizeTime_end) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date bt = sdf.parse(yeRecognizeTime_begin);
        Date et = sdf.parse(yeRecognizeTime_end);
        if (bt.before(et) || bt.equals(et))
            return true;
        else
            return false;
    }

    /**
     * 封装点击查询按钮的操作
     *
     * @param locator 查询按钮元素
     * @param i       等待时间,点击查询后等待结果加载
     */
    private void doSearch(Locator locator, int i) {
        elementAction.sleep(1);
        elementAction.click_left(locator);
        elementAction.sleep(i);
    }

    /**
     * @param fieldStr 需要获取值的字段
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @description 获取查询结果中指定字段值
     */
    public List<String> getSearchData(String fieldStr) throws IOException, InterruptedException {
        List<String> addressCateList = new ArrayList<>();
        switch (fieldStr) {
            case "风险点类型":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> addressCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='addressCate']/div"));
                    for (int j = 0; j < addressCateElements.size(); j++) {
                        addressCateList.add(addressCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "隐患描述":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeMhazardDescElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeMhazardDesc']/div"));
                    for (int j = 0; j < yeMhazardDescElements.size(); j++) {
                        addressCateList.add(yeMhazardDescElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "专业":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeProfessionElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeProfession']/div"));
                    for (int j = 0; j < yeProfessionElements.size(); j++) {
                        addressCateList.add(yeProfessionElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "伤害类别":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> damageTypeElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='damageType']/div"));
                    for (int j = 0; j < damageTypeElements.size(); j++) {
                        addressCateList.add(damageTypeElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险描述":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yePossiblyHazardElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yePossiblyHazard']/div"));
                    for (int j = 0; j < yePossiblyHazardElements.size(); j++) {
                        addressCateList.add(yePossiblyHazardElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "作业活动":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> activityidElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activity.id']/div"));
                    for (int j = 0; j < activityidElements.size(); j++) {
                        addressCateList.add(activityidElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险等级":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeRiskGradeTempElements = driver.findElements(By
                            .xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRiskGradeTemp']//input"));
                    for (int j = 0; j < yeRiskGradeTempElements.size(); j++) {
                        addressCateList.add(yeRiskGradeTempElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险类型":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeHazardCate']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险点":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='address']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "管控标准来源":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='docSource']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "标准内容":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeStandard']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "隐患等级":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='hiddenLevel']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "辨识时间":
                if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRecognizeTime']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
        }
        return addressCateList;
    }

    /**
     * @throws IOException
     * @description 还原查询条件为默认值
     */
    public void setDefult() throws IOException {

        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());

        // 判断风险点类型是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.addressCate_select(), 0);
        // 判断辨识开始时间输入框是否为空
        elementAction.clear(reviewDangerListPage.yeRecognizeTime_begin_textarea());
        // 判断辨识结束时间输入框是否为空
        elementAction.clear(reviewDangerListPage.yeRecognizeTime_end_textarea());
        // 判断隐患描述输入框是否为空
        elementAction.clear(reviewDangerListPage.yeMhazardDesc_textarea());
        // 判断专业是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.yeProfession_select(), 0);
        // 判断伤害类别是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.damageType_select(), 0);
        // 判断风险描述输入框是否为空
        elementAction.clear(reviewDangerListPage.yePossiblyHazard_textarea());
        // 判断作业活动是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.activityId_select(), 0);
        // 判断风险等级是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.yeRiskGrade_select(), 0);
        // 判断风险类型是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.yeHazardCate_select(), 0);
        // 判断管控标准来源输入框是否为空
        elementAction.clear(reviewDangerListPage.docSource_textarea());
        // 判断标准内容输入框是否为空
        elementAction.clear(reviewDangerListPage.yeStandard_textarea());
        // 判断隐患等级是否为默认值
        elementAction.selectByIndex(reviewDangerListPage.hiddenLevel_select(), 0);
    }
}