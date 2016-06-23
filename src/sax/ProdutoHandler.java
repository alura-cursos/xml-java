package sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import model.Produto;

public class ProdutoHandler extends DefaultHandler {
	
	private List<Produto> produtos = new ArrayList<Produto>();
	private Produto produto;
	private StringBuilder conteudo = new StringBuilder();
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		
		if("produto".equals(qName)) {
			produto = new Produto();
		}
		
		conteudo = new StringBuilder();
		
	}
	
	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		// TODO Auto-generated method stub
		conteudo.append(new String(ch,start,length));
	}
	
	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		
		if("produto".equals(qName)) {
			produtos.add(produto);
		}else if("nome".equals(qName)) {
			produto.setNome(conteudo.toString());
		}else if("preco".equals(qName)) {
			produto.setPreco(Double.parseDouble(conteudo.toString()));
		}
		
	}
	
	public List<Produto> getProdutos() {
		return produtos;
	}

}
