package es.upm.dit.gsi.episteme;

import java.util.List;

public class Person {
	
	/* Posible Genders */
	/* m=masculine */
	/* f=feminine */
	public static String[] genders = {"m", "f"};
	
	private String name;
	private String locality;
	private String zip;
	private String address;
	private String summary;
	private String description;
	private String photoUrl;
	private String position;
	private String gender;
	private int ranking;
	private List<Skill> skills;
	
	public Person(String name, String locality, String zip, String address,
			String summary, String description, String photoUrl) {
		super();
		this.name = name;
		this.locality = locality;
		this.zip = zip;
		this.address = address;
		this.summary = summary;
		this.description = description;
		this.photoUrl = photoUrl;
	}
	
	public Person(String name, String locality, String zip, String address,
			String summary, String description, String photoUrl, List<Skill> skills) {
		super();
		this.name = name;
		this.locality = locality;
		this.zip = zip;
		this.address = address;
		this.summary = summary;
		this.description = description;
		this.photoUrl = photoUrl;
		this.skills = skills;
	}
	public Person(String name, String locality, String zip, String address,
			String summary, String description, String photoUrl,
			String position, int ranking, String gender, List<Skill> skills) {
		super();
		this.name = name;
		this.locality = locality;
		this.zip = zip;
		this.address = address;
		this.summary = summary;
		this.description = description;
		this.photoUrl = photoUrl;
		this.setPosition(position);
		this.ranking = ranking;
		this.gender = gender;
		this.skills = skills;
	}

	public Person(String name, String locality, String zip, String address,
			String summary, String description, String photoUrl,
			String position, int ranking, String gender) {
		super();
		this.name = name;
		this.locality = locality;
		this.zip = zip;
		this.address = address;
		this.summary = summary;
		this.description = description;
		this.photoUrl = photoUrl;
		this.setPosition(position);
		this.ranking = ranking;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	public void setSkill(Skill skill){
		this.skills.add(skill);
	}

	public List<Skill> getSkills() {
		return skills;
	}

	public void setSkills(List<Skill> skills) {
		this.skills = skills;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	
	public String getUid(){
		return this.name.replaceAll("\\s","");
	}
	
	
	
}
