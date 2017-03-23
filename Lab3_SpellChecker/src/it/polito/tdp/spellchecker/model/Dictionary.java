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
	
	RichWord r;
	List <RichWord> paroleRich=new ArrayList<RichWord>();
	for(String input:inputTextList)
	{
		if(listaParoleDizionario.contains(input))
			r=new RichWord(input,true);
		else
			r=new RichWord(input,false);
		  
		paroleRich.add(r);
	}
	
	return paroleRich;
}



}
