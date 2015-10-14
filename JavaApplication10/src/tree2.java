
import java.util.*;
public class tree2 implements WordSet{

	private RedBlackBST<String,Word> base;

	public tree2 (){

	base = new RedBlackBST<String,Word>();

	}

	public Word get(Word word)
	{
		
		return base.get(word.getWord());
	}
	
	public void add(Word wordObject)
	{
		base.put(wordObject.getWord(),wordObject);
	}
}