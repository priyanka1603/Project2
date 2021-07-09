package com.maven1.org;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DatadrivenFramework {

	public static void main(String[] args) throws IOException {

		File file = new File("C:\\Users\\user\\eclipse-workspace\\Maven1\\target\\income-expense-worksheet.xlsx");
		
		FileInputStream fis = new  FileInputStream(file);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet sheetAt = wb.getSheetAt(0);
		
		for (int i = 0; i < sheetAt.getPhysicalNumberOfRows(); i++) {
			
			
			Row row = sheetAt.getRow(i);
			
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				
				Cell cell = row.getCell(j);
				
				CellType cellType = cell.getCellType();
				
				if (cellType.equals(cellType.STRING)) {
					
					
					System.out.println(cell.getStringCellValue());
					
					
					double numeri = cell.getNumericCellValue();
					System.out.println(String.valueOf(numeri));
				}
				
			}
		}
		
		
		
		
	}

}
