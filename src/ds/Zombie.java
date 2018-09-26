package ds;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.plaf.InputMapUIResource;

public class Zombie {
	
	/*
     * Complete the function below.
     */
	static int zombieCluster(String[] zombies) {
    	int count = 0;
    	int[][] inputMatrix = getMatrix(zombies);
    	int size = zombies.length;
    	Set<Integer> cluster = new HashSet<>();
    	cluster.add(0);
    	for (int i = 0; i < size; i++) {
    		boolean matched = false;
    		for (int j = 0; j < size; j++ ) {
    			int value = inputMatrix[i][j];
    			if (value == 1 && !cluster.contains(j)) {
    				if (i != j || cluster.size() == 0) {
    					cluster.add(j);
    					matched = true;
    				}
    			}
    		}
    		if (!matched) {
    			count ++;
    			cluster = new HashSet<>();
    			cluster.add(i + 1);
    		}
    	}
    	return count;
    }
    
    static int[][] getMatrix (String[] zombies) {
    	int size = zombies.length;
    	int[][] matrix = new int[size][size];
    	for (int i = 0; i < size; i++) {
            String[] currentLine = zombies[i].split("");
            for (int j = 0; j < currentLine.length; j++) {
                matrix[i][j] = Integer.parseInt(currentLine[j]);
            }
        }
    	return matrix;
    }

	public static void main(String[] args) {
		String[] zombies = {"10000", "01000","00100" ,"00010", "00001"};
		System.out.println(zombieCluster(zombies));
	}
}
