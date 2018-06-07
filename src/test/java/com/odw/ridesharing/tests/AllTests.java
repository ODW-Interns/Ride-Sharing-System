package com.odw.ridesharing.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.odw.ridesharing.tests.controllers.CarControllerTest;
import com.odw.ridesharing.tests.controllers.CommandControllerTest;
import com.odw.ridesharing.tests.controllers.PickupControllerTest;
import com.odw.ridesharing.tests.controllers.UserControllerTest;
import com.odw.ridesharing.tests.factories.CarFactoryTest;
import com.odw.ridesharing.tests.factories.PickupFactoryTest;
import com.odw.ridesharing.tests.factories.UserFactoryTest;

@RunWith(Suite.class)

/* @formatter:off */
@SuiteClasses({ CarControllerTest.class,
                CarFactoryTest.class,
                CommandControllerTest.class,
                EventParserTest.class,
                PickupControllerTest.class, 
                PickupFactoryTest.class,
                PickupSchedulerTest.class,
                UserControllerTest.class,
                UserFactoryTest.class })
/* @formatter:on */

/**
 * Note: Run this as a JUnit test to run all the tests specified
 * under @SuiteClasses.
 */
public class AllTests {
}
