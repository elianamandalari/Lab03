package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictionary {

List<String> listaParoleDizionario=new ArrayList<String>();	

public void loadDictionary(String language){
	listaParoleDizionario.clear();
		try{
			FileReader fr=new FileReader("rsc/"+language+".txt");
			BufferedReader br=new BufferedReader(fr);
			String word;
			while((word=br.readLine())!=null){
				listaParoleDizionario.add(word);
			}
			br.close();
		}catch(IOException e){
			System.out.println("Errore nella lettura del file");
		}
	
	
	}




public List<RichWord> spellCheckText(List<String> inputTextList){
	
	List<RichWord> paroleRich=new ArrayList<RichWord>();
	Collections.sort(listaParoleDizionario);

    for(int i=0;i<inputTextList.size() ;i++){
    	
    	int start = 0;
        int end = listaParoleDizionario.size();
        RichWord r;
        boolean trovato=false;
        
    while(start <= end && trovato==false) {
    	 
    	  int meta = (start + end) / 2;
    	  
    	  if(inputTextList.get(i).compareTo(listaParoleDizionario.get(meta))==0)
          	trovato=true;
    	  
          if(inputTextList.get(i).compareTo(listaParoleDizionario.get(meta))>0)
            start = meta + 1;
       
          
          if(inputTextList.get(i).compareTo(listaParoleDizionario.get(meta))<0)
            end = meta - 1;
    }
    
    if(trovato==true)
      r=new RichWord(inputTextList.get(i),true);
    else
      r=new RichWord(inputTextList.get(i),false);
    
      paroleRich.add(r);
    
    }
  return paroleRich;

}
}
