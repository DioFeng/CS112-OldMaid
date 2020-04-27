import java.util.*;
import java.util.Scanner;
public class OldMaid
{
	private static int oldmaid;
	private static int players,winner,oldMaidValue;
	private static int hasValue = -1;
	private static int choice1,choice2,choice3,choice4,choice5;
	private static String p1,p2,p3,p4,p5,whoWon;
	private static Deck deck;
	private static OldMaidPlayer player1, player2, player3, player4, player5 = null;
	private static CardStack fulldeck = new CardStack();
	private static OldMaidHand p1deck,p2deck,p3deck,p4deck,p5deck = null;
	private static boolean inPlay;
	public static void main(String[] args)
	{
		inPlay = false;
		Scanner scan = new Scanner(System.in);
		while(!inPlay)
		{
			gameSetUp();
			System.out.println("=====================================>");
			System.out.println();
			System.out.println("=====================================>");
			System.out.println("PLAY AGAIN WITH DIFFERENT PLAYERS? (y or n)");
			String input = scan.next();
			if (input.equals("y"))
			{
				inPlay= false;
			}
			else 
				inPlay =  true;
		}			
	}
	public static void threePlayers()
	{
		boolean abc = false;
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the name for the 1st player: ");
		p1 = scan1.nextLine();
		player1 = new OldMaidPlayer(p1);
		player1.setName(p1);
		System.out.println("Enter the name for the 2nd player: ");
		p2 = scan1.nextLine();
		player2 = new OldMaidPlayer(p2);
		player2.setName(p2);
		System.out.println("Enter the name for the 3rd player: ");
		p3 = scan1.nextLine();
		player3 = new OldMaidPlayer(p3);
		player3.setName(p3);

		while (!abc)
		{
			p1deck = new OldMaidHand();
			p2deck = new OldMaidHand();	
			p3deck = new OldMaidHand();
			while (fulldeck.getSize()>0)
			{
				p1deck.addCard(fulldeck.deal());
				p2deck.addCard(fulldeck.deal());
				p3deck.addCard(fulldeck.deal());
			}
			System.out.println("Card on each player's hand:");
			System.out.println("🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏");
			System.out.println(player1.getName()+": "+p1deck.toString1());
			System.out.println();
			System.out.println(player2.getName()+": "+p2deck.toString1());
			System.out.println();
			System.out.println(player3.getName()+": "+p3deck.toString1());
			System.out.println();
			p1deck.removePairs();
			p2deck.removePairs();
			p3deck.removePairs();
			System.out.println();
			System.out.println("After removed pairs on each player's hand:");
			System.out.println("🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴");
			System.out.println(player1.getName()+": "+p1deck.toString());
			System.out.println();
			System.out.println(player2.getName()+": "+p2deck.toString());
			System.out.println();
			System.out.println(player3.getName()+": "+p3deck.toString());
			System.out.println();
			boolean playmode = true;

			while (playmode)
			{
				Scanner choosecard = new Scanner(System.in);
				boolean correct = true;
				
				if(p3deck.getSize()==0)
				{
					player3.won();
					player3.setPoints(3);
					whoWon = "player3";
					break;
				}
				System.out.println("1⃣️  It's "+player1.getName()+" turn");
				System.out.println("You have: "+ p1deck.toString1());
				System.out.println();
				System.out.println("2⃣️  "+player2.getName()+" has   "+p2deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice1 = choosecard.nextInt();
						if (choice1>0&&choice1<=p2deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice1 = choosecard.nextInt();		
					}
				}			
				p1deck.addCard(p2deck.getCard(choice1-1));
				p2deck.removeCard(choice1-1);		
				p1deck.removePairs();
				if(p2deck.getSize()==0)
				{
					player2.won();
					player2.setPoints(3);
					whoWon = "player2";
					break;
				}
				p1deck.shuffle();
				
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
				correct = true;
				if(p1deck.getSize()==0)
				{
					player1.won();
					player1.setPoints(3);
					whoWon = "player1";
					break;
				}
				System.out.println("2⃣️  It's "+player2.getName()+" turn");
				System.out.println("You have: "+ p2deck.toString1());
				System.out.println();
				System.out.println("3⃣️  "+player3.getName()+" has   "+p3deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice2 = choosecard.nextInt();
						if (choice2>0&&choice2<=p3deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}
						
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice2 = choosecard.nextInt();		
					}
				}
				p2deck.addCard(p3deck.getCard(choice2-1));
				p3deck.removeCard(choice2-1);		
				p2deck.removePairs();
				if(p3deck.getSize()==0)
				{
					player3.won();
					player3.setPoints(3);
					whoWon = "player3";
					break;
				}
				p2deck.shuffle();
				
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
				correct = true;
				if(p2deck.getSize()==0)
				{
					player2.won();
					player2.setPoints(3);
					whoWon = "player2";
					 break;
				}
				System.out.println("3⃣️  It's "+player3.getName()+" turn");
				System.out.println("You have: "+ p3deck.toString1());
				System.out.println();
				System.out.println("1⃣️  "+player1.getName()+" has   "+p1deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice3 = choosecard.nextInt();
						if (choice3>0&&choice3<=p1deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}	
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice3 = choosecard.nextInt();		
					}
				}
				p3deck.addCard(p1deck.getCard(choice3-1));
				p1deck.removeCard(choice3-1);
				p3deck.removePairs();
				if(p1deck.getSize()==0)
				{
					player1.won();
					player1.setPoints(3);
					whoWon = "player1";
					break;
				}
				p3deck.shuffle();
				
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
			}
			calScoreThreePlayer();
			System.out.println("=====================================>");
			System.out.println("PLAY AGAIN WITH SAME PLAYERS? (y or n)");
			String input = scan1.next();
			if (input.equals("y"))
			{
				deckSetUp();
				abc= false;
			}
			else 
				abc = true;
		}
	}
	public static void fourPlayers()
	{
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the name for the 1st player: ");
		p1 = scan1.nextLine();
		player1 = new OldMaidPlayer(p1);
		player1.setName(p1);
		System.out.println("Enter the name for the 2nd player: ");
		p2 = scan1.nextLine();
		player2 = new OldMaidPlayer(p2);
		player2.setName(p2);
		System.out.println("Enter the name for the 3rd player: ");
		p3 = scan1.nextLine();
		player3 = new OldMaidPlayer(p3);
		player3.setName(p3);
		System.out.println("Enter the name for the 4th player: ");
		p4 = scan1.nextLine();
		player4 = new OldMaidPlayer(p4);
		player4.setName(p4);

		boolean qwe = false;
		while(!qwe)
		{
			p1deck = new OldMaidHand();
			p2deck = new OldMaidHand();	
			p3deck = new OldMaidHand();
			p4deck = new OldMaidHand();
			 int cardremains=0;
			while (cardremains<12)
			{
				p1deck.addCard(fulldeck.deal());
				p2deck.addCard(fulldeck.deal());
				p3deck.addCard(fulldeck.deal());
				p4deck.addCard(fulldeck.deal());
				cardremains++;
			}
			p1deck.addCard(fulldeck.deal());
			p2deck.addCard(fulldeck.deal());
			p3deck.addCard(fulldeck.deal());
			
			System.out.println("Card on each player's hand:");
			System.out.println("🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏");
			System.out.println(player1.getName()+": "+p1deck.toString1());
			System.out.println();
			System.out.println(player2.getName()+": "+p2deck.toString1());
			System.out.println();
			System.out.println(player3.getName()+": "+p3deck.toString1());
			System.out.println();
			System.out.println(player4.getName()+": "+p4deck.toString1());
			System.out.println();
			p1deck.removePairs();
			p2deck.removePairs();
			p3deck.removePairs();
			p4deck.removePairs();
			System.out.println();
			System.out.println("After removed pairs on each player's hand:");
			System.out.println("🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴");
			System.out.println(player1.getName()+": "+p1deck.toString());
			System.out.println();
			System.out.println(player2.getName()+": "+p2deck.toString());
			System.out.println();
			System.out.println(player3.getName()+": "+p3deck.toString());
			System.out.println();
			System.out.println(player4.getName()+": "+p4deck.toString());
			System.out.println();
			boolean playmode = true;
			while (playmode)
			{
				Scanner choosecard = new Scanner(System.in);
				boolean correct = true;	
				if(p4deck.getSize()==0)
				{
					player4.won();
					player4.setPoints(3);
					whoWon = "player4";
					break;
				}
				System.out.println("1⃣️  It's "+player1.getName()+" turn");
				System.out.println("You have: "+ p1deck.toString1());
				System.out.println();
				System.out.println("2⃣️  "+player2.getName()+" has   "+p2deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice1 = choosecard.nextInt();
						if (choice1>0&&choice1<=p2deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice1 = choosecard.nextInt();		
					}
				}			
				p1deck.addCard(p2deck.getCard(choice1-1));
				p2deck.removeCard(choice1-1);			
				p1deck.removePairs();
				if(p2deck.getSize()==0)
				{
					player2.won();
					player2.setPoints(3);
					whoWon = "player2";
					break;
				}
				p1deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
				correct = true;
				if(p1deck.getSize()==0)
				{
					player1.won();
					player1.setPoints(3);
					whoWon = "player1";
					break;
				}
				System.out.println("2⃣️  It's "+player2.getName()+" turn");
				System.out.println("You have: "+ p2deck.toString1());
				System.out.println();
				System.out.println("3⃣️  "+player3.getName()+" has   "+p3deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice2 = choosecard.nextInt();
						if (choice2>0&&choice2<=p3deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}				
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice2 = choosecard.nextInt();		
					}
				}		
				p2deck.addCard(p3deck.getCard(choice2-1));
				p3deck.removeCard(choice2-1);
				p2deck.removePairs();
				if(p3deck.getSize()==0)
				{
					player3.won();
					player3.setPoints(3);
					whoWon = "player3";
					break;
				}
				p2deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
				correct = true;
				if(p2deck.getSize()==0)
				{
					player2.won();
					player2.setPoints(3);
					whoWon = "player2";
					 break;
				}
				System.out.println("3⃣️  It's "+player3.getName()+" turn");
				System.out.println("You have: "+ p3deck.toString1());
				System.out.println();
				System.out.println("4⃣️  "+player4.getName()+" has   "+p4deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice3 = choosecard.nextInt();
						if (choice3>0&&choice3<=p4deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}			
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice3 = choosecard.nextInt();		
					}
				}
				p3deck.addCard(p4deck.getCard(choice3-1));
				p4deck.removeCard(choice3-1);			
				p3deck.removePairs();
				if(p4deck.getSize()==0)
				{
					player4.won();
					player4.setPoints(3);
					whoWon = "player4";
					break;
				}
				p3deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");

				correct = true;
				if(p3deck.getSize()==0)
				{
					player3.won();
					player3.setPoints(3);
					whoWon = "player3";
					 break;
				}
				System.out.println("4⃣️  It's "+player4.getName()+" turn");
				System.out.println("You have: "+ p4deck.toString1());
				System.out.println();
				System.out.println("1⃣️  "+player1.getName()+" has   "+p1deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice4 = choosecard.nextInt();
						if (choice4>0&&choice4<=p1deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}	
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice4 = choosecard.nextInt();		
					}
				}
				System.out.println(choice4-1);
				p4deck.addCard(p1deck.getCard(choice4-1));
				p1deck.removeCard(choice4-1);		
				p4deck.removePairs();
				if(p1deck.getSize()==0)
				{
					player1.won();
					player1.setPoints(3);
					whoWon = "player1";
					break;
				}
				p4deck.shuffle();

				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");		
			}
			calScoreFourPlayer();
			System.out.println("=====================================>");
			System.out.println("PLAY AGAIN WITH SAME PLAYERS? (y or n)");
			String input = scan1.next();
			if (input.equals("y"))
			{
				deckSetUp();
				qwe= false;
			}
			else 
				qwe = true;
		}
	}
	public static void fivePlayers()
	{
		Scanner scan1 = new Scanner(System.in);
		System.out.println("Enter the name for the 1st player: ");
		p1 = scan1.nextLine();
		player1 = new OldMaidPlayer(p1);
		player1.setName(p1);
		System.out.println("Enter the name for the 2nd player: ");
		p2 = scan1.nextLine();
		player2 = new OldMaidPlayer(p2);
		player2.setName(p2);
		System.out.println("Enter the name for the 3rd player: ");
		p3 = scan1.nextLine();
		player3 = new OldMaidPlayer(p3);
		player3.setName(p3);
		System.out.println("Enter the name for the 4th player: ");
		p4 = scan1.nextLine();
		player4 = new OldMaidPlayer(p4);
		player4.setName(p4);
		System.out.println("Enter the name for the 5th player: ");
		p5 = scan1.nextLine();
		player5 = new OldMaidPlayer(p5);
		player5.setName(p5);
		boolean zxc = false;
		while(!zxc)
		{
			p1deck = new OldMaidHand();
			p2deck = new OldMaidHand();	
			p3deck = new OldMaidHand();
			p4deck = new OldMaidHand();
			p5deck = new OldMaidHand();

			int counter=0;
			while (counter<10)
			{
				p1deck.addCard(fulldeck.deal());
				p2deck.addCard(fulldeck.deal());
				p3deck.addCard(fulldeck.deal());
				p4deck.addCard(fulldeck.deal());
				p5deck.addCard(fulldeck.deal());
				counter++;
			}
			p1deck.addCard(fulldeck.deal());
			

			System.out.println("Card on each player's hand:");
			System.out.println("🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏");
			System.out.println(player1.getName()+": "+p1deck.toString1());
			System.out.println();
			System.out.println(player2.getName()+": "+p2deck.toString1());
			System.out.println();
			System.out.println(player3.getName()+": "+p3deck.toString1());
			System.out.println();
			System.out.println(player4.getName()+": "+p4deck.toString1());
			System.out.println();
			System.out.println(player5.getName()+": "+p5deck.toString1());
			System.out.println();
			p1deck.removePairs();
			p2deck.removePairs();
			p3deck.removePairs();
			p4deck.removePairs();
			p5deck.removePairs();
			System.out.println();
			System.out.println("After removed pairs on each player's hand:");
			System.out.println("🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴🎴");
			System.out.println(player1.getName()+": "+p1deck.toString());
			System.out.println();
			System.out.println(player2.getName()+": "+p2deck.toString());
			System.out.println();
			System.out.println(player3.getName()+": "+p3deck.toString());
			System.out.println();
			System.out.println(player4.getName()+": "+p4deck.toString());
			System.out.println();
			System.out.println(player5.getName()+": "+p5deck.toString());
			System.out.println();
			boolean playmode = true;
			while (playmode)
			{
				Scanner choosecard = new Scanner(System.in);
				boolean correct = true;
				if(p5deck.getSize()==0)
				{
					player5.won();
					player5.setPoints(3);
					whoWon = "player5";
					break;
				}
				System.out.println("1⃣️  It's "+player1.getName()+" turn");
				System.out.println("You have: "+ p1deck.toString1());
				System.out.println();
				System.out.println("2⃣️  "+player2.getName()+" has   "+p2deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice1 = choosecard.nextInt();
						if (choice1>0&&choice1<=p2deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}					
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice1 = choosecard.nextInt();		
					}
				}			
				p1deck.addCard(p2deck.getCard(choice1-1));
				p2deck.removeCard(choice1-1);			
				p1deck.removePairs();
				if(p2deck.getSize()==0)
				{
					player2.won();
					player2.setPoints(3);
					whoWon = "player2";
					break;
				}
				p1deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
				correct = true;
				if(p1deck.getSize()==0)
				{
					player1.won();
					player1.setPoints(3);
					whoWon = "player1";
					break;
				}
				System.out.println("2⃣️  It's "+player2.getName()+" turn");
				System.out.println("You have: "+ p2deck.toString1());
				System.out.println();
				System.out.println("3⃣️  "+player3.getName()+" has   "+p3deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice2 = choosecard.nextInt();
						if (choice2>0&&choice2<=p3deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}					
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice2 = choosecard.nextInt();		
					}
				}						
				p2deck.addCard(p3deck.getCard(choice2-1));
				p3deck.removeCard(choice2-1);			
				p2deck.removePairs();
				if(p3deck.getSize()==0)
				{
					player3.won();
					player3.setPoints(3);
					whoWon = "player3";
					break;
				}
				p2deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
				correct = true;
				if(p2deck.getSize()==0)
				{
					player2.won();
					player2.setPoints(3);
					whoWon = "player2";
					 break;
				}
				System.out.println("3⃣️  It's "+player3.getName()+" turn");
				System.out.println("You have: "+ p3deck.toString1());
				System.out.println();
				System.out.println("4⃣️  "+player4.getName()+" has   "+p4deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice3 = choosecard.nextInt();
						if (choice3>0&&choice3<=p4deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}				
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice3 = choosecard.nextInt();		
					}
				}
				p3deck.addCard(p4deck.getCard(choice3-1));
				p4deck.removeCard(choice3-1);		
				p3deck.removePairs();
				if(p4deck.getSize()==0)
				{
					player4.won();
					player4.setPoints(3);
					whoWon = "player4";
					break;
				}
				p3deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");

				correct = true;
				if(p3deck.getSize()==0)
				{
					player3.won();
					player3.setPoints(3);
					whoWon = "player3";
					 break;
				}
				System.out.println("4⃣️  It's "+player4.getName()+" turn");
				System.out.println("You have: "+ p4deck.toString1());
				System.out.println();
				System.out.println("5⃣️  "+player5.getName()+" has   "+p5deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice4 = choosecard.nextInt();
						if (choice4>0&&choice4<=p5deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}				
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice4 = choosecard.nextInt();		
					}
				}
				System.out.println(choice4-1);
				p4deck.addCard(p5deck.getCard(choice4-1));
				p5deck.removeCard(choice4-1);			
				p4deck.removePairs();
				if(p5deck.getSize()==0)
				{
					player5.won();
					player5.setPoints(3);
					whoWon = "player5";
					break;
				}
				p4deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");

				correct = true;
				if(p4deck.getSize()==0)
				{
					player4.won();
					player4.setPoints(3);
					whoWon = "player4";
					 break;
				}
				System.out.println("5⃣️  It's "+player5.getName()+" turn");
				System.out.println("You have: "+ p5deck.toString1());
				System.out.println();
				System.out.println("1⃣️  "+player1.getName()+" has   "+p1deck.toString());
				while(correct)
				{
					try
					{
						System.out.println("Which card you take: ");
						choice5 = choosecard.nextInt();
						if (choice5>0&&choice5<=p1deck.getSize())
							{
								correct = false;
							}
						else
						{
							System.out.println("Not valid, try again: ");				
						}				
					}
					catch (InputMismatchException eee)
					{
						System.out.println("⚠️   Enter integer please    ⚠️");
						System.out.println();
						choice5 = choosecard.nextInt();		
					}
				}
				p5deck.addCard(p1deck.getCard(choice5-1));
				p1deck.removeCard(choice5-1);		
				p5deck.removePairs();
				if(p1deck.getSize()==0)
				{
					player1.won();
					player1.setPoints(3);
					whoWon = "player1";
					break;
				}
				p5deck.shuffle();
				System.out.println("🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠🏠");
				
			}
			calScoreFivePlayer();
			System.out.println("=====================================>");
			System.out.println("PLAY AGAIN WITH SAME PLAYERS? (y or n)");
			String input = scan1.next();
			if (input.equals("y"))
			{
				deckSetUp();
				zxc= false;
			}
			else 
				zxc = true;

		}
	}
	public static void calScoreThreePlayer()
	{
		if(whoWon.contains("player1"))
		{
			winner = 1;
			System.out.println("👏👏👏The winner is "+ player1.getName()+"!!");
		}
		if(whoWon.contains("player2"))
		{
			winner = 2;
			System.out.println("👏👏👏The winner is "+ player2.getName()+"!!");
		}
		if(whoWon.contains("player3"))
		{
			winner = 3;
			System.out.println("👏👏👏The winner is "+ player3.getName()+"!!");
		}

		oldMaidValue = deck.get(oldmaid).getFace();
		switch (winner)
		{
			case 1:
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");			
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player2.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");		
			}
			break;
			case 2:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player1.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 3:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player2.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player1.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
		}
		System.out.println("=====================================>");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		System.out.println(player3.toString());
		inPlay = true;
	}
	public static void calScoreFourPlayer()
	{	
		if(whoWon.contains("player1"))
		{
			winner = 1;
			System.out.println("👏👏👏The winner is "+ player1.getName()+"!!");
		}
		if(whoWon.contains("player2"))
		{
			winner = 2;
			System.out.println("👏👏👏The winner is "+ player2.getName()+"!!");
		}
		if(whoWon.contains("player3"))
		{
			winner = 3;
			System.out.println("👏👏👏The winner is "+ player3.getName()+"!!");		
		}
		if(whoWon.contains("player4"))
		{
			winner = 4;
			System.out.println("👏👏👏The winner is "+ player4.getName()+"!!");			
		}

		oldMaidValue = deck.get(oldmaid).getFace();
		switch (winner)
		{
			case 1:
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player3.setPoints(1);
				player4.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player2.setPoints(1);
				player4.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player2.setPoints(1);
				player3.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 2:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player3.setPoints(1);
				player4.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player1.setPoints(1);
				player4.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player1.setPoints(1);
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 3:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player2.setPoints(1);
				player4.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player1.setPoints(1);
				player4.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player1.setPoints(1);
				player2.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 4:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player2.setPoints(1);
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player1.setPoints(1);
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player1.setPoints(1);
				player2.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
		}
		System.out.println("=====================================>");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		System.out.println(player3.toString());
		System.out.println(player4.toString());
		inPlay = true;
	}
	public static void calScoreFivePlayer()
	{
		if(whoWon.contains("player1"))
		{
			winner = 1;
			System.out.println("👏👏👏The winner is "+ player1.getName()+"!!");
		}
		if(whoWon.contains("player2"))
		{
			winner = 2;
			System.out.println("👏👏👏The winner is "+ player2.getName()+"!!");
		}
		if(whoWon.contains("player3"))
		{
			winner = 3;
			System.out.println("👏👏👏The winner is "+ player3.getName()+"!!");	
		}
		if(whoWon.contains("player4"))
		{
			winner = 4;
			System.out.println("👏👏👏The winner is "+ player4.getName()+"!!");
		}
		if(whoWon.contains("player5"))
		{
			winner = 5;
			System.out.println("👏👏👏The winner is "+ player5.getName()+"!!");
		}

		oldMaidValue = deck.get(oldmaid).getFace();
		switch (winner)
		{
			case 1:
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player3.setPoints(1);
				player4.setPoints(1);
				player5.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player2.setPoints(1);
				player4.setPoints(1);
				player5.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player2.setPoints(1);
				player3.setPoints(1);
				player5.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p5deck,oldMaidValue)==-1)
			{
				player5.lost();
				player2.setPoints(1);
				player3.setPoints(1);
				player4.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 2:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player3.setPoints(1);
				player4.setPoints(1);
				player5.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player1.setPoints(1);
				player4.setPoints(1);
				player5.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player1.setPoints(1);
				player3.setPoints(1);
				player5.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p5deck,oldMaidValue)==-1)
			{
				player5.lost();
				player1.setPoints(1);
				player3.setPoints(1);
				player4.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 3:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player2.setPoints(1);
				player4.setPoints(1);
				player5.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player1.setPoints(1);
				player4.setPoints(1);
				player5.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player2.setPoints(1);
				player1.setPoints(1);
				player5.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p5deck,oldMaidValue)==-1)
			{
				player5.lost();
				player2.setPoints(1);
				player1.setPoints(1);
				player4.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 4:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player2.setPoints(1);
				player3.setPoints(1);
				player5.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player1.setPoints(1);
				player3.setPoints(1);
				player5.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player2.setPoints(1);
				player1.setPoints(1);
				player5.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p5deck,oldMaidValue)==-1)
			{
				player5.lost();
				player2.setPoints(1);
				player1.setPoints(1);
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player5.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
			case 5:
			if(checkOldMaid(p1deck,oldMaidValue)==-1)
			{
				player1.lost();
				player2.setPoints(1);
				player4.setPoints(1);
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p2deck,oldMaidValue)==-1)
			{
				player2.lost();
				player1.setPoints(1);
				player4.setPoints(1);
				player3.setPoints(1);
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p4deck,oldMaidValue)==-1)
			{
				player4.lost();
				player2.setPoints(1);
				player1.setPoints(1);
				player3.setPoints(1);
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" lost!"+"This hand has an old maid!");
			}
			if(checkOldMaid(p3deck,oldMaidValue)==-1)
			{
				player3.lost();
				player2.setPoints(1);
				player1.setPoints(1);
				player4.setPoints(1);
				System.out.println(player2.getName()+" doesn't have the old maid.");
				System.out.println(player4.getName()+" doesn't have the old maid.");
				System.out.println(player1.getName()+" doesn't have the old maid.");
				System.out.println(player3.getName()+" lost!"+"This hand has an old maid!");
			}
			break;
		}
		System.out.println("=====================================>");
		System.out.println(player1.toString());
		System.out.println(player2.toString());
		System.out.println(player3.toString());
		System.out.println(player4.toString());
		System.out.println(player5.toString());
		inPlay = true;
	}
	public static int checkOldMaid(OldMaidHand deck,int a)
    {
    	int b = 0;
    	for (int i =0;i<deck.getSize();i++)
    	{
    		if (deck.getCard(i).getFace() == a)
   				b = hasValue ;
    	}
    	return b;
    }
    public static void gameSetUp()
    {
    	deckSetUp();
		Scanner scan = new Scanner(System.in);
		System.out.println("🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏");
		System.out.println("🃏Welcome to the OldMaid game!🃏");
		System.out.println("🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏🃏");
		System.out.println("How many players today?(3-5 players): ");
		players = scan.nextInt();
		while (players !=3 && players !=4 && players !=5)
		{
			try
			{
				System.out.println("Please enter integer between 3 - 5: ");
				players = scan.nextInt();
			}
			catch (InputMismatchException e)
			{
				System.out.println("Not integer!⚠️");
				System.out.println("Enter 3-5");
				players = scan.nextInt();
			}			
		}
		if (players == 3)
		{
			threePlayers();
		}
		if (players == 4)
		{
			fourPlayers();
		}
		if (players == 5)
		{
			fivePlayers();
		}
    }
    public static void deckSetUp()
    {
		deck = new Deck();
		Random gene = new Random();
		oldmaid = gene.nextInt(52)+1;

		for (int i = 0;i<52;i++)
		{
			fulldeck.addCard(deck.get(i));
		}	
		fulldeck.removeCard(oldmaid);
		fulldeck.shuffle();
    }
}