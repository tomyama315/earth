package com.internousdev.earth.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.CartInfoDAO;
import com.internousdev.earth.dto.CartInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class CartAction extends ActionSupport implements SessionAware {
	private ArrayList<CartInfoDTO> cartlist;
	private Map<String, Object> session;
	private String message;
	private int totalprice;

	public String execute() throws SQLException {
		CartInfoDAO dao = new CartInfoDAO();
		cartlist = dao.getCartContents(session.get("UserId").toString());
		if (!cartlist.isEmpty()) {  //カートが空ではない場合読み込み
			session.put("cartinfo", cartlist);  //To Settlement
			for(CartInfoDTO dto:cartlist){ //合計値の更新
				totalprice+=dto.getSum();
			}
		}else{ //カートが空である場合
			message="カート情報がありません";
		}
		return SUCCESS;

	}
	// getter setter

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

}
