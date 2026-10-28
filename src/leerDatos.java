import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
                System.out.println("videojuego encontrado " + videoJuegos);

                System.out.println("introduce el nuevo titulo : ");
                String nuevoTitulo = sc.nextLine();

                System.out.println("introduce el nuevo precio : ");
                double precio = sc.nextDouble();
                //modificamos el precio con el metodo set en la clase videojuego
                videoJuegos.setTitulo(nuevoTitulo);
                videoJuegos.setPrecio(precio);
                listaCategorias listaCategorias = new listaCategorias();
                leerCategorias(listaCategorias);

                if (!listaCategorias.getListaCategoria().isEmpty()) {
                    System.out.println("categorias disponibles");
                    for (categoria categoria : listaCategorias.getListaCategoria()) {
                        System.out.println(categoria);
                    }
                    System.out.println("introduce el id de la nueva categoria: ");
                    int idCategoria = sc.nextInt();
                    categoria categoriaElegida = null;

                    for (categoria categoria : listaCategorias.getListaCategoria()) {
                        if (categoria.getIdCategoria() == idCategoria) {
                            categoriaElegida = categoria;
                            break;
                        }
                    }
                    if (categoriaElegida != null) {
                        videoJuegos.setCategoria(categoriaElegida);
                    } else {
                        System.out.println("Categoria no encontrada.");
                    }

                }


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
        if (!encontrado) {
            System.out.println("Videojuego no encontrado.");
        }
    }

    /// ////////////7777


    public static void leerCategorias(listaCategorias lista) {
        File archivo = new File("categorias.dat");

        if (!archivo.exists() || archivo.length() == 0) {
            return;
        }

        try {
            FileInputStream fichero = new FileInputStream("categorias.dat");
            ObjectInputStream objeto = new ObjectInputStream(fichero);

            listaCategorias listaCategorias = (listaCategorias) objeto.readObject();

            lista.getListaCategoria().clear();
            lista.getListaCategoria().addAll(listaCategorias.getListaCategoria());

            for (categoria categoria : listaCategorias.getListaCategoria()) {
                System.out.println(categoria);
            }

            objeto.close();
            fichero.close();

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer las categorías.");
            e.printStackTrace();
        }
    }

    public static void mostrarCategorias(listaCategorias listaCategorias) {
        if (listaCategorias.getListaCategoria().isEmpty()) {
            System.out.println("No hay categorías guardadas.");
            return;
        }

        System.out.println("--- Lista de categorías ---");

        for (categoria categoria : listaCategorias.getListaCategoria()) {
            System.out.println(categoria);
        }
    }

    public static boolean EliminarCategoria(listaCategorias listaCategorias, int id) {
        boolean encontrado = false;

        for (int i = 0; i < listaCategorias.getListaCategoria().size(); i++) {

            categoria categoria = listaCategorias.getListaCategoria().get(i);

            if (categoria.getIdCategoria() == id) {
                listaCategorias.getListaCategoria().remove(categoria);
                System.out.println("removido correctamente: " + categoria.getTitulo());
                encontrado = true;

                break;

            }

        }
        return encontrado;
    }
}









