package WordCount;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;  
import java.util.Collections;  
import java.util.Comparator;  
import java.util.List;  
import java.util.Map;  
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;  
  
/** 
 *  
 * @author cute 
 * 
 * 
 * 实现从文件中读入英文文章，统计单词个数,并按值从大到小输出 
 */  

public class WordCount {

  
    public static void main(String[] args) throws Exception {  
          
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));  
        List<String> lists = new ArrayList<String>();  //存储过滤后单词的列表  
        String readLine = null;
		while((readLine = br.readLine()) != null){  
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");  //过滤出只含有字母的  
            for (String word : wordsArr1) {  
                if(word.length() != 0){  //去除长度为0的行  
                    lists.add(word);  
                }  
            }  
        }  
          
        br.close();  
     
        Map<String, Integer> wordsCount = new TreeMap<String,Integer>();  //存储单词计数信息，key值为单词，value为单词数       
        //单词的词频统计  
        for (String li : lists) {  
            if(wordsCount.get(li) != null){  
                wordsCount.put(li,wordsCount.get(li) + 1);  
            }else{  
                wordsCount.put(li,1);  
            }  
  
        }  
          
        SortMap(wordsCount);    //按值进行排序  
      
    }  
     
    
    
    
    //按value的大小进行排序  
    public static void SortMap(Map<String,Integer> oldmap){  
          
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());  
          
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue() - o1.getValue();  //降序  
            }  
        });  
        System.out.println("单词总数为："+list.size()+"个");  
        System.out.println("每个单词出现次数如下：");  
        for(int i = 0; i<list.size(); i++){  
        	
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());  
            
            
            //将词频统计结果输出到指定文件results.txt中    
        }  
       
        try{
    	FileWriter fr=new FileWriter("results.txt");
    	BufferedWriter txt=new BufferedWriter(fr);
    	for (Map.Entry<String,Integer> entry: list) {
    		txt.write(entry.getKey()+":"+entry.getValue());
    		txt.newLine();
    	}
    		txt.flush();
    		txt.close();
    		System.out.println("词频统计结果已输出到result.txt文件！");
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    
        Scanner find = new Scanner(System.in); 
        System.out.println("请输入需要查询的单词:"); 
        String f = find.next();
	    String word="";
	    int index=1;
	    int value=0;
		
		for (Map.Entry<String, Integer> entry : list) {
		
			if(entry.getKey().equals(f)){//
				word=entry.getKey();
				value=entry.getValue();
				index=1;
				break;
			}else{
				index=0;
			}
			
		}
		if(index==1){
			System.out.println("所查询的单词"+word+"出现的次数为:"+value);	
		}else{
			System.out.println("对不起没有查询到该单词！");
		}
		
    }

}   
    
    
