package com.demo.SwagLabs.generic;

import java.io.FileInputStream;
import java.util.Properties;

public class ReadDataPropFile {
	
	public String readDataPropFile(String key) throws Throwable
	{
	FileInputStream fis = new FileInputStream(I_AutoConstants.PROFILEPATH);
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
	}
}
