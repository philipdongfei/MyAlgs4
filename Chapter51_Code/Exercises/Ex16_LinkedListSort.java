import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Insertion;
import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.SeparateChainingHashST;
import edu.princeton.cs.algs4.DoublyLinkedList;
import java.util.Arrays;
import java.util.StringJoiner;

public class Ex16_LinkedListSort {
    public DoublyLinkedList<String>.DoubleNode sortLinkeList(DoublyLinkedList<String> doublyLinkedList){
        DoublyLinkedList<String>.DoubleNode lowNode = doublyLinkedList.getFirstNode();
        DoublyLinkedList<String>.DoubleNode highNode = doublyLinkedList.getLastNode();
        sortLinkedList(lowNode, highNode, 0, doublyLinkedList.size()-1, 0);
        return doublyLinkedList.getFirstNode();
    }
    
    private void sortLinkedList(DoublyLinkedList<String>.DoubleNode lowNode, DoublyLinkedList<String>.DoubleNode highNode, int lowIndex, int highIndex, int digit){
        if (lowIndex >= highIndex)
            return;

        DoublyLinkedList<String>.DoubleNode pivotNode = getPivotNode(lowNode, highNode, lowIndex, highIndex);

        exchange(lowNode, pivotNode);

        int pivot = charAt(lowNode.item, digit);

        DoublyLinkedList<String>.DoubleNode lowerThan = lowNode;
        DoublyLinkedList<String>.DoubleNode greaterThan = highNode;

        int lowerThanIndex = lowIndex;
        int greaterThanIndex = highIndex;

        DoublyLinkedList<String>.DoubleNode currentNode = lowNode.next;
        int index = lowIndex + 1;

        while (index <= greaterThanIndex){
            int currentChar = charAt(currentNode.item, digit);
            if (currentChar < pivot){
                exchange(lowerThan, currentNode);
                lowerThan = lowerThan.next;
                currentNode = currentNode.next;

                index++;
                lowerThanIndex++;
            } else if (currentChar > pivot){
                exchange(currentNode, greaterThan);
                greaterThan = greaterThan.previous;
                greaterThanIndex--;
            } else {
                currentNode = currentNode.next;
                index++;
            }
        }
        // Now linkedList[lowIndex..lowerThanIndex - 1] < pivot = linkedList[lowerThanIndex..greaterThanIndex]
        // < linkedList[greaterThanIndex + 1..highIndex]
        sortLinkedList(lowNode, lowerThan.previous, lowIndex, lowerThanIndex-1, digit);
        if (digit != -1){
            sortLinkedList(lowerThan, greaterThan, lowerThanIndex, greaterThanIndex, digit+1);

        }
        sortLinkedList(greaterThan.next, highNode, greaterThanIndex+1, highIndex, digit);
    }

    private DoublyLinkedList<String>.DoubleNode getPivotNode(DoublyLinkedList<String>.DoubleNode lowNode, DoublyLinkedList<String>.DoubleNode highNode, int lowIndex, int highIndex){
        int pivotIndex = StdRandom.uniform(lowIndex, highIndex+1);
        DoublyLinkedList<String>.DoubleNode currentNode;
        int middleIndex = lowIndex + (highIndex - lowIndex)/2;
        if (pivotIndex <= middleIndex){
            currentNode = lowNode;
            int count = lowIndex;

            while (count != pivotIndex){
                currentNode = currentNode.next;
                count++;
            }
        } else {
            currentNode = highNode;
            int count = highIndex;
            while (count != pivotIndex){
                currentNode = currentNode.previous;
                count--;
            }
        }
        return currentNode;
    }

    private void exchange(DoublyLinkedList<String>.DoubleNode node1, 
            DoublyLinkedList<String>.DoubleNode node2){
        String temp = node1.item;
        node1.item = node2.item;
        node2.item = temp;
    }
    private int charAt(String s, int digit){
        if (d < s.length())
            return s.charAt(digit);
        else
            return -1;
    }
    public static void main(String[] args){
        Ex16_LinkedListSort sort = new Ex16_LinkedListSort();
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<>();

        String[] a = StdIn.readAllStrings();
        for (String s : a){
            linkedList.insertAtTheEnd(s);
        }
        DoublyLinkedList<String>.DoubleNode nodeInSortedList = 
            sort.sortLinkedList(linkedList);

        StringJoiner sortedListStr = new StringJoiner(" ");
        while (nodeInSortedList != null){
            sortedListStr.add(nodeInSortedList.item);
            nodeInSortedList = nodeInSortedList.next;
        }
        StdOut.println("Sorted List: " + sortedListStr);
    }
}
