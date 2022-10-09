import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import domain.Quote;

@RunWith(MockitoJUnitRunner.class)
public class GertaerakKopiatuMockInt {
	
	 DataAccess dataAccess=Mockito.mock(DataAccess.class);
     Event mockedEvent=Mockito.mock(Event.class);
     Question mockedQuestion=Mockito.mock(Question.class);
     Quote mockedQuote=Mockito.mock(Quote.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dataAccess);
	
	@Test
	//Event galdera eta kuotarekin existitzen da databasean eta data berri batera kopiatuko dugu 
	public void test1() {
		//define paramaters
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
		//configure Mock
		Mockito.doReturn(oneDate).when(mockedEvent).getEventDate();
		Mockito.doReturn(mockedEvent).when(mockedQuestion).getEvent();
		Mockito.doReturn(mockedQuestion).when(mockedQuote).getQuestion();
		Mockito.doReturn(true).when(dataAccess).gertaerakKopiatu(Mockito.any(Event.class), Mockito.any(Date.class));
		//Mockito.doReturn(false).when(dataAccess).gertaerakKopiatu(Mockito.any(Event.class), oneDate);
		Mockito.doReturn(new Vector<Question>()).when(mockedEvent).getQuestions();
		Mockito.doReturn(new Vector<Quote>()).when(mockedQuestion).getQuotes();
		
		//invoke System Under Test (sut) 
		boolean emaitza= sut.gertaerakKopiatu(mockedEvent, twoDate);
				
		//verify the results
		ArgumentCaptor<Event> eventCaptor = ArgumentCaptor.forClass(Event.class);
		ArgumentCaptor<Date> dateCaptor = ArgumentCaptor.forClass(Date.class);
		
		Mockito.verify(dataAccess,Mockito.times(1)).gertaerakKopiatu(Mockito.any(Event.class),Mockito.any(Date.class));
		//assertEquals(eventCaptor.getValue(),mockedEvent);
		assertEquals(dateCaptor.getValue(),twoDate);
		assertTrue(emaitza);
		}catch(Exception e) {
			fail();
		}
	}
	@Test
	 //Event galderakinn existitzen da databasean eta data berri batera kopiatuko dugu 
	public void test2() {
				//define paramaters
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	@Test
	 //Event existitzen da databasean eta data berri batera kopiatuko dugu 
	public void test3() {
				//define paramaters
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	@Test
	//Eventua datubasean dago baina data berdinerako kopiatzen saiatzean ez du kopiatuko
	public void test4() {
				//define paramaters
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	@Test
	//Event-a ez da existitzen databasean, ez da ezer kopiatuko
	public void test5() {
				//define paramaters
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	

}
