package com.graviton.neuralNetwork;

import java.util.ArrayList;

public class Layer 
{
	private Network network;
	public ArrayList<Neuron> neurons;
	
	public Layer(Network network)
	{
		neurons = new ArrayList<Neuron>();
		this.network = network;
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
		
		// Pour chaque neuron dans la couche actuelle on leur inject en entr�e les outputs des neurons de la couche pr�c�dente
		for (Neuron currentNeuron : neurons)
		{
			for (int i = 0; i < neuronPreviousLayer.size(); i++)
			{
				currentNeuron.getInputs().set(i, neuronPreviousLayer.get(i));
			}
			
			// Permet un affichage en temps r�el de l'�colution des output
			// Sinon instant et on ne voit rien
			// System.out.println("---");
		}
	}
	
	// [SC] FIXME - A revoir
	public void computeLocalError(Layer forwardLayer)
	{
//		// Pour chaque neuron de la couche actuelle, on calcul somme les erreurs de la couche suivante
//		for (int i = 0; i < this.neurons.size(); i++)
//		{
//			double newLocalError = Sigmoide.derivate(this.neurons.get(i).getOutput()) * forwardLayer.getNeurons().get(index);
//			
//			//For each neurons of the forward layer
//			for (Neuron forwardNeuron : forwardLayer.neurons)
//			{
//				newLocalError += Sigmoide.derivate(forwardNeuron.getSynapses().get(i)) * network.getGlobalError() * forwardNeuron.getLocalError();
//			}
//			
//			
//			this.neurons.get(i).setLocalError(newLocalError);
//			//System.out.println("...");
//		}
		double error;
		
		for (int i = 0; i < neurons.size(); ++i) {
			error = 0;
			for (int j = 0; j < forwardLayer.getNeurons().size(); ++j) {
				error += forwardLayer.getNeurons().get(j).getLocalError() *
						forwardLayer.getNeurons().get(j).getSynapses().get(i);
			}
			
			neurons.get(i).setLocalError(error);
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









