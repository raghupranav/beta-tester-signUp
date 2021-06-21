package com.beta.testers.signup.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.beta.testers.signup.config.BeanMapper;
import com.beta.testers.signup.dto.BetaTester;
import com.beta.testers.signup.entity.TesterEntity;
import com.beta.testers.signup.exception.ServiceException;
import com.beta.testers.signup.repository.TesterRepository;
import com.beta.testers.signup.service.BetaTestersService;
import com.datastax.oss.driver.internal.core.util.CollectionsUtils;

@Service
public class BetaTestersServiceImpl implements BetaTestersService {

	private static final Logger logger = LoggerFactory.getLogger(BetaTestersServiceImpl.class);

	private TesterRepository repository;

	private BeanMapper mapper;

	public BetaTestersServiceImpl(TesterRepository repository, BeanMapper mapper) {
		super();
		this.repository = repository;
		this.mapper = mapper;
	}

	@Override
	public TesterEntity userSignUp(BetaTester betaTestUser) throws ServiceException {
		if (StringUtils.isBlank(betaTestUser.getEmailId()) || StringUtils.isBlank(betaTestUser.getBetaTesterId()))
			throw new ServiceException("Email and/or Beta testerId can't be empty or null!", HttpStatus.BAD_REQUEST);
		logger.info("Registering new user with betaTesterId = {}", betaTestUser.getBetaTesterId());
		TesterEntity user = mapper.map(betaTestUser, TesterEntity.class);
		repository.save(user);
		logger.info("Succesfully registered new user with betaTesterId = {}", betaTestUser.getBetaTesterId());
		return user;
	}

	@Override
	public TesterEntity getBetaTesterById(String userId) throws ServiceException {
		TesterEntity user = repository.findById(userId).orElse(null);
		if (Objects.isNull(user))
			throw new ServiceException("User not found with beatTeserId!", HttpStatus.BAD_REQUEST);
		return user;
	}

	@Override
	public List<TesterEntity> getBetaTesterByLocation(String location) throws ServiceException {
		List<TesterEntity> usersByLocation = repository.findByLocation(location).orElse(null);
		if (Objects.isNull(usersByLocation) || CollectionUtils.isEmpty(usersByLocation) )
			throw new ServiceException("No beta testers in " + location + " yet!", HttpStatus.BAD_REQUEST);
		return usersByLocation;
	}

}
