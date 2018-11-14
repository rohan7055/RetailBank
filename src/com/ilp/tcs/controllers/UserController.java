package com.ilp.tcs.controllers;


import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ilp.tcs.bean.Customer;
import com.ilp.tcs.bean.User;
import com.ilp.tcs.controllers.Models.Model;
import com.ilp.tcs.responsemodel.CustomerLoginResponse;
import com.ilp.tcs.responsemodel.CustomerRegisterResponse;
import com.ilp.tcs.responsemodel.StatusModel;
import com.ilp.tcs.service.ApplicationService;
import com.ilp.tcs.utils.MessageConstants;
import com.ilp.tcs.utils.Utils;

// http://localhost:8080/RetailBanking_GroupB/


//http://localhost:8080/RetailBanking_GroupB/user/register


@WebServlet("/user/*")
public class UserController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();
		System.out.println("GET");

//		if(pathInfo == null || pathInfo.equals("/")){
//            StatusModel statusModel=new StatusModel();
//            statusModel.setStatus(false);
//            statusModel.setMessage(MessageConstants.WRONG_URL);
//            statusModel.setStatusCode(404);
//
//            Utils.sendAsJson(resp, statusModel);
//			
//			return;
//		}
		
      String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			//resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			 StatusModel statusModel=new StatusModel();
	            statusModel.setStatus(false);
	            statusModel.setMessage(MessageConstants.BAD_REQUEST);
	            statusModel.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
	            Utils.sendAsJson(resp, statusModel);
			return;
		}
		//this should be either /login or /register
		String urlSelector = splits[1];
		System.out.println(urlSelector);
		
		if(urlSelector.equalsIgnoreCase("login")){
			//login function should be called from the service
		/*	System.out.println("Login");
			 StatusModel statusModel=new StatusModel();
	            statusModel.setStatus(true);
	            statusModel.setMessage(MessageConstants.LOGIN_SUCCESS);
	            statusModel.setStatusCode(HttpServletResponse.SC_OK);
	            Utils.sendAsJson(resp, statusModel);
			return;*/
			
			req.getRequestDispatcher("login.jsp").forward(req, resp);
			return;
		}else if(urlSelector.equalsIgnoreCase("register")){
			//register function should be called from the service
			System.out.println("Register");
//			 StatusModel statusModel=new StatusModel();
//	            statusModel.setStatus(false);
//	            statusModel.setMessage(MessageConstants.REGISTER_SUCCESS);
//	            statusModel.setStatusCode(HttpServletResponse.SC_OK);
//
//	            Utils.sendAsJson(resp, statusModel);
			req.getRequestDispatcher("register.jsp").forward(req, resp);
			resp.sendRedirect("");

			return;
		}/*else{
			//resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			StatusModel statusModel=new StatusModel();
            statusModel.setStatus(false);
            statusModel.setMessage(MessageConstants.BAD_REQUEST);
            statusModel.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);

            Utils.sendAsJson(resp, statusModel);
			return;
		}*/
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pathInfo = req.getPathInfo();

		if(pathInfo == null || pathInfo.equals("/")){
            StatusModel statusModel=new StatusModel();
            statusModel.setStatus(false);
            statusModel.setMessage(MessageConstants.WRONG_URL);
            statusModel.setStatusCode(404);

            Utils.sendAsJson(resp, statusModel);
			
			return;
		}
		
      String[] splits = pathInfo.split("/");
		
		if(splits.length != 2) {
			
			//resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			 StatusModel statusModel=new StatusModel();
	            statusModel.setStatus(false);
	            statusModel.setMessage(MessageConstants.BAD_REQUEST);
	            statusModel.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);
	            Utils.sendAsJson(resp, statusModel);
			return;
		}
		//this should be either /login or /register
		String urlSelector = splits[1];
		
		if(urlSelector.equalsIgnoreCase("login")){
			//login function should be called from the service
			String payload=Utils.getJSON(req);			Gson _gson = new Gson();
			User user=_gson.fromJson(payload, User.class);
			CustomerLoginResponse responseOBJ=ApplicationService.login(user.getSsn(), user.getPassword());
	        Utils.sendAsJson(resp, responseOBJ);
			return;
		}
		
		else if(urlSelector.equalsIgnoreCase("register")){
		    String payload=Utils.getJSON(req);
		     System.out.println(payload);

			Gson _gson = new Gson();
			Customer customer=_gson.fromJson(payload, Customer.class);
			CustomerRegisterResponse responseOBJ=ApplicationService.register(customer);
			Utils.sendAsJson(resp, responseOBJ);
			return;
		}
		else{
			//resp.sendError(HttpServletResponse.SC_BAD_REQUEST);
			StatusModel statusModel=new StatusModel();
            statusModel.setStatus(false);
            statusModel.setMessage(MessageConstants.BAD_REQUEST);
            statusModel.setStatusCode(HttpServletResponse.SC_BAD_REQUEST);

            Utils.sendAsJson(resp, statusModel);
			return;
		}
		
		
	}
	
	

}
