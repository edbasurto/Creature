
public class Creature {
	int str;
	int hp;
	
	public Creature() {
		setStr(10);
		setHP(10);
	}
	
	public Creature(int str, int hp) {
		setStr(str);
		setHP(hp);
	}
	
	public int getStr() { return str; }
	public int getHP() {return hp; }
	
	public void setStr(int str) {
		this.str = str;
	}
	
	public void setHP(int hp) {
		this.hp = hp;
	}
	
	public int getDmg() {
		return (int)(Math.random() * str);
	}
	
	public String toString() {
		return "Creature type: ";
	}
}

class Human extends Creature {

	public Human() {
		super();
	}
	
	public Human(int strength, int hp) {
		super(strength, hp);
	}
	
	public int getDmg() {
		return super.getDmg();
	}
	
	public String toString() {
		return super.toString() + "Human";
	}
}

class Elf extends Creature {
	
	public Elf() {
		super();
	}
	
	public Elf(int str, int hp) {
		super(str, hp);
	}
	
	public int getDmg() {
		if(((int)(Math.random()) % 2 == 0)) 
			return super.getDmg() * 2;
		return super.getDmg();
	}
}

class demon extends Creature {
	
	public demon() {
		super();
	}
	
	public demon(int str, int hp) {
		super(str, hp);
	}
	
	public int getDmg() {
		if((int)Math.random() % 4 == 0)
			return super.getDmg() + 50;
		return super.getDmg();
	}
}

class Cyberdemon extends demon {
	
	public Cyberdemon() {
		super();
	}
	
	public Cyberdemon(int str, int hp) {
		super(str, hp);
	}
}

class Balrog extends demon {
	
	public Balrog() {
		super();
	}
	
	public Balrog(int str, int hp) {
		super(str, hp);
	}
	
	public int getDmg() {
		return super.getDmg() + (int) Math.random() * super.str;
	}
}