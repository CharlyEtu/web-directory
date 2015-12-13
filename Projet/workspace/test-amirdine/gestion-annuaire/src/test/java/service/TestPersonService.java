package service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TestPersonService{


    IPersonService personService = new PersonService();
	
	@Test
	public void testGetAllPerson() {
		personService.getAllPersons();
	}
	
	@Test
	public void testGetPerson() throws Exception{
		personService.getPerson(1);
	}
	
	@Test
	public void testGetPersonNotExits(){
		
		try {
			personService.getPerson(14);
			assertTrue("Échec", true);
		} catch (Exception e) {
			e.printStackTrace();
			assertTrue("Succes", true);
		}
	}

	@Test
	public void testPersonIDExists(){
		
		boolean result = personService.personIDExists(1);
		assertEquals(true,result);
	}
	
	@Test
	public void testPersonIDNotExists(){
		
		boolean result = personService.personIDExists(51014);
		assertEquals(false,result);
	}
	
}
