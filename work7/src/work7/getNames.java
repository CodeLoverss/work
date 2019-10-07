package work7;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.*;

public class getNames {
	private static String savefile = "D:\\test.txt";
	public static String getmessage(String url)  {
			URL url1;
			StringBuilder mes = new StringBuilder();
			try {
				url1 = new URL(url);
				InputStream is = url1.openStream();
				//以UTF-8的形式获取内容
				BufferedReader br = new BufferedReader(new InputStreamReader(is,"UTF-8"));
				String msg = null;
				while(null!=(msg = br.readLine())) {
					mes.append(msg);					
				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		     //返回网页源码
			return mes.toString();
			}
	
	public static void main(String[] args) throws Exception {
			String message = getmessage("https://www.w3.org/Consortium/Member/List");
			//正则表达式
			Pattern p = Pattern.compile("class=\"member\">(\\D.+?)</a>");
			Matcher m = p.matcher(message);
			FileWriter fwriter = null ;
			fwriter = new FileWriter(savefile);
			while(m.find()) {
				 // 若匹配到则写入文件中。
			     fwriter.write(m.group(1));
			     fwriter.append("\r\n");
			}
			//推送文件流。
			fwriter.flush();
			//关闭文件流。
			fwriter.close();
			System.out.println("finished");
		}
}