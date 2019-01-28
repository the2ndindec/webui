package com.webui.HiddenDangerManage.DangerRecord;

import com.webui.action.DefultPageActions;
import com.webui.action.HiddenDangerManage.DangerRecord.SjjcPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.SjjcPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Description;
import io.qameta.allure.Story;
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

    @Story("验证必填项")
    @Test(description = "验证班次是否可以为空")
    @Description("验证录入/编辑数据时班次是否可以为空")
    public void TC_checkTip_Shift() throws IOException {
        sjjcpa.switchPage(sjjp.add_Button(),sjjp.iframe_add());
        ea.fireEventBlur(sjjp.shift_area());
        Assertion.verityString(ea.getText(sjjp.checkTip()),"请选择班次");
    }

    @Story("添加数据")
    @Test(description = "添加数据")
    @Description("录入数据")
    public void TC_add() throws IOException {
        openMenu();
        sjjcpa.switchPage(sjjp.add_Button(),sjjp.iframe_add());
        sjjcpa.editShift("1");
        sjjcpa.editAddress("测试风险点1");
        sjjcpa.editSjjcDept("auto_add1");
        sjjcpa.editsjjcCheckMan("测试员");
        sjjcpa.editDanger();
        sjjcpa.editDutyUnit("xx煤矿");
        sjjcpa.editDutyMan("管理员");
        sjjcpa.editHiddenNature("一般隐患A级");
        sjjcpa.editHiddenType("通风");
        sjjcpa.editProblemDesc("aotu自动输入内容2");
        sjjcpa.editLimitDate("2019-01-31");
        sjjcpa.doDraft();
        Assertion.verityCationString(ea.getAttribute(sjjp.tip(),"innerText"),"隐患检查添加成功");
        sjjcpa.doClose();
        ea.switchToFrame(sjjp.iframe_sjjc());
        Assertion.verityTextPresent("aotu自动输入内容2");
    }

    public void openMenu() throws IOException {
        dpa.openMenu(dp.yhpczl(), dp.aqxxlr(), dp.sjjc());
        ea.switchToFrame(sjjp.iframe_sjjc());
    }
}
