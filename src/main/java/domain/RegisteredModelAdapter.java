package domain;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

public class RegisteredModelAdapter extends AbstractTableModel{
	private Registered user;
	private String[] colNames = new String[] {"Event", "Event Date", "Question", "Bet(€)"};
	private ArrayList<Apustua> allBets;
	public RegisteredModelAdapter(Registered r) {
		this.user=r;
		allBets = new ArrayList<Apustua>();
		for(ApustuAnitza a : user.getApustuAnitzak()) {
			allBets.addAll(a.getApustuak());
		}
	}	
	@Override
	public Object getValueAt(int row, int col) {
	      Object temp = null;
	      if (col == 0) {
	         temp = allBets.get(row).getKuota().getQuestion().getEvent().getDescription();
	      }
	      else if (col == 1) {
		     temp = allBets.get(row).getApustuAnitza().getData();
	      }
	      else if (col == 2) {
		         temp = allBets.get(row).getKuota().getQuestion().getQuestion();
	      }
	      else if (col == 3) {
		         temp = allBets.get(row).getApustuAnitza().getBalioa();
	      }
	      if(temp == null) temp = "Hutsa";
	      return temp;
	}
	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}
	@Override
	public int getColumnCount() {
		return 4;
	}
	@Override
	public int getRowCount() {
		return allBets.size();
	}
}
