package com.webui.action.HiddenDangerManage.DangerRecord;

import com.webui.pageObject.SjjcPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;

import java.io.IOException;
import java.text.ParseException;

/**
 * @author the2n
 * @date 2019/01/25 11:38
 */
public class SjjcPageActions extends TestBaseCase {

    SjjcPage sjjcp = new SjjcPage();
    ElementAction ea = new ElementAction();
    FunctionUtil functionUtil = new FunctionUtil();

    public void motifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.switchToFrame(locator);
    }

    /**
     * 根据开始时间查询数据。需输入正确格式的日期，2019-01-25.否则不会按照输入的日期进行查询
     * @param dateStr
     * @throws IOException
     */
    public void searchByexamDateBegin(String dateStr) throws IOException {
        /**isValidDate()方法判断输入的日期格式是否为正确的格式*/
        if (functionUtil.isValidDate(dateStr)) {
            ea.typeByJS(sjjcp.examDate_begin_area(), dateStr);
            ea.clickByJS(sjjcp.search_Button());
        } else {
            log.warn("输入的日期：【" + dateStr + "】格式不正确");
        }
    }

    /**
     * 根据结束时间查询数据。需输入正确格式的日期，2019-01-25.否则不会按照输入的日期进行查询
     * @param dateStr
     * @throws IOException
     */
    public void searchByexamDateEnd(String dateStr) throws IOException {
        /**isValidDate()方法判断输入的日期格式是否为正确的格式*/
        if (functionUtil.isValidDate(dateStr)) {
            ea.typeByJS(sjjcp.examDate_end_area(), dateStr);
            ea.clickByJS(sjjcp.search_Button());
        } else {
            log.warn("输入的日期：【" + dateStr + "】格式不正确");
        }
    }

    /**
     * 根据输入的时间段查询数据。需输入正确格式的日期，2019-01-25.否则不会按照输入的日期进行查询
     * @param begindate
     * @param endDate
     * @throws IOException
     * @throws ParseException
     */
    public void searchByexamDate(String begindate, String endDate) throws IOException, ParseException {
        /**
         * isValidDate()方法判断输入的日期格式是否为正确的格式
         * compareTime()方法用于比较输入的时间段是否正确
         */
        if (functionUtil.isValidDate(begindate) && functionUtil.isValidDate(endDate)) {
            if (functionUtil.compareTime(begindate, endDate)) {
                ea.typeByJS(sjjcp.examDate_begin_area(), begindate);
                ea.typeByJS(sjjcp.examDate_end_area(), endDate);
                ea.clickByJS(sjjcp.search_Button());
            } else {
                log.warn("输入的时间段错误。输入的开始时间为：【" + begindate + "】，输入的结束时间为：【" + endDate + "】");
            }
        } else {
            if (functionUtil.isValidDate(begindate))
                log.warn("输入的时间【" + begindate + "】格式不正确");
            if (functionUtil.isValidDate(endDate))
                log.warn("输入的时间【" + endDate + "】格式不正确");
        }
    }

    /**
     * 根据班次进行查询
     * @param shiftStr 
     * @throws IOException
     */
    public void searchByShift(String shiftStr) throws IOException {
        ea.selectByText(sjjcp.shift_area(), shiftStr);
        ea.clickByJS(sjjcp.search_Button());
    }
}
