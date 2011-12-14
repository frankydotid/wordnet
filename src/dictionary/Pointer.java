package dictionary;

public class Pointer {
	private String pointer_symbol;
	private int synset_offset;
	private String pos;
	private int source_target;
	
	public Pointer() {
		this.pointer_symbol = "";
		this.synset_offset = 0;
		this.pos = "";
		this.source_target = 0;;
	}

	public String getPointer_symbol() {
		return pointer_symbol;
	}

	public void setPointer_symbol(String pointer_symbol) {
		this.pointer_symbol = pointer_symbol;
	}

	public int getSynset_offset() {
		return synset_offset;
	}

	public void setSynset_offset(int synset_offset) {
		this.synset_offset = synset_offset;
	}

	public String getPos() {
		return pos;
	}

	public void setPos(String pos) {
		this.pos = pos;
	}

	public int getSource_target() {
		return source_target;
	}

	public void setSource_target(int source_target) {
		this.source_target = source_target;
	}
	
	
}
