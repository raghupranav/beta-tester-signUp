package com.beta.testers.signup.config;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

import com.beta.testers.signup.dto.BetaTester;
import com.beta.testers.signup.entity.TesterEntity;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.converter.builtin.DateToStringConverter;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Configuration
public class BeanMapper implements InitializingBean {

	private static MapperFactory mapperFactory;

	private static final String DATE_CONVERTER_ID = "dateToISOStringConverter";
	private static String ISO_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

	static {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFactory.getConverterFactory().registerConverter(DATE_CONVERTER_ID,
				new DateToStringConverter(ISO_DATE_FORMAT));

	}
	private static MapperFacade mapperFacade = mapperFactory.getMapperFacade();

	public BeanMapper() throws Exception {
		super();
		afterPropertiesSet();
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		mapperFactory.classMap(BetaTester.class, TesterEntity.class).fieldMap("betaTesterId", "beta_tester_id").add()
				.fieldMap("firstName", "first_name").add().fieldMap("lastName", "last_name").add()
				.fieldMap("registeredTimestamp", "registered_at").converter(DATE_CONVERTER_ID).add()
				.fieldMap("emailId", "email_id").add().fieldMap("socialMediaHandles", "social_media_handles").add()
				.fieldMap("developmentTools", "development_tools").add().mapNulls(false).byDefault().register();

	}

	/**
	 * Returns a new object of the given type with values mapped from source object.
	 *
	 * @param <S>               the generic type
	 * @param <D>               the generic type
	 * @param iSourceObject     the source object
	 * @param iDestinationClass the destination class
	 * @return the d
	 */
	public <S, D> D map(S iSourceObject, Class<D> iDestinationClass) {
		Assert.notNull(iSourceObject, "Object can't be  null");
		return mapperFacade.map(iSourceObject, iDestinationClass);
	}

}
