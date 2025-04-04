/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Objects;

/**
 *
 * @author jin9669
 */
public class Trainer {
    private String nickname;
    private int id;
    private String password;

    public Trainer() {
    }

    public Trainer(String nickname, int id, String password) {
        this.nickname = nickname;
        this.id = id;
        this.password = password;
    }
    
    public Trainer(String nickname, String password) {
        this.nickname = nickname;
        this.password = password;
    }
    
    public Trainer(String nickname) {
        this.nickname = nickname;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trainer other = (Trainer) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Id=" + id + ", nickname=" + nickname + ", password=" + password;
    }
    
    
    
}
