/**
 * 
 */
package dictionary;

import java.util.Vector;

/**
 * @author franx
 * 
 * Representation of Wordnet Lemma
 */
public class Lemma {
	private String lemma;
	private String pos;
	private int synset_cnt;
	private int p_cnt;
	private Vector<String> ptr_symbol;
	private int sense_cnt;
	private int tagsense_cnt;
	private Vector<Integer> synset_offset;
	
	public Lemma() {
		this.lemma = "";
		this.pos = "";
		this.synset_cnt = 0;
		this.p_cnt = 0;
		this.ptr_symbol = new Vector<String>();
		this.sense_cnt = 0;
		this.tagsense_cnt = 0;
		this.synset_offset = new Vector<Integer>();
	}

	public String getLemma() {
		return lemma;
	}

	public void setLemma(String lemma) {
		this.lemma = lemma;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getSynset_cnt() {
		return synset_cnt;
	}

	public void setSynset_cnt(int synset_cnt) {
		this.synset_cnt = synset_cnt;
	}

	public int getP_cnt() {
		return p_cnt;
	}

	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}

	public Vector<String> getPtr_symbol() {
		return ptr_symbol;
	}

	public void setPtr_symbol(Vector<String> ptr_symbol) {
		this.ptr_symbol = ptr_symbol;
	}

	public int getSense_cnt() {
		return sense_cnt;
	}

	public void setSense_cnt(int sense_cnt) {
		this.sense_cnt = sense_cnt;
	}

	public int getTagsense_cnt() {
		return tagsense_cnt;
	}

	public void setTagsense_cnt(int tagsense_cnt) {
		this.tagsense_cnt = tagsense_cnt;
	}

	public Vector<Integer> getSynset_offset() {
		return synset_offset;
	}

	public void setSynset_offset(Vector<Integer> synset_offset) {
		this.synset_offset = synset_offset;
	}

	public String toString() {
		return lemma;
	}
}
