import java.util.Random;
public class TortoiseAndHare {
	
	public static void main(String[] args) {
		getPositions(); 
	}
	
public static int moveTortoise(int position) {
	Random r = new Random();
	int x = r.nextInt(9);
	if(0<= x && x<=4)
		position += 3;
	else if(x ==5 || x == 6)
		position = position - 6;
	else if(7 <= x && x <= 9)
		position += 1;
	if(position <1)
		position = 1;
	return position; 
}
public static int moveHare(int position) {
	Random r = new Random();
	int x = r.nextInt(9);
	 if(x == 2 || x == 3)
		position += 9;
	else if(x == 4)
		position = position-12;
	else if(5 <= x && x <= 7)
		++position;
	else if( x == 8 || x == 9)
		position = position -2;
	if(position <1)
		position = 1;
	return position; 
}

public static void getPositions() {
	int hare = 1;
	int tortoise = 1;
	int time = 0;
	System.out.printf("ON YOUR MARK, GET SET%nBANG!!!!%nAND THEY'RE OFF!!!!!%n" );
	System.out.printf("Time: %d%nB%n",time);
	System.out.printf("----------------------------------------------------------------------%n");
	++time;
	while(hare < 70 && tortoise < 70) {
		hare = moveHare(hare);
		tortoise = moveTortoise(tortoise);
		if(hare > 70)
			hare = 70;
		if(tortoise > 70)
			tortoise = 70;
		if(hare == tortoise) {
			System.out.printf("Time: %d%n",time);
			String positions = "%" + hare + "s%n";
			System.out.printf(positions, "B");
			System.out.printf("----------------------------------------------------------------------%n");
		}
		else {
			System.out.printf("Time: %d%n",time);
			String bunny;
			String tort;
			if (hare < tortoise) {
				bunny = "%" + hare + "s";
				System.out.printf(bunny, "H");
				tort = "%" + (tortoise - hare) + "s%n";
				System.out.printf(tort, "T");
			}
			else {
				tort ="%" + tortoise + "s";
				System.out.printf(tort, "T");
				bunny = "%" + (hare - tortoise) + "s%n";
				System.out.printf(bunny, "H");
			}
			System.out.printf("----------------------------------------------------------------------%n");
		}
		++time;
	}
	if(hare == tortoise)
		System.out.println("There is a Tie!");
	else if (hare > tortoise)
		System.out.println("Hare wins. Yuck.");
	else 
		System.out.println("TORTOISE WINS! YAY!!");
	System.out.printf("Time elapsed: %d seconds", time);
}
}
