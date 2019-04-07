import java.util.*;

class MinimumSwaps2 {

    static class DistanceContainer {
        final int value;
        final int index;
        final int distance;

        DistanceContainer(int value, int index) {
            this.value = value;
            this.index = index;
            this.distance = getDistance(value, index);
        }
    }

    // Complete the minimumSwaps function below.
    static int minimumSwaps(int[] arr) {
        int minimumSwaps = 0;

        Comparator<Integer> comparator = (d1, d2) -> d2 - d1;
        TreeMap<Integer, List<DistanceContainer>> distanceMap = new TreeMap<>(comparator);
        List<DistanceContainer> containers = new ArrayList<>(arr.length);

        for (int i = 0; i < arr.length; i++) {
            DistanceContainer dc = getDistanceContainer(arr[i], i);
            List<DistanceContainer> distanceList = distanceMap.getOrDefault(dc.distance, new LinkedList<>());
            distanceList.add(dc);
            distanceMap.put(dc.distance, distanceList);
            containers.add(dc);
        }

        DistanceContainer nextDC = getNextDistanceContainer(distanceMap, distanceMap.firstEntry());
        while (nextDC.distance > 0) {
            swapValue(nextDC, distanceMap, containers);
            minimumSwaps++;
            nextDC = getNextDistanceContainer(distanceMap, distanceMap.firstEntry());
        }

        return minimumSwaps;
    }

    private static DistanceContainer getNextDistanceContainer(TreeMap<Integer, List<DistanceContainer>> distanceMap,
                                                              Map.Entry<Integer, List<DistanceContainer>> entry) {
        List<DistanceContainer> distanceContainers = entry.getValue();
        if(distanceContainers.isEmpty()) {
            distanceMap.remove(entry.getKey());
            return getNextDistanceContainer(distanceMap, distanceMap.firstEntry());
        }
        return distanceContainers.get(0);
    }

    private static DistanceContainer getDistanceContainer(int value, int i) {
        return new DistanceContainer(value, i);
    }

    private static void swapValue(DistanceContainer sourceContainer, TreeMap<Integer, List<DistanceContainer>> treeMap,
                                  List<DistanceContainer> containerList) {
        int destValue = sourceContainer.value;
        int destIndex = destValue - 1;
        DistanceContainer destContainer = new DistanceContainer(destValue, destIndex);

        DistanceContainer containerAtDestIndex = containerList.get(destIndex);

        int swapIndex = sourceContainer.index;
        int sourceValue = containerAtDestIndex.value;
        DistanceContainer swappedContainer = new DistanceContainer(sourceValue, swapIndex);

        containerList.set(destIndex, destContainer);
        containerList.set(swapIndex, swappedContainer);

        updateTreeMap(treeMap, sourceContainer, destContainer);
        updateTreeMap(treeMap, containerAtDestIndex, swappedContainer);
    }

    private static void updateTreeMap(TreeMap<Integer, List<DistanceContainer>> treeMap,
                                      DistanceContainer source, DistanceContainer dest) {
        List<DistanceContainer> sourceList = treeMap.get(source.distance);
        if(sourceList != null) {
            sourceList.remove(source);
            if(sourceList.isEmpty()) {
                treeMap.remove(source.distance);
            }
        }
        List<DistanceContainer> destList = treeMap.getOrDefault(dest.distance, new LinkedList<>());
        destList.add(dest);
        treeMap.put(dest.distance, destList);
    }

    private static int getDistance(int value, int index) {
        return Math.abs(value - (index + 1));
    }

    public static void main(String[] args) {
        minimumSwaps(new int[]{2, 4, 1, 3, 7, 5, 6, 8});
    }
}
