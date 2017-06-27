/*

import java.io.*;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xwpf.extractor.XWPFWordExtractor;
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageToDoc 
{
    public static void main(String[] args) throws IOException, InvalidFormatException 
    {
    	FileOutputStream out=null;
    	InputStream pic = null;
    	try{
        XWPFDocument docx = new XWPFDocument();
//        XWPFDocument docx = new XWPFDocument(new FileInputStream("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\screenshot.JPEG"));
        XWPFWordExtractor extractor = new XWPFWordExtractor(docx);
        System.out.println("After new XWPF Doc");
        //System.out.println("File Contents : "+extractor.get);
        XWPFParagraph par = docx.createParagraph();
        System.out.println("After new create Paragraph");
        XWPFRun run = par.createRun();
        System.out.println("create run");
        run.setText("Hello, World. This is my first java generated docx-file. Have fun.");
        run.setFontSize(13);
        System.out.println("after set font size");
        pic = new FileInputStream("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\screenshot.JPEG");
        System.out.println("PIC new FIS");
        byte [] picbytes = IOUtils.toByteArray(pic);
        System.out.println("after Byte array");
        //docx.addPicture(picbytes, Document.PICTURE_TYPE_JPEG);
        docx.addPictureData(picbytes, Document.PICTURE_TYPE_JPEG);
       // run.addPicture(pic, Document.PICTURE_TYPE_JPEG, "3", 0, 0);
        out = new FileOutputStream("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\finallyhurray.doc"); 
        docx.write(out); 
        System.out.println("Write into file");
    	}
    	catch(Exception i){
    		i.printStackTrace();
    	}
    	finally{
        out.close(); 
        pic.close();
    	}
    }}
    
    */
	import java.io.File;
    import java.io.FileInputStream;
    import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;

    import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
    import org.apache.poi.xwpf.usermodel.Document;
    import org.apache.poi.xwpf.usermodel.XWPFDocument;

    
    /*Romesh Soni
    soni.romesh@gmail.com*/
    

    public class ImageToDoc
    {

        public static void main(String []a) throws FileNotFoundException, IOException, InvalidFormatException
        {

            CustomXWPFDocument document = new CustomXWPFDocument(new FileInputStream(new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\finallyhurray.doc")));
            FileOutputStream fos = new FileOutputStream(new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\finallyhurray.doc"));

            String blipId = document.addPictureData(new FileInputStream(new File("C:\\Lakshmi\\TestAutomationSelenium\\WebDriverDemo\\screenshot.JPEG")), Document.PICTURE_TYPE_JPEG);

            System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));

            //System.out.println(document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG));
            document.createPicture(blipId,document.getNextPicNameNumber(Document.PICTURE_TYPE_JPEG), 500, 500);


            document.write(fos);
            fos.flush();
            fos.close();
}
    }
  