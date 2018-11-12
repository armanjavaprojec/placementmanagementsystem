package com.nacre.pms.exception;
/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java
 * This Class is handling DatabaseExceptions
 */
public class DatabaseException  extends Exception{


	private static final long serialVersionUID = 1L;
	
	
	public DatabaseException( String message) {
		
		super(message);
	}

}
