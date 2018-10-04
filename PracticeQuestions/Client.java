import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {
	public static void main(String[] args) {
		try {
			
			String str = null;
			str = JOptionPane.showInputDialog("Enter a message for server");

			Socket c = new Socket(args[0], Integer.parseInt(args[1]));
			JOptionPane.showMessageDialog(null, "Connected to " + c.getRemoteSocketAddress());
			
			DataOutputStream out = new DataOutputStream(c.getOutputStream());
			out.writeUTF("Hello Server I am " + c.getLocalSocketAddress());
			out.writeUTF(str);

			DataInputStream in = new DataInputStream(c.getInputStream());
			JOptionPane.showMessageDialog(null, "Server - " + in.readUTF());
			
			c.close();

		} catch (Exception e) {
			System.out.println(e);
		}
		
	}
}