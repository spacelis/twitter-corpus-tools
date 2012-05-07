#!/bin/bash
java -cp 'lib/*:dist/twitter-corpus-tools-0.0.1.jar' com.twitter.corpus.demo.ReadStatuses -input $1 -dump -html
