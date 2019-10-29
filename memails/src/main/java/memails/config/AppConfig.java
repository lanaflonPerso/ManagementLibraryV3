package memails.config;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@Configuration
public class AppConfig {

    @Autowired
    private MailConfig mailConfig;

    @Autowired
    private SmtpConfig smtpConfig;

    @Autowired
    private StartTlsConfig startTlsConfig;

    @Autowired
    private TransportConfig transportConfig;

    /**
     * Permet l'utilisation du DTO
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public JavaMailSender getJavaMailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost( mailConfig.getHost() );
        mailSender.setPort( mailConfig.getPort() );

        mailSender.setUsername( mailConfig.getUsername() );
        mailSender.setPassword( mailConfig.getPassword() );

        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", transportConfig.getProtocol() );
        props.put("mail.smtp.auth", smtpConfig.isAuth() );
        props.put("mail.smtp.starttls.enable", startTlsConfig.isEnable() );
        props.put("mail.debug", mailConfig.isDebug() );

        return mailSender;
    }

    @Bean
    public SimpleMailMessage templateSimpleMessage() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setText(
                "This is the test email template for your email:\n%s\n");
        return message;
    }
}
