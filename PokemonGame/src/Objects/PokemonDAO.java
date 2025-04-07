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
public class PokemonDAO {

    public PokemonDAO() {
    }
    
    public boolean darAltaPokemon(int id, String pokename) throws SQLException{
        try (Connection conn = SQLConnect.getConnection()) {
            String query = "INSERT INTO POKEMON(ID_POKEDEX,NAME) VALUES(?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, id);
            pstmt.setString(2, pokename);
            
            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public boolean darAltaPokemon(Pokemon t) throws SQLException, pokemonExistente {
        try (Connection conn = SQLConnect.getConnection()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM POKEMON WHERE name = '"+ t.getName() +"' ;";
            ResultSet res =  stmt.executeQuery(query);
            if (res.next()) {
                throw new pokemonExistente("Ya existe este pokemon.");
            }
            
            query = "INSERT INTO POKEMON(ID_POKEDEX,NAME) VALUES(?,?);";
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, t.getId_pokedex());
            pstmt.setString(2, t.getName());

            pstmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }
    
    public Pokemon darBajaUsuario(Pokemon t) throws SQLException{
        try (Connection conn = SQLConnect.getConnection()) {
            Pokemon devolver = null;
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM POKEMON WHERE name = '" + t.getName() + "' ;";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                int id = res.getInt("id_pokedex");
                String name = res.getString("name");
                devolver = new Pokemon(id,name);
                
                query = "DELETE FROM POKEMON WHERE NAME = ?;";
                PreparedStatement pstmt = conn.prepareStatement(query);
                pstmt.setString(1, t.getName());
                pstmt.executeUpdate();
            }
            return devolver;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public Pokemon getPokemonRandom() throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            List<Pokemon> pokemons = new ArrayList<>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM POKEMON;";
            ResultSet res =  stmt.executeQuery(query);
            while (res.next()) {                
                int id = res.getInt("id_pokedex");
                String name = res.getString("name");
                
                pokemons.add(new Pokemon(id, name));
            }
            
            int random = (int) (Math.random()*pokemons.size());
            return pokemons.get(random);
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public List<Pokemon> devolverPokemons() throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            List<Pokemon> pokemons = new ArrayList<>();
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM POKEMON ORDER BY ID_POKEDEX;";
            ResultSet res =  stmt.executeQuery(query);
            while (res.next()) {                
                int id = res.getInt("id_pokedex");
                String name = res.getString("name");
                
                pokemons.add(new Pokemon(id, name));
            }

            return pokemons;
        } catch (SQLException e) {
            throw e;
        }
    }
    
    public String getNombrePokemon(int num_pokemon) throws SQLException {
        try (Connection conn = SQLConnect.getConnection()) {
            Statement stmt = conn.createStatement();
            String query = "SELECT * FROM POKEMON WHERE ID_POKEDEX = '"+ num_pokemon +"';";
            ResultSet res = stmt.executeQuery(query);
            if (res.next()) {
                return res.getString("name");
            } else{
                return null;
            }

        } catch (SQLException e) {
            throw e;
        }
    }
}
