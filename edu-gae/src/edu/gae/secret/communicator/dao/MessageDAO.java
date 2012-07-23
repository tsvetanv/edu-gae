package edu.gae.secret.communicator.dao;

import java.util.logging.Logger;

import org.apache.jsp.ah.datastoreViewerBody_jsp;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;

import edu.gae.secret.communicator.model.Message;

public class MessageDAO {

	public static final String KIND = "Message";
	public static final String CONTENT = "Data";

	private static final Logger log = Logger.getLogger(MessageDAO.class
			.getName());

	public Key storeMessage(Message msg) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		// Key key= KeyFactory.createKey("channel", "channel1");
		Entity entity = new Entity(KIND);
		entity.setProperty(CONTENT, msg.getContent());

		Key key = datastore.put(entity);
		return key;
	}

	public Message getMessage(Key key) {
		DatastoreService datastore = DatastoreServiceFactory
				.getDatastoreService();

		// get entity
		String content=null;
		try {
			Entity entity = datastore.get(key);
			content=(String) entity.getProperty(CONTENT);
		} catch (EntityNotFoundException e) {
			e.printStackTrace();
		}
		// convert to msg
		// return msg
		Message msg= new Message(content, null);
		return msg;
	}

	// public void setDatastore(DatastoreService datastore) {
	// this.datastore = datastore;
	// }
}
