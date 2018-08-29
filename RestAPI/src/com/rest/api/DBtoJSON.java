package com.rest.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
//import com.google.gson.GsonBuilder;

import java.sql.SQLException;
import java.util.ArrayList;

//import javax.ws.rs.ApplicationPath;
//import javax.ws.rs.core.Application;

@Path("/getJSON")
public class DBtoJSON 
{
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String sendJSON() throws ClassNotFoundException, SQLException
	{
		ArrayList<Customer> al;
		DatabaseConnection db = new DatabaseConnection();
		al = db.retrieve();
		
		Gson json = new Gson();
		String resource = json.toJson(al);
		return resource;
	}
}
