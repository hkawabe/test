package jp.gihyo.wbpress.qiita;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication // (d1)
@EnableScheduling // (d2)
public class QiitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(QiitaApplication.class, args);
	}
}
