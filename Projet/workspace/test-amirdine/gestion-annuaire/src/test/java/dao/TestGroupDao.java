package dao;

import static org.junit.Assert.assertEquals;

import java.util.Collection;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Group;
import model.Person;

public class TestGroupDao {

	static GroupDao groupDao = new GroupDao();

	@Before
	public void setUp() {
		groupDao.init();
	}

	@After
	public void tearDown() {
		// pour plus tard
	}

	//@Test 
	public void testAddGroup(){
		
		Group group = new Group();
		group.setName("Groupe E");
		
		groupDao.addGroup(group);
	}
	
	@Test
	public void testGetAllGroups() {

		Collection<Group> groups = groupDao.getAllGroups();
		
		for (Group group : groups) {
			System.out.println(group);
		}
	}

	@Test
	public void testGetGroup() throws InterruptedException{
		Group group = groupDao.getGroup(51);
		System.out.println(group);
	}
	
	@Test
	public void testGroupContent() {
		
		Collection<Person> persons = groupDao.getContentGroup(51);
		
		System.out.println("Groupe content");
		for (Person person : persons) {
			System.out.println(person);
		}
	}
	
	@Test 
	public void testGroupIDExits(){
		
		boolean result = groupDao.groupIdExists(51);
		assertEquals(true,result);
	}
	
	@Test 
	public void testGroupIdNotExits(){
		
		boolean result = groupDao.groupIdExists(555454577);
		assertEquals(false,result);
	}
	
}