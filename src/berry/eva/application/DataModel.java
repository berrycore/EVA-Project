package berry.eva.application;

import java.util.ArrayList;
import java.util.List;

public class DataModel {

	private String name;
	public DataModel parent;
	public List<DataModel> child = new ArrayList<DataModel>();
	
	public DataModel(String name,DataModel parent) {
		this.name = name;
		this.parent = parent;
	}

	@Override
	public String toString() {
		return "name:" + name;
	}
}
