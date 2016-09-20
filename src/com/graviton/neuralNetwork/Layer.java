package com.graviton.neuralNetwork;

import java.util.ArrayList;

public class Layer 
{
	public ArrayList<Neuron> neurons;
	
	public Layer()
	{
		neurons = new ArrayList<Neuron>();
	}
	
	public void addNeuron(Neuron neuron)
	{
		this.neurons.add(neuron);
	}
	
	public void removeNeuron()
	{
		this.neurons.remove(this.neurons.size() - 1);
	}
	
	public void injectionInputsInCurrentLayer(Layer previousLayer)
	{
		ArrayList<Neuron> neuronPreviousLayer = previousLayer.neurons;
		
		// Pour chaque neuron dans la couche actuelle on leur inject en entrée les outputs des neurons de la couche précédente
		for (Neuron currentNeuron : neurons)
		{
			for (int i = 0; i < neuronPreviousLayer.size(); i++)
			{
				currentNeuron.getInputs().set(i, neuronPreviousLayer.get(i));
			}
			System.out.println("---");
		}
	}
	
	public void computeLocalError(Layer forwardLayer)
	{
		// Pour chaque neuron de la couche actuelle, on calcul somme les erreurs de la couche suivante
		for (int i = 0; i < this.neurons.size(); i++)
		{
			double newLocalError = 0;
			
			//For each neurons of the forward layer
			for (Neuron forwardNeuron : forwardLayer.neurons)
			{
				newLocalError += forwardNeuron.getSynapses().get(i) * forwardNeuron.getLocalError();
				System.out.println("local error : " + newLocalError);
			}
			this.neurons.get(i).setLocalError(newLocalError);
		}
	}
	
	public void updatingWeights()
	{
		for (Neuron currentNeuron : this.neurons)
		{
			currentNeuron.updatingWeight();
		}
	}


	/*
	 * 		GET & SET
	 */
	
	public ArrayList<Neuron> getNeurons() {
		return neurons;
	}

	public void setNeurons(ArrayList<Neuron> neurons) {
		this.neurons = neurons;
	}
}









