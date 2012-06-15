#!/bin/bash
if [ $# -ne 1 ]; then
  echo "ERROR: No directory of dataset specified."
  echo "Usage: bin/easy_crawl.sh <dir>"
  exit 1
fi
if [ ! -f bin/crawl.sh ]; then
  echo "ERROR: Please execute this script from the root directory of twitter-corpus-tool."
  exit 1
fi

for f in $1/*.txt; do
  bin/crawl.sh $f
  bin/extract.sh $f.seq
done

