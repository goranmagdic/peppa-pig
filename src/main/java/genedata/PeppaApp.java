package genedata;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PeppaApp {

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(PeppaApp.class)
                .run(args);
    }
}
