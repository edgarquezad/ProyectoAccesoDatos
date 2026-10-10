import java.io.*;
import java.util.Scanner;

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

    public static void modificarJuego(listaJuegos listaJuegos, int id) {
        boolean encontrado = false;
        Scanner sc = new Scanner(System.in);
        for (videoJuegos videoJuegos : listaJuegos.getLista()) {
            if (videoJuegos.getId() == id) {

                System.out.println(videoJuegos);

                System.out.println("introduce el nuevo titulo : ");
                String nuevoTitulo = sc.nextLine();

                System.out.println("introduce el nuevo precio : ");
                double precio = sc.nextDouble();
                //modificamos el precio con el metodo set en la clase videojuego
                videoJuegos.setTitulo(nuevoTitulo);
                videoJuegos.setPrecio(precio);


                escribirDatos.guardarVideojuego(listaJuegos);
                System.out.println("modificado correctamente ");
                encontrado = true;
                break;


            }
        }
        if (!encontrado) {
            System.out.println("Videojuego no encontrado.");
        }

    }

    public static void eliminarJuego(listaJuegos listaJuegos, int id) {
        boolean encontrado = false;
        for (videoJuegos videoJuegos : listaJuegos.getLista()) {
            if (videoJuegos.getId() == id) {
                listaJuegos.getLista().remove(videoJuegos);
                escribirDatos.guardarVideojuego(listaJuegos);
                System.out.println(videoJuegos.getTitulo() + " eliminado correctamente");
                encontrado = true;
                break;
            }


        }
        if(!encontrado) {
            System.out.println("Videojuego no encontrado.");
        }
    }


}




