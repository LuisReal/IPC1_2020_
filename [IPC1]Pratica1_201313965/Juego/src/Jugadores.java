
import java.util.Scanner;


public class Jugadores {
    
    String jugador;
    String jugador2;
    String pokemon1;
    String pokemon2;
    int vidarestantepokemon1j2;
    int vidarestantepokemon2j2;
    int vidarestantepokemon1j1;
    int vidarestantepokemon2j1;
        
        
    public Jugadores(){
           
    
    
    }
    
    
   
    public void estableceNombre(){ 
    
        Scanner entrada = new Scanner (System.in);
    
        
        
        jugador = entrada.nextLine();
        
        
    }
    
    public String devuelveNombreJugador(){ 
    
    
        return jugador;
    
    
    }
    
    public void seleccionPokemon1(){ 
    
        Scanner entrada = new Scanner (System.in);
        
        
        pokemon1 = entrada.nextLine();
        
        
       
    }
    
    public void seleccionPokemon2(){ 
    
        Scanner entrada = new Scanner (System.in);
        
        
        pokemon2 = entrada.nextLine();
        
    
    }
    
    public void seleccionaPokemon(String nombre, String pokemon1j1, String pokemon2j1, 
            String pokemon1j2, String pokemon2j2, Pokemon[] vector){ 
    
        
         
        if(nombre.equals(pokemon1j1)){ // EMPIEZA ACCION DE ARTICUNO POKEMON1J1
        
            Scanner entrada = new Scanner(System.in);
        
            System.out.println("Seleccione el pokemon del jugador 2 a Atacar: ");
            String pokemonj2 = entrada.next();
            
           
            
            if(pokemon1j2.equals(pokemonj2)){ // SI SE SELECCIONA POKEMON1J2 A ATACAR
            
               
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon1j1.equals(vector[k].dameNombre())){
                    
                            vidarestantepokemon1j2 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon1j2));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon1j2);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                            
                            
                            
                            
                    
                        }
                    
                    }
                
                
                }
                
                }
                
            }else if(pokemon2j2.equals(pokemonj2)){ // SI SE SELECCIONA POKEMON 2J2 A ATACAR
            
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon1j1.equals(vector[k].dameNombre())){
                    
                            vidarestantepokemon2j2 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon2j2));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon2j2);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                            
                    
                        }
                    
                    }
                
                
                }
                
                }
            
            
            
            
            }
         // FINALIZA ACCION DE ARTICUNO POKEMON1J1
        }else if(nombre.equals(pokemon2j1)){ // EMPIEZA ACCION DE ALAKAZAM POKEMON2J1
        
            Scanner entrada = new Scanner(System.in);
        
            System.out.println("Seleccione el pokemon del jugador 2 a Atacar: ");
            String pokemonj2 = entrada.next();
            
            
            if(pokemon1j2.equals(pokemonj2)){ // SI SELECCIONA POKEMON A ATACAR : POKEMON 1J2
            
               
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon2j1.equals(vector[k].dameNombre())){
                    
                            vidarestantepokemon1j2 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon1j2));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon1j2);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                    
                        }
                    
                    }
                
                
                }
                
                }
                
            }else if(pokemon2j2.equals(pokemonj2)){ //SE SELECCIONA POKEMON A ATACAR POKEMON2J2
            
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon2j1.equals(vector[k].dameNombre())){
                    
                           vidarestantepokemon2j2 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon2j2));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon2j2);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                    
                        }
                    
                    }
                
                
                }
                
                }
            
            
            
            
            }
        
        }else if(nombre.equals(pokemon1j2)){ // INICIA ACCION ARCANINE POKEMON 1J2 // 
        
            Scanner entrada = new Scanner(System.in);
        
            System.out.println("Seleccione el pokemon del jugador 1 a Atacar: ");
            String pokemonj2 = entrada.next();
            
            
            if(pokemon1j1.equals(pokemonj2)){ // SI SELECCIONA POKEMON A ATACAR : POKEMON 1J1
            
               
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon1j2.equals(vector[k].dameNombre())){
                    
                            vidarestantepokemon1j1 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon1j1));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon1j1);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                    
                        }
                    
                    }
                
                
                }
                
                }
                
            }else if(pokemon2j1.equals(pokemonj2)){ //SE SELECCIONA POKEMON A ATACAR POKEMON2J1
            
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon1j2.equals(vector[k].dameNombre())){
                    
                           vidarestantepokemon2j1 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon2j1));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon2j1);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                    
                        }
                    
                    }
                
                
                }
                
                }
            
            
            
            
            }
        
        }else if(nombre.equals(pokemon2j2)){ // INICIA ACCION BULBASAUR POKEMON 2J2 // 
        
            Scanner entrada = new Scanner(System.in);
        
            System.out.println("Seleccione el pokemon del jugador 1 a Atacar: ");
            String pokemonj2 = entrada.next();
            
            
            if(pokemon1j1.equals(pokemonj2)){ // SI SELECCIONA POKEMON A ATACAR : POKEMON 1J1
            
               
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon2j2.equals(vector[k].dameNombre())){
                    
                            vidarestantepokemon1j1 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon1j1));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon1j1);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                    
                        }
                    
                    }
                
                
                }
                
                }
                
            }else if(pokemon2j1.equals(pokemonj2)){ //SE SELECCIONA POKEMON A ATACAR POKEMON2J1
            
                for(int i=0 ; i<=5; i++){ 
                
                    if(pokemonj2.equals(vector[i].dameNombre())){ 
                    
                    System.out.println("vida actual del pokemon: " + vector[i].dameVida());
                    
                    
                    
                    
                    for(int k=0; k<=5; k++){
                    
                        if(pokemon2j2.equals(vector[k].dameNombre())){
                    
                           vidarestantepokemon2j1 = (vector[i].dameVida())-vector[k].dameAtaque();
                            
                            System.out.println("punto de vida restante: " + (vidarestantepokemon2j1));
                            
                            vector[i].estableceNuevaVida(vidarestantepokemon2j1);
                            
                            
                           System.out.println("Nueva Vida: " + vector[i].dameVida());
                    
                        }
                    
                    }
                
                
                }
                
                }
            
            
            
            
            }
        
        } 
    
     
        
        
        
    
    }
    
    
    public int devuelveVidaRestante1j2(){ 
    
    
        return vidarestantepokemon1j2 ;
    
    
    }
    
   /* public int devuelveNuevaVida1j2(){ 
    
     return vidainicialpokemon1j2;
    
    }*/
    
    public int devuelveVidaRestante2j2(){ 
    
    
     return vidarestantepokemon2j2;
    
    }
    
    public int devuelveVidaRestante1j1(){ 
    
        return vidarestantepokemon1j1;
    
    
    }
    
    public int devuelveVidaRestante2j1(){ 
    
        return vidarestantepokemon2j1;
    
    
    }
    
    
    
    public void establecePokemonAtacar(String nombre , Pokemon[] vector){ 
    
        Scanner entrada = new Scanner (System.in);
    
        System.out.println("Seleccione el Pokemon a atacar del jugador 2");
    
        String pokemonatacar = entrada.next() ;
        
        if(pokemonatacar.equals(nombre)){ 
            
           
            
            
            System.out.println("vida actual del pokemon: " + vector[2].dameVida());
            System.out.println("punto de vida restante: " + ((vector[2].dameVida())-vector[0].dameAtaque()));
            
            
        }
        
    
    }
    
    public String devuelveNombrePokemon1(){
    
    
        return pokemon1;
        
    }
    
    public String devuelveNombrePokemon2(){ 
    
        return pokemon2;
    }
}
