package com.graviton.neuralNetwork;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Neuron extends JPanel
{
	// Les inputs de la couche précédente
	//public double inputs[];
	
	private ArrayList<Neuron> inputs;
	
	// Les synapses sont derrière les neurones dans cette version
	private ArrayList<Double> synapses; // Ou poids
	
	private double localError = 0;
	private double output = 0;
	private double computedSum = 0;
	
	private boolean isInput = false;

	private Rectangle rectangle;
	private Point position;
	
	public Neuron(ArrayList<Neuron> inputs, Boolean isInput, Point position) 
	{
		this.inputs = inputs;
		this.isInput = isInput;

		// Graphical part - begin
		
		rectangle = new Rectangle(new Dimension(80, 30));
		this.position = position;
		
		// Graphical part - end
		
		if (inputs == null)
			return;
		
		// Si ce n'est pas un input, alors on lui ajout des synapses.
		if (!isInput)
		{
			int nombreDeSynapses = inputs.size();
			synapses = new ArrayList<Double>();
			
			for (int i = 0; i < nombreDeSynapses; i++)
			{
				double temp = 0;
				
				// [SC] - On établi les synapses entre [0.1, 0.9[ \ [4.5, 5.5[
				do {
					temp = 0.1d + Math.random() * 0.8d;
				} while (temp > 0.45 && temp < 0.55);
				
				System.out.println("Synapse  : " + temp);
				
				synapses.add(temp);
			}
		}
	}
	
	private void computeSum() 
	{
		double sumInputs = 0;
		for (int i = 0; i < inputs.size(); i++)
			sumInputs += inputs.get(i).output * synapses.get(i);
		
		computedSum = sumInputs;
	}
	
	public double getOutput() 
	{
		return output;
	}
	
	public void computeOutput() {
		computeSum();
		output = Sigmoide.output(computedSum);
	}
	
	// FIXME - il faut récupérer la synapse du neurone de devant
	//		input.get(i).output -> synapses de devant
	public void updatingWeight()
	{
		for (int i = 0; i < synapses.size(); i++) {
			
//			System.out.println("Output : " + inputs.get(i).getOutput());
			
			synapses.set(i, synapses.get(i) + Network.getLearningCoef() * localError * inputs.get(i).getOutput()
					* Sigmoide.derivate(output));
		}
	}
	
	public double getLocalError()
	{
		return this.localError;
	}
	
	public void setLocalError(double error)
	{
		this.localError = error;
	}
	
	public void setOutput(double output) {
		this.output = output;
	}
	
	public ArrayList<Double> getSynapses() {
		return synapses;
	}

	public void setSynapses(ArrayList<Double> synapses) {
		this.synapses = synapses;
	}

	public ArrayList<Neuron> getInputs() {
		return inputs;
	}

	public void setInputs(ArrayList<Neuron> inputs) {
		this.inputs = inputs;
	}
	
	/*
	 * 		GRAPHICAL PART
	 */

	public Rectangle setRectangleAt(Point point) {
		
		this.rectangle.setLocation(point);
		
		return this.rectangle;
	}

	public Point getPosition() {
		return position;
	}

	public void setPosition(Point position) {
		this.position = position;
	}

	public Rectangle getRectangle() {
		return rectangle;
	}

	public void setRectangle(Rectangle rectangle) {
		this.rectangle = rectangle;
	}
	
	/**
	 * 
	 * @param g
	 * @param point - Is the position of the top left corner of a neuron
	 */
	public void paintComponentDebug(Graphics g, int x, int y) {
		
		g.drawRect(rectangle.x + x, rectangle.y + y,
				rectangle.width, rectangle.height);
		
		g.drawString("" + output , rectangle.x + x + rectangle.width / 6, rectangle.y + y + rectangle.height / 2);
	}
	
	public void paintComponent(Graphics g) {
		
		if (this.isInput && inputs != null) {
			g.drawString("" + (int) inputs.get(0).getOutput(), position.x - 10, position.y + 10);
		}
		
		g.setColor(Color.GREEN);
		g.fillOval(position.x, position.y, 10, 10);
		
		if (inputs != null) {
			for (int i = 0; i < inputs.size(); ++i) {
				if (inputs.get(i).getPosition() != null)
					g.drawLine(position.x + 5 , position.y + 5, inputs.get(i).getPosition().x + 5, inputs.get(i).getPosition().y + 5);
			}
		}
		
		g.setColor(Color.black);
	}
}











