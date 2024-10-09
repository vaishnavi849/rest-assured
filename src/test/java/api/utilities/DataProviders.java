package api.utilities;


import org.testng.annotations.DataProvider;
public class DataProviders {
	
	@DataProvider(name="AllData")
	public String [][] AllDataProvider()
	{
		String fName = System.getProperty("user.dir")+"C:\\Users\\Acer\\Desktop\\RestAssuredFrameDevelopment\\RestAssuredAutomationFramework\\TestData\\testcasesRest.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
		int ttlcolCnt = ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userData[][] = new String[ttlRowCnt][ttlcolCnt];
		
		for (int rowNo =1; rowNo<ttlRowCnt; rowNo++)
		{
			for (int colNo=0; colNo<ttlcolCnt; colNo++)
			{
				userData[rowNo-1][colNo]= ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, colNo, null);
			}
		}
		return userData;
	}
	
	@DataProvider(name="UserNameData")
	public String[] UserNameDataProvider()
	{
		String fName = System.getProperty("user.dir")+"C:\\Users\\Acer\\Desktop\\RestAssuredFrameDevelopment\\RestAssuredAutomationFramework\\TestData\\testcasesRest.xlsx";
		
		int ttlRowCnt = ReadExcelFile.getRowCount(fName, "Sheet1");
	//	int ttlcolCnt = ReadExcelFile.getColCount(fName, "Sheet1");
		
		String userNameData[] = new String[ttlRowCnt-1];
		
		for (int rowNo =1; rowNo<=ttlRowCnt; rowNo++)
		{
			userNameData[rowNo-1] = ReadExcelFile.getCellValue(fName, "Sheet1", rowNo, 1, null);
			
		}
		return userNameData;
	}
	
	
	
}
