package com.leetcode.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Created by liwentian on 2017/9/3.
 */

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Arrays.asList(0);
        }
        Set<Integer>[] sets = new HashSet[n];
        for (int i = 0; i < n; i++) {
            sets[i] = new HashSet<>();
        }
        for (int[] edge : edges) {
            sets[edge[0]].add(edge[1]);
            sets[edge[1]].add(edge[0]);
        }
        List<Integer> leaves = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (sets[i].size() == 1) {
                leaves.add(i);
            }
        }
        while (n > 2) {
            n -= leaves.size();
            List<Integer> newLeaves = new LinkedList<>();
            for (Integer k : leaves) {
                int m = sets[k].iterator().next();
                sets[k].clear();
                sets[m].remove(k);
                if (sets[m].size() == 1) {
                    newLeaves.add(m);
                }
            }
            leaves = newLeaves;
        }
        return leaves;
    }
}
