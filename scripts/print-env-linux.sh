#!/bin/bash

cat /proc/cpuinfo | grep -E 'fma|avx2' || true