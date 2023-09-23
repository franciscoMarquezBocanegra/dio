package edu.eci.arsw.primefinder;

import java.util.ArrayList;
import java.util.List;

//Uso de Sincronizacion para controlar el acceso.
public class primeArray {
    private ArrayList<Integer> numerosPrimos = new ArrayList<Integer>();
		//sumArray está sincronizado
		synchronized List<Integer> isPrimeControll( int a, int b){
			for (int i=a;i<=b;i++){						
				if (isPrime(i)){
					if(!numerosPrimos.contains(i)){
						numerosPrimos.add(i);
					}
				}
			}
			try {
				Thread.sleep(10);//permitir el cambio de tarea
			}catch (InterruptedException exc){
				System.out.println("Hilo interrumpido");
			}
			return numerosPrimos;
		}

		boolean isPrime(int n) {
			if (n%2==0) return false;
			for(int i=3;i*i<=n;i+=2) {
				if(n%i==0)
					return false;
			}
			return true;
		}
	
		public ArrayList<Integer> getPrimes() {
			return numerosPrimos;
		}
}
