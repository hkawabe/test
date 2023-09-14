package jp.gihyo.wbpress.qiita.repository;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jp.gihyo.wbpress.qiita.domain.QiitaItem;
import jp.gihyo.wbpress.qiita.param.QiitaParam;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component // (d1)
public class RestComponent {

	RestTemplate restTemplate;

	QiitaParam qiitaParam;

	@Autowired
	public RestComponent(RestTemplate restTemplate, QiitaParam qiitaParam) {
		this.restTemplate = restTemplate;
		this.qiitaParam = qiitaParam;
	}

	public List<QiitaItem> getItems() { // (d2)
		URI uri = convertToUri(qiitaParam);
		log.info("url=[{}]", uri.toString()); // (d3)
		RequestEntity<Void> requestEntity = RequestEntity.get(uri).build();
		ResponseEntity<List<QiitaItem>> responseEntity = restTemplate.exchange(requestEntity,
				new ParameterizedTypeReference<List<QiitaItem>>() {
				});
		return responseEntity.getBody();
	}

	private URI convertToUri(QiitaParam qiitaParam) {
		String url = qiitaParam.getUrl();
		Integer limit = qiitaParam.getLimit();
		UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url).queryParam("page", 1)
				.queryParam("per_page", limit);
		return builder.build().toUri();
	}

}
