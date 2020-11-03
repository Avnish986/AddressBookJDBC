package com.sql.jdbc;

import java.util.List;
import java.util.Map;

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

	@Test
	public void givenNewCity_WhenUpdated_shouldMatchWithDB() {
		AddressBookService service = new AddressBookService();
		service.readAddressBookData(IOService.DB_IO);
		service.updateContactsCity("abc", "btd");
		boolean result = service.checkAddressBookDataInSyncWithDB("abc", "btd");
		Assert.assertTrue(result);
	}

	@Test
	public void givenContactsData_WhenCountByCity_ShouldReturnProperValue() {
		AddressBookService service = new AddressBookService();
		service.readAddressBookData(IOService.DB_IO);
		Map<String, Integer> countContactsByCity = service.readCountContactsByCity(IOService.DB_IO);
		Assert.assertTrue(countContactsByCity.get("bathinda").equals(1));
	}

	@Test
	public void givenContactsData_WhenCountByState_ShouldReturnProperValue() {
		AddressBookService service = new AddressBookService();
		service.readAddressBookData(IOService.DB_IO);
		Map<String, Integer> countContactsByState = service.readCountContactsByState(IOService.DB_IO);
		Assert.assertTrue(countContactsByState.get("pnb").equals(5));
	}

}
