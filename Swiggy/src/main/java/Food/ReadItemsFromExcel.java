package Food;

import java.io.File;




import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet; // use ss not si
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadItemsFromExcel   {
	
	String filePath = "D:\\Excel_Proj\\HotelDetails.xlsx";
	
	public void readData(String hotelName) throws IOException {
		File f = new File(filePath); // exist or not 
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fs); // xlsx  , xls
		Sheet sh = workbook.getSheet("Hotels");
		int totalRows = sh.getPhysicalNumberOfRows();
		for(int i=0;i<totalRows;i++) {
			Row eachRow = sh.getRow(i);
			int totCols = eachRow.getLastCellNum();
			for(int j=0;j<totCols;j++) {
				Cell eachCell = eachRow.getCell(j);
				String actualValue = eachCell.getStringCellValue();
				if(actualValue.equalsIgnoreCase(hotelName)) {
					System.out.println(actualValue+" given hotel available");
//				System.out.print(actualValue+" ");
				}
//			
//			System.out.println();
			}
	}
		// rough work to read data from excel
			
		
//		fs.close();
}
	public static void main(String[] args) throws IOException {
		
		ReadItemsFromExcel obj = new ReadItemsFromExcel();
		obj.readData("A2B");
		// TODO Auto-generated method stub

	}

}
