/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectologica;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author eduar
 */
public class DatabaseManager {
    private String dbURI = "jdbc:sqlite:countryData.db";
    private Connection dbCon;

    public DatabaseManager() throws SQLException {
        this.dbCon = DriverManager.getConnection(this.dbURI);
    }
    public ResultSet sendSQLCommandAndRetrieve(String sqlCommand) throws SQLException {
        Statement stmt2 = this.dbCon.createStatement();
        ResultSet rs = stmt2.executeQuery(sqlCommand);
        return rs;
    }
    public void repopulateDB(){
        try {
            String sql_tabla = "CREATE TABLE IF NOT EXISTS countryData ("
                    + "id integer primary key,"
                    + "name text,"
                    + "country text,"
                    + "population integer,"
                    + "languages text,"
                    + "timezone float,"
                    + "government text,"
                    + "size double"
                    + ");";
            Statement stmt = this.dbCon.createStatement();
            stmt.execute(sql_tabla);
            
            String sql_insert = "insert into countryData (name, country, population, languages, timezone, government, size) values (?,?,?,?,?,?,?)";
            
            PreparedStatement pstmt0 = this.dbCon.prepareStatement(sql_insert);
            pstmt0.setString(1, "Estados Unidos");
            pstmt0.setString(2, "America");
            pstmt0.setInt(3, 331);
            pstmt0.setString(4, "Ingles");
            pstmt0.setString(5, "UTC-5, UTC-10");
            pstmt0.setString(6, "Republica presidencialista");
            pstmt0.setDouble(7, 10);
            pstmt0.executeUpdate();

            PreparedStatement pstmt1 = this.dbCon.prepareStatement(sql_insert);
            pstmt1.setString(1, "China");
            pstmt1.setString(2, "Asia");
            pstmt1.setInt(3, 1410);
            pstmt1.setString(4, "Mandarin");
            pstmt1.setString(5, "UTC+8");
            pstmt1.setString(6, "Republica socialista");
            pstmt1.setDouble(7, 10);
            pstmt1.executeUpdate();

            PreparedStatement pstmt2 = this.dbCon.prepareStatement(sql_insert);
            pstmt2.setString(1, "India");
            pstmt2.setString(2, "Asia");
            pstmt2.setInt(3, 1390);
            pstmt2.setString(4, "Hindi, Ingles");
            pstmt2.setString(5, "UTC+5:30");
            pstmt2.setString(6, "Republica parlamentaria");
            pstmt2.setDouble(7, 3);
            pstmt2.executeUpdate();

            PreparedStatement pstmt3 = this.dbCon.prepareStatement(sql_insert);
            pstmt3.setString(1, "Brasil");
            pstmt3.setString(2, "America del Sur");
            pstmt3.setInt(3, 213);
            pstmt3.setString(4, "Portugues");
            pstmt3.setString(5, "UTC-3, UTC-5");
            pstmt3.setString(6, "Republica federal");
            pstmt3.setDouble(7, 9);
            pstmt3.executeUpdate();

            PreparedStatement pstmt4 = this.dbCon.prepareStatement(sql_insert);
            pstmt4.setString(1, "Rusia");
            pstmt4.setString(2, "Asia");
            pstmt4.setInt(3, 145);
            pstmt4.setString(4, "Ruso");
            pstmt4.setString(5, "UTC+2, UTC+12");
            pstmt4.setString(6, "Republica federal semipresidencial");
            pstmt4.setDouble(7, 17);
            pstmt4.executeUpdate();

            PreparedStatement pstmt5 = this.dbCon.prepareStatement(sql_insert);
            pstmt5.setString(1, "Mexico");
            pstmt5.setString(2, "America del Norte");
            pstmt5.setInt(3, 129);
            pstmt5.setString(4, "Espanol");
            pstmt5.setString(5, "UTC-8, UTC-6");
            pstmt5.setString(6, "Republica federal");
            pstmt5.setDouble(7, 2);
            pstmt5.executeUpdate();

            PreparedStatement pstmt6 = this.dbCon.prepareStatement(sql_insert);
            pstmt6.setString(1, "Indonesia");
            pstmt6.setString(2, "Asia");
            pstmt6.setInt(3, 273);
            pstmt6.setString(4, "Indonesio");
            pstmt6.setString(5, "UTC+7, UTC+9");
            pstmt6.setString(6, "Republica presidencialista");
            pstmt6.setDouble(7, 2);
            pstmt6.executeUpdate();

            PreparedStatement pstmt7 = this.dbCon.prepareStatement(sql_insert);
            pstmt7.setString(1, "Japon");
            pstmt7.setString(2, "Asia");
            pstmt7.setInt(3, 126);
            pstmt7.setString(4, "Japones");
            pstmt7.setString(5, "UTC+9");
            pstmt7.setString(6, "Monarquia parlamentaria");
            pstmt7.setDouble(7, 0);
            pstmt7.executeUpdate();

            PreparedStatement pstmt8 = this.dbCon.prepareStatement(sql_insert);
            pstmt8.setString(1, "Nigeria");
            pstmt8.setString(2, "Africa");
            pstmt8.setInt(3, 211);
            pstmt8.setString(4, "Ingles, Hausa, Yoruba, Igbo");
            pstmt8.setString(5, "UTC+1");
            pstmt8.setString(6, "Republica federal");
            pstmt8.setDouble(7, 1);
            pstmt8.executeUpdate();

            PreparedStatement pstmt9 = this.dbCon.prepareStatement(sql_insert);
            pstmt9.setString(1, "Alemania");
            pstmt9.setString(2, "Europa");
            pstmt9.setInt(3, 83);
            pstmt9.setString(4, "Aleman");
            pstmt9.setString(5, "UTC+1");
            pstmt9.setString(6, "Republica federal parlamentaria");
            pstmt9.setDouble(7, 0);
            pstmt9.executeUpdate();

            PreparedStatement pstmt10 = this.dbCon.prepareStatement(sql_insert);
            pstmt10.setString(1, "Francia");
            pstmt10.setString(2, "Europa");
            pstmt10.setInt(3, 67);
            pstmt10.setString(4, "Frances");
            pstmt10.setString(5, "UTC+1");
            pstmt10.setString(6, "Republica semipresidencialista");
            pstmt10.setDouble(7, 1);
            pstmt10.executeUpdate();

            PreparedStatement pstmt11 = this.dbCon.prepareStatement(sql_insert);
            pstmt11.setString(1, "Reino Unido");
            pstmt11.setString(2, "Europa");
            pstmt11.setInt(3, 67);
            pstmt11.setString(4, "Ingles");
            pstmt11.setString(5, "UTC+0, UTC+1");
            pstmt11.setString(6, "Monarquia parlamentaria");
            pstmt11.setDouble(7, 0);
            pstmt11.executeUpdate();

            PreparedStatement pstmt12 = this.dbCon.prepareStatement(sql_insert);
            pstmt12.setString(1, "Italia");
            pstmt12.setString(2, "Europa");
            pstmt12.setInt(3, 60);
            pstmt12.setString(4, "Italiano");
            pstmt12.setString(5, "UTC+1");
            pstmt12.setString(6, "Republica parlamentaria");
            pstmt12.setDouble(7, 0);
            pstmt12.executeUpdate();

            PreparedStatement pstmt13 = this.dbCon.prepareStatement(sql_insert);
            pstmt13.setString(1, "Corea del Sur");
            pstmt13.setString(2, "Asia");
            pstmt13.setInt(3, 51);
            pstmt13.setString(4, "Coreano");
            pstmt13.setString(5, "UTC+9");
            pstmt13.setString(6, "Republica presidencialista");
            pstmt13.setDouble(7, 0);
            pstmt13.executeUpdate();

            PreparedStatement pstmt14 = this.dbCon.prepareStatement(sql_insert);
            pstmt14.setString(1, "Argentina");
            pstmt14.setString(2, "America del Sur");
            pstmt14.setInt(3, 45);
            pstmt14.setString(4, "Espanol");
            pstmt14.setString(5, "UTC-3");
            pstmt14.setString(6, "Republica federal");
            pstmt14.setDouble(7, 3);
            pstmt14.executeUpdate();

            PreparedStatement pstmt15 = this.dbCon.prepareStatement(sql_insert);
            pstmt15.setString(1, "Canada");
            pstmt15.setString(2, "America del Norte");
            pstmt15.setInt(3, 38);
            pstmt15.setString(4, "Ingles, Frances");
            pstmt15.setString(5, "UTC-3.5, UTC-8");
            pstmt15.setString(6, "Monarquia parlamentaria federal");
            pstmt15.setDouble(7, 10);
            pstmt15.executeUpdate();

            PreparedStatement pstmt16 = this.dbCon.prepareStatement(sql_insert);
            pstmt16.setString(1, "Australia");
            pstmt16.setString(2, "Oceania");
            pstmt16.setInt(3, 26);
            pstmt16.setString(4, "Ingles");
            pstmt16.setString(5, "UTC+8, UTC+11");
            pstmt16.setString(6, "Monarquia constitucional parlamentaria");
            pstmt16.setDouble(7, 8);
            pstmt16.executeUpdate();

            PreparedStatement pstmt17 = this.dbCon.prepareStatement(sql_insert);
            pstmt17.setString(1, "Sudafrica");
            pstmt17.setString(2, "Africa");
            pstmt17.setInt(3, 60);
            pstmt17.setString(4, "Afrikaans, Ingles, Zulu");
            pstmt17.setString(5, "UTC+2");
            pstmt17.setString(6, "Republica parlamentaria");
            pstmt17.setDouble(7, 1);
            pstmt17.executeUpdate();

            PreparedStatement pstmt18 = this.dbCon.prepareStatement(sql_insert);
            pstmt18.setString(1, "Turquia");
            pstmt18.setString(2, "Asia y Europa");
            pstmt18.setInt(3, 84);
            pstmt18.setString(4, "Turco");
            pstmt18.setString(5, "UTC+3");
            pstmt18.setString(6, "Republica parlamentaria");
            pstmt18.setDouble(7, 1);
            pstmt18.executeUpdate();

            PreparedStatement pstmt19 = this.dbCon.prepareStatement(sql_insert);
            pstmt19.setString(1, "Egipto");
            pstmt19.setString(2, "Africa");
            pstmt19.setInt(3, 104);
            pstmt19.setString(4, "Arabe");
            pstmt19.setString(5, "UTC+2");
            pstmt19.setString(6, "Republica semipresidencial");
            pstmt19.setDouble(7, 1.01);
            pstmt19.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DatabaseManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
