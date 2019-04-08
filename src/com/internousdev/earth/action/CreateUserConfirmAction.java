package com.internousdev.earth.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.UserInfoDAO;
import com.internousdev.earth.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class CreateUserConfirmAction extends ActionSupport implements SessionAware {

	private String familyName;
	private String firstName;
	private String familyNameKana;
	private String firstNameKana;
	private String sex;
	private String email;
	private String userId;
	private String password;
	private List<String>familyNameErrorMessageList;
	private List<String>firstNameErrorMessageList;
	private List<String>familyNameKanaErrorMessageList;
	private List<String>firstNameKanaErrorMessageList;
	private List<String>emailErrorMessageList;
	private List<String>userIdErrorMessageList;
	private List<String>passwordErrorMessageList;
	private String isExistsUserErrorMessage;
	private Map<String, Object>session;

	public String execute() {

//タイムアウトのチェック
		if(session.isEmpty()) {
			return "sessionTimeout";
		}

		String result=ERROR;

		session.put("familyName", familyName);
		session.put("firstName", firstName);
		session.put("familyNameKana", familyNameKana);
		session.put("firstNameKana", firstNameKana);
		session.put("sex", sex);
		session.put("email", email);
		session.put("userIdForCreateUser", userId);
		session.put("password", password);
//インプットチェッカーのインスタンス化
		InputChecker inputChecker=new InputChecker();

//（項目名、値、最小文字数、最大文字数、 半角英字を許容するか、漢字を許容するか、ひらがなを許容するか、半角数字を許容するか、
//半角記号を許容するか、カタカナを許容するか、スペースを許容するか）
//渡された値が正規表現にマッチしているかチェックするためのもの。
		familyNameErrorMessageList=inputChecker.doCheck("姓", familyName, 1, 16, true, true, true, false, false, false, false);
		firstNameErrorMessageList=inputChecker.doCheck("名", firstName, 1, 16, true, true, true, false, false, false, false);
		familyNameKanaErrorMessageList=inputChecker.doCheck("姓ふりがな", familyNameKana, 1, 16, false, false, true, false, false, false, false);
		firstNameKanaErrorMessageList=inputChecker.doCheck("名ふりがな", firstNameKana, 1, 16, false, false, true, false, false, false, false);
		emailErrorMessageList=inputChecker.doCheck("メールアドレス", email, 1, 32, true, false, false, true, true, false, false);
		userIdErrorMessageList=inputChecker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false, false);
		passwordErrorMessageList=inputChecker.doCheck("パスワード", password, 1, 16, true,false, false, true, false, false, false);

//0だったらエラーメッセージを表示する。かつ、または〜
		if(familyNameErrorMessageList.size()>0
		|| firstNameErrorMessageList.size()>0

		|| familyNameKanaErrorMessageList.size()>0

		|| firstNameKanaErrorMessageList.size()>0

		|| emailErrorMessageList.size()>0

		|| userIdErrorMessageList.size()>0

		|| passwordErrorMessageList.size() > 0) {
			return result;
		}

		UserInfoDAO userInfoDAO=new UserInfoDAO();
//ユーザーIDがすでに使われているかチェック
//もし存在するユーザーIDだったらエラーメッセージを表示する。
		if(userInfoDAO.isExistsUserInfo(userId)) {
			isExistsUserErrorMessage="使用できないユーザーIDです。";
//それ以外ならサクセス
		}else {
			result=SUCCESS;
		}
//結果を返す
		return result;
	}

//ゲットして、
	public String getFamilyName() {
		return familyName;
	}
//登録する
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName=firstName;
	}

	public String getFamilyNameKana() {
		return familyNameKana;
	}
	public void setFamilyNameKana(String familyNameKana) {
	this.familyNameKana=familyNameKana;
	}

	public String getFirstNameKana() {
		return firstNameKana;
	}
	public void setFirstNameKana(String firstNameKana) {
		this.firstNameKana=firstNameKana;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex=sex;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email=email;
	}

	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId=userId;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password=password;
	}

	public List<String> getFamilyNameErrorMessageList() {
		return familyNameErrorMessageList;
	}
	public void setFamilyNameErrorMessageList(List<String> familyNameErrorMessageList) {
		this.familyNameErrorMessageList=familyNameErrorMessageList;
	}

	public List<String> getFirstNameErrorMessageList() {
		return firstNameErrorMessageList;
	}
	public void setFirstNameErrorMessageList(List<String> firstNameErrorMessageList) {
		this.firstNameErrorMessageList=firstNameErrorMessageList;
	}


	public List<String> getFamilyNameKanaErrorMessageList() {
		return familyNameKanaErrorMessageList;
	}
	public void setFamilyNameKanaErrorMessageList(List<String> familyNameKanaErrorMessageList) {
		this.familyNameKanaErrorMessageList=familyNameKanaErrorMessageList;
	}

	public List<String> getFirstNameKanaErrorMessageList() {
		return firstNameKanaErrorMessageList;
	}
	public void setFirstNameKanaErrorMessageList(List<String> firstNameKanaErrorMessageList) {
		this.firstNameKanaErrorMessageList=firstNameKanaErrorMessageList;
	}

	public List<String> getEmailErrorMessageList(){
		return emailErrorMessageList;
	}
	public void setEmailErrorMessageList(List<String> emailErrorMessageList) {
		this.emailErrorMessageList=emailErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList(){
		return passwordErrorMessageList;
	}
	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public String IsExistsUserErrorMessage() {
		return isExistsUserErrorMessage;
	}
	public void setIsExistsUserErrorMessage(String isExistsUserErrorMessage) {
		this.isExistsUserErrorMessage=isExistsUserErrorMessage;
	}


	public Map<String, Object>getSession(){
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}


