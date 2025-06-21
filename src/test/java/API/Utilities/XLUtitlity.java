package API.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Color;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtitlity {
	FileInputStream fi;
	FileOutputStream fo;
	XSSFWorkbook Wrkbk;
	XSSFSheet Xsheet;
	XSSFRow  Xrow;
	XSSFCell Xcell;
	CellStyle cstyle;
	String path;
	
	XLUtitlity(String path){
		this.path = path;
	}
	
	public int getRowCount(String sheetname) throws IOException {
		fi = new FileInputStream(path);
		Wrkbk = new XSSFWorkbook(fi);
		Xsheet = Wrkbk.getSheet(sheetname);
		int rowcount = Xsheet.getLastRowNum();
		Wrkbk.close();
		fi.close();
		
		return rowcount;
	}
	
	public int getCellCount(String sheetname,int rownum) throws IOException {
		fi = new FileInputStream(path);
		Wrkbk = new XSSFWorkbook(fi);
		Xsheet = Wrkbk.getSheet(sheetname);
		Xrow  = Xsheet.getRow(rownum);
		int cellcount = Xrow.getLastCellNum();
		Wrkbk.close();
		fi.close();
		
		return cellcount;
	}
	
	public String getCellData(String sheetname,int rownum,int column) throws IOException {
		fi = new FileInputStream(path);
		Wrkbk = new XSSFWorkbook(fi);
		Xsheet = Wrkbk.getSheet(sheetname);
		Xrow  = Xsheet.getRow(rownum);
		Xcell = Xrow.getCell(column);
		DataFormatter formatter = new DataFormatter();
		String data;
		try {
			data = formatter.formatCellValue(Xcell);
		}
		catch (Exception e) {
			data="";
		}
		
		Wrkbk.close();
		fi.close();
		
		return data;
	}
	
	public void SetCellData(String sheetname,int rownum,int column,String data) throws IOException {
		File file = new File(path);
		if(!file.exists()) {
			Wrkbk = new XSSFWorkbook(fi);
			fo = new FileOutputStream(path);
			Wrkbk.write(fo);			
		}
		
		fi = new FileInputStream(path);
		Wrkbk = new XSSFWorkbook(fi);
		if(Wrkbk.getSheetIndex(sheetname)==-1)
			Wrkbk.createSheet(sheetname);	
		Xsheet = Wrkbk.getSheet(sheetname);
		
		if(Xsheet.getRow(rownum)==null)
			Xsheet.createRow(rownum);
		Xrow = Xsheet.getRow(rownum);
		
		Xcell = Xrow.createCell(column);
		Xcell.setCellValue(data);
		fo = new FileOutputStream(path);
		Wrkbk.write(fo);
		Wrkbk.close();
		fi.close();
		fo.close();
	}
	
	public void fillGreenColor(String sheetname,int rownum,int column) throws IOException {
		fi = new FileInputStream(path);
		Wrkbk = new XSSFWorkbook(fi);
		Xsheet = Wrkbk.getSheet(sheetname);
		Xrow = Xsheet.getRow(rownum);
		Xcell = Xrow.getCell(column);
		cstyle = Wrkbk.createCellStyle();
		
		cstyle.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		cstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
	   Xcell.setCellStyle(cstyle);
	   Wrkbk.write(fo);
	   fi.close();
	   fo.close();
	}
	
	public void fillRedColor(String sheetname,int rownum,int column) throws IOException {
		fi = new FileInputStream(path);
		Wrkbk = new XSSFWorkbook(fi);
		Xsheet = Wrkbk.getSheet(sheetname);
		Xrow = Xsheet.getRow(rownum);
		Xcell = Xrow.getCell(column);
		cstyle = Wrkbk.createCellStyle();
		
		cstyle.setFillForegroundColor(IndexedColors.RED.getIndex());
		cstyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
	   Xcell.setCellStyle(cstyle);
	   Wrkbk.write(fo);
	   fi.close();
	   fo.close();
	}
			
			

		
		
	}


