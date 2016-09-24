#!/bin/bash

function test_subproj {
    cd ./$1
    ant test
    cd ..
}

test_subproj "A1-CalcParse"
test_subproj "A1-MiniS"
test_subproj "A2-CalcAST"
test_subproj "A2-MinimalAST"
test_subproj "A3-CalcComp"
test_subproj "A3-MinTree"
test_subproj "A4-CalcRAG"
