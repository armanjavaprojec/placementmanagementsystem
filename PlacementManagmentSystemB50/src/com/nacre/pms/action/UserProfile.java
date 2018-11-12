package com.nacre.pms.action;

import java.awt.image.BufferedImage;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.dev.ReSave;

import com.google.gson.Gson;
import com.nacre.pms.bo.ProfileBO;
import com.nacre.pms.delegate.AdminDelegate;
import com.nacre.pms.delegate.TraineeDelegate;
import com.nacre.pms.exception.DatabaseException;
import com.nacre.pms.util.ImageUtil;
import com.nacre.pms.util.StringConstants;

/**
 * @author Tanaji
 * @version 1.0.0 2018
 * @author Nacre Batch 50 Java This controller is used to dvelop the Admin
 *         Functionalities
 */
@WebServlet("/UserProfile")
public class UserProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/json");
		// get the writer
		PrintWriter pw = response.getWriter();
		
		// set the content type
		
		
		System.out.println("email id controller--" + request.getSession(false).getAttribute(StringConstants._SESSION_EMAIL));
		
		String email = request.getSession(false).getAttribute(StringConstants._SESSION_EMAIL).toString();

		System.out.println("UserEmail"+email);
		ProfileBO bo = null;
		
		Gson gson = null;
		try {
		AdminDelegate adminDelegate = null;

		adminDelegate = new AdminDelegate();
			bo = adminDelegate.getUserProfile(email);
			
				gson=new Gson();
				String data=gson.toJson(bo);
				response.getWriter().write(data);
				System.out.println(data);
			
		} catch (DatabaseException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
}