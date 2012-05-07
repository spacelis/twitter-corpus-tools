#!/bin/bash
java -Xmx4g -cp 'lib/*:dist/twitter-corpus-tools-0.0.1.jar' com.twitter.corpus.download.VerifyHtmlStatusBlockCrawl -data $1 -statuses_input $1.seq -statuses_repaired $1.repaired.seq -output_success log.success -output_failure log.failure
