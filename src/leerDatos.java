import java.io.*;

public class leerDatos {

    public static void leervideoJuego(listaJuegos lista) {

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
            if (videoJuegos.getTitulo().equalsIgnoreCase(tituloNombre)) {
                System.out.println(videoJuegos);
                encontrado = true;

            } else if (!encontrado) {
                System.out.println(videoJuegos + " no encontrado fck");
            }

        }

        for (videoJuegos videoJuegos : listaJuegos.getLista()) {
            if (id != -1 && videoJuegos.getId() == id) {
                System.out.println(videoJuegos);
                encontrado = true;

            } else if (!encontrado) {

                System.out.println(videoJuegos + " no encontrado fck");
            }

        }
    }


}
