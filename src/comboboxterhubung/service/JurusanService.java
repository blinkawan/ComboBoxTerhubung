package comboboxterhubung.service;

import comboboxterhubung.entity.Jurusan;
import java.util.List;

public interface JurusanService {
    public List<Jurusan> getJurusanByFakultas(String kodeFakultas);
}
