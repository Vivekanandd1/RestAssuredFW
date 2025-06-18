package API.Utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
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
	

}
