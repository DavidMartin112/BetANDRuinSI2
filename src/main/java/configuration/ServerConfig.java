package configuration;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.Endpoint;

import businessLogic.BLFacade;
import businessLogic.BLFacadeImplementation;
import businessLogic.BusinessLogicServer;

public class ServerConfig extends JDialog{
	
	public ServerConfig() {}
	
	//whichServer==true BusinessLogic, false ObjectdbManager
	public void configureContentPane(JPanel contentPanel, boolean whichServer) {
		if(whichServer) {
			setTitle("BusinessLogicServer: running the business logic");
		}else {
			setTitle("objectDBManagerServer: running the database server");
		}
	
		setBounds(100, 100, 486, 209);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
	
	}
	
	
	public void configureTextArea(JPanel contentPanel, JTextArea textArea) {

		textArea = new JTextArea();
		contentPanel.add(textArea);
	}
	public JPanel configureJPanel() {
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		return buttonPane;
	}
	
}
