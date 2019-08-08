package com.datahan.server.irian;

import com.datahan.server.irian.domain.Cat;
import com.datahan.server.irian.domain.Student;
import com.datahan.server.irian.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author Jim Han
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.datahan.*")
public class ServerIrianApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerIrianApplication.class, args);
    }

    @Component
    public class Runner implements CommandLineRunner {

        //@Autowired
        @Resource(name = "redisTemplate")
        private RedisTemplate redisTemplate;

        @Autowired
        private StudentRepository studentRepository;

        @Override
        public void run(String... args) throws Exception {
            redisTemplate.opsForValue().set("cat", new Cat("red", 12));
            Cat cat = (Cat) redisTemplate.opsForValue().get("cat");
            System.out.println(cat);

            // repository save
            Student student = new Student("Eng2015001", "John Doe", Student.Gender.MALE, 1);
            studentRepository.save(student);

            // repository find
            Student retrievedStudent = studentRepository.findById("Eng2015001").get();

            // repository update
            retrievedStudent.setName("Richard Watson");
            studentRepository.save(student);

            // repository delete
            studentRepository.deleteById(student.getId());
        }
    }

}
