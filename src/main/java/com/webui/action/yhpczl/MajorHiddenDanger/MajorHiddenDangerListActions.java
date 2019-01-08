package com.webui.action.yhpczl.MajorHiddenDanger;

import com.webui.pageObject.MajorHiddenDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

import java.io.IOException;

/**
 * @author the2n
 * @Description:隐患综合查询页面相关操作
 * @Data 2019/01/07 14:45
 */
public class MajorHiddenDangerListActions extends TestBaseCase {

    MajorHiddenDangerListPage mhdlp = new MajorHiddenDangerListPage();
    ElementAction ea = new ElementAction();
    FunctionUtil fu = new FunctionUtil();

    /**
     * Description:切换frame
     * @param locator 需要切换的frame对象
     * @return: void
     * @throws:
     */
    public void motifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.visibilityOfElement(ea.findElement(locator));
        ea.switchToFrame(locator);
    }

    /**
     * Description:根据提供的隐患专业的字段值，进行查询操作
     * @param hdMajor 隐患专业的字段值
     * @return: void
     * @throws:
     */
    public void searchByhdMajor(String hdMajor) throws IOException {
        ea.selectByText(mhdlp.hdMajor_search_area(), hdMajor);
        ea.clickByJS(mhdlp.search_Button());
    }

    /**
     * Description:根据随机的隐患专业进行查询操作
     * @param
     * @return: void
     * @throws:
     */
    public void searchByhdMajorRandom() throws IOException {
        ea.selectByIndex(mhdlp.hdMajor_search_area(), ea.getOption(mhdlp.hdMajor_search_area()));
        ea.clickByJS(mhdlp.search_Button());
    }

    /**
     * Description:根据提供的隐患状态的字段值，进行查询操作
     * @param clStatus 隐患专业的字段值
     * @return: void
     * @throws:
     */
    public void searchByclStatus(String clStatus) throws IOException {
        ea.selectByText(mhdlp.clStatus_search_area(), clStatus);
        ea.clickByJS(mhdlp.search_Button());
    }

    /**
     * Description:根据随机的隐患状态进行查询操作
     * @param
     * @return: void
     * @throws:
     */
    public void searchByclStatusRandom() throws IOException {
        ea.selectByIndex(mhdlp.clStatus_search_area(), ea.getOption(mhdlp.clStatus_search_area()));
        ea.clickByJS(mhdlp.search_Button());
    }

    /**
     * Description:录入重大风险
     * @param hdLocation              隐患地点
     * @param inveDate                排查时间
     * @param hdInfoSource            信息来源
     * @param hdMajor                 隐患专业
     * @param hiddenType              隐患类型
     * @param magicsuggestDutyUnitSel 责任单位
     * @param magicsuggestDutyMan     责任人
     * @param rectPeriod              整改时间
     * @param hdDesc                  隐患描述
     * @return: void
     * @throws:
     */
    public void addMHD(String hdLocation, String inveDate, String hdInfoSource, String hdCate,String hdMajor, String hiddenType, String magicsuggestDutyUnitSel,
                       String magicsuggestDutyMan, String rectPeriod, String hdDesc) throws IOException {
        ea.clickByJS(mhdlp.add_Button());
        motifyFrame(mhdlp.iframe_add());
        ea.clickByJS(mhdlp.hdLocationSelect());
        ea.clickByJS(".//*[@id='hdLocationSelect']/div[3]/div[text()='" + hdLocation + "']");  //选择隐患地点
//        ea.typeByJS(mhdlp.inveDate(), fu.formatterDate("yyyy-MM-dd"));// 输入排查时间为当前时间
        ea.typeByJS(mhdlp.inveDate(), inveDate); //输入指定的排查时间
        ea.selectByText(mhdlp.hdInfoSource(), hdInfoSource);//隐患信息来源
//        ea.selectByIndex(mhdlp.hdInfoSource(), ea.getOption(mhdlp.hdInfoSource()));//隐患信息来源 --随机选择
        ea.selectByText(mhdlp.hdCate(), hdCate);//隐患类别
        ea.selectByText(mhdlp.hdMajor(), hdMajor);//隐患专业
        ea.selectByText(mhdlp.hiddenType(), hiddenType);//隐患类型
        chooseDangerSource();
        ea.clickByJS(mhdlp.magicsuggestDutyUnitSel());
        ea.clickByJS(".//*[@id='magicsuggestDutyUnitSel']/div[3]/div[text()='" + magicsuggestDutyUnitSel + "']");  //选择责任单位
        ea.clickByJS(mhdlp.magicsuggestDutyMan());
        ea.clickByJS(".//*[@id='magicsuggestDutyMan']/div[3]/div[text()='" + magicsuggestDutyMan + "']");  //选择责任单位人
        ea.typeByJS(mhdlp.rectPeriod(), rectPeriod); //整改时间
//        ea.typeByJS(mhdlp.hdDesc(), hdDesc);
        ea.clickByJS(mhdlp.confirm_btn()); // 确定按钮
//        ea.clickByJS(mhdlp.submit_btn());// 提交按钮
        motifyFrame(mhdlp.iframe_list());
    }

    /**
     * Description:随机选择当前页面上的危险源
     * @param
     * @return: void
     * @throws:
     */
    public void chooseDangerSource() throws IOException {
        ea.clickByJS(mhdlp.dangerName());
        motifyFrame(mhdlp.iframe_chooseDangerSource());
        ea.typeByJS(mhdlp.yeRecognizeYear(), "2018");
        ea.clickByJS(mhdlp.search_Button());
        ea.sleep(1);
        Boolean flag = ea.isElementDisplayedByLocator(mhdlp.data_tbody());
        if (flag) {
            // .//div[@class='datagrid-view2']/div[2]//tbody/tr 危险源弹框列表中每行数据的xpath
            int temp = ea.getElements(".//div[@class='datagrid-view2']/div[2]//tbody/tr").size();
            if (temp == 1) {
                ea.clickByJS(".//div[@class='datagrid-view2']/div[2]//tbody/tr");
                ea.switchToDefaultFrame();  //切换到default frame上点击确定按钮
                ea.clickByJS(mhdlp.confirm_btn());
                motifyFrame(mhdlp.iframe_add()); //切换到录入frame
            } else if (temp > 10) {
                ea.getElements(".//div[@class='datagrid-view2']/div[2]//tbody/tr").get(fu.randomForElement(10)).click();
                ea.switchToDefaultFrame();  //切换到default frame上点击确定按钮
                ea.clickByJS(mhdlp.confirm_btn());
                motifyFrame(mhdlp.iframe_add()); //切换到录入frame
            }else {
                ea.getElements(".//div[@class='datagrid-view2']/div[2]//tbody/tr").get(fu.randomForElement(temp)).click();
                ea.switchToDefaultFrame();  //切换到default frame上点击确定按钮
                ea.clickByJS(mhdlp.confirm_btn());
                motifyFrame(mhdlp.iframe_add()); //切换到录入frame
            }
        }else {
            log.info("wushuju");
        }
    }

}
