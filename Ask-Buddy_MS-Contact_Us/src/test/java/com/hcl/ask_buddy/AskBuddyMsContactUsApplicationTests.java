package com.hcl.ask_buddy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ask_buddy.controller.ContactUsController;
import com.hcl.ask_buddy.entity.ContactUs;
import com.hcl.ask_buddy.exceptions.IdNotFoundException;
import com.hcl.ask_buddy.repository.ContactUsRepo;
import com.hcl.ask_buddy.service.ContactUsService;

@SpringBootTest
class AskBuddyMsContactUsApplicationTests {

	@InjectMocks
	private ContactUsService conServ;

	@Mock
	private ContactUsRepo cRepo;

	@Test
	void contextLoads() {
	}

	@Test
	public void testAddQuery() {

		ContactUs conUs = new ContactUs();
		conUs.setSap_Id(52117973);
		conUs.setName("Faraz");
		conUs.setQuery("Want to know about project");

		Mockito.when(cRepo.save(Mockito.any(ContactUs.class))).thenReturn(conUs);

		ContactUs savedConUS = conServ.addQuery(conUs);

		assertEquals(conUs, savedConUS);

	}

	@Test
	public void testGetAllQueries() {
		List<ContactUs> conUsList = new ArrayList<>();
		ContactUs con1 = new ContactUs();
		con1.setSap_Id(52117971);
		con1.setName("Dani");
		con1.setQuery("Test Question");
		conUsList.add(con1);
		ContactUs con2 = new ContactUs();
		con2.setSap_Id(52117972);
		con2.setName("Johnny");
		con2.setQuery("Test Check");
		conUsList.add(con2);

		Mockito.when(cRepo.findAll()).thenReturn(conUsList);

		List<ContactUs> fetList = conServ.getAllQueries();

		assertEquals(conUsList, fetList);
	}

	@Test
	public void testSearchById() {
		long sap_Id = 52117973;
		ContactUs conUs = new ContactUs();
		conUs.setSap_Id(sap_Id);
		conUs.setName("Faraz");
		conUs.setQuery("Testing the app");

		Mockito.when(cRepo.findById(sap_Id)).thenReturn(Optional.of(conUs));

		ContactUs actConUs = conServ.searchById(sap_Id);

		assertEquals(conUs, actConUs);
	}

	@Test
	public void testSearchByInvalidId() {
		Optional<ContactUs> opt = Optional.empty();
		long sap_Id = 12345786;
		Mockito.when(cRepo.findById(sap_Id)).thenReturn(opt);
		IdNotFoundException exc = assertThrows(IdNotFoundException.class, () -> conServ.searchById(sap_Id));
		assertEquals("Database does not contain any info or Queries with the given SAP ID :" + sap_Id,
				exc.getMessage());
	}

//	@Test
//	public void testSearchByNullId() {
//		Optional<ContactUs> opt = Optional.empty();
//		long sap_Id = (Long) null;
//		Mockito.when(cRepo.findById(sap_Id)).thenReturn(opt);
//		IdNotFoundException exc = assertThrows(IdNotFoundException.class, () -> conServ.searchById(sap_Id));
//		assertEquals("Database does not contain any info or Queries with the given SAP ID :" + sap_Id,
//				exc.getMessage());
//
//	}

//	public void testUpdateById() {
//		
//		long sap_Id = 12345678;
//		boolean que_status = true;
//		
//		ContactUs con = new ContactUs();
//		con.setSap_Id(sap_Id);
//		con.setQue_status(!que_status);
//		
//		Mockito.when(cRepo.findById(sap_Id)).thenReturn(Optional.of(con));
//		
//		ContactUs res = conServ.updatebyId(con);
//		
//		//assertEquals(res);
//		
//		
//		
//	}

	@BeforeEach
	void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	void testUpdatebyIdWithValidId() {
		// Arrange
		ContactUs existingContactUs = new ContactUs();
		existingContactUs.setSap_Id(12345L);
		existingContactUs.setName("John Doe");
//	        existingContactUs.setEmail("johndoe@example.com");
		existingContactUs.setQuery("This is a test message");
		Mockito.when(cRepo.findById(12345L)).thenReturn(java.util.Optional.of(existingContactUs));
		ContactUs updatedContactUs = new ContactUs();
		updatedContactUs.setSap_Id(12345L);
		updatedContactUs.setName("Jane Doe");
//	        updatedContactUs.setEmail("janedoe@example.com");
		updatedContactUs.setQuery("This is an updated message");

		// Act
		ContactUs result = conServ.updatebyId(updatedContactUs);

		// Assert
		assertEquals(result.getName(), "Jane Doe");
//	        assertEquals(result.getEmail(), "janedoe@example.com");
		assertEquals(result.getQuery(), "This is an updated message");
		verify(cRepo).save(updatedContactUs);
	}

	@Test
	void testUpdatebyIdWithInvalidId() {
		// Arrange
		ContactUs updatedContactUs = new ContactUs();
		updatedContactUs.setSap_Id(12345L);
		updatedContactUs.setName("Jane Doe");
//	        updatedContactUs.setEmail("janedoe@example.com");
		updatedContactUs.setQuery("This is an updated message");
		Mockito.when(cRepo.findById(12345L)).thenReturn(java.util.Optional.of(updatedContactUs));

		// Act
		ContactUs result = conServ.updatebyId(updatedContactUs);
		assertEquals(result, updatedContactUs);
	}

}
