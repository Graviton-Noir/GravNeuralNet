package com.graviton.neuralNetwork;

public class Main 
{	
	static double inputs[][] = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
	static double expectedValues[] = {0, 1, 1, 0};
	static double outputValues[] = {0.0d, 0.0d, 0.0d, 0.0d};
	//One hidden layer with 3 neurons, could be {3, 3} : 2 layers with 3 neurons
	static int networkStructure[] = {2, 4, 1};
	
	static final int ITERATIONS = 10000;
	
	public static void main(String[] args) 
	{
		
		Network network = new Network(networkStructure, inputs);
		
		Interface frame = new Interface(outputValues, network);
		
		int nbIterations = 1;
		
		do
		{
			network.train(expectedValues);
			
			frame.display(outputValues);
			
//			System.out.println("* Debut nouvelle itération " + nbIterations + " *");
//			System.out.println("Output (0, 0) : " + outputValues[0]);
//			System.out.println("Output (0, 1) : " + outputValues[1]);
//			System.out.println("Output (1, 0) : " + outputValues[2]);
//			System.out.println("Output (1, 1) : " + outputValues[3]);
//			System.out.println("Global error : " + network.getGlobalError());
//			System.out.println("* Fin nouvelle itération *");
		} while (network.getGlobalError() < 0.1 && nbIterations++ < ITERATIONS);
	}
	
	public static void setOutputValues(double output[])
	{
		outputValues = output;
	}
}
