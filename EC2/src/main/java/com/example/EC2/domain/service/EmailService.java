package com.cloudmaestro.domain.Service;

import com.cloudmaestro.global.util.RedisUtil;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;
    private final RedisUtil redisUtil;
    private String authNum; //랜덤 인증 코드

    @Value("${spring.mail.username}")
    private String configEmail;

    //랜덤 인증 코드 생성
    public void createCode() {
        Random random = new Random();
        StringBuffer key = new StringBuffer();

        for(int i=0;i<8;i++) {
            int index = random.nextInt(3);

            switch (index) {
                case 0 :
                    key.append((char) ((int)random.nextInt(26) + 97));
                    break;
                case 1:
                    key.append((char) ((int)random.nextInt(26) + 65));
                    break;
                case 2:
                    key.append(random.nextInt(9));
                    break;
            }
        }
        this.authNum = key.toString();
    }

    public String sendAuthMail(String mail)  throws MessagingException{
        createCode();
        String authKey = this.authNum;
        MimeMessage mailMessage = mailSender.createMimeMessage();
        String mailContent = "인증번호:"+authKey ;     //보낼 메시지
        mailMessage.setSubject("Cloud Maestro Sign up Request: 인증코드", "utf-8");
        mailMessage.setText(mailContent, "utf-8", "html");
        mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(mail));
        mailMessage.setFrom(new InternetAddress(configEmail));
        mailSender.send(mailMessage);

        redisUtil.setDataExpire(mail, authKey, 60L * 3L); //3분

        return authKey;
    }
    public Boolean verifyEmailCode(String email, String code) {
        String codeFoundByEmail = redisUtil.getData(email);
        if (codeFoundByEmail == null) {
            return false;
        }
        return codeFoundByEmail.equals(code);
    }

}
