package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCurp {

    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final  String insertarCurp = "INSERT INTO persona(nombre, p_apellido, m_apellido, año, mes, dia, codigoEst, sexo, CURP)" +
            "VALUES(?,?,?,?,?,?,?,?,?)";

    private String obtener = "SELECT * FROM persona where CURP = ?";

    public boolean guardarCurp(BeanCurp curp){
        try{
            conn = new MySQLConnection().getConnection();
            String query = insertarCurp;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, curp.getNombre());
            pstm.setString(2, curp.getP_apellido());
            pstm.setString(3, curp.getM_apellido());
            pstm.setInt(4, curp.getAño());
            pstm.setInt(5, curp.getMes());
            pstm.setInt(6, curp.getDia());
            pstm.setString(7, curp.getCodigoEst());
            pstm.setString(8, curp.getSexo());
            pstm.setString(9, curp.getCURP());

            return pstm.executeUpdate()==1;
        }catch (SQLException e){
            Logger.getLogger(DaoCurp.class.getName()).log(Level.SEVERE,
                    "Error guardarCurp -> "+e);
            return false;
        }
    }

    public BeanCurp verCurp (String CURP){
        BeanCurp curp = null;
        try {
            conn = new MySQLConnection().getConnection();
            String query = obtener;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, CURP);
            rs = pstm.executeQuery();

            while (rs.next()) {
                curp = new BeanCurp();
                curp.setNombre(rs.getString("nombre"));
                curp.setP_apellido(rs.getString("p_apellido"));
                curp.setM_apellido(rs.getString("m_apellido"));
                curp.setAño(rs.getInt("año"));
                curp.setMes(rs.getInt("mes"));
                curp.setDia(rs.getInt("dia"));
                curp.setCodigoEst(rs.getString("codigoEst"));
                curp.setSexo(rs.getString("sexo"));
                return curp;
            }

        }catch (SQLException e){
            Logger.getLogger(DaoCurp.class.getName())
                    .log(Level.SEVERE, "Error en obtener -> ", e);
        }
        return null;
    }

    public void closeConnections(){
        try{
            if (conn!= null){
                conn.close();
            }
            if (pstm!= null){
                pstm.close();
            }
            if (rs!= null){
                rs.close();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
