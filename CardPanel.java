/*
 * Created on Mar 9, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class CardPanel extends JPanel implements MouseListener
{
	private CardDeck paneldeck;
	private FreeCellFrame theframe;
	private String id;
	private boolean isempty;
	private boolean freecell;
	private boolean foundationcells;
	private boolean tableaucells;
	private final String emptycard = "b1fv.gif";
	
	public CardPanel(CardDeck deck, FreeCellFrame theframe, String id, boolean isempty)
	{
		paneldeck = deck;
		addMouseListener(this);
		this.theframe = theframe;
		this.id = id;
		this.isempty = isempty;
		freecell = false;
		foundationcells = false;
		tableaucells = false;
		setBackground(Color.GREEN);
		if( (id.equals("top5")) || (id.equals("top6")) || (id.equals("top7")) || (id.equals("top8")))
		{	
			foundationcells = true;
		}
		else if(  (id.equals("top1")) || (id.equals("top2")) || (id.equals("top3")) || (id.equals("top4")))
		{
			freecell = true;
		}
		else
			tableaucells = true;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		int xcord = 0;
		int ycord = 0;
		
		if( (paneldeck.IsEmpty()) && ((freecell == true) || (foundationcells == true)))
		{
			try{
				Image image = ImageIO.read(new File(emptycard));
				g.drawImage(image,xcord,ycord,null);}
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
		else if( (freecell == true) || (foundationcells == true) )
		{
			Card card = paneldeck.GetCard(paneldeck.GetDeckSize()-1);
			Image cardimage = card.getImage();
			g.drawImage(cardimage,xcord, ycord,null);
		}
		else
		{
			for(int idx = 0; idx < paneldeck.GetDeckSize(); idx++)
			{
				Card card = paneldeck.GetCard(idx);
				Image cardimage = card.getImage();
				g.drawImage(cardimage, xcord, ycord, null);
				ycord = ycord+16;
			}
		}
	}
	
	public Card MoveCard()
	{
		Card card = paneldeck.RemoveTopCard();
		return card;
	}
	
	public void addCard(Card card)
	{
		paneldeck.AddCard(card);
	    this.repaint();
	}
	
	public boolean isEmpty()
	{
		return paneldeck.IsEmpty();
	}
	
	public Card getTopCard()
	{
		Card card = paneldeck.GetCard(paneldeck.GetDeckSize()-1);
		return card;
	}
	
	public String getID()
	{
		return id;
	}
	
	public String getTopCardColor()
	{
		Card card = paneldeck.GetCard(paneldeck.GetDeckSize()-1);
		return card.suitColor();
	}
	
	public String getTopCardSuit()
	{
		Card card = paneldeck.GetCard(paneldeck.GetDeckSize()-1);
		return card.suitId();
	}
	
	public int getTopCardVal()
	{
		Card card = paneldeck.GetCard(paneldeck.GetDeckSize()-1);
		if(card == null)
			return -1;
		int x = card.typeToInt();
		return x;
	}
	
	public boolean isFoundationCell()
	{
		if(foundationcells)
			return true;
		else 
			return false;
	}
	
	public boolean isFreeCell()
	{
		if(freecell)
			return true;
		else
			return false;
	}
	
	public boolean isTableauCell()
	{
		if(tableaucells)
			return true;
		else
			return false;
	}
	
	
	public void mousePressed(MouseEvent e){}
	public void mouseExited(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	
	public void mouseClicked(MouseEvent event)
	{
		CardPanel clickedpane = (CardPanel)event.getSource();
		//if no card has been selected already
		System.out.println(clickedpane.getID());
		if(!theframe.IsCardSelected())
		{	
			//can't move these cards
			if( (clickedpane.getID().equals("top5")) || (clickedpane.getID().equals("top6")) ||   
				 (clickedpane.getID().equals("top7")) || (clickedpane.getID().equals("top8")) )
			{
				return;
			}
			else
			{
				theframe.setCardSelected();
				theframe.setSelectedStack(clickedpane.getID());
			}
		}
		else
		{
			if (theframe.CheckMove(clickedpane) == true)
			{
				CardPanel firstclicked = theframe.getSelectedPanel();
				Card movecard = firstclicked.MoveCard();
				this.addCard(movecard); //also repaints it
				clickedpane.repaint();
				theframe.unselectCard();
				firstclicked.repaint();
				theframe.checkWin();
			}
			else
			{
				JOptionPane.showMessageDialog(this,"YOU CAN'T MOVE YOUR CARD HERE!", "Bad Move", JOptionPane.ERROR_MESSAGE);
				theframe.unselectCard();
			}
			
		}
	}
}
