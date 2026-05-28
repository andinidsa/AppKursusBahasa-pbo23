package myEntity;

public class Tutor {
         private String id_tutor,id_bahasa,nama_tutor,alamat,noHP;
    public String getId_tutor() {
        return id_tutor;
    }

    public void setId_tutor(String id_tutor) {
        this.id_tutor = id_tutor;
    }

    public String getId_bahasa() {
        return id_bahasa;
    }

    public void setId_bahasa(String id_bahasa) {
        this.id_bahasa = id_bahasa;
    }

    public String getNama_tutor() {
        return nama_tutor;
    }

    public void setNama_tutor(String nama_tutor) {
        this.nama_tutor = nama_tutor;
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
    public Tutor (String id_tutor, String id_bahasa, String nama_tutor, String alamat, String noHP){
        this.id_tutor = id_tutor;
        this.id_bahasa = id_bahasa;
        this.nama_tutor = nama_tutor;
        this.alamat = alamat;
        this.noHP = noHP;
}
    public Tutor(){ 
    };
}
