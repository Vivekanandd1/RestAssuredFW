package API.Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="Data")
	public String[][] getAllData() throws IOException {
		String path = System.getProperty("user.dir")+"//TestData//UserData.xlsx";
		XLUtitlity utility = new XLUtitlity(path);
		int rownum  = utility.getRowCount("Sheet1");
		int colCount = utility.getCellCount("Sheet1", 1);
		String apiData[][] = new String[rownum][colCount];
		for(int i=1;i<=rownum;i++) {
			for(int j=0;j<colCount;j++) {
				apiData[i-1][j] = utility.getCellData("Sheet1", i, j);
			}
		}
		return apiData;	
	}

	
	@DataProvider(name="UserName")
	public String[] getUserName() throws IOException {
		String path = System.getProperty("user.dir")+"//TestData//UserData.xlsx";
		XLUtitlity utility = new XLUtitlity(path);
		int rownum  = utility.getRowCount("Sheet1");
		String apiData[] = new String[rownum];
		for(int i=1;i<=rownum;i++) {
			
				apiData[i-1]= utility.getCellData("Sheet1", i, 1);
			
		}
		return apiData;	
	}

}
