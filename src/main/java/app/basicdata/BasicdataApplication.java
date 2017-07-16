package app.basicdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
public class BasicdataApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(BasicdataApplication.class);
 

    public static void main(String[] args) {
        SpringApplication.run(BasicdataApplication.class, args);
    }
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... strings) throws Exception {
        logger.info("spring boot run, and create table.");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS persons("
                + "cardid VARCHAR(30) NOT NULL, "
                + "pname VARCHAR(255) NOT NULL,"
                + "pid VARCHAR(10) NOT NULL,"
                + "dob VARCHAR(10) NOT NULL,"
                + "sex VARCHAR (2) NOT NULL,"
                + "issue VARCHAR(10) NOT NULL,"
                + "enable BOOLEAN DEFAULT FALSE,"
                + "PRIMARY KEY(pid)"
                + ")");
        jdbcTemplate.execute("CREATE TABLE IF NOT EXISTS personsInfo("
                + "pid VARCHAR(10) NOT NULL,"
                + "schoolid VARCHAR(6) NOT NULL,"
                + "title VARCHAR(20) NOT NULL"
                + ")");
    }
}
