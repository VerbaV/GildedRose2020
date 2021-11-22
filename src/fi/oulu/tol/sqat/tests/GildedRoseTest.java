package fi.oulu.tol.sqat.tests;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
		assertEquals(19, quality, "Failed quality for Dexterity Vest");
	}
	
	
	@Test
	public void testGildedRose_SellInValueDecrease() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("+5 Dexterity Vest", 10, 20));
		inn.oneDay();

		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		assertEquals(9, sellIn, "Failed sellIn value for Dexterity Vest");
	}
	
	
	@Test
	public void testGildedRose_updateQualityOfAgedBrie() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(1, quality, "Failed quality for Aged Brie");
	}
	

	@Test
	public void testGildedRose_sulfurasQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(80, quality, "Failed quality for Sulfuras, Hand of Ragnaros");
	}
	
	
	@Test
	public void testGildedRose_sulfurasSellInValue() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int sellIn = items.get(0).getSellIn();
		
		assertEquals(0, sellIn, "Failed sellIn value for Sulfuras, Hand of Ragnaros");
	}

	
	@Test
	public void testGildedRose_QualityAfterSellInValueGoesUnderZero() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(1, quality, "Failed quality for Conjured Mana Cake");
	}
	
	
	@Test
	public void testGildedRose_QualityUnderZero() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(0, quality, "Failed quality for Conjured Mana Cake");
	}


	@Test
	public void testGildedRose_QualityOfBacstagePassesForSellInValue5() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(33, quality, "Failed quality for Backstage passes to a TAFKAL80ETC concert");
	}
	

	@Test
	public void testGildedRose_QualityOfBacstagePassesForSellInValue10() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(22, quality, "Failed quality for Backstage passes to a TAFKAL80ETC concert");
	}


	@Test
	public void testGildedRose_negativeValuesOfQuality() {
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		inn.oneDay();
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality();
		
		assertEquals(0, quality, "Failed quality for Conjured Mana Cake");
	}
	
	
	@Test
	public void testGildedRose_negatedQualityConditional() {
	
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Conjured Mana Cake", 3, 6));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality() - items.get(0).getQuality() - 1;
		
		assertEquals(0, quality, "Failed quality for Conjured Mana Cake");
	}
		
	
	@Test
	public void testGildedRose_decreasesulfurasQuality() {
		
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality() - 1;
		
		assertEquals(80, quality, "Failed quality for Sulfuras, Hand of Ragnaros");
	}

	
	@Test
	public void testGildedRose_increasesulfurasQuality() {
		
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality() + 1;
		
		assertEquals(80, quality, "Failed quality for Sulfuras, Hand of Ragnaros");
	}
	
	
	@Test
	public void testGildedRose_decreasesulfurasSellInValue() {
		
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getSellIn() - 1;
		
		assertEquals(0, quality, "Failed SellIn value for Sulfuras, Hand of Ragnaros");
	}
	
	
	@Test
	public void testGildedRose_increasesulfurasSellInValue() {
		
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getSellIn() + 1;
		
		assertEquals(0, quality, "Failed SellIn value for Sulfuras, Hand of Ragnaros");
	}
	
	
	@Test
	public void testGildedRose_decreaseQualityOfAgedBrie() {
		
		GildedRose inn = new GildedRose();
		inn.setItem(new Item("Aged Brie", 2, 0));
		
		List<Item> items = inn.getItems();
		int quality = items.get(0).getQuality() - 1;
		
		assertEquals(0, quality, "Failed quality for Aged Brie");
	}
}