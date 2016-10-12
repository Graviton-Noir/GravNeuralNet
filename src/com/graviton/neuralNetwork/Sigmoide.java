package com.graviton.neuralNetwork;

/**
 * Fonction de seuil ! TODO - mettre la définition exacte
 * @author cueille
 *
 */
public class Sigmoide {
	public static double output(double x) {
		return 1 / (1 + Math.exp(-x));
	}
	
	public static double derivate(double x) {
		return output(x) * (1 - output(x));
	}
}
