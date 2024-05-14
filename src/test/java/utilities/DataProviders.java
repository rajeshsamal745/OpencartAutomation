package utilities;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class DataProviders {
	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\testData\\Opencart_LoginData.xlsx";
		ExcelUtility excelUtil = new ExcelUtility(path);
		int total_rows = excelUtil.getRowCount("Sheet1");
		int total_cells = excelUtil.getCellCount("Sheet1", 1);

		String loginData[][] = new String[total_rows][total_cells];
		for (int i = 1; i <= total_rows; i++) {
			for (int j = 0; j < total_cells; j++) {
				loginData[i - 1][j] = excelUtil.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
	}
}
