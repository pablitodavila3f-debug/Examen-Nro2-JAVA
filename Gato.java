public class Gato extends Mascota {

    public Gato(int id, String nombre, int edad) {
        super(id, nombre, edad);
    }

   
    public String getTipo() {
        return "Gato";
    }

   
    public String hacerSonido() {
        return "Miau";
    }
}