# Notes
- Factories should be moved in their own package instead in same package with controllers
- Will input parameters have validation?

## Tests

- Tests should be moved to corresponding packages, e.g. tests for controllers should be in `com.odw.risesharing.tests.controllers`.
- Each test should be atomic. Test should only expect one result. 
	Example:

```java
	public class CarControllerTest {
		
		public void testCreateCarWithSuccess() {
			// TODO expecting successful result 
		}
		
		public void testCreateCarFailsIfYearIsInFuture() {
			ArrayList<String> carInfo = ...
			carInfo.add("3000");
			
			try {
				// try to call controller
				fail("Should fail if year is in future");
			}
			catch(Exception e) {
				// this is happy path, no need to add assert
			}
		}
	}
```
		
