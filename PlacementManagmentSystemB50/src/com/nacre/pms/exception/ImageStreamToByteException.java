/**
 * 
 */
package com.nacre.pms.exception;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author nacre java B50 This class is used to handle the exception of image
 *         Stream to Byte Exception
 */
public class ImageStreamToByteException extends Exception {

	public ImageStreamToByteException(String message) {
		super(message);
	}

	public ImageStreamToByteException(Throwable cause) {
		super(cause);
	}

	public ImageStreamToByteException(String message, Throwable cause) {
		super(message, cause);
	}

	public ImageStreamToByteException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
