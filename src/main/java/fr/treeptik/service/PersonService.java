package fr.treeptik.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.treeptik.dao.PersonDAO;
import fr.treeptik.exception.ServiceException;
import fr.treeptik.model.Person;

@Service
public class PersonService
{
	@Inject
	private PersonDAO personDAO;
	
	@Transactional
	public Person save(Person p) throws ServiceException
	{
		try
		{
			return personDAO.save(p);
		}
		
		catch(DataAccessException e)
		{
			throw new ServiceException("Bouh",e);
		}
	}
	
	@Transactional
	public List<Person> findByFirstName(String firstName) throws ServiceException
	{
		try
		{
			return personDAO.findByFirstName(firstName);
		}
		
		catch(DataAccessException e)
		{
			throw new ServiceException("Bouh",e);
		}
	}
	
	@Transactional
	public List<Person> listPersonByIdDesc() throws ServiceException
	{
		try
		{
			return personDAO.listPersonByIdDesc();
		}
		
		catch(DataAccessException e)
		{
			throw new ServiceException("Bouh",e);
		}
	}
}
