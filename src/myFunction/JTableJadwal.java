
package myFunction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import myEntity.Jadwal;

public class JTableJadwal extends AbstractTableModel {
    List<Jadwal> list = new ArrayList<>();
    
    public void add (Jadwal jad)
    {
        list.add(jad);
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
            case 0 : return list.get(rowIndex).getId_jadwal();
            case 1 : return list.get(rowIndex).getId_bahasa();
            case 2 : return list.get(rowIndex).getHari();
            case 3 : return list.get(rowIndex).getWaktu();
            case 4 : return list.get(rowIndex).getKelas();
            
            default : return null;
        }
    }
    @Override
    public String getColumnName (int column)
    {
        switch (column)
        {
            case 0 : return "Id Jadwal";
            case 1 : return "Id Bahasa";
            case 2 : return "Hari";
            case 3 : return "Waktu";
            case 4 : return "Kelas";
          
            default : return null;
        }
    }
    public void removeRow (int i, int l)
    {
        list.remove(i);
        fireTableRowsDeleted(i,l);
    }
}
