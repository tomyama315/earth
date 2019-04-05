/**
 * @author sksgym（すぎ）
 */
package com.internousdev.earth.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.UserInfoDAO;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {
		UserInfoDAO userInfoDAO = new UserInfoDAO();
		String userId = String.valueOf(session.get("loginuserid"));
		boolean savedUserId = Boolean.valueOf(String.valueOf(session.get("loginflag")));

		int count = userInfoDAO.logout(userId);
		//DBのuserIdが0以上（誰かがログインしている）状態なら～
		if(count > 0) {
			session.clear();
			if(savedUserId) {
				session.put("loginflag", savedUserId);
				session.put("loginuserid", userId);
			}
		}
		return SUCCESS;
	}
	/**
	 * sessionを使うためのゲッター・セッター
	 */

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;

	}


}
