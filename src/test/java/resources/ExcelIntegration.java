package resources;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
public class ExcelIntegration {

	public static void main(String[] args) throws IOException {
		
		List<String> sweepsTestDataList=new ArrayList<>();
		
	FileInputStream fis=new FileInputStream("C:\\Users\\LAM\\Documents\\TestData.xlsx");
	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	
	int sheetCount=wb.getNumberOfSheets();
	
	for(int i=0; i<sheetCount; i++)
	{
		if(wb.getSheetName(i).equalsIgnoreCase("Sweeps"))
		{
			XSSFSheet sheet=wb.getSheetAt(i);
			
			//Identify entire first row to find the TestCase column
			Iterator<Row> rows=sheet.iterator();
			
			Row firstRow=rows.next();
			
			Iterator<Cell> ce=firstRow.cellIterator();
			int index=0;
			int column=0;
			while(ce.hasNext())
			{
				Cell value=ce.next();
				
				if(value.getStringCellValue().equalsIgnoreCase("TestCase"))
				{
				column=index;	
				}
				index++;
			}
			
			//Scan the entire TestCase column identified from above step, to find the Targeted Test Case=Sweep Transfer
			
			while(rows.hasNext())
			{
				Row r=rows.next();
				
				if(r.getCell(column).getStringCellValue().equalsIgnoreCase("Sweep Transfer"))
				{
					Iterator<Cell> cv=r.cellIterator();
					while(cv.hasNext())
					{
						Cell c=cv.next();
						if(c.getCellType()==CellType.STRING)
						{
							sweepsTestDataList.add(c.getStringCellValue());
						}
						else
							sweepsTestDataList.add(NumberToTextConverter.toText(c.getNumericCellValue()));
					}
				}
				
			}
			
		}
	}

	System.out.println(sweepsTestDataList);
		
	}


}
