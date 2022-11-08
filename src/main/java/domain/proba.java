package domain;


import java.util.ArrayList;


import businessLogic.BLFacade;
import businessLogic.BLFacadeFactory;

public class proba {

	public static void main(String[] args) {
		BLFacadeFactory blf = new BLFacadeFactory();
		try {
			BLFacade facadeInterface;
			facadeInterface = blf.createBLFacade(1);
			ExtendedIterator<Event> i=new ExtendedIterator<Event>((ArrayList<Event>)facadeInterface.getEventsAll());
			Event ev;
			System.out.println("Prueba");
		 	i.goLast();
			while (i.hasPrevious()){
				ev=i.previous();
				System.out.println(ev.toString());
			}
			 //Nahiz eta suposatu hasierara ailegatu garela, eragiketa egiten dugu. 
			i.goFirst();
			while (i.hasNext()){
				ev=i.next();
				System.out.println(ev.toString());
			}
			}catch (Exception e) {
		}
		
	}
}
