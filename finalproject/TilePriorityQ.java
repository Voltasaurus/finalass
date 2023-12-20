package finalproject;

import java.util.ArrayList;
import java.util.Arrays;


import finalproject.system.Tile;

public class TilePriorityQ {
	// TODO level 3: Add fields that can help you implement this data type
	int size;
	Tile[] heap = new Tile[100];

	// TODO level 3: implement the constructor for the priority queue
	public TilePriorityQ (ArrayList<Tile> vertices) {
		for (Tile v : vertices) {
			add(v);
		}
	}

	public void add(Tile t) {
		size++;
		heap[size] = t;
		upHeap(size);
	}
	private void upHeap(int s) {
		int i = s;
		while (i > 1 && heap[i].costEstimate < heap[i/2].costEstimate) {
			Tile temp = heap[i];
			heap[i] = heap[i/2];
			heap[i/2] = temp;
			i = i/2;
		}
	}

	private void downHeap(int s, int m) {
		int i = s;
		while (2*i <= m) {
			int j = 2*i;
			if (j < m && heap[j].costEstimate > heap[j+1].costEstimate) {
				j++;
			}
			if (heap[i].costEstimate <= heap[j].costEstimate) {
				break;
			}
			Tile temp = heap[i];
			heap[i] = heap[j];
			heap[j] = temp;
			i = j;
		}
	}

	// TODO level 3: implement remove min as seen in class
	public Tile removeMin() {
		Tile min = heap[1];
		heap[1] = heap[size];
		size--;
		downHeap(1, size);
		return min;
	}
	
	// TODO level 3: implement updateKeys as described in the pdf
	public void updateKeys(Tile t, Tile newPred, double newEstimate) {
		int i = 1;
		while (i <= size) {
			if (heap[i] == t) {
				heap[i].predecessor = newPred;
				heap[i].costEstimate = newEstimate;
				break;
			}
			i++;
		}
		downHeap(i, size);
	}
	
}
