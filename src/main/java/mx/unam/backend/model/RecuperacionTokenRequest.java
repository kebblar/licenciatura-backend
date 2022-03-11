package mx.unam.backend.model;

public class RecuperacionTokenRequest {
    private String token;
    private String claveNueva;


    public RecuperacionTokenRequest(String token, String claveNueva) {
        this.token = token;
        this.claveNueva = claveNueva;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getClaveNueva() {
        return this.claveNueva;
    }

    public void setClaveNueva(String claveNueva) {
        this.claveNueva = claveNueva;
    }

}
