package com.internousdev.earth.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.CartInfoDAO;
import com.internousdev.earth.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class DeleteCartAction extends ActionSupport implements SessionAware {
	private ArrayList<CartInfoDTO> cartlist;
	private Map<String, Object> session;
	private String message;
	private int totalprice;
	private int[] ProductId;

	public String execute() throws SQLException {
		int result = 0;
		System.out.println("ID:"+ProductId);
		if (ProductId.length != 0) { //チェックされたものがある場合true
			for (int i : ProductId) {  //配列から取り出して削除
				CartInfoDAO dao = new CartInfoDAO();
				result += dao.delete(session.get("loginuserid").toString(), i); //成功∨失敗の場合判別できない
			}
		}
		if (result == 0) {
			message = "カートから削除できませんでした";
		} else {
			CartInfoDAO initializedao = new CartInfoDAO();
			cartlist = initializedao.getCartContents(session.get("loginuserid").toString());
			if(cartlist.isEmpty()){
				message = "カート情報がありません";
			}
			for (CartInfoDTO dto : cartlist) {
				totalprice += dto.getSum();
			}
		}
		return result == 0 ? ERROR : SUCCESS;
	}

	public ArrayList<CartInfoDTO> getCartlist() {
		return cartlist;
	}

	public void setCartlist(ArrayList<CartInfoDTO> cartlist) {
		this.cartlist = cartlist;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}

	public int[] getProductId() {
		return ProductId;
	}

	public void setProductId(int[] productId) {
		ProductId = productId;
	}

}
