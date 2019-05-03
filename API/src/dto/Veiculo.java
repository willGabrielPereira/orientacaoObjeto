package dto;

public class Veiculo {
	private String key;
	private String name;
	private String id;
	private String fipe_name;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFipe_name() {
		return fipe_name;
	}
	public void setFipe_name(String fipe_name) {
		this.fipe_name = fipe_name;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Veiculo [key=");
		builder.append(key);
		builder.append(", name=");
		builder.append(name);
		builder.append(", id=");
		builder.append(id);
		builder.append(", fipe_name=");
		builder.append(fipe_name);
		builder.append("]");
		return builder.toString();
	}
	
	

}
