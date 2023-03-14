package com.example.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.User;
import com.example.service.InputAssistSevice;

/**
 * ログイン状態にあるユーザー情報を取得する機能を制御するコントローラ.
 * 
 * @author sugaharatakamasa
 *
 */
@RestController
@RequestMapping("input-assist")
public class InputAssistController {

	@Autowired
	private InputAssistSevice service;

	/**
	 * ユーザー情報を取得する.
	 * 
	 * @param userId ユーザーID
	 * @param key キー
	 * @return 取得したユーザー情報
	 */
	@GetMapping("")
	public Map<String, User> check(Integer userId, Integer key) {
		System.out.println(userId);
		Map<String, User> map = new HashMap<>();
		User user = service.load(userId);
		if (key.equals(user.getEmail().hashCode())) {

			map.put("user", user);
		}
		return map;

	}

}
