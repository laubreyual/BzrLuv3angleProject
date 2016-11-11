import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

public class AgawanBaseFrame extends JFrame{
	/*
		This class is a singleton class to control object creation so that there will be only one frame opened when the game starts
	*/
	private static AgawanBaseFrame instance = null;

	protected AgawanBaseFrame(){
		//exists only to defeat instantiation
	}

	public static AgawanBaseFrame getInstance(){
	/*
		This method returns a JFrame instance if there is already an existing one and will create an instance if there's none
	*/
		if(instance == null)
			instance = new AgawanBaseFrame();

		return instance;
	}

	public static void removeContents(){
	/*
		This method removes all the objects in the container of a frame being "hidden"
	*/
		if(instance != null){
			instance.remove(instance.getContentPane());
			instance.removeKeyListener(instance.getKeyListeners()[0]);
		}
	}
}