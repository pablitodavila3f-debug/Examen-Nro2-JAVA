public class Perro extends Mascota {

    public Perro(int id, String nombre, int edad) {
        super(id, nombre, edad);
    }

    
    public String getTipo() {
        return "Perro";
    }

     
    public String hacerSonido() {
        return "Guau ";
    }
}
