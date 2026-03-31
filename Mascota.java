/*
Examen Nro 2 JAVA 
Nombre: Pablo Dávila
Fecha: 30/03/2026 
*/
// Mascota.java
public class Mascota {

    private int id;
    private String nombre;
    private int edad;

    public Mascota(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    // Setters
    public void setId(int id) { this.id = id; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }

    public String getTipo() {
        return "Mascota";
    }

    public String hacerSonido() {
        return "...";
    }

    public void mostrarInfo() {
        System.out.println("----------------------------------");
        System.out.println("  ID     : " + id);
        System.out.println("  Nombre : " + nombre);
        System.out.println("  Edad   : " + edad + " año(s)");
        System.out.println("  Tipo   : " + getTipo());
        System.out.println("  Sonido : " + hacerSonido());
        System.out.println("----------------------------------");
    }
}      System.out.println(n/"Especie: " + especie);
        System.out.println(n/"Edad:    " + edad + " años");
        
    {

    }
