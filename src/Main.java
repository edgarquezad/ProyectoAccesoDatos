import java.io.IOException;
import java.util.Scanner;

void main() throws IOException {
    Scanner sc = new Scanner(System.in);
    listaJuegos lista = new listaJuegos();
    leerDatos.leervideoJuego(lista);

    listaCategorias listaCategorias = new listaCategorias();
    leerDatos.leerCategorias(listaCategorias);

    int opcion = -1;

    while (opcion != 0) {

        System.out.println("\n------ GESTIÓN DE VIDEOJUEGOS ------");
        System.out.println("0 = Salir");
        System.out.println("1 = Crear videojuego");
        System.out.println("2 = Mostrar videojuegos");
        System.out.println("3 = Buscar videojuego");
        System.out.println("4 = Modificar videojuego");
        System.out.println("5 = Eliminar videojuego");
        System.out.println("6 = Exportar videojuegos a XML");
        System.out.println("7 = Agregar Categorias");

        System.out.print("\n Ingresa la opción: ");
        String entrada = sc.nextLine();

        if (!entrada.matches("[0-9]+")) {
            System.out.println("No se permiten caracteres. Debes introducir un número.");
            continue;
        }

        opcion = Integer.parseInt(entrada);

        if (opcion == 1) {
            System.out.println(" escribe un id para el juego ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println(" escribe un titulo para el juego ");
            String titulo = sc.nextLine();
            System.out.println(" escribe un precio para el juego ");
            double precio = Double.parseDouble(sc.nextLine());
            if (listaCategorias.getListaCategoria().isEmpty()) {
                System.out.println("No hay categorías creadas. Crea una categoría primero.");
                continue;
            }

            System.out.println("categorias disponibles");

            for (categoria categoria : listaCategorias.getListaCategoria()) {
                System.out.println(categoria);
            }
            System.out.println("escribir el id de la categoria");
            int categoriaId = Integer.parseInt(sc.nextLine());
            categoria categoriaElegida = null ;
            for (categoria categoria : listaCategorias.getListaCategoria()) {
                if (categoria.getIdCategoria() == categoriaId) {
                    categoriaElegida = categoria;
                    break;
                }
            }
            if (categoriaElegida == null) {
                System.out.println("No se encontro la categoria");
                continue;
            }

            videoJuegos Juegos = new videoJuegos(id, titulo, precio,categoriaElegida);
            lista.addJuegos(Juegos);

            escribirDatos.guardarVideojuego(lista);


        } else if (opcion == 2) {
            System.out.println("---Biblioteca actual de juegos--- \n");

            leerDatos.leervideoJuego(lista);

        } else if (opcion == 3) {

            System.out.println("escribe el titulo del juego a buscar o el id :  \n");
            String busqueda = sc.nextLine();

            if (busqueda.matches("[0-9]+")) {
                int id = Integer.parseInt(busqueda);
                leerDatos.buscarVideoJuego(lista, null, id);
            } else {
                leerDatos.buscarVideoJuego(lista, busqueda, -1);
            }


        } else if (opcion == 4) {
            System.out.println("id del juego a modificar");

            int id = Integer.parseInt(sc.nextLine());
            leerDatos.modificarJuego(lista, id);

        } else if (opcion == 5) {
            System.out.println("id del juego a eliminar");
            int id = Integer.parseInt(sc.nextLine());
            leerDatos.eliminarJuego(lista, id);


        } else if (opcion == 6) {

            escribirDatos.exportarJuegos(lista);

        } else  if (opcion == 7) {
            System.out.println(" escribe un id para la categoria ");
            int id = Integer.parseInt(sc.nextLine());
            System.out.println(" escribe el nombre para la categoria ");
            String titulo = sc.nextLine();
            categoria categoria = new categoria(titulo,id);
            listaCategorias.addCategoria(categoria);

            escribirDatos.guardarCategoria(listaCategorias);
        }else  if (opcion == 8) {
            System.out.println("--categorias --");
            leerDatos.leerCategorias(listaCategorias);

        }


        else if (opcion == 0) {

            System.out.println("El programa termina.");

        } else {

            System.out.println("Opción incorrecta.");
        }
    }
}
