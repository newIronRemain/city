package com.pojo;

public class City {

	private Integer id;
	
	private String name;
	
	private String type;
	
	private String code;
	
	private String parentcode;

	private String parenttype;

	private City city;

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getParentcode() {
		return parentcode;
	}

	public void setParentcode(String parentcode) {
		this.parentcode = parentcode;
	}

	public String getParenttype() {
		return parenttype;
	}

	public void setParenttype(String parenttype) {
		this.parenttype = parenttype;
	}





	@Override
	public String toString() {
		return "City{" +
				"id=" + id +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", code='" + code + '\'' +
				", parentcode='" + parentcode + '\'' +
				", parenttype='" + parenttype + '\'' +
				'}';
	}
}
