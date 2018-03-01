package com.haeralis.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.haeralis.HaeralisCpApiApplicationTests;
import com.haeralis.tecnology.robot.human.cyberpunk.controller.CyberpunkController;
import com.haeralis.tecnology.robot.human.cyberpunk.model.CyberpunkHumanRobot;

/**
 * Test class for CyberpunkController
 * @author Haeralis (GledsonMotta)
 *
 */
//@Transactional
public class CyberpunkControllerTest extends HaeralisCpApiApplicationTests {
	
	@Autowired
	CyberpunkController cyberpunkController;
			
	@Test
    public void testListModels() {

        List<CyberpunkHumanRobot> list = cyberpunkController.listModels();

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertFalse("failure - expected not empty", list.isEmpty());
    }
	 	
	@Test
    public void testClone() throws CloneNotSupportedException {

		CyberpunkHumanRobot cyber = new CyberpunkHumanRobot();		
		cyber.setName("TER0123");
		cyber.setParentId(1L);
		cyber.setAge(12);
		
		cyber = cyberpunkController.clone(cyber);

        Assert.assertNotNull("failure - expected not null", cyber);
        Assert.assertNotNull("failure - Id expected not null", cyber.getId());
    } 	
	
	@Test
    public void testListAll() {

        List<CyberpunkHumanRobot> list = cyberpunkController.listAll();

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertFalse("failure - expected not empty", list.isEmpty());
    }
	
	@Test
    public void testSearch() {

		CyberpunkHumanRobot cyber = new CyberpunkHumanRobot();
		cyber.setId(1L);
		
		cyber = cyberpunkController.search(cyber);
        Assert.assertNotNull("failure - expected not null", cyber);
    } 
		
	@Test
    public void testUpdate() {

		CyberpunkHumanRobot cyber = new CyberpunkHumanRobot();
		cyber.setId(1L);
		cyber.setName("TER1234");
		cyber.setAge(15);
		
		cyberpunkController.update(cyber);       
    } 	
	
	@Test
    public void testDelete() throws Exception {

		CyberpunkHumanRobot cyber = new CyberpunkHumanRobot();
		cyber.setId(2L);
		
		cyberpunkController.delete(cyber);
    } 	
}
