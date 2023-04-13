package com.hcl.ask_buddy;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.hcl.ask_buddy.controller.FeedbackCtrl;
import com.hcl.ask_buddy.controller.JoinusCtrl;
import com.hcl.ask_buddy.entity.Feedback;
import com.hcl.ask_buddy.entity.Joinus;
import com.hcl.ask_buddy.service.FeedbackService;
import com.hcl.ask_buddy.service.JoinusService;

import junit.framework.TestCase;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class ControllerTests extends TestCase {

	@InjectMocks
	FeedbackCtrl feedbackCtrl;

	@Mock
	FeedbackService feedbackService;

	@Test
	void testAddFeed() {
		// Arrange
		Feedback feedback = new Feedback();
		when(feedbackService.addFeed(feedback)).thenReturn(feedback);

		// Act
		Feedback result = feedbackCtrl.addFeed(feedback);

		// Assert
		assertNotNull(result);
		assertEquals(feedback, result);
	}

	@Test
	void testAllFeeds() {
		// Arrange
		List<Feedback> feedbackList = Arrays.asList(new Feedback(), new Feedback());
		when(feedbackService.allFeeds()).thenReturn(feedbackList);

		// Act
		List<Feedback> result = feedbackCtrl.allFeeds();

		// Assert
		assertNotNull(result);
		assertEquals(feedbackList.size(), result.size());
	}

	@Test
	void testFetchById() {
		// Arrange
		long sapId = 12345L;
		Feedback feedback = new Feedback();
//		when(feedbackService.fetchById(sapId)).thenReturn(feedback);

		// Act
//		Feedback result = feedbackCtrl.fetchById(sapId);

		// Assert
//		assertNotNull(result);
//		assertEquals(feedback, result);
	}

	@Test
	void testFetchByRatings() {
		// Arrange
		int rating = 5;
		Feedback feedback = new Feedback();
//		when(feedbackService.fetchByRatings(rating)).thenReturn(feedback);

		// Act
//		Feedback result = feedbackCtrl.fetchByRatings(rating);

		// Assert
//		assertNotNull(result);
//		assertEquals(feedback, result);
	}

	/*********************************************************************************************/

	@Mock
	private JoinusService juServ;

	@InjectMocks
	private JoinusCtrl juCtrl;

	@Test
	void testRegister() {
		// Arrange
		Joinus newUser = new Joinus();
		newUser.setName("John Doe");
		newUser.setEmail("johndoe@example.com");

		Joinus savedUser = new Joinus();
		savedUser.setSapId(12345L);
		savedUser.setName("John Doe");
		savedUser.setEmail("johndoe@example.com");

		when(juServ.register(newUser)).thenReturn(savedUser);

		// Act
		Joinus result = juCtrl.register(newUser);

		// Assert
		assertEquals(savedUser, result);
	}

//	@Test
//	void testGetAllData() {
//		// Arrange
//		List<Joinus> allData = Arrays.asList(new Joinus(12345L, "John Doe", "johndoe@example.com"),
//				new Joinus(67890L, "Jane Doe", "janedoe@example.com"));
//
//		when(juServ.getAllData()).thenReturn(allData);
//
//		// Act
//		List<Joinus> result = juCtrl.getAllData();
//
//		// Assert
//		assertEquals(allData, result);
//	}
//
//	@Test
//	void testFetchById1() {
//		// Arrange
//		long sapId = 12345L;
//		Joinus user = new Joinus(sapId, "John Doe", "johndoe@example.com");
//
//		when(juServ.fetchById(sapId)).thenReturn(user);
//
//		// Act
//		Joinus result = juCtrl.fetchById(sapId);
//
//		// Assert
//		assertEquals(user, result);
//	}
//
//	@Test
//	void testUpdQueStatus() {
//		// Arrange
//		long sapId = 12345L;
//		boolean newQueStatus = true;
//		Joinus updatedUser = new Joinus(sapId, "John Doe", "johndoe@example.com");
//		updatedUser.setQue_status(newQueStatus);
//
//		when(juServ.updQueStatus(sapId, newQueStatus)).thenReturn(updatedUser);
//
//		// Act
//		Joinus result = juCtrl.updQueStatus(sapId, newQueStatus);
//
//		// Assert
//		assertEquals(updatedUser, result);
//	}

	@Test
	void testGetAllData() {
		// Arrange
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

		Mockito.doReturn(joinusList).when(juServ).getAllData();

		// Act
		List<Joinus> result = juCtrl.getAllData();

		// Assert
		assertEquals(joinusList, result);
	}

	@Test
	void testFetchById1() {
		// Arrange
		long sapId = 52117973;
		Joinus expJoinus = new Joinus();
		expJoinus.setSapId(sapId);
		expJoinus.setName("Faraz");
		expJoinus.setEmail("f@f.com");
		expJoinus.setGender("Male");
		expJoinus.setAboutU("Dev - Fresher");
		expJoinus.setSkillsSet("Java");
		expJoinus.setTrained("React");

		Mockito.doReturn(expJoinus).when(juServ).fetchById(sapId);

		// Act
		Joinus result = juCtrl.fetchById(sapId);

		// Assert
		assertEquals(expJoinus, result);
	}

	@Test
	void testUpdQueStatus() {
		// Arrange
		long sapId = 12345L;
		boolean newQueStatus = true;

		Joinus joinus = new Joinus();
		joinus.setSapId(sapId);
		joinus.setQue_status(!newQueStatus);
		Mockito.doReturn(joinus).when(juServ).updQueStatus(sapId, newQueStatus);

		// Act
		Joinus result = juCtrl.updQueStatus(sapId, newQueStatus);

		// Assert
		assertEquals(joinus, result);
	}

}
