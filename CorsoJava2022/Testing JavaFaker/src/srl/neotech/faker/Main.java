package srl.neotech.faker;

import com.github.javafaker.Faker;

public class Main {

	public static void main(String[] args) {
		Faker faker=new Faker();
		System.out.println(faker.name().fullName()+" lives in "+faker.address().city());
		System.out.println(faker.dragonBall().character()+" fights against "+faker.dragonBall().character());
		System.out.println(faker.funnyName().name()+" exclaims: \""+faker.shakespeare().romeoAndJulietQuote()+"\"");
		System.out.println(faker.harryPotter().location()+" is scarier than "+faker.lordOfTheRings().location());
		for (int i=0; i<10; i++){System.out.print(faker.letterify("A????o "));}	System.out.println();
		System.out.println("the "+faker.animal().name()+" fears the "+faker.animal().name());
		System.out.println(faker.ancient().primordial()+" was killed by "+faker.ancient().god());
	}

}
