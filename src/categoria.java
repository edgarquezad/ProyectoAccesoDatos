import java.io.Serializable;

public class categoria  implements Serializable {
    private static final long serialVersionUID = 1L;

    private int idCategoria;
    private String titulo;

    public categoria(String titulo, int idCategoria) {
        this.titulo = titulo;
        this.idCategoria = idCategoria;
    }
    public categoria() {}

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    @Override
    public String toString() {
        return "ID: " + idCategoria + ", titulo: " + titulo;

    }
}
