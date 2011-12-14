package dictionary;

import java.util.Vector;

public class Synset {
	private int offset;
	private int lex_filenum;
	private String ss_type;
	private int w_cnt;
	private Vector<String> word;
	private Vector<Integer> lex_id;
	private int p_cnt;
	private Vector<Pointer> ptr;
	private String gloss;
	
	public Synset() {
		this.offset = 0;
		this.lex_filenum = 0;
		this.ss_type = "";
		this.w_cnt = 0;
		this.word = new Vector<String>();
		this.lex_id = new Vector<Integer>();
		this.p_cnt = 0;
		this.ptr = new Vector<Pointer>();
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLex_filenum() {
		return lex_filenum;
	}

	public void setLex_filenum(int lex_filenum) {
		this.lex_filenum = lex_filenum;
	}

	public String getSs_type() {
		return ss_type;
	}

	public void setSs_type(String ss_type) {
		this.ss_type = ss_type;
	}

	public int getW_cnt() {
		return w_cnt;
	}

	public void setW_cnt(int w_cnt) {
		this.w_cnt = w_cnt;
	}

	public Vector<String> getWord() {
		return word;
	}

	public void setWord(Vector<String> word) {
		this.word = word;
	}

	public Vector<Integer> getLex_id() {
		return lex_id;
	}

	public void setLex_id(Vector<Integer> lex_id) {
		this.lex_id = lex_id;
	}

	public int getP_cnt() {
		return p_cnt;
	}

	public void setP_cnt(int p_cnt) {
		this.p_cnt = p_cnt;
	}

	public Vector<Pointer> getPtr() {
		return ptr;
	}

	public void setPtr(Vector<Pointer> ptr) {
		this.ptr = ptr;
	}

	public String getGloss() {
		return gloss;
	}

	public void setGloss(String gloss) {
		this.gloss = gloss;
	}
	
	
	
	
}
