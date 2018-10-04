import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Server {
	public static void main(String[] args) {
		try {

			String str = null;
			str = JOptionPane.showInputDialog("Enter your message");

			ServerSocket ss = new ServerSocket(0);
			JOptionPane.showMessageDialog(null, "Waiting for client on port " + ss.getLocalPort());

			Socket s = ss.accept();
			JOptionPane.showMessageDialog(null, "Connected to " + s.getRemoteSocketAddress());
			
			DataInputStream in = new DataInputStream(s.getInputStream());
			JOptionPane.showMessageDialog(null, "Client - " + in.readUTF());

			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeUTF("I am " + s.getLocalSocketAddress());
			out.writeUTF(str);

			s.close();
			ss.close();

		} catch (Exception e) {
			System.out.println("Error " + e + "occured");
		}

	}
}