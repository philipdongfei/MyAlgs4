#!/bin/bash

var="a"
var1="abc"
var2="ab"
for index in 100 #1 2 3 4 5 100
do
    echo "#################################"
    echo "$index:$var: "
    echo "RunLength: "
    java NCopies $index $var | java RunLength - | java BinaryDump 32
    echo "Huffman: "
    java NCopies $index $var | java Huffman - | java BinaryDump 32
    echo "LZW: "
    java NCopies $index  $var| java LZW - | java BinaryDump 32

done

for index in 100 #1 2 3 4 5 100
do
    echo "#################################"
    echo "$index $var1: "
    echo "RunLength: "
    java NCopies $index $var1 | java RunLength - | java BinaryDump 32
    echo "Huffman: "
    java NCopies $index $var1 | java Huffman - | java BinaryDump 32
    echo "LZW: "
    java NCopies $index $var1 | java LZW - | java BinaryDump 32
done

for index in 100 #1 2 3 4 5 100
do
    echo "#################################"
    echo "$index $var2: "
    echo "RunLength: "
    java NCopies $index $var2 | java RunLength - | java BinaryDump 32
    echo "Huffman: "
    java NCopies $index $var2 | java Huffman - | java BinaryDump 32
    echo "LZW: "
    java NCopies $index  $var2| java LZW - | java BinaryDump 32
done



