/*
 * Created on Mar 25, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.camechis.freecell;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WinDialog extends JDialog 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9083997232645079687L;
	private final FreeCellFrame freecellframe;
	public WinDialog(FreeCellFrame owner)
	{
		super(owner,"YOU WIN!",true);
		freecellframe = owner;
		Container contentpane = getContentPane();
		setSize(250,150);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ImageIcon icon = new ImageIcon("resources/smiley1.gif","YOU WIN!!!!");
		JLabel iconlabel = new JLabel(icon);
		iconlabel.setText("YOU WIN!!!");
	
		JPanel buttonpanel = new JPanel();
		JButton restart = new JButton("Restart");
		JButton quit = new JButton("Quit");
		buttonpanel.add(restart);
		buttonpanel.add(quit);
		
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
						freecellframe.dispose();
						FreeCellFrame newfreecellframe = new FreeCellFrame();
						newfreecellframe.setVisible(true);
					}
				});
		
		contentpane.add(iconlabel, BorderLayout.CENTER);
		contentpane.add(buttonpanel, BorderLayout.SOUTH);
	}

}
