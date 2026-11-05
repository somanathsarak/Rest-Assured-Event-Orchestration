package Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_Properties {
	
	public static String filepath = System.getProperty("user.dir")+ "\\test_data\\test-data.xlsx";
	
	public static String readExcelValue(String filePath, String SheetName, int rowNumber, int ColumnNumber) {
		String value = null;
		try (FileInputStream fis = new FileInputStream(new File (filePath));
				Workbook workbook = new XSSFWorkbook(fis)){
			
			Sheet sheet = workbook.getSheet(SheetName);
			if (sheet == null) throw new IllegalArgumentException("Sheet " +SheetName+ " Not Found");
			
			Row row = sheet.getRow(rowNumber);
			if (row == null) throw new IllegalArgumentException("Row "+rowNumber+" Not Found");
			
			Cell cell = row.getCell(ColumnNumber);
			if (cell == null) throw new IllegalArgumentException("Cell " +ColumnNumber+ " Not Found");
			
			if (cell.getCellType() == CellType.STRING) {
                value= cell.getStringCellValue();
           }
			
		} catch (Exception e) {
			throw new RuntimeException("Error reading the Excel file: " + e.getMessage());
		}
		return value;
	}
	
	public static void writeToExcel(String filePath, String sheetName, int rowNumber, int columnNumber, String value) {
		File file = new File (filePath);
		
		try (FileInputStream fis = new FileInputStream(file);
				Workbook workbook = new XSSFWorkbook(fis)){
			
			Sheet sheet = workbook.getSheet(sheetName);
			if(sheet == null) throw new IllegalArgumentException("Sheet "+sheetName+ " Not Found");
			
			Row row = sheet.getRow(rowNumber);
			if(row == null) {
				row = sheet.createRow(rowNumber);
			}
			
			Cell cell = row.getCell(columnNumber);
			if(cell == null) {
				cell = row.createCell(columnNumber);
			}
			
//			if (value.matches("-?\\d+(\\.\\d+)?")) { // Check if value is numeric
//                cell.setCellValue(Double.parseDouble(value));
//            } else {
//                cell.setCellValue(value); // Set as string otherwise
//            }
			cell.setCellValue(value);
			
			try (FileOutputStream fos = new FileOutputStream(file)){
					workbook.write(fos);
				
			}
			
		} catch (Exception e) {
			throw new RuntimeException("Error reading the Excel file: " + e.getMessage());
		}
	}
}