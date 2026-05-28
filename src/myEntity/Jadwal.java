
package myEntity;

public class Jadwal {
        private String id_jadwal,id_bahasa,hari,waktu,kelas;
        
    public String getId_jadwal() {
        return id_jadwal;
    }

    public void setId_jadwal(String id_jadwal) {
        this.id_jadwal = id_jadwal;
    }

    public String getId_bahasa() {
        return id_bahasa;
    }

    public void setId_bahasa(String id_bahasa) {
        this.id_bahasa = id_bahasa;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public String getWaktu() {
        return waktu;
    }

    public void setWaktu(String waktu) {
        this.waktu = waktu;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
    public Jadwal (String id_jadwal, String id_bahasa, String hari, String waktu, String kelas){
        this.id_jadwal = id_jadwal;
        this.id_bahasa = id_bahasa;
        this.hari = hari;
        this.waktu= waktu;
        this.kelas = kelas;
        
    } 
    public Jadwal(){
        
    };
}
