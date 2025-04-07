/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

import java.util.Objects;

/**
 *
 * @author jin9669
 */
public class Pokemon {
    private int id_pokedex;
    private String name;

    public Pokemon() {
    }

    public Pokemon(int id_pokedex, String name) {
        this.id_pokedex = id_pokedex;
        this.name = name;
    }
    
    public Pokemon(int id_pokedex){
        this.id_pokedex = id_pokedex;
    }

    public int getId_pokedex() {
        return id_pokedex;
    }

    public String getName() {
        return name;
    }
    
    public int getRandomCP(int MAX_VALUE){
        return (int) (Math.random()*MAX_VALUE+1);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof Pokemon)) {
            return false;
        }
        final Pokemon other = (Pokemon) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public String toString() {
        return  "Numº pokedex: " + id_pokedex + ", pokemon: " + name;
    }
    
    
}
