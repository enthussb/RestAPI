package com.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.ws.rs.Consumes;

@Path("/storeJSON")
public class JSONtoDB 
{
	@GET
	@Consumes(MediaType.APPLICATION_JSON)
	public String storeJSON() throws ClassNotFoundException, SQLException, IOException
	{
		String JSONstring = "";
		URL url = new URL("http://localhost:8080/RestAPI/api/getJSON");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.connect();
		int responsecode = conn.getResponseCode();
		if(responsecode !=200)
		{
			throw new RuntimeException("HttpResponseCode:"+responsecode);
		}
			else
			{
				Scanner sc = new Scanner(url.openStream());
				while(sc.hasNext())
				{
					JSONstring += sc.nextLine();
				}
				sc.close();
			}
		Gson gson = new Gson();
		Type CustomerListType = new TypeToken<ArrayList<Customer>>(){}.getType();
		ArrayList<Customer> CustomerList = gson.fromJson(JSONstring,CustomerListType);
		DatabaseConnection db = new DatabaseConnection();
		db.storeinDB(CustomerList);
		
		return "<html>"+"<body><h1>"+"Success"+"</h1></body>"+"</html>";
	}	
}
