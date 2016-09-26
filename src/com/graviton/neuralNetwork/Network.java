package com.graviton.neuralNetwork;

import java.awt.Point;
import java.util.ArrayList;

public class Network 
{
	private ArrayList<Layer> layers = new ArrayList<Layer>();
	private double output = 0;
	private double globalError = 0;
	public double outputs[] = {0, 0, 0, 0};
	
	private static final double LEARNING_COEF = 0.4;
	
	private int positionDep = 80;
	private int distanceBtwNeurons = 20;
	
	public Network(int networkStructure[], double inputs[][]) 
	{
		System.out.println("Création network...");
		for (int i = 0; i < networkStructure.length; i++)
		{			
			if (i == 0)
			{
				this.addFirstLayer(inputs[i], i);
				System.out.println("Ajout first layer...");
			}
			else if (i == networkStructure.length - 1)
			{
				this.addLastLayer(i);
				System.out.println("Ajout last layer...");
			}
			else 
			{
				this.addHiddenLayer(networkStructure[i], i);
				System.out.println("Ajout hidden layer...");
			}
		}
	}
	
	
	public void addFirstLayer(double inputs[], int pos)
	{
		Layer temp = new Layer(this);
		
		for (int i = 0; i < inputs.length; i++)
		{
			// Utilisation d'un tableau pour simplification des calculs
//			ArrayList<Neuron> tab = new ArrayList<Neuron>();
//			tab.add(new Neuron(null, false, null));
//			tab.get(0).setOutput(inputs[i]);
			temp.addNeuron(new Neuron(null, true, new Point(pos * distanceBtwNeurons + positionDep, i * distanceBtwNeurons + positionDep)));
		}
		
		layers.add(temp);
	}
	
	public void addHiddenLayer(int tailleLayer, int pos)
	{
		Layer newLayer = new Layer(this);
		
		// Ajout du nombre de neuron correspondant
		for (int i = 0; i < tailleLayer; i++) {
			newLayer.addNeuron(new Neuron(layers.get(layers.size() - 1).getNeurons(), false, new Point(pos * distanceBtwNeurons + positionDep, i * distanceBtwNeurons + positionDep)));
		}
		
		this.layers.add(newLayer);
	}
	
	public void addLastLayer(int pos)
	{
		Layer newLayer = new Layer(this);
		
		newLayer.addNeuron(new Neuron(layers.get(layers.size() - 1).getNeurons(), false, new Point(pos * distanceBtwNeurons + positionDep, distanceBtwNeurons + positionDep)));
		
		this.layers.add(newLayer);
	}
	
	/*
	 * 	ACTION FONCTIONS
	 */
	
	public void train(double expectedValue[], double inputValues[][])
	{
		for (int i = 0; i < expectedValue.length; i++)
		{
			for (int j = 0; j < inputValues[i].length; ++j) {
				ArrayList<Neuron> input = new ArrayList<>();
				input.add(new Neuron(null, true, null));
				input.get(0).setOutput(inputValues[i][j]);
				layers.get(0).getNeurons().get(j).setInputs(input);
			}
			forwardPropagation(expectedValue[i]);
			this.outputs[i] = this.output;
			backPropagation();
		}
		
		Main.setOutputValues(outputs);
	}
	
	public void forwardPropagation(double expectedValue)
	{
		for (int i = 1; i < this.layers.size(); i++)
		{
			this.layers.get(i).injectionInputsInCurrentLayer(this.layers.get(i-1));
		}
		
		this.output = this.layers.get(this.layers.size() - 1).neurons.get(0).getOutput();
		this.globalError = expectedValue - output;
	}
	
	public void backPropagation()
	{
		// On établit l'erreur global du network
		this.layers.get(this.layers.size() - 1).neurons.get(0).setLocalError(globalError);
		
		// Pour toutes les couches sauf la denrière, on calcul l'erreur local
		for (int i = this.layers.size() - 2; i > 0; i--)
		{
			this.layers.get(i).computeLocalError(this.layers.get(i+1));
		}
		
		// Mise à jour des poids
		for (int i = 1; i < this.layers.size(); i++)
		{
			this.layers.get(i).updatingWeights();
		}
	}
	
	/*
	 * 	GETTEUR SETTER
	 */
	
	public double getGlobalError()
	{
		return this.globalError;
	}
	
	public double getOutput()
	{
		return this.output;
	}
	
	static public double getLearningCoef()
	{
		return LEARNING_COEF;
	}
	
	public ArrayList<Layer> getLayers() {
		return layers;
	}

	public void setLayers(ArrayList<Layer> layers) {
		this.layers = layers;
	}
	
	/*
	 * 		GRAPHICAL PART
	 */
	


	public void displayNetwork() {
		
	}
}
