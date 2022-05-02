package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Constants {

    public static  final String  APP_NAME="FrameworkFinal";

    public static final String PROP_FILE_NAME = "execution.properties";

    public static final String FILE_NOT_FOUND_EXCEPTION_MESSAGE = "The Property file has not been found";
    public static final String CHROME = "Chrome";
    public static final String FIREFOX = "Firefox";

    public static final int TIMEOUT = 15;

    public static final String BROWSER = "browser";

    public static final String  WEBSITE_TO_TEST="websiteUrl";
    public static final String  LOG_FILE= "logFilePath";

    public static final String  USER_DIR="user.dir";

    public static final String  LOG4J2_CONFIG_FILE_NAME="log4j2.configurationFile";

    public static  String  TEST_REPORT_FOLDER= System.getProperty("user.dir") + "/testReport/"+"/"+new SimpleDateFormat("dd_MM_yyyy").format(new Date())+"/";

    public static  String  EXTENT_START_REPORTER= TEST_REPORT_FOLDER + "/"+ APP_NAME + new SimpleDateFormat("yyyyMMddhhmmss").format(new Date())+ ".html";

    public static final String  STARTED= " Started";
    public static final String  COMPLETED= " Completed";
    public static final String  ALL_COMPLETED= "All Tests Completed";

    public static String  DATE_NAME=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

    public static String  IMAGE_NAME=DATE_NAME+ ".png";

    public static final String  HOME_PAGE_ACCESS_SUCCESS="Successfully Accessed Home Page ";
    public static final String  HOME_PAGE_ACCESS_FAIL="Error accessing Home Page ";

    public static final String SEARCH_SUCCESS ="Search Successful for search string ";
    public static final String
            SEARCH_FAIL="Search Failed for search string ";

    public static final String  SEARCH_RESULT_CHECK_SUCCESS="Search result successful for expected count ";
    public static final String  SEARCH_RESULT_CHECK_FAIL="Search Failed for expected count ";

    public static final String  NOT_IMPLEMENTED_SUCCESS="Success Message Not implemented ";
    public static final String  NOT_IMPLEMENTED_FAIL="Fail Message Not implemented  ";

}
