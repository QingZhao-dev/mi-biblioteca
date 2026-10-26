/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author USUARIO
 */
import java.util.Scanner;
import java.util.ArrayList;

public class Biblioteca {
    public static void main(String[]args){
        System.out.println("Bienvenido a mi biblioteca");
        
        Scanner teclado = new Scanner(System.in);
        ArrayList<Libro> libros = new ArrayList<>();
        int opcion;
        
        
        do {
            System.out.println("\n=== MI BIBLIOTECA ===");
            System.out.println("1. Añadir un libro");
            System.out.println("2. Mostrar los libros");
            System.out.println("3. Cambiar estado de lectura");
            System.out.println("4. Eliminar un libro");
            System.out.println("5. Salir");
            System.out.println("Elige una opción: ");
            
            opcion = teclado.nextInt();
            teclado.nextLine();
            
            switch (opcion) {
                case 1: 
                    System.out.println("Introduce el título del libro: ");
                    String titulo = teclado.nextLine();
                    
                    System.out.println("Introduce el autor: ");
                    String autor = teclado.nextLine();
                    
                    Libro libro = new Libro(titulo, autor);
                    libros.add(libro);
                    
                    System.out.println("¡Libro añadido correctamente!");
                    break;
                    
                case 2:
                    System.out.println("\n=== MIS LIBROS ===");
                    
                    if (libros.isEmpty()){
                        System.out.println("No hay libros en la biblioteca");
                    }else {
                        for (Libro l: libros){
                            System.out.println("Título: " + l.titulo);
                            System.out.println("Autor: " + l.autor);
                            System.out.println("Estado: " + l.estado);
                            System.out.println("--------------------");
                        }
                    }
                    break;
                case 3:
                    if (libros.isEmpty()){
                        System.out.println("No hay libros en la biblioteca");
                    }else {
                        System.out.println("¿Qué libro quieres actualizar?");
                        
                        for (int i = 0; i < libros.size(); i++){
                            System.out.println((i + 1) + ". " + libros.get(i).titulo);
                        }
                        
                        System.out.println("Elige el número del libro: ");
                        int numeroLibro = teclado.nextInt();
                        teclado.nextLine();
                        
                        if(numeroLibro >=1 && numeroLibro <= libros.size()){
                            Libro libroSeleccionado = libros.get(numeroLibro - 1);
                            
                            System.out.println("Elige el nuevo estado:");
                            System.out.println("1. Pendiente");
                            System.out.println("2. Leyendo");
                            System.out.println("3. Terminado");
                            System.out.print("Opción: ");

                            int nuevoEstado = teclado.nextInt();
                            teclado.nextLine();

                            switch (nuevoEstado) {
                                case 1:
                                    libroSeleccionado.estado = "Pendiente";
                                    break;
                                case 2:
                                    libroSeleccionado.estado = "Leyendo";
                                    break;
                                case 3:
                                    libroSeleccionado.estado = "Terminado";
                                    break;
                                default:
                                    System.out.println("Estado no válido.");
                            }

                            if (nuevoEstado >= 1 && nuevoEstado <= 3) {
                                System.out.println("¡Estado actualizado correctamente!");
                            }
                        }
                    }
                    break;
                case 4:
                    if(libros.isEmpty()){
                        System.out.println("No hay libros para eliminar");
                    }else {
                        for (int i = 0; i < libros.size(); i++) {
                            System.out.println((i+1)+". " + libros.get(i).titulo);
                        }
                        
                        System.out.println("¿Qué libro quieres eliminar?");
                        int numeroLibro = teclado.nextInt();
                        teclado.nextLine();
                        
                        if (numeroLibro >= 1 && numeroLibro <= libros.size()){
                            libros.remove(numeroLibro -1);
                            System.out.println("¡Libro eliminado correctamente!");
                        }else {
                            System.out.println("Número de libro no válido");
                        }
                    }
                    break;
                case 5:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }while (opcion !=5);
        
        teclado.close();
    }
}
