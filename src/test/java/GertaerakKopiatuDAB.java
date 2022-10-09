import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Sport;
import exceptions.QuestionAlreadyExist;
import test.dataAccess.TestDataAccess;

public class GertaerakKopiatuDAB {

	 //sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();

	private Event ev;
	
		
	//Eventua datubasean dago baina data berdinerako kopiatzen saiatzean ez du kopiatuko
	@Test
	public void test4() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sut.open(true);
		try {
			
			testDA.open();
			ev = testDA.addEventWithQuestionAndQuote("Manolo-Manolete",oneDate,"query2", 3,12);
			testDA.close();	
		
			boolean emaitza= sut.gertaerakKopiatu(ev, oneDate);
			assertTrue(!emaitza);
		}catch(Exception e) {
			fail();
		}finally {
			testDA.open();
	        boolean b=testDA.removeEvent(ev);
	        testDA.close();
	        sut.close();
		}
		
		
		
		
		
   }
	//Event-a ez da existitzen databasean, ez da ezer kopiatuko
	@Test
	public void test5() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		ev= null;
		Date oneDate=null;
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		sut.open(true);
		
		try {
			sut.gertaerakKopiatu(ev, oneDate);
			fail();
		}catch(Exception e) {
			assertTrue(true);
		}finally {
			sut.close();			
		}
		
		
		
		
		
   }
}


