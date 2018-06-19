package com.ferhat.springmongodemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringmongodemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringmongodemoApplication.class, args);
    }

    /*
    --- Sunucudaki Mongo Db bilgileri ---
	spring.data.mongodb.host=dev.tmod.com.tr
    spring.data.mongodb.port=27020
    spring.data.mongodb.database=fbedirdb
    spring.data.mongodb.username=fbedir
    spring.data.mongodb.password=123Fb321

    --- Kendi Pc'mdeki Mongo Db Bilgileri ---
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=example
     */
}
