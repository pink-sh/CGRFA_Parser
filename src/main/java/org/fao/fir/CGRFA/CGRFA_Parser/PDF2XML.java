package org.fao.fir.CGRFA.CGRFA_Parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

public class PDF2XML {
	private static String INPUT = "/home/enrico/Desktop/Adobe/CGRFA_dynamic_300312_FILLED.pdf";
	public static void main(String[] args) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(INPUT);
			PDDocument document = PDDocument.load(fileInputStream);
	        fileInputStream.close();
	        document.setAllSecurityToBeRemoved(true);

	        PDAcroForm form = document.getDocumentCatalog().getAcroForm();
	        Document documentXML = form.getXFA().getDocument();
	        
	        documentXML.getDocumentElement().normalize();

	        
	        Transformer transformer = TransformerFactory.newInstance().newTransformer();
	        Result output = new StreamResult(new File("/home/enrico/Desktop/Adobe/CGRFA_dynamic_300312_FILLED.xml"));
	        Source input = new DOMSource(documentXML);

	        transformer.transform(input, output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
