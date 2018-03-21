package uk.co.certait.cloudera.hive;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.hadoop.hive.HiveOperations;
import org.springframework.stereotype.Repository;

@Repository
public class HiveRepository {

	private static final Logger logger = LoggerFactory.getLogger(HiveRepository.class);

	@Autowired
	private HiveOperations hiveOperations;

	public void doStuff() {
		logger.debug("Executing!");

		List<String> tables = hiveOperations.query("show tables");

		for (String table : tables) {
			System.out.println(table);
		}
	}
}
