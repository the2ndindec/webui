package com.webui.action;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.webui.pageObject.DefultPage;
import com.webui.pageObject.ReportDangerListPage;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;

import io.qameta.allure.Step;

/**
 * 
 * @author the2n
 * @date: 2018年11月13日 下午4:05:22
 * @Description:本矿风险汇总页面包含的功能
 */
public class ReportDangerListPageActions extends TestBaseCase {

	ElementAction ea = new ElementAction();
	ReportDangerListPage rdlp = new ReportDangerListPage();
	DefultPage dp = new DefultPage();

	/**
	 * 
	 * @param addressCate 需要查询的风险点类型字段值
	 * @throws IOException
	 * @Description:根据风险点类型执行查询操作
	 */
	@Step(value = "输入查询条件，风险点")
	public void searchByAddressCate(String addressCate) throws IOException {
		ea.selectByText(rdlp.addressCate_select(), addressCate);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param yeMhazardDesc 隐患描述字段值
	 * @throws IOException
	 * @Description:根据隐患描述执行查询操作
	 */
	public void searchByYeMhazardDesc(String yeMhazardDesc) throws IOException {
		setDefult();
		ea.type(rdlp.yeMhazardDesc_textarea(), yeMhazardDesc);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param yeProfession 专业字段值
	 * @throws IOException
	 * @Description:根据专业执行查询操作
	 */
	public void searchByYeProfession(String yeProfession) throws IOException {
		setDefult();
		ea.selectByText(rdlp.yeProfession_select(), yeProfession);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param damageType 伤害类别字段值
	 * @throws IOException
	 * @Description 根据伤害类别执行查询操作
	 */
	public void searchByDamageType(String damageType) throws IOException {
		setDefult();
		ea.selectByText(rdlp.damageType_select(), damageType);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param yePossiblyHazard 风险描述字段值
	 * @throws IOException
	 * @Description 根据风险描述执行查询操作
	 */
	public void searchByYePossiblyHazard(String yePossiblyHazard) throws IOException {
		setDefult();
		ea.type(rdlp.yePossiblyHazard_textarea(), yePossiblyHazard);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param activityid 作业活动字段值
	 * @throws IOException
	 * @description 根据作业活动执行查询操作
	 */
	public void searchByActivityid(String activityid) throws IOException {
		setDefult();
		ea.selectByText(rdlp.activityId_select(), activityid);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param yeRiskGradeTemp 风险等级字段值
	 * @throws IOException
	 * @description 根据风险等级执行查询操作
	 */
	public void searchByYeRiskGradeTemp(String yeRiskGradeTemp) throws IOException {
		setDefult();
		ea.selectByText(rdlp.yeRiskGrade_select(), yeRiskGradeTemp);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @param yeHazardCate 风险类型字段值
	 * @throws IOException
	 * @description 根据风险类型执行查询操作
	 */
	public void searchByYeHazardCate(String yeHazardCate) throws IOException {
		setDefult();
		ea.selectByText(rdlp.yeRiskGrade_select(), yeHazardCate);
		ea.sleep(1);
		ea.click_left(rdlp.search_Button());
		ea.sleep(3);
	}

	/**
	 * 
	 * @throws IOException
	 * @description 打开关联风险点
	 */
	public void chooseAddress() throws IOException {
		List<WebElement> dataElements = driver
				.findElements(By.xpath(".//div[@class='datagrid-view2']/div[2]//tbody/tr"));
		Random random = new Random();
		int temp = random.nextInt(dataElements.size());
		dataElements.get(temp).click();
		ea.click(rdlp.chooseAddress_Button());
	}


	/**
	 * 
	 * @param addString 地点名称字符串
	 * @throws IOException
	 * @description 关联风险点，根据地点查询
	 */
	public void chooseAddSearch(String addString) throws IOException {
		ea.type(rdlp.addressAddlist_address_textarea(), addString);
		ea.sleep(1);
		ea.click_left(rdlp.addressAddlist_search_Button());
		ea.sleep(3);
	}

	/**
	 * 
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
		}
		return addressCateList;
	}

	/**
	 * 
	 * @throws IOException
	 * @Description:重置查询条件
	 */
	public void setDefult() throws IOException {

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
