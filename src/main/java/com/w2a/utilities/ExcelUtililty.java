package com.w2a.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtililty {

	public HashMap<String, String> getTCData(String flName, String shtName, String tcid) throws IOException {
		String flPath = System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\" + flName + ".xlsx";
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
