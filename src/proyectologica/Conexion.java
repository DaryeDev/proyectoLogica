/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologica;

import java.io.StringReader;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

/**
 *
 * @author eduar
 */
public class Conexion {
    static public String traducir(String input){       
        try {
            parser p = new parser(new Lexer(new StringReader(input)));
            Object result = p.parse().value;
            DatabaseManager db = new DatabaseManager();
            //db.repopulateDB();
            ResultSet rs = db.sendSQLCommandAndRetrieve(result.toString());
            
            String output = "";

            while(rs.next()){
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();

                String rowData = "";
                for (int i = 1; i <= columnCount; i++ ) {
                    String name = rsmd.getColumnName(i);
                    switch (name) { 
                        case "id":
                        case "population":
                            rowData += String.valueOf(rs.getInt(name)) + ";";
                            break;

                        case "size":
                            rowData += String.valueOf(rs.getFloat(name)) + ";";
                            break;

                        case "name":
                        case "country":
                        case "languages":
                        case "timezone":
                        case "government":
                            rowData += rs.getString(name) + ";";
                            break;
                    }
                }
                output += rowData + "\n";
            }

            return output;
        } catch (Exception e) {
            e.printStackTrace();
            return "Sintaxis y/o Gramática incorrecta.";
        }
    }
}
