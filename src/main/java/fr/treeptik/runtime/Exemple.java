package fr.treeptik.runtime;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.treeptik.utils.DatasourceConfiguration;

public class Exemple
{
	private static Logger logger = Logger.getLogger(Exemple.class);
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatasourceConfiguration.class);
		
		logger.info("alo");
		
		context.close();
	}

}
