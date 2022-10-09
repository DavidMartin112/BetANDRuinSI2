import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import dataAccess.DataAccess;
import domain.Event;
import domain.Registered;

@RunWith(MockitoJUnitRunner.class)
public class RankingLortuMockInt {
    DataAccess da=Mockito.mock(DataAccess.class);

    @InjectMocks
	 BLFacade sut=new BLFacadeImplementation(da);

	@Test
	//sut.rankingLortu: The list of registered users is empty. 
	public void test1() {
		try {		
			Mockito.doReturn(new ArrayList<Registered>()).when(da).rankingLortu();
			List<Registered> ema = sut.rankingLortu();
			Mockito.verify(da,Mockito.times(1)).rankingLortu();
			if(ema.isEmpty()) assertTrue(true);
		 } catch (Exception e) {
			fail("This shouldm't be reached");
		 }
	}
	@Test
	//sut.rankingLortu:  There is a registered user
	public void test2() {
		Registered david = new Registered("David", "1234", 5678);
		Double g = (double) 15;
		david.setIrabazitakoa(g);
		ArrayList<Registered> expected = new ArrayList<Registered>(); 
		expected.add(david);
		try {		
			Mockito.doReturn(expected).when(da).rankingLortu();
			List<Registered> ema = sut.rankingLortu();
			Mockito.verify(da,Mockito.times(1)).rankingLortu();
			if(ema.size()==1 && ema.get(0).equals(david)) assertTrue(true);
		} catch (Exception e) {
			fail();
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
			
			us1.setIrabazitakoa(g1);
			us2.setIrabazitakoa(g2);
			us3.setIrabazitakoa(g3);
			us4.setIrabazitakoa(g4);
			us5.setIrabazitakoa(g5);
			
			List<Registered> expected = new ArrayList<Registered>();
			
			expected.add(us2);
			expected.add(us3);
			expected.add(us4);
			expected.add(us1);			
			sut.rankingLortu();
			
			expected.clear();
			expected.add(us5);
			expected.add(us2);
			expected.add(us3);
			expected.add(us4);
			expected.add(us1);	
			Mockito.doReturn(expected).when(da).rankingLortu();
			
			List<Registered> ema = sut.rankingLortu();
			Mockito.verify(da,Mockito.times(2)).rankingLortu();
			if(ema.equals(expected)) assertTrue(true);
		} catch (Exception e) {
			fail();
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
			
			us1.setIrabazitakoa(g1);
			us2.setIrabazitakoa(g2);
			us3.setIrabazitakoa(g3);
			
			List<Registered> expected = new ArrayList<Registered>();
			expected.add(us1);
			expected.add(us2);
		
			Mockito.doReturn(expected).when(da).rankingLortu();
			sut.rankingLortu();
			Mockito.doReturn(expected).when(da).rankingLortu();
			expected.clear();
			expected.add(us1);
			expected.add(us3);
			expected.add(us2);
			
			List<Registered> ema = sut.rankingLortu();
			Mockito.verify(da,Mockito.times(2)).rankingLortu();
			if(ema.equals(expected)) assertTrue(true);
		} catch (Exception e) {
			fail();
		}
	}
}
