package dto;

public class Marca {
	
	private String key;
	private int id;
	private String fipe_name;
	private String name;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFipe_name() {
		return fipe_name;
	}
	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Marca [key=");
		builder.append(key);
		builder.append(", id=");
		builder.append(id);
		builder.append(", fipe_name=");
		builder.append(fipe_name);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		return builder.toString();
	}
	
	
}
