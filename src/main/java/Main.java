import java.io.*;
import java.lang.*;
import java.util.Scanner;


public class Main {
  
  public static void main(String[] args) {

  	Scanner in = new Scanner(System.in);
	String operacion = in.nextLine();
  	Facade calc = new Facade(operacion);
  	float respuesta = calc.eval();
  	System.out.print(respuesta);

  }

}