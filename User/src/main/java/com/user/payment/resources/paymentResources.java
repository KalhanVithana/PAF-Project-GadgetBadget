package com.user.payment.resources;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import com.user.payment.model.payment;
import com.user.payment.repository.paymentRepository;


//Resources
@Path("/payments")
public class paymentResources {

	
paymentRepository repo = new paymentRepository();
	
			
	@GET	
	@Produces(MediaType.APPLICATION_JSON)
	public List<payment> getPayments() {
		return repo.getPayments();
	}
	
	@GET
	@Path("payment/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public payment getPayment(@PathParam("id") int id) {
		return repo.getPayment(id);
	}
	
	@POST
	@Path("payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public payment createPayment(payment p1) {
		System.out.println(p1);
		repo.create(p1);
		
		return p1;
	}
	
	@PUT
	@Path("payment")
	@Consumes(MediaType.APPLICATION_JSON)
	public payment updatePayment(payment p1) {
		System.out.println(p1);
		if(repo.getPayment(p1.getId()).getId() == 0) {
			System.out.println("Payment ID not found in the database!");
		} else {
			repo.update(p1);
		}
		return p1;
		
	}
	
	@DELETE
	@Path("payment/{id}")
	public payment deletePayment(@PathParam("id") int id) {
		payment p = repo.getPayment(id);
		
		if(p.getId() != 0) {
			repo.delete(id);
		}
		else {
			System.out.println("Payment ID not found in the database!");
		}
		return p;
		
	}
}
