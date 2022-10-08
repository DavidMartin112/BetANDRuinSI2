import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
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

	@Test
	public void test() {
		try {
			
			//define paramaters
			String eventText="Manolo-Pedro";
			String queryText="query1";
			Float betMinimum=new Float(2);
			
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
				twoDate = sdf.parse("09/10/2022");
			}catch(ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//configure the state of the system (create object in the dabatase)
			testDA.open();
			ev = testDA.addEventWithQuestion(eventText,oneDate,"query2", betMinimum);
			testDA.close();			
			
			//invoke System Under Test (sut)  
			boolean q=sut.gertaerakKopiatu(ev, twoDate);
			
			
			//verify the results
			assertTrue(!q);
			
			
			//q is DB
			//testDA.open();
			//boolean exist = testDA.existQuestion(ev,q);
				
			//assertTrue(exist);
			//testDA.close();
			
		   } catch (Exception e) {
			// TODO Auto-generated catch block
			// if the program goes to this point fail  
			fail();
			} finally {
				  //Remove the created objects in the database (cascade removing)   
				testDA.open();
		          boolean b=testDA.removeEvent(ev);
		          testDA.close();
		      //     System.out.println("Finally "+b);          
		        }
		   }
}

