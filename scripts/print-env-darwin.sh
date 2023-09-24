#!/bin/bash

sysctl -a | grep -E 'FMA|AVX2' || true