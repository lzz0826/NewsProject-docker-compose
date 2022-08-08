package tw.tony.com;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("tw.tony.com.mapper")
public class NewsProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(NewsProjectApplication.class, args);
	}

}
