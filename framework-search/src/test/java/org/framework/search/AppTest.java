package org.framework.search;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.github.framework.starter.logging.CommonLogger;

import org.framework.search.ES.ElasticSearchClient;
import org.framework.search.status.CommonStatus;
/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    public void testAttachmentCreated()
    {
        CommonLogger.consolePrint("run in test attachment");
        ElasticSearchClient client = new ElasticSearchClient("47.105.127.77",9200);
        String mapping = "{\"AttachmentContent\":{\"properties\":{\"filename\":{\"type\":\"text\",\"store\":\"true\",\"term_vector\":\"with_positions_offsets\",\"analyzer\":\"ik_max_word\",\"search_analyzer\":\"ik_max_word\",\"boost\":8},\"content\":{\"type\":\"attachment\",\"store\":\"true\",\"term_vector\":\"with_positions_offsets\",\"analyzer\":\"ik_max_word\",\"search_analyzer\":\"ik_max_word\",\"boost\":8}}}}";
        CommonStatus status = client.CreateIndex("attachment_content",mapping,"AttachmentContent");
        CommonLogger.consolePrint(status.getMessage());
    }

    public void testIndexAttachment()
    {

    }
    
    public void buildTestIndex()
    {
        CommonLogger.consolePrint("Create elastic search client test ----------->");
        ElasticSearchClient client = new ElasticSearchClient("47.105.127.77",9200);
        String mapping = "{\r\n    \"bookContents\": {\r\n              \"properties\": {\r\n            \"content\": {\r\n                \"type\": \"text\",\r\n                \"store\": \"true\",\r\n                \"term_vector\": \"with_positions_offsets\",\r\n                \"analyzer\": \"ik_max_word\",\r\n                \"search_analyzer\": \"ik_max_word\",\r\n                        \"boost\": 8\r\n            }\r\n        }\r\n    }\r\n}";
        CommonStatus status = client.CreateIndex("books_cn",mapping,"bookContents");
        CommonLogger.consolePrint(status.getMessage());


        Map<String, Object> jsonMap = new HashMap<String, Object>();
       

        try {
            File file = new File("c:/tmp/all.txt");
            if(file.isFile() && file.exists()) {
              InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
              BufferedReader br = new BufferedReader(isr);
              String lineTxt = null;
              while ((lineTxt = br.readLine()) != null) {
                jsonMap.put("user", "kimmy");
                jsonMap.put("postDate", new Date());
                jsonMap.put("bookContents", lineTxt);
                jsonMap.put("bookName","浪子回头");
                client.CreateDocument("books_cn","bookContents",jsonMap);
                jsonMap.clear();
              }
              br.close();
            } else {
              System.out.println("文件不存在!");
            }
          } catch (Exception e) {
            System.out.println("文件读取错误!");
          }
        
    }
}
