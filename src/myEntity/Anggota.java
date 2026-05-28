
package myEntity;

public class Anggota {
    private String id_anggota, id_bahasa,id_jadwal, nama_anggota,alamat, noHP;
   
    public String getId_anggota() {
        return id_anggota;
    }

    public void setId_anggota(String id_anggota) {
        this.id_anggota = id_anggota;
    }

    public String getId_bahasa() {
        return id_bahasa;
    }

    public void setId_bahasa(String id_bahasa) {
        this.id_bahasa = id_bahasa;
    }

    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getNama_anggota() {
        return nama_anggota;
    }

    public void setNama_anggota(String nama_anggota) {
        this.nama_anggota = nama_anggota;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getNoHP() {
        return noHP;
    }

    public void setNoHP(String noHP) {
        this.noHP = noHP;
    }

public Anggota(String id_anggota, String id_bahasa,String id_jadwal,String nama_anggota, String alamat, String noHP){
        this.id_anggota = id_anggota;
        this.id_bahasa = id_bahasa;
        this.id_jadwal = id_jadwal;
        this.nama_anggota = nama_anggota;
        this.alamat = alamat;
        this.noHP = noHP;
    } 
    public Anggota(){
        
    };
}