package com.inetBanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {
	String path = null;
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public FileOutputStream fo;
	public CellStyle style;
	
	
	public int getRowCount(String xlfile, String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		int rowCount = sheet.getLastRowNum();
		workbook.close();
		fi.close();
		return rowCount;
	}
	public int getCellCount(String xlfile, String xlsheet, int rowNum) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		workbook.close();
		fi.close();
		return cellCount;
	}
	public String getCellData(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(cell);//Returns the formatted value of a cell as a string regardless of the cell type.
		}
		catch(Exception e)
		{
			data = "";
		}
		workbook.close();
		fi.close();
		return data;
	}
	public void setCellData(String xlfile, String xlsheet, int rowNum, int colNum, String data) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		fo = new FileOutputStream(xlfile);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	public void fillGreenColor(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		
		style = workbook.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}
	public void fillRedColor(String xlfile, String xlsheet, int rowNum, int colNum) throws IOException {
		fi = new FileInputStream(xlfile);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(xlsheet);
		row = sheet.getRow(rowNum);
		cell = row.getCell(colNum);
		style = workbook.createCellStyle();
		
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

}
