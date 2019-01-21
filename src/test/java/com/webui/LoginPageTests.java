package com.webui;

import com.webui.Listener.TestFailListener;
import com.webui.action.LoginPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.pageObject.LoginPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description 登陆功能模块测试
 * @Data 2018/11/28 11:30
 */
@Listeners({TestFailListener.class})
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

    @Test
    @Step("方法failLogin步骤：输入用户名")
    public void failLogin() throws IOException {
        loginPageActions.signInInit("admin", "");
        Assertion.verityString(elementAction.getText(lp.errorwithoutpassword_tip()),"请输入密码");
    }
}
