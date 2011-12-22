/*
 * Created on Mar 17, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */
package org.camechis.freecell;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class LogoPanel extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4553242014907600496L;

	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try{
			Image image = ImageIO.read(new File("resources/freecell.gif"));
			g.drawImage(image,0,0,null);}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
