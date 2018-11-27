package com.webui.tests;

import com.webui.action.ReviewDangerListPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReviewDangerListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description
 * @Data 2018/11/27 16:56
 */
public class ReviewDangerListPageTests extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    ReviewDangerListPageActions reviewDangerListPageActions = new ReviewDangerListPageActions();
    DefultPage defultPage = new DefultPage();
    ReviewDangerListPage reviewDangerListPage = new ReviewDangerListPage();

    @Test(description = "根据风险点类型验证查询功能")
    public void TC_searchByAddressCate() throws IOException, InterruptedException {
        reviewDangerListPageActions.modifyMenu(defultPage.reviewDangerList());
        elementAction.switchToFrame(reviewDangerListPage.iframe_reviewDangerList());
        reviewDangerListPageActions.searchByAddressCate("洗煤厂");
        for (int i = 0; i < reviewDangerListPageActions.getSearchData("风险点类型").size(); i++) {
            Assertion.VerityString(reviewDangerListPageActions.getSearchData("风险点类型").get(i),"洗煤厂");
        }
    }
}
