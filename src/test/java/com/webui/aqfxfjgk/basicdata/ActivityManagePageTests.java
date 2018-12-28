package com.webui.aqfxfjgk.basicdata;

import com.webui.action.aqfxfjgk.basicdata.ActivityManagePageActions;
import com.webui.pageObject.ActivityManagePage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.ReadProperties;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @Description:
 * @Data 2018/12/26 15:19
 */
public class ActivityManagePageTests extends TestBaseCase {

    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";

    ActivityManagePageActions ampa = new ActivityManagePageActions();
    ActivityManagePage amp = new ActivityManagePage();
    ReadProperties rp = new ReadProperties();
    ElementAction ea = new ElementAction();


    @Feature("添加作业活动")
    @Test(description = "验证添加作业活动功能")
    public void TC_addActivity() throws IOException {
        ampa.modifyMenu();
        ampa.addActivity(rp.readPropertiesFile(filePath, "add_activity_string"));
        //  验证作业活动数据是否添加成功
        Assertion.verityTextPresent(rp.readPropertiesFile(filePath, "add_activity_string") + ampa.dataStr);
    }

    @Feature("添加作业活动")
    @Test(description = "验证添加重复的作业活动")
    public void TC_addDupActivity() throws IOException {
        ampa.addDupActivity();
        //录入重复的作业活动，验证是否会显示错误的提示信息
        Assertion.verityTextPresent(ea.getText(amp.activity_tip()));
    }

    @Feature("查询作业活动")
    @Test(description = "验证查询功能")
    public void TC_search() throws IOException {
        ampa.searchActivity(rp.readPropertiesFile(filePath, "search_activity_string")+ampa.dataStr);
        /**
         * 用于模糊查询时验证
         */
//        for (String activityValue :
//                ampa.getActivityValue()) {
//            Assertion.VerityCationString(activityValue, rp.readPropertiesFile(filePath, "search_activity_string"));
//        }
        /**
         * 用于精确查询时验证
         */
        Assertion.verityTextPresent(rp.readPropertiesFile(filePath,"search_activity_string")+ampa.dataStr);
    }

    @Feature("查看作业活动")
    @Test(description = "验证查看功能")
    public void TC_detailRandom() throws IOException {
        ampa.detailOfActivity();
        Assertion.verityString(ea.getTextByJS(amp.activityName_area()), ampa.valueOfChooseActivity);
        ampa.closeDetail();
    }

    @Feature("删除作业活动")
    @Test(description = "验证删除功能")
    public void TC_delActivity() throws IOException {
        ampa.deleteActivityByValue(rp.readPropertiesFile(filePath,"search_activity_string")+ampa.dataStr);
        Assertion.verityNotTextPresent(rp.readPropertiesFile(filePath,"search_activity_string")+ampa.dataStr);
    }
}
