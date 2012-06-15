#!/bin/bash
if [ $# -ne 1 ]; then
  echo "ERROR: No directory of dataset specified."
  echo "Usage: bin/easy_crawl.sh <dir>"
  exit 1
fi
if [ ! -f bin/export.sh ]; then
  echo "ERROR: Please execute this script from the root directory of twitter-corpus-tool."
  exit 1
fi

for f in $1/*.gz; do
  bin/export.sh $f
done

