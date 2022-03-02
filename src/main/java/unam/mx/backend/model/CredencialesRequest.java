package unam.mx.backend.model;

public class CredencialesRequest {
    private String mail;
    private String password;

    public CredencialesRequest(String mail, String password) {
        this.mail = mail;
        this.password = password;
    }

    public CredencialesRequest() {
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getClave() {
        return this.password;
    }

    public void setClave(String password) {
        this.password = password;
    }

}
