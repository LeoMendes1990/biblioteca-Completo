package br.com.biblioteca.springboot.biblioteca.profiles;

import br.com.biblioteca.springboot.biblioteca.services.DbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestProfile {
    @Autowired
    DbService dbService;
    @Value("${spring.jpa.hibernate.ddl-auto}")
    private String ddl;

    @Bean
    public boolean intanciaDB() {
        if (ddl.equals("update")) {
            this.dbService.intanciaDB();
        }
        return false;
    }
}
