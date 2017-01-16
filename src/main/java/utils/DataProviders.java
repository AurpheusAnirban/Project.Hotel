package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class DataProviders {
	private static XSSFSheet excelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	private static Object[][] getTableArray(String sheetName){
		String[][]tableArray = null;
		
		try{
			File source = new File("Resources/excelFiles/Book3.xlsx");
			FileInputStream fileInput = new FileInputStream(source);
			
			ExcelWBook = new XSSFWorkbook(fileInput);
			excelWSheet = ExcelWBook.getSheet(sheetName);
			
			int startRow = 0;
			int startCol = 0;
			int totalRows = excelWSheet.getLastRowNum()+1;
			int totalCols = excelWSheet.getRow(0).getLastCellNum();
			
			tableArray = new String[totalRows][totalCols];				
				for(int i=startRow;i<totalRows;i++){
					for(int j=startCol;j<totalCols;j++){
						tableArray[i][j]= getCellData(i,j);
					}
				}
				ExcelWBook.close();
			}
		catch(FileNotFoundException e){
			e.getMessage();
			e.printStackTrace();
			System.out.println("couldn't read excel Sheet");
		}
		catch(IOException e){
			e.getMessage();
			e.printStackTrace();
			System.out.println("couldn't read excel Sheet");
		}
		catch(Exception e){
			e.getMessage();
			e.printStackTrace();
		}
		
			return (tableArray);
	}
	
	
	private static String getCellData(int RowNum, int ColNum) throws Exception {
		 
		try{

			Cell = excelWSheet.getRow(RowNum).getCell(ColNum);
				Cell.setCellType(1);
				String cellData = Cell.getStringCellValue();
				System.out.println(cellData);
				return cellData;

			}catch (Exception e){
			System.out.println(e.getMessage());
			throw (e);

			}
		}

	@DataProvider
	public Object[][]test(){
		Object[][] testObArray = getTableArray("Sheet1");
		return (testObArray);
	}
}
	
