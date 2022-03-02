package unam.mx.backend.model;

import java.util.List;

public class Login {
    private String mail;
    private String jwt;
    private List<Rol> roles;

    public Login() {
    }


    public Login(String mail, String jwt, List<Rol> roles) {
        this.mail = mail;
        this.jwt = jwt;
        this.roles = roles;
    }


    public List<Rol> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Rol> roles) {
        this.roles = roles;
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
