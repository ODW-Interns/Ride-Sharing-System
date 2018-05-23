package com.odw.ridesharing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)

/* @formatter:off */
@SuiteClasses({ EventParserTest.class,
                CommandControllerTest.class,
                CarControllerTest.class,
                CarFactoryTest.class,
                UserControllerTest.class,
                UserFactoryTest.class,
                PickupControllerTest.class, 
                PickupFactoryTest.class })
/* @formatter:on */

/**
 * Note: Run this as a JUnit test to run all the tests specified
 * under @SuiteClasses.
 */
public class AllTests {
}
