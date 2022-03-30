/*
 * Licencia:    Este  código y cualquier  derivado  de  el, es  propiedad de la
 *              empresa Metasoft SA de CV y no debe, bajo ninguna circunstancia
 *              ser copiado, donado,  cedido, modificado, prestado, rentado y/o
 *              mostrado  a ninguna persona o institución sin el permiso expli-
 *              cito  y  por  escrito de  la empresa Metasoft SA de CV, que es,
 *              bajo cualquier criterio, el único dueño de la totalidad de este
 *              código y cualquier derivado de el.
 *              ---------------------------------------------------------------
 * Paquete:     io.kebblar.petstore.api.support
 * Proyecto:    petstore-back
 * Tipo:        Interface
 * Nombre:      MailSenderService
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:30:40
 */
package mx.unam.backend.service;

/**
 * <p>
 * Descripción:
 * </p>
 * Interface asociado al servicio de envio de mail.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
public interface MailSenderService {

    /**
     * Envio del chatbot por medio de JavaMailSender.
     *
     * @param to      Cadena con los correos electronicos a quienes se desea enviar
     *                el correo generado
     * @param subject Cadena con el titulo del correo electronico
     * @param body    Cadena con el cuerpodo del mensaje de correo
     * @return a {@link java.lang.String} object.
     */
    String sendHtmlMail(String to, String subject, String body);
}
