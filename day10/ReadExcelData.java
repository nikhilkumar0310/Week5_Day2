package assignments.day10;

import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	
	public static String[][] readCreate() throws IOException {
		
		//Set the Path for the Excel Work book so that we can go there and open the workbook
		XSSFWorkbook wb = new XSSFWorkbook("./data/CreateLead.xlsx");
		
		//Get into the Specific Sheet in the given Workbook
		XSSFSheet ws = wb.getSheet("LeadDetails");
		
		int rowCount = ws.getLastRowNum(); //getLast row number excludes the Header Automatically so Header Row is not taken into count.
		
		short cellCount = ws.getRow(0).getLastCellNum(); //Here first we used the Header Row to get the Cell Count coz Header won't change
		
		System.out.println(cellCount);
		System.out.println(rowCount);
		
		String [] []  createData = new String [rowCount] [cellCount];
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j <cellCount; j++) {
				
			
			XSSFRow row = ws.getRow(i);
		//Now getting into the specific row in the sheet excluding HEADER that is why we put "1", in Index.
		//XSSFRow row = ws.getRow(1);
		
		
		//One in the specific Row we now need to get into the specific column of that Row
		XSSFCell cell = row.getCell(j);
		
		//We have pointed our control to the Cell from which we need the Data so now we have to RETRIVE the data from the Cell.
		String allName = cell.getStringCellValue();
		System.out.println(allName);
		createData [i-1] [j] = allName;
		}
		}
		wb.close();
		return createData;

	}

}
