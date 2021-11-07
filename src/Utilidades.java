import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class Utilidades {
	
	
	public static void generarXML(ArrayList<Mamiferos> listMam, ArrayList<Paxaros> listPax, ArrayList<Reptiles> listRep) {
		
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = factory.newDocumentBuilder();
			Document documento = db.newDocument();
			
			Element zoo = documento.createElement("Zoo");
			documento.appendChild(zoo);
			
			Element animales = documento.createElement("Animales");
			zoo.appendChild(animales);
			
			for (int i = 0; i < listMam.size(); i++) {
			
			Element animal = documento.createElement("Animal");
			animales.appendChild(animal);
			
			Element nombre = documento.createElement("Nombre");
			nombre.setTextContent(listMam.get(i).getNombre());
			animal.appendChild(nombre);
			
			Element patas = documento.createElement("Patas");
			patas.setTextContent(String.valueOf(listMam.get(i).getPatas()));
			animal.appendChild(patas);
			
			Element tamanho = documento.createElement("Tamaño");
			tamanho.setTextContent(listMam.get(i).getTamanho());
			animal.appendChild(tamanho);
			
			}
			
			for (int i = 0; i < listPax.size(); i++) {
				
				Element animal = documento.createElement("Animal");
				animales.appendChild(animal);
				
				Element nombre = documento.createElement("Nombre");
				nombre.setTextContent(listPax.get(i).getNombre());
				animal.appendChild(nombre);
				
				Element patas = documento.createElement("Patas");
				patas.setTextContent(String.valueOf(listPax.get(i).getPatas()));
				animal.appendChild(patas);
				
				Element tamanho = documento.createElement("Tamaño");
				tamanho.setTextContent(listPax.get(i).getTamanho());
				animal.appendChild(tamanho);
				
				}
			
			for (int i = 0; i < listRep.size(); i++) {
				
				Element animal = documento.createElement("Animal");
				animales.appendChild(animal);
				
				Element nombre = documento.createElement("Nombre");
				nombre.setTextContent(listRep.get(i).getNombre());
				animal.appendChild(nombre);
				
				Element patas = documento.createElement("Patas");
				patas.setTextContent(String.valueOf(listRep.get(i).getPatas()));
				animal.appendChild(patas);
				
				Element tamanho = documento.createElement("Tamaño");
				tamanho.setTextContent(listRep.get(i).getTamanho());
				animal.appendChild(tamanho);
				
				}
			
			
			TransformerFactory tFactory = TransformerFactory.newInstance();
			Transformer tf = tFactory.newTransformer();
			DOMSource dom = new DOMSource(documento);
			StreamResult sr = new StreamResult("C:\\PRUEBAEXAMEN\\animales.xml");
			tf.transform(dom, sr);			
			
			
			
		} catch (ParserConfigurationException | TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
