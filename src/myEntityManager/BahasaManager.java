package myEntityManager;
import myEntity.Bahasa;
import myFunction.Fungsi;

public class BahasaManager {
    int i;
    
    public int inputData (Bahasa bhs)
    {
        i = 0;
        try
        {
            String sql = "insert into Bahasa (id_bahasa,nama_bahasa) values ('"+bhs.getId_bahasa()+"','"+
                    bhs.getNama_bahasa()+"')";  
            
        i = Fungsi.EQuery(sql);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }
    
    public int hapusData (int ID)
    {
        i = 0;
        try
        {
            String sql = "delete from bahasa where id_bahasa = "+ID+"";
            i = Fungsi.EQuery(sql);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }
}
