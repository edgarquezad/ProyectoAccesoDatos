import java.io.*;

public class leerDatos {

    public static void leervideoJuego(listaJuegos lista) {

        File archivo = new File("videojuegos.dat");

        if (!archivo.exists() || archivo.length() == 0) {
            return;
        }

        try {
            FileInputStream fichero =
                    new FileInputStream("videojuegos.dat");

            ObjectInputStream objeto =
                    new ObjectInputStream(fichero);

            listaJuegos listaJuegos =
                    (listaJuegos) objeto.readObject();

            lista.getLista().clear();
            lista.getLista().addAll(listaJuegos.getLista());

            for (videoJuegos juego : listaJuegos.getLista()) {
                System.out.println(juego);
            }

            objeto.close();
            fichero.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el videojuego.");
            e.printStackTrace();
        }
    }



    public static void buscarVideoJuego(listaJuegos listaJuegos, String tituloNombre, int id) {

        boolean encontrado = false;

        for (videoJuegos videoJuegos : listaJuegos.getLista()) {

            if (tituloNombre != null &&
                    videoJuegos.getTitulo().equalsIgnoreCase(tituloNombre)) {

                System.out.println(videoJuegos);
                encontrado = true;

            } else if (id != -1 && videoJuegos.getId() == id) {

                System.out.println(videoJuegos);
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Videojuego no encontrado.");
        }
    }
}




