package net.sozal.benchmark.vector.distance.impl;

import net.sozal.benchmark.vector.distance.VectorDistanceCalculator;

/**
 * @author sozal
 */
public class FMAVectorDistanceCalculator implements VectorDistanceCalculator {

    @Override
    public double cosineSimilarity(float[] v1, float[] v2) {
        double dotProd = 0.0;
        double v1SqrSum = 0.0;
        double v2SqrSum = 0.0;
        for (int i = 0; i < v1.length; i++) {
            dotProd = Math.fma(v1[i], v2[i], dotProd);
            v1SqrSum = Math.fma(v1[i], v1[i], v1SqrSum);
            v2SqrSum = Math.fma(v2[i], v2[i], v2SqrSum);
        }
        return dotProd / (Math.sqrt(v1SqrSum) * Math.sqrt(v2SqrSum));
    }

    @Override
    public double dotProduct(float[] v1, float[] v2) {
        float dotProd = 0f;
        for (int i = 0; i < v1.length; i++) {
            dotProd = Math.fma(v1[i], v2[i], dotProd);
        }
        return dotProd;
    }

    @Override
    public double manhattanDistance(float[] v1, float[] v2) {
        // Does not actually leverage Math.fma.
        double sumAbsDiff = 0.0;
        for (int i = 0; i < v1.length; i++) {
            sumAbsDiff += Math.abs(v1[i] - v2[i]);
        }
        return sumAbsDiff;
    }

    @Override
    public double euclideanDistance(float[] v1, float[] v2) {
        double sumSqrDiff = 0.0;
        float diff;
        for (int i = 0; i < v1.length; i++) {
            diff = v1[i] - v2[i];
            sumSqrDiff = Math.fma(diff, diff, sumSqrDiff);
        }
        return Math.sqrt(sumSqrDiff);
    }

}
