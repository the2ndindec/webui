package com.webui.tests;

import com.webui.action.PostListPageActions;
import com.webui.pageObject.PostListPage;
import com.webui.utils.Assertion;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @Description:岗位管理页面
 * @Data 2018/12/17 16:26
 */
public class PostListPageTests extends TestBaseCase {

    PostListPageActions postListPageActions = new PostListPageActions();
    PostListPage postListPage = new PostListPage();


    @Feature("添加岗位信息")
    @Test(description = "验证添加岗位信息功能")
    @Parameters({"postName"})
    public void TC_addPost(String postName) throws IOException {
        postListPageActions.modifyMenu();
        postListPageActions.addPostName(postName);
        postListPageActions.modifyFrame(postListPage.iframe_PostList());
        Assertion.VerityTextPresent(postName);
    }

    @Feature("修改岗位信息")
    @Test(description = "验证修改岗位信息功能")
    @Parameters({"postName"})
    public void TC_updatePost(String postName) throws IOException {
        postListPageActions.modifyMenu();
        postListPageActions.updatePostNameRandom(postName);
    }
}
