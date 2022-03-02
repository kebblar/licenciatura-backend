package unam.mx.backend.exceptions;
import unam.mx.backend.utils.HttpStatus;


public class ControllerException extends Exception{
    private final Throwable rootException;
    private final String shortMessage;
    private final String detailedMessage;
    private final int localExceptionNumber;
    private final String localExceptionKey;
    private final HttpStatus httpEstado;

    public ControllerException(
            Throwable rootException,
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpEstado) {
        this.rootException = rootException;
        this.localExceptionNumber = localExceptionNumber;
        this.localExceptionKey = localExceptionKey;
        this.httpEstado = httpEstado;
        this.shortMessage = shortMessage;
        this.detailedMessage = detailedMessage;
    }

    public ControllerException(
            String shortMessage,
            String detailedMessage,
            int localExceptionNumber,
            String localExceptionKey,
            HttpStatus httpStatus) {
        this(new Exception(""), shortMessage, detailedMessage, localExceptionNumber, localExceptionKey, httpStatus);
    }

    public ControllerException(Exception rootException,HttpStatus httpStatus ) {
        this(rootException, rootException.getMessage(), rootException.getMessage(), 1000, "cve_1000", httpStatus);
    }

    public Throwable getRootException() {
        return this.rootException;
    }

    public String getShortMessage() {
        return this.shortMessage;
    }


    public String getDetailedMessage() {
        return this.detailedMessage;
    }


    public int getLocalExceptionNumber() {
        return this.localExceptionNumber;
    }


    public String getLocalExceptionKey() {
        return this.localExceptionKey;
    }


    public HttpStatus getHttpEstado() {
        return this.httpEstado;
    }

    /** {@inheritDoc} */
    @Override
    public String toString() {
        return "ControllerException [rootException=" + rootException + ", shortMessage=" + shortMessage
                + ", detailedMessage=" + detailedMessage + ", localExceptionNumber=" + localExceptionNumber
                + ", localExceptionKey=" + localExceptionKey + ", httpStatus=" + httpEstado + "]";
    }


}
