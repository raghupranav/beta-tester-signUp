package com.beta.testers.signup.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.beta.testers.signup.constants.Constants;
import com.beta.testers.signup.constants.ControllerPaths;
import com.beta.testers.signup.dto.BaseClass;
import com.beta.testers.signup.dto.BetaTester;
import com.beta.testers.signup.entity.TesterEntity;
import com.beta.testers.signup.exception.ServiceException;
import com.beta.testers.signup.service.BetaTestersService;

@RestController
public class BetaTestersController {

	private static final Logger logger = LoggerFactory.getLogger(BetaTestersController.class);

	@Autowired
	private BetaTestersService service;

	@PostMapping(path = ControllerPaths.USER_SIGN_UP, produces = "application/json")
	public ResponseEntity<TesterEntity> userSignUp(@RequestBody BetaTester betaTestUser,
			@RequestHeader HttpHeaders headers) throws ServiceException {
		addHeaders(headers, betaTestUser);
		logger.info("Request for betaUserSignUp with betaTesterId = " + betaTestUser.getBetaTesterId());
		return ResponseEntity.ok().body(service.userSignUp(betaTestUser));
	}

	@GetMapping(path = ControllerPaths.GET_BETA_TESTER_BY_ID, produces = "application/json")
	public ResponseEntity<TesterEntity> getBetaTesterById(@PathVariable String betaTesterId,
			@RequestHeader HttpHeaders headers, @RequestBody BetaTester betaTestUser) throws ServiceException {
		logger.info("Requesting info for betaTesterId = " + betaTesterId);
		addHeaders(headers, betaTestUser);
		return ResponseEntity.ok().body(service.getBetaTesterById(betaTesterId));

	}
	
	@GetMapping(path = ControllerPaths.GET_BETA_TESTER_BY_LOCATION, produces = "application/json")
	public ResponseEntity<List<TesterEntity>> getBetaTesterByLocation(@PathVariable String location,
			@RequestHeader HttpHeaders headers, @RequestBody BetaTester betaTestUser) throws ServiceException {
		logger.info("Requesting beta testers info from " + location);
		addHeaders(headers, betaTestUser);
		return ResponseEntity.ok().body(service.getBetaTesterByLocation(location));

	}

	private void addHeaders(HttpHeaders headers, BaseClass request) {
		request.setRequestId(headers.getFirst(Constants.requestId));
	}
}
