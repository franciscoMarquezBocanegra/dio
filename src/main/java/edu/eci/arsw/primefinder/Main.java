package edu.eci.arsw.primefinder;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		//No debe modificar el tipo de objeto "numerosPrimos"
		ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
		PrimeFinderThread pft = PrimeFinderThread.createThreadInstance(1, 30000, numerosPrimos, "#1");
		PrimeFinderThread pft2 = PrimeFinderThread.createThreadInstance(1, 30000, numerosPrimos, "#2");
		PrimeFinderThread pft3 = PrimeFinderThread.createThreadInstance(1, 30000, numerosPrimos, "#3");
		
		try {
			pft.PrimeFinder.join();
			pft2.PrimeFinder.join();
			pft3.PrimeFinder.join();
		} catch (InterruptedException ex) {
			System.out.println("Hilo principal interrumpido.");
		}
	}
}
