
import java.util.*;
public class tree1 implements WordSet{
        //ATRIBUTOS
	private SplayTree<Word> base;

        //CONSTRUCTOR
	public tree1 (){
	base = new SplayTree<Word>();
	}
        
        //METODOS
	public Word get(Word word){
		return base.get(word);
	}
	
	public void add(Word wordObject){
		base.add(wordObject);
	}
}




