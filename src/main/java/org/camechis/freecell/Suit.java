/*
 * Created on Mar 7, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.camechis.freecell;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Suit 
{
	private String name;
	private String color;
	private String symb;
	
	public final static Suit DIAMONDS = new Suit("Diamonds", "Red", "d");
	
	public final static Suit CLUBS = new Suit("Clubs", "Black", "c");
	
	public final static Suit HEARTS= new Suit("Hearts", "Red", "h");
	
	public final static Suit SPADES = new Suit("Spades", "Black", "s");
	
	/**
	 * The Constructor
	 */
	
	private Suit(String name, String color, String symb)
	{
		this.name = name;
		this.color = color;
		this.symb = symb;
	}
	
	
	/**
	 * Gives the Suit name
	 * @return The name of the suit
	 */
	public String getSuit()
	{
		return name;
	}
	
	public String getSymb()
	{
		return symb;
	}
	/**
	 * Gives the color of the suit
	 * @return The color of the Suit
	 */
	public String getColor()
	{
		return color;
	}
	
	/**
	 * Creates an unmodifiable list of Suit Types
	 * Can traverse this list using an iterator
	 */
	public final static List VALUES = Collections.unmodifiableList( 
	         Arrays.asList( new Suit[] { DIAMONDS, CLUBS, HEARTS, SPADES } ) );
	
	public String toString()
	{
		return name;
	}
	

}
