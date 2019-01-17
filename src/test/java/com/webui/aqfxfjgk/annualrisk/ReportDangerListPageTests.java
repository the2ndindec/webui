package com.webui.aqfxfjgk.annualrisk;

import com.webui.action.DefultPageActions;
import com.webui.action.aqfxfjgk.annualrisk.ReportDangerListPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReportDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.ParseException;

@Feature(value = "查询")
public class ReportDangerListPageTests extends TestBaseCase {
    ElementAction ea = new ElementAction();
    DefultPageActions dpa = new DefultPageActions();
    DefultPage dp = new DefultPage();
    ReportDangerListPage rdlp = new ReportDangerListPage();
    ReportDangerListPageActions rdlpa = new ReportDangerListPageActions();

    @Feature(value = "查询")
    @Test(description = "根据风险点类型验证查询功能")
    public void TC_searchByAddressCate() throws IOException, InterruptedException {
        dpa.openMenu(dp.aqfxfjgk_menu(), dp.ndfxgl_list(), dp.reportDangerList());
        ea.switchToFrame(rdlp.iframe_reportDangerList());
        rdlpa.searchByAddressCate("副井");
        for (int i = 0; i < rdlpa.getSearchData("风险点类型").size(); i++) {
            Assertion.verityString(rdlpa.getSearchData("风险点类型").get(i), "副井");
        }
    }

    @Feature(value = "查询")
    @Test(description = "根据隐患描述验证查询功能")
    public void TC_searchByYeMhazardDesc() throws IOException, InterruptedException {
        rdlpa.searchByYeMhazardDesc("瓦斯事故");
        for (int i = 0; i < rdlpa.getSearchData("隐患描述").size(); i++) {
            Assertion.verityCationString(rdlpa.getSearchData("隐患描述").get(i), "瓦斯事故");
        }
    }

    @Feature(value = "查询")
    @Test(description = "根据专业验证查询功能")
    public void TC_searchByYeProfession() throws IOException, InterruptedException {
        rdlpa.searchByYeProfession("采煤");
        for (int i = 0; i < rdlpa.getSearchData("专业").size(); i++) {
            Assertion.verityCationString(rdlpa.getSearchData("专业").get(i), "采煤");
        }
    }

    @Test(description = "关联风险点")
    public void TC_chooseAddress() throws IOException, InterruptedException {
        rdlpa.chooseAddressByRandom();
        Assertion.verityTextPresentPrecision(rdlpa.getAddStr());
    }

    @Feature(value = "查询")
    @Test(description = "根据辨识开始时间查询")
    public void TC_searchByRecognizeTimeBegin() throws IOException, ParseException {
        rdlpa.searchByRecognizeTimeBegin("2018-12-18");
        for (int i = 0; i < rdlpa.getSearchData("辨识时间").size(); i++) {
            Assertion.verifyTimeBegin("2018-12-18", rdlpa.getSearchData("辨识时间").get(i));
        }
    }

    @Feature(value = "查询")
    @Test(description = "根据辨识时间段查询")
    public void TC_searchBy() throws IOException, ParseException {
        rdlpa.searchByRecognizeTime("2018-12-28", "2019-01-10");
    }
}
