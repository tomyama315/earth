package com.internousdev.earth.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class ResetPasswordCompleteAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;
//実行するよ
	public String execute() {
//sessionがタイムアウトのチェック
		if(session.isEmpty()) {
			return "sessionTimeout";
		}
//とりあえずエラーにしとく。
		String result = ERROR;
//インスタンス化する。
		UserInfoDAO userInfoDAO = new UserInfoDAO();

//countにuserIdForResetPasswordとnewPasswordをgetして代入する。
		int count = userInfoDAO.resetPassword(String.valueOf(session.get("userIdForResetPassword")),
			        String.valueOf(session.get("newPassword")));

//countが0より大きかったらサクセス
		if (count > 0) {
			result = SUCCESS;
		}

//セッション情報を削除して、結果を返す。
		session.remove("userIdForResetPassword");
		session.remove("newPassword");

		return result;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
