package com.webui.aqfxfjgk.zxfxbs;

import com.webui.action.DefultPageActions;
import com.webui.action.aqfxfjgk.zxfxbs.XgzmPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.XgzmPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.ReadProperties;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @Description:
 * @Data 2019/01/02 16:29
 */
@Listeners
public class XgzmPageTests extends TestBaseCase {

    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\parameters.properties";

    XgzmPageActions xpa = new XgzmPageActions();
    XgzmPage xp =new XgzmPage();
    ReadProperties rp = new ReadProperties();
    ElementAction ea = new ElementAction();

    DefultPage dp = new DefultPage();
    DefultPageActions dpa = new DefultPageActions();

    @Story("添加风险评估")
    @Description("添加新工作面风险评估")
    @Test(description = "验证添加风险评估功能")
    public void TC_addData() throws IOException {
        dpa.openMenu(dp.aqfxfjgk_menu(),dp.zxfxbs(),dp.xgzm());
        xpa.motifyFrame(xp.iframe_xgzm());
        xpa.addData(rp.readPropertiesFile(filePath,"xgzm_name"),rp.readPropertiesFile(filePath,"xgzm_leaderType"),rp.readPropertiesFile(filePath,"xgzm_leader"),rp.readPropertiesFile(filePath,"xgzm_time")
        ,rp.readPropertiesFile(filePath,"xgzm_teamMembers"),rp.readPropertiesFile(filePath,"xgzm_location"),rp.readPropertiesFile(filePath,"xgzm_remark"));
        Assertion.verityTextPresentPrecision(rp.readPropertiesFile(filePath,"xgzm_name"));
    }
    @Story("添加风险评估")
    @Description("添加新工作面风险评估")
    @Test(description = "验证添加风险评估功能")
    public void TC_detailOfEvaluation() throws IOException {
        dpa.openMenu(dp.aqfxfjgk_menu(),dp.zxfxbs(),dp.xgzm());
        xpa.motifyFrame(xp.iframe_xgzm());
        xpa.detailOfEvaluation("xxx工作面风险评估yePossiblyHazard");
        Assertion.verityString(ea.getText(".//*[@id='formobj']/table/tbody/tr[2]/td[2]"),xpa.getDataMap().get("辨识时间"));
    }

}
