/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myEntityManager;

import myEntity.Jadwal;
import myFunction.Fungsi;

public class JadwalManager {
    int i;
    public int inputData (Jadwal jad)
    {
     i = 0;
        try
        {
            String sql = "insert into Jadwal (id_jadwal,id_bahasa,hari,waktu,kelas) values ('"+jad.getId_jadwal()+"','"+
                    jad.getId_bahasa()+"','"+jad.getHari()+"','"+jad.getWaktu()+"','"+jad.getKelas()+"')";
            
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
            String sql = "DELETE FROM jadwal WHERE id_jadwal = '" + ID + "'";
            int result = Fungsi.EQuery(sql);
            return result;
        } catch (Exception e) {
            e.printStackTrace();  // Print the exception details for debugging
            return 0;  // Return 0 to indicate failure
        }
    }
    public int ubahData (Jadwal jad)
    {
        i = 0;
        try
        {
            String hari = "UPDATE jadwal SET hari = '"+ jad.getHari()+"'where id_jadwal = '"+jad.getId_jadwal()+"'";
            String wkt = "UPDATE jadwal SET waktu = '"+ jad.getWaktu()+"'where id_jadwal = '"+jad.getId_jadwal()+"'";
            String kls = "UPDATE jadwal SET kelas = '"+ jad.getKelas()+"'where id_jadwal = '"+jad.getId_jadwal()+"'";

           i = Fungsi.EQuery(hari);
           i = Fungsi.EQuery(wkt);
           i = Fungsi.EQuery(kls);
            return i;
        }
        catch (Exception e)
        {
            return i;
        }
    }
}

