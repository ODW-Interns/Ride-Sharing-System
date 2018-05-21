package com.odw.ridesharing;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ EventParserTest.class, CommandControllerTest.class, CarControllerTest.class, UserControllerTest.class,
        CarFactoryTest.class, UserFactoryTest.class })

public class AllTests {
}
