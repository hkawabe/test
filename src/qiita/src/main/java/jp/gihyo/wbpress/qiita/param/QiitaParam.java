package jp.gihyo.wbpress.qiita.param;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties( // (d1)
		prefix = "qiita.param")
public class QiitaParam {

	private String url;

	private Integer limit;

}
