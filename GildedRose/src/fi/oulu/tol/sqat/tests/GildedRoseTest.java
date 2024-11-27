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
	public void testDexterity() {
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
	public void testDexterityDateOver() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", -1, 20));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality has decreased by one
		assertEquals("Failed quality for Dexterity Vest", 18, quality);
	}
	
	@Test
	public void testItemQualityNegative() {
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", -1, 0));
		inn.oneDay();
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		//assert quality can't be negative
		assertEquals("Failed quality for Dexterity Vest", 0, quality);
	}
	
	
	@Test
	public void testAgeBrie() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 1, 2));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by one
		assertEquals("Failed quality for Aged Brie", quality + 1 ,newQuality);
	}
	
	@Test
	public void testAgeBrieQualityOver50() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 0, 50));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality can't be over 50
		assertEquals("Failed quality for Aged Brie", 50 ,newQuality);
	}
	
	@Test
	public void testAgeBrieSellDateOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -1, 40));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality can't be over 50
		assertEquals("Failed quality for Aged Brie", 42 ,newQuality);
	}
	
	@Test
	public void testAgeBrieQualityOver50SellDateOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", -1, 49));
		
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
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		//assert quality has stayed the same
		assertEquals("Failed quality for Sulfura", 80 ,quality);
	}
	
	@Test
	public void testSulfuraSellDateOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", -2, 80));
		
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
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 2
		assertEquals("Failed quality for Backstage passes",quality + 1, newQuality);
	}

	
	@Test
	public void testBackStageSellInbelow11() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 10, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has increased by 2
		assertEquals("Failed quality for Backstage passes",quality + 2, newQuality);
	}
	
	@Test
	public void testBackStageSellInbelow5() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
												
		//assert quality has increased by 3
		assertEquals("Failed quality for Backstage passes",quality + 3, newQuality);
	}
	
	@Test
	public void testBackStageAfterConcert() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 0, 20));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has dropped to 0
		assertEquals("Failed quality for Backstage passes", 0 , newQuality);															
	}
	
	@Test
	public void testBackStageQualityOver50() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality can't be over 50
		assertEquals("Failed quality for Backstage passes", 50 , newQuality);															
	}
	
	@Test
	public void testBackStageQualityOver50SellDateOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", -3, 49));
		
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality can't be over 50
		assertEquals("Failed quality for Backstage passes", 0 , newQuality);															
	}
	
	
	@Test
	public void testManaCakeSellDateOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", -1, 6));
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has decreased by 2
		assertEquals("Failed quality for Aged Brie", quality - 2 ,newQuality);
	}
	
	@Test
	public void testManaCake() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 1, 6));
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has decreased by 1
		assertEquals("Failed quality for Aged Brie", quality - 1 ,newQuality);
	}
	
	@Test
	public void testElixir() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", 5, 7));
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has decreased by 1
		assertEquals("Failed quality for Elixir of the Mongoose", quality - 1 ,newQuality);
	}
	
	@Test
	public void testElixirSellDateOver() {
		
		//create an inn, add an item, and simulate one day
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Elixir of the Mongoose", -1, 7));
		//access a list of items, get the quality of the one set
		List<Item> items = inn.getItems();
		
		int quality = items.get(0).getQuality();
		
		inn.oneDay();
		
		int newQuality = items.get(0).getQuality();
		
		//assert quality has decreased by 2
		assertEquals("Failed quality for Elixir of the Mongoose", quality - 2 ,newQuality);
	}
}
