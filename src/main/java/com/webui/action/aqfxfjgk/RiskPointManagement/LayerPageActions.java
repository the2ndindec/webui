package com.webui.action.aqfxfjgk.RiskPointManagement;

import com.webui.action.DefultPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.LayerPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

import java.io.IOException;

/**
 * @author the2n
 * @Description:煤层管理页面相关操作
 * @Data 2019/01/02 11:36
 */
public class LayerPageActions extends TestBaseCase {

    LayerPage lp = new LayerPage();
    ElementAction ea = new ElementAction();
    DefultPageActions dpa = new DefultPageActions();
    DefultPage dp = new DefultPage();
    FunctionUtil functionUtil = new FunctionUtil();
    /**
     * 格式化日期作为参数使用
     */
    public String dataStr = functionUtil.formatterDate("yyyyMMddHHmmss");

    /**
     * Description:切换frame
     * @param locator 需要切换的frame
     * @return: void
     * @throws:
     */
    public void modifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.visibilityOfElement(ea.findElement(locator));
        ea.switchToFrame(locator);
    }

    /**
     * Description:打开作业管理页面
     * @param
     * @return: void
     * @throws:
     */
    public void modifyMenu() throws IOException {
        dpa.openMenu(dp.aqfxfjgk_menu(), dp.addressManage_list(), dp.layerManage());
        ea.switchToFrame(lp.iframe_Layer());
    }

    /**
     * Description:通过指定煤层字段值进行查询操作
     * @param layerCode 煤层信息
     * @return: void
     * @throws:
     */
    public void searchBylayerCode(String layerCode) throws IOException {
        ea.typeByJS(lp.layerCode_select(), layerCode);
        ea.clickByJS(lp.search_Button());
    }

    /**
     * Description:通过指定矿图名称字段值进行查询操作
     * @param layerDetailName 矿图名称
     * @return: void
     * @throws:
     */
    public void searchBylayerDetailName(String layerDetailName) throws IOException {
        ea.typeByJS(lp.layerDetailName_input(), layerDetailName);
        ea.clickByJS(lp.search_Button());
    }

    /**
     * Description:通过指定超图路径字段值进行查询操作
     * @param url 超图路径
     * @return: void
     * @throws:
     */
    public void searchByurl(String url) throws IOException {
        ea.typeByJS(lp.url_input(), url);
        ea.clickByJS(lp.search_Button());
    }

    /**
     * Description:按照是否显示图层进行查询操作
     * @param isShow 是否显示图层
     * @return: void
     * @throws:
     */
    public void searchByisShow(String isShow) throws IOException {
        ea.selectByText(lp.isShow_select(), isShow);
        ea.clickByJS(lp.search_Button());
    }

    /**
     * Description:按照备注内容进行查询操作
     * @param remark 备注内容
     * @return: void
     * @throws:
     */
    public void searchByremark(String remark) throws IOException {
        ea.typeByJS(lp.remark_input(), remark);
        ea.clickByJS(lp.search_Button());
    }

    /**
     * Description:录入煤层信息
     * @param layerCode       图层名称
     * @param layerDetailName 矿图名称
     * @param url             超图路径
     * @param center          超图中心点
     * @param isshow          是否展示图层
     * @param remark          备注
     * @return: void
     * @throws:
     */
    public void addLayer(String layerCode, String layerDetailName, String url, String center, String isshow, String remark) throws IOException {
        ea.clickByJS(lp.add_Button());
        modifyFrame(lp.iframe_add());
        ea.selectByText(lp.layerCode_select(), layerCode);//图层名称
        ea.typeByJS(lp.layerDetailName_input(), layerDetailName);//矿图名称
        ea.typeByJS(lp.url_input(), url);//超图路径
        ea.typeByJS(lp.center_input(), center);//超图中心点
        ea.selectByText(lp.isShow_select(), isshow);//是否展示图层
        ea.typeByJS(lp.remark_input(), remark);//备注
        ea.switchToDefaultFrame();
        ea.clickByJS(lp.confirm_btn());
    }
}
