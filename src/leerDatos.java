import java.io.*;

public class leerDatos {

    public static void leervideoJuego() {

        try {

            FileInputStream fichero =
                    new FileInputStream("videojuegos.dat");

            ObjectInputStream objeto =
                    new ObjectInputStream(fichero);

            listaJuegos listaJuegos = (listaJuegos) objeto.readObject();

          for(videoJuegos juego : listaJuegos.getLista()) {
              System.out.println(juego);
          }

            objeto.close();
            fichero.close();



        } catch (IOException | ClassNotFoundException e) {

            System.out.println("Error al leer el videojuego.");
            e.printStackTrace();

        }

    }



    public static void buscarVideoJuego(listaJuegos  listaJuegos , int id) {
        boolean encontrado = false;
        for (videoJuegos videoJuegos : listaJuegos.getLista()) {
            if (videoJuegos.getId() == id) {
                System.out.println(videoJuegos);
                encontrado = true;

            }
            else {
                System.out.println(videoJuegos + " no encontrado fck");
            }

        }
    }


}
