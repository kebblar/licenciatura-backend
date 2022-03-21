package mx.unam.backend.utils;

import mx.unam.backend.exceptions.ServiceException;

public interface AuthenticatorService {

    public void authentica(String rolObjetivo, String jwt) throws ServiceException;
}
