/*
 *  Clase creada usando OpenIA.

 */
package ufps.util.varios.graficador;

import java.util.Vector;
import ufps.util.colecciones_seed.NodoBin;

/**
 * Clase basada en código generado por OpenIA.
 * Sólo se adapta al contexto de SEED
 * @author gpt 4.0
 */
public class BinaryTreeBuilder {
    private int preIndex = 0;

    public NodoBin buildTree(String preOrderStr, String inOrderStr) {
        // Convert the input strings to vectors
        Vector<Integer> preOrder = new Vector<>();
        Vector<Integer> inOrder = new Vector<>();

        for (String val : preOrderStr.split(",")) {
            preOrder.add(Integer.parseInt(val));
        }
        for (String val : inOrderStr.split(",")) {
            inOrder.add(Integer.parseInt(val));
        }

        return buildTreeHelper(preOrder, inOrder, 0, inOrder.size() - 1);
    }

    private NodoBin buildTreeHelper(Vector<Integer> preOrder, Vector<Integer> inOrder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }

        // Pick current node from preOrder traversal using preIndex and increment preIndex
        int rootValue = preOrder.get(preIndex++);
        NodoBin root = new NodoBin(rootValue);

        // If this node has no children, then return
        if (inStart == inEnd) {
            return root;
        }

        // Else find the index of this node in inOrder traversal
        int inIndex = inOrder.indexOf(rootValue);

        // Using index in inOrder traversal, construct left and right subtrees
        root.setIzq( buildTreeHelper(preOrder, inOrder, inStart, inIndex - 1));
        root.setDer( buildTreeHelper(preOrder, inOrder, inIndex + 1, inEnd));

        return root;
    }

    public static void main(String[] args) {
        BinaryTreeBuilder builder = new BinaryTreeBuilder();
        String preOrderStr = "1,2,3";
        String inOrderStr = "3,2,1";
        NodoBin root = builder.buildTree(preOrderStr, inOrderStr);
        BTreePrinter.printNode(root);
        // Output the tree or test the tree
        
    }

   
}
