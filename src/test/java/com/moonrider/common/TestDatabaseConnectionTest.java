package com.moonrider.common;

import java.sql.SQLException;

import javax.inject.Inject;

import org.junit.jupiter.api.Test;

import io.agroal.api.AgroalDataSource;
import io.quarkus.test.junit.QuarkusTest;

@QuarkusTest
public class TestDatabaseConnectionTest {

	@Inject
	AgroalDataSource dataSource;
	
    @Test
    public void testDatabaseConnection() throws SQLException {
    	dataSource.getConnection();
    }

}