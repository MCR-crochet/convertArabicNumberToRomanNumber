package com.ineat.ChiffreRomain;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.ineat.exception.ConversionException;
import com.ineat.utils.Utils;

/**
 * Test de conversion de chiffres arabes en chiffres romains.
 */
public class AppTest {
	
	@Test 
	public void convert123() throws ConversionException {
		String nombre = Utils.convertArabicNumberToRomanNumber("123");
		assertEquals("La conversion est correcte", "CXXIII", nombre);
	}
	
	@Test(expected=ConversionException.class)
	public void convert123Negatif() throws ConversionException {
		String nombre = Utils.convertArabicNumberToRomanNumber("-123");
	}
	
	@Test(expected=ConversionException.class)
	public void convert4000() throws ConversionException {
		String nombre = Utils.convertArabicNumberToRomanNumber("4000");
	}
}
