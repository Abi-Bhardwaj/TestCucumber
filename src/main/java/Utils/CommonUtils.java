package Utils;

import static Helper.Constants.*;
import static Helper.BaseObejcts.*;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.util.Random;
import org.junit.Assert;
import Helper.BaseObejcts;

/**
 * This class contains methods related to random data, date, time, directory & assert verification.
 * Each method of class is static method.
 * @author $@ndy
 * @since 04-Nov-2021
 * @version $@1.0
 * @category Util
 */

public class CommonUtils {
    static boolean verify = false;
    static Random random;
    static int randomNo = 0, noOfLength = 0;
    static String strRandomNo = null, strRandomValue = null;
    
    /**
     * This method for generate a random number with give length and return in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {int} howManyDigit - digit to generate deserver length of random number
     * @return {String} strRandomNo - return generated random no in string
     */
    public static String RandomNo(int howManyDigit) {
    	random = new Random();
    	switch (howManyDigit) {
		case 1:
			randomNo = 1 + (int)(random.nextFloat() * 8);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 2:
			randomNo = 10 + (int)(random.nextFloat() * 89);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 3:
			randomNo = 100 + (int)(random.nextFloat() * 899);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 4:
            randomNo = 1000 + (int)(random.nextFloat() * 8999);
            strRandomNo = Integer.toString(randomNo);
            break;
			
		case 5:
			randomNo = 10000 + (int)(random.nextFloat() * 89990);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 6:
			randomNo = 100000 + (int)(random.nextFloat() * 899900);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 7:
			randomNo = 1000000 + (int)(random.nextFloat() * 8999000);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 8:
			randomNo = 10000000 + (int)(random.nextFloat() * 89990000);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 9:
			randomNo = 100000000 + (int)(random.nextFloat() * 899900000);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		case 10:
			randomNo = 1000000000 + (int)(random.nextFloat() * 1147483600);
			strRandomNo = Integer.toString(randomNo);
			break;
			
		default:
			int q = howManyDigit/10, r = howManyDigit%10;
			strRandomNo = RandomNo(10);
			for (int i = 1; i < q; i++) {
				strRandomNo = strRandomNo + RandomNo(10);
			}
			strRandomNo = strRandomNo + RandomNo(r);
			break;
		}
        return strRandomNo;
    }
    
    /**
     * This method for generate a random value with give text & length and return in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} text - text which u want to add in random value
     * @param {int} length - length to generate deserver random value
     * @return {String} strRandomNo - return generated random value in string
     */
    public static String RandomValue(String text, int length) {
    	noOfLength = length - text.length();
        strRandomValue = text + RandomNo(noOfLength);
        return strRandomValue;
    }

    /**
     * This method for generate a current date in "dd-MM-yyyy" format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @return {String} dtReturn - return generated current date in "dd-MM-yyyy" format in string
     */
    public static String CurrentDate() {
        SimpleDateFormat dtFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar dtCalender = Calendar.getInstance();
        String dtReturn = dtFormat.format(dtCalender.getTime());
        return dtReturn;
    }
    
    /**
     * This method for generate a current date in given format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} Format - format generate a date format 
     * @return {String} dtReturn - return generated current date in given format in string
     */
    public static String CurrentDate(String Format) {
        SimpleDateFormat dtFormat = new SimpleDateFormat(Format);
        Calendar dtCalender = Calendar.getInstance();
        String dtReturn = dtFormat.format(dtCalender.getTime());
 
        return dtReturn;
    }
    
    /**
     * This method for generate a current date time in "dd MMM yyyy HH:mm:ss" format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @return {String} dtReturn - return generated current date in "dd MMM yyyy HH:mm:ss" format in string
     */
    public static String CurrentDateTime() {
        SimpleDateFormat dtFormat = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        Calendar dtCalender = Calendar.getInstance();
        String dtReturn = dtFormat.format(dtCalender.getTime());

        return dtReturn;
    }
    
    /**
     * This method for generate a specific date from the current date with given days in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {int} days - from current date how many days after or before date, for previous date from current date pass the value with '-' 
     * @return {String} dtReturn - return generated specific date from the current date with given days in string
     */
    public static String SpecificDate(int days) throws Throwable {
        SimpleDateFormat dtFormat = new SimpleDateFormat("dd-MM-yyyy");
        Calendar dtCalender = Calendar.getInstance();
        dtCalender.add(Calendar.DAY_OF_MONTH,days);
        String dtReturn = dtFormat.format(dtCalender.getTime());

        return dtReturn;
    }
    
    /**
     * This method for generate a specific date from the current date with given days & format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} Format - format generate a date format 
     * @param {int} days - from current date how many days after or before date, for previous date from current date pass the value with '-' 
     * @return {String} dtReturn - return generated specific date from the current date with given days & format in string
     */
    public static String SpecificDate(String Format, int days) throws Throwable {
        SimpleDateFormat dtFormat = new SimpleDateFormat(Format);
        Calendar dtCalender = Calendar.getInstance();
        dtCalender.add(Calendar.DAY_OF_MONTH,days);
        String dtReturn = dtFormat.format(dtCalender.getTime());
        return dtReturn;
    }

    /**
     * This method for generate a specific date from the given date with given days & format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} date - 
     * @param {String} Format - format generate a date format 
     * @param {int} days - from given date how many days after or before date, for previous date from given date pass the value with '-' 
     * @return {String} dtReturn - return generated specific date from the given date with given days & format in string
     */
    public static String SpecificDate(String date, String Format, int days) throws Throwable {
        SimpleDateFormat dtFormat=new SimpleDateFormat(Format);
        Calendar dtCalender=Calendar.getInstance();
        dtCalender.setTime(dtFormat.parse(date));
        dtCalender.add(Calendar.DAY_OF_MONTH,days);
        String dtReturn=dtFormat.format(dtCalender.getTime());
        return dtReturn;
    }
    
    /**
     * This method for generate a current time in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @return {String} dtReturn - return generated current time in given format in string
     */
    public static String CurrentTime() {
        SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar dtCalender = Calendar.getInstance();
        String  dtReturn=dtFormat.format(dtCalender.getTime());

        return dtReturn;
    }
    
    /**
     * This method for generate a specific time from the current time with given  minute & format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {int} mintues - from current time how many minute after or before time, for previous time from current time pass the value with '-' 
     * @return {String} dtReturn - return generated specific time from the current time with given minutes & format in string
     */
    public static String SpecificTime(int mintues) throws Throwable {
        SimpleDateFormat dtFormat = new SimpleDateFormat("HH:mm:ss");
        Calendar dtCalender = Calendar.getInstance();
        dtCalender.add(Calendar.DAY_OF_MONTH,mintues);
        String dtReturn=dtFormat.format(dtCalender.getTime());

        return dtReturn;
    }
    
    /**
     * This method for generate a current date with given format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} Format - format generate a time format 
     * @return {String} dtReturn - return generated current date with given format in string
     */
    public static String CurrentTime(String format) {
        SimpleDateFormat dtFormat = new SimpleDateFormat(format);
        Calendar dtCalender = Calendar.getInstance();
        String dtReturn=dtFormat.format(dtCalender.getTime());

        return dtReturn;
    }
    
    /**
     * This method for generate a specific time from the current time with given  minute & format in string.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} Format - format generate a date format 
     * @param {int} mintues - from current time how many minute after or before time, for previous time from current time pass the value with '-' 
     * @return {String} dtReturn - return generated specific time from the current time with given minutes & format in string
     */
    public static String SpecificTime(String format, int mintues) throws Throwable {
        SimpleDateFormat dtFormat = new SimpleDateFormat(format);
        Calendar dtCalender = Calendar.getInstance();
        dtCalender.add(Calendar.DAY_OF_MONTH,mintues);
        String dtReturn=dtFormat.format(dtCalender.getTime());

        return dtReturn;
    }
    
    /**
     * This method to find out difference between to time and return the value in string in minutes
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} time1 - time 1 to find the difference
     * @param {String} time2 - time 2 to find the difference
     * @return {String} dtReturn - return difference between to time and return the value in string in minutes
     */
    public static String TimeDiff(String time1, String time2) throws Throwable {
        String[] startTime = time1.split(" ");
        time1 = startTime[3];
        String[] endTime = time2.split(" ");
        time2 = endTime[3];
        SimpleDateFormat dtFormat=new SimpleDateFormat("HH:mm:ss");
        Date d1=dtFormat.parse(time1);
        Date d2=dtFormat.parse(time2);
        long diff=d2.getTime()-d1.getTime();
        String dtReturn= String.format("%02d:%02d:%02d",(diff/(60 * 60 * 1000) % 24),(diff/(60 * 1000) % 60),(diff/1000 % 60));
        return dtReturn;
    }

    /**
     * This method to check file exists in the current system directory using given path
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} filePath - file path which to check exists or not
     * @return {boolean} iExists - return file exists in the current system directory using given path or not in true or false
     */
    public static boolean isFileExists(String filePath) {
        File tmpDir = new File(filePath);
        boolean iExists = tmpDir.exists();
        return iExists;
    }

    /**
     * This method create a folder at given path with given name and return the created folder path in string 
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} FolderPath - folder path where want to create new folder
     * @param {String} FolderName - folder name which given to create new folder
     * @return {boolean} iExists - return the created folder path in string 
     */
    public static String CreateFolder(String FolderPath, String FolderName) throws Throwable {
        String CreatedFolderPath = null;
        try {
            CreatedFolderPath = FolderPath+FolderName+"\\";
            boolean exists = isFileExists(CreatedFolderPath);
            if (exists != true) {
                File f2 = new File(CreatedFolderPath);
                f2.mkdir();
                if(f2.exists()==true)
                	System.out.println("Folder is sucessfully created.");
                else
                	System.out.println("Folder is not created.");
            }
            else {
                System.out.println("Folder is already is exists.");
            }
            File f1 = new File(CreatedFolderPath);
            f1.listFiles();
        }
        catch (Exception e) {
        	printException(e, "Unable to create folder");
        }

        return CreatedFolderPath;
    }

    /**
     * This method cpoy the file from given file path and paste in given folder path and return it successfully done or not in true or false
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} SourceFile - file path to copy the file
     * @param {String} DestinationFolder - folder path to paste the file
     * @return {boolean} iExists - return it successfully done or not in true or false 
     */
    public static boolean CopyFile(String SourceFile, String DestinationFolder) throws Throwable {
        Path sourceDirectory = null, targetDirectory = null;
        boolean Copied = true;
        try {
            sourceDirectory = Paths.get(SourceFile);
            targetDirectory = Paths.get(DestinationFolder);
            Files.copy(sourceDirectory, targetDirectory);
            Copied = true;
        }
        catch (Exception e) {
            Copied = false;
            printException(e, "Unable Copy File");
        }
        return Copied;
    }
    
    /**
     * This method move the file from given file path and paste in given folder path and return it successfully done or not in true or false
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} SourceFile - file path to cut the file
     * @param {String} DestinationFolder - folder path to paste the file
     * @return {boolean} iExists - return it successfully done or not in true or false 
     */
    public static boolean MoveFile(String SourceFile, String DestinationFolder) throws Throwable {
        Path sourceDirectory = null, targetDirectory = null;
        boolean Moved = true;
        try {
            sourceDirectory = Paths.get(SourceFile);
            targetDirectory = Paths.get(DestinationFolder);
            Files.move(sourceDirectory, targetDirectory);
            Moved = true;
        }
        catch (Exception e) {
            Moved = false;
            printException(e, "Unable Move File");
        }
        return Moved;
    }
    
    /**
     * This method initialize the properties object and load the properties file all keys in the properties object of {@link BaseObejcts} class
     * @author $@ndy
     * @since 04-Nov-2021
     * @return void
     */
    public static void initProperites() throws Throwable
    {
        file = new File(ConfigKeysFile);
        fis = new FileInputStream(file);
        pf = new Properties();
        pf.load(fis);
    }
    
    /**
     * This method assertTrue or assertFalse on given verify base to given true or false.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {boolean} verify - verify value in true or false which set as parameter in the assertTrue or assertFalse
     * @param {boolean} TrueOrFalse - it is value in true or false which decide which assert should be apply, for true - assertTrue & for false - assertFalse
     * @return void
     */
    public static void Verify(boolean verify, boolean TrueOrFalse) {
    	System.out.println(verify);
        if (TrueOrFalse == true)
        	Assert.assertTrue(verify);
        else
        	Assert.assertFalse(verify);
    }
    
    /**
     * This method assertTrue or assertFalse on given verify base to given true or false and set a message if assertion fails
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {boolean} verify - verify value in true or false which set as parameter in the assertTrue or assertFalse
     * @param {boolean} TrueOrFalse - it is value in true or false which decide which assert should be apply, for true - assertTrue & for false - assertFalse
     * @param {String} msg - message which get displayed in the report if scenario is fail with assertion exception
     * @return void
     */
    public static void Verify(boolean verify, boolean TrueOrFalse, String msg) {
    	System.out.println(verify);
        if (TrueOrFalse == true)
        	Assert.assertTrue(msg, verify);
        else
        	Assert.assertFalse(msg, verify);
    }
    
    /**
     * This method assertEquals or assertNotEquals on given two value base to given true or false.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} value1 - value 1 for assertEquals or assertNotEquals
     * @param {String} value2 - value 2 for assertEquals or assertNotEquals
     * @param {boolean} TrueOrFalse - it is value in true or false which decide which assert should be apply, for true - assertEquals & for false - assertNotEquals
     * @return void
     */
    public static void Verify(String value1, String value2, boolean TrueOrFalse) {
        if (TrueOrFalse == true)
        	Assert.assertEquals(value1, value2);
        else
        	Assert.assertNotEquals(value1, value2);
    }
    
    /**
     * This method assertEquals or assertNotEquals on given two value base to given true or false and set a message if assertion fails.
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {String} value1 - value 1 for assertEquals or assertNotEquals
     * @param {String} value2 - value 2 for assertEquals or assertNotEquals
     * @param {boolean} TrueOrFalse - it is value in true or false which decide which assert should be apply, for true - assertEquals & for false - assertNotEquals
     * @param {String} msg - message which get displayed in the report if scenario is fail with assertion exception
     * @return void
     */
    public static void Verify(String value1, String value2, boolean TrueOrFalse, String message) {
        if (TrueOrFalse == true)
        	Assert.assertEquals(message, value1, value2);
        else
        	Assert.assertNotEquals(message, value1, value2);
    }
    
    /**
     * This method print a exception details in console with some specific format
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {Exception} e - exception which want print in console
     * @return void
     */
    public static void printException(Exception e) {
    	System.err.println("----------------------------------------------------------------------");
    	e.printStackTrace();
        System.err.println("----------------------------------------------------------------------");
    }
    
    /**
     * This method print a exception details in console with some specific format & given message
     * @author $@ndy
     * @since 04-Nov-2021
     * @param {Exception} e - exception which want print in console
     * @param {String} message - message which wnat print with exception
     * @return void
     */
    public static void printException(Exception e, String message) {
    	System.err.println("-----------------------"+message+"----------------------------");
        e.printStackTrace();
        System.err.println("----------------------------------------------------------------------");
    }
    
    
    
}
