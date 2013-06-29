package comboboxterhubung;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import comboboxterhubung.entity.Fakultas;
import comboboxterhubung.entity.Jurusan;
import comboboxterhubung.service.FakultasService;
import comboboxterhubung.service.FakultasServiceImplHibernate;
import comboboxterhubung.service.FakultasServiceImplJdbc;
import comboboxterhubung.service.JurusanService;
import comboboxterhubung.service.JurusanServiceImplHibernate;
import comboboxterhubung.service.JurusanServiceImplJdbc;
import comboboxterhubung.ui.MainFrame;
import comboboxterhubung.util.HibernateUtil;
import java.sql.SQLException;
import org.hibernate.Session;

public class Main {

    public static FakultasService fakultasService;
    public static JurusanService jurusanService;
    
    private static boolean JdbcMode= Boolean.TRUE;
    
    public static FakultasService getFakultasService(){
        return fakultasService;
    }
    
    public static JurusanService getJurusanService(){
        return jurusanService;
    }
    
    public static void main(String[] args) throws SQLException {
        
//        if(!JdbcMode){
//            fakultasService=new FakultasServiceImplHibernate();
//            jurusanService=new JurusanServiceImplHibernate();
//        }
//        else{
//            MysqlDataSource dataSource=new MysqlDataSource();
//            dataSource.setUser("root");
//            dataSource.setPassword("root");
//            dataSource.setDatabaseName("comboboxterhubung");
//            dataSource.setServerName("localhost");
//            
//            fakultasService=new FakultasServiceImplJdbc(dataSource.getConnection());
//            jurusanService=new JurusanServiceImplJdbc(dataSource.getConnection());
//        }
//        
//        
//        new MainFrame().setVisible(true);
        Session session=HibernateUtil.getSessionFactory().openSession();
        session.getTransaction().begin();
        
        Fakultas fakultas=new Fakultas();
        fakultas.setIdFakultas("fak-004");
        fakultas.setNamaFakultas("Fakultas Hukum");
        
        Jurusan jurusan=new Jurusan();
        jurusan.setIdJurusan("hukum-001");
        jurusan.setNamaJurusan("Hukum Publik");
        
        jurusan.setFakultas(fakultas);
        fakultas.getJurusans().add(jurusan);
        
        session.save(fakultas);
        session.save(jurusan);
        
        session.getTransaction().commit();
        session.close();
        System.out.println("Done");
    }
    
}
