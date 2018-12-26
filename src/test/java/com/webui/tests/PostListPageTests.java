package com.webui.tests;

import com.webui.action.PostListPageActions;
import com.webui.pageObject.PostListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ReadProperties;
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
    ReadProperties rp =new ReadProperties();

    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\post.properties";


    @Feature("添加岗位信息")
    @Test(description = "验证添加岗位信息功能")
    public void TC_search(){

    }

    @Feature("添加岗位信息")
    @Test(description = "验证添加岗位信息功能")
    public void TC_addPost() throws IOException {
        postListPageActions.modifyMenu();
        postListPageActions.addPostName(rp.readPropertiesFile(filePath,"postName"));
        postListPageActions.modifyFrame(postListPage.iframe_PostList());
        Assertion.VerityTextPresent(rp.readPropertiesFile(filePath,"postName"));
    }


    @Feature("修改岗位信息")
    @Test(description = "验证修改岗位信息功能")
    @Parameters({"postName"})
    public void TC_updatePost(String postName) throws IOException {
        postListPageActions.modifyMenu();
        postListPageActions.updatePostNameRandom(postName);
    }

    @Feature("删除岗位信息")
    @Test(description = "验证删除岗位信息功能--随机删除")
    public void TC_delPost() throws IOException {
        postListPageActions.modifyMenu();
        postListPageActions.deletePostRandom();
        Assertion.verityNotTextPresent(postListPageActions.getPostName());
    }
}
