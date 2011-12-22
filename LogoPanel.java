/*
 * Created on Mar 17, 2005
 *
 * To change the template for this generated file go to
 * Window&gt;Preferences&gt;Java&gt;Code Generation&gt;Code and Comments
 */

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.imageio.*;

public class LogoPanel extends JPanel 
{
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		try{
			Image image = ImageIO.read(new File("freecell.gif"));
			g.drawImage(image,0,0,null);}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
