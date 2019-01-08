package com.webui.yhpczl.MajorHiddenDanger;

import com.webui.action.DefultPageActions;
import com.webui.action.yhpczl.MajorHiddenDanger.MajorHiddenDangerListActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.MajorHiddenDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @Description: 隐患综合查询
 * @Data 2019/01/08 11:20
 */
public class MajorHiddenDangerListTests extends TestBaseCase {

    MajorHiddenDangerListActions mhdla = new MajorHiddenDangerListActions();
    MajorHiddenDangerListPage mhdlp = new MajorHiddenDangerListPage();
    DefultPage dp = new DefultPage();
    DefultPageActions dpa = new DefultPageActions();
    ElementAction elementAction = new ElementAction();

    @Feature("添加重大风险")
    @Test(description = "验证添加风险功能")
    public void TC_addMHD() throws IOException {
        dpa.openMenu(dp.yhpczl(),dp.zdyhsb(),dp.majorHiddenDangerList());
        elementAction.switchToFrame(mhdlp.iframe_list());
        mhdla.addMHD("测试风险点1","2019-01-07","班组检查","资质证照","通风","通风",
                "xx煤矿","管理员","2019-01-17","");

    }
}
