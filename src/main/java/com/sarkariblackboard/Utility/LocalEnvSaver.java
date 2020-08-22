package com.sarkariblackboard.Utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;

public class LocalEnvSaver {
	private final static Logger LOGGER	= LoggerFactory.getLogger(LocalEnvSaver.class);
	private LocalEnvSaver() {
		
	}
	private static LocalEnvSaver mySingleton = new LocalEnvSaver();
	Map<Long, Object> savedEnvMap = new HashMap<Long, Object>();
	public static void setLocalEnv(Object env) {
		if ((mySingleton.savedEnvMap.get(Thread.currentThread().getId())) != null) {
			throw new NullPointerException();
		}
		mySingleton.savedEnvMap.put(Thread.currentThread().getId(), env);
	}
	public static Object getLocalEnv() {
		if(mySingleton.savedEnvMap.size() > 3) {
			LOGGER.info("is it correct that we have {} saved environments?", mySingleton.savedEnvMap.size());
		}
		return mySingleton.savedEnvMap.get(Thread.currentThread().getId());
	}
	public static void clearLocalEnv() {
		mySingleton.savedEnvMap.remove(Thread.currentThread().getId());
	}
	
	// moved some copy pasted code to here because we reused these methods in more than one class 
	
	public static String getMyName() {
		String myname = getEnvValue("HOSTNAME");
			if ((myname == null) || (myname.trim().length() == 0))
				myname = getEnvValue("HOST");
			if ((myname == null) || (myname.trim().length() == 0))
				myname = getEnvValue("COMPUTERNAME");
			if ((myname == null) || (myname.trim().length() == 0)) {
	    		try {
	    			myname = InetAddress.getLocalHost().getHostName();
	    		} catch (UnknownHostException e) {
	    			myname = Integer.valueOf(new Object().hashCode()).toString();
	    		}
			}
			if ((myname == null) || (myname.trim().length() == 0)) {
				myname = "No Name";
			}
		return myname;
    }
	
	public static String getEnvValue(String envVar) {
    	String result = null;
    	try {
			result = System.getenv(envVar);
    	}
    	catch (Exception e) {
    		result = null;
    	}
    	return result;
    }
}
