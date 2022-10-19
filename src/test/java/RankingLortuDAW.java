
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Registered;
import domain.User;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;
import test.businessLogic.TestFacadeImplementation;
import test.dataAccess.TestDataAccess;
public class RankingLortuDAW {
	/* //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Event ev;
	
	@Test
	//sut.rankingLortu: The list of registered users is empty. 
	public void test1() {
		try {		
			//configure the state of the system (create object in the dabatase)
			testDA.open();
			//ev = testDA.rankingLortu();
			testDA.close();
			
			
			//invoke System Under Test (sut)  
			List<Registered> ema = sut.rankingLortu();
			assertTrue(ema.isEmpty());
		 } catch (Exception e) {
			   fail();
		 }
	}
	@Test
	//sut.rankingLortu:  There is a registered user
	public void test2() {
		Registered david = new Registered("David", "1234", 5678);
		try {		
			//configure the state of the system (create object in the dabatase)
			testDA.open();
			testDA.addUserWithGains(david, (double)15);
			testDA.close();


			//invoke System Under Test (sut)  
			List<Registered> ema = sut.rankingLortu();
			
			assertTrue(ema.size()==1 && ema.get(0).equals(david));
		} catch (Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database
			testDA.open();
			testDA.removeRegisteredUsers(david);
			testDA.close();
		}
	}
	
	@Test
	//sut.rankingLortu:  There is a list of registered users and a ranking with 4 users. Add new user on top gains
	public void test3() {
		Registered us1 = new Registered("Pepe", "1234", 5678);
		Registered us2 = new Registered("Manuel", "1234", 1111);
		Registered us3 = new Registered("Pedro", "1234", 2222);
		Registered us4 = new Registered("Pepito", "1234", 3333);
		Registered us5 = new Registered("Andoni", "1234", 4444);
		try {		
			List<Registered> expected = new ArrayList<Registered>();
			expected.add(us5);
			expected.add(us4);
			expected.add(us2);
			expected.add(us3);
			expected.add(us1);
			testDA.open();
			testDA.addUserWithGains(us1, (double)10);
			testDA.addUserWithGains(us2, (double)13);
			testDA.addUserWithGains(us3, (double)12);
			testDA.addUserWithGains(us4, (double)14);
			testDA.close();

			//invoke System Under Test (sut)  
			List<Registered> em1a = sut.rankingLortu();
			
			testDA.open();
			testDA.addUserWithGains(us5, (double)16);
			testDA.close();
			
			List<Registered> ema = sut.rankingLortu();
			
			assertTrue(ema.equals(expected));
		} catch (Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database
			testDA.open();
			testDA.removeRegisteredUsers(us1);
			testDA.removeRegisteredUsers(us2);
			testDA.removeRegisteredUsers(us3);
			testDA.removeRegisteredUsers(us4);
			testDA.removeRegisteredUsers(us5);
			testDA.close();
		}
	}
	
	@Test
	//sut.rankingLortu:  There is a list of registered users and a ranking with 4 users. Add new user on mid ranking.
	public void test4() {
		Registered us1 = new Registered("Ane", "1234", 5678);
		Registered us2 = new Registered("Ana", "1234", 1111);
		Registered us3 = new Registered("Ander", "1234", 2222);
		try {	
			List<Registered> expected = new ArrayList<Registered>();
			expected.add(us1);
			expected.add(us3);
			expected.add(us2);
			
			testDA.open();
			testDA.addUserWithGains(us1, (double)24);
			testDA.addUserWithGains(us2, (double)13);
			testDA.close();

			//invoke System Under Test (sut)  
			sut.rankingLortu();
			
			testDA.open();
			testDA.addUserWithGains(us3, (double)16);
			testDA.close();
			
			List<Registered> ema = sut.rankingLortu();
			
			assertTrue(ema.equals(expected));
		} catch (Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database
			testDA.open();
			testDA.removeRegisteredUsers(us1);
			testDA.removeRegisteredUsers(us2);
			testDA.removeRegisteredUsers(us3);
			testDA.close();
		}
	}*/
}
