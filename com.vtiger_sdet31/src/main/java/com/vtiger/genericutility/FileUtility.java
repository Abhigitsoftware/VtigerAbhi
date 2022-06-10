package com.vtiger.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Abhishek
 *
 */

public class FileUtility {
 /**
  * its used to read the data from commonData.properties File based on Key which you pass as an argument
  * @param key
 * @param password 
  * @throws Throwable 
  */
	public String getPropertyKeyValue(String key) throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstants.PROPERTYFILE_PATH);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
	}
}
