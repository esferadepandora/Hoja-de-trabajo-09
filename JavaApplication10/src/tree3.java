import java.util.*;

class tree3 implements WordSet
{
	private TreeMap<String,Word> base;
	
	public tree3()
	{
		base = new TreeMap<String, Word>();
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