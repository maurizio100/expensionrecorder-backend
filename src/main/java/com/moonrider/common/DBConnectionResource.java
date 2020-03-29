package com.moonrider.common;

import java.sql.SQLException;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.agroal.api.AgroalDataSource;

@Path("/dbconn")
public class DBConnectionResource {

	private final AgroalDataSource dataSource;
	
	@Inject
	DBConnectionResource(AgroalDataSource dataSource) {
		this.dataSource = dataSource;
	}
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String checkDBConnection() throws SQLException {
    	try {
    		dataSource.getConnection();
    	} catch (SQLException se){
    		//TODO log error
    		throw se;
    	}

    	return "works";
    }
}