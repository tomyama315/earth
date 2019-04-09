/**
 * @author sksgym（すぎ）
 */
package com.internousdev.earth.action;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.CartInfoDAO;
import com.internousdev.earth.dao.UserInfoDAO;
import com.internousdev.earth.dto.CartInfoDTO;
import com.internousdev.earth.dto.UserInfoDTO;
import com.internousdev.earth.util.InputChecker;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {
	private String userId;
	private String password;
	private List<CartInfoDTO> cartlist;
	private boolean saveduseridflag;
	private List<String> userIdErrorMessageList;
	private List<String> passwordErrorMessageList;
	private String isNotUserInfoMessage;
	private Map<String, Object> session;
	private int totalprice;

	public String execute() throws SQLException {

		// session内に何も情報が入っていない場合、タイムアウト（接続不可）と扱う。
		if (session.isEmpty()) {
			return "sessionTimeout";
		}

		// strutsにresultを渡して画面推移を行う。ひとまずエラー扱いとする。
		String result = ERROR;

		if (saveduseridflag) {
			// [ユーザーIDの保存]にチェックを入れたかどうか
			session.put("saveduseridflag", true);
			// 保存したユーザーIDと入力されたIDの照合。
			session.put("loginuserid", userId);
		} else {
			// session内に格納している不要な情報を削除する。
			session.remove("saveduseridflag");
			session.remove("loginuserid");
		}
		/**
		 * DBの会員情報テーブルにユーザーIDとパスワードが 一致するユーザーが存在しているかを確認する。
		 */
		InputChecker inputChecker = new InputChecker();
		userIdErrorMessageList = inputChecker.doCheck("ユーザーID", userId, 1, 8, true, false, false, true, false, false,
				false);
		passwordErrorMessageList = inputChecker.doCheck("パスワード", password, 1, 16, true, false, false, true, false,
				false, false);

		// エラー処理
		if (userIdErrorMessageList.size() > 0 || passwordErrorMessageList.size() > 0) {
			// ログインフラグを折る
			session.put("logined", 0);
			return result;
		}

		UserInfoDAO userInfoDAO = new UserInfoDAO();

		if (userInfoDAO.isExistsUserInfo(userId, password)) {

			if (userInfoDAO.login(userId, password) > 0) {
				// カートの情報をユーザーに紐付ける。
				// sessionからカート情報を取得
				@SuppressWarnings("unchecked")
				List<CartInfoDTO> cartlistBySession = (List<CartInfoDTO>) session.get("cartinfo");


				if (cartlistBySession != null) {
					boolean cartresult = changeCartInfo(cartlistBySession);
					if (!cartresult) {
						return result;
					}
				}

				// カート画面から推移してきた場合は、カート画面に推移する。
				if (session.containsKey("cartflg")) {
					session.remove("cartflg");
					result = "cart";
				} else {
					// ログインボタンを押下した場合は、自画面に推移。
					result = SUCCESS;
				}

				// ユーザー情報をsessionに登録し、ログイン可能にする。
				UserInfoDTO userInfoDTO = userInfoDAO.getUserInfo(userId, password);
				session.put("loginuserid", userInfoDTO.getUserId());
				session.put("logined", 1);
			}
		} else {
			isNotUserInfoMessage = "ユーザーIDまたはパスワードが異なります。";
		}
		return result;
	}

	/**
	 * DBのカート情報を更新/作成する。
	 *
	 * @param cartlistBySession
	 */
	private boolean changeCartInfo(List<CartInfoDTO> cartlistBySession) {
		int count = 0;
		boolean result = false;
		String tempUserId = session.get("tempuserid").toString();
		CartInfoDAO cartInfoDAO = new CartInfoDAO();

		for (CartInfoDTO dto : cartlistBySession) {
			// sessionに入っている（画面に表示されている）
			// カート情報と同じ商品のデータが
			// すでにDBに存在するかをチェックする。

			if (cartInfoDAO.isExistsCartInfo(userId, dto.getProductId())) {
				// 存在する場合は、カート情報テーブルの購入個数を更新し、tempUserIdのデータは削除する。
				try {
					count += cartInfoDAO.updateFromLogin(dto.getProductCount(), userId, dto.getProductId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				cartInfoDAO.delete(tempUserId, dto.getProductId());

			} else {
				// 存在しない場合は、ユーザーIDをtempUserIdからuserIdに変更する。
				try {
					count += cartInfoDAO.linkToUserId(tempUserId, userId, dto.getProductId());
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		if (count == cartlistBySession.size()) {
			try {
				cartlist = cartInfoDAO.getCartContents(userId);
				for(CartInfoDTO dto:cartlist){ //合計値の更新
					totalprice+=dto.getSum();
				}
				session.put("cartinfo", cartlist);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			result = true;
		}
		return result;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isSaveduseridflag() {
		return saveduseridflag;
	}

	public void setSaveduseridflag(boolean saveduseridflag) {
		this.saveduseridflag = saveduseridflag;
	}

	public List<String> getUserIdErrorMessageList() {
		return userIdErrorMessageList;
	}

	public void setUserIdErrorMessageList(List<String> userIdErrorMessageList) {
		this.userIdErrorMessageList = userIdErrorMessageList;
	}

	public List<String> getPasswordErrorMessageList() {
		return passwordErrorMessageList;
	}

	public void setPasswordErrorMessageList(List<String> passwordErrorMessageList) {
		this.passwordErrorMessageList = passwordErrorMessageList;
	}

	public String getIsNotUserInfoMessage() {
		return isNotUserInfoMessage;
	}

	public void setIsNotUserInfoMessage(String isNotUserInfoMessage) {
		this.isNotUserInfoMessage = isNotUserInfoMessage;
	}


	public Map<String, Object> getSession() {
		return session;
	}


	public List<CartInfoDTO> getCartlist() {
		return cartlist;
	}

	public void setCartlist(List<CartInfoDTO> cartlist) {
		this.cartlist = cartlist;
	}


	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
