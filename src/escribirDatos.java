import java.io.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

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

    public static void guardarCategoria(listaCategorias listaCategorias) {
        try {
            FileOutputStream fichero = new FileOutputStream("categorias.dat");
            ObjectOutputStream objeto = new ObjectOutputStream(fichero);

            objeto.writeObject(listaCategorias);

            objeto.close();
            fichero.close();

            System.out.println("Categorías guardadas correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar las categorías.");
            e.printStackTrace();
        }

    }

    public static void exportarJuegos(listaJuegos listaJuegos) {
        try{
            XStream xstream = new XStream(new DomDriver());
            xstream.alias("listaJuego", listaJuegos.class);
            xstream.alias("videojuego", videoJuegos.class);
            xstream.addImplicitCollection(listaJuegos.class, "lista");
            xstream.toXML(listaJuegos,new FileOutputStream("videojuegos.xml"));
            System.out.println("creado el videojuegos.xml");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}

