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
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author MiltonLQ
 */
public class Servidor extends HttpServlet {

    /*no tomar en cuenta*/
//    Conexion conexion;
//    DAOtablaprueba tabla;
//    tablaprueba tabl;
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
        String id = request.getParameter("id");//capturo el dato enviado desde fetch el request.getParamete("") es equivalente a $_POST[""] de php
        PrintWriter out = response.getWriter();
        JSONObject json = new JSONObject();
        json.put("ID server", id);
        out.print(json);//imprimo(pero me da nulo)

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
