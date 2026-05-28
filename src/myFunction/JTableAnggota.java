
package myFunction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import myEntity.Anggota;

public class JTableAnggota extends AbstractTableModel {
    List<Anggota> list = new ArrayList<>();
    
    public void add (Anggota anggo)
    {
        list.add(anggo);
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
        return 6;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        switch (columnIndex)
        {
            case 0 : return list.get(rowIndex).getId_anggota();
            case 1 : return list.get(rowIndex).getId_bahasa();
            case 2 : return list.get(rowIndex).getId_jadwal();
            case 3 : return list.get(rowIndex).getNama_anggota();
            case 4 : return list.get(rowIndex).getAlamat();
            case 5 : return list.get(rowIndex).getNoHP();
            
            default : return null;
        }
    }
    @Override
    public String getColumnName (int column)
    {
        switch (column)
        {
            case 0 : return "Id Anggota";
            case 1 : return "Id Bahasa";
            case 2 : return "Id Jadwal";
            case 3 : return "Nama Anggota";
            case 4 : return "Alamat";
            case 5 : return "NoHP";
            default : return null;
        }
    }
    public void removeRow (int i, int l)
    {
        list.remove(i);
        fireTableRowsDeleted(i,l);
    }
}
