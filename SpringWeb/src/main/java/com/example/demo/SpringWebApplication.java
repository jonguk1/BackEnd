package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"common.controller","com.example.demo"})
@MapperScan(basePackages = {"common.mapper"})
public class SpringWebApplication {
//@ComponentScan에 스캔 대상이 될 패키지를 등록해야 한다 ==> 스프링 컨테이너는 해당 패키지를 스캔해서
//@Controller,@Service,@Repository 등등의 어노테이션이 붙은 객체들을 메모리에 올려준다
	public static void main(String[] args) {
		SpringApplication.run(SpringWebApplication.class, args);
	}

}
