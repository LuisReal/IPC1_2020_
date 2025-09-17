import java.util.Scanner;

public class Pokemon {
    
    private Pokemon[] misPokemon;
    
    private String nombre;
    
    private String imagen;
    
    private int ataque;
    
    private int vida;
    
    private String estado;
    
    public Pokemon(String imagen, String nombre, int vida, int ataque, String estado ){

        this.imagen = imagen;
        this.nombre = nombre;
        this.vida = vida;
        this.ataque = ataque;
        this.estado = estado;
        misPokemon = new Pokemon[20];
        
        
    }
    
    public Pokemon[] mostrarLista(){ 
    
        int[] vida = new int[20];
        
         for(int i=0 ; i<=19 ; i++){ 
        
           
            vida[i]= (int)(Math.random()*(100-50+1)+50);
        
        
        }
        
        
        
        int[] ataque = new int[20];
        
        for(int i=0 ; i<=19 ; i++){ 
        
           
            ataque[i]= (int)(Math.random()*(20-5+1)+5);
        
        
        }
        
        
                         misPokemon[0]= new Pokemon("imagen","alakazam", vida[0], ataque[0], "vivo");
                         misPokemon[1]= new Pokemon("imagen", "arcanine", vida[1], ataque[1], "vivo");
                         misPokemon[2]= new Pokemon("imagen","articuno", vida[2], ataque[2], "vivo");
                         
                         misPokemon[3]= new Pokemon("imagen","bellsprout", vida[3], ataque[3], "vivo");
                         misPokemon[4]= new Pokemon("imagen","bulbasaur", vida[4], ataque[4], "vivo");
                         misPokemon[5]= new Pokemon("imagen","butterfree", vida[5], ataque[5], "vivo");
    
     return misPokemon;
    }
    
    
    
    public void estableceNuevaVida(int vida){ 
    
      this.vida = vida;
    
    }
    
    public String dameNombre(){
    
        return nombre;
        
    }
    
    public int dameAtaque(){ 
    
        return ataque;
    
    }
    
    public int dameVida(){ 
    
        return vida;
    }
    
    public String devuelveImagen(){ 
    
        return imagen;
    
    }
    
    public String dameEstado(){ 
    
        return estado;
        
    }
    

    
    public void editarPokemon(String nombre){ 
    
        
        // ALAKAZAM // ALAKAZAM // ALAKAZAM // ALAKAZAM//
        
        
        if(nombre.equals("alakazam")){
         
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre");
            
            String nombre1 = entrada.next();

           /* System.out.println("Ingrese la imagen");
            String imagen1 = entrada.next();*/
            
            System.out.println("Ingrese el valor de la vida");
            int vida1= entrada.nextInt();
            
            System.out.println("Ingrese el valor del ataque");
            int ataque1 = entrada.nextInt();
            
            
           this.nombre=nombre1;
           this.ataque=ataque1;
          // this.imagen=imagen1;
           this.vida=vida1;
        
        }
        
        // ARCANINE // ARCANINE // ARCANINE // ARCANINE//
        
        if(nombre.equals("arcanine")){
         
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre");
            
            String nombre1 = entrada.next();

           /* System.out.println("Ingrese la imagen");
            String imagen1 = entrada.next();*/
            
            System.out.println("Ingrese el valor de la vida");
            int vida1= entrada.nextInt();
            
            System.out.println("Ingrese el valor del ataque");
            int ataque1 = entrada.nextInt();
            
            
           this.nombre=nombre1;
           this.ataque=ataque1;
          // this.imagen=imagen1;
           this.vida=vida1;
        
        }
        
        // ARTICUNO // ARTICUNO // ARTICUNO // ARTICUNO//
        
         if(nombre.equals("articuno")){
         
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre");
            
            String nombre1 = entrada.next();

           /* System.out.println("Ingrese la imagen");
            String imagen1 = entrada.next();*/
            
            System.out.println("Ingrese el valor de la vida");
            int vida1= entrada.nextInt();
            
            System.out.println("Ingrese el valor del ataque");
            int ataque1 = entrada.nextInt();
            
            
           this.nombre=nombre1;
           this.ataque=ataque1;
          // this.imagen=imagen1;
           this.vida=vida1;
        
        }
         
         // BELLSPROUT // BELLSPROUT // BELLSPROUT // BELLSPROUT//
     
         if(nombre.equals("bellsprout")){
         
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre");
            
            String nombre1 = entrada.next();

           /* System.out.println("Ingrese la imagen");
            String imagen1 = entrada.next();*/
            
            System.out.println("Ingrese el valor de la vida");
            int vida1= entrada.nextInt();
            
            System.out.println("Ingrese el valor del ataque");
            int ataque1 = entrada.nextInt();
            
            
           this.nombre=nombre1;
           this.ataque=ataque1;
          // this.imagen=imagen1;
           this.vida=vida1;
        
        }
         
         // BULBASAUR // BULBASAUR // BULBASAUR // BULBASAUR//
         
         if(nombre.equals("bulbasaur")){
         
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre");
            
            String nombre1 = entrada.next();

           /* System.out.println("Ingrese la imagen");
            String imagen1 = entrada.next();*/
            
            System.out.println("Ingrese el valor de la vida");
            int vida1= entrada.nextInt();
            
            System.out.println("Ingrese el valor del ataque");
            int ataque1 = entrada.nextInt();
            
            
           this.nombre=nombre1;
           this.ataque=ataque1;
          // this.imagen=imagen1;
           this.vida=vida1;
        
        }
         
         // BUTTERFREE // BUTTERFREE // BUTTERFREE // BUTTERFREE//
         
         if(nombre.equals("butterfree")){
         
            Scanner entrada = new Scanner(System.in);
            System.out.println("Ingrese el nuevo nombre");
            
            String nombre1 = entrada.next();

           /* System.out.println("Ingrese la imagen");
            String imagen1 = entrada.next();*/
            
            System.out.println("Ingrese el valor de la vida");
            int vida1= entrada.nextInt();
            
            System.out.println("Ingrese el valor del ataque");
            int ataque1 = entrada.nextInt();
            
            
           this.nombre=nombre1;
           this.ataque=ataque1;
          // this.imagen=imagen1;
           this.vida=vida1;
        
        }
    } // FIN METODO EDITAR POKEMON
    
    
    
    
}
