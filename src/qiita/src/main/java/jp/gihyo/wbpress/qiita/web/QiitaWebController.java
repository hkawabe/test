package jp.gihyo.wbpress.qiita.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import jp.gihyo.wbpress.qiita.domain.QiitaItem;
import jp.gihyo.wbpress.qiita.service.QiitaService;

@Controller // (d1)
public class QiitaWebController {

	@Autowired // (d2)
	QiitaService qiitaService;

	@GetMapping(value = "/items") // (d3)
	public ModelAndView showAllItemsPage() {
		ModelAndView modelAndView = new ModelAndView("items");
		List<QiitaItem> items = qiitaService.findAll();
		modelAndView.addObject("items", items);
		return modelAndView;
	}

}
