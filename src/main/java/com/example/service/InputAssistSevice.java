package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;
import com.example.repository.UserRepository;

/**
 * ユーザー情報取得の業務処理を行うサービス.
 * 
 * @author sugaharatakamasa
 *
 */
@Service
@Transactional
public class InputAssistSevice {

	@Autowired
	private UserRepository userRepository;

	/**
	 * 主キーからユーザー情報を取得する.
	 * 
	 * @param userId ユーザーID
	 * @return 検索されたユーザー情報
	 */
	public User load(Integer userId) {

		return userRepository.load(userId);

	}
}
