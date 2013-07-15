package es.upm.dit.gsi.episteme;


public class SkillsRDFGenerator {
	
	private static String endpointResource = "http://localhost:8080/LMF-3.0.0/resource/";

	public static String generateSkill(String skillName){

		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF\n    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n    xmlns:skos=\"http://www.w3.org/2004/02/skos/core#\">\n    \t\n\t" +
				"<skos:Concept rdf:about=\""+endpointResource+"skills/"+skillName.replaceAll("\\s","")+"\">\n\t\t " +
				"<skos:prefLabel>"+skillName+"</skos:prefLabel>\n\t\t" +
				"<skos:broader rdf:about=\"http://www.gsi.dit.upm.es/skills/OOP\"/>\n\t" +
				"</skos:Concept>\n</rdf:RDF>\n";

		return rdf;
	}
	
	public static String generateLevel(String level){

		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF\n    xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\"\n    xmlns:rdfs=\"http://www.w3.org/2000/01/rdf-schema#\"\n    xmlns:skos=\"http://www.w3.org/2004/02/skos/core#\">\n    \t\n\t" +
				"<skos:Concept rdf:about=\""+level.replaceAll("\\s","")+"\">\n\t\t " +
				"<skos:prefLabel>"+level+"</skos:prefLabel>\n\t\t" +
				"</skos:Concept>\n</rdf:RDF>\n";

		return rdf;
	}
	
	

}
