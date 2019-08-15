package com.ming.common;

import com.ming.bean.Employee;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

public class EmailRunnable implements Runnable{
    private Employee employee;
    private JavaMailSender javaMailSender;
    private TemplateEngine templateEngine;

    public EmailRunnable(Employee employee,
                         JavaMailSender javaMailSender,
                         TemplateEngine templateEngine) {
        this.employee = employee;
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
    }
    @Override
    public void run() {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(employee.getEmail());
            helper.setFrom("vhr@mingming.email");
            helper.setSubject("XXX集团：通知");
            Context ctx = new Context();
            ctx.setVariable("name", employee.getName());
            ctx.setVariable("workID", employee.getWorkID());
            ctx.setVariable("contractTerm", employee.getContractTerm());
            ctx.setVariable("beginContract", employee.getBeginContract());
            ctx.setVariable("endContract", employee.getEndContract());
            ctx.setVariable("departmentName", employee.getDepartmentName());
            ctx.setVariable("posName", employee.getPosName());
            String mail = templateEngine.process("email.html", ctx);
            helper.setText(mail, true);
            javaMailSender.send(message);
        } catch (MessagingException e) {
            System.out.println("发送失败");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
