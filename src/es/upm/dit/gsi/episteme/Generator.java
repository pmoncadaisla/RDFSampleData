package es.upm.dit.gsi.episteme;

import java.util.ArrayList;
import java.util.List;


import de.svenjacobs.loremipsum.LoremIpsum;
import es.moncadaisla.util.NameGenerator;

public class Generator {
	
	private List<Person> people = new ArrayList<Person>();
		
	private String[] cities = {"Albacete", "Alicante", "Asturias", "Badajoz", "Barcelona", "Burgos",
			"Cantabria", "Ceuta", "Ciudad Real", "Cuenca", "Girona", "Las Palmas", "Granada",
			"Guadalajara", "Huelva", "Huesca", "Illes Balears", "La Rioja", "Madrid", "Melilla", "Murcia",
			"Navarra", "Ourense", "Palencia", "Salamanca", "Segovia", "Soria","Tarragona", "Teruel", "Valladolid",
			"Vizcaya", "Zamora", "Zaragoza"};
	
	private String[] sks = {"Java", "Software Engineering", "C++", "C", "iOS", "Android", 
			"HTML", "HTML5", "Javascript", "jQuery", "Knockout", "Sparql", "Semantic technologies", 
			"Linux", "Social skills", "Server administration", "PHP", "Signal procesing", "Photo editing",
			"Video rendering", "Windows", "Mobile developement", "Scrum"};
	
	private String[] positions = {"Full Proffesor", "Associate Proffesor", "Postgraduate Researcher",
			"Fellow Grade", "Collaborator" };
	
	private String[] levels = {"Beginner", "Intermediate", "Expert"};
	
	public List<Person> generateRandom(int number){
		NameGenerator ng = new NameGenerator();
		LoremIpsum li = new LoremIpsum();
		for (int i=0; i<number;i++){
			String gender = Person.genders[random(0,1)];
			String name;
			if(gender.equals("m"))
				name = ng.getRandomMasculineFullName();
			else
				name = ng.getRandomFeminineFullName();
			
			String citie = cities[random(0,cities.length-1)];
			String zip = Integer.toString(random(20000,50000));
			String address = "Avenida complutense S/N";
			String summary = li.getWords(20);
			String description = li.getWords(60);
			String photoUrl = "http://lab.gsi.dit.upm.es/~pmoncada/episteme/images/random.php?g="+gender+random(1,999999);
			String position = positions[random(0,positions.length-1)];
			List<Skill> skills = new ArrayList<Skill>();
			int ranking = random(100,20000);			
			int numSkills = random(4,sks.length-1);
			
			for(int j = 0; j<numSkills; j++){
				String skillName = sks[random(0,sks.length-1)];
				String skillLevel = levels[random(0,levels.length-1)];
				skills.add(new Skill(skillName, skillLevel));
				
			}
			people.add(new Person(name, citie, zip, address, summary, description, photoUrl, position, ranking, gender,  skills));
			
			
		}
		return people;
	}
	

	public static int random(int min, int max){
		return (min + (int)(Math.random()*(max+1)));
	}

}
