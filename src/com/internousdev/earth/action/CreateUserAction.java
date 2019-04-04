package com.internousdev.earth.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class CreateUserAction extends ActionSupport implements SessionAware{
	private int backFlag;
	private Map<String, Object> session;

	public String execute() {
//sessionがタイムアウトのチェック
		if(session.isEmpty()) {
			return "sessionTimeout";
		}
//１じゃなかったら削除する
		if (backFlag != 1) {
			session.remove("familyName");
			session.remove("firstName");
			session.remove("familyNameKana");
			session.remove("firstNameKana");
			session.remove("sex");
			session.remove("sexList");
			session.remove("email");
			session.remove("userIdForCreateUser");
			session.remove("password");
		}
		List<String> sexList = new ArrayList<String>();
// 画面表示時に選択されている性別を作成
		if(!session.containsKey("sex")) {
			session.put("sex", "男性");
		}else {
			session.put("sex", String.valueOf(session.get("sex")));
		}
		sexList.add("男性");
		sexList.add("女性");
		session.put("sexList", sexList);

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
