package org.camechis.freecell;

import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Card {
	private Suit suitval; // the suit value of the card
	private Type typeval; // the type of the card(ace, queen, 3, etc)
	private Image cardimage; // the image representing the card
	private String imagename;

	public Card(Suit suit, Type type) {
		suitval = suit;
		typeval = type;
		imagename = suit.getSymb() + type.getSymb() + ".gif";
		System.out.println(imagename);
	}

	public Suit getSuit() {
		return suitval;
	}

	public Type getType() {
		return typeval;
	}

	public static String getImageName(Suit suit, Type type) {
		String suitvalue = suit.getSuit();
		String typevalue = type.getType();
		String imagename = suitvalue + typevalue;
		return imagename;
	}

	public Image getImage() {
		try {
			cardimage = ImageIO.read(new File("resources/" + imagename));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return cardimage;
	}

	public String suitColor() {
		return suitval.getColor();
	}

	public String suitId() {
		return suitval.getSymb();
	}

	public Integer typeToInt() {
		String type = typeval.getSymb();
		if (type.equals("j"))
			return 11;
		else if (type.equals("q"))
			return 12;
		else if (type.equals("k"))
			return 13;
		else {
			Integer integerval = new Integer(type);
			int x = integerval.intValue();
			return x;
		}

	}
}
