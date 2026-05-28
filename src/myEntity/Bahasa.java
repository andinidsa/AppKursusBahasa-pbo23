
package myEntity;

public class Bahasa {
     private String id_bahasa, nama_bahasa;

    public String getId_bahasa() {
        return id_bahasa;
    }

    public void setId_bahasa(String id_bahasa) {
        this.id_bahasa = id_bahasa;
    }

    public String getNama_bahasa() {
        return nama_bahasa;
    }

    public void setNama_bahasa(String nama_bahasa) {
        this.nama_bahasa = nama_bahasa;
    }
public Bahasa (String id_bahasa, String nama_bahasa){
        this.id_bahasa = id_bahasa;
        this.nama_bahasa = nama_bahasa;
}

public Bahasa(){}
}
