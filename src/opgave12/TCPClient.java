package opgave12;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class TCPClient {

	public static void main(String[] args) throws Exception, IOException {
		ArrayList<Person> personer = new ArrayList<>(List.of(new Person(1, "Mark", "Aarhus"),
															new Person(2, "Henrik", "Horsens"),
															new Person(3, "Karsten", "Esbjerg"),
															new Person(4, "Morten", "Aalborg"),
															new Person(5, "Billy", "Austin")));

		String sentence = "";
		String modifiedSentence;
		
		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

		Socket clientSocket = new Socket("localhost", 6789);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sendPersoner(personer, outToServer);
		clientSocket.close();
	}

	public static void sendPersoner(ArrayList<Person> personer, DataOutputStream outstream) {
		String messageToSend = "";
		for (int i = 0; i < personer.size(); i++) {
			messageToSend += personer.get(i).getId() + "," + personer.get(i).getNavn() + "," + personer.get(i).getBy();
			if (i < personer.size() - 1) {
				messageToSend += "/";
			}
		}
		messageToSend += "\n";
		try {
			outstream.writeBytes(messageToSend);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
