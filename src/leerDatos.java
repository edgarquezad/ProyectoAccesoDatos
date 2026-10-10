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


}
