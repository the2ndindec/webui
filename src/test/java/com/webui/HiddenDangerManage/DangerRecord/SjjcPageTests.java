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

    public void openMenu() throws IOException {
        dpa.openMenu(dp.yhpczl(), dp.aqxxlr(), dp.sjjc());
        ea.switchToFrame(sjjp.iframe_sjjc());
    }
}
