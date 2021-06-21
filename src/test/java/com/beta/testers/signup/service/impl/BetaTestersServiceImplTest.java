package com.beta.testers.signup.service.impl;

import java.util.HashMap;
import java.util.UUID;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.util.Assert;

import com.beta.testers.signup.config.BeanMapper;
import com.beta.testers.signup.dto.BetaTester;
import com.beta.testers.signup.entity.TesterEntity;
import com.beta.testers.signup.exception.ServiceException;
import com.beta.testers.signup.repository.TesterRepository;

public class BetaTestersServiceImplTest {

	private BetaTestersServiceImpl serviceImpl;

	@Mock
	private BeanMapper mapper;

	@Mock
	private TesterRepository repository;

	@Before
	public void initMocks() {
		MockitoAnnotations.initMocks(this);
		serviceImpl = new BetaTestersServiceImpl(repository, mapper);
	}

	@Test
	public void testUserSignUp() throws ServiceException {
		BetaTester betaTester = getUserData();
		TesterEntity testerEntity = new TesterEntity();
		Mockito.when(repository.save(Mockito.any())).thenReturn(testerEntity);
		Mockito.when(mapper.map(betaTester, TesterEntity.class)).thenReturn(testerEntity);
		TesterEntity response = serviceImpl.userSignUp(betaTester);
		Assert.notNull(response);
	}

	private BetaTester getUserData() {
		BetaTester betaTester = new BetaTester();
		betaTester.setBetaTesterId(UUID.randomUUID().toString());
		betaTester.setDevelopmentTools(new HashMap<>());
		betaTester.setEmailId("email@email.com");
		betaTester.setFirstName("firstName");
		betaTester.setLastName("lastName");
		betaTester.setLocation("location");
		betaTester.setRegisteredTimestamp("2016-07-10T11:00:01.056Z");
		betaTester.setSocialMediaHandles(new HashMap<>());
		return betaTester;
	}
}
