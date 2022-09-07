package com.isil.sesion1;

import java.sql.*;

public class MainApp {

    public static void main(String[] args) throws Exception{


        Class.forName("com.mysql.cj.jdbc.Driver"
        );

        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/TEST",
                "root",
                "root"
        );

       /* Statement stmt = con.createStatement();
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



        Statement stmt2 = con.createStatement();
        ResultSet resultSet = stmt2.executeQuery("Select * from Users Where name = 'Ronaldo'");

        while(resultSet.next()){
            System.out.println(resultSet.getString("name") + "\n"+
                    resultSet.getString("phone") + "\n"+
                    resultSet.getString("city"));
        }



        // 3. Crear statement
        PreparedStatement preparedStatement =
                con.prepareStatement("select * from Users where name=? and city=?");
        preparedStatement.setString(1, "Messi");
        preparedStatement.setString(2, "Paris");
        // 4. Ejecutar query
        ResultSet resultSet2 = preparedStatement.executeQuery();

        // 5. Recorrer resultados
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("name") + "\n"+
                    resultSet2.getString("phone") + "\n"+
                    resultSet2.getString("city"));
        }
 */
        // 3. Crear statement
        // 3.1 Statement mantenimiento
        Statement stCreate = con.createStatement();
        int filasAfectadas=
                stCreate.executeUpdate("UPDATE USERS SET NAME='JUAN' WHERE IDUSER=1");
        System.out.println("Filas afectadas: " + filasAfectadas);

        // 3.2 Statement consulta
        PreparedStatement preparedStatement =
                con.prepareStatement("select * from Users where idUser=?");

        preparedStatement.setInt(1, 1);

        // 4. Ejecutar query
        ResultSet resultSet2 = preparedStatement.executeQuery();

        // 5. Recorrer resultados
        while(resultSet2.next()){
            System.out.println(resultSet2.getString("name") + "\n"+
                    resultSet2.getString("phone") + "\n"+
                    resultSet2.getString("city"));
        }

        // 6. Cerrar conexion
        con.close();

    }

}

