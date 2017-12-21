#!/bin/sh
fly -t home sp -p webflux-fn-blank \
    -c `dirname $0`/pipeline.yml \
    -l `dirname $0`/credentials.yml