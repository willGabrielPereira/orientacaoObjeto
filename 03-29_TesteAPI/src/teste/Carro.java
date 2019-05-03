package teste;

public class Carro {
	private String key;
	private int id;
	private String fipe_name;
	private String name;
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Carro [key=");
		builder.append(key);
		builder.append(", id=");
		builder.append(id);
		builder.append(", fipe_name=");
		builder.append(fipe_name);
		builder.append(", name=");
		builder.append(name);
		builder.append("]");
		builder.append("\n");
		return builder.toString();
	}
	
	
}
