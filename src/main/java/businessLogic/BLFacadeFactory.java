package businessLogic;

import java.net.URL;
import java.util.Locale;

import javax.xml.namespace.QName;
import configuration.ConfigXML;
import dataAccess.DataAccess;
import javax.xml.ws.Service;


public class BLFacadeFactory {

	public BLFacade createBLFacade(int type, Object... params) throws Exception{
		ConfigXML c=ConfigXML.getInstance();
		
		System.out.println(c.getLocale());
		
		Locale.setDefault(new Locale(c.getLocale()));
		
		System.out.println("Locale: "+Locale.getDefault());
		
		switch (type) {
		case 1:
			DataAccess da= new DataAccess(c.getDataBaseOpenMode().equals("initialize"));
			return new BLFacadeImplementation(da);
		case 2:
			String serviceName= "http://"+c.getBusinessLogicNode() +":"+ c.getBusinessLogicPort()+"/ws/"+c.getBusinessLogicName()+"?wsdl";

			//URL url = new URL("http://localhost:9999/ws/ruralHouses?wsdl");
			URL url = new URL(serviceName);

			//1st argument refers to wsdl document above
			//2nd argument is service name, refer to wsdl document above
			QName qname = new QName("http://businessLogic/", "BLFacadeImplementationService");

			Service service = Service.create(url, qname);

			return service.getPort(BLFacade.class);
		default:
			return null;
		}
	}

}
