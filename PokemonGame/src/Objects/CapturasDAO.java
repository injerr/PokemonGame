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
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jin9669
 */
public class CapturasDAO {

    public CapturasDAO() {
    }
    
    public boolean darCaptura(int id_entrenador, int num_pokemon,int cp, int response, int intento) throws SQLException, segundaOportunidadEnCaza{
        try (Connection conn = SQLConnect.getConnection()) {
            //MECANICA PRINCIPAL
            int random = (int) (Math.random()*cp);
            int formula = random%10;
            
            if(response != formula & intento == 0){
               throw new segundaOportunidadEnCaza("Has fallado la primera pokeball, intenta una última vez");
            }
            if(response != formula & intento != 0){
                return false;
            }
            
            
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ENTRENADOR_TIENE WHERE TRAINER_ID = ' "+ id_entrenador +" ' AND POKEMON_ID = ' "+ num_pokemon +" ';";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                throw new SQLIntegrityConstraintViolationException();
            }
            query = "INSERT INTO ENTRENADOR_TIENE(TRAINER_ID,POKEMON_iD,CP) VALUES(?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id_entrenador);
            pstmt.setInt(2, num_pokemon);
            pstmt.setInt(3, cp);
            pstmt.executeUpdate();
            return true;
        } catch (SQLIntegrityConstraintViolationException e) {
            Connection conn = SQLConnect.getConnection();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ENTRENADOR_TIENE WHERE TRAINER_ID = ' "+ id_entrenador +" ' AND POKEMON_ID = ' "+ num_pokemon +" ';";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                int actual_cp = res.getInt("cp");
                if(actual_cp < cp){
                    query = "UPDATE ENTRENADOR_TIENE SET CP = ? WHERE TRAINER_ID = ? AND POKEMON_ID = ?;";
                    PreparedStatement pstmt = conn.prepareStatement(query);
                    pstmt.setInt(1, cp);
                    pstmt.setInt(2, id_entrenador);
                    pstmt.setInt(3, num_pokemon);
                    pstmt.executeUpdate();
                }
            }
            return false;
        }
    }
    
        public List<String> getCaza(int id_entrenador) throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            List<String> pokemons = new ArrayList<>();
            PokemonDAO pokeDAO = new PokemonDAO();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM ENTRENADOR_TIENE WHERE TRAINER_ID = '"+ id_entrenador +"' ORDER BY CP DESC;";
            ResultSet res = stmt.executeQuery(query);
            while(res.next()){
                int id = res.getInt("pokemon_id");
                int cp = res.getInt("cp");
                String pokename = pokeDAO.getNombrePokemon(id);
                
                pokemons.add(pokename + " " + cp);
            }
            Collections.sort(pokemons);
            return pokemons;
        } catch (SQLException e) {
            throw e;
        }
    }
}
