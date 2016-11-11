import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.imageio.*;
import java.io.*;
import java.util.logging.*;
import java.awt.image.*;

public class AgawanBaseWorld extends JPanel{
	private char type;
	private BufferedImage image;

	//constructor
	public AgawanBaseWorld(char type){
		super();
		this.type = type;
		try{
			if(type=='G') //ground
				image = ImageIO.read(new File("pictures/ground.jpg"));
			else if(type=='D') //diamond
				image = ImageIO.read(new File("pictures/diamond.png"));
		}catch(Exception e){}
	}

	protected void paintComponent(Graphics g){
	/*
		This method gives the image of the JPanels
	*/
		try{
			super.paintComponent(g);

			if(type=='G')
				image = ImageIO.read(new File("pictures/ground.jpg"));
			else if(type=='D')
				image = ImageIO.read(new File("pictures/diamond.png"));
		}catch(Exception e){}

		g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
	}

	public void setType(char c){
		this.type = c;
	}

	public char getType(){
		return this.type;
	}
}