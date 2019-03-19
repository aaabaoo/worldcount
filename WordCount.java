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
 * ʵ�ִ��ļ��ж���Ӣ�����£�ͳ�Ƶ��ʸ���,����ֵ�Ӵ�С��� 
 */  

public class WordCount {

  
    public static void main(String[] args) throws Exception {  
          
        BufferedReader br = new BufferedReader(new FileReader("data.txt"));  
        List<String> lists = new ArrayList<String>();  //�洢���˺󵥴ʵ��б�  
        String readLine = null;
		while((readLine = br.readLine()) != null){  
            String[] wordsArr1 = readLine.split("[^a-zA-Z]");  //���˳�ֻ������ĸ��  
            for (String word : wordsArr1) {  
                if(word.length() != 0){  //ȥ������Ϊ0����  
                    lists.add(word);  
                }  
            }  
        }  
          
        br.close();  
     
        Map<String, Integer> wordsCount = new TreeMap<String,Integer>();  //�洢���ʼ�����Ϣ��keyֵΪ���ʣ�valueΪ������       
        //���ʵĴ�Ƶͳ��  
        for (String li : lists) {  
            if(wordsCount.get(li) != null){  
                wordsCount.put(li,wordsCount.get(li) + 1);  
            }else{  
                wordsCount.put(li,1);  
            }  
  
        }  
          
        SortMap(wordsCount);    //��ֵ��������  
      
    }  
     
    
    
    
    //��value�Ĵ�С��������  
    public static void SortMap(Map<String,Integer> oldmap){  
          
        ArrayList<Map.Entry<String,Integer>> list = new ArrayList<Map.Entry<String,Integer>>(oldmap.entrySet());  
          
        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){  
            @Override  
            public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {  
                return o2.getValue() - o1.getValue();  //����  
            }  
        });  
        System.out.println("��������Ϊ��"+list.size()+"��");  
        System.out.println("ÿ�����ʳ��ִ������£�");  
        for(int i = 0; i<list.size(); i++){  
        	
            System.out.println(list.get(i).getKey()+ ": " +list.get(i).getValue());  
            
            
            //����Ƶͳ�ƽ�������ָ���ļ�results.txt��    
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
    		System.out.println("��Ƶͳ�ƽ���������result.txt�ļ���");
    	}
    	catch(IOException e) {
    		e.printStackTrace();
    	}
    
        Scanner find = new Scanner(System.in); 
        System.out.println("��������Ҫ��ѯ�ĵ���:"); 
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
			System.out.println("����ѯ�ĵ���"+word+"���ֵĴ���Ϊ:"+value);	
		}else{
			System.out.println("�Բ���û�в�ѯ���õ��ʣ�");
		}
		
    }

}   
    
    
