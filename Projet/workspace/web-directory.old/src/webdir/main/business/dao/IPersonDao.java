package webdir.main.business.dao;

import java.util.List;

import webdir.main.model.Person;

public interface IPersonDao {

	public void addPerson(Person person);
	public Person getPerson(long id) throws Exception;
	public List<Person> getAllPersons();
}
