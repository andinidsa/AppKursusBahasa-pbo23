
package myFunction;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import myEntity.Bahasa;

public class JTableBahasa extends AbstractTableModel{
    List<Bahasa> list = new ArrayList<>();
    
    public void add (Bahasa bhs)
    {
        list.add(bhs);
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
        return 2;
    }
    @Override
    public Object getValueAt (int rowIndex, int columnIndex){
        switch (columnIndex)
        {
            case 0 : return list.get(rowIndex).getId_bahasa();
            case 1 : return list.get(rowIndex).getNama_bahasa();
            
            default : return null;
        }
    }
    @Override
    public String getColumnName (int column)
    {
        switch (column)
        {
            case 0 : return "Id Bahasa";
            case 1 : return "Nama Bahasa";
            
            default : return null;
        }
    }
    public void removeRow (int i, int l)
    {
        list.remove(i);
        fireTableRowsDeleted(i,l);
    }
}
