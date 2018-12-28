package com.webui.aqfxfjgk.basicdata;

import com.webui.action.aqfxfjgk.basicdata.HazardManagePageActions;
import com.webui.pageObject.HazardManagePage;
import com.webui.utils.Assertion;
import com.webui.utils.ReadProperties;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @Description:危险源页面功能测试
 * @Data 2018/12/27 16:06
 */
public class HazardManagePageTests extends TestBaseCase {

    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";

    HazardManagePageActions hmpa = new HazardManagePageActions();
    HazardManagePage hmp = new HazardManagePage();
    ReadProperties rp = new ReadProperties();


    @Feature("添加危险源")
    @Test(description = "验证添加危险源功能")
    public void TC_addHazard() throws IOException {
        hmpa.modifyMenu();
        hmpa.addHazard(rp.readPropertiesFile(filePath, "add_hazard_string") + hmpa.dataStr);
        Assertion.verityTextPresent(rp.readPropertiesFile(filePath, "add_hazard_string") + hmpa.dataStr);
    }

    @Feature("添加危险源")
    @Test(description = "验证在未输入危险源名称时是否有提示信息")
    public void TC_addHazardWithoutHazardString() throws IOException {
        hmpa.addHazardWithoutHazardString();
        Assertion.verityTextPresent("请填写信息");
    }

    @Feature("添加危险源")
    @Test(description = "验证在未选择危险源类型时是否有提示信息")
    public void TC_addHazardWithoutHazardType() throws IOException {
        hmpa.addHazardWithoutHazardSTYpe();
        Assertion.verityTextPresent("请选择");
    }
}
