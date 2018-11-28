package com.webui.tests;

import com.webui.action.ReviewDangerListPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReviewDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description 风险审核模块相关的测试案例
 * @Data 2018/11/27 16:56
 */
public class ReviewDangerListPageTests extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    ReviewDangerListPageActions reviewDangerListPageActions = new ReviewDangerListPageActions();
    DefultPage defultPage = new DefultPage();
    ReviewDangerListPage reviewDangerListPage = new ReviewDangerListPage();

    @Test(description = "根据风险点类型验证查询功能")
    @Feature("查询")
    public void TC_searchByAddressCate() throws IOException, InterruptedException {
        reviewDangerListPageActions.modifyMenu(defultPage.reviewDangerList());
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());
        reviewDangerListPageActions.searchByAddressCate("洗煤厂");
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险点类型").size(); i++) {
            Assertion.VerityString(reviewDangerListPageActions.getSearchData("风险点类型").get(i),"洗煤厂");
        }
    }

    @Feature("风险审核")
    @Test(description = "审核通过测试")
    @Parameters({"remark"})
    public void TC_goReviewPass(String remark) throws IOException {
        reviewDangerListPageActions.modifyMenu(defultPage.reviewDangerList());
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());
        reviewDangerListPageActions.goReviewPassByRandom(remark);
    }
}
