package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.List;

public class PrimeFinderThread implements Runnable{

	Thread PrimeFinder;
	static primeArray primeArray = new primeArray();
	int a = 0; 
	int b = 0;
	String nameThread = ""; 
	static ArrayList<Integer> numerosPrimos;
	
	public PrimeFinderThread(int a, int b, ArrayList<Integer> numerosPrimos, String nameThread) {
		super();
		this.PrimeFinder = new Thread(this,nameThread);
		this.a = a;
		this.b = b;
		this.numerosPrimos = numerosPrimos;
		this.nameThread = nameThread;
	}

	//Un método que crea e inicia un hilo
    public static PrimeFinderThread createThreadInstance (int a, int b ,ArrayList<Integer> numerosPrimos, String nameThread){       
		PrimeFinderThread newThread = new PrimeFinderThread(a, b, numerosPrimos, nameThread);
		newThread.PrimeFinder.start();
        return newThread;
    }

	public void run(){
		System.out.println(PrimeFinder.getName()+ " iniciando.");
		primeArray.isPrimeControll(a, b);
		numerosPrimos = primeArray.getPrimes();
		System.out.println("Números encontrados: "+numerosPrimos.size());
		for (Integer numero : numerosPrimos) {
			System.out.println(numero);
		}
		System.out.println("Total de numeros: "+numerosPrimos.size());
	}
	
	public List<Integer> getPrimes() {
		return primeArray.getPrimes();
	}

}
