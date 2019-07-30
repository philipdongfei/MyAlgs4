objects:=*.out *.o
cflags:=-Wall -W -O2

ssort1: ssort1.cc
	g++ -o ssort1.out ${cflags} ssort1.cc
tst: tst.cc
	g++ -o tst.out ${cflags} tst.cc




.PHONY: clean
clean:
	-rm edit ${object}
	echo Clean done

