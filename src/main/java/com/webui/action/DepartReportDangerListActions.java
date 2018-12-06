package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.DepartReportDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.TestBaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

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

    //  选择伤害类别:指定伤害类别
    public void checkDamageType(String damageString){
        switch (damageString){
            case "物体打击":
                WebElement element1 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='01']"));
                element1.click();
                break;
            case "车辆伤害":
                WebElement element2 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='02']"));
                element2.click();
                break;
            case "机械伤害":
                WebElement element3 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='03']"));
                element3.click();
                break;
            case "起重伤害":
                WebElement element4 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='04']"));
                element4.click();
                break;
            case "触电":
                WebElement element5 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='05']"));
                element5.click();
                break;
            case "淹溺":
                WebElement element6 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='06']"));
                element6.click();
                break;
            case "灼烫":
                WebElement element7 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='07']"));
                element7.click();
                break;
            case "火灾":
                WebElement element8 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='08']"));
                element8.click();
                break;
            case "高处坠落":
                WebElement element9 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='09']"));
                element9.click();
                break;
            case "坍塌":
                WebElement element10 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='10']"));
                element10.click();
                break;
            case "冒顶片帮":
                WebElement element11 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='11']"));
                element11.click();
                break;
            case "透水":
                WebElement element12 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='12']"));
                element12.click();
                break;
            case "放炮":
                WebElement element13 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='13']"));
                element13.click();
                break;
            case "瓦斯爆炸":
                WebElement element14 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='14']"));
                element14.click();
                break;
            case "火药爆炸":
                WebElement element15 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='15']"));
                element15.click();
                break;
            case "锅炉爆炸":
                WebElement element16 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='16']"));
                element16.click();
                break;
            case "容器爆炸":
                WebElement element17 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='17']"));
                element17.click();
                break;
            case "其他爆炸":
                WebElement element18 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='18']"));
                element18.click();
                break;
            case "中毒和窒息":
                WebElement element19 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='19']"));
                element19.click();
                break;
            case "其他伤害":
                WebElement element20 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='20']"));
                element20.click();
                break;
        }
    }

    public void checkDamageType(){

    }
}
