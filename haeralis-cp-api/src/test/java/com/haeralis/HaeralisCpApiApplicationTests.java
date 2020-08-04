package com.haeralis;

import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Abstract class for all Test Classes
 * @author Haeralis (GledsonMotta)
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class HaeralisCpApiApplicationTests {

	/**
     * The Logger instance for all classes in the unit test framework.
     */
    protected Logger logger = LoggerFactory.getLogger(this.getClass());

}
