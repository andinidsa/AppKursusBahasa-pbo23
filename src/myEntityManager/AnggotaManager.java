
package myEntityManager;
import myEntity.Anggota;
import myFunction.Fungsi;

public class AnggotaManager {
    int i;
   
    public int inputData (Anggota anggo)
    {
        i = 0;
        try
        {
            String sql = "insert into anggota(id_anggota,id_bahasa,id_jadwal,nama_anggota,alamat,noHP)"
                    + "values('"+anggo.getId_anggota()+"','"+anggo.getId_bahasa()+"','"+anggo.getId_jadwal()+"','"+anggo.getNama_anggota()+"','"+
                    anggo.getAlamat()+"','"+anggo.getNoHP()+"')";
            
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
            String sql = "delete from anggota where id_anggota = "+ID+"";
            i = Fungsi.EQuery(sql);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }
    public int ubahData (Anggota anggo)
    {
        i = 0;
        try
        {
            String nama = "UPDATE anggota SET nama_anggota = '"+ anggo.getNama_anggota()+"'where id_anggota = '"+anggo.getId_anggota()+"'";
            String alamat = "UPDATE anggota SET alamat = '"+ anggo.getAlamat()+"'where id_anggota = '"+anggo.getId_anggota()+"'";
            String hp = "UPDATE anggota SET noHP = '"+ anggo.getNoHP()+"'where id_anggota = '"+anggo.getId_anggota()+"'";

           i = Fungsi.EQuery(nama);
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

