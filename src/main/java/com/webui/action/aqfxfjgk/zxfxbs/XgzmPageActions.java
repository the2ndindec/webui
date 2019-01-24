package com.webui.action.aqfxfjgk.zxfxbs;

import com.webui.pageObject.XgzmPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

/**
 * @author the2n
 * @Description:新工作面风险评估
 * @Data 2019/01/02 14:57
 */
public class XgzmPageActions extends TestBaseCase {
    XgzmPage xgzmPage = new XgzmPage();
    ElementAction ea = new ElementAction();
    FunctionUtil functionUtil = new FunctionUtil();


    /**
     * Description:切换frame
     * @param locator 需要切换的frame对象
     * @return: void
     * @throws:
     */
    public void motifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.switchToFrame(locator);
    }

    /**
     * Description:根据提供的辨识名称进行查询
     * @param name 辨识名称
     * @return: void
     * @throws:
     */
    public void searchByName(String name) throws IOException {
        ea.typeByJS(xgzmPage.name_area(), name);
        ea.clickByJS(xgzmPage.search_Button());
    }

    /**
     * Description:根据辨识开始时间进行查询.
     * 调用isValidDate方法判断输入的时间格式是否正确，若正确则直接输入数据。若不正确给出提示信息
     * @param time 辨识开始时间，时间格式为：2019-01-02
     * @return: void
     * @throws:
     */
    public void searchByStartTime(String time) throws IOException {
        if (functionUtil.isValidDate(time)) {
            ea.typeByJS(xgzmPage.time_begin_search_area(), time);
            ea.clickByJS(xgzmPage.search_Button());
        } else {
            log.info("输入的时间格式不正确");
        }

    }

    /**
     * Description:根据辨识结束时间进行查询.
     * 调用isValidDate方法判断输入的时间格式是否正确，若正确则直接输入数据。若不正确给出提示信息
     * @param time 辨识结束时间，时间格式为：2019-01-02
     * @return: void
     * @throws:
     */
    public void searchByEndTime(String time) throws IOException {
        if (functionUtil.isValidDate(time)) {
            ea.typeByJS(xgzmPage.time_end_search_area(), time);
            ea.clickByJS(xgzmPage.search_Button());
        } else {
            log.info("输入的时间格式不正确");
        }
    }

    /**
     * Description:根据辨识时间段进行查询
     * 先调用isValidDate方法判断输入的日期的格式是否正确。再调用compareTime方法判断时间大小
     * @param beginTime 辨识开始时间
     * @param endTime   辨识结束时间
     * @return: void
     * @throws:
     */
    public void searchByTime(String beginTime, String endTime) throws ParseException, IOException {
        if (functionUtil.isValidDate(beginTime) && functionUtil.isValidDate(endTime)) {
            if (functionUtil.compareTime(beginTime, endTime)) {
                ea.typeByJS(xgzmPage.time_begin_search_area(), beginTime);
                ea.typeByJS(xgzmPage.time_end_search_area(), endTime);
                ea.clickByJS(xgzmPage.search_Button());
            } else {
                log.info("开始时间晚于结束时间");
            }
        } else {
            log.info("输入的时间格式不正确");
        }
    }

    /**
     * Description:录入新工作面风险
     * @param name        专项辨识名称
     * @param leaderType  辨识人类型
     * @param leader      辨识负责人
     * @param time        辨识时间
     * @param teamMembers 参加人员
     * @param location    辨识地点
     * @param remark      辨识结论
     * @return: void
     * @throws:
     */
    public void addData(String name, String leaderType, String leader, String time, String teamMembers, String location, String remark) throws IOException {
        ea.clickByJS(xgzmPage.add_Button());
        motifyFrame(xgzmPage.iframe_add());
        ea.typeByJS(xgzmPage.name_area(), name);
        ea.selectByText(xgzmPage.leaderType_select(), leaderType);
        ea.clickByJS(xgzmPage.leader_select());
        ea.clickByJS(".//*[@id='leaderSelect']/div[3]/div[text()='"+leader+"']");
        ea.typeByJS(xgzmPage.time_input(), time);
        ea.clickByJS(xgzmPage.teamMembers());
        ea.sleep(1);
        chooseTeamMember(teamMembers);
        motifyFrame(xgzmPage.iframe_add());
        ea.clickByJS(xgzmPage.locationSelect());
        ea.clickByJS(".//*[@id='locationSelect']/div[3]/div[text()='" + location + "']");
        ea.typeByJS(xgzmPage.remark_textarea(), remark);
        ea.switchToDefaultFrame();
        ea.clickByJS(xgzmPage.confirm_btn());
        ea.switchToFrame(xgzmPage.iframe_xgzm());
    }

    /**
     * Description:选择辨识参加人员
     * @param teamMembers 辨识人员名称
     * @return: void
     * @throws:
     */
    private void chooseTeamMember(String teamMembers) throws IOException {
        motifyFrame(xgzmPage.iframe_userManySelectList());
        if (ea.isElementDisplayedByLocator(xgzmPage.data_tbody())) {
//            chooseElement(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='realName']", teamMembers);
            ea.clickByJS(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='realName']/div[text()='"+teamMembers+"']");
        } else {
            log.info("暂无可选择的人员信息");
        }
        ea.switchToDefaultFrame();
        ea.clickByJS(xgzmPage.confirm_btn());
    }

}
