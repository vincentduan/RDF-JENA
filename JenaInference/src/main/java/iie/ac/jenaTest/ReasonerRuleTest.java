package iie.ac.jenaTest;

import org.apache.jena.rdf.model.InfModel;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.reasoner.Reasoner;
import org.apache.jena.reasoner.rulesys.GenericRuleReasonerFactory;
import org.apache.jena.util.FileManager;
import org.apache.jena.util.PrintUtil;
import org.apache.jena.vocabulary.ReasonerVocabulary;

public class ReasonerRuleTest {
	public static void main(String[] args) {
		// Register a namespace for use in the demo
		String demoURI = "http://jena.hpl.hp.com/demo#";
		PrintUtil.registerPrefix("demo", demoURI);

		// Create an (RDF) specification of a hybrid reasoner which
		// loads its data from an external file.
		Model m = ModelFactory.createDefaultModel();
		Resource configuration =  m.createResource();
		configuration.addProperty(ReasonerVocabulary.PROPruleMode, "hybrid");
		configuration.addProperty(ReasonerVocabulary.PROPruleSet,  "data/demo.rules");


		// Create an instance of such a reasoner
		Reasoner reasoner = GenericRuleReasonerFactory.theInstance().create(configuration);


		// Load test data
		Model data = FileManager.get().loadModel("file:data/demoData.ttl");
		InfModel infmodel = ModelFactory.createInfModel(reasoner, data);


		// Query for all things related to "a" by "p"
		Property p = data.getProperty(demoURI, "p");
		Resource a = data.getResource(demoURI + "a");
		StmtIterator i = infmodel.listStatements(a , p, (RDFNode)null);
		while (i.hasNext()) {
		    System.out.println(PrintUtil.print(i.nextStatement()));
			//Statement s = i.nextStatement();
			//System.out.println("<"+s.getSubject()+"> <" + s.getPredicate() + "> <" + s.getObject() + "> .");
		}
	}
}
