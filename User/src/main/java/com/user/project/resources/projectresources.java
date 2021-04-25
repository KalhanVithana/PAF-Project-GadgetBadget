package com.user.project.resources;
//import javax.json.JsonObject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.google.gson.*;
import com.google.gson.JsonObject;
//import com.sun.xml.txw2.Document;

import org.apache.tomcat.util.json.JSONParser;
import org.eclipse.jdt.internal.compiler.parser.JavadocParser;
import org.json.JSONObject;
import org.jsoup.*;
import org.jsoup.parser.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;

import com.user.project.model.project;
@Path("project")
public class projectresources {
///gdgeggd
	
	project p1 = new project();
	//private Object Jsoup;
		

		//insert
		@POST
		@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
		@Produces(MediaType.TEXT_PLAIN)
		public String insertItem(@FormParam("Project") String Project,@FormParam("OwnerName") String OwnerName,
		 @FormParam("Duration") String Duration,
		 @FormParam("Email") String Email,
		 @FormParam("Description") String Description)
		{
		 String output = p1.insertItem(Project, OwnerName, Duration, Email, Description);
		return output;
		}
		
		//read
		@GET
		
		@Produces(MediaType.TEXT_HTML)
		public String readItems()
		 {
		 return p1.readItems();
		 }

		
		
		
		//delete
		@DELETE
		
		@Consumes(MediaType.APPLICATION_XML)
		@Produces(MediaType.TEXT_PLAIN)
		public String deleteItem(String itemData)
		{
		//Convert the input string to an XML document
		 
		
			Document doc = Jsoup.parse(itemData, "", Parser.xmlParser());
			
		//Read the value from the element <PID>
		 String PID = doc.select("PID").text();
		 String output = p1.deleteItem(PID);
		return output;
		}
		
		
		
		
		 	
		@PUT
		@Consumes(MediaType.APPLICATION_JSON)
		@Produces(MediaType.TEXT_PLAIN)
		public String updateItem(String itemData)
		{
		//Convert the input string to a JSON object
			 JsonObject itemObject = new JsonParser().parse(itemData).getAsJsonObject();
		//Read the values from the JSON object
		 int PID = itemObject.get("PID").getAsInt();
		 String Project = itemObject.get("Project").getAsString();
		 String OwnerName = itemObject.get("OwnerName").getAsString();
		 String Duration = itemObject.get("Duration").getAsString();
		 String Email = itemObject.get("Email").getAsString();
		 String Description = itemObject.get("Description").getAsString();
		 String output = p1.updateItem(PID, Project, OwnerName, Duration, Email, Description);
		return output;
		}
		
		


	
	
	
	
}
