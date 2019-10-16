package work10;

import java.beans.XMLDecoder;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import javax.swing.text.Document;
import javax.xml.stream.FactoryConfigurationError;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;

import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;

import de.odysseus.staxon.json.JsonXMLConfig;
import de.odysseus.staxon.json.JsonXMLConfigBuilder;
import de.odysseus.staxon.json.JsonXMLInputFactory;
import de.odysseus.staxon.xml.util.PrettyXMLEventWriter;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;  
import net.sf.json.xml.XMLSerializer;  




public class test {
	 
	public static StringBuilder builder = new StringBuilder("");
	
	public static String json2xml(String json) throws XMLStreamException, FactoryConfigurationError, IOException {
		StringReader input = new StringReader(json);
		StringWriter output = new StringWriter();
		JsonXMLConfig config = new JsonXMLConfigBuilder().multiplePI(false).repairingNamespaces(false).build();
		
		XMLEventReader reader = new JsonXMLInputFactory(config).createXMLEventReader(input);
		XMLEventWriter writer = XMLOutputFactory.newInstance().createXMLEventWriter(output);
		writer = new PrettyXMLEventWriter(writer);
		writer.add(reader);
		reader.close();
		writer.close();
		
		output.close();
		input.close();
		if (output.toString().length() >= 38) {// remove <?xml version="1.0" encoding="UTF-8"?>
		System.out.println(output.toString().substring(39));
		builder.append(output.toString().substring(39));
		return output.toString().substring(39);
		}
		return output.toString();
	}
		
	public static void main(String[] args) throws IOException, XMLStreamException, FactoryConfigurationError{
		// TODO Auto-generated method stub
				
		  //String realUrl="http://wthrcdn.etouch.cn/WeatherApi?city="; 
		  //String realUrl="http://wthrcdn.etouch.cn/weather_mini?city="; 
		  Scanner input=new Scanner(System.in);
		  String param=""; 
		  System.out.println("请输入要搜素的城市：");
		  param=input.nextLine();
		  String realUrl="https://www.tianqiapi.com/api/?version=v1&city="+param+"&appid=18657272&appsecret=ReI2RuN9";
		  realUrl=realUrl+param; 
		  URL url = new URL(realUrl); 
		  String document = null ;
		  URLConnection conn = url.openConnection();//URL请求
		 
		  BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));//获取数据流
		  
		  String line= null; 
		  while ((line = reader.readLine()) != null){ 
			  line =String.valueOf(JSON.parse(line));
			  document+=line; 
		  }
		  reader.close();
		  
		  //json转xml
		  document = document.replace("null", "");
		  json2xml(document);
		 
		  File wn=new File("D:\\java\\work10\\src\\work10\\weather.xml");
		  wn.createNewFile();
		  builder=builder.insert(0, "\n<root>\n");
		  builder=builder.append("\n</root>\n");
		  BufferedWriter out=new BufferedWriter(new FileWriter(wn));
		  out.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?xml-stylesheet type=\"text/xsl\" href=\"weather.xsl\"?>\n"+builder.toString());
		  out.flush();
		  out.close(); 
	}
}
