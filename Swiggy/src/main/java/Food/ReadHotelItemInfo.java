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

	public class ReadHotelItemInfo {

		String filepath = System.getProperty("user.dir")+"D:\\Excel_Proj\\HotelDetails.xlsx";

		public boolean ReadHotelExist(String SheetName,String HotelName) throws IOException
		{
			// rough work
			/*
			 * File open and open the I/P stream
			 * Navigate to sheet
			 * Get Total used row
			 * Get Total used column
			 * Navigate to the cell using row and column
			 * Get the value from the cell
			 * Close the stream
			 */

			File f = new File(filepath);
			FileInputStream FS = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(FS);
			//HSSFWorkbook workbook = new HSSFWorkbook(FS);

			Sheet sh = workbook.getSheet(SheetName);
			// total tows
			int totalRows = sh.getPhysicalNumberOfRows();
			for(int i=0;i<totalRows;i++)
			{
				Row eachRow = sh.getRow(i);
				//int totalColumns = eachRow.getLastCellNum();
				int totalColumns =1;
				for(int j=0;j<totalColumns;j++)
				{
					Cell eachCell =eachRow.getCell(j);
					if(eachCell!=null)
					{
						String actualValue = ReadDataAsSuch(eachCell).toString();
						if(actualValue.equalsIgnoreCase(HotelName))
						{
							System.out.println(HotelName);
							Cell addressCell =eachRow.getCell(1);
							Cell hotelNameCell =eachRow.getCell(2);
							String hotelNamevalue = ReadDataAsSuch(hotelNameCell).toString();
							String addressvalue = ReadDataAsSuch(addressCell).toString();
							System.out.println("hotelName: "+hotelNamevalue);
							System.out.println("The address : "+addressvalue);
							return true;
						}

						System.out.print(" ");
					}
				}
				//System.out.println("");
			}
			FS.close();
			return false;

		}


		public String ReadItemExist(String SheetName,String ItemName) throws IOException
		{
			/*
			 * File open and open the I/P stream
			 * Navigate to sheet
			 * Get Total used row
			 * Get Total used column
			 * Navigate to the cell using row and column
			 * Get the value from the cell
			 * Close the stream
			 */

			File f = new File(filepath);
			FileInputStream FS = new FileInputStream(f);
			XSSFWorkbook workbook = new XSSFWorkbook(FS);
			//HSSFWorkbook workbook = new HSSFWorkbook(FS);

			Sheet sh = workbook.getSheet(SheetName);
			// total tows
			int totalRows = sh.getPhysicalNumberOfRows();
			for(int i=0;i<totalRows;i++)
			{
				Row eachRow = sh.getRow(i);
				//int totalColumns = eachRow.getLastCellNum();
				int totalColumns =1;
				for(int j=0;j<totalColumns;j++)
				{
					Cell eachCell =eachRow.getCell(j);
					if(eachCell!=null)
					{
						String actualValue = ReadDataAsSuch(eachCell).toString();
						if(actualValue.equalsIgnoreCase(ItemName))
						{
							System.out.println(ItemName);
							Cell priceCell =eachRow.getCell(1);
							//Cell hotelNameCell =eachRow.getCell(2);
							String hotelNamevalue = ReadDataAsSuch(priceCell).toString();
							//String addressvalue = ReadDataAsSuch(addressCell).toString();
							System.out.println("Item Price is: "+hotelNamevalue);
							//System.out.println("The address : "+addressvalue);
							return hotelNamevalue;
						}

						System.out.print(" ");
					}
				}
				//System.out.println("");
			}
			FS.close();
			return null;

		}

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
	


	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadHotelItemInfo k = new ReadHotelItemInfo();
//		k.ReadHotelExist("bismi", "shawarma");
		k.ReadItemExist("bismi","shawarma");
		
	}


	

}
