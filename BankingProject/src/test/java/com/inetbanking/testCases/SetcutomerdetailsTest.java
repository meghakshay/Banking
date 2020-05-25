package com.inetbanking.testCases;

import java.io.IOException;

import com.inetbanking.utilities.XLutils;

public class SetcutomerdetailsTest {
	static String Data;
	public SetcutomerdetailsTest(String data[])  throws IOException{	
		String Data[] = data;
		String path = System.getProperty("user.dir")+"\\src\\test\\java\\com\\inetbanking\\testData\\customerdetail.xlsx";
		int rowcount = XLutils.getRowCount(path, "Sheet1");
		int colcount = XLutils.getCellCouunt(path, "Sheet1", rowcount);
		XLutils.setCellData(path, "Sheet1",Data);
	}
	public static void main(String[] args){
		
	}
}
