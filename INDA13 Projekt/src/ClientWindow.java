import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class ClientWindow extends JFrame {

	private JPanel panel;
	private String name;
	private String ip;
	private int port;
	private JMenuBar menuBar;
	private JTextField txtMessage;
	private JTextArea textHistory;

	/**
	 * Constructor for ClientWindow
	 */
	public ClientWindow(String name, String ip, int port) {
		this.name = name;
		this.ip = ip;
		this.port = port;
		define();
		printToScreen(name + " is connected on " + ip + ":" + port);
	}

	/**
	 * Defines the content in ClientWindow
	 * 
	 * All its content is defines and creates here
	 */
	private void define(){
		//Panel
		panel = new JPanel();
		panel.setAlignmentY(Component.TOP_ALIGNMENT);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);

		//Frame Settings
		setTitle("Chatroom");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 800);
		setResizable(true);	

		//Layout -GridBagLayout
		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[]{40, 910, 40, 10};						//sum = 1000
		layout.rowHeights = new int[]{75, 660, 55};								//sum = 800
		layout.columnWeights = new double[]{1.0, 1.0, 0.0};
		layout.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel.setLayout(layout);

		//On Screen History - TextArea
		textHistory = new JTextArea();
		textHistory.setFont(new Font("Arial", Font.PLAIN, 18));
		textHistory.setEditable(false);
		GridBagConstraints textHistoryConstrains = new GridBagConstraints();
		textHistoryConstrains.gridwidth = 2;
		textHistoryConstrains.insets = new Insets(0, 0, 5, 5);
		textHistoryConstrains.fill = GridBagConstraints.BOTH;
		textHistoryConstrains.gridx = 1;
		textHistoryConstrains.gridy = 1;
		panel.add(textHistory, textHistoryConstrains);

		//Message Field - TextField
		txtMessage = new JTextField();
		GridBagConstraints txtMessageConstrains = new GridBagConstraints();
		txtMessageConstrains.fill = GridBagConstraints.HORIZONTAL;
		txtMessageConstrains.insets = new Insets(0, 0, 0, 5);
		txtMessageConstrains.gridx = 1;
		txtMessageConstrains.gridy = 2;
		panel.add(txtMessage, txtMessageConstrains);
		txtMessage.setColumns(10);
		txtMessage.requestFocusInWindow();												//Sets focus on the message input

		//Send - Button
		JButton sendButton = new JButton("Send");
		sendButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String sendMessage = txtMessage.getText();
				if(sendMessage.length() > 0 ){
					printToScreen(name + ": " + sendMessage);
					txtMessage.setText("");
				}
			}
		});
		GridBagConstraints sendButtonConstrains = new GridBagConstraints();
		sendButtonConstrains.insets = new Insets(0, 0, 0, 5);
		sendButtonConstrains.gridx = 2;
		sendButtonConstrains.gridy = 2;
		panel.add(sendButton, sendButtonConstrains);

		//Menubar
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		//Menu - File
		JMenu fileMenu = new JMenu("File");
		fileMenu.setIconTextGap(8);
		menuBar.add(fileMenu);

		//MenuItem - Open
		JMenuItem menuItemOpen = new JMenuItem("Open");
		fileMenu.add(menuItemOpen);

		//MenuItem - Exit
		JMenuItem menuItemExit = new JMenuItem("Exit");
		menuItemExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		fileMenu.add(menuItemExit);
	}

	public void printToScreen(String message){
		textHistory.append(message + "\n");
	}
}

//TODO Smilesar
//TODO Scrollbar
//TODO Logged in activity

