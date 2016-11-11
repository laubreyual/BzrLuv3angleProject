import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameTimer extends JLabel implements Runnable{
	private int seconds;
	private JFrame frame;
	private JFrame frame2;
	private boolean running;

	//constructor
	public GameTimer(int seconds, JFrame frame, JFrame frame2){
		super("Timer: " + seconds, JLabel.CENTER);
		this.seconds = seconds;
		this.setText(seconds + " ");
		this.frame = frame;
		this.frame2 = frame2;
		this.running = true;
	}

	public void run(){
		while(running){
			while(seconds>0){
				try{
					Thread.sleep(1000);
					seconds--;

					this.setText(seconds + " ");
					if(running==false) break;
				}catch(Exception e){}
			}
			if(seconds==0) break;
		}
		if(seconds==0){
			ImageIcon diamond = new ImageIcon("pictures/diamond.png");
			JOptionPane.showMessageDialog(frame, "Congratulations!", "Game Ended", JOptionPane.INFORMATION_MESSAGE, diamond);

			frame.setVisible(false);
			frame2.setVisible(true);
		}
	}

	public void terminate(){
		this.running = false;
	}
}