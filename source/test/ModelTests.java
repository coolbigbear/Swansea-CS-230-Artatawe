package test;

import model.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;


/**
 * This Test class will test the base code also called the Model
 * this means no UI related things will be tested
 * Uses JUnit5
 *
 * @author Bassam Helal
 */
@DisplayName("Model")
class ModelTests {
	
	//region Artworks Tests
	
	
	//endregion
	
	@Disabled
	@DisplayName("Painting Type")
	@Test
	void testPaintingGetType() {
		Artwork localPainting = new Painting("", new StringBuilder(""), LocalDate.now(), "", "path", 5, 5);
		assertEquals(ArtworkType.PAINTING, localPainting.getType());
	}
	
	@DisplayName("Sculpture Type")
	@Test
	void testSculptureGetType() {
		Artwork localSculpture = new Sculpture("", new StringBuilder(""), LocalDate.now(), "",
				null, 5, 5, 5, "");
		assertEquals(ArtworkType.SCULPTURE, localSculpture.getType());
	}

	@DisplayName("Bid Getters")
	@Test
	void testAllBidGetters() {
	
	}

	@DisplayName("Bid Equals false")
	@Test
	void testBidEqualsFalseMethod() {
	
	}
	
	@DisplayName("Bid Equals true")
	@Test
	void testBidEqualsTrueMethod() {
	
	}
	
	@DisplayName("Bid toString")
	@Test
	void testBidToString() {
	
	}
	
	@DisplayName("BHFeedString isEmpty")
	@Test
	void testBHFeedStringIsEmpty() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		assertTrue(stringFeed.isEmpty());
	}
	
	@DisplayName("BHFeedString size empty")
	@Test
	void testBHFeedStringSizeEmpty() {
		BHFeedString stringFeed = BHFeedString.getNewInstanceWithCapacity(5);
		
		assertTrue(stringFeed.isEmpty());
		assertEquals(0, stringFeed.size());
	}
	
	@DisplayName("BHFeedString size nonempty")
	@Test
	void testBHFeedStringSizeNonEmpty() {
		BHFeedString stringFeed = BHFeedString.getNewInstanceWithCapacity(5);
		stringFeed.add("Hello");
		assertFalse(stringFeed.isEmpty());
		assertEquals(1, stringFeed.size());
	}
	
	@DisplayName("BHFeedString check instances equal")
	@Test
	void testBHFeedStringInstancesEqual() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		BHFeedString stringFeed2 = BHFeedString.getInstance();
		assertEquals(stringFeed, stringFeed2);
		assertEquals(BHFeedString.getInstance(), BHFeedString.getInstance());
	}
	
	@DisplayName("BHFeedString check instances not equal")
	@Test
	void testBHFeedStringInstancesNotEqual() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		BHFeedString stringFeed2 = BHFeedString.getNewInstance();
		assertNotEquals(stringFeed, stringFeed2);
	}
	
	@DisplayName("BHFeedString check instances not equal with new capacity")
	@Test
	void testBHFeedStringInstancesNotEqualNewCapacity() {
		BHFeedString stringFeed = BHFeedString.getNewInstanceWithCapacity(5);
		BHFeedString stringFeed2 = BHFeedString.getNewInstanceWithCapacity(50);
		assertNotEquals(stringFeed, stringFeed2);
		assertEquals(stringFeed.size(), stringFeed2.size());
	}
	
	@DisplayName("BHFeedString check instances not equal with new capacity smaller")
	@Test
	void testBHFeedStringInstancesNotEqualNewCapacitySmaller() {
		BHFeedString stringFeed = BHFeedString.getNewInstanceWithCapacity(50);
		BHFeedString stringFeed2 = BHFeedString.getNewInstanceWithCapacity(5);
		assertNotEquals(stringFeed, stringFeed2);
		assertEquals(stringFeed.size(), stringFeed2.size());
	}
	
	@DisplayName("BHFeedString add one by one")
	@Test
	void testBHFeedStringAddOne() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.add("Hello");
		stringFeed.add("Hi");
		stringFeed.add("Welcome");
		stringFeed.add("Greetings");
		assertEquals(4, stringFeed.size());
	}
	
	@DisplayName("BHFeedString addAll varargs")
	@Test
	void testBHFeedStringAddAllVarargs() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Welcome", "Greetings");
		assertEquals(4, stringFeed.size());
	}
	
	@DisplayName("BHFeedString addAll collection")
	@Test
	void testBHFeedStringAddAllCollection() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Batman");
		arrayList.add("Superman");
		arrayList.add("Wonder woman");
		arrayList.add("Cyborg");
		
		stringFeed.addAll(arrayList);
		assertEquals(4, stringFeed.size());
	}
	
	@DisplayName("BHFeedString Check current instance")
	@Test
	void testBHFeedStringCheckInstances() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		stringFeed = BHFeedString.getInstance();
		
		assertEquals(4, stringFeed.size());
	}
	
	@DisplayName("BHFeedString Check current instance 2")
	@Test
	void testBHFeedStringCheckInstances2() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		stringFeed = BHFeedString.getInstance();
		BHFeedString anotherStringFeed = BHFeedString.getInstance();
		
		assertEquals(4, anotherStringFeed.size());
		assertEquals(stringFeed, anotherStringFeed);
		assertEquals(BHFeedString.getInstance(), BHFeedString.getInstance());
		
	}
	
	@DisplayName("BHFeedString clear current instance")
	@Test
	void testBHFeedStringClearCurrentInstance() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Batman");
		arrayList.add("Superman");
		arrayList.add("Wonder woman");
		arrayList.add("Cyborg");
		
		stringFeed.addAll(arrayList);
		stringFeed.clear();
		
		assertEquals(0, stringFeed.size());
		assertTrue(stringFeed.isEmpty());
	}
	
	@DisplayName("BHFeedString Get all as ArrayList")
	@Test
	void testBHFeedStringGetAllAsArrayList() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		ArrayList<String> arrayList = stringFeed.getAllAsArrayList();
		
		assertEquals("Welcome", arrayList.get(3));
	}
	
	@DisplayName("BHFeedString Get all as ArrayList Empty")
	@Test
	void testBHFeedStringGetAllAsArrayListEmpty() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		ArrayList<String> arrayList = stringFeed.getAllAsArrayList();
		
		assertNotNull(arrayList);
	}
	
	@DisplayName("BHFeedString Get all as Array")
	@Test
	void testBHFeedStringGetAllAsArray() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		String[] array = stringFeed.getAllAsArray();
		
		assertEquals("Welcome", array[3]);
	}
	
	@DisplayName("BHFeedString copy to new instance")
	@Test
	void testBHFeedStringCopyToNewInstance() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		ArrayList<String> stringFeedArrayList = stringFeed.getAllAsArrayList();
		
		BHFeedString newStringFeed = stringFeed.copyToNewInstance();
		ArrayList<String> newStringFeedArrayList = newStringFeed.getAllAsArrayList();
		
		assertEquals(stringFeedArrayList, newStringFeedArrayList);
	}
	
	@DisplayName("BHFeedString copy to new instance with capacity")
	@Test
	void testBHFeedStringCopyToNewInstanceWithCapacity() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		ArrayList<String> stringFeedArrayList = stringFeed.getAllAsArrayList();
		
		//it doesn't matter because it will grow anyway
		BHFeedString newStringFeed = stringFeed.copyToNewInstanceWithCapacity(2);
		ArrayList<String> newStringFeedArrayList = newStringFeed.getAllAsArrayList();
		
		assertEquals(stringFeedArrayList, newStringFeedArrayList);
	}
	
	@DisplayName("BHFeedString update with collection")
	@Test
	void testBHFeedStringUpdateWithCollection() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Batman");
		arrayList.add("Superman");
		arrayList.add("Wonder woman");
		arrayList.add("Cyborg");
		
		stringFeed = stringFeed.updateWith(arrayList);
		
		assertEquals(arrayList, stringFeed.getAllAsArrayList());
	}
	
	@DisplayName("BHFeedString update with array")
	@Test
	void testBHFeedStringUpdateWithArray() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		String[] array = {"Batman", "Superman", "Wonder Woman", "Cyborg"};
		
		stringFeed = stringFeed.updateWith(array);
		
		assertEquals(array[0], stringFeed.getAllAsArray()[0]);
		assertEquals(array[1], stringFeed.getAllAsArray()[1]);
		assertEquals(array[2], stringFeed.getAllAsArray()[2]);
		assertEquals(array[3], stringFeed.getAllAsArray()[3]);
	}
	
	@DisplayName("BHFeedString update with capacity collection")
	@Test
	void testBHFeedStringUpdateWithCapacityCollection() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("Batman");
		arrayList.add("Superman");
		arrayList.add("Wonder woman");
		arrayList.add("Cyborg");
		
		stringFeed = stringFeed.updateWithCapacity(10, arrayList);
		
		assertEquals("Cyborg", stringFeed.getAllAsArrayList().get(3));
	}
	
	@DisplayName("BHFeedString update with capacity array")
	@Test
	void testBHFeedStringUpdateWithCapacityArray() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		String[] array = {"Batman", "Superman", "Wonder woman", "Cyborg"};
		
		stringFeed = stringFeed.updateWithCapacity(10, array);
		
		assertEquals("Cyborg", stringFeed.getAllAsArray()[3]);
	}
	
	@DisplayName("BHFeedString iterator with for each")
	@Test
	void testBHFeedStringIteratorForEach() {
		BHFeedString stringFeed = BHFeedString.getNewInstanceWithCapacity(10);
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		ArrayList<String> arrayList = new ArrayList<>();
		
		for (String string : stringFeed) {
			arrayList.add(string);
		}
		
		
		assertEquals("Greetings", arrayList.get(2));
	}
	
	@DisplayName("BHFeedString for each")
	@Test
	void testBHFeedStringForEach() {
		BHFeedString stringFeed = BHFeedString.getNewInstanceWithCapacity(10);
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		ArrayList<String> arrayList = new ArrayList<>();
		
		stringFeed.forEach((Consumer<String>) s -> arrayList.add(s));
		
		
		assertEquals("Greetings", arrayList.get(2));
	}
	
	@DisplayName("BHFeedString non equal")
	@Test
	void testBHFeedStringNonEqual() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		BHFeedString anotherStringFeed = BHFeedString.getNewInstance();
		anotherStringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
	    assertNotEquals(stringFeed, anotherStringFeed);
	}
	
	@DisplayName("BHFeedString equal")
	@Test
	void testBHFeedStringEqual() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		BHFeedString anotherStringFeed = BHFeedString.getNewInstance();
		anotherStringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		
		assertEquals(stringFeed.getAllAsArrayList(), anotherStringFeed.getAllAsArrayList());
	}
	
	@DisplayName("BHFeedString Destroy Instance Not Null")
	@Test
	void testBHFeedStringDestroyInstanceNotNull() {
		BHFeedString stringFeed = BHFeedString.getNewInstance();
		stringFeed.addAll("Hello", "Hi", "Greetings", "Welcome");
		stringFeed.destroyInstance();
		
	    assertNotNull(BHFeedString.getInstance());
	}
	
	@DisplayName("LocalDateTime now +1 millisecond hashcode")
	@Test
	void testLocalDateTimeNowHashCode() throws InterruptedException {
		LocalDateTime now = LocalDateTime.now();
		int nowHashCode = now.hashCode();
		Thread.sleep(1);
		now = LocalDateTime.now();
		int laterHashcode = now.hashCode();
		assertTrue(nowHashCode != laterHashcode);
	}
	
	@DisplayName("LocalDate equal and hashcode")
	@Test
	void testLocalDatesEqual() {
		LocalDate july271950 = LocalDate.of(1950, Month.JULY, 27);
		LocalDate j7271950 = LocalDate.of(1950, 7, 27);
		assertEquals(july271950, j7271950);
		assertTrue(july271950.hashCode() == j7271950.hashCode());
	}
	
	
}
