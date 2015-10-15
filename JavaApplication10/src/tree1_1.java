package hoja9;

import java.util.*;
public class tree1 implements WordSet{

	private SplayTree<Word> base;

	public tree1 (){

	base = new SplayTree<Word>();

	}

	public Word get(Word word)
	{
		
		return base.get(word);
	}
	
	public void add(Word wordObject)
	{
		base.add(wordObject);
	}
}




