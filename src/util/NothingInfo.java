package util;

public class NothingInfo {
	private Integer id;
	private String name;
	private Integer number;
	public NothingInfo() {
		super();
	}
	public NothingInfo(Integer id, String name, Integer number) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
}
