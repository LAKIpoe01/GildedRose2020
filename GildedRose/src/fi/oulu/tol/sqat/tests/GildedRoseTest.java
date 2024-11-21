package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import fi.oulu.tol.sqat.GildedRose;
import fi.oulu.tol.sqat.Item;

public class GildedRoseTest {

	@Test
	public void testTheTruth() {
		assertTrue(true);
	}
	@Test
	public void exampleTest() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 19, quality);
	}
	
	@Test
	public void testAgeBrie() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Aged Brie", quality + 1 ,newQuality);
	}
	
	@Test
	public void testSulfura() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		//assert quality has stayed the same
		assertEquals("Failed quality for Sulfura", 80 ,quality);
	}
	
	@Test
	public void testBackStage() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int sellIn = items.get(0).getSellIn();
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 1
		assertEquals("Failed quality for Backstage passes", quality + 1 ,newQuality);
		
		if (sellIn <= 10 ) {
			//assert quality has increased by 2
			assertEquals("Failed quality for Backstage passes", quality + 2 ,newQuality);
		} if (sellIn <= 5) {
			//assert quality has increased by 3
			assertEquals("Failed quality for Backstage passes", quality + 3 ,newQuality);
		} if ()
	}
}
