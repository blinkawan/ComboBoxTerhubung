package comboboxterhubung.service;

import comboboxterhubung.entity.Jurusan;
import comboboxterhubung.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class JurusanServiceImplHibernate implements JurusanService {

    @Override
    public List<Jurusan> getJurusanByFakultas(String kodeFakultas) {
        Session session=HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("select j from Jurusan j where j.fakultas.idFakultas=:kodeFakultas")
                .setParameter("kodeFakultas", kodeFakultas).list();
    }
    
}
