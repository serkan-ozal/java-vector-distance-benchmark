package net.sozal.benchmark.vector.distance;

/**
 * @author sozal
 */
public interface VectorDistanceCalculator {

    // https://en.wikipedia.org/wiki/Cosine_similarity
    double cosineSimilarity(float[] v1, float[] v2);

    // https://en.wikipedia.org/wiki/Dot_product
    double dotProduct(float[] v1, float[] v2);

    // https://en.wikipedia.org/wiki/Taxicab_geometry
    // Aka L1 distance
    double manhattanDistance(float[] v1, float[] v2);

    // https://en.wikipedia.org/wiki/Euclidean_distance
    // Aka L2 distance
    double euclideanDistance(float[] v1, float[] v2);

}
