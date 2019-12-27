package Assignment7.part1;

public class Rodent
{
	void eat()
	{
		System.out.println("Rodent.eat()");
	}

	void jump()
	{
		System.out.println("Rodent.jump()");
	}
	
}

class Mouse extends Rodent 
{
	void eat()
	{
		System.out.println("Mouse.eat()");
	}
	
	void jump()
	{
		System.out.println("Mouse.jump()");
	}
}

class Gerbil extends Rodent 
{
	void eat()
	{
		System.out.println("Gerbil.eat()");
	}
	
	void jump()
	{
		System.out.println("Gerbil.jump()");
	}
}

class Hamster extends Rodent 
{
	void eat()
	{
		System.out.println("Hamster.eat()");
	}
	
	void jump()
	{
		System.out.println("Hamster.jump()");
	}
}
