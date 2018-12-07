package com.webui.tests;

import com.webui.action.DepartReportDangerListActions;
import com.webui.pageObject.DepartReportDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.TestBaseCase;
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

    public String tempDate=functionUtil.formatterDate("yyyyMMddHHmmss");

    @Feature("查询")
    @Test(description = "验证根据退休编号查询功能")
    @Parameters({"hazardName", "yePossiblyHazard","yeProbability","yeCost","yeHazardCate","activityname","docSource","sectionName","yeStandard",
    "manageMeasure","postname","yeMhazardDesc","hiddenLevel","fineMoney"})
    public void TC_addData(String hazardName, String yePossiblyHazard, String yeProbability, String yeCost, String yeHazardCate,
                           String activityname, String docSource, String sectionName, String yeStandard, String manageMeasure,
                           String postname, String yeMhazardDesc, String hiddenLevel, String fineMoney) throws IOException, InterruptedException {
        departReportDangerListActions.modifyMenu();
        departReportDangerListActions.goAdd();
        departReportDangerListActions.selectAddressCate();
        departReportDangerListActions.typeYeRecognizeTime();
        departReportDangerListActions.selectYeProfession();
        departReportDangerListActions.selectHazardName(hazardName); //危险源
        departReportDangerListActions.checkDamageType();
        departReportDangerListActions.checkYeAccident();
        departReportDangerListActions.typeYePossiblyHazard(yePossiblyHazard);//风险描述
        departReportDangerListActions.selectYeProbability(yeProbability);//风险可能性
        departReportDangerListActions.selectYeCost(yeCost);//风险损失
        int temp1 = Integer.parseInt(elementAction.getTextByJS(departReportDangerListPage.yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getTextByJS(departReportDangerListPage.yeCost_select()));
        int temp3 = temp1 * temp2;
        //验证风险值是否正确
        Assertion.VerityString(elementAction.getTextByJS(departReportDangerListPage.riskValue_textarea()), String.valueOf(temp3));
        departReportDangerListActions.selectYeHazardCate(yeHazardCate);//风险类型
        departReportDangerListActions.selectActivityName(activityname);//作业活动
        departReportDangerListActions.typeDocSource(docSource);//管控标准来源
        departReportDangerListActions.typeSectionName(sectionName);//  输入章节条款
        departReportDangerListActions.typeYeStandard(yeStandard);//输入标准内容
        departReportDangerListActions.typeManageMeasure(manageMeasure);//  输入管控措施
        departReportDangerListActions.selectPostName(postname);//  选择责任岗位
        departReportDangerListActions.typeYeMhazardDesc(yeMhazardDesc+tempDate);
        departReportDangerListActions.selectHiddenLevel(hiddenLevel);
        departReportDangerListActions.typeFineMoney(fineMoney);
        departReportDangerListActions.doSave();

        departReportDangerListActions.goDepartReportDangerList();
        Assertion.VerityTextPresentPrecision(yeMhazardDesc+tempDate);
    }
}
