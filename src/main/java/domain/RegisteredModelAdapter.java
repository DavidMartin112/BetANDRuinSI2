package domain;

import javax.swing.table.AbstractTableModel;

public class RegisteredModelAdapter extends AbstractTableModel{

	private Registered user;
	private String[] colNames = new String[] {"Event", "Question", "Event Date", "Bet(€)"};
	public RegisteredModelAdapter(Registered r) {
		this.user=r;
	}
	@Override
	public Object getValueAt(int row, int col) {
	      Object temp = null;
	      if (col == 0) {
	         temp = user.getTransakzioak().get(row).getMota();
	      }
	      else if (col == 1) {
		     temp = user.getTransakzioak().get(row).getData();
	      }
	      else if (col == 2) {
			     temp = user.getTransakzioak().get(row).getDirua();
	      }
	      return temp;
	}
	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}
	@Override
	public int getColumnCount() {
		return 3;
	}
	@Override
	public int getRowCount() {
		return user.getTransakzioak().size();
	}
}
