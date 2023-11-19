#!/bin/bash

echo "Preparing environment ..."

if [ -z "${LD_LIBRARY_PATH}" ]; then
  echo "LD_LIBRARY_PATH=$(pwd)/hsdis" >> $GITHUB_ENV
else
  echo "LD_LIBRARY_PATH=${LD_LIBRARY_PATH}:$(pwd)/hsdis" >> $GITHUB_ENV
fi

echo "Prepared environment"
