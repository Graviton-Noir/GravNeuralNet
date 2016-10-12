package com.graviton.neuralNetwork;

public class Main 
{	
	static double inputs[][] = {{0, 0}, {0, 1}, {1, 0}, {1, 1}};
	static double expectedValues[] = {0, 1, 1, 0};
	static double outputValues[] = {0.0d, 0.0d, 0.0d, 0.0d};
	//One hidden layer with 3 neurons, could be {3, 3} : 2 layers with 3 neurons
	static int networkStructure[] = {2, 3, 1};
	
	static final int ITERATIONS = 20000;
	
	public static void main(String[] args) 
	{
		
		Network network = new Network(networkStructure, inputs);
		
		Interface frame = new Interface(outputValues, network);
		GraphFrame graph = new GraphFrame(network, ITERATIONS, frame);
		
		int nbIterations = 1;
		
		do
		{
			
			network.train(expectedValues, inputs, frame, outputValues);
			
//			frame.display(outputValues);
			graph.display(nbIterations);
			
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} while ((network.getGlobalError() > 0.05 || network.getGlobalError() < -0.05) &&
				nbIterations++ < ITERATIONS);
	}
	
	public static void setOutputValues(double output[])
	{
		outputValues = output;
	}
}
