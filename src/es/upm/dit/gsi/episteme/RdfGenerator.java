package es.upm.dit.gsi.episteme;

import java.util.List;

public class RdfGenerator {

	private List<Person> people;
	private String endpointResource = "http://localhost:8080/LMF-3.0.0/resource/";
	
	public RdfGenerator(List<Person> people){
		this.people = people;
	}
	
	public String generatePerson(Person p){
		String rdf = "<?xml version=\"1.0\" encoding=\"utf-8\" standalone=\"no\"?>\n<rdf:RDF xmlns:rdf=\"http://www.w3.org/1999/02/22-rdf-syntax-ns#\" xmlns:ecos=\"http://kmm.lboro.ac.uk/ecos/1.0#\" xmlns:v=\"http://www.w3.org/2006/vcard/ns#\">\n  " +
				"<ecos:Enterprise rdf:about=\""+this.endpointResource+""+p.getUid()+"\">\n    <ecos:General>\n      <rdf:Description>\n        <ecos:Address>\n          <rdf:Description>\n            <v:VCard>\n              <rdf:Description>\n                <v:adr>\n                  <rdf:Description>\n                    " +
				"<v:locality>"+p.getLocality()+"</v:locality>\n                    <v:postal-code>"+p.getZip()+"</v:postal-code>\n                    " +
				"<v:street-address>"+p.getAddress()+"</v:street-address>\n                  </rdf:Description>\n                </v:adr>\n              </rdf:Description>\n            </v:VCard>\n          </rdf:Description>\n        </ecos:Address>\n        <ecos:CompanyName>\n          <rdf:Description>\n            " +
				"<ecos:name>"+p.getName()+"</ecos:name>\n            <ecos:uri>http://www.gsi.dit.upm.es/~"+p.getUid()+"</ecos:uri>\n          </rdf:Description>\n        </ecos:CompanyName>\n        <ecos:summary>"+p.getSummary()+"</ecos:summary>\n      </rdf:Description>\n    </ecos:General>\n    <ecos:Specific>\n      <rdf:Description>\n        <ecos:Plan>\n          <rdf:Description>\n            <ecos:detail>"+p.getDescription()+"</ecos:detail>\n            \n          </rdf:Description>\n        </ecos:Plan>\n        <ecos:Skill>\n          <rdf:Description>\n            <rdf:Bag>\n              <rdf:Description>                \n              ";
				
				for(Skill skill : p.getSkills()){
					rdf += "                <rdf:li>\n                  <rdf:Description>\n                    " +
							"<ecos:name>"+skill.getName()+"</ecos:name>\n                   " +
							" <ecos:level>"+skill.getLevel()+"</ecos:level>\n                  </rdf:Description>\n                </rdf:li>\n";

				}
				
				rdf += "                        \n                </rdf:Description>\n            </rdf:Bag>\n          </rdf:Description>\n        </ecos:Skill>\n      </rdf:Description>\n    </ecos:Specific>\n    <v:VCard>\n      <rdf:Description>\n        <v:adr>\n          <rdf:Description>\n            " +
						"<v:locality>"+p.getLocality()+"</v:locality>\n" +
						"<v:postal-code>"+p.getZip()+"</v:postal-code>\n            " +
						"<v:street-address>"+p.getAddress()+"</v:street-address>\n          </rdf:Description>\n        </v:adr>\n        " +
						"<v:fn>"+p.getName()+"</v:fn>\n        <v:logo>"+p.getPhotoUrl()+"</v:logo>\n        <v:org>\n          <rdf:Description>\n            " +
						"<v:organisation-name>"+p.getName()+"</v:organisation-name>\n            " +
						"<v:organisation-unit>"+p.getPosition()+"</v:organisation-unit>\n          </rdf:Description>\n        </v:org>\n      </rdf:Description>\n    </v:VCard>\n  <ecos:provenance>\n      <rdf:Description>\n        " +
						"<ecos:name>gsi</ecos:name>\n      </rdf:Description>\n    </ecos:provenance>\n    <ecos:ranking>\n      <rdf:Description>\n        " +
						"<ecos:value>"+p.getRanking()+"</ecos:value>\n      </rdf:Description>\n    </ecos:ranking>\n  </ecos:Enterprise>\n</rdf:RDF>\n";
		return rdf;
	}
	
	public void generateAll(){
		for(Person p : people){
			String rdf = this.generatePerson(p);
			System.out.println(rdf);
		}
	}
	

}
