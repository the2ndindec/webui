package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.DepartReportDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.TestBaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;

/**
 * @author the2n
 * @description
 * @Data 2018/12/06 15:49
 */
public class DepartReportDangerListActions extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DefultPageActions defultPageActions = new DefultPageActions();

    DepartReportDangerListPage departReportDangerListPage = new DepartReportDangerListPage();
    DefultPage defultPage = new DefultPage();
    FunctionUtil functionUtil = new FunctionUtil();

    public void modifyMenu() throws IOException {
        defultPageActions.openMenu(defultPage.aqfxfjgk_menu(), defultPage.ndfxbs_list(), defultPage.departReportDangerList());
        elementAction.switchToFrame(departReportDangerListPage.iframe_departReportDangerList());
    }

    // 切换到录入界面
    public void goAdd() throws IOException {
        elementAction.click_left(departReportDangerListPage.add_Button());
        elementAction.switchToFrame(departReportDangerListPage.iframe_goAddDepartDangerSource());
    }

    //  选择风险点类型
    public void selectAddressCate() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.addressCate_select(), elementAction.getOption(departReportDangerListPage.addressCate_select()));
    }

    //  输入辨识时间
    public void typeYeRecognizeTime() throws IOException {
        elementAction.type(departReportDangerListPage.yeRecognizeTime_textarea(),functionUtil.formatterDate("yyyy-MM-dd"));
    }

    //  选择专业
    public void selectYeProfession() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.yeProfession_select(),elementAction.getOption(departReportDangerListPage.yeProfession_select()));
    }

    //  选择危险源
    public void selectHazardName(String hazardName) throws IOException {
        elementAction.click_left(departReportDangerListPage.hazardNameList());
        WebElement hazard = driver.findElement(By.xpath(".//*[@id='hazardname']//div[text()='"+hazardName+"']"));
        hazard.click();
    }
}
