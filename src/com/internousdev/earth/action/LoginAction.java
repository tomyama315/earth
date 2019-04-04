/*
 * session使ってるのでctrl+Fで検索して
 *
 */
package com.internousdev.earth.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

//import com.internousdev.sampleweb.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;
//import com.internousdev.earth.dao.CartInfoDAO;
//import com.internousdev.earth.dao.UserInfoDAO;
//import com.internousdev.earth.dto.CartInfoDTO;
//import com.internousdev.earth.dto.UserInfoDTO;
import com.internousdev.earth.util.InputChecker;


public class LoginAction extends ActionSupport implements SessionAware{
	private String userId;
	private String password;
	private boolean savedUserIdFlag;
	private List<String> userIdErrorMessageList;
	private List<String> passwordErrorMessageList;
	private String isNotUserInfoMessage;
	private List<CartInfoDTO> cartInfoDTOList;
	private Map<String, Object> session;
	UserInfoDAO userInfoDAO = new UserInfoDAO();
	InputChecker inputChecker = new InputChecker();

//	ログインボタンを押下した場合は、自画面に推移。

//	メッセージ一覧の対象のエラーメッセージを表示


	//sessionを使用します。
	public String execute(){

		//session内に何も情報が入っていない場合、タイムアウト（接続不可）と扱う。
		if(session.isEmpty()) {
			return "sessionTimeout";
		}

		//strutsにresultを渡して画面推移を行う。ひとまずエラー扱いとする。
		String result = ERROR;

		if(savedUserIdFlag){
			//session内でログイン中のユーザーIDを他クラスと共有する。
			session.put("savedUserIdFlag", true);
			session.put("savedUserId", userId);
		}else{
			//session内に格納していた（かもしれない）いらない情報を削除する。
			session.remove("savedUserIdFlag");
			session.remove("savedUserId");
		}
/*
 * DBの会員情報テーブルにユーザーIDとパスワードが
 * 一致するユーザーが存在しているかを確認する。
 */

		//ユーザーIDは最低1文字、最大8文字
		userIdErrorMessageList = inputChecker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false, false);

		//パスワードは最低1文字、最大16文字
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false, false, false);
/*
 * 		エラーがない場合は認証処理を行う。
 */
		//loginedはたぶんUserInfoクラスからsessionを介して持ってきます。
		if(userIdErrorMessageList.size() > 0
		|| passwordErrorMessageList.size() > 0) {
			session.put("logined", 0);
			return result;
		}

		if(userInfoDAO.isExistsUserInfo(userId, password)) {

			if(userInfoDAO.login(userId,password) > 0) {
				//カートの情報をユーザーに紐付ける。
				//sessionからカート情報を取得
				//あとで
				@SuppressWarnings("unchecked")
				List<CartInfoDTO> cartInfoDTOListBySession = (List<CartInfoDTO> session.get("cartInfoDTOList");

				if(cartInfoDTOListBySession != null) {
					boolean cartresult = changeCartInfo(cartInfoDTOListBySession);
				}
			}
		}

		}






//	カート画面から推移してきた場合は、カート画面に推移する。

//	ヘッダーのログインボタンを押下した場合は、ホーム画面に推移する。

//	認証失敗した場合は、ログイン画面に推移し、エラー内容を表示する。

//	新規ユーザー登録ボタンを押下した場合は、ユーザー情報入力画面に推移する。

//	パスワード再設定ボタンを押下した場合は、パスワード再設定画面に推移する。




	@Override //Sessionを使うためのセッター
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
