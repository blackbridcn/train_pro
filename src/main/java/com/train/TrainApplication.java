package com.train;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

@Slf4j
@Configuration
@SpringBootApplication
public class TrainApplication implements CommandLineRunner {


    @Autowired
    DataSource dataSource;

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext*.xml");
        SpringApplication.run(TrainApplication.class, args);
    }

   /* @Bean(destroyMethod ="close")
    public DataSource dataSource() {
        Properties properties = new Properties();
        properties.setProperty("driverClassName","org.h2.Driver");
        properties.setProperty("url","jdbc:h2:mem:dcd4a32d-4851-47fa-9599-4303330c66d2");
        properties.setProperty("username","SA");
        return BasicD
    }*/

    @Override
    public void run(String... args) throws Exception {
        showConnection();
    }

    private void showConnection() throws SQLException {
        System.out.println("-----------------------------------------------> \n");
        System.out.println("--> dataSource: \n " + dataSource.toString());
        Connection connection = dataSource.getConnection();
        System.out.println("--> dataSource: \n " + connection.toString());
        connection.close();
        System.out.println("-----------------------------------------------> \n");
    }
}
