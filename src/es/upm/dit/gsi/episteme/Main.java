package es.upm.dit.gsi.episteme;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Generator g = new Generator();
		List<Person> people = g.generateRandom(100);
		
		RdfGenerator rdfGen = new RdfGenerator(people);
		for(Person p : people){
			writeRdf(p.getUid(), rdfGen.generatePerson(p));
		}
		System.out.println("End");
		
	}
	
	private static void writeRdf(String name, String content){
		 try {
			 	String filename = "output/"+name+".rdf";
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

}
