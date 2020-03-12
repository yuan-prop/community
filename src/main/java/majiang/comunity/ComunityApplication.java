package majiang.comunity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("majiang.comunity.mapper")//mybatis的逆向工程映射路径
public class ComunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComunityApplication.class, args);
	}

}
