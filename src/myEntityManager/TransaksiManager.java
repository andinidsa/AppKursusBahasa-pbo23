package myEntityManager;
import myEntity.Transaksi;
import myFunction.Fungsi;
public class TransaksiManager {
    int i;
   
    public int inputData (Transaksi trans)
    {
        i = 0;
        try
        {
            String sql = "insert into transaksi(id_transaksi,id_anggota,tgl_transaksi,nominal,keterangan)"
                    + "values('"+trans.getId_Transaksi()+"','"+trans.getId_Anggota()+"','"+trans.getTgl_Transaksi()+"','"+
                    trans.getNominal()+"','"+trans.getKeterangan()+"')";
            
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
        String sql = "DELETE FROM transaksi WHERE id_transaksi = '" + ID + "'";
        int result = Fungsi.EQuery(sql);
        return result;
    } catch (Exception e) {
        e.printStackTrace();  // Print the exception details for debugging
        return 0;  // Return 0 to indicate failure
    }
}

    public int ubahData (Transaksi trans)
    {
        i = 0;
        try
        {
            String tgl = "UPDATE transaksi SET tgl_transaksi = '"+ trans.getTgl_Transaksi()+"'where id_transaksi = '"+trans.getId_Transaksi()+"'";
            String nominal = "UPDATE transaksi SET nominal = '"+ trans.getNominal()+"'where id_transaksi = '"+trans.getId_Transaksi()+"'";
            String ket = "UPDATE transaksi SET keterangan = '"+ trans.getKeterangan()+"'where id_transaksi = '"+trans.getId_Transaksi()+"'";

            i = Fungsi.EQuery(tgl);
            i = Fungsi.EQuery(nominal);
            i = Fungsi.EQuery(ket);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }

}
