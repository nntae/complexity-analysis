import java.util.Arrays;

public class Analizador {
	
	/* 
	 * NOTA IMPORTANTE
	 * 
	 * Esta clase se proporciona solamente para ilustrar el formato de
	 * salida que deberia tener la solucion a este ejericio.
	 * Esta clase debe modificarse completamente para cumplir 
	 * mínimamente los requisitos de esta practica.
	 * Notese que ni siquiera esta completa......
	 */
	private final static int UNO = 0;
	private final static int LOGN = 1;
	private final static int N = 2;
	private final static int NLOGN = 3;
	private final static int N2 = 4;
	private final static int N3 = 5;
	private final static int DOSN = 6;
	private final static int NF = 7;
	private final static String[] complexity = {"UNO","LOGN","N","NLOGN","N2","N3","DOSN","NF"};
	private static int[] inputs = {1,2,3,4,5,6,7,8};
	private static long[] times = new long[8];
	private static int augmentFactor;
	private static boolean debug;

	public static String masCercano(double ratio) {
			if (ratio < 1.5) {                      // aprox 1.0
				return "1";							
			} else if (1 <= ratio && ratio < 3.0) { // aprox 2.0
				return "N";
			} else if (3 <= ratio && ratio < 6.0) { // aprox 4.0
				return "N2";
			} else if (6 <= ratio && ratio < 10.0) { // aprox 8.0
				return "N3";
			} else { 								 // otras
				return "NF";
			}
	}

	// Comprueba si el parámetro --debug está puesto
	private static boolean isDebug(String[] args) {
		if (args.length == 0) {
			return false;
		}
		else {
			return args[0].equals("--debug");
		}
	}

	private static int getStartingInput(Temporizador t, String[] args) {
		double testTime = 0;
		double oldTestTime = 0;
		int factor = 0;
		int increaseFactor = 1;

		for (int i=0; i<args.length; i++) {
			if (args[i].equals("-r") && args.length > i+1) {
				factor = Integer.parseInt(args[i+1]);
				if (debug) System.out.println("[DEBUG] Detected user-set input augment factor of " + factor);
				return factor;
			}
		}

		if (debug) System.out.println("[DEBUG] Calculating a good starting input...");

		while (testTime < 10) {
			if (factor < 10) {
				factor++;
			}
			else {
				if (testTime == 0 || oldTestTime == 0 || testTime/oldTestTime < 1.2) {
					increaseFactor++;
				}
				factor += increaseFactor;
			}
			oldTestTime = testTime;
			testTime = evaluateAlgorithm(t, factor);
		}
		if (debug) System.out.println("[DEBUG] The starting input will be " + factor + ", which runs for " + testTime);
		return factor;
	}

	private static long evaluateAlgorithm(Temporizador t, long n) {
		t.iniciar();
		//Algoritmo.f(n);
		AlgorithmBox.f2n(n);
		t.parar();
		long tiempo = t.tiempoPasado();
		t.reiniciar();
		if (debug) System.out.println("[DEBUG] For input " + n + ", it took " + tiempo + " millis.");
		return tiempo;
	}

	public static void main(String[] arg) {
		Temporizador t = new Temporizador(Temporizador.MILIS);
		debug = isDebug(arg);
		augmentFactor = getStartingInput(t, arg);

		// Todo: Test for n! independently, test for pow(2,n) independently, test for rest of cases

		for (int i = 0; i < inputs.length; i++) {
			times[i] = evaluateAlgorithm(t,inputs[i] * augmentFactor);
		}
		System.out.print(Arrays.toString(times));
	}
}
