package uk.co.certait.cloudera.hive;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveOperations;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import uk.co.certait.cloudera.hive.domain.Customer;

@Repository
public class HiveRepository {

	private static final Logger logger = LoggerFactory.getLogger(HiveRepository.class);

	@Autowired
	private HiveOperations hiveTemplate;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void doStuff() {
		logger.debug("Executing!");

		List<Customer> customers = jdbcTemplate.query(
				"select customer_fname as forename, customer_lname as surname from customers where customer_lname like 'A%' limit 10",
				new BeanPropertyRowMapper<Customer>(Customer.class));

		customers.forEach(customer -> System.out.println(customer.toString()));
	}
}
