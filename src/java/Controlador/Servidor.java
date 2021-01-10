/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Conexion;
import Modelo.DAOtablaprueba;
import Modelo.tablaprueba;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;

@MultipartConfig
public class Servidor extends HttpServlet {

    /*no tomar en cuenta*/
    Conexion conexion;
    DAOtablaprueba tabla;
    tablaprueba tabl;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

//       PrintWriter out = null;
//        try {
//            //leemos el fk
//            //int fk = Integer.parseInt(request.getParameter("id"));
//            out = response.getWriter();
//            tabla = new DAOtablaprueba();
//            List<tablaprueba> lista = tabla.consultas();
//            //llenamos un objeto de tipo json object
//            JSONObject json;
//            JSONArray arr=new JSONArray();
//
//            //agregamos propiedades al json
//            for (tablaprueba tab : lista) {    
//                json = new JSONObject();
//                json.put("pk", tab.getPk_tabla());
//                json.put("codigo", tab.getCodigo());
//                arr.add(json);
//                //out.print(json);
//            }
//            out.print(arr);
//
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage());
//        } finally {
//            out.close();
//        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = null;
        try {
            //leemos el fk
            int fk = Integer.parseInt(request.getParameter("id"));
            out = response.getWriter();
            tabla = new DAOtablaprueba();
            tabl = new tablaprueba();
            tabl = tabla.consultar(fk);
            //llenamos un objeto de tipo json object
            JSONObject json;
            if (tabl == null) {
                json = new JSONObject();
                json.put("error", "no se a podido realizar la consulta");
                out.print(json);
                out.close();
                json=null;
            } else {
                json = new JSONObject();
                json.put("pk", tabl.getPk_tabla());
                json.put("codigo", tabl.getCodigo());
                out.print(json);
                out.close();
                json=null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            out.close();
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
