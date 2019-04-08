package com.internousdev.earth.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;


public class ResetPasswordAction extends ActionSupport implements SessionAware{
	private int backFlag;
	private Map<String, Object> session;

	public String execute() {
//タイムアウトのチェック
		if(session.isEmpty()) {
			return "sessionTimeout";
		}

//もしbackFlagが１じゃなかったら・・・
		if (backFlag != 1) {
//セッション情報を削除→userIdForResetPassword;
			session.remove("userIdForResetPassword");
		}

		return SUCCESS;
	}
	public int getBackFlag() {
		return backFlag;
	}
	public void setBackFlag(int backFlag) {
		this.backFlag = backFlag;
	}
	public Map<String, Object> getSession() {
		return session;
	}
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
