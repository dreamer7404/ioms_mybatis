package hae;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = { "hae.basic.board.dao", "hae.basic.biz.dao" } )
public class AbleBaseMybatisApplication {

	private static final Logger logger=LoggerFactory.getLogger(AbleBaseMybatisApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(AbleBaseMybatisApplication.class, args);
		logger.info("Application started");
	}
}
