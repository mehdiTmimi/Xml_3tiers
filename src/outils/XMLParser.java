package outils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * generic class to store and read XML files <=> objcts
 *
 *
 *
 * @author  GL - 2021
 * 
 * 
 * @since 1.1
 */
public class XMLParser {

	// lecture
	/**
	 * 
	 * @param chemin : path of ur xml file
	 * @param c : class type of your object
	 * 
	 * @return a list of objects created by the data within the xml file
	 */
	public static <T> List<T> lire(String chemin,Class<T> c)
	{
		List<T> objects=new ArrayList<T>();
		try {
			Document document =
					DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(chemin));
			String nomClasse=c.getSimpleName().toLowerCase();
			NodeList elements= document.getDocumentElement().getElementsByTagName(nomClasse);
			for (int i = 0; i < elements.getLength(); i++) {
				Element element=(Element) elements.item(i);
				T object=c.getDeclaredConstructor().newInstance();
				NodeList fils =element.getChildNodes();
				for (int j = 0; j < fils.getLength(); j++) {
					if(fils.item(j).getNodeType()==Node.ELEMENT_NODE)
					{
						Element elementFils=(Element) fils.item(j);
						Field field=null;
						try {
							field=c.getDeclaredField(elementFils.getNodeName());
						}
						catch (Exception e) {
							//e.printStackTrace();
						}
						if(field!=null)
						{
							Class t=field.getType();
							if(MAP.containsKey(t))
							t=MAP.get(t);
							field.setAccessible(true);
							field.set(object,t.getDeclaredConstructor(String.class).newInstance(elementFils.getTextContent()));
							field.setAccessible(false);
						}
					}
				}
				objects.add(object);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return objects;
	}
	//ecriture
	public static <T> boolean ecrire(String chemin,List<T> os)
	{
		try {
			if(os.size()==0)
				return false;
			Class c=os.get(0).getClass();
			Field[] fileds=c.getDeclaredFields();
			Document document=DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
		
			Element racine=document.createElement(c.getSimpleName().toLowerCase()+"s");
			document.appendChild(racine);
			for(T o:os)
			{
				Element element=document.createElement(c.getSimpleName().toLowerCase());
				racine.appendChild(element);
				for(int i=0;i<fileds.length;i++)
				{
					Field field=fileds[i];
					Element ele1=document.createElement(field.getName());
					element.appendChild(ele1);
					field.setAccessible(true);
					ele1.setTextContent(field.get(o).toString());
					field.setAccessible(false);
				}
			}
			TransformerFactory transformerFactory=TransformerFactory.newInstance();
			transformerFactory.setAttribute("indent-number", 3);
			Transformer transformer=transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource=new DOMSource(document);
			StreamResult streamResult=new StreamResult(new File(chemin));
			transformer.transform(domSource, streamResult);
			
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	private static final Map<Class<?>, Class<?>> MAP = new HashMap() {{
	    put( int.class,Integer.class);
	    put(long.class,Long.class);
	    put( float.class,Float.class);
	    // etc
	}};
}
