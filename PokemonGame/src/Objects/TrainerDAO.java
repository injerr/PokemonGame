/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.*;
import org.mariadb.jdbc.Connection;
import org.mariadb.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author jin9669
 */
public class TrainerDAO {

    public TrainerDAO() {
    }
    
    public boolean darAltaUsuario(String nickname, String password) throws SQLException{
        try (Connection conn = SQLConnect.getConnection()) {
            String query = "INSERT INTO TRAINER(NICKNAME,PASSWORD) VALUES(?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, nickname);
            pstmt.setString(2, password);
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public boolean darAltaUsuario(Trainer t) throws SQLException, userExistente {
        try (Connection conn = SQLConnect.getConnection()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TRAINER WHERE nickname = '"+ t.getNickname() +"' ;";
            ResultSet res =  stmt.executeQuery(query);
            if (res.next()) {
                throw new userExistente("Ya hay un entrenador con este nickname");
            }
            
            query = "INSERT INTO TRAINER(NICKNAME,PASSWORD) VALUES(?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, t.getNickname());
            pstmt.setString(2, t.getPassword());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public Trainer darBajaUsuario(Trainer t) throws SQLException{
        try (Connection conn = SQLConnect.getConnection()) {
            Trainer devolver = null;
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TRAINER WHERE nickname = '" + t.getNickname() + "' ;";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                int id = res.getInt("id");
                String nickname = res.getString("nickname");
                String password = res.getString("password");
                devolver = new Trainer(nickname, id, password);
                
                query = "DELETE FROM TRAINER WHERE NICKNAME = ?;";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, t.getNickname());
                pstmt.executeUpdate();
            }
            return devolver;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Trainer consultarDatos(String name) throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            Trainer entrenador = null;
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TRAINER WHERE nickname = '"+ name +"' ;";
            ResultSet res =  stmt.executeQuery(query);
            while (res.next()) {                
                int id = res.getInt("id");
                name = res.getString("nickname");
                String password = res.getString("password");
                
                entrenador = new Trainer(name, id, password);
            }
            
            return entrenador;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<Trainer> devolverEntrenadores() throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            List<Trainer> entrenadores = new ArrayList<>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TRAINER;";
            ResultSet res = stmt.executeQuery(query);
            while (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("nickname");
                String password = res.getString("password");
                Trainer entrenador = new Trainer(name, id, password);
                entrenadores.add(entrenador);
            }

            return entrenadores;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Trainer validarEntrenador(String trainername,String password) throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            Trainer entrenador = null;
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM TRAINER WHERE nickname = '"+ trainername +"' AND password = '"+ password +"';";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                int id = res.getInt("id");
                String name = res.getString("nickname");
                password = res.getString("password");
                entrenador = new Trainer(name, id, password);
            }
            
            return entrenador;

        } catch (SQLException e) {
            throw e;
        }
    }
}
