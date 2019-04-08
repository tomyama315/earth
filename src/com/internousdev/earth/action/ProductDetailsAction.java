package com.internousdev.earth.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.internousdev.earth.dao.ProductInfoDAO;
import com.internousdev.earth.dto.ProductInfoDTO;
import com.opensymphony.xwork2.ActionSupport;

public class ProductDetailsAction extends ActionSupport implements SessionAware {
	private int productId;
	// private String productName;
	// private String productNameKana;
	// private String imageFilePath;
	// private String imageFileName;
	// private int price;
	// private String releaseCompany;
	// private Date releaseDate;
	// private String productDescription;
	private Map<String, Object> session;
	private List<ProductInfoDTO> selectRelativeList;
	ProductInfoDTO productInfoDTO = new ProductInfoDTO();

	public String execute() {
		if (session.isEmpty()) {
			return "sessionTimeout";
		}

		// 商品情報取得
		// DAO,DTOの実体化
		ProductInfoDAO productInfoDAO = new ProductInfoDAO();
		// selectByProductIdメソッド呼び出し、引数int productId
		// 戻り値をproductInfoDTOに格納
		productInfoDTO = productInfoDAO.selectByProductId(productId);

		// SELECT結果がDTOに格納(set)されるので呼び出し(get)→jspで出来れば無駄なコードは要らない
		// 商品情報ごとに分ける
		// 商品ID
		// productId = productInfoDTO.getProductId();
		// 商品名
		// productName = productInfoDTO.getProductName();
		// 商品名かな
		// productNameKana = productInfoDTO.getProductNameKana();
		// 画像ファイルパス
		// imageFilePath = productInfoDTO.getImageFilePath();
		// 画像ファイル名
		// imageFileName = productInfoDTO.getImageFileName();
		// 価格
		// price = productInfoDTO.getPrice();
		// 発売会社
		// releaseCompany = productInfoDTO.getReleaseCompany();
		// 発売年月
		// releaseDate = productInfoDTO.getReleaseDate();
		// 商品詳細
		// productDescription = productInfoDTO.getProductDescription();

		// 関連情報の取得、引数にint categoryIdを渡す
		// 戻り値をselectRelativeListに格納→jspでiterator
		selectRelativeList = productInfoDAO.selectRelative(productInfoDTO.getCategoryId());

		return SUCCESS;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	// public String getProductName() {
	// return productName;
	// }
	//
	// public void setProductName(String productName) {
	// this.productName = productName;
	// }
	//
	// public String getProductNameKana() {
	// return productNameKana;
	// }
	//
	// public void setProductNameKana(String productNameKana) {
	// this.productNameKana = productNameKana;
	// }
	//
	// public String getImageFilePath() {
	// return imageFilePath;
	// }
	//
	// public void setImageFilePath(String imageFilePath) {
	// this.imageFilePath = imageFilePath;
	// }
	//
	// public String getImageFileName() {
	// return imageFileName;
	// }
	//
	// public void setImageFileName(String imageFileName) {
	// this.imageFileName = imageFileName;
	// }
	//
	// public int getPrice() {
	// return price;
	// }
	//
	// public void setPrice(int price) {
	// this.price = price;
	// }
	//
	// public String getReleaseCompany() {
	// return releaseCompany;
	// }
	//
	// public void setReleaseCompany(String releaseCompany) {
	// this.releaseCompany = releaseCompany;
	// }
	//
	// public Date getReleaseDate() {
	// return releaseDate;
	// }
	//
	// public void setReleaseDate(Date releaseDate) {
	// this.releaseDate = releaseDate;
	// }
	//
	// public String getProductDescription() {
	// return productDescription;
	// }
	//
	// public void setProductDescription(String productDescription) {
	// this.productDescription = productDescription;
	// }

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public List<ProductInfoDTO> getSelectRelativeList() {
		return selectRelativeList;
	}

	public void setSelectRelativeList(List<ProductInfoDTO> selectRelativeList) {
		this.selectRelativeList = selectRelativeList;
	}

	public ProductInfoDTO getProductInfoDTO() {
		return productInfoDTO;
	}

	public void setProductInfoDTO(ProductInfoDTO productInfoDTO) {
		this.productInfoDTO = productInfoDTO;
	}


}
