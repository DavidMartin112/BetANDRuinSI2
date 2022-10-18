import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import configuration.UtilDate;
import dataAccess.DataAccess;
import exceptions.EventFinished;


public class gertaeraSortuInt {
	 	//sut:system under test
		DataAccess da=new DataAccess(true);

		BLFacade sut=new BLFacadeImplementation(da);
	    
	    @Test
		//The sport is not in the database
		public void test1() {
			//define paramaters
			String sport="F1";
			Date date= UtilDate.newDate(2012,10,9);
			String description= "Japan GP";
			
			//configure the state of the system (create object in the dabatase)
			
			//invoke System Under Test (sut) 
			try {
				sut.gertaerakSortu(description, date, sport);
				fail();
			} catch(EventFinished e) {
				assertTrue(true);
			} catch(Exception e) {
				fail();
			}
			
		}
	    
		@Test
		//The sport is not in the database
		public void test2() {
			//define paramaters
			String sport="F1";
			Date date= UtilDate.newDate(2023,10,9);
			String description= "Japan GP";
			
			boolean result=true;//False expected
			//configure the state of the system (create object in the dabatase)
			//invoke System Under Test (sut) 
			try {
				result=sut.gertaerakSortu(description, date, sport);
			} catch(Exception e) {
				fail();
			}
			//verify the result
			assertTrue(!result);
		}
		@Test
		public void test3() {
			//define paramaters
			String sport="Futbol";
			Date date= UtilDate.newDate(2023,10,9);
			String description= "Valencia-Madrid";
			
			boolean result=true;//False expected
			
			//configure the state of the system (create object in the dabatase
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
		public void test4() {
			//define paramaters
			String sport="Futbol";
			Date date= UtilDate.newDate(2023,10,9);
			String description= "Valencia-Madrid";

			
			boolean result=false;//True expected
			
			//configure the state of the system (create object in the dabatase
			
			//invoke System Under Test (sut) 
			try {
				
				result=sut.gertaerakSortu(description, date, sport);
				
			} catch(Exception e) {
				fail();
			}
			//verify the results
			assertTrue(result);
			
		}
		@Test
		public void test5() {
			//define paramaters
			String sport="Futbol";
			Date date= UtilDate.newDate(2023,10,9);
			String description="Valencia-Madrid"; 
			
			
			boolean result=false;//True expected
			
			//configure the state of the system (create object in the dabatase)

			
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
