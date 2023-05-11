public class Libro {
    private String autor;
    private String titulo;
    private String editorial;
    private double precio;
    private String area;
    private String codigo;

    public Libro(String autor, String titulo, String editorial, double precio, String area, String codigo) {
        this.autor = autor;
        this.titulo = titulo;
        this.editorial = editorial;
        this.precio = precio;
        this.area = area;
        this.codigo = codigo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
}
