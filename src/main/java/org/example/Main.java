package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.println(SolutionOne.readInputAndGetSum("src/main/resources/input.txt"));
  }
}

class SolutionOne{
  static Scanner sc;
  public static int readInputAndGetSum(String path) {
    int totalSum = 0;
    try (BufferedReader br = new BufferedReader(new FileReader(path))) {
      String line;
      String regex = "mul\\((\\d{1,3}),(\\d{1,3})\\)";
      while((line = br.readLine()) != null) {
        totalSum += getSumOfMultiplicationsInLine(line, regex);
      }
    } catch(IOException e) {
      e.printStackTrace();
    }
    return totalSum;
  }

  static int getSumOfMultiplicationsInLine(String line, String regex) {
    sc = new Scanner(line);
    int sum = 0;
    while (sc.findInLine(regex) != null) {
      int num1 = Integer.parseInt(sc.match().group(1));
      int num2 = Integer.parseInt(sc.match().group(2));
      sum += num1*num2;
    }
    return sum;
  }
}
