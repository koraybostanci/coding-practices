package com.coding.challanges;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Collections.reverseOrder;
import static java.util.Map.Entry.comparingByValue;
import static java.util.stream.Collectors.toList;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Solution1 {

    static final Map<String, Integer> features = new HashMap<>();

    public ArrayList<String> popularNFeatures(int numFeatures,
                                              int topFeatures,
                                              List<String> possibleFeatures,
                                              int numFeatureRequests,
                                              List<String> featureRequests) {
        for (int i = 0; i < numFeatureRequests; i++) {
            extractFeatureRequest(featureRequests.get(i), possibleFeatures);
        }

        final List<String> result = features.entrySet().stream()
                .sorted(reverseOrder(comparingByValue()))
                .map(entry -> entry.getKey())
                .limit(topFeatures)
                .collect(toList());

        return new ArrayList<>(result);
    }

    private void extractFeatureRequest(final String featureRequest, final List<String> possibleFeatures) {
        if (featureRequest == null || featureRequest.equals("")) {
            return;
        }

        final List<String> usedWordsInQuote = new ArrayList<>();

        final String[] words = featureRequest.split(" ");
        for (final String word : words) {
            if (usedWordsInQuote.contains(word)) {
                continue;
            }
            if (possibleFeatures.contains(word)) {
                usedWordsInQuote.add(word);
                addOrUpdateFeature(word);
            }
        }
    }

    private void addOrUpdateFeature(final String featureName) {
        final int count = features.containsKey(featureName) ? features.get(featureName) + 1 : 1;
        features.put(featureName, count);
    }

    @Test
    void test1() {
        final List<String> possibleFeatures = asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        final List<String> featureRequests = asList(
                "Best services provided by anacell",
                "betacellular has great services",
                "anacell provides much better services than all other");

        final ArrayList<String> result = popularNFeatures(5,2, possibleFeatures
                              , 3, featureRequests);
        assertTrue(result.size() == 2);
    }

    @Test
    void test2() {
        final List<String> possibleFeatures = asList("anacell", "betacellular", "cetracular", "deltacellular", "eurocell");
        final List<String> featureRequests = asList(
                "I love anacell Best services provided by anacell in the town",
                "betacellular has great services",
                "deltacellular provides much better services than betacellular",
                "cetracular is worse than eurocell",
                "betacellular is better than deltacellular"
                );

        final ArrayList<String> result = popularNFeatures(5,2,possibleFeatures
                , 5, featureRequests);

        assertTrue(result.size() == 2);
    }

}

