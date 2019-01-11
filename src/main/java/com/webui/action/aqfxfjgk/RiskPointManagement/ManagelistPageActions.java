package com.webui.action.aqfxfjgk.RiskPointManagement;

import com.webui.action.DefultPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ManagelistPage;
import com.webui.utils.ElementAction;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

import java.io.IOException;

/**
 * @author the2n
 * @Description: 风险区域管理页面相关操作
 * @Data 2019/01/11 14:36
 */
public class ManagelistPageActions extends TestBaseCase {

    DefultPage dp = new DefultPage();
    DefultPageActions dpa = new DefultPageActions();
    ElementAction ea = new ElementAction();
    ManagelistPage mlp = new ManagelistPage();

    /**
     * Description: 打开菜单
     * @param
     * @return: void
     * @throws:
     */
    public void motifyMenu() throws IOException {
        dpa.openMenu(dp.aqfxfjgk_menu(), dp.addressManage_list(), dp.managelist());
        ea.switchToFrame(mlp.iframe_managelist());
    }

    /**
     * Description: 切换frame
     * @param locator	需要切换的frame
     * @return: void
     * @throws:
     */
    public void motifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.switchToFrame(locator);
    }

    public void clicl(int x,int y) throws IOException {
        ea.clickByJS(mlp.addAddress_Button());
        ea.moveAndClick(mlp.withDepart(),x, y);
    }
}
