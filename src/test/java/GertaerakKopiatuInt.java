import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import businessLogic.BLFacadeImplementation;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import domain.Event;
import test.businessLogic.TestFacadeImplementation;

public class GertaerakKopiatuInt {
	static BLFacadeImplementation sut;
	 static TestFacadeImplementation testBL;

	private Event ev;

	@Before
	public  void setUp() throws Exception {
		sut= new BLFacadeImplementation();
		
		DataAccess da= new DataAccess(ConfigXML.getInstance().getDataBaseOpenMode().equals("initialize"));
		//DataAccess da= new DataAccess();
		sut=new BLFacadeImplementation(da);
		testBL= new TestFacadeImplementation();
	}

	//Event galdera eta kuotarekin existitzen da databasean eta data berri batera kopiatuko dugu 
		@Test
		public void test1() {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			Date oneDate=null;
			Date twoDate=new Date();
			try {
				oneDate = sdf.parse("05/10/2022");
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			try {
				
				ev = testBL.addEventWithQuestionAndQuote("Manolo-Fernanda",oneDate,"query2", 3,678);
				boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
				assertTrue(emaitza);
			}catch(Exception e) {
				fail();
			}finally {
				testBL.removeEvent(ev);
			}
		}
		 //Event galderakinn existitzen da databasean eta data berri batera kopiatuko dugu 
			@Test
			public void test2() {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date oneDate=null;
				Date twoDate=new Date();
				try {
					oneDate = sdf.parse("05/10/2022");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				try {
					
					ev = testBL.addEventWithQuestion("Manolo-Fernanda",oneDate,"query2", 3);
					boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
					assertTrue(emaitza);
				}catch(Exception e) {
					fail();
				}finally {
					testBL.removeEvent(ev);
				}
			}
			 //Event existitzen da databasean eta data berri batera kopiatuko dugu 
			@Test
			public void test3() {
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				Date oneDate=null;
				Date twoDate=new Date();
				try {
					oneDate = sdf.parse("05/10/2022");
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				try {
					
					ev = testBL.addEvent("Manolo-Fernanda",oneDate);
					boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
					assertTrue(emaitza);
				}catch(Exception e) {
					fail();
				}finally {
					testBL.removeEvent(ev);
				}
			}
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
				try {
					
					ev = testBL.addEventWithQuestionAndQuote("Manolo-Manolete",oneDate,"query2", 3,12);
				
					boolean emaitza= sut.gertaerakKopiatu(ev, oneDate);
					assertTrue(!emaitza);
				}catch(Exception e) {
					fail();
				}finally {
			        boolean b=testBL.removeEvent(ev);
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
