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

	public void qualityNeverNegative() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();
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
	public void testAgeBrieSellInOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -1, 0));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 2
		assertEquals("Failed quality for Aged Brie", quality + 2, newQuality);
	}
	
	@Test
	public void testAgeBrieSellInOverQualityOver50() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -1, 49));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 2
		assertEquals("Failed quality for Aged Brie", 50, newQuality);
	}
	
	@Test
	public void testItemNegative() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 0));
				
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
				
		inn.oneDay();
	
		int newQuality = items.get(0).getQuality();
				
		//assert quality can't be negative
		assertEquals("Failed quality for +5 Dexterity Vest", quality ,newQuality);
	}
	
	
	@Test
	public void testItemSellDateOver() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", -1, 7));
				
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
				
		inn.oneDay();
	
		int newQuality = items.get(0).getQuality();
				
		//assert quality has decreased by 2
		assertEquals("Failed quality for Elixir of the Mongoose", quality - 2,newQuality);
	}
	
	@Test
	public void testItemSellDateOverQualityNegative() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", -1, 1));
				
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
				
		inn.oneDay();
	
		int newQuality = items.get(0).getQuality();
				
		//assert quality has decreased by 1
		assertEquals("Failed quality for Elixir of the Mongoose", 0,newQuality);
	}
	
	@Test
	public void testItemQualityOver50() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 50));
				
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
				
		inn.oneDay();
	
		int newQuality = items.get(0).getQuality();
				
		//assert quality can't be over 50
		assertEquals("Failed quality for Aged Brie", 50 ,newQuality);
	}
	@Test
	public void testSulfura() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -1, 80));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		inn.oneDay();
		
		int quality = items.get(0).getQuality();
		
		//assert quality has stayed the same
		assertEquals("Failed quality for Sulfura", 80 ,quality);
	}
	
	@Test
	public void testBackStage() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 20, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
	
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 1
		assertEquals("Failed quality for Backstage passes", quality + 1 ,newQuality);	
	}
	
	@Test
	public void testBackStageSellInBelow10() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 2
		assertEquals("Failed quality for Backstage passes", quality + 2 ,newQuality);	
	}
	
	@Test
	public void testBackStageSellInBelow5() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 3
		assertEquals("Failed quality for Backstage passes", quality + 3 ,newQuality);	
	}
	
	@Test
	public void testBackStageConcert() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has dropped to 0
		assertEquals("Failed quality for Backstage passes", 0 ,newQuality);	
	}
	
	@Test
	public void testBackStageValueOver50Day10() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality can't be over 50
		assertEquals("Failed quality for Backstage passes", 50, newQuality);	
	}
	
	@Test
	public void testBackStageValueOver50Day5() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality can't be over 50
		assertEquals("Failed quality for Backstage passes", 50, newQuality);	
	}
	
	@Test
	public void testManaCake() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has decreased by 1 
		assertEquals("Failed quality for Aged Brie", quality - 1 ,newQuality);
	}
	
}
