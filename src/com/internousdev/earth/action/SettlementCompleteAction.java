package com.internousdev.earth.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.CartInfoDAO;
import com.internousdev.earth.dao.PurchaseHistoryInfoDAO;
import com.internousdev.earth.dto.CartInfoDTO;
import com.internousdev.earth.dto.PurchaseHistoryInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class SettlementCompleteAction extends ActionSupport implements SessionAware {
	private List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTO = new ArrayList<PurchaseHistoryInfoDTO>();
	private Map<String, Object> session;
	private String destinationid;

	/**
	 * 宛先情報確認画面で決済ボタンを押す
	 * if(商品購入履歴登録) {
	 * 		if(カート情報削除) {
	 * 			決済完了画面
	 * 			}
	 * 		}
	 */

	@Override
	public String execute() {
		//初期：エラー画面
		String result = ERROR;

		//商品情報を格納
		@SuppressWarnings("unchecked")
		List<CartInfoDTO> cartInfoDTOList = (List<CartInfoDTO>) session.get("cartInfoDTOList");

		PurchaseHistoryInfoDAO purchaseHistoryInfoDAO = new PurchaseHistoryInfoDAO();
		//insertした商品数のカウント
		int insertcount = 0;
		//拡張for文でsessiongetしてきたListを取り出し
		for (CartInfoDTO dto : cartInfoDTOList) {
			//戻り値をinsertcountに入れる
			insertcount += purchaseHistoryInfoDAO.regist(
				//ユーザーID
				session.get("userId").toString(),
				//商品ID
				dto.getProductId(),
				//購入個数
				dto.getProductCount(),
				//金額
				dto.getSubtotal(),
				//宛先情報ID(ラジオボタンでIDが飛んでくるのでvaluestackで受け取る)
				Integer.parseInt(destinationid));
		}
		//商品購入履歴を登録(insert)できなかったらdelete出来ないので
		if(insertcount > 0) {
			CartInfoDAO cartInfoDAO = new CartInfoDAO();
			//削除カウント
			int deletecount = 0;
			//deleteAllメソッド呼び出し、引数にString型のuserIdを渡す、戻り値をdeletcountに入れる
			deletecount = cartInfoDAO.deleteAll((session.get("userId").toString()));
			//delete成功確認
			if(deletecount > 0) {
				//購入履歴登録成功、削除成功でSUCCESSを返す→決済完了画面→3秒後にホーム画面
				result = SUCCESS;
			}
		}
		return result;
	}

	public List<PurchaseHistoryInfoDTO> getPurchaseHistoryInfoDTO() {
		return purchaseHistoryInfoDTO;
	}

	public void setPurchaseHistoryInfoDTO(List<PurchaseHistoryInfoDTO> purchaseHistoryInfoDTO) {
		this.purchaseHistoryInfoDTO = purchaseHistoryInfoDTO;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getDestinationid() {
		return destinationid;
	}

	public void setDestinationid(String destinationid) {
		this.destinationid = destinationid;
	}

}