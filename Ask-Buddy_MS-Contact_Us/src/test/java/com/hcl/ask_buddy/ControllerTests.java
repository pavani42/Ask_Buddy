package com.hcl.ask_buddy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ask_buddy.controller.ContactUsController;
import com.hcl.ask_buddy.entity.ContactUs;
import com.hcl.ask_buddy.service.ContactUsService;

@SpringBootTest
public class ControllerTests {

	@InjectMocks
	private ContactUsController conCtrl;
	
	@Mock
	private ContactUsService conServ;

	// Controller test cases

//	@Test
//	void testAddQuery1() {
//		// Arrange
//		ContactUs newQuery = new ContactUs();
//		newQuery.setSap_Id(12345L);
//		newQuery.setName("John Doe");
////	      newQuery.set("johndoe@example.com");
//		newQuery.setQuery("This is a new query");
//
//		Mockito.when(conServ.addQuery(Mockito.any(ContactUs.class))).thenReturn(newQuery);
//
//		// Act
//		ContactUs result = conCtrl.addQuery(newQuery);
//
//		// Assert
//		assertNotNull(result);
//		assertEquals(newQuery.getSap_Id(), result.getSap_Id());
//		assertEquals(newQuery.getName(), result.getName());
////	        assertEquals(newQuery.getEmail(), result.getEmail());
//		assertEquals(newQuery.getQuery(), result.getQuery());
//		verify(conServ, times(1)).addQuery(any(ContactUs.class));
//	}

	@Test
	void testGetAllQueries1() {
		// Arrange
		List<ContactUs> queries = new ArrayList<>();
		ContactUs query1 = new ContactUs();
		query1.setSap_Id(12345L);
		query1.setName("John Doe");
//	    query1.setEmail("johndoe@example.com");
		query1.setQuery("This is a new query");
		queries.add(query1);
		ContactUs query2 = new ContactUs();
		query2.setSap_Id(67890L);
		query2.setName("Jane Doe");
//	    query2.setEmail("janedoe@example.com");
		query2.setQuery("This is another query");
		queries.add(query2);

		Mockito.when(conServ.getAllQueries()).thenReturn(queries);

		// Act
		List<ContactUs> result = conCtrl.getAllQueries();

		// Assert
		assertNotNull(result);
		assertEquals(queries.size(), result.size());
		verify(conServ, times(1)).getAllQueries();
	}

	@Test
	void testSearchById1() {
		// Arrange
		ContactUs query = new ContactUs();
		query.setSap_Id(12345L);
		query.setName("John Doe");
//	        query.setEmail("johndoe@example.com");
		query.setQuery("This is a new query");

		Mockito.when(conServ.searchById(12345L)).thenReturn(query);

		// Act
		ContactUs result = conCtrl.searchById(12345L);

		// Assert
		assertNotNull(result);
		assertEquals(query.getSap_Id(), result.getSap_Id());
		assertEquals(query.getName(), result.getName());
//	        assertEquals(query.getEmail(), result.getEmail());
		assertEquals(query.getQuery(), result.getQuery());
	}

//	@Test
//	void testUpdatebyId() {
//		// Arrange
//		ContactUs updatedQuery = new ContactUs();
//		updatedQuery.setSap_Id(12345L);
//		updatedQuery.setName("John Doe");
////	        updatedQuery.setEmail("johndoe@example.com");
//		updatedQuery.setQuery("This is an updated query");
//
//		when(conServ.updatebyId(any(ContactUs.class))).thenReturn(updatedQuery);
//
//		// Act
//		ContactUs result = conCtrl.updatebyId(updatedQuery);
//
//		// Assert
//		assertNotNull(result);
//		assertEquals(updatedQuery.getSap_Id(), result.getSap_Id());
//		assertEquals(updatedQuery.getName(), result.getName());
////	        assertEquals(updatedQuery.getEmail(), result.getEmail());
//		assertEquals(updatedQuery.getQuery(), result.getQuery());
//		verify(conServ, times(1)).updatebyId(any(ContactUs.class));
//	}

}
