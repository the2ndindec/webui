package com.webui.action.aqfxfjgk.annualrisk;

import com.webui.pageObject.ReportDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.FunctionUtil;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author the2n
 * @date: 2018年11月13日 下午4:05:22
 * @Description: 矿风险清单页面包含的功能
 */
public class ReportDangerListPageActions extends TestBaseCase {

    ElementAction ea = new ElementAction();
    ReportDangerListPage rdlp = new ReportDangerListPage();
    FunctionUtil functionUtil = new FunctionUtil();

    /**
     * @param addressCate 需要查询的风险点类型字段值
     * @throws IOException
     * @Description: 根据风险点类型执行查询操作
     */
    @Step(value = "输入查询条件，风险点类型")
    public void searchByAddressCate(String addressCate) throws IOException {
        ea.selectByText(rdlp.addressCate_select(), addressCate);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @param yeMhazardDesc 隐患描述字段值
     * @throws IOException
     * @Description: 根据隐患描述执行查询操作
     */
    public void searchByYeMhazardDesc(String yeMhazardDesc) throws IOException {
        setDefult();
        ea.type(rdlp.yeMhazardDesc_textarea(), yeMhazardDesc);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @param yeProfession 专业字段值
     * @throws IOException
     * @Description: 根据专业执行查询操作
     */
    public void searchByYeProfession(String yeProfession) throws IOException {
        setDefult();
        ea.selectByText(rdlp.yeProfession_select(), yeProfession);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @param damageType 伤害类别字段值
     * @throws IOException
     * @Description 根据伤害类别执行查询操作
     */
    public void searchByDamageType(String damageType) throws IOException {
        setDefult();
        ea.selectByText(rdlp.damageType_select(), damageType);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @param yePossiblyHazard 风险描述字段值
     * @throws IOException
     * @Description 根据风险描述执行查询操作
     */
    public void searchByYePossiblyHazard(String yePossiblyHazard) throws IOException {
        setDefult();
        ea.type(rdlp.yePossiblyHazard_textarea(), yePossiblyHazard);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @param activityid 作业活动字段值
     * @throws IOException
     * @description 根据作业活动执行查询操作
     */
    public void searchByActivityid(String activityid) throws IOException {
        setDefult();
        ea.selectByText(rdlp.activityId_select(), activityid);
        ea.clickByJS(rdlp.search_Button());
    }


    /**
     * @param yeRiskGradeTemp 风险等级字段值
     * @throws IOException
     * @description 根据风险等级执行查询操作
     */
    public void searchByYeRiskGradeTemp(String yeRiskGradeTemp) throws IOException {
        setDefult();
        ea.selectByText(rdlp.yeRiskGrade_select(), yeRiskGradeTemp);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @param yeHazardCate 风险类型字段值
     * @throws IOException
     * @description 根据风险类型执行查询操作
     */
    public void searchByYeHazardCate(String yeHazardCate) throws IOException {
        setDefult();
        ea.selectByText(rdlp.yeRiskGrade_select(), yeHazardCate);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * Description: 根据管控来源查询
     * @param docSource 管控来源内容
     * @return: void
     * @throws:
     */
    public void searchByDocSource(String docSource) throws IOException {
        setDefult();
        ea.type(rdlp.docSource_textarea(), docSource);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * Description: 根据标准内容查询
     * @param yeStandard 标准内容
     * @return: void
     * @throws:
     */
    public void searchByYeStandarde(String yeStandard) throws IOException {
        setDefult();
        ea.type(rdlp.yeStandard_textarea(), yeStandard);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * Description: 根据隐患等级查询
     * @param hiddenLevel 隐患等级
     * @return: void
     * @throws:
     */
    public void searchByHhiddenLevel(String hiddenLevel) throws IOException {
        setDefult();
        ea.selectByText(rdlp.hiddenLevel_select(), hiddenLevel);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * Description: 根据辨识开始时间查询
     * @param yeRecognizeTime 辨识开始时间
     * @return: void
     * @throws:
     */
    public void searchByRecognizeTimeBegin(String yeRecognizeTime) throws IOException {
        setDefult();
        if (functionUtil.isValidDate(yeRecognizeTime)) {
            ea.type(rdlp.yeRecognizeTime_begin_textarea(), yeRecognizeTime);
            ea.clickByJS(rdlp.search_Button());
            ea.sleep(2);
        } else {
            log.warn("输入的日期：" + yeRecognizeTime + "格式不正确");
        }
    }

    /**
     * Description: 根据辨识结束时间查询
     * @param yeRecognizeTime 辨识结束时间
     * @return: void
     * @throws:
     */
    public void searchByRecognizeTimeEnd(String yeRecognizeTime) throws IOException {
        setDefult();
        if (functionUtil.isValidDate(yeRecognizeTime)) {
            ea.type(rdlp.yeRecognizeTime_end_textarea(), yeRecognizeTime);
            ea.clickByJS(rdlp.search_Button());
        } else {
            log.warn("输入的日期：" + yeRecognizeTime + "格式不正确");
        }
    }

    /**
     * Description: 根据辨识时间段查询
     * @param yeRecognizeTime_begin 辨识开始时间
     * @param yeRecognizeTime_end   辨识结束时间
     * @return: void
     * @throws:
     */
    public void searchByRecognizeTime(String yeRecognizeTime_begin, String yeRecognizeTime_end) throws IOException, ParseException {
        setDefult();
        if (functionUtil.isValidDate(yeRecognizeTime_begin) && functionUtil.isValidDate(yeRecognizeTime_end)) {
            if (functionUtil.compareTime(yeRecognizeTime_begin, yeRecognizeTime_end)) {
                ea.type(rdlp.yeRecognizeTime_end_textarea(), yeRecognizeTime_begin);
                ea.type(rdlp.yeRecognizeTime_end_textarea(), yeRecognizeTime_end);
                ea.clickByJS(rdlp.search_Button());
            } else {
                log.warn("输入的时间段有误");
            }
        } else {
            if (functionUtil.isValidDate(yeRecognizeTime_begin) == false)
                log.warn("输入的日期：" + yeRecognizeTime_begin + "格式不正确");
            if (functionUtil.isValidDate(yeRecognizeTime_end) == false)
                log.warn("输入的日期：" + yeRecognizeTime_end + "格式不正确");
        }
    }

    public String getAddStr() {
        return addStr;
    }

    public void setAddStr(String addStr) {
        this.addStr = addStr;
    }

    private String addStr;

    /**
     * @throws IOException
     * @description 关联风险点
     */
    @Step(value = "随机添加风险点关联关系")
    public void chooseAddressByRandom() throws IOException {
        setDefult();
        List<WebElement> dataElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(dataElements.size());//  根据当前页面上的数据,随机选择
        dataElements.get(temp).click();
        ea.click(rdlp.chooseAddress_Button());
        ea.sleep(1);
        motifyFrame(rdlp.iframe_addresslist());
        ea.click_left(rdlp.addresslist_chooseAddress_Button());
        motifyFrame(rdlp.iframe_addressAddlist());
        List<WebElement> addElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random1 = new Random();
        int temp1 = random1.nextInt(addElements.size());
        addElements.get(temp1).click(); // 随机选择风险点
//        addStr = addElements.get(temp1).findElement(By.xpath("/td[@field='address']")).getText();
        //截取字符串,获取风险点字段值
        String elementStr = addElements.get(temp1).getText();
        String[] strs = elementStr.split("\n");
        addStr = strs[0];
        ea.click_left(rdlp.addressAddlist_addRelFunction_Button());
        motifyFrame(rdlp.iframe_addresslist());
        ea.sleep(1);
    }

    private void motifyFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.switchToFrame(locator); //切换到风险点列表弹框
    }

    /**
     * @param:string 需要关联的风险点字段
     * @descption: 根据风险点值进行关联
     */
    public void chooseAddressByValue(String string) throws IOException {
        setDefult();
        List<WebElement> dataElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(dataElements.size());//  根据当前页面上的数据,随机选择
        dataElements.get(temp).click();
        ea.click(rdlp.chooseAddress_Button());
        ea.sleep(1);
        motifyFrame(rdlp.iframe_addresslist());
        ea.click_left(rdlp.addresslist_chooseAddress_Button());
        motifyFrame(rdlp.iframe_addressAddlist());
        ea.type(rdlp.addresslist_address_textarea(), string);
        ea.click_left(rdlp.addressAddlist_search_Button()); //根据需要关联的风险点执行查询操作
        List<WebElement> addElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        for (int i = 0; i < addElements.size(); i++) {
            if (addElements.get(i).getText().toString().equals(string)) {
                addElements.get(i).click();
                break;
            }
        }
        ea.click_left(rdlp.addressAddlist_addRelFunction_Button());
    }


    /**
     * @param addString 地点名称字符串
     * @throws IOException
     * @description 关联风险点，根据地点查询
     */
    public void chooseAddSearch(String addString) throws IOException {
        ea.type(rdlp.addressAddlist_address_textarea(), addString);
        ea.clickByJS(rdlp.search_Button());
    }

    /**
     * @throws IOException
     * @desc 删除关联关系
     */
    public void delAddressRelByRandom() throws IOException {
        setDefult();

        List<WebElement> dataElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(dataElements.size());//  根据当前页面上的数据,随机选择
        dataElements.get(temp).click();
        ea.click(rdlp.chooseAddress_Button());
        ea.sleep(1);
        motifyFrame(rdlp.iframe_addresslist());

        List<WebElement> addElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random1 = new Random();
        int temp1 = random1.nextInt(dataElements.size());//  根据当前页面上的数据,随机选择
        addElements.get(temp1).click();
        ea.click_left(rdlp.addresslist_delAddressRel_Button());
    }

    /**
     * @param fieldStr
     * @return
     * @throws IOException
     * @throws InterruptedException
     * @Description: 获取查询结果中指定字段值
     */
    public List<String> getSearchData(String fieldStr) throws IOException {
        List<String> resultList = new ArrayList<>();
        if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
            switch (fieldStr) {
                case "风险点类型":
                    List<WebElement> addressCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='addressCate']/div"));
                    for (int j = 0; j < addressCateElements.size(); j++) {
                        resultList.add(addressCateElements.get(j).getText());
                    }
                    break;
                case "辨识时间":
                    List<WebElement> yeRecognizeTimeElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRecognizeTime']/div"));
                    for (int j = 0; j < yeRecognizeTimeElements.size(); j++) {
                        resultList.add(yeRecognizeTimeElements.get(j).getText());
                    }
                    break;
                case "隐患描述":
                    List<WebElement> yeMhazardDescElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeMhazardDesc']/div"));
                    for (int j = 0; j < yeMhazardDescElements.size(); j++) {
                        resultList.add(yeMhazardDescElements.get(j).getText());
                    }

                    break;
                case "专业":
                    List<WebElement> yeProfessionElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeProfession']/div"));
                    for (int j = 0; j < yeProfessionElements.size(); j++) {
                        resultList.add(yeProfessionElements.get(j).getText());
                    }

                    break;
                case "伤害类别":
                    List<WebElement> damageTypeElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='damageType']/div"));
                    for (int j = 0; j < damageTypeElements.size(); j++) {
                        resultList.add(damageTypeElements.get(j).getText());
                    }
                    break;
                case "风险描述":
                    List<WebElement> yePossiblyHazardElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yePossiblyHazard']/div"));
                    for (int j = 0; j < yePossiblyHazardElements.size(); j++) {
                        resultList.add(yePossiblyHazardElements.get(j).getText());
                    }
                    break;
                case "作业活动":
                    List<WebElement> activityidElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activity.id']/div"));
                    for (int j = 0; j < activityidElements.size(); j++) {
                        resultList.add(activityidElements.get(j).getText());
                    }
                    break;
                case "风险等级":

                    List<WebElement> yeRiskGradeTempElements = driver.findElements(By
                            .xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRiskGradeTemp']//input"));
                    for (int j = 0; j < yeRiskGradeTempElements.size(); j++) {
                        resultList.add(yeRiskGradeTempElements.get(j).getText());
                    }
                    break;
                case "风险类型":
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeHazardCate']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        resultList.add(yeHazardCateElements.get(j).getText());
                    }
                    break;
                case "管控标准来源":
                    List<WebElement> docSourceElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='docSource']/div"));
                    for (int j = 0; j < docSourceElements.size(); j++) {
                        resultList.add(docSourceElements.get(j).getText());
                    }
                    break;
                case "标准内容":
                    List<WebElement> yeStandardElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeStandard']/div"));
                    for (int j = 0; j < yeStandardElements.size(); j++) {
                        resultList.add(yeStandardElements.get(j).getText());
                    }
                    break;
                case "隐患等级":
                    List<WebElement> hiddenLevelElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='hiddenLevel']/div"));
                    for (int j = 0; j < hiddenLevelElements.size(); j++) {
                        resultList.add(hiddenLevelElements.get(j).getText());
                    }
                    break;
            }
        } else {
            log.warn("根据查询条件>>无相关结果");
        }
        return resultList;
    }

    /**
     * @throws IOException
     * @Description: 重置查询条件
     */
    public void setDefult() throws IOException {

        motifyFrame(rdlp.iframe_reportDangerList());

        // 判断风险点类型是否为默认值
        ea.selectByIndex(rdlp.addressCate_select(), 0);
        // 判断辨识开始时间输入框是否为空
        ea.clear(rdlp.yeRecognizeTime_begin_textarea());
        // 判断辨识结束时间输入框是否为空
        ea.clear(rdlp.yeRecognizeTime_end_textarea());
        // 判断隐患描述输入框是否为空
        ea.clear(rdlp.yeMhazardDesc_textarea());
        // 判断专业是否为默认值
        ea.selectByIndex(rdlp.yeProfession_select(), 0);
        // 判断伤害类别是否为默认值
        ea.selectByIndex(rdlp.damageType_select(), 0);
        // 判断风险描述输入框是否为空
        ea.clear(rdlp.yePossiblyHazard_textarea());
        // 判断作业活动是否为默认值
        ea.selectByIndex(rdlp.activityId_select(), 0);
        // 判断风险等级是否为默认值
        ea.selectByIndex(rdlp.yeRiskGrade_select(), 0);
        // 判断风险类型是否为默认值
        ea.selectByIndex(rdlp.yeHazardCate_select(), 0);
        // 判断管控标准来源输入框是否为空
        ea.clear(rdlp.docSource_textarea());
        // 判断标准内容输入框是否为空
        ea.clear(rdlp.yeStandard_textarea());
        // 判断隐患等级是否为默认值
        ea.selectByIndex(rdlp.hiddenLevel_select(), 0);
        ea.clickByJS(rdlp.search_Button());
    }

    public void modityFrame(Locator locator) {
        ea.switchToDefaultFrame();
        ea.switchToFrame(locator);
    }

    public void chooseAddress(String string) throws IOException {
        ea.clickByJS("//*[contains(text(),'" + string + "')]");  //指定风险
        ea.clickByJS(rdlp.chooseAddress_Button());
        modityFrame(rdlp.iframe_addresslist());
        ea.clickByJS(rdlp.addresslist_chooseAddress_Button());
        modityFrame(rdlp.iframe_addressAddlist());

    }
}
