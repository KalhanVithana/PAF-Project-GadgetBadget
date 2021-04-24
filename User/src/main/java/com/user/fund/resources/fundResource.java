package com.user.fund.resources;

import java.util.List;
import java.util.Arrays;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.user.fund.model.fund;
import com.user.fund.repository.fundRepository;

@Path("/funds")
public class fundResource {
	
	fundRepository repo = new fundRepository();
	
    /*@GET
    @Produces(MediaType.APPLICATION_XML)
	public List<Fund> getFunds()
    {
		
    	System.out.println("getFund Called..");
    	return repo.getFunds();
		
	}*/
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	
	public List<fund> getFunds() {
		System.out.println("get is working");
		return repo.getFunds();
	}
	
		@GET
		@Path("fund/{id}")
		@Produces(MediaType.APPLICATION_JSON)
		public fund getPayment(@PathParam("id") int id) {
			return repo.getFund(id);
		}
    
    /*@POST //creating resource 
    @Path("fund")
    public Fund createFund(Fund f1)
    {
    	System.out.println(f1);
    	repo.create(f1);
    	return f1;
    }*/
	
	@POST
	@Path("/fund")
	@Consumes(MediaType.APPLICATION_JSON)
	public fund createPayment(fund p1) {
		System.out.println(p1);
		repo.create(p1);
		
		return p1;
	}
	
	
	@PUT
	@Path("/fund")
	@Consumes(MediaType.APPLICATION_JSON)
	public fund updatePayment(fund p1) {
		System.out.println(p1);
		if(repo.getFund(p1.getId()).getId() == 0) {
			System.out.println("Payment ID not found in the database!");
		} else {
			repo.update(p1);
		}
		return p1;
		
	}
	
	@DELETE
	@Path("fund/{id}")
	public fund deletePayment(@PathParam("id") int id) {
		fund p = repo.getFund(id);
		
		if(p.getId() != 0) {
			repo.delete(id);
		}
		else {
			System.out.println("Payment ID not found in the database!");
		}
		return p;
		
	}
	
}
