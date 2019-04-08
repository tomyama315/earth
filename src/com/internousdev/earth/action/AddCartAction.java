package com.internousdev.earth.action;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.CartInfoDAO;
import com.internousdev.earth.dto.CartInfoDTO;
import com.internousdev.earth.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class AddCartAction extends ActionSupport implements SessionAware {
	private ArrayList<CartInfoDTO> cartlist;
	private Map<String, Object> session;
	private int IdentifyKey;
	private String message;
	private int totalprice;

	public String execute() throws SQLException {
		ProductInfoDTO productdto = (ProductInfoDTO) session.get("additem");
		CartInfoDAO dao = new CartInfoDAO();
		cartlist = dao.getCartContents(session.get("loginuserid").toString());
		int result = 0;
		if (!cartlist.isEmpty()) { //カートが空ではない場合
			for (CartInfoDTO dto : cartlist) {
				if (productdto.getProductId() == dto.getProductId()) { //詳細画面からの商品IDとカートの商品IDを走査
					CartInfoDAO updatedao = new CartInfoDAO();
					int totalcount = dto.getProductCount() + productdto.getProductCount();
					result = updatedao.update(totalcount, session.get("loginuserid").toString(), dto.getProductId());
					IdentifyKey = 1;  //走査の結果同一値が存在した場合更新（既にカートに存在する商品が追加された場合）
					break;
				}
			}
		}
		if (IdentifyKey == 0) {  //走査の結果IdentifyKeyが更新されなかった場合（同じものをカートに追加していない）
			CartInfoDAO adddao = new CartInfoDAO();
			result = adddao.add(session.get("loginuserid").toString(), productdto);
		}
		if (result == 0) {  //executeUpdate()の結果による分岐
			message = "カートに追加できませんでした";
		} else {
			CartInfoDAO initializedao = new CartInfoDAO();
			cartlist = initializedao.getCartContents(session.get("loginuserid").toString()); //表示するカート内容の更新
			for (CartInfoDTO dto : cartlist) {  //合計金額の更新
				totalprice += dto.getSum();
			}
		}
		return result == 0 ? ERROR : SUCCESS;  //resultが0ならERROR、それ以外ならSUCCESS

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

	public int getIdentifyKey() {
		return IdentifyKey;
	}

	public void setIdentifyKey(int identifyKey) {
		IdentifyKey = identifyKey;
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
