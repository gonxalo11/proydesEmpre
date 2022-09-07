package com.isil.sesion1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainApp {

    public static void main(String[] args) throws Exception{
        System.out.print("Hola mundo");

        Class.forName("com.mysql.jdbc.Driver");

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TEST",
                "root",
                "root"
        );

        Statement stmt = con.createStatement();
        //Actualizacion de una fina    --Devuelve un valor entero--
        int resulUpdate = stmt.executeUpdate("update Users set phone='99999999' where name = 'Messi'");
        //Consulta en la BD
        ResultSet result = stmt.executeQuery("select * from Users");

        while(result.next()){
            System.out.println(result.getString("idUser"));
            System.out.println(result.getString("name"));
            System.out.println(result.getString("phone"));
            System.out.println(result.getString("city"));
        }

    }

}

