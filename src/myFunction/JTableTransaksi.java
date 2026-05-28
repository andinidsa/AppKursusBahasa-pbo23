
package myFunction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import myEntity.Transaksi;

public class JTableTransaksi  extends AbstractTableModel {
    List<Transaksi> list = new ArrayList<>();
    
    public void add (Transaksi trans)
    {
        list.add(trans);
        fireTableRowsInserted(getRowCount(), getColumnCount());
    }
    @Override
    public int getRowCount()
    {
        return list.size();
    }
    @Override
    public int getColumnCount()
    {
        return 5;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        switch (columnIndex)
        {
            case 0 : return list.get(rowIndex).getId_Transaksi();
            case 1 : return list.get(rowIndex).getId_Anggota();
            case 2 : return list.get(rowIndex).getTgl_Transaksi();
            case 3 : return list.get(rowIndex).getNominal();
            case 4 : return list.get(rowIndex).getKeterangan();
            
            default : return null;
        }
    }
    @Override
    public String getColumnName (int column)
    {
        switch (column)
        {
            case 0 : return "Id Transaksi";
            case 1 : return "Id Anggota";
            case 2 : return "Tanggal";
            case 3 : return "Nominal";
            case 4 : return "Keterangan";
            default : return null;
        }
    }
    public void removeRow (int i, int l)
    {
        list.remove(i);
        fireTableRowsDeleted(i,l);
    }
}
