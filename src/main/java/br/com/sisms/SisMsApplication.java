package br.com.sisms;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class SisMsApplication {

    private static final String SERVER_PORT = "local.server.port";

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(SisMsApplication.class, args);
        Environment env = ctx.getEnvironment();
        final String port = env.getProperty(SERVER_PORT);
        log.info("\n\n****************************" +
                "\n\nSistema iniciado com sucesso" +
                "\n\nAcesse http://localhost:{}" +
                "\n\n****************************\n", port);
        try {
            Runtime.getRuntime().exec(String.format("c:/program files (x86)/google/chrome/application/chrome.exe --new-window http://localhost:%s", port));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Bean
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        System.out.println("aaa");
        return messageSource;
    }

    @Bean
    public LocalValidatorFactoryBean getValidator() {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource());
        return bean;
    }

}

