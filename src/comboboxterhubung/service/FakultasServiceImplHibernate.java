package comboboxterhubung.service;

import comboboxterhubung.entity.Fakultas;
import comboboxterhubung.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

public class FakultasServiceImplHibernate implements FakultasService {

    @Override
    public List<Fakultas> getAllFakultas() {
        Session session=HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("select f from Fakultas f").list();
    }
    
}
