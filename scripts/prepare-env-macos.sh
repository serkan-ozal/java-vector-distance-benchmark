#!/bin/bash

echo "Preparing environment ..."

if [ -z "${DYLD_LIBRARY_PATH}" ]; then
  echo "DYLD_LIBRARY_PATH=$(pwd)/hsdis" >> $GITHUB_ENV
else
  echo "DYLD_LIBRARY_PATH=${DYLD_LIBRARY_PATH}:$(pwd)/hsdis" >> $GITHUB_ENV
fi

echo "Prepared environment"
