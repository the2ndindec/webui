package com.webui.aqfxfjgk.annualrisk;

import com.webui.action.aqfxfjgk.annualrisk.DepartReportDangerListActions;
import com.webui.pageObject.DepartReportDangerListPage;
import com.webui.utils.*;
import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description 部门风险上报页面
 * @Data 2018/12/07 16:22
 */
public class DepartReportDangerListPageTests extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DepartReportDangerListActions departReportDangerListActions = new DepartReportDangerListActions();
    DepartReportDangerListPage departReportDangerListPage = new DepartReportDangerListPage();
    FunctionUtil functionUtil = new FunctionUtil();

    ReadProperties rp = new ReadProperties();
    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";
    private String tempDate = functionUtil.formatterDate("yyyyMMddHHmmss");

    @Feature("添加数据")
    @Test(description = "验证添加数据功能")
    @Parameters({"docSource", "sectionName", "yeStandard", "manageMeasure"})
    public void TC_addData(String docSource, String sectionName, String yeStandard, String manageMeasure) throws IOException, InterruptedException {
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
        int temp1 = Integer.parseInt(elementAction.getTextByJS(departReportDangerListPage.yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getTextByJS(departReportDangerListPage.yeCost_select()));
        int temp3 = temp1 * temp2;
        //验证风险值是否正确
        Assertion.verityString(elementAction.getTextByJS(departReportDangerListPage.riskValue_textarea()), String.valueOf(temp3));
        departReportDangerListActions.selectYeHazardCate();//风险类型
        departReportDangerListActions.selectActivityName();//作业活动
        departReportDangerListActions.typeDocSource(docSource);//管控标准来源
        departReportDangerListActions.typeSectionName(sectionName);//  输入章节条款
        departReportDangerListActions.typeYeStandard(yeStandard);//输入标准内容
        departReportDangerListActions.typeManageMeasure(manageMeasure);//  输入管控措施
        departReportDangerListActions.selectPostName();//  选择责任岗位
        departReportDangerListActions.typeYeMhazardDesc(rp.readPropertiesFile(filePath,"yeMhazardDesc"));
        departReportDangerListActions.selectHiddenLevel();
        departReportDangerListActions.typeFineMoney(rp.readPropertiesFile(filePath, "fineMoney"));
        departReportDangerListActions.doSubRep();
//        departReportDangerListActions.goDepartReportDangerList();
//        departReportDangerListActions.checkReported();
//        elementAction.sleep(2);
//        Assertion.verityTextPresentPrecision(rp.readPropertiesFile(filePath,"yeMhazardDesc"));
    }

    @Feature("验证必填项")
    @Test(description = "验证辨识时间为空时是否提示")
    public void TC_checkYeRecognizeTime() throws IOException {
        departReportDangerListActions.modifyMenu();
        departReportDangerListActions.goAdd();
        departReportDangerListActions.doCheckYeRecognizeTime();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请填写辨识时间");
        departReportDangerListActions.typeYeRecognizeTime();
    }

    @Feature("验证必填项")
    @Test(description = "验证专业为空时是否提示")
    public void TC_checkYeProfession() throws IOException {
        departReportDangerListActions.doCheckYeProfession();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请选择专业");
        departReportDangerListActions.selectYeProfession();
    }

    @Feature("验证必填项")
    @Test(description = "验证风险描述为空时是否提示")
    public void TC_checkYePossiblyHazard() throws IOException {
        departReportDangerListActions.doCheckYePossiblyHazard();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请填写风险描述");
        departReportDangerListActions.typeYePossiblyHazard("测试");
    }

    @Feature("验证必填项")
    @Test(description = "验证风险可能性为空时是否提示")
    public void TC_CheckYeProbability() throws IOException {
        departReportDangerListActions.checkYeProbability();
        Assertion.verityCationString(elementAction.getText(departReportDangerListPage.error_tip()), "请选择风险可能性");
        departReportDangerListActions.selectYeProbability();
    }
}
