import java.util.Scanner;

public class Juego {
    
    public static void main (String args[]){
    
        
 
        
        Scanner entrada = new Scanner(System.in);
        
        System.out.println("Ingrese al numero de opcion al que desea ingresar. \n");
        System.out.println("Menu Principal: \n"
                + "1.Ingresar al Sistema. \n"
                + "2. Salir \n");
        
        int opcion = entrada.nextInt();
        
        int carnet1 = 201313965;
        
        String carnet = Integer.toString(carnet1);
        
        String contrasena ;
        
        //Pokemon[] misPokemon = new Pokemon[10];
        
       
        
           Pokemon obj = new Pokemon("imagen","fernando", 5, 10, "vivo");
           
           Pokemon[] vector = obj.mostrarLista();
           
           Jugadores jugador1 = new Jugadores();
           Jugadores jugador2 = new Jugadores();
           
           Jugadores vidapokemon = new Jugadores();
        
        
        
        if(opcion==1){
            
            System.out.println("Ingrese el numero de opcion");
            
            System.out.println("1. Administrador \n"
                    + "2. Iniciar juego con dos jugadores\n");
            
             opcion = entrada.nextInt();
            
             if(opcion==1){// ADMINISTRADOR
             
                 System.out.println("Ingrese contraseña.");
                 
                 contrasena = entrada.next();
             
                 if(contrasena.equals(carnet)){ 
                 
                    
                     
                     System.out.println("Seleccione una de las siguientes opciones: \n"
                             + "1. Listar a todos los pokemones. \n"
                             + "2. Agregar Pokemon. \n"
                             + "3. Editar Pokemon. \n");
                     
                     opcion = entrada.nextInt();
                     
                     
                     
                     
                     if(opcion==1){ // MOSTRAR LISTA DE POKEMON
                         
                         System.out.println(" "  );
  
                          
                         
                         System.out.println("Lista de Pokemon: \n");
                         
                         
                    
                         for(int i=0 ; i<=5; i++){ 
                         
                             
                             
                             System.out.println(vector[i].devuelveImagen()+ "\nNombre: " + vector[i].dameNombre() + "\nVida:   " +
                                     vector[i].dameVida()+ 
                                     "\nAtaque: " + vector[i].dameAtaque() + "\n");
                         
                         }
                         
                     }else if(opcion==2){ // AGREGAR POKEMON 
                     
                         String nombre;
                         String imagen;
                         int vida;
                         int ataque;
                         String estado;
                         
                         
                         for(int i=6; i<=19; i++ ){
                         
                             System.out.println("Ingrese la imagen del pokemon");
                             
                             imagen = entrada.next();
                             
                             System.out.println("Ingrese el nombre del pokemon");
                             nombre = entrada.next();
                             
                             System.out.println("Ingrese el valor de la vida del pokemon");
                             vida = entrada.nextInt();
                             
                             System.out.println("Ingrese el valor de ataque del pokemon");
                             ataque = entrada.nextInt();
                             
                             System.out.println("Ingrese el estado del pokemon");
                             estado = entrada.next();
                             
                             vector[i] = new Pokemon(imagen,nombre,vida,ataque, estado);
                         
                         }
                     
                     
                     }else if(opcion==3){ // EDITAR POKEMON
                     
                        
                        // 1 alakazam 2 arcanine 3 articuno 4 bellsprout 5 bulbasaur 6 butterfree
                     
                         System.out.println("Ingrese el nombre del pokemon a editar");
                         
                         String nombre=entrada.next();
                         
                          Pokemon pokemon1 = new Pokemon("imagen","a", 5, 10, "vivo");
                         
                          pokemon1.editarPokemon(nombre);
                          
                          vector[0]= new Pokemon(pokemon1.devuelveImagen(),pokemon1.dameNombre(),
                                  pokemon1.dameVida(),pokemon1.dameAtaque(), pokemon1.dameEstado());
                          
                          System.out.println("Imagen\n"+vector[0].devuelveImagen()+ "\nNombre: " + vector[0].dameNombre()+ "\nAtaque: "
                          + vector[0].dameAtaque() + "\nVida:   " + vector[0].dameVida() + "\n" );
                          
                          
                     }
                 
                 
                 }
                 
             
             }else if(opcion==2){ // INICIAR JUEGO CON DOS JUGADORES
                 
               
                 
                 
                 System.out.println("Ingrese el nombre del primer jugador: ");
                 jugador1.estableceNombre();
                 
                 System.out.println("Ingrese el nombre del segundo jugador: ");
                 jugador2.estableceNombre();
                 
                 
                 // SE MUESTRA LA LISTA DE POKEMON
                 for(int i=0 ; i<=5; i++){ 
                 
                     System.out.println("\n\nPokemon\n"+vector[i].devuelveImagen()+ "\nNombre: " + vector[i].dameNombre()+ "\nAtaque: "
                          + vector[i].dameAtaque() + "\nVida:   " + vector[i].dameVida() + "\n" );
                 
                 
                 }
                 
                 
                 System.out.println("Escriba el nombre del primer pokemon que seleccionara para el jugador 1");
                 jugador1.seleccionPokemon1();
                 
                 System.out.println("Escriba el nombre del segundo pokemon que seleccionara para el jugador 1");
                 jugador1.seleccionPokemon2();
                 
                 System.out.println("Escriba el nombre del primer pokemon que seleccionara para el jugador 2");
                 jugador2.seleccionPokemon1();
                 
                  System.out.println("Escriba el nombre del segundo pokemon que seleccionara para el jugador 2");
                 jugador2.seleccionPokemon2();
        
                 System.out.println("nombre del primer pokemon jugador1:  " + jugador1.devuelveNombrePokemon1()
                 +"\nnombre del segundo pokemon jugador1 " + jugador1.devuelveNombrePokemon2());
                 
                 
                 
                 
                 for(int i=0 ; i<=5 ; i++){
                 
                     
                    for(int j=0 ; j<=5 ; j++){ 
                     
                        if(jugador1.devuelveNombrePokemon1().equals(vector[i].dameNombre()) && jugador1.devuelveNombrePokemon2().equals(vector[j].dameNombre())){
                     
                 
                         System.out.println("\nJugador 1: " + jugador1.jugador);
                                                                                       // 34 espacios
                 
                         System.out.println("\n\nPokemon\n"+vector[i].devuelveImagen() + "                                 " +vector[j].devuelveImagen()
                                                                        // 22 espacios
                         + "\nNombre: " + vector[i].dameNombre()+"                     " + "Nombre: "+ vector[j].dameNombre()+ "\nAtaque: "
                                                      //30 espacios
                         + vector[i].dameAtaque() +"                             " +"Ataque:  "+ vector[j].dameAtaque()  + "\nVida:   " + vector[i].dameVida() 
                                 // 30 espacios
                         +"                             " + "Vida:  " +vector[j].dameVida()+ "\nEstado: " + vector[i].dameEstado()+"                           "+"Estado: " +vector[j].dameEstado()+ "\n" );
                 
                     }
                     
                    }
                 }
                 
                 // MUESTRA POKEMONES JUGADOR 2
                 for(int i=0 ; i<=5 ; i++){
                 
                     
                    for(int j=0 ; j<=5 ; j++){ 
                     
                        if(jugador2.devuelveNombrePokemon1().equals(vector[i].dameNombre()) && jugador2.devuelveNombrePokemon2().equals(vector[j].dameNombre())){
                     
                 
                         System.out.println("\nJugador 2: " + jugador2.jugador);
                                                                                       // 34 espacios
                 
                         System.out.println("\n\nPokemon\n"+vector[i].devuelveImagen() + "                                 " +vector[j].devuelveImagen()
                                                                        // 22 espacios
                         + "\nNombre: " + vector[i].dameNombre()+"                     " + "Nombre: "+ vector[j].dameNombre()+ "\nAtaque: "
                                                      //30 espacios
                         + vector[i].dameAtaque() +"                             " +"Ataque:  "+ vector[j].dameAtaque()  + "\nVida:   " + vector[i].dameVida() 
                                 // 30 espacios
                         +"                             " + "Vida:  " +vector[j].dameVida()+ "\nEstado: " + vector[i].dameEstado()+"                           "+"Estado: " +vector[j].dameEstado() +"\n" );
                 
                     }
                     
                    }
                 }
                 
                 // MUESTRA POKEMONES JUGADOR 2   // MUESTRA POKEMONES JUGADOR 2
                 
                
                // System.out.println("vida restante 1j2: " + vidapokemon.devuelveVidaRestante1j2() + "vida restante 2j2:" + vidapokemon.devuelveVidaRestante2j2() );
                 
               
                
                 
               do{
                 
                 Pokemon vidanueva = new Pokemon("a","b", 5 ,10, "vivo");   
                   
                 // INICIA TURNO JUGADOR 1 // INICIA TURNO JUGADOR 1  
                 
                 System.out.println("\n\nTURNO JUGADOR 1:\n");
                 
                 System.out.println("Jugador 1 seleccione el Pokemon a utilizar para Atacar:");
                 
                 String seleccionaPokemon=entrada.next();
                 
                 //System.out.println(seleccionaPokemon);
                 
                 String pokemon1j1 = jugador1.devuelveNombrePokemon1(); 
                 String pokemon2j1 = jugador1.devuelveNombrePokemon2();
                 String pokemon1j2 = jugador2.devuelveNombrePokemon1();
                 String pokemon2j2 = jugador2.devuelveNombrePokemon2();
                 jugador1.seleccionaPokemon(seleccionaPokemon, pokemon1j1, pokemon2j1, pokemon1j2, pokemon2j2, vector);
                 
                 int vidanueva1 = jugador1.devuelveVidaRestante1j2();
                 
                 vidanueva.estableceNuevaVida(vidanueva1);
                 
                 System.out.println("vida restante 1j2: " +  jugador1.devuelveVidaRestante1j2()  + "\nvida restante 2j2:" + jugador1.devuelveVidaRestante2j2()+"\n\n" );
                 
                 // FINALIZA TURNO JUGADOR 1 // FINALIZA TURNO JUGADOR 1
                 
                 
                 
                  // INICIA TURNO JUGADOR 2 // INICIA TURNO JUGADOR 2
                 
                   System.out.println("\n\nTURNO JUGADOR 2:\n"); 
                  
                 System.out.println("Jugador 2 seleccione el Pokemon a utilizar para Atacar:");
                 
                 String seleccionaPokemon2=entrada.next();
                 
                 
                 jugador2.seleccionaPokemon(seleccionaPokemon2, pokemon1j1, pokemon2j1, pokemon1j2, pokemon2j2, vector);
                 
                 
                 
                 // FINALIZA TURNO JUGADOR 2 // FINALIZA TURNO JUGADOR 2
                 
               }while(jugador1.devuelveVidaRestante1j2()>0 || jugador1.devuelveVidaRestante2j2()>0 || jugador2.devuelveVidaRestante1j1()>0 || jugador2.devuelveVidaRestante2j1()>0); 
                 
           
                 
          
                 
                 String nombre =jugador2.devuelveNombrePokemon1();
                // jugador1.establecePokemonAtacar(nombre, vector);
                 
                 
                 
                 // JUGADOR1 SELLECIONA POKEMON A ATACAR DE JUGADOR 2
                 
                 
                 
              }
        
    
    }
    
  }
    
}
