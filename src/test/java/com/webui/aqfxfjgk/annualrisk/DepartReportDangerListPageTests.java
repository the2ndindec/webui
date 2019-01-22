package com.webui.aqfxfjgk.annualrisk;

import com.webui.action.aqfxfjgk.annualrisk.DepartReportDangerListActions;
import com.webui.pageObject.DepartReportDangerListPage;
import com.webui.utils.*;
import io.qameta.allure.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author the2n
 * @description 部门风险上报页面
 * @Data 2018/12/07 16:22
 */
@Feature("部门风险上报")
public class DepartReportDangerListPageTests extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DepartReportDangerListActions departReportDangerListActions = new DepartReportDangerListActions();
    DepartReportDangerListPage departReportDangerListPage = new DepartReportDangerListPage();

    ReadProperties rp = new ReadProperties();
    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";


    @Description("添加数据后直接提交审核")
    @Story("添加数据")
    @Test(description = "验证添加数据功能:保存并提交数据")
    @Parameters({"docSource", "sectionName", "yeStandard", "manageMeasure"})
    public void TC_addData(String docSource, String sectionName, String yeStandard, String manageMeasure) throws IOException {
        departReportDangerListActions.modifyMenu();
        departReportDangerListActions.goAdd();
        departReportDangerListActions.selectAddressCate();
        departReportDangerListActions.typeYeRecognizeTime();
        departReportDangerListActions.selectYeProfession();
        departReportDangerListActions.selectHazardName();
        departReportDangerListActions.checkDamageType();
        departReportDangerListActions.checkYeAccident();
        departReportDangerListActions.typeYePossiblyHazard(rp.readPropertiesFile(filePath, "yePossiblyHazard"));//风险描述
        departReportDangerListActions.selectYeProbability();
        departReportDangerListActions.selectYeCost();//风险损失
        int temp1 = Integer.parseInt(elementAction.getValueByJS(departReportDangerListPage.yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getValueByJS(departReportDangerListPage.yeCost_select()));
        int temp3 = temp1 * temp2;
        //验证风险值是否正确
        Assertion.verityString(elementAction.getValueByJS(departReportDangerListPage.riskValue_textarea()), String.valueOf(temp3));
        departReportDangerListActions.selectYeHazardCate();//风险类型
        departReportDangerListActions.selectActivityName();//作业活动
        departReportDangerListActions.typeDocSource(docSource);//管控标准来源
        departReportDangerListActions.typeSectionName(sectionName);//  输入章节条款
        departReportDangerListActions.typeYeStandard(yeStandard);//输入标准内容
        departReportDangerListActions.typeManageMeasure(manageMeasure);//  输入管控措施
        departReportDangerListActions.selectPostName();//  选择责任岗位
        departReportDangerListActions.typeYeMhazardDesc(rp.readPropertiesFile(filePath, "yeMhazardDesc"));
        departReportDangerListActions.selectHiddenLevel();
        departReportDangerListActions.typeFineMoney(rp.readPropertiesFile(filePath, "fineMoney"));
        departReportDangerListActions.doSubRep();
        departReportDangerListActions.goDepartReportDangerList();
        departReportDangerListActions.checkReported();
        Assertion.verityTextPresentPrecision(rp.readPropertiesFile(filePath,"yeMhazardDesc"));
    }

    @Story("添加数据")
    @Description("添加数据后保存")
    @Test(description = "验证添加数据功能:保存数据")
    @Parameters({"docSource", "sectionName", "yeStandard", "manageMeasure"})
    public void TC_addDataSave(String docSource, String sectionName, String yeStandard, String manageMeasure) throws IOException {

            departReportDangerListActions.modifyMenu();

            departReportDangerListActions.goAdd();
            departReportDangerListActions.selectAddressCate();
            departReportDangerListActions.typeYeRecognizeTime();
            departReportDangerListActions.selectYeProfession();
            departReportDangerListActions.selectHazardName();
            departReportDangerListActions.checkDamageType();
            departReportDangerListActions.checkYeAccident();
            departReportDangerListActions.typeYePossiblyHazard(rp.readPropertiesFile(filePath, "yePossiblyHazard"));//风险描述
            departReportDangerListActions.selectYeProbability();
            departReportDangerListActions.selectYeCost();//风险损失
            int temp1 = Integer.parseInt(elementAction.getValueByJS(departReportDangerListPage.yeProbability_select()));
            int temp2 = Integer.parseInt(elementAction.getValueByJS(departReportDangerListPage.yeCost_select()));
            int temp3 = temp1 * temp2;
            //验证风险值是否正确
            Assertion.verityString(elementAction.getValueByJS(departReportDangerListPage.riskValue_textarea()), String.valueOf(temp3));
            departReportDangerListActions.selectYeHazardCate();//风险类型
            departReportDangerListActions.selectActivityName();//作业活动
            departReportDangerListActions.typeDocSource(docSource);//管控标准来源
            departReportDangerListActions.typeSectionName(sectionName);//  输入章节条款
            departReportDangerListActions.typeYeStandard(yeStandard);//输入标准内容
            departReportDangerListActions.typeManageMeasure(manageMeasure);//  输入管控措施
            departReportDangerListActions.selectPostName();//  选择责任岗位
            departReportDangerListActions.typeYeMhazardDesc(rp.readPropertiesFile(filePath, "yeMhazardDesc"));
            departReportDangerListActions.selectHiddenLevel();
            departReportDangerListActions.typeFineMoney(rp.readPropertiesFile(filePath, "fineMoney"));
            departReportDangerListActions.doSave();
            departReportDangerListActions.goDepartReportDangerList();
            Assertion.verityTextPresentPrecision(rp.readPropertiesFile(filePath,"yeMhazardDesc"));
    }

    @Story("验证必填项")
    @Test(description = "验证辨识时间为空时是否提示")
    @Description("录入风险时，辨识时间为空是否有提示信息")
    public void TC_checkYeRecognizeTime() throws IOException {
        departReportDangerListActions.goAdd();
        departReportDangerListActions.doCheckYeRecognizeTime();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请填写辨识时间");
        departReportDangerListActions.typeYeRecognizeTime();
    }

    @Story("验证必填项")
    @Test(description = "验证专业为空时是否提示")
    @Description("录入风险时，专业为空是否有提示信息")
    public void TC_checkYeProfession() throws IOException {
        departReportDangerListActions.doCheckYeProfession();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请选择专业");
        departReportDangerListActions.selectYeProfession();
    }

    @Story("验证必填项")
    @Test(description = "验证风险描述为空时是否提示")
    @Description("录入风险时，风险描述为空是否有提示信息")
    public void TC_checkYePossiblyHazard() throws IOException {
        departReportDangerListActions.doCheckYePossiblyHazard();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请填写风险描述");
        departReportDangerListActions.typeYePossiblyHazard("测试");
    }

    @Story("验证必填项")
    @Test(description = "验证风险可能性为空时是否提示")
    @Description("录入风险时，风险可能性为空是否有提示信息")
    public void TC_CheckYeProbability() throws IOException {
        departReportDangerListActions.checkYeProbability();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请选择风险可能性");
        departReportDangerListActions.selectYeProbability();
    }

    @Story("查询")
    @Test(description = "验证根据辨识开始时间进行查询")
    @Description("根据辨识开始时间进行查询")
    public void TC_searchByYeRecognizeTime_begin() throws IOException, ParseException {
        departReportDangerListActions.modifyMenu();
        departReportDangerListActions.checkReported();
        departReportDangerListActions.searchByyeRecognizeTime_begin("2019-01-04");
        for (int i = 0; i < departReportDangerListActions.getSearchData("辨识时间").size(); i++) {
            Assertion.verifyTimeBegin("2019-01-04", departReportDangerListActions.getSearchData("辨识时间").get(i));
        }
    }

    @Story("查询")
    @Test(description = "验证根据辨识结束时间进行查询")
    @Description("根据辨识结束时间进行查询")
    public void TC_searchByYeRecognizeTime_end() throws IOException, ParseException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByyeRecognizeTime_end("2019-01-04");
        for (int i = 0; i < departReportDangerListActions.getSearchData("辨识时间").size(); i++) {
            Assertion.verifyTimeEnd("2019-01-04", departReportDangerListActions.getSearchData("辨识时间").get(i));
        }
    }

    @Story("查询")
    @Test(description = "验证根据辨识时间段进行查询")
    @Description("根据辨识时间段进行查询")
    public void TC_searchByYeRecognizeTime() throws IOException, ParseException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByyeRecognizeTime("2019-01-04", "2019-01-08");
        for (int i = 0; i < departReportDangerListActions.getSearchData("辨识时间").size(); i++) {
            Assertion.verifyTime("2019-01-04", "2019-01-08", departReportDangerListActions.getSearchData("辨识时间").get(i));
        }
    }

    @Test(description = "验证根据隐患描述进行查询")
    @Story("查询")
    @Description("根据隐患描述进行查询")
    public void TC_searchByYeMhazardDesc() throws IOException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByYeMhazardDesc("1");
        for (int i = 0; i < departReportDangerListActions.getSearchData("隐患描述").size(); i++) {
            Assertion.verityCationString(departReportDangerListActions.getSearchData("辨识时间").get(i), "1");
        }
    }

    @Test(description = "验证根据专业进行查询")
    @Parameters({"yeProfession"})
    @Step("选择查询条件专业为：{0}")
    @Story("查询")
    @Description("根据专业进行查询")
    public void TC_searchByyeProfession(String yeProfession) throws IOException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByyeProfession(yeProfession);
        for (int i = 0; i < departReportDangerListActions.getSearchData("专业").size(); i++) {
            Assertion.verityString(departReportDangerListActions.getSearchData("专业").get(i), yeProfession);
        }
    }

    @Test(description = "验证根据伤害类别进行查询")
    @Parameters({"damageType"})
    @Story("查询")
    @Description("根据伤害类别进行查询")
    public void TC_searchBydamageType(String damageType) throws IOException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchBydamageType(damageType);
        for (int i = 0; i < departReportDangerListActions.getSearchData("伤害类别").size(); i++) {
            Assertion.verityString(departReportDangerListActions.getSearchData("伤害类别").get(i), damageType);
        }
    }

    @Test(description = "验证根据风险描述进行查询")
    @Parameters({"yePossiblyHazard"})
    @Story("查询")
    @Description("根据风险描述进行查询")
    public void TC_searchByyePossiblyHazard(String yePossiblyHazard) throws IOException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByyePossiblyHazard(yePossiblyHazard);
        for (int i = 0; i < departReportDangerListActions.getSearchData("风险描述").size(); i++) {
            Assertion.verityCationString(departReportDangerListActions.getSearchData("风险描述").get(i), yePossiblyHazard);
        }
    }

    @Story("查询")
    @Test
    @Parameters({"activity"})
    @Description("根据作业活动进行查询")
    public void TC_searchByactivity(String activity) throws IOException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByactivity(activity);
        for (int i = 0; i < departReportDangerListActions.getSearchData("作业活动").size(); i++) {
            Assertion.verityString(departReportDangerListActions.getSearchData("作业活动").get(i), activity);
        }
    }

    @Story("查询")
    @Test(description = "根据风险等级进行查询")
    @Parameters({"yeRiskGrade"})
    @Description("验证根据风险等级查询功能是否正确")
    public void TC_searchByyeRiskGrade(String yeRiskGrade) throws IOException {
        departReportDangerListActions.doReset();
        departReportDangerListActions.searchByyeRiskGrade(yeRiskGrade);
        for (int i = 0; i < departReportDangerListActions.getSearchData("风险等级").size(); i++) {
            Assertion.verityString(departReportDangerListActions.getSearchData("风险等级").get(i), yeRiskGrade);
        }
    }

    @Test
    @Description("验证在未选择数据的情况下执行查看，是否有提示信息")
    public void TC_verifyTipOfDetail() throws IOException {
        departReportDangerListActions.selecttoBeReported();
        departReportDangerListActions.toDoWithoutData(departReportDangerListPage.detail_Button());
        Assertion.verityString(elementAction.getAttribute(departReportDangerListPage.tip(),"innerText"),"请选择查看项目");
    }
    @Test
    @Description("验证在未选择数据的情况下执行编辑，是否有提示信息")
    public void TC_verifyTipOfUpdate() throws IOException {
        departReportDangerListActions.toDoWithoutData(departReportDangerListPage.update_Button());
        Assertion.verityString(elementAction.getAttribute(departReportDangerListPage.tip(),"innerText"),"请选择一条需要编辑的条目");
    }
    @Test
    @Description("验证在未选择数据的情况下执行上报，是否有提示信息")
    public void TC_verifyTipOfReport() throws IOException {
        departReportDangerListActions.toDoWithoutData(departReportDangerListPage.goReport_Button());
        Assertion.verityString(elementAction.getAttribute(departReportDangerListPage.tip(),"innerText"),"请选择需要上报的条目");
    }
    @Test
    @Description("验证在未选择数据的情况下执行删除，是否有提示信息")
    public void TC_verifyTipOfDelete() throws IOException {
        departReportDangerListActions.toDoWithoutData(departReportDangerListPage.deleteALLSelect_Button());
        Assertion.verityString(elementAction.getAttribute(departReportDangerListPage.tip(),"innerText"),"请选择需要删除的条目");
    }
    @Test
    @Description("验证在未选择数据的情况下执行撤回，是否有提示信息")
    public void TC_verifyTipOfBack() throws IOException {
        departReportDangerListActions.checkReported();
        departReportDangerListActions.toDoWithoutData(departReportDangerListPage.toReportCallback_Button());
        Assertion.verityString(elementAction.getAttribute(departReportDangerListPage.tip(),"innerText"),"请选择需要撤回的数据");
    }
}
