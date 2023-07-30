package com.abc.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abc.portal.feign.AuthFeignClient;
import com.abc.portal.model.UserLoginCredential;
import com.abc.portal.model.UserToken;

import lombok.extern.slf4j.Slf4j;

/**
 * This class provides service to communicate with authorization service via
 * {@link AuthFeignClient}.
 * 
 * @version 1.8
 * @author Pod3
 * 
 * @see AuthFeignClient
 * @see UserLoginCredential
 */
@Slf4j
@Service
public class AuthFeignService {

	/**
	 * private field of type {@link AuthFeignClient}
	 * 
	 * @see AuthFeignClient
	 */
	@Autowired
	private AuthFeignClient authclient;

	/**
	 * Based on the given {@link UserLoginCredential} object we will call
	 * {@link AuthFeignClient} method login which will return {@link UserToken}
	 * object in return.
	 * 
	 * @param usercredentials
	 * @return {@link UserToken} object
	 */
	public ResponseEntity<?> getToken(UserLoginCredential usercredentials) {
		log.debug("userCredentials{}:", usercredentials);
		return authclient.login(usercredentials);
	}

}