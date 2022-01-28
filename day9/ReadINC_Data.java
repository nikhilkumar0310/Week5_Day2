package assignments.day9;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadINC_Data {
	
	public static String [] [] createINC() throws IOException{
		XSSFWorkbook wbc = new XSSFWorkbook("./data/INC_Creation.xlsx");
		
		//Now need to get into the sheet
		XSSFSheet wsc = wbc.getSheet("CreateINC");
		
		//Now need to get the Row and Cell Counts
		int rowCount = wsc.getLastRowNum();
		System.out.println(rowCount);
		short cellCount = wsc.getRow(0).getLastCellNum();
		System.out.println(cellCount);
		
		String [] [] des = new String[rowCount] [cellCount];
		
		for(int i=1; i<=rowCount; i++) {
			for (int j = 0; j <cellCount ; j++) {
				
				XSSFRow rowINC = wsc.getRow(i); //Getting into the specific Row.
				XSSFCell cellINC = rowINC.getCell(j); //Getting into Specific Cell of the row we went in.
				String description = cellINC.getStringCellValue();
				System.out.println(description);
				des [i-1] [j] = description;
			}
		}
		wbc.close();
		return des;
	}

}
