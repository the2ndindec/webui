package com.webui.action.aqfxfjgk.basicdata;

import com.webui.action.DefultPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.PostListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author the2n
 * @Description:岗位管理页面
 * @Data 2018/12/17 15:50
 */
public class PostListPageActions extends TestBaseCase {
    ElementAction elementAction = new ElementAction();
    PostListPage postListPage = new PostListPage();
    DefultPageActions defultPageActions = new DefultPageActions();
    DefultPage defultPage = new DefultPage();
    FunctionUtil functionUtil = new FunctionUtil();


    private int postCount;
    private List<WebElement> postElements;
    private WebElement element;
    private String postName;
    public String dataStr = functionUtil.formatterDate("yyyyMMddHHmmss");

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }


    /**
     * @param
     * @Description:切换菜单
     * @return: void
     * @throws:
     */
    public void modifyMenu() throws IOException {
        defultPageActions.openMenu(defultPage.aqfxfjgk_menu(), defultPage.jcsjgl_li(), defultPage.postList());
        elementAction.switchToFrame(postListPage.iframe_PostList());
    }

    /**
     * Description:根据岗位名称查询
     * @param postName 岗位名称字段值
     * @return: void
     * @throws:
     */
    public void searchByPostName(String postName) throws IOException {
        elementAction.type(postListPage.postName_search_area(), postName);
        elementAction.click_left(postListPage.search_Button());
    }


    /**
     * @param postName 岗位名称
     * @Description:录入岗位信息
     * @return: void
     * @throws:
     */
    public void addPostName(String postName) throws IOException {
        elementAction.click_left(postListPage.add_Button());
        modifyFrame(postListPage.iframe_goAdd());//切换到录入弹框
        elementAction.type(postListPage.add_postName_area(), postName + dataStr);
        elementAction.switchToDefaultFrame();//切换到默认frame
        elementAction.click_left(postListPage.confirm_btn());
    }

    /**
     * @param postName 岗位名称字段值
     * @Description:随机获取当前页面上的一条岗位数据,并修改岗位名称
     * @return: void
     * @throws:
     */
    public void updatePostNameRandom(String postName) throws IOException {
        getPostElement().click();
        elementAction.click_left(postListPage.update_Button());
        modifyFrame(postListPage.iframe_goUpdate());
        log.info("原岗位信息值为:" + elementAction.getTextByJS(postListPage.update_postName_area()));
        elementAction.type(postListPage.update_postName_area(), postName + dataStr);
        elementAction.switchToDefaultFrame();
        elementAction.click_left(postListPage.confirm_btn());
    }

    /**
     * Description:查看岗位详情
     * @param
     * @return: void
     * @throws:
     */
    public void detailOfPost() throws IOException {
        modifyFrame(postListPage.iframe_PostList());
        getPostElement().click();
        valueOfChoosePost = getPostElement().getText();
        elementAction.clickByJS(postListPage.detail_Button());
        modifyFrame(postListPage.iframe_goUpdate());
    }

    public String getValueOfChoosePost() {
        return valueOfChoosePost;
    }

    public void setValueOfChoosePost(String valueOfChoosePost) {
        this.valueOfChoosePost = valueOfChoosePost;
    }

    public String valueOfChoosePost;

    /**
     * Description:随机删除岗位信息
     * @param
     * @return: void
     * @throws:
     */
    public void deletePostRandom() throws IOException {
        int temp = functionUtil.random(getPostCount());
        postName = driver.findElement(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr[" + temp + "]/td[@field='postName']/div")).getText();
        log.info("删除的岗位信息为:" + postName);
        elementAction.clickByJS(".//div[@class='datagrid-view2']/div[2]//tbody/tr[" + temp + "]/td[@field='opt']//a[1]");
        modifyFrame(postListPage.iframe_PostList());
        elementAction.clickVisibilityOfElement(".//*[@class='layui-layer-btn0']");
    }


    /**
     * Description:获取当前页面上岗位的数量
     * @param
     * @return: int
     * @throws:
     */
    private int getPostCount() throws IOException {
        if (elementAction.isElementDisplayedByLocator(postListPage.data_tbody())) {//判断列表中是否存在数据
            postElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
            postCount = postElements.size();
        } else {
            log.info("暂无相关数据信息");
        }
        return postCount;
    }

    /**
     * Description:随机点击当前页面上一条岗位数据
     * @param
     * @return: org.openqa.selenium.WebElement
     * @throws:
     */
    public WebElement getPostElement() throws IOException {
        if (elementAction.isElementDisplayedByLocator(postListPage.data_tbody())) {//判断列表中是否存在数据
            postElements = driver.findElements(By.xpath(".//div[@class='datagrid-body']//td[@field='postName']"));
            element = postElements.get(functionUtil.random(postElements.size()));
        } else {
            log.info("暂无相关数据信息");
        }
        return element;
    }

    /**
     * Description:获取当前页面上岗位字段值的集合
     * @param
     * @return: java.util.List<java.lang.String>
     * @throws:
     */
    public List<String> getPostValue() throws IOException {
        modifyFrame(postListPage.iframe_PostList());
        List<String> postList = new ArrayList<>();
        if (elementAction.isElementDisplayedByLocator(postListPage.data_tbody())) {//判断列表中是否存在数据
            List<WebElement> postValueElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='postName']/div"));
            for (WebElement postValueElement : postValueElements) {
                postList.add(postValueElement.getText());
            }
        } else {
            log.info("暂无相关数据信息");
        }
        return postList;
    }

    /**
     * Desc: 切换frame
     * @param locator 需要切换的frame
     * @return: void
     * @throws:
     */
    public void modifyFrame(Locator locator) {
        elementAction.switchToDefaultFrame();
        elementAction.visibilityOfElement(elementAction.findElement(locator));
        elementAction.switchToFrame(locator);
    }
}
