import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Question;
import exceptions.EventFinished;
import exceptions.QuestionAlreadyExist;

import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class RankingLortuMockInt {
     DataAccess dataAccess=Mockito.mock(DataAccess.class);
     Event mockedEvent=Mockito.mock(Event.class);
	
	@InjectMocks
	 BLFacade sut=new BLFacadeImplementation(dataAccess);
	

	
	@Test
	//sut.rankingLortu:  The database has no registered users
	public void test1() {
				//define paramaters
				
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	@Test
	//sut.rankingLortu:  The database has one registered user
	public void test2() {
				//define paramaters
				
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	
	@Test
	//sut.rankingLortu:  The database has 3 registered users _________
	public void test3() {
				//define paramaters
				
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
	
	@Test
	//sut.rankingLortu:  The database has 3 registered users ____________
	public void test4() {
				//define paramaters
				
				//configure Mock
				

				//invoke System Under Test (sut) 
				
				//verify the results
				//Mockito.verify(dataAccess,Mockito.times(1)).createQuestion(Mockito.any(Event.class),Mockito.any(String.class), Mockito.any(Integer.class));
				
	}
}
