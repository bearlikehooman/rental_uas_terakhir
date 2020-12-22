package Main;

import java.util.List;
import javax.swing.table.AbstractTableModel;

class CDTableModel extends AbstractTableModel{
	private static final int CD_TITLE_COL = 0;
	private static final int QTY_COL = 1;
	private static final int PRICE_COL = 2;
	private static final int STATUS_COL = 3;

	private String[] columnNames = { "CD's Name", "Quantity", "Price", "Status" };
	private List<CD> cds;

	public CDTableModel(List<CD> theCDs) {
		cds = theCDs;
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return cds.size();
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {

		CD tempCD = cds.get(row);

		switch (col) {
		case CD_TITLE_COL:
			return tempCD.getname();
		case QTY_COL:
			return tempCD.getqty();
		case PRICE_COL:
			return tempCD.getprice();
		case STATUS_COL:
			return tempCD.getstatus();
		default:
			return tempCD.getname();
		}
	}

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
