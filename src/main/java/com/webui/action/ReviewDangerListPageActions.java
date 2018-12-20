package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReviewDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author the2n
 * @Description:  风险审核页面相关操作
 * @Data 2018/11/28 14:15
 */
public class ReviewDangerListPageActions extends TestBaseCase {
    ElementAction elementAction = new ElementAction();
    DefultPageActions defultPageActions = new DefultPageActions();

    ReviewDangerListPage reviewDangerListPage = new ReviewDangerListPage();
    DefultPage defultPage = new DefultPage();
    FunctionUtil functionUtil = new FunctionUtil();

    /**
     * @param locator
     * @throws IOException
     * @description 切换到风险审核页面
     */
    public void modifyMenu(Locator locator) throws IOException {
        defultPageActions.openMenu(defultPage.reviewDangerList());
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());
    }

    public void modifyMenu() throws IOException {
        defultPageActions.openMenu(defultPage.aqfxfjgk_menu(), defultPage.ndfxgl_list(), defultPage.reviewDangerList());
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());
        elementAction.sleep(1);
    }

    /**
     * @param addressCate 风险点字段值
     * @throws IOException
     * @description 根据风险点类型查询
     */
    public void searchByAddressCate(String addressCate) throws IOException {
        elementAction.selectByText(reviewDangerListPage.addressCate_select(), addressCate);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRecognizeTime] 辨识开始时间
     * @return: void
     * @Description: 根据辨识开始时间查询
     */
    public void searchByyeRecognizeTimeBegin(String yeRecognizeTime) throws IOException {
        setDefult();
        elementAction.type(reviewDangerListPage.yeRecognizeTime_begin_textarea(), yeRecognizeTime);
        doSearch(reviewDangerListPage.search_Button(), 2);

    }

    /**
     * @param: [yeRecognizeTime] 辨识结束时间
     * @return: void
     * @Description: 根据辨识开始结束查询
     */
    public void searchByyeRecognizeTimeEnd(String yeRecognizeTime) throws IOException {
        setDefult();
        elementAction.type(reviewDangerListPage.yeRecognizeTime_begin_textarea(), yeRecognizeTime);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRecognizeTime_begin, yeRecognizeTime_end] 辨识开始时间/结束时间
     * @return: void
     * @Description: 根据辨识时间段查询
     * @throws:
     */
    public void searchByRecognizeTime(String yeRecognizeTime_begin, String yeRecognizeTime_end) throws IOException, ParseException {
        setDefult();
        if (functionUtil.compareTime(yeRecognizeTime_begin, yeRecognizeTime_end)) {
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
    public void searchByYeMhazardDesc(String yeMhazardDesc) throws IOException {
        setDefult();
        elementAction.type(reviewDangerListPage.yeMhazardDesc_textarea(), yeMhazardDesc);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeProfession] 专业字段值
     * @return: void
     * @Description: 根据专业查询
     * @throws:
     */
    public void searchByYeProfession(String yeProfession) throws IOException {
        setDefult();
        elementAction.selectByText(reviewDangerListPage.yeProfession_select(), yeProfession);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [damageType]  伤害类别字段值
     * @return: void
     * @Description: 根据伤害类别查询
     * @throws:
     */
    public void searchByDamageType(String damageType) throws IOException {
        setDefult();
        elementAction.selectByText(reviewDangerListPage.damageType_select(), damageType);
        doSearch(reviewDangerListPage.search_Button(), 2);

    }

    /**
     * @param: [yePossiblyHazard] 风险描述字段值
     * @return: void
     * @Description: 根据风险描述查询
     * @throws:
     */
    public void searchByYePossiblyHazard(String yePossiblyHazard) throws IOException {
        setDefult();
        elementAction.type(reviewDangerListPage.yePossiblyHazard_textarea(), yePossiblyHazard);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [activityid] 作业活动字段值
     * @return: void
     * @Description: 根据作业活动查询
     * @throws:
     */
    public void searchByActivityid(String activityid) throws IOException {
        setDefult();
        elementAction.selectByText(reviewDangerListPage.activityId_select(), activityid);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeRiskGrade] 风险等级字段值
     * @return: void
     * @Description: 根据风险等级查询
     * @throws:
     */
    public void searchByYeRiskGrade(String yeRiskGrade) throws IOException {
        setDefult();
        elementAction.selectByText(reviewDangerListPage.yeRiskGrade_select(), yeRiskGrade);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeHazardCate] 风险类型字段值
     * @return: void
     * @Description: 根据风险类型查询
     * @throws:
     */
    public void searchByYeHazardCate(String yeHazardCate) throws IOException {
        setDefult();
        elementAction.selectByText(reviewDangerListPage.yeHazardCate_select(), yeHazardCate);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [docSource] 管控标准来源字段值
     * @return: void
     * @Description: 根据管控标准来源查询
     * @throws:
     */
    public void searchByDocSource(String docSource) throws IOException {
        setDefult();
        elementAction.type(reviewDangerListPage.docSource_textarea(), docSource);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [yeStandard] 标准内容字段值
     * @return: void
     * @Description: 根据标准内容查询
     * @throws:
     */
    public void searchByYeStandard(String yeStandard) throws IOException {
        setDefult();
        elementAction.type(reviewDangerListPage.yeStandard_textarea(), yeStandard);
        doSearch(reviewDangerListPage.search_Button(), 2);
    }

    /**
     * @param: [hiddenLevel] 隐患等级
     * @return: void
     * @Description: 根据隐患等级查询
     * @throws:
     */
    public void searchByHiddenLevel(String hiddenLevel) throws IOException {
        setDefult();
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
        clickElement();
        elementAction.click_left(reviewDangerListPage.detail_Button());
    }

    /**
     *
     *@param: []
     *@return: void
     *@Description: 导出数据
     *@throws: 
     */
    public void exportXls() throws IOException {
        elementAction.click_left(reviewDangerListPage.ExportXls_Button());
    }

    /**
     * @param: [remark] 备注信息
     * @return: void
     * @Description: 审核通过
     * @throws:
     */
    public void goReviewPassByRandom(String remark) throws IOException {
        unCHecked();
        clickElement();
        switchToReviewFrame();
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
     * @param: []
     * @return: void
     * @Description: 审核通过, 不输入备注信息
     * @throws:
     */
    public void goReviewPassWithoutRemark() throws IOException {
        clickElement();
        switchToReviewFrame();
        if (elementAction.getAttribute(reviewDangerListPage.check_pass_radio(), "checked").equals("checked")) {
            elementAction.switchToDefaultFrame();
            elementAction.click_left(reviewDangerListPage.check_confirm_btn());
        } else {
            elementAction.click_left(reviewDangerListPage.check_pass_radio());
            elementAction.switchToDefaultFrame();
            elementAction.click_left(reviewDangerListPage.check_confirm_btn());
        }
    }

    /**
     * @param: []
     * @return: void
     * @Description: 切换到审核frame上, 审核弹框
     * @throws:
     */
    private void switchToReviewFrame() throws IOException {
        elementAction.click_left(reviewDangerListPage.goReview_Button());
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerSource());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 审核驳回, 不输入备注信息
     * @throws:
     */
    public void goReviewDismissWithoutRemark() throws IOException {
        setDefult();
        clickElement();
        switchToReviewFrame();
        elementAction.click_left(reviewDangerListPage.check_dismiss_radio()); //选择驳回
        elementAction.switchToDefaultFrame();
        elementAction.click_left(reviewDangerListPage.check_confirm_btn());
    }

    /**
     * @param: [remark] 备注信息
     * @return: void
     * @Description: 审核驳回, 输入备注信息
     * @throws:
     */
    public void goReviewDismissByRandom(String remark) throws IOException {
        if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
            clickElement();
            switchToReviewFrame();
            elementAction.click_left(reviewDangerListPage.check_dismiss_radio()); //选择驳回
            elementAction.type(reviewDangerListPage.check_remark_textarea(), remark);
            elementAction.switchToDefaultFrame();
            elementAction.click_left(reviewDangerListPage.check_confirm_btn());
        } else {
            log.info("当前页面上暂无数据");
        }
    }

    /**
     * @param: [yeRecognizeTime] 辨识时间字段
     * @return: void
     * @Description: 修改辨识时间, 格式不正确, 日期错误等
     * @throws: ========弹框暂时无法处理
     */
    public void updateYeRecognizeTime(String yeRecognizeTime) throws IOException {
        elementAction.type(reviewDangerListPage.update_yeRecognizeTime_textarea(), yeRecognizeTime);
        elementAction.click_left(reviewDangerListPage.update_btn_save());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 修改专业值为默认值, 用于验证专业为空的验证
     * @throws:
     */
    public void updateYeProfessionSelectDefault() throws IOException {
        elementAction.selectByIndex(reviewDangerListPage.update_yeProfession_select(), 0);   //设置为默认值:请选择
        elementAction.fireEventBlur(reviewDangerListPage.update_yeProfession_select());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 随机点击当前页面上的一条数据, 若没有数据则提示"当前页面上暂无数据"
     * @throws:
     */
    public void clickElement() throws IOException {
        elementAction.sleep(1);
        if (elementAction.isElementDisplayedByLocator(reviewDangerListPage.data_tbody())) {
            List<WebElement> trElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
            Random random = new Random();
            int temp = random.nextInt(trElements.size());
            tempString = driver.findElement(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr[" + (temp + 1) + "]/td[@field='yePossiblyHazard']/div")).getText();
            elementAction.highlightElementByXpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr[" + (temp + 1) + "]/td[@field='yePossiblyHazard']/div");
            trElements.get(temp).click(); //  根据当前页面上的数据,随机选择
        } else {
            log.info("当前页面上暂无数据");
        }
    }

    public String getTempString() {
        return tempString;
    }

    public void setTempString(String tempString) {
        this.tempString = tempString;
    }

    private String tempString;

    /**
     * @param: []
     * @return: void
     * @Description: 打开编辑页面
     * @throws:
     */
    public void switchToUpdatePage() throws IOException {
        clickElement();
        elementAction.click_left(reviewDangerListPage.editDangerSource_Button());
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(reviewDangerListPage.iframe_goUpdateDangerSourceOnCheck());  //切换到编辑页面
    }

    /**
     * @param: []
     * @return: void
     * @Description: 修改危险源名称为空, 用于危险源名称为空的验证
     * @throws:
     */
    public void updateHazardnameDefault() throws IOException {
        elementAction.click_left(reviewDangerListPage.update_ms_close());   //清除原内容
        elementAction.click(reviewDangerListPage.update_btn_save());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 删除风险描述原内容, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updateYePossiblyHazardDefault() throws IOException {
        elementAction.clear(reviewDangerListPage.update_yePossiblyHazard_textarea());//清空风险描述内容
        elementAction.fireEventBlur(reviewDangerListPage.update_yePossiblyHazard_textarea());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 修改风险可能性字段值为默认值, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updateYeProbabilityDefault() throws IOException {
        elementAction.selectByIndex(reviewDangerListPage.update_yeProbability_select(), 0);//选择默认值
        elementAction.fireEventBlur(reviewDangerListPage.update_yeProbability_select());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 随机选择风险可能性值
     * @throws:
     */
    public void updateYeProbability() throws IOException {
        elementAction.selectByIndex(reviewDangerListPage.update_yeProbability_select(), elementAction.getOption(reviewDangerListPage.update_yeProbability_select()));//修改风险可能性
    }

    /**
     * @param: []
     * @return: void
     * @Description: 修改风险损失字段值为默认值, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updateYeCostDefault() throws IOException {
//        updateYeProbability();
        updateYeCost();
        elementAction.selectByIndex(reviewDangerListPage.update_yeCost_select(), 0);//选择默认值
        elementAction.fireEventBlur(reviewDangerListPage.update_yeCost_select());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 随机修改风险损失值
     * @throws:
     */
    public void updateYeCost() throws IOException {
        elementAction.selectByIndex(reviewDangerListPage.update_yeCost_select(), elementAction.getOption(reviewDangerListPage.update_yeCost_select()));//修改风险可能性
    }

    /**
     * @param: []
     * @return: void
     * @Description: 修改风险类型字段值为默认值, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updateYeHazardCateDefault() throws IOException {
        elementAction.selectByIndex(reviewDangerListPage.update_yeHazardCate_select(), 0);//选择默认值
        elementAction.fireEventBlur(reviewDangerListPage.update_yeHazardCate_select());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 随机修改风险类型值
     * @throws:
     */
    public void updateYeHazardCate() throws IOException {
        elementAction.selectByIndex(reviewDangerListPage.update_yeHazardCate_select(), elementAction.getOption(reviewDangerListPage.update_yeHazardCate_select()));
    }

    /**
     * @param: []
     * @return: void
     * @Description: 清空标准内容字段值, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updateYeStandardDefault() throws IOException {
        elementAction.clear(reviewDangerListPage.update_yeStandard_textarea());
        elementAction.fireEventBlur(reviewDangerListPage.update_yeStandard_textarea());
    }

    /**
     * @param: [yeStandard] 标准内容
     * @return: void
     * @Description: 修改标准内容
     * @throws:
     */
    public void updateYeStandard(String yeStandard) throws IOException {
        elementAction.clear(reviewDangerListPage.update_yeStandard_textarea());
        elementAction.type(reviewDangerListPage.update_yeStandard_textarea(), yeStandard);
        elementAction.fireEventBlur(reviewDangerListPage.update_yeStandard_textarea());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 清空管控内容值
     * @throws:
     */
    public void updateManageMeasureDefault() throws IOException {
        elementAction.clear(reviewDangerListPage.update_manageMeasure_textarea());
        elementAction.fireEventBlur(reviewDangerListPage.update_manageMeasure_textarea());
    }

    /**
     * @param: [manageMeasure 管控内容值]
     * @return: void
     * @Description: 修改管控内容为指定值
     * @throws:
     */
    public void updateManageMeasure(String manageMeasure) throws IOException {
        elementAction.clear(reviewDangerListPage.update_manageMeasure_textarea());
        elementAction.type(reviewDangerListPage.update_manageMeasure_textarea(), manageMeasure);
        elementAction.fireEventBlur(reviewDangerListPage.update_manageMeasure_textarea());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 清空责任岗位字段值, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updatePostNameDefault() throws IOException {
        elementAction.click_left(reviewDangerListPage.update_postName_del());
        elementAction.click(reviewDangerListPage.update_btn_save());
    }


    /**
     * @param: [postName 责任岗位名称]
     * @return: void
     * @Description: 修改责任岗位
     * @throws:
     */
    public void updatePostName(String postName) throws IOException {
        elementAction.click_left(reviewDangerListPage.update_postNameList());
        elementAction.click(".//*[@id='postname']//div[text()='" + postName + "']");
    }

    /**
     * @param: [yeMhazardDesc 隐患描述字段值]
     * @return: void
     * @Description: 修改隐患描述
     * @throws:
     */
    public void updateYeMhazardDesc(String yeMhazardDesc) throws IOException {
        elementAction.clear(reviewDangerListPage.update_yeMhazardDesc_textarea());
        elementAction.type(reviewDangerListPage.update_yeMhazardDesc_textarea(), yeMhazardDesc);
        elementAction.fireEventBlur(reviewDangerListPage.update_yeMhazardDesc_textarea());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 清空隐患描述字段值, 用于验证在修改风险时, 该字段是否可以为空
     * @throws:
     */
    public void updateYeMhazardDescDefault() throws IOException {
        elementAction.clear(reviewDangerListPage.update_yeMhazardDesc_textarea());
        elementAction.fireEventBlur(reviewDangerListPage.update_yeMhazardDesc_textarea());
    }

    /**
     * @param: []
     * @return: void
     * @Description: 全部去审
     * @throws:
     */
    public void undoReviewAll() throws IOException {
        checkChecked();
        elementAction.click_left(reviewDangerListPage.undoReviewAll_Button());
        elementAction.switchToDefaultFrame();   //切换到默认iframe上,执行点击确定按钮的操作
        elementAction.click_left(reviewDangerListPage.check_confirm_btn());
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());    //切换到数据列表的iframe
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
     * @return 数据列表, text
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
                    tempNum = addressCateElements.size();
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
                    tempNum = yeMhazardDescElements.size();
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
                    tempNum = yeProfessionElements.size();
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
                    tempNum = damageTypeElements.size();
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
                    tempNum = yePossiblyHazardElements.size();
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
                    tempNum = activityidElements.size();
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
                    tempNum = yeRiskGradeTempElements.size();
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
                    tempNum = yeHazardCateElements.size();
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
                    tempNum = yeHazardCateElements.size();
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
                    tempNum = yeHazardCateElements.size();
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
                    tempNum = yeHazardCateElements.size();
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
                    tempNum = yeHazardCateElements.size();
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

    public int getTempNum() {
        return tempNum;
    }

    public void setTempNum(int tempNum) {
        this.tempNum = tempNum;
    }

    public int tempNum;

    /**
     * @throws IOException
     * @description 还原查询条件为默认值
     */
    public void setDefult() throws IOException {

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
        elementAction.click_left(reviewDangerListPage.search_Button());
    }

    /**
     * @param: [locator] 需要切换的frame
     * @return: void
     * @Description: 切换iframe
     * @throws:
     */
    public void switchFrame(Locator locator) {
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(locator);
    }

    // 选择已审核状态
    public void checkChecked() throws IOException {
        elementAction.click_left(reviewDangerListPage.checked_radio());
    }

    //选择待审核状态
    public void unCHecked() throws IOException {
        elementAction.click_left(reviewDangerListPage.checkPending_radio());
    }

    /**
     *
     *@param: []
     *@return: void
     *@Description: 针对已审核的数据,执行去审操作
     *@throws: 
     */
    public void reviewCallback() throws IOException {
        checkChecked();
        clickElement();
        elementAction.click_left(reviewDangerListPage.reviewCallback_Button());
        elementAction.switchToDefaultFrame();
        elementAction.click_left(reviewDangerListPage.check_confirm_btn());
    }

}
