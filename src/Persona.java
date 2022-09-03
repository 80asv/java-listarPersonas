import java.util.Arrays;
import javax.swing.JOptionPane;


public class Persona {
    private String nombre;
    private String apellidos;
    private int edad;
    private String direccion;
    private String email;
    private char sexo;
    private String nacionalidad;
    

    public Persona(){}
    public Persona(String nombre, String apellidos, int edad, String direccion, String email, char sexo, String nacionalidad) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.direccion = direccion;
        this.email = email;
        this.sexo = sexo;
        this.nacionalidad = nacionalidad;
    }

    //getters y settters
    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public String getEmail() {
        return email;
    }
    
    public char getSexo() {
        return sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    //metodos
    public void saludar(Persona p1){
        JOptionPane.showMessageDialog(null, "Te saludo: " + p1.nombre);
    }
    
    public boolean esMayor(Persona p1, Persona p2){
        return p1.getEdad() > p2.getEdad();
    }

    public String nacionalidad(){
        return this.fullName() + " --- "+ this.nacionalidad;
    }

    public String fullName(){
        return this.nombre + " " + this.apellidos;
    }

    // descendentemente
    public void ordenarPorNombre(Persona[] p1){
        Persona aux;
        for (int x = 0; x < p1.length; x++) {
            for (int y = 0; y < p1.length - 1; y++) {
                int c1 = (int) (p1[x].getNombre().toLowerCase().charAt(0));
                int c2 = (int) (p1[y].getNombre().toLowerCase().charAt(0));
                if (c2 > c1) {
                    // Intercambiar
                    aux = p1[x];
                    p1[x] = p1[y];
                    p1[y] = aux;
                }
            }
        }
    }

    public void ordenarPorEdad(Persona[] p1){
        Persona aux;
        for (int x = 0; x < p1.length; x++) {
            for (int y = 0; y < p1.length - 1; y++) {
                int c1 = p1[x].getEdad();
                int c2 = p1[y].getEdad();
                if (c2 < c1) {
                    // Intercambiar
                    aux = p1[x];
                    p1[x] = p1[y];
                    p1[y] = aux;
                }
            }
        }
    }

    public String filtrarNacionalidad(Persona[] p){
        // ordenar nacionalidades
        Persona aux1;
        Persona[] clon = Arrays.copyOf(p, p.length);
        for (int x = 0; x < clon.length; x++) {
            for (int y = 0; y < clon.length - 1; y++) {
                int c1 = (int) (clon[x].getNacionalidad().toLowerCase().charAt(0));
                int c2 = (int) (clon[y].getNacionalidad().toLowerCase().charAt(0));
                if (c2 > c1) {
                    // Intercambiar
                    aux1 = clon[x];
                    clon[x] = clon[y];
                    clon[y] = aux1;
                }
            }
        }
        
        String listarRepetidos = "";
        int contador = 0; 
        String aux = clon[0].nacionalidad.toLowerCase();
        
        for(int i = 0; i < clon.length; i++) {
            if(aux.equals(clon[i].nacionalidad.toLowerCase())){
                contador++;
            } else {
                listarRepetidos = listarRepetidos + "Hay " + contador + " " + aux + "\n";
                contador = 1;
                aux = clon[i].nacionalidad.toLowerCase();
            }
        }
        listarRepetidos = listarRepetidos + "Hay " + contador + " " + aux + "\n";
        return listarRepetidos;
    }

    public String filtrarGenero(Persona[] p){
        // ordenar nacionalidades
        Persona aux1;
        Persona[] clon = Arrays.copyOf(p, p.length);
        for (int x = 0; x < clon.length; x++) {
            for (int y = 0; y < clon.length - 1; y++) {
                int c1 = (int) (Character.toLowerCase(clon[x].sexo));
                int c2 = (int) (Character.toLowerCase(clon[y].sexo));
                if (c2 > c1) {
                    // Intercambiar
                    aux1 = clon[x];
                    clon[x] = clon[y];
                    clon[y] = aux1;
                }
            }
        }
        
        String genero="";
        String listarRepetidos = "";
        int contador = 0; 
        char aux = Character.toLowerCase(clon[0].sexo);
        
        for(int i = 0; i < clon.length; i++) {
            if(aux == Character.toLowerCase(clon[i].sexo)){
                contador++;
            } else {
                genero = (aux == 'f') ? "mujer(es)" : "hombre(s)";
                listarRepetidos = listarRepetidos + "Hay " + contador + " " + genero + "\n";
                contador = 1;
                aux = Character.toLowerCase(clon[i].sexo);
            }
        }
        genero = (aux == 'f') ? "mujer(es)" : "hombre(s)";
        listarRepetidos = listarRepetidos + "Hay " + contador + " " + genero + "\n";
        return listarRepetidos;
    }
    
    @Override
    public String toString() {
        return this.nombre + " --- " + this.apellidos + " --- " + this.edad + " --- " + this.nacionalidad + " --- " + this.email + " --- " + this.direccion + " --- " + this.sexo;
    }
}
