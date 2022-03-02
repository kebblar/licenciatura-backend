package unam.mx.backend.model;

public class Login {
    private String mail;
    private String jwt;

    public Login() {
    }

    public Login(String mail, String jwt) {
        this.mail = mail;
        this.jwt = jwt;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getJwt() {
        return this.jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

}
