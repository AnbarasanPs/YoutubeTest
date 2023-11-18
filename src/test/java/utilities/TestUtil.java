package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import baseClass.BaseClass;

public class TestUtil extends BaseClass{
	 private Properties prop;

	    public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException {
	        String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	        TakesScreenshot ts = (TakesScreenshot) driver;
	        File source = ts.getScreenshotAs(OutputType.FILE);
	        // after execution, you could see a folder "FailedTestsScreenshots" under src folder
	        String destination = System.getProperty("user.dir") + "/FailedTestsScreenshots/" + screenshotName + dateName
	                + ".png";
	        File finalDestination = new File(destination);
	        FileUtils.copyFile(source, finalDestination);
	        return destination;
	    }

	    public Properties init_Properties(){
	        prop = new Properties();
	        try {
	            FileInputStream inputStream=new FileInputStream("./src/test/resources/config.properties");
	            prop.load(inputStream);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        return prop;
	    }

	    public void update_Properties(String fileName, String key, String value){
	        prop = new Properties();
	        try {
	            FileInputStream inputStream=new FileInputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
	            prop.load(inputStream);
	            inputStream.close();
	            FileOutputStream outputStream = new FileOutputStream("./src/test/resources/propertyFiles/"+ fileName +".properties");
	            prop.setProperty(key,value);
	            prop.store(outputStream,"Property file has been updated : "+key+" updated");
	            outputStream.close();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	    public  static void saveTextToFile(By element_by,WebDriver driver) {
	        try {
	            // Find the element containing the text
	            WebElement textElement = driver.findElement(element_by);
	            // Extract the text
	            String text = textElement.getText(); 
	          String location=System.getProperty("user.dir")+"\\SavedSecretkeys\\secretkey.txt";
	            FileWriter writer=new FileWriter(location,true);
	            writer.write(text);
	            writer.write(System.lineSeparator()); 
	            writer.close();
	            System.out.println("Text saved to file successfully!");
	        } catch (IOException e) {
	            System.err.println("Error writing to file: " + e.getMessage());
	        }
	 }
	    
	    public static void writeExcel(String text1,String text2,String usermail,String mtoName,WebDriver driver) throws IOException {
	    
	    	  
	        String excelFilePath = System.getProperty("user.dir")+"\\Key.xlsx";
	        String sheetName = "sheet3";
	        
	            FileInputStream file = new FileInputStream(new File(excelFilePath));
	            Workbook workbook = new XSSFWorkbook(file);
	             Sheet sheet = workbook.getSheet(sheetName);
	              int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                  Row createRow = sheet.createRow(physicalNumberOfRows);

                  // Create a new cell at the first unused index
                  createRow.createCell(0).setCellValue(usermail);
                  createRow.createCell(1).setCellValue(mtoName);
                  createRow.createCell(2).setCellValue(text1);
                  createRow.createCell(3).setCellValue(text2);
                 
	            // Write the workbook to the Excel file
	             FileOutputStream fos = new FileOutputStream(excelFilePath);
	             workbook.write(fos);
	             fos.close();
	             // Close the workbook
	             workbook.close();
	    }
	    
	        public static String readExcel() throws IOException {
	          
	            String excelFilePath =System.getProperty("user.dir")+"\\Key.xlsx";
	            String sheetName = "sheet3";
	            String secretkey1 = null;

	                FileInputStream file = new FileInputStream(excelFilePath);
	                Workbook workbook = new XSSFWorkbook(file);
	                Sheet sheet = workbook.getSheet(sheetName);

	                // Get the number of rows in the sheet
	                int rowCount = sheet.getLastRowNum();

	                // Iterate over each row
	                for (int i = 1; i <= rowCount; i++) {
	                    Row row = sheet.getRow(i);
	                    
	                    // Read data from the Excel cells
	                    secretkey1 = row.getCell(2).getStringCellValue();
	                    return secretkey1;
	                }

	                // Save the changes to the Excel file (optional)
	                FileOutputStream fos = new FileOutputStream(excelFilePath);
	                workbook.write(fos);
	                fos.close();

	                // Close the workbook and input stream
	                workbook.close();
	                file.close();
					return secretkey1;
	            
	        }

	    

    public static String readExcelWithGivenCellValue() throws IOException {
    	 
        String excelFilePath =System.getProperty("user.dir")+"\\Key.xlsx";
        String sheetName = "sheet3";
        String secretkey1 = null;
      
            FileInputStream fileInputStream = new FileInputStream(excelFilePath);
            Workbook workbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = workbook.getSheet(sheetName);

            // Manually given column index and cell value to search
            int searchColumnIndex = 0;  
            String searchValue =null;  // Example: Cell value to search
            for (Row row : sheet) {
                Cell cell = row.getCell(searchColumnIndex);
                if (cell != null) {
                    String cellValue = cell.getStringCellValue();
                    if (cellValue.equals(searchValue)) {
                        // Match found, retrieve the entire row data
                    	 secretkey1 = row.getCell(2).getStringCellValue();
                        
                    }
                }
            }

            workbook.close();
            fileInputStream.close();
			return secretkey1;
        
    }
}

	    
	    
	    
	    
	    
            
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    


