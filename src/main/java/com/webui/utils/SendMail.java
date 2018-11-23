package com.webui.utils;

import java.util.ArrayList;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	private Log log = new Log(SendMail.class);

	public void sendmessage(String userName, String passWord, String smtpHost, String smtpPort, String from, String tos,
			String title, String content) {
		Properties smtpProper = setSmtp(smtpHost, smtpPort, userName, passWord);
		Auth authenticator = new Auth(userName, passWord);
		try {

			// 创建session实例
			Session session = Session.getInstance(smtpProper, authenticator);
			MimeMessage message = new MimeMessage(session);
			session.setDebug(true);

			// 设置from发件人邮箱地址
			message.setFrom(new InternetAddress(from));
			// 收件人to LIST
			ArrayList<Address> toList = new ArrayList<Address>();
			// 收件人字符串通过,号分隔收件人
			String[] toArray = tos.split(",");
			for (int i = 0; i < toArray.length; i++) {
				String str = toArray[i];
				toList.add(new InternetAddress(str));
			}
			// 将收件人列表转换为收件人数组
			Address[] addresses = new Address[toList.size()];
			addresses = toList.toArray(addresses);
			// 设置to收件人地址
			message.setRecipients(MimeMessage.RecipientType.TO, addresses);
			// 设置邮件标题
			message.setSubject(title);
			// 设置邮件内容
			message.setContent(content, "text/html;charset=UTF-8");
			// Transport.send(message);
			Transport transport = session.getTransport();
			transport.connect(smtpHost, userName, passWord);
			transport.sendMessage(message, addresses);
			log.info("发送邮件成功！");

		} catch (Exception e) {
			// TODO: handle exception
			log.error("发送邮件失败！");
			e.printStackTrace();
		}

	}

	private Properties setSmtp(String smtpHost, String smtpPort, String userName, String passWord) {
		// 创建邮件配置文件
		Properties maiProperties = new Properties();
		// 配置smtp发件服务器
		maiProperties.put("mail.transport.protocol", "smtp");
		// 配置smtp服务器
		maiProperties.put("mail.smtp.host", smtpHost);
		// 配置smtp服务器端口
		maiProperties.put("mail.smtp.port", smtpPort);
		// 配置smtp用户名
		maiProperties.put("mail.user", userName);
		// 配置smtp身份验证
		maiProperties.put("mail.smtp.auth", "true");
		return maiProperties;
	}

	class Auth extends Authenticator {
		Properties pwdProperties;

		public Auth(String userName, String passWord) {
			try {
				pwdProperties.put(userName, passWord);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		public PasswordAuthentication passwordAuthentication() {
			String userName = getDefaultUserName();
			// 当前用户在密码表里
			if (pwdProperties.containsKey(userName)) {
				// 取出密码，封装好后返回
				return new PasswordAuthentication(userName, pwdProperties.getProperty(userName).toString());
			} else {
				// 如果当前用户不在密码表里就返回Null
				System.out.println("当前用户不存在");
				return null;
			}
		}
	}

}
