package com.webui.aqfxfjgk.annualrisk;

import com.webui.action.aqfxfjgk.annualrisk.ReviewDangerListPageActions;
import com.webui.pageObject.ReviewDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author the2n
 * @description 风险审核模块相关的测试案例
 * @Data 2018/11/27 16:56
 */
@Ignore
public class ReviewDangerListPageTests extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    ReviewDangerListPageActions reviewDangerListPageActions = new ReviewDangerListPageActions();
    ReviewDangerListPage reviewDangerListPage = new ReviewDangerListPage();

    Assertion assertion = new Assertion();
    FunctionUtil functionUtil = new FunctionUtil();


    @Feature("查询")
    @Test(description = "根据风险点类型验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"AddressCate"})
    public void TC_searchByAddressCate(String AddressCate) throws IOException, InterruptedException {
        reviewDangerListPageActions.modifyMenu();
        reviewDangerListPageActions.searchByAddressCate(AddressCate);
        if (assertion.assertElementIsDispaly(reviewDangerListPage.data_tbody())) {
            log.info("根据查询条件为查询到相关数据");
        } else {
            for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险点类型").size(); i++) {
                Assertion.verityString(reviewDangerListPageActions.getSearchData("风险点类型").get(i), AddressCate);
            }
        }
    }

    @Feature("查询")
    @Test(description = "根据辨识开始时间验证查询功能")
    public void TC_searchByyeRecognizeTimeBegin() throws IOException, InterruptedException, ParseException {
        reviewDangerListPageActions.searchByyeRecognizeTimeBegin("2018-11-20");
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("辨识时间").size(); i++) {
            if (functionUtil.compareTime("2018-11-20", reviewDangerListPageActions.getSearchData("辨识时间").get(i)))
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
            if (functionUtil.compareTime(reviewDangerListPageActions.getSearchData("辨识时间").get(i), "2018-11-30"))
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
            if (functionUtil.compareTime("2018-11-20", reviewDangerListPageActions.getSearchData("辨识时间").get(i)) &&
                    functionUtil.compareTime(reviewDangerListPageActions.getSearchData("辨识时间").get(i), "2018-11-30"))
                log.info("根据辨识时间验证查询功能==通过");
            else
                log.warn("根据辨识时间验证查询功能==失败");
        }
    }

    @Feature("查询")
    @Test(description = "根据隐患描述验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"hazardDesc"})
    public void TC_searchByYeMhazardDesc(String hazardDesc) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByYeMhazardDesc(hazardDesc);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("隐患描述").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("隐患描述").get(i), hazardDesc);
        }
    }

    @Feature("查询")
    @Test(description = "根据专业验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"profession"})
    public void TC_searchByYeProfession(String profession) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByYeProfession(profession);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("专业").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("专业").get(i), profession);
        }
    }

    @Feature("查询")
    @Test(description = "根据伤害类别验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"damageType"})
    public void TC_searchByDamageType(String damageType) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByDamageType(damageType);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("伤害类别").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("伤害类别").get(i), damageType);
        }
    }

    @Feature("查询")
    @Test(description = "根据风险描述验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"YePossiblyHazard"})
    public void TC_searchByYePossiblyHazard(String YePossiblyHazard) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByYePossiblyHazard(YePossiblyHazard);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险描述").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("风险描述").get(i), YePossiblyHazard);
        }
    }

    @Feature("查询")
    @Test(description = "根据作业活动验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"activityid"})
    public void TC_searchByActivityid(String activityid) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByActivityid(activityid);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("作业活动").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("作业活动").get(i), activityid);
        }
    }

    @Feature("查询")
    @Test(description = "根据风险等级验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"riskGrade"})
    public void TC_searchByYeRiskGrade(String riskGrade) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByYeRiskGrade(riskGrade);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险等级").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("风险等级").get(i), riskGrade);
        }
    }

    @Feature("查询")
    @Test(description = "根据风险类型验证查询功能")
    @Step("输入查询条件:{0}")
    @Parameters({"hazardCate"})
    public void TC_searchByYeHazardCate(String hazardCate) throws IOException, InterruptedException {
        reviewDangerListPageActions.searchByYeHazardCate(hazardCate);
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险类型").size(); i++) {
            Assertion.verityCationString(reviewDangerListPageActions.getSearchData("风险类型").get(i), hazardCate);
        }
    }

    @Feature("审核")
    @Test(description = "审核通过测试,该方法暂时只能验证已审核列表中只有一条数据的情况")
    @Parameters({"remark"})
    public void TC_goReviewPass(String remark) throws IOException, InterruptedException {
        reviewDangerListPageActions.goReviewPassByRandom(remark);
        reviewDangerListPageActions.checkChecked();
        elementAction.sleep(2);
        Assertion.verityString(reviewDangerListPageActions.getSearchData("风险描述").get(reviewDangerListPageActions.tempNum - 1), reviewDangerListPageActions.getTempString());
    }

    @Feature("审核")
    @Test(description = "审核驳回,不输入备注信息测试")
    public void TC_goReviewDismiss() throws IOException {
        reviewDangerListPageActions.goReviewDismissWithoutRemark();
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerSource());
        Assertion.verityString(elementAction.getText(reviewDangerListPage.check_remark_error()).trim(), "请填写备注！");
    }

    @Feature("审核")
    @Test(description = "全部去审功能")
    public void TC_undoReviewAll() throws IOException {
        reviewDangerListPageActions.modifyMenu();
        reviewDangerListPageActions.undoReviewAll();
        assertion.assertElementIsDispaly(reviewDangerListPage.data_tbody());
    }

    @Feature("修改风险")
    @Test(description = "修改辨识时间为不正确的字段值,验证是否判断正确", enabled = false)
    public void TC_updateYeRecognizeTime() throws IOException {
        reviewDangerListPageActions.updateYeRecognizeTime("2015/5285//5");
        Assertion.verityCationString(elementAction.getAlertText(), "不合法的日期格式");
        elementAction.alertConfirm();
    }

    @Feature("修改风险")
    @Test(description = "专业为默认字段值,验证是否判断正确")
    public void TC_updateYeProfessionSelectDefault() throws IOException {
        reviewDangerListPageActions.updateYeProfessionSelectDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请选择专业");
    }

    @Feature("修改风险")
    @Test(description = "危险源名称为空,验证是否判断正确")
    public void TC_updateHazardnameDefault() throws IOException {
        reviewDangerListPageActions.updateHazardnameDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请填写危险源");
    }

    @Feature("修改风险")
    @Test(description = "风险描述为空,验证是否判断正确")
    public void TC_updateYePossiblyHazard() throws IOException {
        reviewDangerListPageActions.updateYePossiblyHazardDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请填写风险描述");
    }

    @Feature("修改风险")
    @Test(description = "风险可能性为空,验证是否判断正确")
    public void TC_updateYeProbability() throws IOException {
        reviewDangerListPageActions.updateYeProbabilityDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "请选择风险可能性");
    }

    @Feature("修改风险")
    @Test(description = "风险损失为空,验证是否判断正确")
    public void TC_updateYeCostDefault() throws IOException {
        reviewDangerListPageActions.updateYeCostDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "选择风险损失");
    }

    @Feature("修改风险")
    @Test(description = "验证风险值是否正确")
    public void TC_verifyRiskValue() throws IOException {
        reviewDangerListPageActions.updateYeCostDefault();
        reviewDangerListPageActions.updateYeCost();
        int temp1 = Integer.parseInt(elementAction.getTextByJS(reviewDangerListPage.update_yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getTextByJS(reviewDangerListPage.update_yeCost_select()));
        int temp3 = temp1 * temp2;
        Assertion.verityCationString(elementAction.getTextByJS(reviewDangerListPage.update_riskValue_textarea()), String.valueOf(temp3));
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
            Assertion.verityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "低风险");
        } else if (temp3 >= 8 && temp3 <= 12) {
            Assertion.verityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "一般风险");
        } else if (temp3 >= 18 && temp3 <= 24) {
            Assertion.verityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "较大风险");
        } else {
            Assertion.verityString(elementAction.getTextByJS(reviewDangerListPage.update_yeRiskGrade_textarea()), "重大风险");
        }
    }

    @Feature("修改风险")
    @Test(description = "验证风险类型值是否可以为空")
    public void TC_updateYeHazardCateDefault() throws IOException {
        reviewDangerListPageActions.updateYeHazardCateDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "选择风险类型");
    }

    @Feature("修改风险")
    @Test(description = "验证标准内容值是否可以为空")
    public void TC_updateYeStandardDefault() throws IOException {

        reviewDangerListPageActions.updateYeStandardDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写标准内容");
    }

    @Feature("修改风险")
    @Test(description = "验证管控措施值是否可以为空")
    public void TC_updateManageMeasureDefault() throws IOException {
        reviewDangerListPageActions.updateManageMeasureDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写管控措施");
    }

    @Feature("修改风险")
    @Test(description = "验证管控措施值是否可以为空")
    public void TC_updatePostNameDefault() throws IOException {
        reviewDangerListPageActions.updateYeProbability();
        reviewDangerListPageActions.updateYeCost();
        reviewDangerListPageActions.updatePostNameDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写岗位");
    }

    @Feature("修改风险")
    @Test(description = "验证管控措施值是否可以为空")
    public void TC_updateYeMhazardDescDefault() throws IOException {
        reviewDangerListPageActions.switchToUpdatePage();
        reviewDangerListPageActions.updateYeMhazardDescDefault();
        Assertion.verityCationString(elementAction.getText(reviewDangerListPage.update_tip()), "填写隐患描述");
    }

    @Feature("修改风险")
    @Test(description = "导出数据")
    public void TC_export() throws IOException {
        reviewDangerListPageActions.exportXls();
    }

    @Feature("修改风险")
    @Test(description = "去审操作")
    public void TC_reviewCallback() throws IOException {
        reviewDangerListPageActions.reviewCallback();
        assertion.verityNotTextPresent(reviewDangerListPageActions.getTempString());
    }
}
