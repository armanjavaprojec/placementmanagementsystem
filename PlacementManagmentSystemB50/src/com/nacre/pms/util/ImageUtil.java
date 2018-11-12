package com.nacre.pms.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.codec.binary.Base64;

import com.nacre.pms.exception.ImageStreamToByteException;

/**
 * @author Chandu
 * @version 1.0.0 2018
 * @author Nacre Java B50
 * This class is used for encryption and Decryption
 */
public class ImageUtil {
	/**
	 * Encodes the byte array into base64 string
	 * @param imageByteArray - byte array
	 * @return String a {@link java.lang.String}
	 */
	public static String encodeImage(byte[] imageByteArray) {
	    return "data:image/png;base64,"+Base64.encodeBase64URLSafeString(imageByteArray);
	
	}
	/**
	 * Encodes the byte array into base64 string
	 *It USES POI JAR IOUTILS CLASS TO GET BYTES
	 * @param imageByteArray - byte array
	 * @return String a {@link java.lang.String}
	 * @throws ImageStreamToByteException 
	 */
	public static String encodeImage(InputStream is) throws ImageStreamToByteException {
		
		try {
			byte [] bytes = new byte[is.available()];
			while (is.available()>0) {
				is.read(bytes, 0, is.available());
			}
			return "data:image/png;base64,"+Base64.encodeBase64String(bytes);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new com.nacre.pms.exception.ImageStreamToByteException("CONVERTION ERR :"+e.getMessage());
		}
	}

	/**
	 * Decodes the base64 string into byte array
	 * @param imageDataString - a {@link java.lang.String}
	 * @return byte array
	 */
	public static byte[] decodeImage(String imageDataString) {
		String [] str =imageDataString.split(",");
		imageDataString="";
		for (int i = 1; i < str.length; i++) {
			imageDataString+=str[i];
		}
	    return Base64.decodeBase64(imageDataString);
	}
	
	
}
