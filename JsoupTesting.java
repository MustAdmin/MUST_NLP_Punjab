import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.Scanner;
public class JsoupTesting {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
    	 String query;
      Scanner in = new Scanner(System.in);
 		String[] mylink=new String[20];
      System.out.println("Enter query");
      query= in.nextLine();

        Document doc =        Jsoup.connect("https://www.google.com/search?q="+query).userAgent("Mozilla").ignoreHttpErrors(true).timeout(0).get();

       Elements titles = doc.select("h3.r > a");
       int i=0;
for(Element e: titles){
	
	
	String et;
	et=e.attr("href");
	
	et=et.replace("/url?q=","");
	et = et.split("&sa=U&ved=")[0];
	
    System.out.println("link: " +et);
    mylink[i]=et;
    i++;
  } 
  
  for(int j=0;j<5;j++)
  {
	String url="";
	url=mylink[j];
	System.out.println(mylink[j]);
  Document docscrap = Jsoup.connect(url).get();

        String result = docscrap.text();

        System.out.println(result);
    }
    
    }

}