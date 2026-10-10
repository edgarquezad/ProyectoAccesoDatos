import java.io.Serializable;

public class videoJuegos implements Serializable {
    private static final long serialVersionUID = 1L;

    private int id;
    private String titulo;
    private double precio;
    private categoria categoria;


    public videoJuegos(int id, String titulo, double precio ,categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.categoria = categoria;

    }

    public categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(categoria categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setId(int id) {
        this.id = id;
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
                " | Precio: " + precio +
                " | Categoria: " + categoria ;
    }
}


