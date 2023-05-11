import java.util.*;
import java.io.*;

public class GestionLibros {
    private List<Libro> libros;
    private static final String FILE_NAME = "libros.txt";

    public GestionLibros() {
        this.libros = new ArrayList<>();
        cargarLibros();
    }

    private void cargarLibros() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] partes = line.split(";");
                String autor = partes[0];
                String titulo = partes[1];
                String editorial = partes[2];
                double precio = Double.parseDouble(partes[3]);
                String area = partes[4];
                String codigo = partes[5];
                libros.add(new Libro(autor, titulo, editorial, precio, area, codigo));
            }
        } catch (IOException e) {
            System.err.println("Error al cargar los libros: " + e.getMessage());
        }
    }

    private void guardarLibros() {
        try (PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Libro libro : libros) {
                pw.println(libro.getAutor() + ";" + libro.getTitulo() + ";" + libro.getEditorial() + ";" + 
                           libro.getPrecio() + ";" + libro.getArea() + ";" + libro.getCodigo());
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los libros: " + e.getMessage());
        }
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        guardarLibros();
    }

    public void eliminarLibro(String codigo) {
        libros.removeIf(libro -> libro.getCodigo().equals(codigo));
        guardarLibros();
    }

    public void actualizarLibro(Libro libroActualizado) {
        for (Libro libro : libros) {
            if (libro.getCodigo().equals(libroActualizado.getCodigo())) {
                libro.setTitulo(libroActualizado.getTitulo());
                libro.setAutor(libroActualizado.getAutor());
                libro.setEditorial(libroActualizado.getEditorial());
                libro.setPrecio(libroActualizado.getPrecio());
                libro.setArea(libroActualizado.getArea());
                break;
            }
        }
        guardarLibros();
    }

    public List<Libro> buscarLibros(String parametro, String valor) {
        List<Libro> resultados = new ArrayList<>();
        for (Libro libro : libros) {
            switch (parametro.toLowerCase()) {
                case "autor":
                    if (libro.getAutor().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                    break;
                case "titulo":
                    if (libro.getTitulo().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                    break;
                case "editorial":
                    if (libro.getEditorial().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                    break;
                case "area":
                    if (libro.getArea().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                    break;
                case "codigo":
                    if (libro.getCodigo().equalsIgnoreCase(valor)) {
                        resultados.add(libro);
                    }
                    break;
                default:
                    break;
            }
        }
        return resultados;
    }
}
