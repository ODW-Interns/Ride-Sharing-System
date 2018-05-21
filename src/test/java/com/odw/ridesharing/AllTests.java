package com.odw.ridesharing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EventParserTest.class, CommandControllerTest.class, CarControllerTest.class, CarFactoryTest.class })

public class AllTests {
}
