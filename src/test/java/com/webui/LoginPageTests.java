package com.webui;

import com.webui.Listener.TestFailListener;
import com.webui.action.LoginPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.LoginPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description 登陆功能模块测试
 * @Data 2018/11/28 11:30
 */
@Listeners({TestFailListener.class})
@Feature("登录测试")
public class LoginPageTests extends TestBaseCase {
    LoginPageActions loginPageActions = new LoginPageActions();
    ElementAction elementAction = new ElementAction();
    DefultPage defultPage = new DefultPage();
    LoginPage lp = new LoginPage();

    @Test(description = "login")

    public void TC_login() throws IOException {
        loginPageActions.signInInit("admin", "123456");
        Assertion.verityString(elementAction.getText(defultPage.userName_1()), "admin");
    }

    @Test(description = "使用用户名，不使用密码")
    @Description("验证再密码为空的情况下是否给出正确的提示信息")
    @Story("密码为空时登录测试")
    public void failLogin() throws IOException {
        loginPageActions.signInInit("admin", "");
        Assertion.verityString(elementAction.getAttribute(lp.tipWithoutPassword(),"innerText"),"请输入密码");
    }
}
