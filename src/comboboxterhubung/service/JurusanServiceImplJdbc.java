package comboboxterhubung.service;

import comboboxterhubung.entity.Jurusan;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JurusanServiceImplJdbc implements JurusanService {

    public Connection connection;
    public PreparedStatement preparedStatement;
    
    
    public JurusanServiceImplJdbc(Connection connection){
        this.connection=connection;
    }
    
    @Override
    public List<Jurusan> getJurusanByFakultas(String kodeFakultas) {
        try {
            List<Jurusan> jurusans=new ArrayList<Jurusan>();
            preparedStatement=connection.prepareStatement("SELECT * FROM jurusan where id_fakultas=?");
            preparedStatement.setString(1, kodeFakultas);
            ResultSet rs=preparedStatement.executeQuery();
            while(rs.next()){
                Jurusan jurusan=new Jurusan();
                jurusan.setIdJurusan(rs.getString("id_jurusan"));
                jurusan.setNamaJurusan(rs.getString("nama_jurusan"));
                jurusans.add(jurusan);
            }
            return jurusans;
        } catch (SQLException ex) {
            Logger.getLogger(JurusanServiceImplJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
}
