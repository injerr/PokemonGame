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
            PokemonDAO pokemons = new PokemonDAO();
            CapturasDAO capturas = new CapturasDAO();
            int ch;
            Scanner sc = new Scanner(System.in);
            String nickname,password,pokename;
            Pokemon poke;
            int id;
            mostrarLogo();
            Trainer thisTrainer = iniciarSesion(0);
            System.out.println("Bienvenido " + thisTrainer.getNickname());
            System.out.println();
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
                        pokename = pedirString("Nombre del nuevo pokemon:");
                        System.out.println("Cual es su numº de la pokedex?");
                        id = sc.nextInt();
                        poke = new Pokemon(id, pokename);
                        try {
                            pokemons.darAltaPokemon(poke);
                        } catch (pokemonExistente ex) {
                            System.out.println(ex.getMessage());
                        }
                        break;


                    case 6:
                        System.out.println("Cazar pokemon");
                        System.out.println("---------------------");
                        poke = pokemons.getPokemonRandom();
                        final int CP_MAX_VALUE = 100; 
                        int cp = poke.getRandomCP(CP_MAX_VALUE);
                        System.out.println("Te has encontrado un " + poke.getName() + " salvaje.");
                        System.out.println(poke.getName() + " Salvaje tiene " + cp +" de cp (Combat Points).");
                        try {
                            System.out.println("Adivina el numero (pista, el numero esta entre 1 y "+ cp +")");
                            int response = sc.nextInt();
                            if (capturas.darCaptura(thisTrainer.getId(), poke.getId_pokedex(), cp, response, 0)) {
                                System.out.println("Has capturado a: " + poke.getName());
                            }
                        } catch (segundaOportunidadEnCaza e) {
                            System.out.println("Última oportunidad");
                            System.out.println("Adivina el numero (pista, el numero esta entre 1 y " + cp + ")");
                            int response = sc.nextInt();
                            try {
                                if (capturas.darCaptura(thisTrainer.getId(), poke.getId_pokedex(), cp, response, 1)) {
                                    System.out.println("Has capturado a: " + poke.getName());
                                }else{
                                    throw new segundaOportunidadEnCaza("");
                                }
                            } catch (segundaOportunidadEnCaza ex) {
                                System.out.println("El pokemon huyó");
                            }
                        } 
                        break;

                    case 7:
                        System.out.println("Listar pokemons cazados");
                        System.out.println("----------------------------------");
                        List<String> mypokemons = capturas.getCaza(thisTrainer.getId());
                        for (String mypokemon : mypokemons) {
                            System.out.println(mypokemon);
                        }
                        System.out.println("Tienes "+ mypokemons.size() +" pokemons.");
                        System.out.println();
                        break;

                    case 8:
                        System.out.println("Listar tipos pokemon existentes en juego");
                        System.out.println("-----------------------------------------------------");
                        List<Pokemon> pokedex = pokemons.devolverPokemons();
                        for (Pokemon pokemon : pokedex) {
                            System.out.println(pokemon.getId_pokedex() + " " +pokemon.getName());
                        }
                        System.out.println("");
                        break;

                    default:
                        System.out.println("Valor no valido");
                        break;
                }

            } while (ch != 0);
            
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (errorInLogin ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    private Menu crearMenu() {
        Menu mn = new Menu("Pokemon Go",true);
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

    private Trainer iniciarSesion(int c) throws SQLException, errorInLogin{
        if (c >= 3) {
            throw new errorInLogin("Has intentado entrar erroneamente muchas veces.");
        }
        Trainer devolver = null;
        TrainerDAO t = new TrainerDAO();
        String usuario = pedirString("Indica tu nombre de usuario");
        String password = pedirString("Indica tu contraseña");
        Trainer entrenador = t.validarEntrenador(usuario, password);
        if (entrenador == null) {
            try {
                devolver = new Trainer(usuario, password);
                t.darAltaUsuario(devolver);
                System.out.println("Se ha creado tu usuario.");
            } catch (userExistente e) {
                System.out.println("Intentalo de nuevo.");
                iniciarSesion(++c);
            }
        } else{
            devolver = entrenador;
        }
        return devolver;
    }
    
}
