package datos;

import domain.Pelicula;
import excepciones.*;
import java.io.*;
import java.util.*;

public class AccesoDatosImpl implements IAccesoDatos {

    @Override
    public boolean existe(String nombreArchivo){
        File archivo = new File(nombreArchivo);
        return archivo.exists();
        
    }

    @Override
    //Listar
    public List<Pelicula> listar(String nombreArchivo) throws LecturaDatosEx{
        var archivo = new File(nombreArchivo);
        List<Pelicula> peliculas = new ArrayList<>();
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            lectura = entrada.readLine();
            while(lectura != null){
                Pelicula pelicula = new Pelicula(lectura);
                peliculas.add(pelicula);
                lectura = entrada.readLine();
            }
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas"+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al listar peliculas"+ex.getMessage());
        }
        return peliculas;
    }

    @Override
    //Agregar
    public void escribir(Pelicula pelicula, String nombreArchivo, boolean anexar) throws EscrituraDatosEx{
         File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo, anexar));
            salida.println(pelicula.toString());
            salida.close();
            System.out.println("Se ha agregado info al archivo: " +pelicula);
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new EscrituraDatosEx("Excepcion al escribir peliculas"+ex.getMessage());
        }
    }

    @Override
    //Buscar
    public String buscar(String nombreArchivo, String buscar) throws LecturaDatosEx{
        var archivo = new File(nombreArchivo);
        String resultado = null;
        try {
            var entrada = new BufferedReader(new FileReader(archivo));
            String lectura = null;
            lectura = entrada.readLine();
            var indice = 1;
            while(lectura != null){
                if(buscar != null && buscar.equalsIgnoreCase(lectura)){
                    resultado = "Pelicula " +lectura +" encontrada en el indice "+indice;
                    break;
                }
                lectura = entrada.readLine();
                indice++;
            }
            if(resultado == null)
                resultado = "Pelicula no encontrada";
            
            entrada.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar pelicula"+ex.getMessage());
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new LecturaDatosEx("Excepcion al buscar pelicula"+ex.getMessage());
        }
        return resultado;
    }

    @Override
    public void crear(String nombreArchivo) throws AccesoDatosEx{
        File archivo = new File(nombreArchivo);
        try {
            PrintWriter salida = new PrintWriter(new FileWriter(archivo));
            salida.close();
            System.out.println("Se ha creado el archivo");
        } catch (IOException ex) {
            ex.printStackTrace(System.out);
            throw new AccesoDatosEx("Excepcion al crear archivo"+ex.getMessage());
        }
    }

    @Override
    public void borrar(String nombreArchivo){
       File archivo = new File(nombreArchivo);
       if(archivo.exists())
            archivo.delete();
        System.out.println("Se ha borrado el archivo");
    }

    
    
}
