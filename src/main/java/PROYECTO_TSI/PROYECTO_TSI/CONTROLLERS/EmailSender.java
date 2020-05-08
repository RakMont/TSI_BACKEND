package PROYECTO_TSI.PROYECTO_TSI.CONTROLLERS;

import PROYECTO_TSI.PROYECTO_TSI.MODELS.Details;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("/showContactanos")
@Controller
public class EmailSender {
    @Autowired
    SpringTemplateEngine templateEngine;

    @Autowired
    private JavaMailSender sender;

    @RequestMapping("/getdetails")
    public @ResponseBody Details sendMail(@RequestBody Details details) throws Exception {
        System.out.println("llega aqui y pasa "+details.getEmail()+"name : "+details.getName()+"message"+details.getMessage());

        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Map<String, Object> model = new HashMap<String, Object>();
        model.put("name",details.getName());
        model.put("email",details.getEmail());
        model.put("message",details.getMessage());

        Context context = new Context();
        context.setVariables(model);
        System.out.println("llega aqui y pasa ");
        String html = templateEngine.process("email-template", context);
        System.out.println("llega aqui y pasa 2");

        try {
            helper.setTo(details.getEmail());
            helper.setText(html,true);
            helper.setSubject("Test Mail");
        } catch (javax.mail.MessagingException e) {
            e.printStackTrace();
        }
        sender.send(message);

        return details;

    }

}