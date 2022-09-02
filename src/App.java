import java.util.Arrays;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class App {
    static Scanner entrada = new Scanner(System.in);
    static String nombres, apellidos, direccion, email, nacionalidad;
    static int edad, op; 
    static char sexo;
    static int nPersonas;

    public static String listar(int nPersons, Persona p1[]){
        String listado = "";
        for(int i = 0; i < nPersonas; i++){
            listado = listado + (i+1) + ". " + p1[i].fullName() + "\n";
        }
        return listado;
    }

    public static void main(String[] args) throws Exception {
        System.out.print("Ingrese el numero de personas a registrar: ");
        nPersonas = entrada.nextInt();
        
        Persona aux = new Persona();
        Persona personas[] = new Persona[nPersonas];

        for(int i = 0; i < nPersonas; i++){
            entrada.nextLine();
            System.out.println("Ingrese los datos de la persona " + (i+1));
        
            System.out.print("Nombres: ");
            nombres = entrada.nextLine();
            
            System.out.print("Apellidos: ");
            apellidos = entrada.nextLine();
            
            System.out.print("Direccion: ");
            direccion = entrada.nextLine();
            
            System.out.print("Email: ");
            email = entrada.nextLine();
            
            System.out.print("Nacionalidad: ");
            nacionalidad = entrada.nextLine();
            
            System.out.print("Edad: ");
            edad = entrada.nextInt();
            
            System.out.print("Sexo (M/F): ");
            sexo = Character.toLowerCase(entrada.next().charAt(0));
            while(sexo != 'f' && sexo != 'm'){
                System.out.println("OPCION NO VALIDA, vuelve a intertarlo");
                System.out.print("Sexo (M/F): ");
                sexo = Character.toLowerCase(entrada.next().charAt(0));
            }
        
            personas[i] = new Persona(nombres, apellidos, edad, direccion, email, sexo, nacionalidad);
        }
        
        System.out.println("LOS DATOS HAN SIDO REGITRADOS. POR FAVOR REVISAR VENTANA EMERGENTE");

        do{
            op = Integer.parseInt(JOptionPane.showInputDialog("¿Qué desea hacer?\n\n" +
                                                              "1. Saludar\n" +
                                                              "2. Saber si la persona es mayor de edad\n" +
                                                              "3. Ver nacionalidad de las personas\n" +
                                                              "4. Ver nombre completo de las personas\n" +
                                                              "5. Modificar email de una persona\n" +
                                                              "6. Ver listado de por nombres\n" +
                                                              "7. Ver listado de por edad\n" +
                                                              "8. Contar nacionalidades\n" +
                                                              "9. Contar Generos\n\n" +
                                                              "0. Salir del programa"));
            switch(op){
                case 1:
                    int elejirNombre = Integer.parseInt(JOptionPane.showInputDialog("A quien desea saludar\n\n" + listar(nPersonas, personas)));
                    aux.saludar(personas[elejirNombre-1]);
                break;

                case 2:
                    int p1 = Integer.parseInt(JOptionPane.showInputDialog("Eliga la primera persona para comparar la edad\n\n" + listar(nPersonas, personas)));
                    int p2 = Integer.parseInt(JOptionPane.showInputDialog("Eliga la segunda persona para comparar la edad\n\n" + listar(nPersonas, personas)));
                    if(aux.esMayor(personas[p1-1], personas[p2-1])){
                        JOptionPane.showMessageDialog(null, personas[p1-1].getNombre() + " es mayor que " + personas[p2-1].getNombre());
                    } else {
                        JOptionPane.showMessageDialog(null, personas[p2-1].getNombre() + " es mayor que " + personas[p1-1].getNombre());
                    }
                break;

                case 3:
                    String nacionalidades = "";
                    for(int i = 0; i < nPersonas; i++){
                        nacionalidades += (i+1) + ". " + personas[i].nacionalidad() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Nacionalidades de las personas\n\n" + nacionalidades);
                break;
                
                case 4:
                    String nombresCompletos = "";
                    for(int i = 0; i < nPersonas; i++){
                        nombresCompletos += (i+1) + ". " + personas[i].fullName() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Nombres completos de las personas\n\n " + nombresCompletos);
                break;

                case 5:
                    int cambiarEmail =  Integer.parseInt(JOptionPane.showInputDialog("Elija la persona a la que le cambiara el email\n" + listar(nPersonas, personas)));
                    String newEmail = JOptionPane.showInputDialog("Ingrese el nuevo correo de " + personas[cambiarEmail-1].getNombre());
                    personas[cambiarEmail-1].setEmail(newEmail);
                    JOptionPane.showMessageDialog(null, "El correo de " + personas[cambiarEmail-1].fullName() + " ha sido cambiado con exito");
                break;

                case 6:
                    String listadoNombres = "";
                    Persona[] ordenPorNombre = Arrays.copyOf(personas, personas.length);
                    aux.ordenarPorNombre(ordenPorNombre);
                    for(int i = 0; i < nPersonas; i++){
                        listadoNombres += ordenPorNombre[i].toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Listado por nombres\n\n" + listadoNombres);
                break;

                case 7:
                    String listadoEdades = "";
                    Persona[] ordenPorEdad = Arrays.copyOf(personas, personas.length);
                    aux.ordenarPorEdad(ordenPorEdad);
                    for(int i = 0; i < nPersonas; i++){
                        listadoEdades += ordenPorEdad[i].toString() + "\n";
                    }
                    JOptionPane.showMessageDialog(null, "Listado por Edades\n\n" + listadoEdades);
                break;
                case 8:
                    String filtroNacionalidad = aux.filtrarNacionalidad(personas);
                    JOptionPane.showMessageDialog(null, "Listado por nacionalidades\n\n " + listar(nPersonas, personas) + "\n" + filtroNacionalidad);
                break;
                case 9:
                    String filtroGenero = aux.filtrarGenero(personas);
                    JOptionPane.showMessageDialog(null, "Listado por Genero\n\n" + listar(nPersonas, personas) + "\n" + filtroGenero);
                break;
            }
        }while(op!=0);
    }
}
