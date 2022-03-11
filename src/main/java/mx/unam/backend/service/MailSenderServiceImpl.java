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
 * Tipo:        Clase
 * Nombre:      MailSenderServiceImpl
 * Autor:       Gustavo Adolfo Arellano (GAA)
 * Correo:      gustavo.arellano@metasoft.com.mx
 * Versión:     0.0.1-SNAPSHOT
 *
 * Historia:
 *              Creación: 5 Sep 2021 @ 08:30:56
 */
package mx.unam.backend.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Descripción:
 * </p>
 * Implementacion del servicio de envio de mail.
 *
 * @author Gustavo A. Arellano (GAA)
 * @version 1.0-SNAPSHOT
 */
@Service
public class MailSenderServiceImpl implements MailSenderService {
    @Value("${spring.mail.from}")
    private String from;

    private static final String ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD = "error in mail service sendHtmlMail method {}";

    /** logger. */
    private final Logger logger = LoggerFactory.getLogger(MailSenderServiceImpl.class);

    /** java mail sender. */
    private final JavaMailSender javaMailSender;

    /** Constante NUM_QUICK_SERVICE_THREADS. */
    public static final int NUM_QUICK_SERVICE_THREADS = 20;

    /**
     * CBDI Constructor.
     *
     * @param javaMailSender (avoiding Autowire)
     */
    public MailSenderServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }


    /** {@inheritDoc} */
    @Override
    @Async
    public String sendHtmlMail(String to, String subject, String body) {
        try {
            MimeMessage mail = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(body, true);
            helper.setFrom(from);
            javaMailSender.send(mail);
            return "succeed";
        } catch (MessagingException me) {
            logger.error(ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD, me.getMessage());
            return ERROR_IN_MAIL_SERVICE_SEND_HTML_MAIL_METHOD;
        }
    }

}