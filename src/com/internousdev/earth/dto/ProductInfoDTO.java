package com.internousdev.earth.dto;

import java.util.Date;

public class ProductInfoDTO {

	// ID
	private int id;
	// 商品ID
	private int productId;
	// 商品名
	private String productName;
	// 商品名かな
	private String productNameKana;
	// 商品詳細
	private String productDescription;
	// カテゴリID
	private int categoryId;
	// 価格
	private int price;
	// 画像ファイルパス
	private String imageFilePath;
	// 画像ファイル名
	private String imageFileName;
	// 発売年月
	private Date releaseDate;
	// 発売会社
	private String releaseCompany;
	// ステータス
	private int status;
	// 登録日
	private Date registDate;
	// 更新日
	private Date upDate;

	// ID
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// 商品ID
	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	// 商品名
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	// 商品名かな
	public String getProductNameKana() {
		return productNameKana;
	}

	public void setProductNameKana(String productNameKana) {
		this.productNameKana = productNameKana;
	}

	// 商品詳細
	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	// カテゴリID
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	// 価格
	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	// 画像ファイルパス
	public String getImageFilePath() {
		return imageFilePath;
	}

	public void setImageFilePath(String imageFilePath) {
		this.imageFilePath = imageFilePath;
	}

	// 画像ファイル名
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	// 発売年月
	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	// 発売会社
	public String getReleaseCompany() {
		return releaseCompany;
	}

	public void setReleaseCompany(String releaseCompany) {
		this.releaseCompany = releaseCompany;
	}

	// ステータス
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	// 登録日
	public Date getRegistDate() {
		return registDate;
	}

	public void setRegistDate(Date registDate) {
		this.registDate = registDate;
	}

	// 更新日
	public Date getUpDate() {
		return upDate;
	}

	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}

}
