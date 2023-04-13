package com.hcl.ask_buddy;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ask_buddy.entity.Feedback;
import com.hcl.ask_buddy.entity.Joinus;
import com.hcl.ask_buddy.exceptions.IdNotFoundException;
import com.hcl.ask_buddy.repository.FeedbackRepo;
import com.hcl.ask_buddy.repository.JoinusRepo;
import com.hcl.ask_buddy.service.FeedbackService;
import com.mysql.cj.x.protobuf.MysqlxDatatypes.Any;

import junit.framework.TestCase;

@SpringBootTest
//@RunWith(MockitoJUnitRunner.class)
public class ApplicationTests extends TestCase {

	@InjectMocks
	private com.hcl.ask_buddy.service.JoinusService joinusService;

	@Mock
	private JoinusRepo joinusRepo;

	@InjectMocks
	private FeedbackService fbserv;

	@Mock
	private FeedbackRepo fbrepo;

	@Test
	void contextLoads() {
	}

	/** Join Us Test cases for all the services **/
	@Test
	@Order(1)
	public void testRegister() {

		Joinus joinus = new Joinus();
		joinus.setSapId(52117971);
		joinus.setName("John Doe");
		joinus.setEmail("johndoe@example.com");

		Mockito.when(joinusRepo.save(Mockito.any(Joinus.class))).thenReturn(joinus);

		Joinus savedJoinus = joinusService.register(joinus);

		assertEquals(joinus, savedJoinus);
	}

	@Test
	@Order(2)
	public void testGetAllData() {

		List<Joinus> joinusList = new ArrayList<>();
		Joinus joinus1 = new Joinus();
		joinus1.setSapId(52117971);
		joinus1.setName("John Doe 1");
		joinus1.setEmail("johndoe1@example.com");
		joinusList.add(joinus1);
		Joinus joinus2 = new Joinus();
		joinus2.setSapId(52117972);
		joinus2.setName("Jane Doe 2");
		joinus2.setEmail("janedoe2@example.com");
		joinusList.add(joinus2);

		Mockito.when(joinusRepo.findAll()).thenReturn(joinusList);

		List<Joinus> fetchedJoinusList = joinusService.getAllData();

		assertEquals(joinusList, fetchedJoinusList);
	}

	@Test
	@Order(5)
	public void testFetchById() {

		long sapId = 52117973;
		Joinus expJoinus = new Joinus();
		expJoinus.setSapId(sapId);
		expJoinus.setName("Faraz");
		expJoinus.setEmail("f@f.com");
		expJoinus.setGender("Male");
		expJoinus.setAboutU("Dev - Fresher");
		expJoinus.setSkillsSet("Java");
		expJoinus.setTrained("React");

		Mockito.when(joinusRepo.findById(sapId)).thenReturn(Optional.of(expJoinus));

		Joinus actualJoinus = joinusService.fetchById(sapId);

		assertEquals(expJoinus, actualJoinus);
	}

	@Test
	@Order(10)
	void testFetchWithIdWithInvalidSapId() {
		Optional<Joinus> optional = Optional.empty();
		long sapId = 12345678;
		Mockito.when(joinusRepo.findById(sapId)).thenReturn(optional);

		IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> joinusService.fetchById(sapId));

		assertEquals("Database does not contain any info with the SAP ID provided i.e.," + sapId,
				exception.getMessage());
	}

//	@Test
//	@Order(13)
//	void testFetchByIdWithNullSapId() {
//		Optional<Joinus> optional = Optional.empty();
//		Long sapId = null;
//
//		Mockito.when(joinusRepo.findById(sapId)).thenReturn(optional);
//
//		IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> joinusService.fetchById(sapId));
//
//		assertEquals("Database does not contain any info with the SAP ID provided i.e.," ,
//				exception.getMessage());
//	}
//
//	@Test
//	@Order(14)
//	void testFetchByIdWithNoSuchElementException() {
//		long sapId = 12345678;
//
//		Mockito.when(joinusRepo.findById(sapId)).thenThrow(new NoSuchElementException());
//
//		IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> joinusService.fetchById(sapId));
//
//		assertEquals("Database does not contain any info with the SAP ID provided i.e.," + sapId,
//				exception.getMessage());
//	}

//	@Test
//	@Order(11)
//	void testUpdQueStatusWithValidSapId() {
//
//		long sapId = 12345678;
//		boolean newQueStatus = true;
//		Joinus joinus = new Joinus();
//		joinus.setSapId(sapId);
//		joinus.setQue_status(!newQueStatus);
//
//		Mockito.when(joinusRepo.findById(sapId)).thenReturn(Optional.of(joinus));
//
//		Joinus result = joinusService.updQueStatus(sapId, newQueStatus);
//
//		assertNotNull(result);
//		assertEquals(newQueStatus, result.isQue_status());
//		verify(joinusRepo, times(1)).findById(sapId);
//		verify(joinusRepo, times(1)).save(joinus);
//	}

	@Test
	@Order(12)
	void testUpdQueStatusWithInvalidSapId() {

		long sapId = 1;
		boolean newQueStatus = true;

		Mockito.when(joinusRepo.findById(sapId)).thenReturn(Optional.empty());

		Joinus result = joinusService.updQueStatus(sapId, newQueStatus);

		assertNull(result);
		verify(joinusRepo, times(1)).findById(sapId);
//	    verify(joinusRepo, never()).save(any());
	}

	/** Feedback Test cases for all the services **/

	@Test
	@Order(3)
	public void testAddFeed() {

		Feedback fb = new Feedback();
//		fb.setSapId(52117971);
		fb.setRating(4);
		fb.setAnyImp("CAn do better");
		fb.setCmnts("Good work");

		Mockito.when(fbrepo.save(Mockito.any(Feedback.class))).thenReturn(fb);

		Feedback savedFeedback = fbserv.addFeed(fb);
		assertEquals(fb, savedFeedback);

	}

	@Test
	@Order(4)
	public void testAllFeeds() {

		List<Feedback> fbLst = new ArrayList<>();
		Feedback fb1 = new Feedback();
//		fb1.setSapId(52117971);
		fb1.setRating(5);
		fb1.setCmnts("Liked ur app");
		fb1.setAnyImp("Expecting more features");
		fbLst.add(fb1);
		Feedback fb2 = new Feedback();
//		fb2.setSapId(52117972);
		fb2.setRating(3);
		fb2.setCmnts("Ok app");
		fb2.setAnyImp("Expecting more features");
		fbLst.add(fb2);
		Feedback fb3 = new Feedback();
//		fb3.setSapId(52117973);
		fb3.setRating(3);
		fb3.setCmnts("Ok app");
		fb3.setAnyImp("Expecting more features");
		fbLst.add(fb3);

		Mockito.when(fbrepo.findAll()).thenReturn(fbLst);

		List<Feedback> fetchedFbList = fbserv.allFeeds();

		assertEquals(fbLst, fetchedFbList);

	}

	@Test
	@Order(6)
	public void testFetchWithId() {

		long sapId = 52117973;
		Feedback expFb = new Feedback();
//		expFb.setSapId(sapId);
		expFb.setRating(4);
		expFb.setCmnts("Loved ur project");
		expFb.setAnyImp("Love to see improvements");

//		Mockito.when(fbrepo.findBySapId(sapId)).thenReturn(Optional.of(expFb));

//		Feedback actFB = fbserv.fetchById(sapId);

//		assertEquals(expFb, actFB);

	}

	@Test
	@Order(7)
	public void testFetchByRatings() {
		Feedback fb = new Feedback();
		fb.setRating(5);

//		Mockito.when(fbrepo.findByRating(5)).thenReturn(Optional.of(fb));

//		Feedback res = fbserv.fetchByRatings(5);

//		verify(fbrepo, times(1)).findByRating(5);
//		assertEquals(fb, res);
	}

//	@BeforeEach
//	public void setup() {
//		fbserv = new FeedbackService(fbrepo);
//	}
//	
//	
//	
//	@Test
//	@Order(8)
//	public void testFetchByRatingsInvalidvalue() {
//		
//		
//
//		Mockito.when(fbrepo.findByRating(3)).thenReturn(Optional.empty());
//
//		fbserv.fetchByRatings(3);

	@Test
	@Order(8)
	public void testFetchByRatingsInvalidvalue() {
		int invalidValue = 6;

		Throwable exception = assertThrows(IdNotFoundException.class, () -> {
			fbserv.fetchByRatings(invalidValue);
		});

		assertEquals("Database does not contain any info with rating provided i.e.," + invalidValue,
				exception.getMessage());
	}

	@Test
	@Order(9)
	public void testFetchByIdWithInvalidSapId() {
		int invalidSapId = 12379654;

//		Mockito.when(fbrepo.findBySapId(invalidSapId)).thenReturn(Optional.empty());

		IdNotFoundException exception = assertThrows(IdNotFoundException.class, () -> {
//			fbserv.fetchById(invalidSapId);
		});

		assertEquals("Database does not contain any info with the SAP ID provided i.e.," + invalidSapId,
				exception.getMessage());
	}

}
