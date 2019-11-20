#!/bin/bash

index=1000

echo "RunLength: "
java Rand2N $index | java RunLength - | java BinaryDump 32
echo "Huffman: "
java Rand2N $index | java Huffman - | java BinaryDump 32
echo "LZW: "
java Rand2N $index  | java LZW - | java BinaryDump 32
