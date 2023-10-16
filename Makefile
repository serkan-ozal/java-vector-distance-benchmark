usage:                  ## Show help
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

run-benchmarks:         ## Run all benchmarks
	echo "Running all benchmarks ..."
	mvn clean package jmh:benchmark

.PHONY: usage run-benchmarks
