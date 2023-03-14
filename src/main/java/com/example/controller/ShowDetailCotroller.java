package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.form.AddItemForm;
import com.example.service.ShowDetailService;

/**
 * 詳細画面を表示するコントローラ.
 * 
 * @author watanabe
 *
 */
@Controller
@RequestMapping("")
public class ShowDetailCotroller {
	@Autowired
	private ShowDetailService showDetailService;

	/**
	 * 詳細を表示するコントローラ.
	 * 
	 * @param model モデル
	 * @param id 商品ID
	 * @return idで検索した商品
	 */
	@GetMapping("/showDetail")
	public String showDetail(Model model, Integer id,AddItemForm form) {
		Item item = showDetailService.showDetailItem(id);
		model.addAttribute("item", item);
		return "item_detail";
	}
}
