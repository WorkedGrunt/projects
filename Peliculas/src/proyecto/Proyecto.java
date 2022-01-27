package proyecto;


import domain.Pelicula;
import negocio.ICatalogoPeliculas;
import java.util.Scanner;
import negocio.CatalogoPeliculasImpl;

public class Proyecto {
    
    
    public static void main(String[] args) {
        var opcion = -1;
        String nombreArchivo;
        Scanner consola = new Scanner(System.in);
        ICatalogoPeliculas catalogoPeliculas = new CatalogoPeliculasImpl();
        
        while(opcion != 0){
            
        
        System.out.println("1. Iniciar catalogo peliculas");
        System.out.println("2. Agregar pelicula");
        System.out.println("3. Listar Peliculas");
        System.out.println("4. Buscar Pelicula");
        System.out.println("0. Salir");
        
        
        opcion = Integer.parseInt(consola.nextLine());
        
        switch(opcion){
            case 1:
                catalogoPeliculas.iniciarCatalagoPeliculas();
                break;
               
            case 2:
                System.out.println("Introduce el nombre de la pelicula a agregar");
                var nombrePelicula = consola.nextLine();
                catalogoPeliculas.agregarPelicula(nombrePelicula);    
                break;
                
            case 3:
                catalogoPeliculas.listarPeliculas();
                break;
                
            case 4:
                System.out.println("Introduce el nombre de la pelicula a buscar");
                var buscar = consola.nextLine();
                catalogoPeliculas.buscarPelicula(buscar);
                break;
            
            case 0:
                System.out.println("Hasta pronto!");
                break;
             
            default:
                System.out.println("Opcion no reconocida");
                break;
        }
        
        }
    }
}
