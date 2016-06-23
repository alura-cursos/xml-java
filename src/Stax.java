import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.XMLEvent;

import model.Produto;

public class Stax {
	public static void main(String[] args) throws Exception {
		
		List<Produto> produtos = new ArrayList<Produto>();
		InputStream is = new FileInputStream("src/venda.xml");
		
		XMLEventReader iterador = XMLInputFactory.newInstance().createXMLEventReader(is);
		
		while(iterador.hasNext()){
			XMLEvent event = iterador.nextEvent();
			
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("produto")) {
				Produto prod = ProcessaProduto(iterador);
				produtos.add(prod);
			}
		}
		
		System.out.println(produtos);
		
		
		
	}

	private static Produto ProcessaProduto(XMLEventReader iterador) throws Exception {
		Produto prod = new Produto();
		
		while(iterador.hasNext()) {
			XMLEvent event = iterador.nextEvent();
			if(event.isEndElement() && event.asEndElement().getName().getLocalPart().equals("produto")) {
				break;
			}
			
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("nome")) {
				event = iterador.nextEvent();
				String nome = event.asCharacters().getData();
				prod.setNome(nome);
			}
			
			if(event.isStartElement() && event.asStartElement().getName().getLocalPart().equals("preco")) {
				event = iterador.nextEvent();
				Double preco = Double.parseDouble(event.asCharacters().getData());
				prod.setPreco(preco);
			}
			
		}
		
		return prod;
	}
}
