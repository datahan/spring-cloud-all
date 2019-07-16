package com.datahan.server.irian;

import com.datahan.server.irian.domain.Cat;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Jim
 */
@SpringBootApplication
@ComponentScan("com.datahan.*")
public class ServerIrianApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerIrianApplication.class, args);
    }

    @Component
    public class Runner implements CommandLineRunner {

        @Resource(name = "redisTemplate")
        private RedisTemplate template;

        @Override
        public void run(String... args) throws Exception {
            template.opsForValue().set("cat", new Cat("red", 12));
            Cat cat = (Cat) template.opsForValue().get("cat");
            System.out.println(cat);
        }
    }

}
