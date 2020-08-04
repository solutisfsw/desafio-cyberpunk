package com.haeralis.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.haeralis.HaeralisCpApiApplicationTests;
import com.haeralis.attribute.controller.AttributeController;
import com.haeralis.attribute.model.Attribute;
import com.haeralis.attribute.model.AttributeType;

/**
 * Test class for AttributeController
 * @author Haeralis (GledsonMotta)
 *
 */
@Transactional
public class AttributeControllerTest extends HaeralisCpApiApplicationTests {
	
	@Autowired
	AttributeController attributeController;
		
	@Test
    public void testListAll() {

        List<Attribute> list = attributeController.listAll();

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertFalse("failure - expected not empty", list.isEmpty());
    }
	
	@Test
    public void testListAllType() {

        List<AttributeType> list = attributeController.listAllType();

        Assert.assertNotNull("failure - expected not null", list);
        Assert.assertFalse("failure - expected not empty", list.isEmpty());
    }
	 	
	@Test
    public void testSearch() {

		Attribute attr = new Attribute();
		attr.setCode(1L);
		
		attr = attributeController.search(attr);

        Assert.assertNotNull("failure - expected not null", attr);
    } 	
	
	@Test
    public void testAdd() {

		Attribute attr = new Attribute();
		attr.setCode(100L);
		attr.setName("TESTING");
		attr.setAttributeType(new AttributeType());
		attr.getAttributeType().setCode(1);
		
		attributeController.add(attr);
    } 	
	
	@Test
    public void testUpdate() {

		Attribute attr = new Attribute();
		attr.setCode(1L);
		attr.setName("TESTING UPDATE");
		attr.setAttributeType(new AttributeType());
		attr.getAttributeType().setCode(1);
		
		attributeController.update(attr);
    } 	
	
	@Test
    public void testDelete() throws Exception {

		Attribute attr = new Attribute();
		attr.setCode(1L);
		
		attributeController.delete(attr);
    } 	
}
