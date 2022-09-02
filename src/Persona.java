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

    public void filtrarNacionalidad(Persona[] p){
        Persona aux;
        
    }
    
    @Override
    public String toString() {
        return this.nombre + " --- " + this.apellidos + " --- " + this.edad + " --- " + this.nacionalidad + " --- " + this.email + " --- " + this.direccion + " --- " + this.sexo;
    }
}
