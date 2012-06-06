java -Xmx4g -cp 'lib/*;dist/twitter-corpus-tools-0.0.1.jar' com.twitter.corpus.download.AsyncJsonStatusBlockCrawler -data %1 -output %1.gz
