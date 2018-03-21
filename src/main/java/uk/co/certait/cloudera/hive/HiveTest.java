package uk.co.certait.cloudera.hive;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HiveTest {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		context.registerShutdownHook();

		HiveRepository repository = context.getBean(HiveRepository.class);
		repository.doStuff();

		context.close();
		System.exit(0);
	}
}
