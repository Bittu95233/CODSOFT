package com.codsoft;

import java.util.Scanner;

public class GuessingNumber {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int limit = 10;
		int score = 0;
		boolean playagain = true;
		System.out.println("Hello Guy's! Welcome to Number Game");
		System.out.println("You have only "+ limit+ " chance to win the Game!!!!");
		while(playagain) {
			int rand = getRandomNumber(1,100);
			boolean guessNumber = false;
			for(int i = 0;i<limit;i++) {
				System.out.println("Limit"+(i+1)+",Enter your guess");
				int userNumber = sc.nextInt();
				if (userNumber==rand) {
					guessNumber=true;
					score+=1;
					System.out.println("You won the Game!!!");
					break;
				} else if(userNumber > rand){
					System.out.println("Too High!!");
				}else {
					System.out.println("Too Low!!");
				}
			}
			if (guessNumber==false) {
				System.out.println("Sorry guy's! Your chance is over now. The number is: "+ rand);
			}
			System.out.println("Do you want to play again(y/n)");
			String pa = sc.next();
			playagain=pa.equalsIgnoreCase("y");			
		}
		System.out.println("Hope you guy's!! You enjoyed the Game!!!!");
		System.out.println("Your score is : "+ score);
		sc.close();
	}

	private static int getRandomNumber(int i, int j) {
		return (int)(Math.random()*(j-i+1)+i);
	}
}
