package com.webui.action;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.DepartReportDangerListPage;
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
 * @description 部门风险上报页面
 * @Data 2018/12/06 15:49
 */
public class DepartReportDangerListActions extends TestBaseCase {

    ElementAction elementAction = new ElementAction();
    DefultPageActions defultPageActions = new DefultPageActions();

    DepartReportDangerListPage departReportDangerListPage = new DepartReportDangerListPage();
    DefultPage defultPage = new DefultPage();
    FunctionUtil functionUtil = new FunctionUtil();

    public void modifyMenu() throws IOException {
        defultPageActions.openMenu(defultPage.aqfxfjgk_menu(), defultPage.ndfxbs_list(), defultPage.departReportDangerList());
        elementAction.switchToFrame(departReportDangerListPage.iframe_departReportDangerList());
    }

    // 切换到主页面页面
    public void goDepartReportDangerList() throws IOException {
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(departReportDangerListPage.iframe_departReportDangerList());
    }

    // 切换到录入界面
    public void goAdd() throws IOException {
        elementAction.clickByJS(departReportDangerListPage.add_Button());
        switchFrame(departReportDangerListPage.iframe_goAddDepartDangerSource());
    }

    private void switchFrame(Locator locator) throws IOException {
        elementAction.switchToDefaultFrame();
        elementAction.switchToFrame(locator);
    }

    //  选择风险点类型
    public void selectAddressCate() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.addressCate_select(), elementAction.getOption(departReportDangerListPage.addressCate_select()));
    }

    //  输入辨识时间
    public void typeYeRecognizeTime() throws IOException {
        elementAction.type(departReportDangerListPage.yeRecognizeTime_textarea(), functionUtil.formatterDate("yyyy-MM-dd"));
    }

    //  选择专业
    public void selectYeProfession() throws IOException {
        elementAction.selectByIndex(departReportDangerListPage.yeProfession_select(), elementAction.getOption(departReportDangerListPage.yeProfession_select()));
    }

    //  选择危险源
    public void selectHazardName(String hazardName) throws IOException {
        elementAction.clickByJS(".//div[@id='hazardname']/div[2]/div");
        elementAction.clickByJS(".//*[@id='hazardname']//div[text()='" + hazardName + "']");
    }

    //  选择伤害类别:指定伤害类别
    public void checkDamageType(String damageString) {
        switch (damageString) {
            case "物体打击":
                WebElement element1 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='01']"));
                element1.click();
                break;
            case "车辆伤害":
                WebElement element2 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='02']"));
                element2.click();
                break;
            case "机械伤害":
                WebElement element3 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='03']"));
                element3.click();
                break;
            case "起重伤害":
                WebElement element4 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='04']"));
                element4.click();
                break;
            case "触电":
                WebElement element5 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='05']"));
                element5.click();
                break;
            case "淹溺":
                WebElement element6 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='06']"));
                element6.click();
                break;
            case "灼烫":
                WebElement element7 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='07']"));
                element7.click();
                break;
            case "火灾":
                WebElement element8 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='08']"));
                element8.click();
                break;
            case "高处坠落":
                WebElement element9 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='09']"));
                element9.click();
                break;
            case "坍塌":
                WebElement element10 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='10']"));
                element10.click();
                break;
            case "冒顶片帮":
                WebElement element11 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='11']"));
                element11.click();
                break;
            case "透水":
                WebElement element12 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='12']"));
                element12.click();
                break;
            case "放炮":
                WebElement element13 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='13']"));
                element13.click();
                break;
            case "瓦斯爆炸":
                WebElement element14 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='14']"));
                element14.click();
                break;
            case "火药爆炸":
                WebElement element15 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='15']"));
                element15.click();
                break;
            case "锅炉爆炸":
                WebElement element16 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='16']"));
                element16.click();
                break;
            case "容器爆炸":
                WebElement element17 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='17']"));
                element17.click();
                break;
            case "其他爆炸":
                WebElement element18 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='18']"));
                element18.click();
                break;
            case "中毒和窒息":
                WebElement element19 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='19']"));
                element19.click();
                break;
            case "其他伤害":
                WebElement element20 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]//input[@value='20']"));
                element20.click();
                break;
        }
    }

    //  随机选择伤害类别
    public void checkDamageType() {
        List<WebElement> webElements = driver.findElements(By.xpath(".//*[@id='formobj']//tbody/tr[3]/td[2]/label/input"));
        webElements.get(functionUtil.random(webElements.size())).click();
    }

    //  选择伤害类别:指定伤害类别
    public void checkYeAccident(String yeAccident) {
        switch (yeAccident) {
            case "顶板":
                WebElement element1 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='1']"));
                element1.click();
                break;
            case "瓦斯":
                WebElement element2 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='2']"));
                element2.click();
                break;
            case "机电":
                WebElement element3 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='3']"));
                element3.click();
                break;
            case "运输":
                WebElement element4 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='4']"));
                element4.click();
                break;
            case "放炮":
                WebElement element5 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='5']"));
                element5.click();
                break;
            case "水害":
                WebElement element6 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='6']"));
                element6.click();
                break;
            case "火灾":
                WebElement element7 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='7']"));
                element7.click();
                break;
            case "其他":
                WebElement element8 = driver.findElement(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]//input[@value='8']"));
                element8.click();
                break;
        }
    }

    //  随机选择伤害类别
    public void checkYeAccident() {
        List<WebElement> webElements = driver.findElements(By.xpath(".//*[@id='formobj']//tbody/tr[4]/td[2]/label/input"));
        webElements.get(functionUtil.random(webElements.size())).click();
    }

    //  输入风险描述
    public void typeYePossiblyHazard(String yePossiblyHazard) throws IOException {
        elementAction.type(departReportDangerListPage.yePossiblyHazard_textarea(), yePossiblyHazard);
    }

    // 选择风险可能性
    public void selectYeProbability(String yeProbability) throws IOException {
        elementAction.selectByText(departReportDangerListPage.yeProbability_select(),yeProbability);
    }
    //  选择风险损失
    public void selectYeCost(String yeCost) throws IOException {
        elementAction.selectByText(departReportDangerListPage.yeCost_select(),yeCost);
    }

    //  选择风险类型
    public void selectYeHazardCate(String yeHazardCate) throws IOException {
        elementAction.selectByText(departReportDangerListPage.yeHazardCate_select(),yeHazardCate);
    }

    //  选择作业活动
    public void selectActivityName(String activityname) throws IOException {
        elementAction.click_left(departReportDangerListPage.activityNameList());
        elementAction.sleep(1);
        WebElement activity = driver.findElement(By.xpath(".//*[@id='activityname']//div[text()='" + activityname + "']"));
        activity.click();
    }

    //  输入管控标准来源
    public void typeDocSource(String docSource) throws IOException {
        elementAction.type(departReportDangerListPage.docSource_textarea(), docSource);
    }
    //  输入章节条款
    public void typeSectionName(String sectionName) throws IOException {
        elementAction.type(departReportDangerListPage.ectionName_textarea(), sectionName);
    }
    //  输入标准内容
    public void typeYeStandard(String yeStandard) throws IOException {
        elementAction.type(departReportDangerListPage.yeStandard_textarea(), yeStandard);
    }
    //  输入管控措施
    public void typeManageMeasure(String manageMeasure) throws IOException {
        elementAction.type(departReportDangerListPage.manageMeasure_textarea(), manageMeasure);
    }

    //  选择责任岗位
    public void selectPostName(String postname) throws IOException {
        elementAction.click_left(departReportDangerListPage.postNameList());
        elementAction.sleep(1);
        WebElement post = driver.findElement(By.xpath(".//*[@id='postname']//div[text()='" + postname + "']"));
        post.click();
    }
    //  输入隐患描述
    public void typeYeMhazardDesc(String yeMhazardDesc) throws IOException {
        elementAction.type(departReportDangerListPage.yeMhazardDesc_textarea(), yeMhazardDesc);
    }
    //  选择隐患等级
    public void selectHiddenLevel(String hiddenLevel) throws IOException {
        elementAction.selectByText(departReportDangerListPage.hiddenLevel_select(),hiddenLevel);
    }

    //  输入隐患描述
    public void typeFineMoney(String fineMoney) throws IOException {
        elementAction.type(departReportDangerListPage.fineMoney_textarea(), fineMoney);
    }

    //  点击保存按钮
    public void doSave() throws IOException {
        elementAction.click_left(departReportDangerListPage.save_btn());
    }

    //  点击保存并提交按钮
    public void doSubRep() throws IOException {
        elementAction.click_left(departReportDangerListPage.subRep_btn());
    }

    //  点击关闭按钮
    public void doClose() throws IOException {
        elementAction.click_left(departReportDangerListPage.closeBtn());
    }


    public int getTempNum() {
        return tempNum;
    }

    public void setTempNum(int tempNum) {
        this.tempNum = tempNum;
    }

    public int tempNum;
    /**
     * @param fieldStr 需要获取值的字段
     * @return 数据列表, text
     * @throws IOException
     * @throws InterruptedException
     * @description 获取查询结果中指定字段值
     */
    public List<String> getSearchData(String fieldStr) throws IOException, InterruptedException {
        List<String> addressCateList = new ArrayList<>();
        switch (fieldStr) {
            case "风险点类型":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> addressCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='addressCate']/div"));
                    tempNum = addressCateElements.size();
                    for (int j = 0; j < addressCateElements.size(); j++) {
                        addressCateList.add(addressCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "隐患描述":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeMhazardDescElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeMhazardDesc']/div"));
                    tempNum = yeMhazardDescElements.size();
                    for (int j = 0; j < yeMhazardDescElements.size(); j++) {
                        addressCateList.add(yeMhazardDescElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "专业":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeProfessionElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeProfession']/div"));
                    tempNum = yeProfessionElements.size();
                    for (int j = 0; j < yeProfessionElements.size(); j++) {
                        addressCateList.add(yeProfessionElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "伤害类别":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> damageTypeElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='damageType']/div"));
                    tempNum = damageTypeElements.size();
                    for (int j = 0; j < damageTypeElements.size(); j++) {
                        addressCateList.add(damageTypeElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险描述":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yePossiblyHazardElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yePossiblyHazard']/div"));
                    tempNum = yePossiblyHazardElements.size();
                    for (int j = 0; j < yePossiblyHazardElements.size(); j++) {
                        addressCateList.add(yePossiblyHazardElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "作业活动":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> activityidElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activity.id']/div"));
                    tempNum = activityidElements.size();
                    for (int j = 0; j < activityidElements.size(); j++) {
                        addressCateList.add(activityidElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险等级":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeRiskGradeTempElements = driver.findElements(By
                            .xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRiskGradeTemp']//input"));
                    tempNum = yeRiskGradeTempElements.size();
                    for (int j = 0; j < yeRiskGradeTempElements.size(); j++) {
                        addressCateList.add(yeRiskGradeTempElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险类型":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeHazardCate']/div"));
                    tempNum = yeHazardCateElements.size();
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险点":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='address']/div"));
                    tempNum = yeHazardCateElements.size();
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "管控标准来源":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='docSource']/div"));
                    tempNum = yeHazardCateElements.size();
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "标准内容":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeStandard']/div"));
                    tempNum = yeHazardCateElements.size();
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "隐患等级":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='hiddenLevel']/div"));
                    tempNum = yeHazardCateElements.size();
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "辨识时间":
                if (elementAction.isElementDisplayedByLocator(departReportDangerListPage.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRecognizeTime']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
        }
        return addressCateList;
    }
}
