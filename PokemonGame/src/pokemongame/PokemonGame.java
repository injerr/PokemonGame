/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pokemongame;
import Objects.*;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author jin9669
 */
public class PokemonGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PokemonGame app = new PokemonGame();
        app.run();
    }
    
    private void run(){
        try {
            SQLConnect.loadDriver();
            Menu mn = crearMenu();
            TrainerDAO entrenadores = new TrainerDAO();
            int ch;
            Scanner sc = new Scanner(System.in);
            String nickname,password,pokename;
            int id;
            mostrarLogo();
            validarUsuario();
            do {
                mn.displayMenu();
                ch = sc.nextInt();

                switch (ch) {
                    case 0:
                        System.out.println("Saliste de la app.");
                        break;
                    case 1:
                        System.out.println("Dar de alta entrenador");
                        System.out.println("-----------------------------");
                        System.out.print("Escribe tu nickname: ");
                        nickname = sc.next();
                        System.out.print("Escribe tu password: ");
                        password = sc.next();
                        
                        try {
                            if (entrenadores.darAltaUsuario(new Trainer(nickname, password))) {
                                System.out.println("Se ha creado tu usuario correctamente");
                            }  else{
                                System.out.println("Ha habido un error imprevisto.");
                            }
                        } catch (userExistente e) {
                            System.out.println(e.getMessage());
                        }
                        break;

                    case 2:
                        System.out.println("Dar de baja entrenador");
                        System.out.println("------------------------------");
                        nickname = pedirString("Indica tu nickname de usuario");
                        Trainer deleted = entrenadores.darBajaUsuario(new Trainer(nickname));
                        if(deleted != null){
                            System.out.println("Se ha borrado el usuario: "+ deleted);
                        } else{
                            System.out.println("El usuario "+ nickname +" no existe.");
                        }
                        
                        break;

                    case 3:
                        System.out.println("Consultar Datos Entrenador");
                        System.out.println("------------------------------------");
                        nickname = pedirString("Indica tu nickname de usuario");
                        Trainer t = entrenadores.consultarDatos(nickname);
                        System.out.println("Tu perfil:");
                        System.out.println(t);
                        break;

                    case 4:
                        System.out.println("Listar Entrenadores");
                        System.out.println("-------------------------");
                        List<Trainer> trainers = entrenadores.devolverEntrenadores();
                        for (Trainer trainer : trainers) {
                            System.out.println(trainer);
                        }
                        
                        break;

                    case 5:
                        System.out.println("Dar de alta pokemon");
                        System.out.println("---------------------------");
                        break;

                    case 6:
                        System.out.println("Cazar pokemon");
                        System.out.println("---------------------");
                        break;

                    case 7:
                        System.out.println("Listar pokemons cazados");
                        System.out.println("----------------------------------");
                        break;

                    case 8:
                        System.out.println("Listar tipos pokemon existentes en juego");
                        System.out.println("-----------------------------------------------------");
                        break;

                    default:
                        System.out.println("Valor no valido");
                        break;
                }

            } while (ch != 0);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private Menu crearMenu() {
        Menu mn = new Menu("TikTok",true);
        try {
                    mn.addOption("Dar de alta entrenador");
                    mn.addOption("Dar de baja entrenador");
                    mn.addOption("Consultar Datos Entrenador");
                    mn.addOption("Listar Entrenadores");
                    mn.addOption("Dar de alta Pokemon");
                    mn.addOption("Cazar pokemon");
                    mn.addOption("Listar Pokemons cazados.");
                    mn.addOption("Listar tipos Pokemon existentes en juego.");
            } catch (OptionDuplicateException e) {
                    e.printStackTrace();
            }
        return mn;
    }
    
    private String pedirString(String msg) {
    	Scanner sc = new Scanner(System.in);
    	System.out.println(msg);
    	return sc.nextLine();
    }
    
    private void mostrarLogo(){
        System.out.println("                                  ,'\\");
        System.out.println("    _.----.        ____         ,'  _\\   ___    ___     ____");
        System.out.println("_,-'       `.     |    |  /`.   \\,-'    |   \\  /   |   |    \\  |`.");
        System.out.println("\\      __    \\    '-.  | /   `.  ___    |    \\/    |   '-.   \\ |  |");
        System.out.println(" \\.    \\ \\   |  __  |  |/    ,','_  `.  |          | __  |    \\|  |");
        System.out.println("   \\    \\/   /,' _`.|      ,' / / / /   |          ,' _`.|     |  |");
        System.out.println("    \\     ,-'/  /   \\    ,'   | \\/ / ,`.|         /  /   \\  |     |");
        System.out.println("     \\    \\ |   \\_/  |   `-.  \\    `'  /|  |    ||   \\_/  | |\\    |");
        System.out.println("      \\    \\ \\      /       `-.`.___,-' |  |\\  /| \\      /  | |   |");
        System.out.println("       \\    \\ `.__,'|  |`-._    `|      |__| \\/ |  `.__,'|  | |   |");
        System.out.println("        \\_.-'       |__|    `-._ |              '-.|     '-.| |   |");
        System.out.println("                                `'                            '-._|");
    }

    private void validarUsuario() {
        //TODO
        String usuario = pedirString("Indica tu nombre de usuario");
        String password = pedirString("Indica tu contraseña");
    }
    
}
