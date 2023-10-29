usage:                  ## Show help
	@fgrep -h "##" $(MAKEFILE_LIST) | fgrep -v fgrep | sed -e 's/\\$$//' | sed -e 's/##//'

run-benchmark-1:         ## Run benchmark 1
	echo "Running benchmark 1 ..."
	mvn clean package jmh:benchmark -Djmh.benchmarks=.*Benchmark1

run-benchmark-2:         ## Run benchmark 2
	echo "Running benchmark 2 ..."
	mvn clean package jmh:benchmark -Djmh.benchmarks=.*Benchmark2

.PHONY: usage run-benchmark-1 run-benchmark-2
