package com.internousdev.earth.action;

import java.util.ArrayList;

import com.internousdev.earth.dao.ProductInfoDAO;
import com.internousdev.earth.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

	public class ProductListAction extends ActionSupport {
		// 商品一覧
		private ArrayList<ProductInfoDTO> productInfoDTOList = new ArrayList<ProductInfoDTO>();
		// 商品情報
		private ProductInfoDAO productInfoDAO = new ProductInfoDAO();

		public String execute() {
	              productInfoDTOList = productInfoDAO.selectAll();
	                      return SUCCESS;
	            }



	//return productInfoDTOList
		public ArrayList<ProductInfoDTO> getProductInfoDTOList() {
			return productInfoDTOList;
		}

		// productInfoDTOList セット
		public void setProductInfoDTOList(ArrayList<ProductInfoDTO> productInfoDTOList) {
			this.productInfoDTOList = productInfoDTOList;
		}

		// return productInfoDAO
		public ProductInfoDAO getProductInfodao() {
			return productInfoDAO;
		}

		// productInfoDAO セットする
		public void setProductInfodao(ProductInfoDAO productInfodao) {
			this.productInfoDAO = productInfodao;
		}

	}
