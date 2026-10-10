import java.io.Serializable;

public class videoJuegos implements Serializable {

    private int id;
    private String titulo;
    private double precio;


    public videoJuegos(int id, String titulo, double precio) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;

    }

    public int getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPrecio() {
        return precio;
    }


    @Override
    public String toString() {
        return "ID: " + id +
                " | Título: " + titulo +
                " | Precio: " + precio ;
    }
}


