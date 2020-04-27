import java.util.*;
public class OldMaidHand extends CardStack
{
	private ArrayList<Card> fuldeck;
	public OldMaidHand()
	{
		fuldeck = new ArrayList<Card>();
	}

	public void addCard(Card c)
	{
		fuldeck.add(c);
	}
	public void removePairs()
	{
		int match = 1;
		int target =0;
		ArrayList<Card> fuldeck2 = new ArrayList<Card>();
		for (int i = 1; i<fuldeck.size();i++)
		{
            int a =fuldeck.get(target).getFace();
         	int b =fuldeck.get(i).getFace();
			if(a==b)
			{
				System.out.println("Remove pair of "+ fuldeck.get(target).toString()+"-"+fuldeck.get(i).toString());
				fuldeck.remove(i);
				fuldeck.remove(target);
				i=0;
				match=1;
            	target=0;
            
            
			}
			if(i==(fuldeck.size()-1))
			{
				fuldeck2.add(fuldeck.get(target));
            	fuldeck.remove(target);
            	target=0;
            	i=0;
            
			}
			if(a!=b&&match!=fuldeck.size())
			{
				match++;
			}
         if(fuldeck.size()==1)
         {
            fuldeck2.add(fuldeck.get(0));
         }
			
		}
		fuldeck = fuldeck2;
	}
	public String toString()
	{
		
		String result = "";
        for(int i=0; i<this.fuldeck.size(); i++)
        {
            result+="("+(i+1)+")"+this.fuldeck.get(i).toString();
        }
        return result;
	}
	public String toString1()
	{
		String result = "";
        for(int i=0; i<fuldeck.size(); i++)
        {
            result+="["+fuldeck.get(i).toString()+"] ";
        }
        return result;
	}
	public Card getCard(int i)
	{
		return this.fuldeck.get(i);
	}
	 public int getSize()
    {
        return this.fuldeck.size();
    }
    public void removeCard(int i)
    {
        
        this.fuldeck.remove(i);
    }
    public boolean hasCard()
    {
    	return (this.fuldeck.size()>0);
    }
    public void shuffle()
    {
        int random;
        for (int i=0; i<fuldeck.size(); i++)
        {
            random = (int)(Math.random()*fuldeck.size());
            swap(i,random);
        }
    }
    public void swap(int position1, int position2)
    {
        Card temp;  
        temp = fuldeck.get(position1);
        fuldeck.set(position1, fuldeck.get(position2));
        fuldeck.set(position2, temp);
    }
    
    // public Card removeCard(int i)
    // {
    // 	System.out.println("removing from stack ... "+fuldeck.get(i));
    //     fuldeck.remove(i);
    // }
}