### Hexlet tests and linter status:
[![Actions Status](https://github.com/NickKisel/java-project-lvl3/workflows/hexlet-check/badge.svg)](https://github.com/NickKisel/java-project-lvl3/actions)
[![Java CI](https://github.com/NickKisel/java-project-lvl3/actions/workflows/Java-CI.yml/badge.svg)](https://github.com/NickKisel/java-project-lvl3/actions/workflows/Java-CI.yml)
[![Maintainability](https://api.codeclimate.com/v1/badges/0dc2b7f7f917c1de9fd6/maintainability)](https://codeclimate.com/github/NickKisel/java-project-lvl3/maintainability)
[![Test Coverage](https://api.codeclimate.com/v1/badges/0dc2b7f7f917c1de9fd6/test_coverage)](https://codeclimate.com/github/NickKisel/java-project-lvl3/test_coverage)

# java-project-lvl3
java-project-lvl3 is schema builder for validation. Now available schemas for String, Number and Map.

## Getting Started
For beginnig you need create new Validator:
```
Validator v = new Validator();
```
After that create new schema: [StringSchema](#stringschema), [NumberSchema](#numberschema), [MapSchema](#mapschema).
For start Validation you need to call method `isValid(Object object)` on your schema. Validation is made for the specified object according to the specified rules.
## StringSchema
To create validation for String you need use:
```ts
StringSchema stringSchema = v.string();
// return new StringSchema
```
### `required()` - validate if object is not empty String.
Example of using:
```ts
stringSchema.isValid(null); // true
stringSchema.required();
stringSchema.isValid(null); // false
stringSchema.isValid("Hello") // true
```
### `contains(String string)` - validate if object contains the specified string.
Example of using:
```ts
stringSchema.isValid(null); // true
stringSchema.contains("Hello");
stringSchema.isValid("Hexlet"); // false
stringSchema.isValid("Hello, world!") // true
```
### `minLength(int minLength)` - validate if object have more or equal specified length.
Example of using:
```ts
stringSchema.isValid(null); // true
stringSchema.minLength(3);
stringSchema.isValid("Hi"); // false
stringSchema.isValid("Hello") // true
```
## NumberSchema
To create validation for Number you need use:
```ts
NumberSchema numberSchema = v.number();
// return new NumberSchema
```
### `required()` - validate if object is a number.
Example of using:
```ts
numberSchema.isValid(null); // true
numberSchema.required();
numberSchema.isValid(null); // false
numberSchema.isValid(1) // true
```
### `positive()` - validate if object is a positive number.
Example of using:
```ts
numberSchema.isValid(null); // true
numberSchema.positive();
numberSchema.isValid(-100); // false
numberSchema.isValid(10) // true
```
### `range(int min, int max)` - validate if object is between min and max (including min and max values).
Example of using:
```ts
numberSchema.isValid(null); // true
numberSchema.range(3, 10);
numberSchema.isValid(2); // false
numberSchema.isValid(4) // true
```
## MapSchema
To create validation for Map you need use:
```ts
MapSchema mapSchema = v.map();
// return new MapSchema
```
### `required()` - validate if object is a Map.
Example of using:
```ts
mapSchema.isValid(null); // true
mapSchema.required();
mapSchema.isValid(null); // false
mapSchema.isValid(new HashMap<>()) // true
```
### `sizeof(int countKeysPairs)` - validate if object is Map and have specified size.
Example of using:
```ts
mapSchema.isValid(null); // true
mapSchema.sizeof(2);
mapSchema.isValid(Map.of("key1", "value1"); // false
mapSchema.isValid(Map.of("key1", "value1", "key2", "value2") // true
```
### `shape(Map<String, BaseSchema> map)` - allows you to describe validation for Map object values by keys.
Example of using:
```ts
Map<String, BaseSchema> schemas = new HashMap<>();
schemas.put("name", v.string().required());
schemas.put("age", v.number().positive());
schema.shape(schemas);

Map<String, Object> human1 = new HashMap<>();
human1.put("name", "Kolya");
human1.put("age", 100);
schema.isValid(human1); // true

Map<String, Object> human2 = new HashMap<>();
human2.put("name", "Maya");
human2.put("age", null); 
schema.isValid(human2); // true

Map<String, Object> human3 = new HashMap<>();
human3.put("name", "");
human3.put("age", null);
schema.isValid(human3); // false
```
