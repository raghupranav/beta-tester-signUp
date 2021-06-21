package com.beta.testers.signup.entity;

import java.util.Date;
import java.util.Map;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table("beta_tester_info_v1")
public class TesterEntity {
	// ========================================
	// Instance Variables
	// ========================================
	@PrimaryKey
	@Column
	private String beta_tester_id;
	@Column
	private String first_name;
	@Column
	private String last_name;
	@Column
	private String product;
	@Column
	private Date registered_at;
	@Column
	private String email_id;
	@Column
	private Map<String, String> social_media_handles;
	@Column
	private Map<String, String> development_tools;
	@Column
	private String location;

}
