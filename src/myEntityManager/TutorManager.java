package myEntityManager;
import myEntity.Tutor;
import myFunction.Fungsi;
public class TutorManager {
    int i;
    
    public int inputData (Tutor tr)
    {
        i = 0;
        try
        {
            String sql = "insert into tutor (id_tutor,id_bahasa,nama_tutor,alamat,noHP)"
                    + "values('"+tr.getId_tutor()+"','"+tr.getId_bahasa()+"','"+tr.getNama_tutor()+"','"+
                    tr.getAlamat()+"','"+tr.getNoHP()+"')";
            
        i = Fungsi.EQuery(sql);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }
    
    public int hapusData(String ID) {
        try {
            String sql = "DELETE FROM tutor WHERE id_tutor = '" + ID + "'";
            int result = Fungsi.EQuery(sql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception details for debugging
            return 0;  // Return 0 to indicate failure
        }
    }

         public int ubahData (Tutor tr)
    {
        i = 0;
        try
        {
            String alamat = "UPDATE tutor SET alamat = '"+ tr.getAlamat()+"'where id_tutor = '"+tr.getId_tutor()+"'";
            String hp = "UPDATE tutor SET noHP = '"+ tr.getNoHP()+"'where id_tutor = '"+tr.getId_tutor()+"'";

           i = Fungsi.EQuery(alamat);
           i = Fungsi.EQuery(hp);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }
 }
 
    
