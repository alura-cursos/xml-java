import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import model.Produto;

public class XPathExemplo {
	
	

	public static void main(String[] args) throws Exception {
		
		List<Produto> produtos = new ArrayList<Produto>();
		
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.parse("src/venda.xml");
		
		XPath xPath = XPathFactory.newInstance().newXPath();
		
		// aqui vou mostrar diversas expressões durante o video.
		
		String expression = "/venda/produtos/produto[2]";
		
		NodeList list = (NodeList) xPath.compile(expression).evaluate(document, XPathConstants.NODESET);
		
		for(int i = 0; i < list.getLength();i++) {
			Element atual = (Element) list.item(i);
			
			String nome = atual.getElementsByTagName("nome").item(0).getTextContent();
			Double preco = Double.parseDouble(atual.getElementsByTagName("preco").item(0).getTextContent());
			
			Produto prod = new Produto();
			prod.setNome(nome);
			prod.setPreco(preco);
			
			produtos.add(prod);
		}
		
		
		System.out.println(produtos);
		
		
	}
}
