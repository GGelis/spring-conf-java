package fr.treeptik.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fr.treeptik.model.Person;

public interface PersonDAO extends JpaRepository<Person, Integer>
{
	List<Person> findByFirstName(@Param("firstName") String firstName) throws DataAccessException;
	
	@Query("select p from Person p order by p.id desc")
	List<Person> listPersonByIdDesc() throws DataAccessException;
}
