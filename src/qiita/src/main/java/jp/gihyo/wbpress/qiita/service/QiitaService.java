package jp.gihyo.wbpress.qiita.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jp.gihyo.wbpress.qiita.domain.QiitaItem;
import jp.gihyo.wbpress.qiita.repository.QiitaRepository;
import jp.gihyo.wbpress.qiita.repository.RestComponent;

@Service
public class QiitaService {

	RestComponent restComponent; // (d1)

	QiitaRepository qiitaRepository; // (d2)

	@Autowired // (d3)
	public QiitaService(RestComponent restComponent, QiitaRepository qiitaRepository) {
		this.restComponent = restComponent;
		this.qiitaRepository = qiitaRepository;
	}

	@Transactional(readOnly = false)
	public void crawlItems() { // (d4)
		List<QiitaItem> items = restComponent.getItems();
		qiitaRepository.saveAll(items);
	}

	@Transactional(readOnly = true)
	public List<QiitaItem> findAll() { // (d5)
		return qiitaRepository.findAll();
	}

}
