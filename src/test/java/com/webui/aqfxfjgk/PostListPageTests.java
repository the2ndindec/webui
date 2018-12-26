package com.webui.aqfxfjgk;

import com.webui.action.PostListPageActions;
import com.webui.pageObject.PostListPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
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

    ElementAction elementAction = new ElementAction();

    private String filePath = "D:\\dev\\IdeaProjects\\webui\\src\\test\\resources\\post.properties";


    @Feature("查询")
    @Test(description = "验证查询功能")
    public void TC_search() throws IOException {
        postListPageActions.searchByPostName(rp.readPropertiesFile(filePath,"postName"));
        for (String postName:postListPageActions.getPostValue()
             ) {
            Assertion.VerityCationString(postName,rp.readPropertiesFile(filePath,"postName"));
        }
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

    @Feature("查看")
    @Test(description = "验证查看功能")
    public void TC_goDetail() throws IOException {
        postListPageActions.detailOfPost();
        Assertion.VerityString(elementAction.getTextByJS(postListPage.add_postName_area()), postListPageActions.getValueOfChoosePost());
    }
}
