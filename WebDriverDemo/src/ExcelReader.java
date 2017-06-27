import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader
{
	public static void main (String [] args){
		ExcelReader objExcelFile = new ExcelReader();
		
		Map map = new HashMap();
		Map orderedMap = new TreeMap();
		Map map1 = new TreeMap();
		Map<Object, List> hashMap1=new TreeMap<Object, List>();
		Map<Object, List> valueHeaderMap = new TreeMap<Object, List>();
		List cellData = new LinkedList();
		List keyMap = new ArrayList();
	    //Prepare the path of excel file
	    //String filePath = System.getProperty("user.dir")+"\\src";

	    //Call read file method of the class to read data
	   // map = objExcelFile.loadExcelLines(new File("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/R8_Orange_TestData.xlsx"));
		//map1 = objExcelFile.loadExcelLine(new File("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/R8_Orange_TestData.xlsx"));
		// Origianl Line - 
		hashMap1 = objExcelFile.loadExcelLine(new File("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/R8_Orange_TestData.xlsx"));
		//hashMap1 = objExcelFile.loadExcelLine(new File("C:/Lakshmi/TestAutomationSelenium/WebDriverDemo/src/GSD_CSC_TestData.xlsx"));
	    //Iterator iterator = map1.keySet().iterator();
	    
	    //Iterator iterator = cellData.iterator();
		Iterator iterator = hashMap1.keySet().iterator();
		
	   /*while (iterator.hasNext()){
	   
		   Object key = iterator.next();
		   System.out.println("key : "+key);
		   Object valueRow= hashMap1.get(key).toString();
		   System.out.println("Value Row:"+valueRow);
	   }*/	   
	    Object header = hashMap1.keySet().toArray()[0];
		//String header = hashMap1.keySet().toArray()[0].toString();
		   List<Object> valueForheader = hashMap1.get(header);
		   //System.out.println("Header :"+header);
		   System.out.println("Value For header :"+valueForheader);
		   List <String> excelHeaderKeysList = new ArrayList<String>();
		   for (int i = 0; i < valueForheader.size(); i++){
			   System.out.println("Header Element : "+valueForheader.toArray()[i].toString());
			   excelHeaderKeysList.add(valueForheader.toArray()[i].toString());
		   }
		  /* Iterator iteratorHeader = excelHeaderKeysList.iterator();
		   while(iteratorHeader.hasNext()){
			   String key = (String) iteratorHeader.next();
			   System.out.println("First row of the excel as list of values :"+key);
			  }*/
		 //Object valueForRow = null;
			List <String> excelValueRowList = null;
			//List <String> excelRow = new ArrayList<String>();
			//for (int j = 1; j< hashMap1.size(); j++){
				Object valuesForRows = hashMap1.keySet().toArray()[1];
				List <Object> valueForRow = hashMap1.get(valuesForRows);
				System.out.println("Value For Row : " +valueForRow);
				
				excelValueRowList = new ArrayList<String>();
				List <String> listOfExcelRows = new ArrayList<String>();
				for (int i = 0; i < valueForRow.size(); i++){
				System.out.println("Row Elements : "+valueForRow.toArray()[i].toString());
					excelValueRowList.add(valueForRow.toArray()[i].toString());
				}
				
				/*listOfExcelRows.addAll(excelValueRowList);
				Iterator listOfExcelRowsItr = listOfExcelRows.iterator();
				while (listOfExcelRowsItr.hasNext()){
					String key = (String) listOfExcelRowsItr.next();
					System.out.println("Value of the Excel Rows : "+key);
				}*/
			//}
		   String firstElementOfHeader = excelHeaderKeysList.get(0);
		   String firstElementOfRow = excelValueRowList.get(0);
		   System.out.println("First Element of the header is :" +firstElementOfHeader);
		   System.out.println("First Element of the row is : "+excelValueRowList.get(0));
		   
		   if (firstElementOfRow.equalsIgnoreCase("yes")){
			   System.out.println("Proceed with Execution");
		   }
		   else if (!firstElementOfRow.equalsIgnoreCase("yes")){
			   System.out.println("Dont Proceed with Execution");
		   }
		   
		   
		   
		   
	    /*while (iterator.hasNext()){
	 	  // for (int i = 1; i <= hashMap1.size(); i++){
			   Object key = iterator.next();
			   System.out.println("key : "+key);
			   Object value = hashMap1.get(key);
			   System.out.println("Value :"+value);
			   for (int i = 0; !hashMap1.isEmpty(); i ++){
			   Object NextValue = hashMap1.keySet().toArray()[i];
			   List<Object> valueForRow = hashMap1.get(NextValue);
			   System.out.println("firstValue : "+NextValue);
			   System.out.println("valueForFirstRow : "+valueForRow);
			   System.out.println(valueForRow.toArray()[0]);
			   }
	 	   //}
		 }*/
	  /* Object header = hashMap1.keySet().toArray()[0];
	   List<Object> valueForheader = hashMap1.get(header);
	   //System.out.println("Header :"+header);
	   System.out.println("Value header :"+valueForheader);
	   System.out.println(valueForheader.toArray()[0]);*/
	   
	   /*for(int i = 1; i <= hashMap1.size(); i++){
	   Object firstValue = hashMap1.keySet().toArray()[i];
	   List<Object> valueForRow = hashMap1.get(firstValue);
	   System.out.println("firstValue : "+firstValue);
	   System.out.println("valueForFirstRow : "+valueForRow);
	   System.out.println(valueForRow.toArray()[0]);
	   //boolean hasYes = valueForFirstRow.contains(valueForFirstRow.get(0));
	   //Boolean hasYes = valueForFirstRow.contains(valueForFirstRow.get(0));
	   //String hasCondition = (Boolean.parseBoolean(hasYes)));
	   
	   
	   if ("yes".equalsIgnoreCase(arg0)){
		   System.out.println("****TRUE****");
	      for(int j = 1; j < hashMap1.size(); j++){
		   getRows(j,hashMap1);
	      }
	   }
	   }*/
	}
	public static void getRows(int rowNum, Map map1){
		//public static void getRows(int rowNum, Map map1){
		Object valueForKey=null;
		Object key = map1.keySet().toArray()[rowNum];
		valueForKey = map1.get(key);
		System.out.println("Key :"+key);
		System.out.println("Value Key :"+valueForKey);
		
	}

	       
	    /*List<Object> valueForheader = hashMap1.get(header);
	    System.out.println("Header :"+header);
	    System.out.println("Value header :"+valueForheader);
	    System.out.println(valueForheader.get(0));
	    //Map<Object, Object> valueHeaderList = new TreeMap<Object, Object>();
	    Object nextRow = getRows(1,hashMap1);
	    System.out.println("nextRow "+nextRow);
	    List<Object> valueForRow = (List<Object>) nextRow;
	    System.out.println("nextRow first value: "+valueForRow.get(0));
	    *///if (valueForRow.get(0).equals("yes"))
	    
	    //System.out.println("Value Exists");
	    
	    //valueHeaderList.put(valueForheader, nextRow);
	    //System.out.println("Value Header List : "+valueHeaderList );
	    //}
		
		/*Object secondKey = map1.keySet().toArray()[1];
	    Object valueForFSecondKey = map1.get(secondKey);
	    System.out.println("Second Key :"+secondKey);
	    System.out.println("Value for Second Key :"+valueForFSecondKey);
	    
	    Object thirdKey = map1.keySet().toArray()[2];
	    Object valueForThirdKey = map1.get(thirdKey);
	    System.out.println("Second Key :"+thirdKey);
	    System.out.println("Value for Second Key :"+valueForThirdKey);*/
	
	
    public static HashMap loadExcelLines(File fileName)
    {
        // Used the LinkedHashMap and LikedList to maintain the order
        HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

        LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();
        

        String sheetName = null;
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            // Get the first sheet on the workbook.
           for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            {
                XSSFSheet sheet = workBook.getSheetAt(i);
                 //XSSFSheet sheet = workBook.getSheetAt(0);
                sheetName = workBook.getSheetName(i);

                Iterator rows = sheet.rowIterator();
                while (rows.hasNext())
                {
                    XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                    List data = new LinkedList();
                    while (cells.hasNext())
                    {
                        XSSFCell cell = (XSSFCell) cells.next();
                        cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(cell);
                    }
                    hashMap.put(row.getRowNum(), data);
                    

                    // sheetData.add(data);
                }
                outerMap.put(sheetName, hashMap);
                hashMap = new LinkedHashMap<Integer, List>();
            }

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

        return outerMap;

    }
    
    //public static HashMap loadExcelLine(File fileName)
    public static HashMap loadExcelLine(File fileName)
    {
        // Used the LinkedHashMap and LikedList to maintain the order
        HashMap<String, LinkedHashMap<Integer, List>> outerMap = new LinkedHashMap<String, LinkedHashMap<Integer, List>>();

        LinkedHashMap<Integer, List> hashMap = new LinkedHashMap<Integer, List>();
        
        Map<Object, List> hashMap1=new TreeMap<Object, List>();
        String sheetName = null;
        List data = new LinkedList();
        List cellData = new LinkedList();
        List cellValues = new ArrayList();
        // Create an ArrayList to store the data read from excel sheet.
        // List sheetData = new ArrayList();
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(fileName);
            // Create an excel workbook from the file system
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
           
            // Get the first sheet on the workbook.
          // for (int i = 0; i < workBook.getNumberOfSheets(); i++)
            //{
                //XSSFSheet sheet = workBook.getSheetAt(i);
                 XSSFSheet sheet = workBook.getSheetAt(2);
                //sheetName = workBook.getSheetName(i);
                sheetName = workBook.getSheetName(2);

                Iterator rows = sheet.rowIterator();
                                
                while (rows.hasNext())
                {
                	
                    
                	XSSFRow row = (XSSFRow) rows.next();
                    Iterator cells = row.cellIterator();

                    data = new LinkedList();
                    cellData = new LinkedList();
                    while (cells.hasNext())
                    {
                        XSSFCell cell = (XSSFCell) cells.next();
                        //cell.setCellType(Cell.CELL_TYPE_STRING);
                        data.add(cell);
                        cellData.add(cell);
                        //System.out.println("Cell : "+cell);
                    }
                    
                    hashMap.put(row.getRowNum(), data);
                    
                    cellValues.add(cellData);
                    //Object headRow = (Object)hashMap1.put(row.getCell(0), data);
                   
                    //hashMap1.put(header, data);
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
        //return cellValues;

    }
   
}