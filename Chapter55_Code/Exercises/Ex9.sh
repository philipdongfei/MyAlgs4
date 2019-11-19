#!/bin/bash

var="a"
var1="abc"
var2="ab"
for index in 100 #1 2 3 4 5 100
do
    echo "#################################"
    echo "$index:$var: "
    echo "RunLength: "
    java NCopies $index | java RunLength - | java BinaryDump 32
    echo "Huffman: "
    java NCopies $index | java Huffman - | java BinaryDump 32
    echo "LZW: "
    java NCopies $index | java LZW - | java BinaryDump 32

done



#echo "Shell over.."


