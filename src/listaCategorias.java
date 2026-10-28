import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class listaCategorias implements Serializable {
    private static final long serialVersionUID = 1L;
    public List<categoria> listaCategoria = new ArrayList<categoria>();

    public listaCategorias() {

    }

    public void addCategoria(categoria categoria) {
        listaCategoria.add(categoria);
    }

    public List<categoria> getListaCategoria() {
        return listaCategoria;
    }
}
