package Modelo;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class DAOtablaprueba extends Conexion {

    public tablaprueba consultar(int fk) throws SQLException {
        tablaprueba ttablaprueba = null;
        try {
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            getConexion();
            ps = getConectionn().prepareCall("call sp_consultar(?)");
            ps.setInt(1, fk);
            res = ps.executeQuery();
            if (res.next()) {
                ttablaprueba = new tablaprueba();
                ttablaprueba.setPk_tabla(res.getInt("pk_tabla"));
                ttablaprueba.setCodigo(res.getString("codigo"));
                res.close();
                ps.close();
                disconnect();
            }

        } catch (SQLException e) {
            disconnect();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ttablaprueba;
    }

    public List consultas() throws SQLException {
        List<tablaprueba> listanew = new ArrayList();
        tablaprueba ttablaprueba = null;
        try {
            CallableStatement ps; //para usar esra se agrego la libreria
            ResultSet res; //tambien agregamos libreria
            getConexion();
            ps = getConectionn().prepareCall("call sp_consulta()");
            res = ps.executeQuery();
            while (res.next()) {
                ttablaprueba = new tablaprueba();
                ttablaprueba.setPk_tabla(res.getInt("pk_tabla"));
                ttablaprueba.setCodigo(res.getString("codigo"));
                listanew.add(ttablaprueba);
            }
            res.close();
            ps.close();
            disconnect();

        } catch (SQLException e) {
            disconnect();
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return listanew;
    }
}
