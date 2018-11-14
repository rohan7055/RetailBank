package com.ilp.tcs.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.simple.JSONObject;

public class Utils {

	//a utility method to send object
		//as JSON response
		public static void sendAsJson(
			HttpServletResponse response, 
			Object obj) throws IOException {
			
			response.setContentType("application/json");
			
			Gson _gson = new Gson();
			String res = _gson.toJson(obj);
			     
			PrintWriter out = response.getWriter();
			  
			out.print(res);
			out.flush();
		}
		
		public static String getPayLoad(HttpServletRequest request){
			
			StringBuilder buffer = new StringBuilder();
			try{
		    BufferedReader reader = request.getReader();
		    String line;
		    while ((line = reader.readLine()) != null) {
		        buffer.append(line);
		    }
			}catch(IOException e){
				e.printStackTrace();
			}
		    
		    return buffer.toString();
			
		}
		
		public static String getJSON(HttpServletRequest request){
			JSONObject jsonObj=new JSONObject();
			Map<String, String[]> map = request.getParameterMap();
			for(String paramName:map.keySet()) {
			    String[] paramValues = map.get(paramName);

			    //Get Values of Param Name
			    for(String valueOfParam:paramValues) {
			        //Output the Values
			    	jsonObj.put(paramName, valueOfParam);
			       // System.out.println("Value of Param with Name "+paramName+": "+valueOfParam);
			    }
			}
			String prettyJson = jsonObj.toString();
	 
		    return prettyJson;
		}
}
