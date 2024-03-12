package Assignment3;

import java.util.Scanner;

public class DiceRoller {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Assignment3.Dice Roller!");

        String input;
        do {
            Dice dice = new Dice();
            dice.roll();
            dice.printRoll();

            System.out.print("Roll again? (y/n): ");
            input = scanner.nextLine();
        } while (input.equalsIgnoreCase("y"));

        scanner.close();
    }
}

class Die {
    private int value;

    public Die() {
        this.value = 0;
    }

    public void roll() {
        this.value = (int) (Math.random() * 6) + 1;
    }

    public int getValue() {
        return this.value;
    }
}

class Dice {
    private Die die1;
    private Die die2;

    public Dice() {
        this.die1 = new Die();
        this.die2 = new Die();
    }

    public void roll() {
        this.die1.roll();
        this.die2.roll();
    }

    public int getDie1Value() {
        return this.die1.getValue();
    }

    public int getDie2Value() {
        return this.die2.getValue();
    }

    public int getSum() {
        return this.die1.getValue() + this.die2.getValue();
    }

    public void printRoll() {
        System.out.println("Assignment3.Die 1: " + getDie1Value());
        System.out.println("Assignment3.Die 2: " + getDie2Value());
        System.out.println("Total: " + getSum());

        if (getSum() == 7)
            System.out.println("Craps!");
        else if (getDie1Value() == 1 && getDie2Value() == 1)
            System.out.println("Snake eyes!");
        else if (getDie1Value() == 6 && getDie2Value() == 6)
            System.out.println("Box cars!");
    }
}

