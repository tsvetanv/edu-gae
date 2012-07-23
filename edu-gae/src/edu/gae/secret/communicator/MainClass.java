package edu.gae.secret.communicator;

import edu.gae.secret.communicator.dao.MessageDAO;
import edu.gae.secret.communicator.model.Message;

public class MainClass {

	public static void main(String[] args) {

		Message msg = new Message();
		msg.setContent("Proba");

		MessageDAO msgDAO = new MessageDAO();
		msgDAO.storeMessage(msg);
	}
}
