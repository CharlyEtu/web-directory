package service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGroupService{


    IGroupService groupService = new GroupService();
	
	@Test
	public void testGetAllGroup() {
		groupService.getAllGroups();
	}
	
	@Test
	public void testGetGroup(){
		groupService.getGroup(51);
	}
	
	@Test
	public void testGroupIDExists(){
		
		boolean result = groupService.groupIDExists(51);
		assertEquals(true,result);
	}

	@Test
	public void testGroupIDNotExists(){
		
		boolean result = groupService.groupIDExists(54771);
		assertEquals(false,result);
	}
	
}