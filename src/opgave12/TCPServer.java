package opgave12;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class TCPServer {

	public static void main(String[] args) throws Exception {
		ArrayList<Person> personer = new ArrayList<>();

		String clientSentence;
		String capitalizedSentence = "";
		ServerSocket welcomSocket = new ServerSocket(6789);

		Socket connectionSocket = welcomSocket.accept();
		BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
		DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

		modtagPersoner(personer, inFromClient);
		System.out.println(personer);
	}

	public static void modtagPersoner(ArrayList<Person> personer, BufferedReader instream) {
		String message = "";
        try {
            message = instream.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
		String[] people = message.split("/");
		for (int i = 0; i < people.length; i++) {
			String[] o = people[i].split(",");
			personer.add(new Person(Integer.parseInt(o[0]), o[1], o[2]));
		}
    }
}
