package tafforeau.javabnb.outils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import tafforeau.javabnb.logements.Appartement;
import tafforeau.javabnb.logements.Logement;
import tafforeau.javabnb.logements.Maison;
import tafforeau.javabnb.utilisateurs.Hote;

public final class LogementsDomParser {
	
	private LogementsDomParser() {
		throw new UnsupportedOperationException();
	}

	public static void parse(String path, ArrayList<Hote> listHotes, ArrayList<Logement> listLogements)
			throws SAXException, IOException, ParserConfigurationException {

		if (listHotes == null || listLogements == null) {
			throw new IllegalArgumentException("listHotes == null || listLogements == null");
		}

		File file = new File(path);

		DocumentBuilderFactory factory = DocumentBuilderFactory.newDefaultInstance();
		Document document = factory.newDocumentBuilder().parse(file);

		Node node = document.getChildNodes().item(0); // Logements

		for (int i = 0; i < node.getChildNodes().getLength(); i++) {

			Node nodeItem = node.getChildNodes().item(i);

			if (nodeItem.getNodeType() == Node.ELEMENT_NODE) {

				Element element = (Element) nodeItem; // Appartement / Maison

				Element nodeHote = (Element) element.getElementsByTagName("hote").item(0); // hote
				String prenom = nodeHote.getElementsByTagName("prenom").item(0).getTextContent();
				String nom = nodeHote.getElementsByTagName("nom").item(0).getTextContent();
				int age = Integer.parseInt(nodeHote.getElementsByTagName("age").item(0).getTextContent());
				int delaiReponse = Integer.parseInt(nodeHote.getElementsByTagName("delaiReponse").item(0).getTextContent());

				Hote hote = new Hote(prenom, nom, age, delaiReponse);

				int index = listHotes.indexOf(hote);
				if (index != -1) {
				    hote = listHotes.get(index);
				} else {
				    listHotes.add(hote);
				}

				int tarifParNuit = Integer.parseInt(element.getElementsByTagName("tarifParNuit").item(0).getTextContent());
				String adresse = element.getElementsByTagName("adresse").item(0).getTextContent();
				int superficie = Integer.parseInt(element.getElementsByTagName("superficie").item(0).getTextContent());
				int nbVoyageursMax = Integer.parseInt(element.getElementsByTagName("nbVoyageursMax").item(0).getTextContent());

				if (element.getNodeName().equals("Appartement")) {
					int numeroEtage = Integer.parseInt(element.getElementsByTagName("numeroEtage").item(0).getTextContent());
					int superficieBalcon = Integer.parseInt(element.getElementsByTagName("superficieBalcon").item(0).getTextContent());
					
					Appartement appartement = new Appartement(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, numeroEtage, superficieBalcon);
					listLogements.add(appartement);
				}

				if (element.getNodeName().equals("Maison")) {
					int superficieJardin = Integer.parseInt(element.getElementsByTagName("superficieJardin").item(0).getTextContent());
					int possedePiscine = Integer.parseInt(element.getElementsByTagName("possedePiscine").item(0).getTextContent());
					
					Maison maison = new Maison(hote, tarifParNuit, adresse, superficie, nbVoyageursMax, superficieJardin, possedePiscine == 0 ? false : true);
					listLogements.add(maison);
				}
			}
		}
	}
}
