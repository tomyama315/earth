package com.internousdev.earth.util;

public class CommonUtility {
	public String getRamdomValue() {
		String value="";
		double d;
		for(int i=1; i<=16; i++) {
			d=Math.random() * 10;
			value=value+((int)d);
		}
		return value;
	}

	public String concealPassword(String password) {
		int beginIndex = 0;
		int endIndex = 1;
		StringBuilder stringBuilder = new StringBuilder("****************");
		//↑stringbuilderはパスワードを登録後開放
		//  stringは一度格納すると値を変更できないため
		String concealPassword = stringBuilder.replace(beginIndex, endIndex, password.substring(beginIndex,endIndex)).toString();
		return concealPassword;//concealは隠す
	}
}
