usage:                  ## Show help
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

run-benchmark-1:         ## Run benchmark 1
	echo "Running benchmark 1 ..."
	mvn clean package jmh:benchmark -Djmh.benchmarks=.*Benchmark1

.PHONY: usage run-benchmark-1
