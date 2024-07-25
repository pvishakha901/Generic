package Wrappers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class xlsReadandWrite {

	    public HashMap<String, String> readExcel(String fileName, String sheetName) throws IOException {
	        
	        HashMap<String, String> data = new HashMap<String, String>();

	        File file = new File(fileName);
	        FileInputStream inputStream = new FileInputStream(file);

	        Workbook workbook = new XSSFWorkbook(inputStream);
	        Sheet sheet = workbook.getSheet(sheetName);
	        
	        Iterator<Row> rowIterator = sheet.iterator();
	        
	        while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            
	            // Get key
	            Cell keyCell = row.getCell(0);
	            String key = keyCell.getStringCellValue().trim();
	            
	            // Get value
	            Cell valueCell = row.getCell(1);
	            String value = valueCell.getStringCellValue().trim();
	            
	            data.put(key, value);
	        }
	        
	        //workbook.close();
	        inputStream.close();

	        return data;
	    }
}
