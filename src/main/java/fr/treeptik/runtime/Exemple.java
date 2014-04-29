package fr.treeptik.runtime;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Person;
import fr.treeptik.service.PersonService;
import fr.treeptik.utils.DatasourceConfiguration;

public class Exemple
{
	private static Logger logger = Logger.getLogger(Exemple.class);
	
	public static void main(String[] args)
	{
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatasourceConfiguration.class);
		
		logger.error("alo");
		
		Person p = new Person();
		p.setFirstName("troll");
		
		PersonService personService = context.getBean(PersonService.class);
		
		List<Person> result = null;
		
		try
		{
			p = personService.save(p);
			result = personService.findByFirstName("troll");
			System.out.println(result);
			result = personService.listPersonByIdDesc();
			System.out.println(result);
		}
		
		catch (ServiceException e)
		{
			logger.error(e.getMessage());
		}
		
		context.close();
	}

}
