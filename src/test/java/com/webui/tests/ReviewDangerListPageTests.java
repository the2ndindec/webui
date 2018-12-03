package com.webui.tests;

import com.webui.action.ReviewDangerListPageActions;
import com.webui.pageObject.ReviewDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author the2n
 * @description 风险审核模块相关的测试案例
 * @Data 2018/11/27 16:56
 */
public class ReviewDangerListPageTests extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    ReviewDangerListPageActions reviewDangerListPageActions = new ReviewDangerListPageActions();
    ReviewDangerListPage reviewDangerListPage = new ReviewDangerListPage();

    Assertion assertion = new Assertion();


    @Feature("查询")
    @Test(description = "根据风险点类型验证查询功能")
    public void TC_searchByAddressCate() throws IOException, InterruptedException {
//        reviewDangerListPageActions.modifyMenu(defultPage.reviewDangerList());
        reviewDangerListPageActions.modifyMenu();
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());
        reviewDangerListPageActions.searchByAddressCate("材料库");
        if (assertion.AssertElementIsDispaly(reviewDangerListPage.data_tbody())) {
            log.info("根据查询条件为查询到相关数据");
        } else {
            for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险点类型").size(); i++) {
                Assertion.VerityString(reviewDangerListPageActions.getSearchData("风险点类型").get(i), "洗煤厂");
            }
        }
    }

    @Feature("查询")
    @Test(description = "根据辨识开始时间验证查询功能")
    public void TC_searchByyeRecognizeTimeBegin() throws IOException, InterruptedException, ParseException {
        reviewDangerListPageActions.searchByyeRecognizeTimeBegin("2018-11-20");
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("辨识时间").size(); i++) {
            if (reviewDangerListPageActions.compareTime("2018-11-20", reviewDangerListPageActions.getSearchData("辨识时间").get(i)))
                log.info("根据辨识开始时间验证查询功能==通过");
            else
                log.warn("根据辨识开始时间验证查询功能==失败");
        }
    }

    @Feature("查询")
    @Test(description = "根据辨识结束时间验证查询功能")
    public void TC_searchByyeRecognizeTimeEnd() throws IOException, InterruptedException, ParseException {
        reviewDangerListPageActions.searchByyeRecognizeTimeEnd("2018-11-30");
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("辨识时间").size(); i++) {
            if (reviewDangerListPageActions.compareTime(reviewDangerListPageActions.getSearchData("辨识时间").get(i), "2018-11-30"))
                log.info("根据辨识结束时间验证查询功能==通过");
            else
                log.warn("根据辨识结束时间验证查询功能==失败");
        }
    }

    @Feature("查询")
    @Test(description = "根据辨识时间验证查询功能")
    public void TC_searchByRecognizeTime() throws IOException, ParseException, InterruptedException {
        reviewDangerListPageActions.searchByRecognizeTime("2018-11-20", "2018-11-30");
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("辨识时间").size(); i++) {
            if (reviewDangerListPageActions.compareTime("2018-11-20", reviewDangerListPageActions.getSearchData("辨识时间").get(i)) &&
                    reviewDangerListPageActions.compareTime(reviewDangerListPageActions.getSearchData("辨识时间").get(i), "2018-11-30"))
                log.info("根据辨识时间验证查询功能==通过");
            else
                log.warn("根据辨识时间验证查询功能==失败");
        }
    }

    @Feature("审核")
    @Test(description = "审核通过测试,该方法暂时只能验证已审核列表中只有一条数据的情况")
    @Parameters({"remark"})
    public void TC_goReviewPass(String remark) throws IOException, InterruptedException {
        reviewDangerListPageActions.goReviewPassByRandom(remark);
        reviewDangerListPageActions.checkChecked();
        elementAction.sleep(2);
        Assertion.VerityString(reviewDangerListPageActions.getSearchData("风险描述").get(reviewDangerListPageActions.tempNum - 1), reviewDangerListPageActions.getTempString());
    }

    @Feature("审核")
    @Test(description = "审核驳回,不输入备注信息测试")
    public void TC_goReviewDismiss() throws IOException {
//        reviewDangerListPageActions.modifyMenu(defultPage.reviewDangerList());
        reviewDangerListPageActions.goReviewDismissWithoutRemark();
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerSource());
        Assertion.VerityString(elementAction.getText(reviewDangerListPage.check_remark_error()).trim(), "请填写备注！");
    }

    @Feature("审核")
    @Test(description = "全部去审功能")
    public void TC_undoReviewAll() throws IOException {
        reviewDangerListPageActions.modifyMenu();
        reviewDangerListPageActions.undoReviewAll();
        assertion.AssertElementIsDispaly(reviewDangerListPage.data_tbody());
    }

    @Feature("修改风险")
    @Test(description = "修改辨识时间为不正确的字段值,验证是否判断正确", enabled = false)
    public void TC_updateYeRecognizeTime() throws IOException {
        reviewDangerListPageActions.updateYeRecognizeTime("2015/5285//5");
        Assertion.VerityCationString(elementAction.getAlertText(), "不合法的日期格式");
        elementAction.alertConfirm();
    }

    @Feature("修改风险")
    @Test(description = "专业为默认字段值,验证是否判断正确")
    public void TC_updateYeProfessionSelectDefault() throws IOException {
        reviewDangerListPageActions.updateYeProfessionSelectDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请选择专业");
    }

    @Feature("修改风险")
    @Test(description = "危险源名称为空,验证是否判断正确")
    public void TC_updateHazardnameDefault() throws IOException {
//        reviewDangerListPageActions.modifyMenu();
        reviewDangerListPageActions.updateHazardnameDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请填写危险源");
    }

    @Feature("修改风险")
    @Test(description = "风险描述为空,验证是否判断正确")
    public void TC_updateYePossiblyHazard() throws IOException {
        reviewDangerListPageActions.updateYePossiblyHazardDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请填写风险描述");
    }

    @Feature("修改风险")
    @Test(description = "风险可能性为空,验证是否判断正确")
    public void TC_updateYeProbability() throws IOException {
        reviewDangerListPageActions.updateYeProbabilityDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请选择风险可能性");
    }

    @Feature("修改风险")
    @Test(description = "风险损失为空,验证是否判断正确")
    public void TC_updateYeCostDefault() throws IOException {
        reviewDangerListPageActions.updateYeCostDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "选择风险损失");
    }

    @Feature("修改风险")
    @Test(description = "验证风险值是否正确")
    public void TC_verifyRiskValue() throws IOException {
        reviewDangerListPageActions.updateYeCostDefault();
        reviewDangerListPageActions.updateYeCost();
        int temp1 = Integer.parseInt(elementAction.getTextByJS(reviewDangerListPage.update_yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getTextByJS(reviewDangerListPage.update_yeCost_select()));
        int temp3 = temp1 * temp2;
        Assertion.VerityString(elementAction.getTextByJS(reviewDangerListPage.update_riskValue_textarea()), String.valueOf(temp3));
    }

    @Feature("修改风险")
    @Test(description = "验证风险等级值是否正确")
    public void TC_yeRiskGrade() throws IOException {
        reviewDangerListPageActions.updateYeProbability();
        reviewDangerListPageActions.updateYeCost();
        int temp1 = Integer.parseInt(elementAction.getTextByJS(reviewDangerListPage.update_yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getTextByJS(reviewDangerListPage.update_yeCost_select()));
        int temp3 = temp1 * temp2;
        if (temp3 >= 1 && temp3 <= 6) {
            Assertion.VerityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "低风险");
        } else if (temp3 >= 8 && temp3 <= 12) {
            Assertion.VerityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "一般风险");
        } else if (temp3 >= 18 && temp3 <= 24) {
            Assertion.VerityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "较大风险");
        } else {
            Assertion.VerityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "重大风险");
        }
    }

    @Feature("修改风险")
    @Test(description = "验证风险类型值是否可以为空")
    public void TC_updateYeHazardCateDefault() throws IOException {

        reviewDangerListPageActions.updateYeHazardCateDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "选择风险类型");
    }

    @Feature("修改风险")
    @Test(description = "验证标准内容值是否可以为空")
    public void TC_updateYeStandardDefault() throws IOException {

        reviewDangerListPageActions.updateYeStandardDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写标准内容");
    }

    @Feature("修改风险")
    @Test(description = "验证管控措施值是否可以为空")
    public void TC_updateManageMeasureDefault() throws IOException {
        reviewDangerListPageActions.updateManageMeasureDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写管控措施");
    }

    @Feature("修改风险")
    @Test(description = "验证管控措施值是否可以为空")
    public void TC_updatePostNameDefault() throws IOException {

        reviewDangerListPageActions.updateYeProbability();
        reviewDangerListPageActions.updateYeCost();
        reviewDangerListPageActions.updatePostNameDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写岗位");
    }

    @Feature("修改风险")
    @Test(description = "验证管控措施值是否可以为空")
    public void TC_updateYeMhazardDescDefault() throws IOException {
        reviewDangerListPageActions.modifyMenu();
        reviewDangerListPageActions.switchToUpdatePage();
        reviewDangerListPageActions.updateYeMhazardDescDefault();
        Assertion.VerityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写隐患描述");
    }
}
