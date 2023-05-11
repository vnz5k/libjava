import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class InventarioLibrosGUI {
    private JFrame frame;
    private GestionLibros gestionLibros;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                InventarioLibrosGUI window = new InventarioLibrosGUI();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public InventarioLibrosGUI() {
        gestionLibros = new GestionLibros();
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 450, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        JPanel panelMenu = new JPanel();
        frame.getContentPane().add(panelMenu, BorderLayout.NORTH);

        JButton btnAlta = new JButton("Dar de alta un libro");
        btnAlta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String autor = JOptionPane.showInputDialog("Ingrese el autor del libro:");
                String titulo = JOptionPane.showInputDialog("Ingrese el titulo del libro:");
                String editorial = JOptionPane.showInputDialog("Ingrese la editorial del libro:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el precio del libro:");
                double precio = Double.parseDouble(precioStr);
                String area = JOptionPane.showInputDialog("Ingrese el area del libro:");
                String codigo = JOptionPane.showInputDialog("Ingrese el codigo del libro:");

                Libro libro = new Libro(autor, titulo, editorial, precio, area, codigo);
                gestionLibros.agregarLibro(libro);
            }
        });
        panelMenu.add(btnAlta);

        JButton btnBaja = new JButton("Dar de baja un libro");
        btnBaja.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Ingrese el codigo del libro que quiere dar de baja:");
                gestionLibros.eliminarLibro(codigo);
            }
        });
        panelMenu.add(btnBaja);

        JButton btnActualizar = new JButton("Actualizar datos de un libro");
        btnActualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String codigo = JOptionPane.showInputDialog("Ingrese el codigo del libro que quiere actualizar:");

                String autor = JOptionPane.showInputDialog("Ingrese el nuevo autor del libro:");
                String titulo = JOptionPane.showInputDialog("Ingrese el nuevo titulo del libro:");
                String editorial = JOptionPane.showInputDialog("Ingrese la nueva editorial del libro:");
                String precioStr = JOptionPane.showInputDialog("Ingrese el nuevo precio del libro:");
                double precio = Double.parseDouble(precioStr);
                String area = JOptionPane.showInputDialog("Ingrese la nueva area del libro:");

                Libro libro = new Libro(autor, titulo, editorial, precio, area, codigo);
                gestionLibros.actualizarLibro(libro);
            }
        });
        panelMenu.add(btnActualizar);

        JButton btnConsultar = new JButton("Consultar un libro(s)");
        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String parametro = JOptionPane.showInputDialog("Buscar libro por: (autor, titulo, editorial, area, codigo)");
                String valor = JOptionPane.showInputDialog("Ingrese el valor de busqueda:");
                List<Libro> librosEncontrados = gestionLibros.buscarLibros(parametro, valor);

                if (librosEncontrados.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "No se encontraron libros");
                } else {
                    for (Libro libro : librosEncontrados) {
                        JOptionPane.showMessageDialog(frame, 
                            "Autor: " + libro.getAutor() +
                            "\nTítulo: " + libro.getTitulo() +
                            "\nEditorial: " + libro.getEditorial() +
                            "\nPrecio: " + libro.getPrecio() +
                            "\nÁrea: " + libro.getArea() +
                            "\nCódigo: " + libro.getCodigo()
                        );
                    }
                }
            }
        });
        panelMenu.add(btnConsultar);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        panelMenu.add(btnSalir);
    }
}
