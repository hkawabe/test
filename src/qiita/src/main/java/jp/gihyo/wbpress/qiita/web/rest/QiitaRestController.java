package jp.gihyo.wbpress.qiita.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jp.gihyo.wbpress.qiita.domain.QiitaItem;
import jp.gihyo.wbpress.qiita.service.QiitaService;

@RestController // (d1)
@RequestMapping("/rest") // (d2)
public class QiitaRestController {

	@Autowired
	QiitaService qiitaService;

	@GetMapping(value = "/items") // (d3)
	public ResponseEntity<List<QiitaItem>> getAllItems() {
		List<QiitaItem> items = qiitaService.findAll();
		return ResponseEntity.ok().body(items);
	}

}
