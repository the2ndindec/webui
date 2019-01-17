package com.webui.action;

import java.io.IOException;

import com.webui.pageObject.LoginPage;
import com.webui.utils.ElementAction;
import com.webui.utils.TestBaseCase;
import io.qameta.allure.Step;

public class LoginPageActions extends TestBaseCase {

	ElementAction ea = new ElementAction();
	LoginPage lp = new LoginPage();

	@Step(value = "输入用户名:{0}/密码:{1}")
	public void signInInit(String username, String password) throws IOException {
		ea.type(lp.userName_Text(), username);
		ea.type(lp.password_Text(), password);
		ea.click(lp.login_btn());
	}
}
