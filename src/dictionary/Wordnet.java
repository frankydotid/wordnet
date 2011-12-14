package dictionary;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Vector;


public class Wordnet {
	private Hashtable<String, Vector<Lemma>> lemmas;
	private Hashtable<Integer, Synset> synsets;
	
	
	public Wordnet() throws IOException {
		lemmas = new Hashtable<String, Vector<Lemma>>();
		synsets = new Hashtable<Integer, Synset>();
		
		System.out.println("loading dictionary...");
		
		this.readIndex("dict/index.adv");
		this.readIndex("dict/index.adj");
		this.readIndex("dict/index.noun");
		this.readIndex("dict/index.verb");
		
		this.readSynset("dict/data.adv");
		this.readSynset("dict/data.adj");
		this.readSynset("dict/data.noun");
		this.readSynset("dict/data.verb");
		
		System.out.println("finish loading dictionary...");
	}
	
	public void readIndex(String indexFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(indexFile));
		
		// read copyright notice and ignore, hard-coded to ignore first 29 lines
		for(int i=0;i<29;i++) 
			br.readLine();
		
		// read index file
		String line = "";
		while((line=br.readLine())!=null) {
			String columns[] = line.split("\\s");
			
			Lemma lemma = new Lemma();
			lemma.setLemma(columns[0].replace("_", " "));
			lemma.setPos(columns[1]);
			lemma.setSynset_cnt(Integer.parseInt(columns[2]));
			
			lemma.setP_cnt(Integer.parseInt(columns[3]));
			int ptr_num = Integer.parseInt(columns[3]);
			
			Vector<String> ptr_symbol = new Vector<String>(); 
			for(int i=1;i<=ptr_num;i++) {
				ptr_symbol.add(columns[3+i]);
			}
			lemma.setPtr_symbol(ptr_symbol);
			
			lemma.setSense_cnt(Integer.parseInt(columns[3+ptr_num+1]));
			int sense_num = Integer.parseInt(columns[3+ptr_num+1]);
			
			lemma.setTagsense_cnt(Integer.parseInt(columns[3+ptr_num+2]));
			
			Vector<Integer> synset_offset = new Vector<Integer>();
			for(int i=1;i<=sense_num;i++) {
				synset_offset.add(Integer.parseInt(columns[3+ptr_num+2+i]));
			}
			lemma.setSynset_offset(synset_offset);
			
			this.addLemma(lemma);
		}
	}
	
	private void addLemma(Lemma lemma) {
		Vector<Lemma> vLemma;
		
		if(lemmas.get(lemma.getLemma())!=null) {
			vLemma = lemmas.get(lemma.getLemma());
		} else {
			vLemma = new Vector<Lemma>();
		}
		
		vLemma.add(lemma);
		lemmas.put(lemma.getLemma(), vLemma);
	}
	
	public void readSynset(String synsetFile) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(synsetFile));
		
		// read copyright notice and ignore, hard-coded to ignore first 29 lines
		for(int i=0;i<29;i++) 
			br.readLine();
		
		// read synset file
		String line = "";
		while((line=br.readLine())!=null) {
			String parts[] = line.split("\\|");		// parts[1] is the gloss
			
			String columns[] = parts[0].split("\\s+");
			
			Synset synset = new Synset();
			synset.setGloss(parts[1]);
			synset.setOffset(Integer.parseInt(columns[0]));
			synset.setLex_filenum(Integer.parseInt(columns[1]));
			synset.setSs_type(columns[2]);
			
			synset.setW_cnt(Integer.parseInt(columns[3], 16));
			int w_cnt = Integer.parseInt(columns[3], 16);
			
			Vector<String> word = new Vector<String>(); 
			Vector<Integer> lex_id = new Vector<Integer>();
			
			for(int i=1;i<=w_cnt*2;i=i+2) {
				word.add(columns[3+i].replace("_", " "));
				lex_id.add(Integer.parseInt(columns[4+i], 16));
			}
			
			synset.setWord(word);
			synset.setLex_id(lex_id);
			
			synset.setP_cnt(Integer.parseInt(columns[3+w_cnt*2+1]));
			int p_cnt = Integer.parseInt(columns[3+w_cnt*2+1]);
			
			Vector<Pointer> ptr = new Vector<Pointer>();
			for(int i=1;i<=p_cnt*4;i=i+4) {
				Pointer p = new Pointer();
				p.setPointer_symbol(columns[4+w_cnt*2+i]);
				p.setSynset_offset(Integer.parseInt(columns[5+w_cnt*2+i]));
				p.setPos(columns[6+w_cnt*2+i]);
				p.setSource_target(Integer.parseInt(columns[7+w_cnt*2+i], 16));
				ptr.add(p);
			}
			synset.setPtr(ptr);

			synsets.put(Integer.parseInt(columns[0]), synset);
		}
		
	}
	
	public Vector<String> getSynonym(String lemma) {
		Vector<String> synonym = new Vector<String>();
		
		Vector<Lemma> vLemma = lemmas.get(lemma);
		if(vLemma!=null) {
			for(Lemma l: vLemma) {
				Vector<Integer> synset_offset = l.getSynset_offset();
				
				for(Integer i: synset_offset) {
					Synset s = synsets.get(i);
					
					Vector<String> word = s.getWord();
					for(String w: word) {
						if(!synonym.contains(w))
							synonym.add(w);
					}
				}
			}
		}
		
		return synonym;
	}
}
