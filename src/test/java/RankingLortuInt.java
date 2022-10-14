import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import businessLogic.BLFacadeImplementation;
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

public class RankingLortuInt {
	static BLFacadeImplementation sut;
	static TestFacadeImplementation testBL;

	@BeforeClass
	public static void setUpClass() {
		try {
		sut= new BLFacadeImplementation();

		DataAccess da= new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));
		
		testBL= new TestFacadeImplementation();
		}catch(Exception e) {}
	}
	
	@Test
	//sut.rankingLortu: The list of registered users is empty. 
	public void test1() {
		Registered reg1 =new Registered("registered", "123", 1234);
		Registered reg2 = new Registered("andrea", "123", 1111);
		Registered reg3 = new Registered("markel", "123", 1111);
		Registered reg4 = new Registered("mikel", "123", 1111);
		try {
			testBL.removeRegisteredUsers(reg1);
			testBL.removeRegisteredUsers(reg2);
			testBL.removeRegisteredUsers(reg3);
			testBL.removeRegisteredUsers(reg4);
			List<Registered> ema = sut.rankingLortu();
			assertTrue(ema.isEmpty());
		 } catch (Exception e) {
			fail("This shouldm't be reached");
		 }
	}
	@Test
	//sut.rankingLortu:  There is a registered user
	public void test2() {
		Registered david = new Registered("David", "1234", 5678);
		Double g = (double) 15;
		try {		
			//configure the state of the system (create object in the dabatase)
			testBL.addUserWithGains(david, g);
			
			//invoke System Under Test (sut)  
			List<Registered> ema = sut.rankingLortu();
			assertTrue(ema.size()==1 && ema.get(0).equals(david));
		} catch (Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database
			testBL.removeRegisteredUsers(david);
		}
	}
	
	@Test
	//sut.rankingLortu:  There is a list of registered users and a ranking with 4 users. Add new user on top gains
	public void test3() {
		Registered us1 = new Registered("David", "1234", 5678);
		Registered us2 = new Registered("Manuel", "1234", 1111);
		Registered us3 = new Registered("Pedro", "1234", 2222);
		Registered us4 = new Registered("Pepito", "1234", 3333);
		Registered us5 = new Registered("Andoni", "1234", 4444);
		try {		
			Double g1 = (double) 1;
			Double g2 = (double) 1;
			Double g3 = (double) 1;
			Double g4 = (double) 1;
			Double g5 = (double) 1;
			
			List<Registered> expected = new ArrayList<Registered>();
			
			expected.add(us4);
			expected.add(us3);
			expected.add(us2);
			expected.add(us1);
			expected.add(us5);
			
			testBL.addUserWithGains(us1, g1);
			testBL.addUserWithGains(us2, g2);
			testBL.addUserWithGains(us3, g3);
			testBL.addUserWithGains(us4, g4);

			//invoke System Under Test (sut)  
			sut.rankingLortu();
			
			testBL.addUserWithGains(us5, g5);
			
			List<Registered> ema = sut.rankingLortu();
			
			assertTrue(ema.equals(expected));
			
		} catch (Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database
			testBL.removeRegisteredUsers(us1);
			testBL.removeRegisteredUsers(us2);
			testBL.removeRegisteredUsers(us3);
			testBL.removeRegisteredUsers(us4);
			testBL.removeRegisteredUsers(us5);
		}
	}
	
	@Test
	//sut.rankingLortu:  There is a list of registered users and a ranking with 4 users. Add new user on mid ranking.
	public void test4() {
		Registered us1 = new Registered("David", "1234", 5678);
		Registered us2 = new Registered("Manuel", "1234", 1111);
		Registered us3 = new Registered("Pedro", "1234", 2222);
		try {		
			Double g1 = (double) 24;
			Double g2 = (double) 13;
			Double g3 = (double) 16;
			
			List<Registered> expected = new ArrayList<Registered>();
			expected.add(us1);
			expected.add(us3);
			expected.add(us2);
			
			testBL.addUserWithGains(us1, g1);
			testBL.addUserWithGains(us2, g2);

			//invoke System Under Test (sut)  
			sut.rankingLortu();
			
			testBL.addUserWithGains(us3, g3);
			
			List<Registered> ema = sut.rankingLortu();
			assertTrue(ema.equals(expected));
		} catch (Exception e) {
			fail();
		} finally {
			//Remove the created objects in the database
			testBL.removeRegisteredUsers(us1);
			testBL.removeRegisteredUsers(us2);
			testBL.removeRegisteredUsers(us3);
		}
	}
}
