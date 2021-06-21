package com.beta.testers.signup.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import com.beta.testers.signup.entity.TesterEntity;

@Repository
public interface TesterRepository extends CassandraRepository<TesterEntity, String> {

	@Query(value = "SELECT * FROM beta_tester_info_v1 WHERE location=?0")
	public Optional<List<TesterEntity>> findByLocation(String location);

}
