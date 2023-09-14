package jp.gihyo.wbpress.qiita.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import jp.gihyo.wbpress.qiita.service.QiitaService;

@Controller // (d1)
public class QiitaScheduleController {

	private static final long INTERVAL = 900_000;

	@Autowired // (d2)
	QiitaService qiitaService;

	@Scheduled(fixedRate = INTERVAL) // (d3)
	public void crawlQiitaItems() {
		qiitaService.crawlItems();
	}
}
