#!/bin/bash
java -Xmx4g -cp 'lib/*:dist/twitter-corpus-tools-0.0.1.jar' com.twitter.corpus.download.AsyncHtmlStatusBlockCrawler -data $1 -output $1.seq
