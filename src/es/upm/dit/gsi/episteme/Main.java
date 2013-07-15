package es.upm.dit.gsi.episteme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	private static boolean genPeople = true;
	private static boolean genSkills = true;
	private static boolean genLevels = true;
	
	private static String dirOutput = "output";	
	private static String dirPeople = "people";
	private static String dirSkills = "skills";
	private static String dirLevels = "levels";

	public static void main(String[] args) {
		if(genPeople){
			deleteDir(dirPeople);
			Generator g = new Generator();
			List<Person> people = g.generateRandom(100);

			RdfFoafGenerator rdfGen = new RdfFoafGenerator(people);
			for(Person p : people){
				writeRdf("people", p.getUid(), rdfGen.generatePerson(p));
			}
		}

		if(genSkills){
			deleteDir(dirSkills);
			for(String s : Skill.skills){
				writeRdf("skills", s.replaceAll("\\s",""), SkillsRDFGenerator.generateSkill(s));
			}
		}
		
		if(genLevels){
			deleteDir(dirLevels);
			for(String l : Skill.levels){
				writeRdf("levels", l.replaceAll("\\s",""), SkillsRDFGenerator.generateLevel(l));
			}
		}
		System.out.println("End");

	}

	private static void writeRdf(String dir, String name, String content){	
		
		
		try {
			String filename = dirOutput+"/"+dir+"/"+name+".rdf";
			File newTextFile = new File(filename);
			newTextFile.createNewFile();
			FileWriter fw = new FileWriter(newTextFile);
			fw.write(content);
			fw.close();
			System.out.println("Generated "+filename);

		} catch (IOException iox) {
			iox.printStackTrace();
		}
	}
	
	private static void deleteDir(String dir){
		File directory = new File(dirOutput+"/"+dir);
		for(File file: directory.listFiles()) file.delete();
	}
	
	

}
