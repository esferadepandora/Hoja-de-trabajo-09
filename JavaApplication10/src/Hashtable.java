

import java.util.*;

class Hashtable implements WordSet
{
	private HashMap<String,Word> base;
	
	public Hashtable()
	{
		base = new HashMap<String, Word>();
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