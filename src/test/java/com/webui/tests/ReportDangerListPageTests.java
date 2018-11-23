package com.webui.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.webui.action.DefultPageActions;
import com.webui.action.LoginPageActions;
import com.webui.action.ReportDangerListPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReportDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;

@Feature(value = "查询")
public class ReportDangerListPageTests extends TestBaseCase {
	ElementAction ea = new ElementAction();
	LoginPageActions lpa = new LoginPageActions();
	DefultPageActions dpa = new DefultPageActions();
	DefultPage dp = new DefultPage();
	ReportDangerListPage rdlp = new ReportDangerListPage();
	ReportDangerListPageActions rdlpa = new ReportDangerListPageActions();

	@Story(value = "风险点查询")
	@Test(description = "根据风险点类型验证查询功能")
	public void TC_searchByAddressCate() throws IOException, InterruptedException {
		lpa.signInInit("admin", "123456");
		dpa.openMenu(dp.aqfxfjgk_menu(), dp.ndfxbs_list(), dp.reportDangerList());
		ea.switchToFrame(rdlp.iframe_reportDangerList());
		rdlpa.searchByAddressCate("副井");
		for (int i = 0; i < rdlpa.getSearchData("风险点类型").size(); i++) {
			Assertion.VerityString(rdlpa.getSearchData("风险点类型").get(i), "副井");
		}
	}

	@Test(description = "根据隐患描述验证查询功能")
	public void TC_searchByYeMhazardDesc() throws IOException, InterruptedException {
		rdlpa.searchByYeMhazardDesc("瓦斯事故");
		for (int i = 0; i < rdlpa.getSearchData("隐患描述").size(); i++) {
			Assertion.VerityCationString(rdlpa.getSearchData("隐患描述").get(i), "瓦斯事故");
		}
	}

	@Test(description = "根据专业验证查询功能")
	public void TC_searchByYeProfession() throws IOException, InterruptedException {
		rdlpa.searchByYeProfession("采煤");
		for (int i = 0; i < rdlpa.getSearchData("专业").size(); i++) {
			Assertion.VerityCationString(rdlpa.getSearchData("专业").get(i), "采煤");
		}
	}
}
