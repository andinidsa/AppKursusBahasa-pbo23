
package myEntity;

public class Transaksi {
    private String id_transaksi, id_anggota, tgl_transaksi,nominal,keterangan;
    public String getId_Transaksi() {
        return id_transaksi;
    }

    public void setId_Transaksi(String id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public String getId_Anggota() {
        return id_anggota;
    }

    public void setId_Anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getTgl_Transaksi() {
        return tgl_transaksi;
    }

    public void setTgl_Transaksi(String tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public String getNominal() {
        return nominal;
    }

    public void setNominal(String nominal) {
        this.nominal = nominal;
    }
     public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
    public Transaksi (String id_transaksi, String id_anggota,String tgl_transaksi, String nominal, String keterangan){
        this.id_transaksi = id_transaksi;
        this.id_anggota = id_anggota;
        this.tgl_transaksi = tgl_transaksi;
        this.nominal = nominal;  
        this.keterangan = keterangan;
    } 
    public Transaksi(){
        
    };
}
