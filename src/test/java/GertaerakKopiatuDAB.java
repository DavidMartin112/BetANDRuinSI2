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
	
	@Before
	public void setUp() throws Exception {
	}
	
	//En teoria event bat data berri batera mugitzean 
	@Test
	public void test() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		Date twoDate=null;
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			twoDate = sdf.parse("23/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		try {
			
			testDA.open();
			ev = testDA.addEventWithQuestionAndQuote("Manolo-Juanita",oneDate,"query2", 3,678);
			testDA.close();	
		
			boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
			assertTrue(emaitza);
		}catch(Exception e) {
			fail();
		}finally {
	        sut.gertaeraEzabatu(ev);
		}
		
		
		
		
		
   }
	//Data berdinerako
	@Test
	public void test2() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date oneDate=null;
		Date twoDate=null;
		try {
			oneDate = sdf.parse("05/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		try {
			twoDate = sdf.parse("23/10/2022");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
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
		}
		
		
		
		
		
   }
}


