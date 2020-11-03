package com.sql.jdbc;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.sql.jdbc.AddressBookService.IOService;


public class AddressBookJDBCTest {
	@Test
    public void givenEmpPayrollDataInDB_ShouldMatchEmpCount() {
    	AddressBookService service = new AddressBookService();
    	List<AddressBookData> addList = service.readAddressBookData(IOService.DB_IO);
    	Assert.assertEquals(5, addList.size());
    }
}
