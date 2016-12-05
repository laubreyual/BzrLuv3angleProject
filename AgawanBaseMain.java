import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;
import java.util.Random;

public class AgawanBaseMain{
	public static void main(String[] args) throws Exception{
		final JFrame menu = new JFrame("Agawan Base");
		final JFrame instructions = new JFrame("Instructions");

		BufferedImage image = ImageIO.read(new File("pictures/diamond.png"));
		menu.setIconImage(image);
		instructions.setIconImage(image);

		//contents of instructions frame
		instructions.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		final Container instructionsContainer = instructions.getContentPane();
		instructionsContainer.setPreferredSize(new Dimension(1000,700));
		instructionsContainer.setLayout(new BorderLayout());
		final JPanel instructionsPanel = new JPanel();
		final JPanel instructionsPanel2 = new JPanel();
		final JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new FlowLayout());
		final JPanel buttonsPanel2 = new JPanel();
		buttonsPanel2.setLayout(new FlowLayout());
		//images needed for instructions & buttons panels
		ImageIcon paragraph1 = new ImageIcon("pictures/instructions.png");
		ImageIcon paragraph2 = new ImageIcon("pictures/instructions2.png");
		ImageIcon next = new ImageIcon("pictures/next.png");
		ImageIcon back = new ImageIcon("pictures/back.png");
		ImageIcon home = new ImageIcon("pictures/home.png");
		final JLabel paragraphLabel = new JLabel(paragraph1);
		final JLabel paragraphLabel2 = new JLabel(paragraph2);
		final JButton nextButton = new JButton(next);
		nextButton.setOpaque(false);
		nextButton.setContentAreaFilled(false);
		nextButton.setBorderPainted(false);
		nextButton.setFocusPainted(false);
		final JButton backButton = new JButton(back);
		backButton.setOpaque(false);
		backButton.setContentAreaFilled(false);
		backButton.setBorderPainted(false);
		backButton.setFocusPainted(false);
		final JButton homeButton = new JButton(home);
		homeButton.setOpaque(false);
		homeButton.setContentAreaFilled(false);
		homeButton.setBorderPainted(false);
		homeButton.setFocusPainted(false);
		instructionsPanel.add(paragraphLabel);
		buttonsPanel.add(homeButton);
		buttonsPanel.add(nextButton);
		instructions.add(instructionsPanel, BorderLayout.CENTER);
		instructions.add(buttonsPanel, BorderLayout.SOUTH);
		nextButton.addActionListener(new ActionListener(){		//makes the next panel visible and the current panel hidden
			public void actionPerformed(ActionEvent e){
				instructionsPanel.setVisible(false);
				buttonsPanel.setVisible(false);
				instructionsPanel2.add(paragraphLabel2);
				buttonsPanel2.add(homeButton);
				buttonsPanel2.add(backButton);
				instructions.remove(instructionsPanel);
				instructions.remove(buttonsPanel);
				instructions.add(instructionsPanel2, BorderLayout.CENTER);
				instructions.add(buttonsPanel2, BorderLayout.SOUTH);
				instructionsPanel2.setVisible(true);
				buttonsPanel2.setVisible(true);
			}
		});
		backButton.addActionListener(new ActionListener(){		//makes the previous panel visible and the current panel hidden
			public void actionPerformed(ActionEvent e){
				instructionsPanel2.setVisible(false);
				buttonsPanel2.setVisible(false);
				instructionsPanel.add(paragraphLabel);
				buttonsPanel.add(homeButton);
				buttonsPanel.add(nextButton);
				instructions.remove(instructionsPanel2);
				instructions.remove(buttonsPanel2);
				instructions.add(instructionsPanel, BorderLayout.CENTER);
				instructions.add(buttonsPanel, BorderLayout.SOUTH);
				instructionsPanel.setVisible(true);
				buttonsPanel.setVisible(true);
			}
		});
		homeButton.addActionListener(new ActionListener(){		//hides instructions frame then goes back to main menu
			public void actionPerformed(ActionEvent e){
				instructions.setVisible(false);
				menu.setVisible(true);
			}
		});
		instructions.pack();

		final JFrame dev = new JFrame("Developers");
		dev.setIconImage(image);
		//contents of developers frame
		dev.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container mainDev = dev.getContentPane();
		mainDev.setPreferredSize(new Dimension(1000,700));
		mainDev.setLayout(new BorderLayout());
		JPanel mainDevPanel = new JPanel();
		ImageIcon developers = new ImageIcon("pictures/developers.png");
		ImageIcon homeForDev = new ImageIcon("pictures/home.png");
		final JButton homeButtonForDev = new JButton(homeForDev);
		homeButtonForDev.setOpaque(false);
		homeButtonForDev.setContentAreaFilled(false);
		homeButtonForDev.setBorderPainted(false);
		homeButtonForDev.setFocusPainted(false);
		JLabel devLabel = new JLabel(developers);
		mainDevPanel.add(devLabel);
		mainDev.add(mainDevPanel, BorderLayout.CENTER);
		mainDev.add(homeButtonForDev, BorderLayout.SOUTH);
		homeButtonForDev.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				dev.setVisible(false);
				menu.setVisible(true);
			}
		});
		dev.pack();

		//contents of menu frame
		menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container menuContainer = menu.getContentPane();
		menuContainer.setPreferredSize(new Dimension(1000,700));
		JPanel mainMenu = new JPanel();
		mainMenu.setLayout(new GridLayout(5,1));
		ImageIcon title = new ImageIcon("pictures/title.png");
		ImageIcon wordMenu = new ImageIcon("pictures/menu.png");
		final ImageIcon play = new ImageIcon("pictures/play.png");
		final ImageIcon howToPlay = new ImageIcon("pictures/how.png");
		final ImageIcon devTeam = new ImageIcon("pictures/dev.png");
		JLabel titleLabel = new JLabel(title);
		JLabel menuLabel = new JLabel(wordMenu);
		final JButton playButton = new JButton(play);
		playButton.setOpaque(false);
		playButton.setContentAreaFilled(false);
		playButton.setBorderPainted(false);
		playButton.setFocusPainted(false);
		final JButton howToPlayButton = new JButton(howToPlay);
		howToPlayButton.setOpaque(false);
		howToPlayButton.setContentAreaFilled(false);
		howToPlayButton.setBorderPainted(false);
		howToPlayButton.setFocusPainted(false);
		final JButton devTeamButton = new JButton(devTeam);
		devTeamButton.setOpaque(false);
		devTeamButton.setContentAreaFilled(false);
		devTeamButton.setBorderPainted(false);
		devTeamButton.setFocusPainted(false);
		mainMenu.add(titleLabel);
		mainMenu.add(menuLabel);
		mainMenu.add(playButton);
		mainMenu.add(howToPlayButton);
		mainMenu.add(devTeamButton);
		menuContainer.add(mainMenu);
		playButton.addActionListener(new ActionListener(){	//starts the game
			public void actionPerformed(ActionEvent e){
				try{
					System.out.println("HELLO");
					gameStart(menu);
				}
				catch(Exception ex){}
			}
		});
		howToPlayButton.addActionListener(new ActionListener(){		//hides main menu then goes to the instructions frame
			public void actionPerformed(ActionEvent e){
				menu.setVisible(false);
				instructions.setVisible(true);
			}
		});
		devTeamButton.addActionListener(new ActionListener(){	//hides main menu then goes to the developers frame
			public void actionPerformed(ActionEvent e){
				menu.setVisible(false);
				dev.setVisible(true);
			}
		});
		playButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			
			public void mouseEntered(MouseEvent e){
				ImageIcon play2 = new ImageIcon("pictures/play2.png");
				playButton.setIcon(play2);
			}
			public void mouseExited(MouseEvent e){
				playButton.setIcon(play);
			}
		});
		howToPlayButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			
			public void mouseEntered(MouseEvent e){
				ImageIcon howToPlay2 = new ImageIcon("pictures/how2.png");
				howToPlayButton.setIcon(howToPlay2);
			}
			public void mouseExited(MouseEvent e){
				howToPlayButton.setIcon(howToPlay);
			}
		});
		devTeamButton.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e){}
			public void mousePressed(MouseEvent e){}
			public void mouseReleased(MouseEvent e){}
			
			public void mouseEntered(MouseEvent e){
				ImageIcon devTeam2 = new ImageIcon("pictures/dev2.png");
				devTeamButton.setIcon(devTeam2);
			}
			public void mouseExited(MouseEvent e){
				devTeamButton.setIcon(devTeam);
			}
		});

		menu.setVisible(true);
		menu.pack();
	}

	public static void gameStart(JFrame menu) throws Exception{
	/*
		This method contains the game proper. Singleton is also used in the method so that there will be only one game frame opened even if the
		play button is clicked multiple times.
	*/
		System.out.println("what");
		AgawanBaseFrame.removeContents();
		AgawanBaseFrame frame = AgawanBaseFrame.getInstance();
		BufferedImage image = ImageIO.read(new File("pictures/diamond.png"));
		frame.setIconImage(image);

		String b = null;
		BufferedReader reader = new BufferedReader(new FileReader("template/template.txt"));

		//Container mainContainer = new Container();
		//frame.setContentPane(mainContainer);
		//mainContainer.setPreferredSize(new Dimension(1000,700));
		//mainContainer.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Container placeContainer = new Container();
		//placeContainer.setLayout(new GridLayout(21,21));
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new GridLayout(1,3));
		//JPanel chatPanel = new JPanel();
		//chatPanel.setLayout(new FlowLayout());
		//JLabel chat = new JLabel("INSERT CHAT HERE");

		//GameTimer timer = new GameTimer(180, frame, menu);
		//final Thread timerThread = new Thread(timer);

		//final AgawanBaseWorld[][] world = new AgawanBaseWorld[21][21];
		GameServer gw = new GameServer(2);
		CircleWars cw = new CircleWars("localhost", "player1");
		CircleWars cw1 = new CircleWars("localhost", "player2"); 
		/*int j;
		for(j=0; j<21; j++){
			//file reading
			b = reader.readLine();

			if(b != null){
				int i;
				for(i=0; i<b.length(); i++){
					world[j][i] = new AgawanBaseWorld(b.charAt(i));

					placeContainer.add(world[j][i]);
				}
			}
		}*/
		topPanel.add(new JLabel(" "));
		//topPanel.add(timer);
		//mainContainer.add(placeContainer, BorderLayout.CENTER);
		//mainContainer.add(topPanel, BorderLayout.NORTH);
		//mainContainer.add(chatPanel, BorderLayout.SOUTH);
		reader.close();

		frame.pack();
		menu.setVisible(false);
		frame.setVisible(true);
	}
}