import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Calendar;
import java.util.Date;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import configuration.UtilDate;

import org.junit.After;
import org.junit.AfterClass;

import dataAccess.DataAccess;
import domain.Sport;
import test.dataAccess.TestDataAccess;

public class gertaeraSortuDABTest {
	 	//sut:system under test
	 	static DataAccess sut=new DataAccess();
	 
		@Before
		public void before() {
			sut.open(true);//Initializes empty db
		}
		@After
		public void after() {
			sut.close();
		}

		@Test
		//The sport is not in the database
		public void test1() {
			//define paramaters
			String sport="F1";
			Date date= UtilDate.newDate(2022,10,9);
			String description= "Japan GP";
			
			boolean result=true;//False expected
			
			//configure the state of the system (create object in the dabatase)
			sut.gertaerakSortu("Valencia-Madrid", new Date(), "Futbol");
			
			//invoke System Under Test (sut) 
			try {
				result=sut.gertaerakSortu(description, date, sport);
				
			} catch(Exception e) {
				e.printStackTrace();
				fail();
			}
			//verify the results
			assertTrue(!result);
			
		}
		@Test
		public void test2() {
			//define paramaters
			String sport="Futbol";
			Date date= UtilDate.newDate(2022,10,9);
			String description= "Valencia-Madrid";
			
			boolean result=true;//False expected
			
			//configure the state of the system (create object in the dabatase)
			sut.gertaerakSortu(description, date, sport);
			
			//invoke System Under Test (sut) 
			try {
				
				result=sut.gertaerakSortu(description, date, sport);
				
			} catch(Exception e) {
				fail();
			}
			//verify the results
			assertTrue(!result);
			
		}
		@Test
		public void test3() {
			//define paramaters
			String sport="Futbol";
			Date date= UtilDate.newDate(2022,10,9);
			String description= "Valencia-Madrid";
			Date dateBefore=UtilDate.newDate(2020,1,9);
			
			boolean result=false;//True expected
			
			//configure the state of the system (create object in the dabatase)
			sut.gertaerakSortu(description, date, sport);
			
			//invoke System Under Test (sut) 
			try {
				
				result=sut.gertaerakSortu(description, dateBefore, sport);
				
			} catch(Exception e) {
				fail();
			}
			//verify the results
			assertTrue(result);
			
		}
		@Test
		public void test4() {
			//define paramaters
			String sport="Futbol";
			Date date= UtilDate.newDate(2022,10,9);
			String description="Valencia-Madrid"; 
			
			
			boolean result=false;//True expected
			
			//configure the state of the system (create object in the dabatase)
			sut.gertaerakSortu("Ponferradina-Elche", date, sport);
			
			//invoke System Under Test (sut) 
			try {
				
				result=sut.gertaerakSortu(description, date, sport);
				
			} catch(Exception e) {
				fail();
			}
			//verify the results
			assertTrue(result);
			}
}
