package comboboxterhubung.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="jurusan")
public class Jurusan {
    @Id
    @Column(name="id_jurusan")
    private String idJurusan;
    
    @Column(name="nama_jurusan")
    private String namaJurusan;
    
    @JoinColumn(name="id_fakultas")
    @ManyToOne
    private Fakultas fakultas;

    public String getIdJurusan() {
        return idJurusan;
    }

    public void setIdJurusan(String idJurusan) {
        this.idJurusan = idJurusan;
    }

    public String getNamaJurusan() {
        return namaJurusan;
    }

    public void setNamaJurusan(String namaJurusan) {
        this.namaJurusan = namaJurusan;
    }

    public Fakultas getFakultas() {
        return fakultas;
    }

    public void setFakultas(Fakultas fakultas) {
        this.fakultas = fakultas;
    }

    @Override
    public String toString() {
        return  namaJurusan;
    }
    
    
}
