package dao;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import model.Group;
import model.Person;

public class TestPersonDao {

	static PersonDao personDao;
	static Group group;

	@BeforeClass
	public static void beforeAll() {

		group = new Group();
		group.setName("GROUPE B");

		personDao = new PersonDao();
		personDao.init();
	}

	@Before
	public void setUp() {
		// pour plus tard
	}

	@After
	public void tearDown() {
		// pour plus tard
	}

	//@Test
	public void testAddPersn() throws ParseException {

		Person person = new Person();

		person.setFirstname("Saïkou");
		person.setLastname("Bah");

		String date_s = " 1992-07-14";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		Date birthDay = dt.parse(date_s);
		person.setBirthdate(birthDay);
		person.setPassword("aaaa");
		person.setEmail("saïkou.bah@hotmail.fr");
		person.setWebsite("saikou.bah.perso.fr");
		person.setGroup(group);

		personDao.addPerson(person);
	}

	@Test
	public void testFindAll() {

		Collection<Person> persons = personDao.getAllPersons();

		System.out.println("Requête like - taille de la liste: " + persons.size());

		for (Person person : persons) {
			System.out.println(person);
		}
	}

	@Test
	public void testGetPerson() throws Exception{
		Person person = personDao.getPerson(1601);
		System.out.println(person);
	}
	
	@Test 
	public void testPersonIdExits(){
		
		boolean result = personDao.personIDExists(1);
		assertEquals(true,result);
	}
	
	@Test 
	public void testPersonIdNotExits(){
		
		boolean result = personDao.personIDExists(457448741);
		assertEquals(false,result);
	}
	
	//@Test
	public void testUpdatePerson() throws ParseException{
		
		Person person = new Person();
		
		person.setId(1);
		person.setFirstname("Amirdine");
		person.setLastname("toto");
		person.setWebsite("amirdine.perso.fr");
		String date_s = " 1994-07-14";
		SimpleDateFormat dt = new SimpleDateFormat("yyyy-mm-dd");
		Date birthdate = dt.parse(date_s);
		person.setBirthdate(birthdate);
		
		personDao.updatePerson(person);
	}
}