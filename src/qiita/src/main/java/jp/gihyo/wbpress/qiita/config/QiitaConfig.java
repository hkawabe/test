package jp.gihyo.wbpress.qiita.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import jp.gihyo.wbpress.qiita.param.QiitaParam;

@Configuration
public class QiitaConfig {

	@Bean
	public QiitaParam qiitaParam() {
		return new QiitaParam();
	}

}
