/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Blockbuster;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author victoriaacuna
 */
public class Metodos {
    
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
    
    public static void Escribir(){
        File miArchivo; // Para manipular el nombreArchivo.
        PrintWriter escribir; // Para escribir en el nombreArchivo.
        miArchivo = new File("baseDatos.txt"); //Se prepara el nombreArchivo, se instancia.
        String contenido = Metodos.escribirUsuarios() + Metodos.escribirPeliculas() + Metodos.escribirIndexPeliculas()
                + Metodos.escribirIndexUsuarios()+"FIN";
        if(!miArchivo.exists()){
            try {
                miArchivo.createNewFile(); //Crear el nombreArchivo si no hay uno.
            } catch (IOException ex) {
                Logger.getLogger(Metodos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            try {
                escribir = new PrintWriter(miArchivo,"utf-8");
                escribir.println(contenido);
                escribir.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            
        }    
    }
    
    public static String escribirUsuarios(){
        if(Cartelera.firstUser){
            String usuarios="USUARIOS\n";
            for (int i = 0; i < Cartelera.users.length; i++) {
                usuarios=usuarios+Cartelera.users[i].getName()+"-"+Cartelera.users[i].getCI()+"-"+Cartelera.users[i].getPhone()+"-"+Cartelera.users[i].firstMovie;
                if(Cartelera.users[i].firstMovie){
                    for (int j = 0; j < Cartelera.users[i].peliculas.length; j++) {
                        usuarios=usuarios+"-"+Cartelera.users[i].peliculas[j].getID();
                    }
                    usuarios=usuarios+"\n";
                } else {
                    usuarios=usuarios+"\n";
                }
            }
            return usuarios;
        } else {
            return "";
        }
    }
    
    public static String escribirPeliculas(){
        if(Cartelera.firstMovie){
            String peliculas="PELICULAS\n";
            for (int i = 0; i < Cartelera.movies.length; i++) {
                peliculas=peliculas+Cartelera.movies[i].getID()+"-"+Cartelera.movies[i].getName()+"-"+Cartelera.movies[i].getGenre()+"-"+Cartelera.movies[i].getCI()+"-"+Cartelera.movies[i].getDate()+"\n";
            }
            return peliculas;
        } else {
            return "";
        }
    }
    
    public static String escribirIndexPeliculas(){
        if(Cartelera.firstMovie){
            String indexPeliculas="INDEXPELICULA\n";
            for (int i = 0; i < Cartelera.movieIndexes.length; i++) {
                indexPeliculas=indexPeliculas+Integer.toString(Cartelera.movieIndexes[i].getArrayIndex())+"-"+Integer.toString(Cartelera.movieIndexes[i].getMovieID())+"\n";
            }
            return indexPeliculas;  
        } else {
            return "";
        }
    }
    
    public static String escribirIndexUsuarios(){
        if(Cartelera.firstUser){
            String indexUsuarios="INDEXUSUARIO\n";
            for (int i = 0; i < Cartelera.userIndexes.length; i++) {
                indexUsuarios=indexUsuarios+Cartelera.userIndexes[i].getArrayIndex()+"-"+Cartelera.userIndexes[i].getUserCI()+"-"+Cartelera.userIndexes[i].getUserLiteralCI()+"\n";
            }
            return indexUsuarios;   
        } else {
            return "";
        }
    }
    
    public static void crearUsuarios(){
        String linea="";
            try {
                BufferedReader br = new BufferedReader(new FileReader("baseDatos.txt"));
                int cont =0;
                while ((linea= br.readLine())!=null && !linea.contains("PELICULAS") && !linea.contains("INDEXPELICULAS") && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN")) {
                    if(linea.contains("USUARIOS")&&(linea= br.readLine())!=null) {
                        Cartelera.firstUser=true;
                        do{
                            cont=cont+1;
                        } while((linea=br.readLine())!=null && !linea.contains("PELICULAS") && !linea.contains("INDEXPELICULAS") && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN"));
                    }
                }
                if(cont>0){
                    BufferedReader br2 = new BufferedReader(new FileReader("baseDatos.txt"));
                    User[] u = new User[cont];
                    cont=0;
                    while ((linea= br2.readLine())!=null && !linea.contains("PELICULAS") && !linea.contains("INDEXPELICULAS") && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN")) {
                    if(linea.contains("USUARIOS")&&(linea= br2.readLine())!=null) {
                        do{
                            String[] datos = linea.split("-");
                            User newU = new User(Integer.parseInt(datos[2]), datos[0], datos[1]);
                            if(datos[3].equals("true")){
                                newU.firstMovie=true;
                                Pelicula[] p = new Pelicula[datos.length-4];
                                int aux=0;
                                for (int i = 4; i < datos.length; i++) {
                                    int movieID = Integer.parseInt(datos[i]);
                                    int pos = Cartelera.buscarPelicula(movieID);
                                    p[aux]=Cartelera.movies[pos];
                                    aux=aux+1;
                                }
                                newU.peliculas=p;
                            } else {
                                newU.firstMovie=false;
                            }
                            u[cont]=newU;
                            cont=cont+1;
                        } while((linea=br2.readLine())!=null && !linea.contains("PELICULAS") && !linea.contains("INDEXPELICULA") && !linea.contains("INDEXUSUARIO")  && !linea.contains("FIN"));
                        Cartelera.users=u;
                    }
                }
                }
            } catch(Exception e){
            }    
    }
    
    
    public static void crearIndexUsuarios(){
        String linea="";
            try {
                BufferedReader br = new BufferedReader(new FileReader("baseDatos.txt"));
                int cont =0;
                while ((linea= br.readLine())!=null && !linea.contains("FIN")) {
                    if(linea.contains("INDEXUSUARIO")&&(linea= br.readLine())!=null) {
                        do{
                            cont=cont+1;
                        } while((linea=br.readLine())!=null  && !linea.contains("FIN"));
                       
                    }
                }
                if(cont>0){
                    BufferedReader br2 = new BufferedReader(new FileReader("baseDatos.txt"));
                    UserIndex[] u = new UserIndex[cont];
                    cont=0;
                    while ((linea= br2.readLine())!=null && !linea.contains("FIN")) {
                            if(linea.contains("INDEXUSUARIO")&&(linea= br2.readLine())!=null) {
                                do{
                                    String[] datos = linea.split("-");
                                    UserIndex newU = new UserIndex(Integer.parseInt(datos[1]), Integer.parseInt(datos[0]), datos[2]);
                                    u[cont]=newU;
                                    cont=cont+1;
                                } while((linea=br2.readLine())!=null && !linea.contains("FIN"));
                                Cartelera.userIndexes=u;
                            }
                    }
                }
            } catch(Exception e){
            }    
    }
    
    public static void crearIndexPeliculas(){
        String linea="";

            try {
                BufferedReader br = new BufferedReader(new FileReader("baseDatos.txt"));
                int cont =0;
                while ((linea= br.readLine())!=null && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN")) {
                    if(linea.contains("INDEXPELICULA")&&(linea= br.readLine())!=null) {
                        do{
                            cont=cont+1;
                        } while((linea=br.readLine())!=null && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN"));
                    }
                }
                if(cont>0){
                    BufferedReader br2 = new BufferedReader(new FileReader("baseDatos.txt"));
                    MovieIndex[] u = new MovieIndex[cont];
                    boolean done=false;
                    cont=0;
                    while ((linea= br2.readLine())!=null && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN") && !done) {
                        if(linea.contains("INDEXPELICULA")&&(linea= br2.readLine())!=null) {
                            done=true;
                            do{
                                String[] datos = linea.split("-");
                                u[cont]=new MovieIndex(Integer.parseInt(datos[1]),Integer.parseInt(datos[0]));
                                cont=cont+1;
                            } while((linea=br2.readLine())!=null && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN"));
                             Cartelera.movieIndexes=u;
                        }
                    }
                }
            } catch(Exception e){
            }    
    }
    
    public static void crearPeliculas(){
        String linea="";
            try {
                BufferedReader br = new BufferedReader(new FileReader("baseDatos.txt"));
                int cont =0;
                while ((linea= br.readLine())!=null && !linea.contains("INDEXPELICULA") && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN")) {
                    if(linea.contains("PELICULAS")&&(linea= br.readLine())!=null) {
                        Cartelera.firstMovie=true;
                        do{
                            cont=cont+1;
                        } while((linea=br.readLine())!=null && !linea.contains("INDEXPELICULA") && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN"));
                    }
                }
                if(cont>0){
                    BufferedReader br2 = new BufferedReader(new FileReader("baseDatos.txt"));
                    Pelicula[] u = new Pelicula[cont];
                    cont=0;
                    while ((linea= br2.readLine())!=null && !linea.contains("INDEXPELICULA") && !linea.contains("INDEXUSUARIO") && !linea.contains("FIN")) {
                    if(linea.contains("PELICULAS")&&(linea= br2.readLine())!=null) {
                        do{
                            String[] datos = linea.split("-");
                            Pelicula newU = new Pelicula(datos[1], datos[2], Integer.parseInt(datos[0]));
                            if(datos.length>3){
                                newU.setDate(datos[4]);
                                newU.setCI(datos[3]);
                            }
                            u[cont]=newU;
                            cont=cont+1;
                        } while((linea=br2.readLine())!=null && !linea.contains("PELICULAS") && !linea.contains("INDEXPELICULA") && !linea.contains("INDEXUSUARIO")  && !linea.contains("FIN"));
                        Cartelera.movies=u;
                    }
                }
                }
            } catch(Exception e){
            }    
    }
    
}
