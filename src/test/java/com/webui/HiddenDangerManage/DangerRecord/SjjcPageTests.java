package com.webui.HiddenDangerManage.DangerRecord;

import com.webui.action.DefultPageActions;
import com.webui.action.HiddenDangerManage.DangerRecord.SjjcPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.SjjcPage;
import com.webui.utils.*;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author the2n
 * @date 2019/01/25 16:32
 */
public class SjjcPageTests extends TestBaseCase {

    SjjcPageActions sjjcpa = new SjjcPageActions();
    SjjcPage sjjp = new SjjcPage();
    DefultPageActions dpa = new DefultPageActions();
    DefultPage dp = new DefultPage();
    ElementAction ea = new ElementAction();
    ReadProperties rp = new ReadProperties();
    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";

    @Story("查询")
    @Test(description = "验证结束时间进行查询")
    @Description("根据结束时间进行查询")
    public void TC_searchexamDateEnd() throws IOException, ParseException {
        openMenu();
        sjjcpa.searchByexamDateEnd("2019-01-04");
        for (String data : sjjcpa.getSearchData("日期")) {
            Assertion.verifyTimeEnd("2019-01-04", data);
        }
    }

    @Story("查询")
    @Test(description = "验证班次进行查询")
    @Description("根据班次进行查询")
    public void TC_searchByShift() throws IOException {
        sjjcpa.reset();
        sjjcpa.searchByShift("中班");
        for (String shiftStr : sjjcpa.getSearchData("班次")
        ) {
            Assertion.verityString(shiftStr, "中班");
        }
    }

    @Story("验证必填项")
    @Test(description = "验证班次是否可以为空")
    @Description("验证录入/编辑数据时班次是否可以为空")
    public void TC_checkTip_Shift() throws IOException {
        sjjcpa.switchPage(sjjp.add_Button(), sjjp.iframe_add());
        ea.fireEventBlur(sjjp.shift_area());
        Assertion.verityString(ea.getText(sjjp.checkTip()), "请选择班次");
    }

    @Test(description = "验证班次是否可以为空")
    public void TC_viewDetail() throws IOException {
        sjjcpa.viewDetail("222");
//        String s = sjjcpa.getDataMap().get("问题描述");
//        String s2 = FunctionUtil.replaceBlank(ea.getAttribute(driver.findElement(By.xpath(".//table[@class='formtable']//tr[11]/td[2]/textarea")),"innerHTML"));
        Assertion.verityString(FunctionUtil.replaceBlank(ea.getText(".//table[@class='formtable']//tr[11]/td[2]")), sjjcpa.getDataMap().get("问题描述"));
    }

    @Story("添加数据")
    @Test(description = "添加数据")
    @Description("录入数据")
    public void TC_add() throws IOException, InterruptedException {
        openMenu();
        sjjcpa.switchPage(sjjp.add_Button(), sjjp.iframe_add());
//        sjjcpa.editShift("1");
        sjjcpa.editShift();
        sjjcpa.editAddress("测试风险点1");
        sjjcpa.editSjjcDept(rp.readPropertiesFile(filePath, "SjjcDept"));
        sjjcpa.editsjjcCheckMan("测试员");
        sjjcpa.editDanger();
        sjjcpa.editDutyUnit("xx煤矿");
        sjjcpa.editDutyMan("管理员");
        sjjcpa.editHiddenNature("一般隐患A级");
        sjjcpa.editHiddenType("通风");
        sjjcpa.editProblemDesc("aotu自动输入内容3");
        sjjcpa.editLimitDate("2019-01-31");
        sjjcpa.doDraft();
        Assertion.verityCationString(ea.getAttribute(sjjp.tip(), "innerText"), "隐患检查添加成功");
        sjjcpa.doClose();
        ea.switchToFrame(sjjp.iframe_sjjc());
        Assertion.verityTextPresent(rp.readPropertiesFile(filePath, "SjjcDept"));
    }

    public void openMenu() throws IOException {
        dpa.openMenu(dp.yhpczl(), dp.aqxxlr(), dp.sjjc());
        ea.switchToFrame(sjjp.iframe_sjjc());
        ea.sleep(1);
    }
}
