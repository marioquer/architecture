package service.CrawlerServiceImpl;


import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import org.w3c.dom.Node;
import org.w3c.dom.NodeList;



public class XMLScheduleParser {
	public static final String filepath="src/main/resources/time.xml";
	
	public String parseScheduler(){
		DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder db = factory.newDocumentBuilder();
			Document doc = db.parse(filepath);  
			
			
			NodeList timeList = doc.getElementsByTagName("TimeGap"); 
			
			Node time=(Node) timeList.item(0);
			
			
			
			
			
			String timegap=time.getFirstChild().getNodeValue();
			
			
			return timegap;
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		return "";
	}
	
}
