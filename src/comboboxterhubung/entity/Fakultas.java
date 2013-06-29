package comboboxterhubung.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="fakultas")
public class Fakultas {
    @Id
    @Column(name="id_fakultas")
    private String idFakultas;
    
    @Column(name="nama_fakultas")
    private String namaFakultas;
    
    @OneToMany(mappedBy = "fakultas")
    private List<Jurusan> jurusans=new ArrayList<Jurusan>();

    public String getIdFakultas() {
        return idFakultas;
    }

    public void setIdFakultas(String idFakultas) {
        this.idFakultas = idFakultas;
    }

    public String getNamaFakultas() {
        return namaFakultas;
    }

    public void setNamaFakultas(String namaFakultas) {
        this.namaFakultas = namaFakultas;
    }

    public List<Jurusan> getJurusans() {
        return jurusans;
    }

    public void setJurusans(List<Jurusan> jurusans) {
        this.jurusans = jurusans;
    }

    @Override
    public String toString() {
        return  namaFakultas;
    }
    
    
}
