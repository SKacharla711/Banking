package com.w2a.rough;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Rough {

	public static void main(String[] args) throws IOException {
		String flPath = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\Banking.xlsx";
		HashMap<String, String> tcData = getTCData(flPath, "Add Customer", "Delete Customer");
		System.out.println(tcData);
	}

	public static HashMap<String, String> getTCData(String flPath, String shtName, String tcid) throws IOException {
		File file = new File(flPath);
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet(shtName);
		int rows = sheet.getLastRowNum();
		XSSFRow header = sheet.getRow(0);
		HashMap<String, String> tcData = new HashMap<String, String>();

		for (int r = 1; r <= rows; r++) {
			XSSFRow row = sheet.getRow(r);
			if (row.getCell(0).toString().equalsIgnoreCase(tcid)) {
				int cols = row.getLastCellNum();
				for (int c = 0; c < cols; c++) {
					String keyName = header.getCell(c).toString();
					String kValue = row.getCell(c).toString();
					tcData.put(keyName, kValue);
				}
				break;
			}

		}
		workbook.close();
		return tcData;
	}

}
