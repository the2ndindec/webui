package com.webui.aqfxfjgk;

import com.webui.action.DepartReportDangerListActions;
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
    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\departDangers.properties";


    public String getTempDate() {
        return tempDate;
    }

    public void setTempDate(String tempDate) {
        this.tempDate = tempDate;
    }

    private String tempDate = functionUtil.formatterDate("yyyyMMddHHmmss");

    @Feature("查询")
    @Test(description = "验证添加数据功能")
    @Parameters({"hazardName", "yeProbability", "yeCost", "yeHazardCate", "activityname", "docSource", "sectionName", "yeStandard",
            "manageMeasure", "postname", "yeMhazardDesc", "hiddenLevel", "fineMoney"})
    public void TC_addData(String hazardName, String yeProbability, String yeCost, String yeHazardCate,
                           String activityname, String docSource, String sectionName, String yeStandard, String manageMeasure,
                           String postname, String yeMhazardDesc, String hiddenLevel, String fineMoney) throws IOException, InterruptedException {
        departReportDangerListActions.modifyMenu();
        departReportDangerListActions.goAdd();
        departReportDangerListActions.selectAddressCate();
        departReportDangerListActions.typeYeRecognizeTime();
        departReportDangerListActions.selectYeProfession();
        departReportDangerListActions.selectHazardName();
        departReportDangerListActions.checkDamageType();
        departReportDangerListActions.checkYeAccident();
        departReportDangerListActions.typeYePossiblyHazard(rp.readPropertiesFile(filePath,"yePossiblyHazard") + tempDate);//风险描述
        departReportDangerListActions.selectYeProbability();
        departReportDangerListActions.selectYeCost();//风险损失
        int temp1 = Integer.parseInt(elementAction.getTextByJS(departReportDangerListPage.yeProbability_select()));
        int temp2 = Integer.parseInt(elementAction.getTextByJS(departReportDangerListPage.yeCost_select()));
        int temp3 = temp1 * temp2;
        //验证风险值是否正确
        Assertion.VerityString(elementAction.getTextByJS(departReportDangerListPage.riskValue_textarea()), String.valueOf(temp3));
        departReportDangerListActions.selectYeHazardCate();//风险类型
        departReportDangerListActions.selectActivityName();//作业活动
        departReportDangerListActions.typeDocSource(docSource);//管控标准来源
        departReportDangerListActions.typeSectionName(sectionName);//  输入章节条款
        departReportDangerListActions.typeYeStandard(yeStandard);//输入标准内容
        departReportDangerListActions.typeManageMeasure(manageMeasure);//  输入管控措施
        departReportDangerListActions.selectPostName();//  选择责任岗位
        departReportDangerListActions.typeYeMhazardDesc(yeMhazardDesc + tempDate);
        departReportDangerListActions.selectHiddenLevel();
        departReportDangerListActions.typeFineMoney(fineMoney);
        departReportDangerListActions.doSave();

        departReportDangerListActions.goDepartReportDangerList();
        Assertion.VerityTextPresentPrecision(yeMhazardDesc + tempDate);
    }
}
