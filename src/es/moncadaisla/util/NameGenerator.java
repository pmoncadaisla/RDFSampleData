package es.moncadaisla.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Random name generator
 * @author Pablo Moncada Isla pmoncada@dit.upm.es
 * @version 11/07/2013
 *
 */
public class NameGenerator {
	
	
	private String[] lastNames = {"Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
			"Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Garcia",
			"Martinez", "Robinson", "Clark", "Rodriguez", "Lewis", "Lee", "Walker", "Hall", "Allen", "Young", 
			"Hernandez", "King", "Wright", "Lopez", "Hill", "Scott", "Green", "Adams", "Baker", "Gonzalez", "Nelson",
			"Carter", "Mitchell", "Perez", "Roberts", "Turner", "Philips", "Campbell", "Parker", "Evans", "Edwards",
			"Collins", "Stewart", "Sanchez", "Morris", "Rogers", "Reed", "Cook", "Morgan", "Bell", "Murphy", "Bailey",
			"Rivera", "Cooper", "Richardson", "Cox", "Howard", "Ward", "Torres", "Peterson", "Gray", "Ramirez", "James",
			"Watson", "Brooks", "Kelly", "Sanders", "Price", "Bennet", "Wood", "Barnes", "Ross", "Henderson", "Coleman",
			"Jenkings", "Perry", "Powell", "Long", "Patterson", "Hughes", "Flores", "Washington", "Butler", "Simmons",
			"Foster", "Gonzales", "Bryant", "Alexander", "Russel", "Griffin", "Diaz", "Hayes"};
	
	private List<String[]> firstNames;
	
	private String[] masculineNames = {"James", "John", "Robert", "Michael", "William", "David", "Richard", "Charles",
			"Joseph", "Thomas", "Christopher", "Daniel", "Paul", "Mark", "Donald", "George", "Kenneth", "Steven", "Edward",
			"Brian", "Ronald", "Anthony", "Kevin", "Jason", "Jeff"};
	
	private String[] feminineNames = {"Mary", "Patricia", "Linda", "Barbara", "Elizabeth", "Jennifer", "Maria", "Susan",
			"Margaret", "Dorothy", "Lisa", "Nancy", "Karen", "Betty", "Helen", "Sandra", "Donna", "Carol", "Ruth", "Sharon",
			"Michelle", "Laura", "Sarah", "Kimberly", "Deborah"};

	public NameGenerator(){
		firstNames = new ArrayList<String[]>();
		this.firstNames.add(masculineNames);
		this.firstNames.add(feminineNames);
	}
	
	/**
	 * Returns Random last name
	 * @return
	 */
	public String getRandomLastName(){
		return lastNames[random(0, lastNames.length -1)];
	}
	
	/**
	 * 
	 * @return masculine feminine first name
	 */
	public String getRandomMasculineFirstName(){
		return masculineNames[random(0, masculineNames.length -1)];
	}
	
	/**
	 * 
	 * @return Random feminine first name
	 */
	public String getRandomFeminineFirstName(){
		return feminineNames[random(0, feminineNames.length -1)];
	}
	
	/**
	 * 
	 * @return Random First Name masculine or feminine
	 */
	public String getRandomFirstName(){
		if(random(0,1) == 0)
			return getRandomMasculineFirstName();
		else
			return getRandomFeminineFirstName();		
	}
	
	/**
	 * 
	 * @return Random masculine full name
	 */
	public String getRandomMasculineFullName(){
		return getRandomMasculineFirstName() + " " + getRandomLastName();
	}
	
	/**
	 * Random feminine full name
	 * @return
	 */
	public String getRandomFeminineFullName(){
		return getRandomFeminineFirstName() + " " + getRandomLastName();
	}
	
	/**
	 * Random full name
	 * @return
	 */
	public String getRandomFullName(){
		if(random(0,1) == 0)
			return getRandomMasculineFullName();
		else
			return getRandomFeminineFullName();
	}
	
	
	
	private static int random(int min, int max){
		return (min + (int)(Math.random()*max));
	}
}
