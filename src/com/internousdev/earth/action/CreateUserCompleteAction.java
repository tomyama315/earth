package com.internousdev.earth.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserCompleteAction extends ActionSupport implements SessionAware{

	private Map<String, Object> session;

	public String execute() {
		//sessionがタイムアウトのチェック
		if(session.isEmpty()) {
			return "sessionTimeout";
		}

		String result = ERROR;
		String sex = null;
		if (String.valueOf(session.get("sex")).equals("女性")) {
			sex = "1";
		} else {
			sex = "0";
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();
		int count = userInfoDAO.createUser(
				String.valueOf(session.get("familyName")),
				String.valueOf(session.get("firstName")),
				String.valueOf(session.get("familyNameKana")),
				String.valueOf(session.get("firstNameKana")),
				sex,
				String.valueOf(session.get("email")),
				String.valueOf(session.get("userIdForCreateUser")),
				String.valueOf(session.get("password")));

		if(count > 0) {
			result = SUCCESS;
		}

		session.remove("familyName");
		session.remove("firstName");
		session.remove("familyNameKana");
		session.remove("firstNameKana");
		session.remove("sex");
		session.remove("sexList");
		session.remove("email");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
