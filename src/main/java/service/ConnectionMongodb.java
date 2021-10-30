package service;

import java.util.List;

import javax.inject.Named;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ConnectionMongodb {

	private DB database;
	private DBCollection collection;

	public void startConnection() {
		MongoClient mongoClient = new MongoClient();
		this.database = mongoClient.getDB("test");
		mongoClient.getDatabaseNames().forEach(System.out::println);
		// this.database.createCollection("users", null);
		// this.database.getCollectionNames().forEach(System.out::println);
		// System.out.println("logged in");
	}

	public void insertData(String name, String password) {
		this.startConnection();
		this.collection = this.database.getCollection("car");
		BasicDBObject document = new BasicDBObject();
		document.put("name", name);
		document.put("password", password);
		this.collection.insert(document);
		System.out.println("inserted");
	}

	public List<DBObject> findAll() {
		this.startConnection();
		this.collection = this.database.getCollection("car");
		List<DBObject> all = collection.find().toArray();
		return all;
	}

}
