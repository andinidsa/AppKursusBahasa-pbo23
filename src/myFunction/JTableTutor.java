
package myFunction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import myEntity.Tutor;

public class JTableTutor extends AbstractTableModel {
    List<Tutor> list = new ArrayList<>();
    
    public void add (Tutor tr)
    {
        list.add(tr);
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
            case 0 : return list.get(rowIndex).getId_tutor();
            case 1 : return list.get(rowIndex).getId_bahasa();
            case 2 : return list.get(rowIndex).getNama_tutor();
            case 3 : return list.get(rowIndex).getAlamat();
            case 4 : return list.get(rowIndex).getNoHP();
            
            default : return null;
        }
    }
    @Override
    public String getColumnName (int column)
    {
        switch (column)
        {
            case 0 : return "Id Tutor";
            case 1 : return "Id Bahasa";
            case 2 : return "Nama Tutor";
            case 3 : return "Alamat";
            case 4 : return "No HP";
            default : return null;
        }
    }
    public void removeRow (int i, int l)
    {
        list.remove(i);
        fireTableRowsDeleted(i,l);
    }
}
