package com.odw.ridesharing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EventParserTest.class,
                CommandControllerTest.class,
                CarControllerTest.class,
                UserControllerTest.class,
                CarFactoryTest.class,
                UserFactoryTest.class })

/**
 * Note: Run this as a JUnit test to run all the tests specified under @SuiteClasses.
 */
public class AllTests { }
