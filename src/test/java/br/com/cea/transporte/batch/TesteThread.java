package br.com.cea.transporte.batch;

public class TesteThread {

	public static void main(String[] args) {
	
		new Thread(() -> {
			  for(int i = 0; i < 10000; i++)
			    System.out.println("programa 1 valor " + i);
			}).start();
	}
}
