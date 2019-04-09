package com.internousdev.earth.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.CartInfoDAO;
import com.internousdev.earth.dao.DestinationInfoDAO;
import com.internousdev.earth.dto.CartInfoDTO;
import com.internousdev.earth.dto.DestinationInfoDTO;
//import com.internousdev.earth.dao.CartInfoDAO;
//import com.internousdev.earth.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {
	// private List<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
	private List<DestinationInfoDTO> destinationInfoDTO = new ArrayList<DestinationInfoDTO>();
	private Map<String, Object> session;
	private List<CartInfoDTO> cartInfoDTO;

	@Override
	public String execute() throws SQLException {
		if (session.isEmpty()) {
			return "sessionTimeout";
		}
		CartInfoDAO dao = new CartInfoDAO();
		session.put("cartinfo", cartInfoDTO);


		String result;

		// 動作確認用
		// session.put("logined", 1);
		// session.put("loginuserid", 12);

		/**
		 * 決済ボタン押下(カート画面) ログイン判定
		 */
		// 未ログインだったらログイン画面へ
		if (session.get("logined").equals(0)) {
			// ログイン機能でカート画面から遷移してきた場合、認証成功でカート画面に戻るのでflgを渡す。
			session.put("cartflg", "1");
			result = "login";
		}
		// ログインしてたら宛先情報確認
		else {
			System.out.println("else");
			DestinationInfoDAO destinationInfoDAO = new DestinationInfoDAO();
			// getDestinationInfoメソッドを呼び出し、引数にString型のuserIdを渡す
			// ユーザーIDごとの宛先情報をselectしてdestinationInfoDTOに格納
			// jsp側でdestinationInfoDTOのnull判定をする(宛先情報判定)
			// null:宛先情報はありません。
			// !null:宛先情報を選択して下さい。
			System.out.println(session.get("loginuserid"));
			destinationInfoDTO = destinationInfoDAO.destinationInfo(session.get("loginuserid").toString());

			// 動作確認用
			// System.out.println(destinationInfoDTO);
			// System.out.println(destinationInfoDTO == null);
			// System.out.println(destinationInfoDTO.size());
			// System.out.println(destinationInfoDTO.isEmpty());
			result = SUCCESS;
		}
		System.out.println(result);
		return result;
	}

	 public List<CartInfoDTO> getCartInfoDTO() {
	 return cartInfoDTO;
	 }

	 public void setCartInfoDTO(List<CartInfoDTO> cartInfoDTO) {
	 this.cartInfoDTO = cartInfoDTO;
	 }

	public List<DestinationInfoDTO> getDestinationInfoDTO() {
		return destinationInfoDTO;
	}

	public void setDestinationInfoDTO(List<DestinationInfoDTO> destinationInfoDTO) {
		this.destinationInfoDTO = destinationInfoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
