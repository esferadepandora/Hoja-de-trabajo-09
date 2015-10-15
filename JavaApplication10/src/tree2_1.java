package hoja9;

import java.util.*;
public class tree2 implements WordSet{

	private RedBlackTree<Word> base;

	public tree2 (){

	base = new RedBlackTree<Word>();

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