package com.webui.action.aqfxfjgk.basicdata;

import com.webui.action.DefultPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.HazardManagePage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

import java.io.IOException;

/**
 * @author the2n
 * @Description:危险源管理
 * @Data 2018/12/27 15:50
 */
public class HazardManagePageActions extends TestBaseCase {

    ElementAction ea = new ElementAction();
    DefultPageActions dpa = new DefultPageActions();
    DefultPage dp = new DefultPage();
    HazardManagePage hmp = new HazardManagePage();

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
     * Description:打开危险源管理页面
     * @param
     * @return: void
     * @throws:
     */
    public void modifyMenu() throws IOException {
        dpa.openMenu(dp.aqfxfjgk_menu(), dp.jcsjgl_li(), dp.hazardList());
        ea.switchToFrame(hmp.iframe_hazard());
    }

    /**
     * Description:添加危险源，随机选择危险源类型
     * @param hazardStr 危险源值
     * @return: void
     * @throws:
     */
    public void addHazard(String hazardStr) throws IOException {
        ea.clickByJS(hmp.add_Button());
        modifyFrame(hmp.iframe_addHazard());
        ea.typeByJS(hmp.hazardName_search_area(), hazardStr);
        /**
         * 随机选择危险源类型
         */
        ea.selectByIndex(hmp.hazardType_search_area(), ea.getOption(hmp.hazardType_search_area()));
        ea.switchToDefaultFrame();
        ea.clickByJS(hmp.confirm_btn());
        ea.switchToFrame(hmp.iframe_hazard());
    }

    /**
     * Description:用于验证危险源名称为空时提示信息
     * @param
     * @return: void
     * @throws:
     */
    public void addHazardWithoutHazardString() throws IOException {
        ea.clickByJS(hmp.add_Button());
        modifyFrame(hmp.iframe_addHazard());
        ea.click(hmp.hazardName_search_area());
        ea.fireEventBlur(hmp.hazardName_search_area());
    }

    /**
     * Description:用于验证危险源类型为空时提示信息
     * @param
     * @return: void
     * @throws:
     */
    public void addHazardWithoutHazardSTYpe() throws IOException {
        modifyFrame(hmp.iframe_hazard());
        ea.clickByJS(hmp.add_Button());
        modifyFrame(hmp.iframe_addHazard());
        ea.click(hmp.hazardType_search_area());
        ea.fireEventBlur(hmp.hazardType_search_area());
    }
}
