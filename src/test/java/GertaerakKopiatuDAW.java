import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import dataAccess.DataAccess;
import domain.Event;
import test.dataAccess.TestDataAccess;

public class GertaerakKopiatuDAW {
	//sut:system under test
	 static DataAccess sut=new DataAccess();
	 
	 //additional operations needed to execute the test 
	 static TestDataAccess testDA=new TestDataAccess();
	 
	 private Event ev;
	 //!query.getResultList().isEmpty()	
	 @Test
		public void test1() {
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
	 //query.getResultList().isEmpty() && gertaera.getQuestions().isEmpty()
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
				sut.open(true);
				testDA.open();
				ev = testDA.addEvent("Manolo-Fernanda",oneDate);
				boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
				assertTrue(emaitza);
			}catch(Exception e) {
				fail();
			}finally {
				testDA.removeEvent(ev);
		        testDA.close();
		        sut.close();
			}
	 }
	//query.getResultList().isEmpty() && !gertaera.getQuestions().isEmpty && galdera.getQuotes().isEmpty()
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
				sut.open(true);
				testDA.open();
				ev = testDA.addEventWithQuestion("Manolo-Fernanda",oneDate,"query2", 3);
				boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
				assertTrue(emaitza);
			}catch(Exception e) {
				fail();
			}finally {
				testDA.removeEvent(ev);
		        testDA.close();
		        sut.close();
			}
	 }
	 //query.getResultList().isEmpty() && !gertaera.getQuestions().isEmpty() && !galdera.getQuotes().isEmpty()
	 @Test
	 public void test4() {
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
				sut.open(true);
				testDA.open();
				ev = testDA.addEventWithQuestionAndQuote("Manolo-Fernanda",oneDate,"query2", 3,678);
				boolean emaitza= sut.gertaerakKopiatu(ev, twoDate);
				assertTrue(emaitza);
			}catch(Exception e) {
				fail();
			}finally {
				testDA.removeEvent(ev);
		        testDA.close();
		        sut.close();
			}
	 }

}
