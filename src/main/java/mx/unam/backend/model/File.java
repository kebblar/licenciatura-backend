package mx.unam.backend.model;

public class File {
    private String nombre;
    private String url;
    private String ruta;

    public String getRuta() {
        return this.ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public File(String nombre, String url, String ruta) {
        this.nombre = nombre;
        this.url = url;
        this.ruta = ruta;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
