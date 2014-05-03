import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginWindow extends JFrame {

	private JPanel panel;
	private JTextField textIp;
	private JTextField textName;
	private JTextField textPort;

	/**
	 * Constructor for LoginWindow
	 */
	public LoginWindow() {
		define();
	}

	/**
	 * Defines the contents in the LoginWindow.
	 * 
	 * All its content is defines and creates here
	 */
	private void define(){
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}

		//Frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 300, 355, 530);				//TODO set center though resolution
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(panel);
		panel.setLayout(null);
		setResizable(false);
		setTitle("Login");

		//IP-Address  - TextField
		textIp = new JTextField();
		textIp.setBounds(84, 145, 180, 32);
		panel.add(textIp);
		textIp.setColumns(10);

		//Screen Name  - TextField
		textName = new JTextField();
		textName.setColumns(10);
		textName.setBounds(84, 70, 180, 32);
		panel.add(textName);

		//Port - TextField
		textPort = new JTextField();
		textPort.setColumns(10);
		textPort.setBounds(84, 220, 180, 32);
		panel.add(textPort);

		//Name - Label
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(155, 50, 38, 16);
		panel.add(lblName);

		//IP-Adress - Label
		JLabel lblIpadress = new JLabel("IP-Adress:");
		lblIpadress.setBounds(144, 125, 61, 16);
		panel.add(lblIpadress);

		//Port - Label
		JLabel lblPort = new JLabel("Port:");
		lblPort.setBounds(155, 200, 38, 16);
		panel.add(lblPort);

		//Login - Button
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {		//ActionListener for Clicking the button
			public void actionPerformed(ActionEvent arg0) {
				LoginProcedure();
			}
		});
		btnNewButton.setBounds(124, 347, 100, 30);
		panel.add(btnNewButton);
	}

	/**
	 * Login sequence
	 * 
	 * Logging in to the server.
	 * 
	 * @param name - the name of the user
	 * @param ip - the Ip-address to the server
	 * @param port - the port to the server.
	 */
	public void login(String name, String ip, int port){
		dispose();
		new ClientWindow(name, ip, port);
	}

	/**
	 * Login Procedure
	 * 
	 * Checks that all the inputs are correct
	 */
	public void LoginProcedure(){
		if(!textName.getText().isEmpty() && !textIp.getText().isEmpty() && !textPort.getText().isEmpty()){
			String name = textName.getText();
			String ip = textIp.getText();
			int port = Integer.parseInt(textPort.getText());
			login(name, ip, port);
			System.out.println("Logged in");
		}else{
			System.out.println("Error");
			System.out.println("Name: " + textName.getText());
			System.out.println("IP: " + textIp.getText());
			System.out.println("Port: " + textPort.getText());
			//TODO felhantering: fixa en r�d label som s�ger att inputen �r fel
		}
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow window = new LoginWindow();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
