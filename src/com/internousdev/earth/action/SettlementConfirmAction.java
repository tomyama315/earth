package com.internousdev.earth.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.DestinationInfoDAOA;
//import com.internousdev.earth.dao.CartInfoDAO;
//import com.internousdev.earth.dto.CartInfoDTO;
import com.internousdev.earth.dto.DestinationInfoDTOA;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementConfirmAction extends ActionSupport implements SessionAware {
//	private List<CartInfoDTO> cartInfoDTO = new ArrayList<CartInfoDTO>();
	private List<DestinationInfoDTOA> destinationInfoDTO = new ArrayList<DestinationInfoDTOA>();
	private Map<String, Object> session;

	@Override
	public String execute() throws SQLException {
		String result = ERROR;
		// 決済ボタン押下(カート画面)
		// ユーザーID、宛先情報ID、商品ID、個数、金額を送る
		// CartInfoDAO cartInfoDAO = new CartInfoDAO();
		// cartInfoDTO = cartInfoDAO.getCartInfoDTOList(session.get("userid").toString());
		// session.put("cartInfoDTO", cartInfoDTO);

		/**
		 * 決済ボタン押下(カート画面) ログイン判定
		 */
		// 未ログインだったらログイン画面へ
		if (session.get("loginFlg").equals(0)) {
			result = "login";
		}
		// ログインしてたら宛先情報確認
		else {
			DestinationInfoDAOA destinationInfoDAO = new DestinationInfoDAOA();
			// getDestinationInfoメソッドを呼び出し、引数にString型のuserIdを渡す
			// ユーザーIDごとの宛先情報をselectしてdestinationInfoDTOに格納
			// jsp側でdestinationInfoDTOのnull判定をする(宛先情報判定)
			// null:宛先情報はありません。
			// !null:宛先情報を選択して下さい。
			destinationInfoDTO = destinationInfoDAO.destinationInfo(session.get("userid").toString());
			result = "SUCCESS";
		}
		return result;
	}

	// public List<CartInfoDTO> getCartInfoDTO() {
	// return cartInfoDTO;
	// }
	//
	// public void setCartInfoDTO(List<CartInfoDTO> cartInfoDTO) {
	// this.cartInfoDTO = cartInfoDTO;
	// }

	public List<DestinationInfoDTOA> getDestinationInfoDTO() {
		return destinationInfoDTO;
	}

	public void setDestinationInfoDTO(List<DestinationInfoDTOA> destinationInfoDTO) {
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
