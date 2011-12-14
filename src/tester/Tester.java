package tester;

import java.io.File;
import java.io.IOException;
import java.util.Vector;

import dictionary.Wordnet;

public class Tester {
	
	public static void main(String []arg) throws IOException {
		System.out.println("Test" + (new File(".")).getAbsolutePath());
		
		Wordnet wordnet = new Wordnet();
		
		String lemma = System.console().readLine("Lemma: ");
		while(!lemma.equals("exit")) {
			Vector<String> synonym = wordnet.getSynonym(lemma);
			
			for(String s: synonym) {
				System.out.println(s);
			}
			
			System.out.println();
			lemma = System.console().readLine("Lemma: ");
		}
	}
}
