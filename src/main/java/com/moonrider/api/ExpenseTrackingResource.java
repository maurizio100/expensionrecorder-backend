package com.moonrider.api;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.moonrider.dao.dto.ExpenseDTO;


@Path("/expenses")
public interface ExpenseTrackingResource {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	List<ExpenseDTO> list();

}