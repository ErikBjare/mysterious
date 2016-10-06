#!/bin/bash

java -cp "../lib/beaver-rt.jar:ant-bin" lang.CallGraph $1 | dot -Tpdf -o $2
