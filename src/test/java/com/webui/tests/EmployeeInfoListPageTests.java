package com.webui.tests;

import com.webui.action.EmployeeInfoListPageActions;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Feature;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description
 * @Data 2018/12/05 14:22
 */
public class EmployeeInfoListPageTests extends TestBaseCase {
    ElementAction elementAction = new ElementAction();
    EmployeeInfoListPageActions employeeInfoListPageActions = new EmployeeInfoListPageActions();

    @Feature("查询")
    @Test(description = "验证根据档案号查询功能")
    @Parameters({"fileNo", "searchfileNo"})
    public void TC_searchByFileNo(String fileNo, String searchfileNo) throws IOException {
        employeeInfoListPageActions.modifyMenu();
        employeeInfoListPageActions.searchByFileNo(fileNo);
        for (int i = 0; i < employeeInfoListPageActions.getSearchData(searchfileNo).size(); i++) {
            Assertion.VerityCationString(employeeInfoListPageActions.getSearchData(searchfileNo).get(i), fileNo);
        }
    }

    @Feature("查询")
    @Test(description = "验证根据在岗编号查询功能")
    @Parameters({"postNo", "searchpostNo"})
    public void TC_searchByPostNumber(String postNo, String searchpostNo) throws IOException {
        employeeInfoListPageActions.doReset();
        employeeInfoListPageActions.searchByPostNumber(postNo);
        for (int i = 0; i < employeeInfoListPageActions.getSearchData(searchpostNo).size(); i++) {
            Assertion.VerityCationString(employeeInfoListPageActions.getSearchData(searchpostNo).get(i), postNo.trim());
        }
    }

    @Feature("查询")
    @Test(description = "验证根据退休编号查询功能")
    @Parameters({"retireNumber", "searchretireNumber"})
    public void TC_searchByRetireNumber(String retireNumber, String searchretireNumber) throws IOException {
        employeeInfoListPageActions.doReset();
        employeeInfoListPageActions.searchByRetireNumber(retireNumber);
        for (int i = 0; i < employeeInfoListPageActions.getSearchData(searchretireNumber).size(); i++) {
            Assertion.VerityCationString(employeeInfoListPageActions.getSearchData(searchretireNumber).get(i), retireNumber.trim());
        }
    }

    @Feature("查询")
    @Test(description = "验证根据姓名查询功能")
    @Parameters({"name", "searchname"})
    public void TB_searchByName(String name, String searchname) throws IOException {
        employeeInfoListPageActions.doReset();
        employeeInfoListPageActions.searchByName(name);
        for (int i = 0; i < employeeInfoListPageActions.getSearchData(searchname).size(); i++) {
            Assertion.VerityCationString(employeeInfoListPageActions.getSearchData(searchname).get(i), name.trim());
        }
    }

    @Feature("查询")
    @Test(description = "验证根据身份证号查询功能")
    @Parameters({"cardNumber", "searchcardNumber"})
    public void TC_searchByCardNumber(String cardNumber, String searchcardNumber) throws IOException {
        employeeInfoListPageActions.doReset();
        employeeInfoListPageActions.searchByCardNumber(cardNumber);
        for (int i = 0; i < employeeInfoListPageActions.getSearchData(searchcardNumber).size(); i++) {
            Assertion.VerityCationString(employeeInfoListPageActions.getSearchData(searchcardNumber).get(i), cardNumber.trim());
        }
    }
}
