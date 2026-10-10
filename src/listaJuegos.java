
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class listaJuegos implements Serializable {
    private static final long serialVersionUID = 1L;
    public List<videoJuegos> lista = new ArrayList<videoJuegos>();

    public listaJuegos(){
    }

    public void addJuegos(videoJuegos juegos) {
        lista.add(juegos);

    }
    public List<videoJuegos> getLista() {
        return lista;
    }

}
