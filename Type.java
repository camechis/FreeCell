/*
 * Created on Mar 7, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.util.*;

public class Type 
{
	private String type;
	private String symb;
	
	public final static Type TWO = new Type("Two", "2");
	
	public final static Type THREE = new Type("Three", "3");
	
	public final static Type FOUR = new Type("Four", "4");
	
	public final static Type FIVE = new Type("Five", "5");
	
	public final static Type SIX = new Type("Six", "6");
	
	public final static Type SEVEN = new Type("Seven", "7");

	public final static Type EIGHT = new Type("Eight", "8");
	
	public final static Type NINE = new Type("Nine", "9");
	
	public final static Type TEN = new Type("Ten", "10" );
	
	public final static Type JACK = new Type("Jack", "j");
	
	public final static Type QUEEN = new Type("Queen", "q");
	
	public final static Type KING = new Type("King", "k");
	
	public final static Type ACE = new Type("Ace", "1");
	
	private Type(String type, String symb)
	{
		this.type = type;
		this.symb = symb;
	}
	
	public String getType()
	{
		return type;
	}
	
	public String getSymb()
	{
		return symb;
	}
	
	
	/**
	 * Collection of Card Types used for iteration
	 */
	public final static List VALUES = Collections.unmodifiableList( 
	         Arrays.asList( new Type[] { TWO, THREE, FOUR, FIVE, SIX, SEVEN,
                     					EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE } ) );
	
	
	public String toString()
	{
		return type;
	}

}
