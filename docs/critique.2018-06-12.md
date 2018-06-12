# Notes
## Exceptiosn should never be empty. 
Explain what the problem is so you can diagnose it quickly.

```java
 	} catch (NullPointerException e_) {
                throw new InvalidCarArgumentsException();
```
should be:

```java
 	} catch (NullPointerException e_) {
                throw new InvalidCarArgumentsException(e_.toString());
```
## "C" like approch: 
The buildCar factory has a very "C" like approcat - an array of values, where you implicitly know what the values are. Instead use more descriptive methods:

```java
	public AbstractCar buildCar(ArrayList<String> typeValues_) throws InvalidCarArgumentsException
```

should be

```java
	public AbstractCar buildCar(int runtimeConstat_, String make_, String model_, String color_) throws InvalidCarArgumentsException
```

## Constants
Runtime constants are good.
However, here, why are you not using an enum?

```java
public enum CarType {
    COUPE,
    SENDAN,
    SUV
}
```

then, the above method signature becomes:

```java
	public AbstractCar buildCar(CarType runtimeConstat_, String make_, String model_, String color_) throws InvalidCarArgumentsException
```

and you code becomes


```java
    public AbstractCar buildCar(CarType carType_, String make_, String model_, String color_, int year_) throws InvalidCarArgumentsException {
        switch (carType_) {
            case COUPE:
                return new Coupe(nextCarID++, make_, model_, color_, year_);
            case SEDAN:
                return new Sedan(nextCarID++, make_, model_, color_, year_);
            case SUV:
                return new Suv(nextCarID++, make_, model_, color_, year_);
            default:
                throw new InvalidCarArgumentsException("invalid arguments, unable to determine car type. Value passed: " + carType_.toString());
        }
    }
```


plus I added some more testing in the code - please have a look