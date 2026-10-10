import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class escribirDatos {

    public static void guardarVideojuego(listaJuegos listaJuegos) {

        try {

            FileOutputStream fichero =
                    new FileOutputStream("videojuegos.dat");

            ObjectOutputStream objeto =
                    new ObjectOutputStream(fichero);

            objeto.writeObject(listaJuegos);

            objeto.close();
            fichero.close();

            System.out.println("Videojuegos guardado correctamente.");

        } catch (IOException e) {

            System.out.println("Error al guardar el videojuego.");
            e.printStackTrace();
        }
    }
}

