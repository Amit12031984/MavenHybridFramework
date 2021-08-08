package com.Utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtil {
	
	public static Object[][] readExcel()throws Exception{
	    Object[][] dd = null;
		DataFormatter df = new DataFormatter();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/userid.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		int rows = sh.getLastRowNum();//4
		int col1 = sh.getRow(0).getLastCellNum();
		dd = new Object[rows][col1];
		for(int i=1;i<=rows;i++) {// rows
			int col = sh.getRow(i).getLastCellNum();
			System.out.println("no. of cols in row:"+ i+"are "+col);
			for(int j=0;j<col;j++) {
				Cell c= sh.getRow(i).getCell(j);
				String data = df.formatCellValue(c);
				dd[i-1][j] = data;
			}
		}
		System.out.println(dd);
		return dd;
	}
}
