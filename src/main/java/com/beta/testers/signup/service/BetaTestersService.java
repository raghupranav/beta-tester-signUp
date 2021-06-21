package com.beta.testers.signup.service;

import java.util.List;

import com.beta.testers.signup.dto.BetaTester;
import com.beta.testers.signup.entity.TesterEntity;
import com.beta.testers.signup.exception.ServiceException;

public interface BetaTestersService {
	
	public TesterEntity userSignUp(BetaTester betaTestUser) throws ServiceException;
	
	public TesterEntity getBetaTesterById (String betaTesterId) throws ServiceException;
	
	public List<TesterEntity> getBetaTesterByLocation (String location) throws ServiceException;

}
