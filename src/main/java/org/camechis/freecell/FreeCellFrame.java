/*
 * Created on Mar 10, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.camechis.freecell;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class FreeCellFrame extends JFrame 
{
	private final int width = 700;
	private final int height = 550;
	private boolean cardselected;
	private String selectedstack;
	
	private CardPanel top1;
	private CardPanel top2;
	private CardPanel top3;
	private CardPanel top4;
	private CardPanel top5;
	private CardPanel top6;
	private CardPanel top7;
	private CardPanel top8;
	
	private CardPanel bottom1;
	private CardPanel bottom2;
	private CardPanel bottom3;
	private CardPanel bottom4;
	private CardPanel bottom5;
	private CardPanel bottom6;
	private CardPanel bottom7;
	private CardPanel bottom8;
	
	private JPanel top;
	private JPanel bottom;
	private final FreeCellFrame frame;
	
	public FreeCellFrame()
	{
		setSize(width,height);
		setTitle("FreeCell");
		setLayout(new GridLayout(2,1));
		setBackground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentpane = getContentPane();
		frame = this;
		//setup the menu
		JMenuBar menubar = new JMenuBar();
		JMenu game = new JMenu("Game");
		JMenuItem restart = new JMenuItem("Restart");
		JMenuItem quit = new JMenuItem("Quit");
		
		quit.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						System.exit(0);
					}
				});
		
		restart.addActionListener(new
				ActionListener()
				{
					public void actionPerformed(ActionEvent evt)
					{
						frame.dispose();
						FreeCellFrame newfreecellframe = new FreeCellFrame();
						newfreecellframe.setVisible(true);
					}
				});
		game.add(restart);
		game.add(quit);
		menubar.add(game);
		this.setJMenuBar(menubar);
		
		//create the master deck
		CardDeck masterdeck = new CardDeck();
		
		Iterator suitidx = Suit.VALUES.iterator();
		while(suitidx.hasNext())
		{
			Suit suit = (Suit)suitidx.next();
			Iterator typeidx = Type.VALUES.iterator();
			while ( typeidx.hasNext() ) 
			{
				Type type = (Type) typeidx.next();
				Card card = new Card( suit, type );
				masterdeck.AddCard( card );
			}
		}	
		
		//create logo
		LogoPanel logopane = new LogoPanel();
		logopane.setBackground(Color.GREEN);
		
		
		masterdeck.Shuffle(); //shuffle the cards
		
		//create decks
		CardDeck stack1 = new CardDeck();
		CardDeck stack2 = new CardDeck();
		CardDeck stack3 = new CardDeck();
		CardDeck stack4 = new CardDeck();
		CardDeck stack5 = new CardDeck();
		CardDeck stack6 = new CardDeck();
		CardDeck stack7 = new CardDeck();
		CardDeck stack8 = new CardDeck();
		
		//create holder decks
		CardDeck empty1 = new CardDeck();
		CardDeck empty2 = new CardDeck();
		CardDeck empty3 = new CardDeck();
		CardDeck empty4 = new CardDeck();
		CardDeck empty5 = new CardDeck();
		CardDeck empty6 = new CardDeck();
		CardDeck empty7 = new CardDeck();
		CardDeck empty8 = new CardDeck();
		
		//divide cards amount stacks
		for(int idx = 0; idx < 7; idx++)
			stack1.AddCard(masterdeck.GetCard(idx));
		for(int idx = 7; idx < 14;idx++)
			stack2.AddCard(masterdeck.GetCard(idx));
		for(int idx = 14; idx < 21; idx++)
			stack3.AddCard(masterdeck.GetCard(idx));
		for(int idx = 21; idx < 28; idx++)
			stack4.AddCard(masterdeck.GetCard(idx));
		for(int idx = 28; idx < 34; idx++)
			stack5.AddCard(masterdeck.GetCard(idx));
		for(int idx = 34; idx < 40; idx++)
			stack6.AddCard(masterdeck.GetCard(idx));
		for(int idx = 40; idx < 46; idx++)
			stack7.AddCard(masterdeck.GetCard(idx));
		for(int idx = 46; idx < 52; idx++)
			stack8.AddCard(masterdeck.GetCard(idx));
		
		
		//create Panels
		top = new JPanel();
		top.setBackground(Color.GREEN);
		top.setLayout(new GridLayout(1,9));
		bottom = new JPanel();
		bottom.setBackground(Color.GREEN);
		bottom.setLayout(new GridLayout(1,8));
		
		top1 = new CardPanel(empty1, this, "top1", empty1.IsEmpty());
		top2 = new CardPanel(empty2, this, "top2", empty2.IsEmpty());
		top3 = new CardPanel(empty3, this, "top3", empty3.IsEmpty());
		top4 = new CardPanel(empty4, this, "top4", empty4.IsEmpty());
		top5 = new CardPanel(empty5, this, "top5", empty5.IsEmpty());
		top6 = new CardPanel(empty6, this, "top6", empty6.IsEmpty());
		top7 = new CardPanel(empty7, this, "top7", empty7.IsEmpty());
		top8 = new CardPanel(empty8, this, "top8", empty8.IsEmpty());
		
		bottom1 = new CardPanel(stack1, this, "bottom1", stack1.IsEmpty());
		bottom2 = new CardPanel(stack2, this, "bottom2", stack2.IsEmpty());
		bottom3 = new CardPanel(stack3, this, "bottom3", stack3.IsEmpty());
		bottom4 = new CardPanel(stack4, this, "bottom4", stack4.IsEmpty());
		bottom5 = new CardPanel(stack5, this, "bottom5", stack5.IsEmpty());
		bottom6 = new CardPanel(stack6, this, "bottom6", stack6.IsEmpty());
		bottom7 = new CardPanel(stack7, this, "bottom7", stack7.IsEmpty());
		bottom8 = new CardPanel(stack8, this, "bottom8", stack8.IsEmpty());
		
		top.add(top1);
		top.add(top2);
		top.add(top3);
		top.add(top4);
		top.add(logopane);
		top.add(top5);
		top.add(top6);
		top.add(top7);
		top.add(top8);
		
		bottom.add(bottom1);
		bottom.add(bottom2);
		bottom.add(bottom3);
		bottom.add(bottom4);
		bottom.add(bottom5);
		bottom.add(bottom6);
		bottom.add(bottom7);
		bottom.add(bottom8);
		
		contentpane.add(top);
		contentpane.add(bottom);
		
		cardselected = false;
	}
	
	public boolean IsCardSelected()
	{
		return cardselected;
	}
	
	public void setCardSelected()
	{
		cardselected = true;
	}
	
	public void unselectCard()
	{
		cardselected = false;
	}
	
	public void setSelectedStack(String selectedstack)
	{
		this.selectedstack = selectedstack;
	}
	
	public String getSelectedStack()
	{
		return selectedstack;
	}
	
	public CardPanel getSelectedPanel()
	{
		if(selectedstack.equals("top1"))
			return top1;
		else if(selectedstack.equals("top2"))
			return top2;
		else if(selectedstack.equals("top3"))
			return top3;
		else if(selectedstack.equals("top4"))
			return top4;
		else if(selectedstack.equals("bottom1"))
			return bottom1;
		else if(selectedstack.equals("bottom2"))
			return bottom2;
		else if(selectedstack.equals("bottom2"))
				return bottom2;
		else if(selectedstack.equals("bottom3"))
			return bottom3;
		else if(selectedstack.equals("bottom4"))
			return bottom4;
		else if(selectedstack.equals("bottom5"))
			return bottom5;
		else if(selectedstack.equals("bottom6"))
			return bottom6;
		else if(selectedstack.equals("bottom7"))
			return bottom7;
		else
			return bottom8;
	}
	
	public boolean CheckMove(CardPanel movetopanel)
	{
		CardPanel firstclicked = this.getSelectedPanel();
		
		//checks to see if its one of the free cells (only one card can be stored here)
		if( (movetopanel.getID().equals("top1")) || (movetopanel.getID().equals("top2")) || (movetopanel.getID().equals("top3"))  
			||	(movetopanel.getID().equals("top4")))
		{
			if(movetopanel.isEmpty())
			{
				return true;
			}
			else
				return false;
		}
		//if it is one of the foundation cells Checks suit and Value
		if( (movetopanel.getID().equals("top5")) || (movetopanel.getID().equals("top6")) || (movetopanel.getID().equals("top7"))  
				||	(movetopanel.getID().equals("top8")))
		{
			if(movetopanel.isEmpty())
			{
				if(firstclicked.getTopCardVal() == 1)
					return true;
				else
					return false;
			}
			else
			{
				if( (firstclicked.getTopCardVal() == movetopanel.getTopCardVal()+1) && 
						(firstclicked.getTopCardSuit().equals(movetopanel.getTopCardSuit())) )
				{
					return true;
				}
				else
					return false;
			}
		}
		//check bottom stack movements
		else
		{
			if (movetopanel.isEmpty() == true)
				return true;
			else if(movetopanel.getTopCardVal() == 1)
				return false;
			else if ( (firstclicked.getTopCardVal() == movetopanel.getTopCardVal()-1) &&
					( (!firstclicked.getTopCardColor().equals(movetopanel.getTopCardColor()))))
				return true;
			else
				return false;
		}
		
			
	}
	
	public void checkWin()
	{
		if( (top5.getTopCardVal() == 13) && (top6.getTopCardVal() == 13) && (top7.getTopCardVal() == 13)     
			 && (top8.getTopCardVal() == 13) )
		{
			WinDialog win = new WinDialog(this);
			win.setVisible(true);
		}
		else
			return;
	}
	
	public void youWin()
	{
		WinDialog win = new WinDialog(this);
		win.setVisible(true);
	}

}
