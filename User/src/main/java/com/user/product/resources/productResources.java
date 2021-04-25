package com.user.product.resources;

//import java.util.Arrays;
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

import com.user.product.model.product;
import com.user.product.repository.productRepository;

@Path("products")
public class productResources {
	
	productRepository repo = new productRepository();
	
	@GET
	@Path("product")
	@Produces(MediaType.APPLICATION_JSON)
	public List<product> getProducts()
	{
		//System.out.println("called..");
		return repo.getProducts();
		
	}
	
	@GET
	@Path("product/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public product getProduct(@PathParam("id") int id)
	{
		return repo.getProduct(id);
	}
	
	@POST
	@Path("product")
	@Consumes(MediaType.APPLICATION_JSON)
	public product createProduct(product p1)
	{
		System.out.println(p1);
		repo.create(p1);
		return p1;
	}
	
	@PUT
	@Path("product")
	@Consumes(MediaType.APPLICATION_JSON)
	public product updateProduct(product p1)
	{
		System.out.println(p1);
		if(repo.getProduct(p1.getId()).getId()==0)
		{
			System.out.println("product id not found");
			//repo.create(p1);
		}
		else
		{
			System.out.println("updated..");
			repo.update(p1);
		}
		return p1;
	}
	
	@DELETE
	@Path("product/{id}")
	public product deleteProduct(@PathParam("id") int id)
	{
		product p = repo.getProduct(id);
		
		if(p.getId()!=0) {
		repo.delete(id);
		System.out.println("deleted..");
		}
		else {
			System.out.println("product id not found");
		}
		return p;
	}
}
