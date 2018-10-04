import java.awt.Dimension;
import java.awt.FlowLayout;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;
import javax.swing.*;

public class IPFinder extends JFrame {

	JTextField text;

	IPFinder() {

		try {
			
			String host = null;
			// JOptionPane.showInputDialog("Enter any url");
			Scanner sc = new Scanner(System.in);
			host = sc.next();
			InetAddress address = InetAddress.getLocalHost();
			// JOptionPane.showMessageDialog(null, address.toString());
			System.out.println(address.toString());

			setLayout(new FlowLayout(FlowLayout.CENTER));

			add(new JTextField(address.toString().replaceAll("/(\\d|\\.)+", "")));

			setVisible(true);
			setSize(new Dimension(200, 200));

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	public static void main(String[] args) {
		new IPFinder();
	}
}