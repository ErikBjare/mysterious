#!/bin/bash

ant &&
java -cp "../lib/beaver-rt.jar:ant-bin" lang.ActualCompiler testfiles/assembly/$1.c > testfiles/assembly/$1.s &&
as testfiles/assembly/$1.s -o testfiles/assembly/$1.o &&
ld testfiles/assembly/$1.o -o testfiles/assembly/$1.elf
./testfiles/assembly/$1.elf
exit $?
