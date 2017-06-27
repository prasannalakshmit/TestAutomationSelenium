package com.testframework.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.seleniumdriver.gsd.core.logging.Log;

import com.testframework.core.FetchDictionaryObjectHelper;

public class CreateDictionary {
	
	Logger logger = Logger.getLogger(Log.class.getName());
	/**
	 * @param ExcelFileName
	 * @return
	 */
	protected HashMap getDictionaryObject(File excelFileName){
		
			//Using LinkedHashMap and LikedList to maintain the order
	        HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();
	        LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();
	        FetchDictionaryObjectHelper fetchDictionaryObjectHelper = new FetchDictionaryObjectHelper();

	        String sheetName = null;
	        FileInputStream fis = null;
	        
	        try
	        {
	            fis = new FileInputStream(excelFileName);
	            // Create an excel workbook from the file system
	            //logger.log(null, "Excel Object Creation Started....");
	            //System.out.println("Reading Excel sheet.. STARTED");
	            
	            XSSFWorkbook workBook = new XSSFWorkbook(fis);
	           // workBook = fetchDictionaryObjectHelper.checkWorkbookType(excelFileName.toString(), fis);
	            
	            logger.info("Reading Excel sheet.. STARTED");
	            
	            // Get the first sheet on the workbook.
	          // for (int i = 0; i < workBook.getNumberOfSheets(); i++)
	            //{
	                //XSSFSheet sheet = workBook.getSheetAt(i);
	                 XSSFSheet sheet = workBook.getSheetAt(2);
	                //sheetName = workBook.getSheetName(i);
	                sheetName = workBook.getSheetName(2);

	                Iterator rows = sheet.rowIterator();
	                //System.out.println("Iterating through the rows of the excel sheet..");
	                logger.info("Iterating through the rows of the excel sheet..");
	                while (rows.hasNext())
	                {
	                	
	                    
	                	XSSFRow row = (XSSFRow) rows.next();
	                    Iterator cells = row.cellIterator();

	                    //System.out.println("Iterating through the cells of each row..");
	                   // logger.info("Iterating through the cells of each row..");
	                    List data = new LinkedList();
	                    while (cells.hasNext())
	                    {
	                        XSSFCell cell = (XSSFCell) cells.next();
	                        //cell.setCellType(Cell.CELL_TYPE_STRING);
	                        data.add(cell);
	                    }
	                    //System.out.println("Adding the data into HashMap!!");
	                    //logger.info("Adding the data into HashMap!!");
	                    hashMap.put(row.getRowNum(), data);
	                    //System.out.println("Data added to the Hashmap.... Reading Excel COMPLETE...");
	                    
	                    /*for (int i = 0; i < 2; i++){
	                	    
	                	    Object key = hashMap.keySet().toArray()[i];
	                	    Object valueForKey = hashMap.get(key);
	                	    System.out.println("First Key :"+key);
	                	    System.out.println("Value for First Key :"+valueForKey);
	                	    }*/
	                    /*int rowIndex = row.getRowNum();
	                    System.out.println("RowNum : "+row.getRowNum());
		                System.out.println("Data : " +data);*/
	                   //}
	                    
	                      //sheetData.add(data);
	                	}
	                
	                logger.info("Data added to the Hashmap.... Reading Excel COMPLETE...");
	                outerMap.put(sheetName, hashMap);
	                //hashMap = new LinkedHashMap<Integer, List>();
	            //}

	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        }
	        finally
	        {
	            if (fis != null)
	            {
	                try
	                {
	                    fis.close();
	                }
	                catch (IOException e)
	                {
	                    // TODO Auto-generated catch block
	                    e.printStackTrace();
	                }
	            }
	        }

		return hashMap;
	}
}
