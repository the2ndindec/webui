package com.webui;

import com.webui.action.LoginPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.LoginPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.*;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description 登陆功能模块测试
 * @Data 2018/11/28 11:30
 */

@Feature("登录测试")
public class LoginPageTests extends TestBaseCase {
    LoginPageActions loginPageActions = new LoginPageActions();
    ElementAction elementAction = new ElementAction();
    DefultPage defultPage = new DefultPage();
    LoginPage lp = new LoginPage();

    @Test(description = "正确登录")
    @Description("验证正确的用户名和密码是否可以登陆成功")
    public void TC_login() throws IOException {
        loginPageActions.signInInit("admin", "123456");
        Assertion.verityString(elementAction.getText(defultPage.userName_1()), "admin");
    }


    public void Tc_cookies(){
      loginPageActions.testCookies();
    }

    @Test(description = "使用用户名，不使用密码")
    @Description("验证在密码为空的情况下是否给出正确的提示信息")
    @Story("密码为空时登录测试")
    public void TC_Login_noPwd() throws IOException {
        loginPageActions.signInInit("admin", "");
        Assertion.verityString(elementAction.getAttribute(lp.tipWithoutPassword(),"innerText"),"请输入密码");
        elementAction.clickByJS(lp.cancel_btn());

    }
    @Test(description = "不使用用户名，不使用密码")
    @Description("验证在用户名/密码为空的情况下是否给出正确的提示信息")
    @Story("用户名/密码为空时登录测试")
    public void TC_loginExcludeNameAndPwd() throws IOException {
        loginPageActions.loginExcludeNameAndPwd();
        Assertion.verityString(elementAction.getAttribute(lp.tipWithoutPassword(),"innerText"),"请输入用户名");
        elementAction.clickByJS(lp.cancel_btn());
    }
    @Test(description = "用户名/密码不匹配")
    @Description("验证在用户名/密码不匹配的情况下是否给出正确的提示信息")
    @Story("用户名/密码不匹配时登录测试")
    public void TC_loginIncorrectPwd() throws IOException {
        loginPageActions.loginIncorrectPwd("admin","123");
        Assertion.verityCationString(elementAction.getAttribute(lp.tipWithoutPassword(),"innerText"),"用户名或密码错误");
    }
}
