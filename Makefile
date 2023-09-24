OS_NAME := $(shell uname -s | tr A-Z a-z)

usage:                  ## Show help
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

print-env:              ## Print environment info
	echo "Printing info for OS ${OS_NAME} ..."
	-@make print-env-${OS_NAME}

print-env-linux:        ## Print environment info for Linux
	./scripts/print-env-linux.sh

print-env-darwin:       ## Print environment info for MacOS
	./scripts/print-env-darwin.sh

run-benchmarks:         ## Run all benchmarks
	echo "Running all benchmarks ..."
	mvn clean package jmh:benchmark

.PHONY: usage run-benchmarks
