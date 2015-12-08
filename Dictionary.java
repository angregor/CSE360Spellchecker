
public class Dictionary {

	private String[] dictionary = new String[5];
	private String[] ignoredWords = new String[5];
	private String[] addedWords = new String[5];
	private int count = 0;
	private int dictionarySize = 5;

	public Dictionary()
	{
		
	}
	
	public int getLength(String[] arrayForLength)
	{
		int iterL = 0;
		int length = 0;
		while(arrayForLength[iterL] != null)
		{
			length++;
		}
		return length;
	}
	
	public void insertWord(String toDictionary)
	{
		if(dictionary[0] == null)
		{
			dictionary[0] = toDictionary; 
			count++;
		}
		else if(dictionary[dictionarySize - 1] != null)
		{
			this.expandSize(dictionary);
		}
		{
			int iter = 0;
			while(iter < count)
			{
				if(toDictionary.compareTo(dictionary[iter]) < 0)
				{
					iter++;
				}
				else 
				{
					int j = count;
					while(j >= iter)
					{
						dictionary[j] = dictionary[j - 1];
						j--;
					}
					dictionary[iter] = toDictionary;
				}
			}
		}
	}
	
	
	public boolean searchWord(int lowerBound, int upperBound, String searchWord)
	{
		boolean found = false;
		int lower = lowerBound;
		int upper = upperBound;
		int midPoint = (lowerBound + upperBound/2);
		while(found == false && lower <= upper)
		{
			if(searchWord.compareTo(dictionary[midPoint]) == 0)
			{
				found = true;
			}
			else if(searchWord.compareTo(dictionary[midPoint]) <= 0)
			{
				searchWord(lower, midPoint, searchWord);
			}
			else
				searchWord(midPoint + 1, upper, searchWord);
		}

		return found;
	}
	
	
	private void expandSize(String[] listForExpansion)
	{
		int newLength = listForExpansion.length * 2;
		String[] dictionary = new String[newLength];
		for(int i = 0; i <= getLength(listForExpansion); i++)
		{
			dictionary[i] = listForExpansion[i];
			dictionarySize = dictionarySize * 2;
		}
	}

	public void addIgnore(String toIgnoredDictionary)
	{
		if(ignoredWords[0] == null)
		{
			ignoredWords[0] = toIgnoredDictionary; 
		}
		else if(ignoredWords[ignoredWords.length - 1] != null)
		{
			this.expandSize(ignoredWords);
		}
		{
			int iter = 0;
			while(iter < ignoredWords.length)
			{
				if(toIgnoredDictionary.compareTo(ignoredWords[iter]) < 0)
				{
					iter++;
				}
				else 
				{
					int j = ignoredWords.length;
					while(j >= iter)
					{
						ignoredWords[j] = ignoredWords[j - 1];
						j--;
					}
					ignoredWords[iter] = toIgnoredDictionary;
				}
			}
		}
	}
	

	public void addWord(String toAddedDictionary)
	{
		if(addedWords[0] == null)
		{
			addedWords[0] = toAddedDictionary; 
		}
		else if(addedWords[addedWords.length - 1] != null)
		{
			this.expandSize(addedWords);
		}
		{
			int iter = 0;
			while(iter < addedWords.length)
			{
				if(toAddedDictionary.compareTo(addedWords[iter]) < 0)
				{
					iter++;
				}
				else 
				{
					int j = addedWords.length;
					while(j >= iter)
					{
						addedWords[j] = addedWords[j - 1];
						j--;
					}
					addedWords[iter] = toAddedDictionary;
				}
			}
		}
	}
	
	public void outputFiles()
	{
		
	}

}
