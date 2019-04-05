/**
 * @author sksgym（すぎ）
 */
package com.internousdev.earth.action;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class GoLoginAction extends ActionSupport implements SessionAware {
	private Map<String, Object> session;

	public String execute() {

		//session内に何も情報が入っていない場合、タイムアウト（接続不可）と扱う。
		if(session.isEmpty()) {
			return "sessionTimeout";
		}

		session.remove("cartflag");
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

	}

}
