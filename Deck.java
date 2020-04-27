import java.util.*;
public class Deck extends CardStack
{
	private final static int MAX = 52;
	private Card[] deck = new Card[MAX];

	public Deck()
	{
		for (int i = 0; i<13;i++)
		{
			deck[i] = new Card(i+1,1);
		}
		for (int i = 13; i<26;i++)
		{
			int n = i-12;
			deck[i] =new  Card(n,2);
		}
		for (int i = 26; i<39;i++)
		{
			int n = i-25;
			deck[i] = new Card(n,3);
		}
		for (int i = 39; i<52;i++)
		{
			int n = i-38;
			deck[i] = new Card(n,4);
		}
	}
	public String toString()
	{
		String a = "";
		for (int i = 0; i<deck.length;i++)
		{
			a += (i+1)+": "+deck[i].toString()+"\n";	
		}
		return a;
	}
	public Card get(int c)
	{
		return deck[c];
	}

}