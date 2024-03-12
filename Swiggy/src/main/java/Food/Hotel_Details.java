package Food;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;




public class Hotel_Details {
	
	String filePath = "D:\\Excel_Proj\\HotelDetails.xlsx";
	
	public String readData(String hotelName,String Sheet_name) throws IOException { 
		// handles the  reading of hotel details from an excel file
		File f = new File(filePath); // exist or not 
		FileInputStream fs = new FileInputStream(f);
		XSSFWorkbook workbook = new XSSFWorkbook(fs); // xlsx  , xls
		Sheet sh = workbook.getSheet(Sheet_name);
		int totalRows = sh.getPhysicalNumberOfRows();
		for(int i=0;i<totalRows;i++) {
			Row eachRow = sh.getRow(i);
			int totCols = eachRow.getLastCellNum();
			for(int j=0;j<totCols;j++) {
				Cell eachCell = eachRow.getCell(j);
				String actualValue = eachCell.getStringCellValue();
				if(actualValue.equalsIgnoreCase(hotelName)) {
					System.out.println(actualValue+" hotel available");
					
					return actualValue;
				}
			}
	}
		
			
		
		fs.close();
		return "notExist";
}
	public String readItem(String Item_name, String Sheet_name) throws IOException {
	    File f = new File(filePath); // exist or not 
	    FileInputStream fs = new FileInputStream(f);
	    
	    XSSFWorkbook workbook = new XSSFWorkbook(fs); // xlsx  , xls
	    
	    Sheet sh = workbook.getSheet(Sheet_name);
	    
	    int totalRows = sh.getPhysicalNumberOfRows();
	    
	    for (int i = 0; i < totalRows; i++) {
	    	
	        Row eachRow = sh.getRow(i);
	        
	        int totCols = eachRow.getLastCellNum();
	        
	        for (int j = 0; j < totCols; j++) {
	        	
	            Cell eachCell = eachRow.getCell(j);
	            
	            String actualValue = ReadDataAsSuch(eachCell).toString();
	            
	            if (actualValue.equalsIgnoreCase(Item_name)) {
	            	
	                Cell eachcellPrice = eachRow.getCell(1);
	                
	                System.out.println(actualValue + " item available");
	                
	                String actualPrice = ReadDataAsSuch(eachcellPrice).toString();
	                
	                
	                return actualPrice; // Return the item's price as a String
	            }
	        }
	        
	       
	    }
	    
	   fs.close();
	    return "notExist"; // Return "notExist" if the item is not found // false
	    
	}
	

	
//	public Boolean readItem(String Item_name,String Sheet_name) throws IOException {
//		File f = new File(filePath); // exist or not 
//		FileInputStream fs = new FileInputStream(f);
//		XSSFWorkbook workbook = new XSSFWorkbook(fs); // xlsx  , xls
//		Sheet sh = workbook.getSheet(Sheet_name);
//		int totalRows = sh.getPhysicalNumberOfRows();
//		for(int i=0;i<totalRows;i++) {
//			Row eachRow = sh.getRow(i);
//			int totCols = eachRow.getLastCellNum();
//			for(int j=0;j<totCols;j++) {
//			Cell eachCell = eachRow.getCell(j);
//////				String actualValue = eachCell.getStringCellValue();
//				String actualValue = ReadDataAsSuch(eachCell).toString();
//				if(actualValue.equalsIgnoreCase(Item_name)) {
//					Cell eachcellPrice = eachRow.getCell(1);
//					System.out.println(actualValue+" item available");
//					String actualPrice = ReadDataAsSuch(eachcellPrice).toString();
//					int price = Integer.parseInt(actualPrice);
//					System.out.println("Item price is "+ price);
//					
// 
//
//				}
//
//			}
//	}
//		
//			
//		return false;
//		fs.close();
//}
	
	
	public Object ReadDataAsSuch(Cell cellValue)
	{
		if(cellValue.getCellType()==CellType.STRING)
		{
			return cellValue.getStringCellValue();
		}
		else if(cellValue.getCellType()==CellType.NUMERIC)
		{
			DataFormatter data =  new DataFormatter();
			return data.formatCellValue(cellValue);
			//return cellValue.getNumericCellValue();
		}
		return null;
	}


}
