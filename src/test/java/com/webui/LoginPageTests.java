package com.webui;

import com.webui.action.LoginPageActions;
import com.webui.pageObject.DefultPage;
import com.webui.utils.Assertion;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import org.testng.annotations.Test;

import java.io.IOException;

/**
 * @author the2n
 * @description 登陆功能模块测试
 * @Data 2018/11/28 11:30
 */
public class LoginPageTests extends TestBaseCase {
    LoginPageActions loginPageActions = new LoginPageActions();
    ElementAction elementAction = new ElementAction();
    DefultPage defultPage = new DefultPage();

    @Test(description = "login")
    public void TC_login() throws IOException {
        loginPageActions.signInInit("admin", "123456");
        Assertion.verityString(elementAction.getText(defultPage.userName_1()), "admin");
    }
}
