package service;

import java.util.List;

import com.mongodb.*;

public class CarService {

	private ConnectionMongodb connectionMongodb = new ConnectionMongodb();

	public List<DBObject> findAll() {
		return connectionMongodb.findAll();

	}

	public void insrt() {
		connectionMongodb.insertData("oumayma", "ana");
	}

}
