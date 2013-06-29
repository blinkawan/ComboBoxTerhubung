package comboboxterhubung.service;

import comboboxterhubung.entity.Fakultas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FakultasServiceImplJdbc implements FakultasService {
    
    public Connection connection;
    public PreparedStatement preparedStatement;
    List<Fakultas> fakultases=new ArrayList<Fakultas>();
    
    public FakultasServiceImplJdbc(Connection connection){
        this.connection=connection;
    }

    @Override
    public List<Fakultas> getAllFakultas() {
        try {
            preparedStatement=connection.prepareStatement("SELECT * FROM fakultas");
            ResultSet rs=preparedStatement.executeQuery();
            
            while(rs.next()){
                Fakultas fakultas=new Fakultas();
                fakultas.setIdFakultas(rs.getString("id_fakultas"));
                fakultas.setNamaFakultas(rs.getString("nama_fakultas"));
                fakultases.add(fakultas);
            }
            return fakultases;
        } catch (SQLException ex) {
            Logger.getLogger(FakultasServiceImplJdbc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
