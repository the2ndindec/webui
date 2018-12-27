package com.webui.action.aqfxfjgk.annualrisk;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReportDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.Locator;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author the2n
 * @date: 2018年11月13日 下午4:05:22
 * @Description:本矿风险汇总页面包含的功能
 */
public class ReportDangerListPageActions extends TestBaseCase {

    ElementAction ea = new ElementAction();
    ReportDangerListPage rdlp = new ReportDangerListPage();
    DefultPage dp = new DefultPage();

    /**
     * @param addressCate 需要查询的风险点类型字段值
     * @throws IOException
     * @Description:根据风险点类型执行查询操作
     */
    @Step(value = "输入查询条件，风险点")
    public void searchByAddressCate(String addressCate) throws IOException {
        ea.selectByText(rdlp.addressCate_select(), addressCate);
        doSearch(rdlp.search_Button(), 3);
    }

    /**
     * @param yeMhazardDesc 隐患描述字段值
     * @throws IOException
     * @Description:根据隐患描述执行查询操作
     */
    public void searchByYeMhazardDesc(String yeMhazardDesc) throws IOException {
        setDefult();
        ea.type(rdlp.yeMhazardDesc_textarea(), yeMhazardDesc);
        doSearch(rdlp.search_Button(), 3);
    }

    /**
     * @param yeProfession 专业字段值
     * @throws IOException
     * @Description:根据专业执行查询操作
     */
    public void searchByYeProfession(String yeProfession) throws IOException {
        setDefult();
        ea.selectByText(rdlp.yeProfession_select(), yeProfession);
        doSearch(rdlp.search_Button(), 3);
    }

    /**
     * @param damageType 伤害类别字段值
     * @throws IOException
     * @Description 根据伤害类别执行查询操作
     */
    public void searchByDamageType(String damageType) throws IOException {
        setDefult();
        ea.selectByText(rdlp.damageType_select(), damageType);
        doSearch(rdlp.search_Button(), 3);
    }

    /**
     * @param yePossiblyHazard 风险描述字段值
     * @throws IOException
     * @Description 根据风险描述执行查询操作
     */
    public void searchByYePossiblyHazard(String yePossiblyHazard) throws IOException {
        setDefult();
        ea.type(rdlp.yePossiblyHazard_textarea(), yePossiblyHazard);
        doSearch(rdlp.search_Button(), 3);
    }

    /**
     * @param activityid 作业活动字段值
     * @throws IOException
     * @description 根据作业活动执行查询操作
     */
    public void searchByActivityid(String activityid) throws IOException {
        setDefult();
        ea.selectByText(rdlp.activityId_select(), activityid);
        doSearch(rdlp.search_Button(), 3);
    }

    private void doSearch(Locator locator, int i) {
        ea.sleep(1);
        ea.click_left(locator);
        ea.sleep(i);
    }

    /**
     * @param yeRiskGradeTemp 风险等级字段值
     * @throws IOException
     * @description 根据风险等级执行查询操作
     */
    public void searchByYeRiskGradeTemp(String yeRiskGradeTemp) throws IOException {
        setDefult();
        ea.selectByText(rdlp.yeRiskGrade_select(), yeRiskGradeTemp);
        doSearch(rdlp.search_Button(), 3);
    }

    /**
     * @param yeHazardCate 风险类型字段值
     * @throws IOException
     * @description 根据风险类型执行查询操作
     */
    public void searchByYeHazardCate(String yeHazardCate) throws IOException {
        setDefult();
        ea.selectByText(rdlp.yeRiskGrade_select(), yeHazardCate);
        doSearch(rdlp.search_Button(), 3);
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
        doSearch(rdlp.search_Button(), 2);
        List<WebElement> dataElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(dataElements.size());//  根据当前页面上的数据,随机选择
        dataElements.get(temp).click();
        ea.click(rdlp.chooseAddress_Button());
        ea.sleep(1);
        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_addresslist()); //切换到风险点列表弹框
        ea.click_left(rdlp.addresslist_chooseAddress_Button());
        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_addressAddlist()); //切换选择风险点弹框
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
        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_addresslist()); //切换到风险点列表弹框
        ea.sleep(1);
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
        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_addresslist()); //切换到风险点列表弹框
        ea.click_left(rdlp.addresslist_chooseAddress_Button());
        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_addressAddlist()); //切换选择风险点弹框
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
        doSearch(rdlp.addressAddlist_search_Button(), 3);
    }

    /**
     * @throws IOException
     * @desc 删除关联关系
     */
    public void delAddressRelByRandom() throws IOException {
        setDefult();
        doSearch(rdlp.search_Button(), 2);

        List<WebElement> dataElements = driver.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
        Random random = new Random();
        int temp = random.nextInt(dataElements.size());//  根据当前页面上的数据,随机选择
        dataElements.get(temp).click();
        ea.click(rdlp.chooseAddress_Button());
        ea.sleep(1);
        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_addresslist()); //切换到风险点列表弹框

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
     * @Description:获取查询结果中指定字段值
     */
    public List<String> getSearchData(String fieldStr) throws IOException, InterruptedException {
        List<String> addressCateList = new ArrayList<>();
        switch (fieldStr) {
            case "风险点类型":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> addressCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='addressCate']/div"));
                    for (int j = 0; j < addressCateElements.size(); j++) {
                        addressCateList.add(addressCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "隐患描述":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> yeMhazardDescElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeMhazardDesc']/div"));
                    for (int j = 0; j < yeMhazardDescElements.size(); j++) {
                        addressCateList.add(yeMhazardDescElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "专业":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> yeProfessionElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeProfession']/div"));
                    for (int j = 0; j < yeProfessionElements.size(); j++) {
                        addressCateList.add(yeProfessionElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "伤害类别":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> damageTypeElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='damageType']/div"));
                    for (int j = 0; j < damageTypeElements.size(); j++) {
                        addressCateList.add(damageTypeElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险描述":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> yePossiblyHazardElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yePossiblyHazard']/div"));
                    for (int j = 0; j < yePossiblyHazardElements.size(); j++) {
                        addressCateList.add(yePossiblyHazardElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "作业活动":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> activityidElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='activity.id']/div"));
                    for (int j = 0; j < activityidElements.size(); j++) {
                        addressCateList.add(activityidElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险等级":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> yeRiskGradeTempElements = driver.findElements(By
                            .xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeRiskGradeTemp']//input"));
                    for (int j = 0; j < yeRiskGradeTempElements.size(); j++) {
                        addressCateList.add(yeRiskGradeTempElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险类型":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='yeHazardCate']/div"));
                    for (int j = 0; j < yeHazardCateElements.size(); j++) {
                        addressCateList.add(yeHazardCateElements.get(j).getText());
                    }
                } else {
                    log.info("根据查询条件>>无相关结果");
                }
                break;
            case "风险点":
                if (ea.isElementDisplayedByLocator(rdlp.data_tbody())) {
                    List<WebElement> yeHazardCateElements = driver.findElements(
                            By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr/td[@field='address']/div"));
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

    /**
     * @throws IOException
     * @Description:重置查询条件
     */
    public void setDefult() throws IOException {

        ea.switchToDefaultFrame();
        ea.switchToFrame(rdlp.iframe_reportDangerList());

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
    }
}
