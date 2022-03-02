package unam.mx.backend.service;

import unam.mx.backend.exceptions.ControllerException;
import unam.mx.backend.model.CredencialesRequest;
import unam.mx.backend.model.Login;

public interface LoginService {
    public Login login(CredencialesRequest usuario) throws ControllerException;
}