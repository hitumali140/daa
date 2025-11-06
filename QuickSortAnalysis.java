
    import java.util.Random;
    
    public class QuickSortAnalysis {
        // Deterministic QuickSort
        public static void deterministicQuickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pivotIndex = partition(arr, low, high);
                deterministicQuickSort(arr, low, pivotIndex - 1);
                deterministicQuickSort(arr, pivotIndex + 1, high);
            }
        }
    
        // Randomized QuickSort
        public static void randomizedQuickSort(int[] arr, int low, int high) {
            if (low < high) {
                int pivotIndex = randomizedPartition(arr, low, high);
                randomizedQuickSort(arr, low, pivotIndex - 1);
                randomizedQuickSort(arr, pivotIndex + 1, high);
            }
        }
    
        // Partition function for deterministic QuickSort
        private static int partition(int[] arr, int low, int high) {
            int pivot = arr[high];
            int i = low - 1;
            for (int j = low; j < high; j++) {
                if (arr[j] <= pivot) {
                    i++;
                    swap(arr, i, j);
                }
            }
            swap(arr, i + 1, high);
            return i + 1;
        }
    
        // Partition function for randomized QuickSort
        private static int randomizedPartition(int[] arr, int low, int high) {
            Random rand = new Random();
            int randomPivotIndex = low + rand.nextInt(high - low + 1);
            swap(arr, randomPivotIndex, high);
            return partition(arr, low, high);
        }
    
        // Utility function to swap elements
        private static void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    
        // Function to print the array
        private static void printArray(int[] arr) {
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    
        public static void main(String[] args) {
            int[] arr = { 10, 7, 8, 9, 1, 5 };
            int n = arr.length;
            System.out.println("Original Array:");
            printArray(arr);
    
            // Deterministic QuickSort
            int[] deterministicArr = arr.clone();
            long startTime = System.nanoTime();
            deterministicQuickSort(deterministicArr, 0, n - 1);
            long endTime = System.nanoTime();
            System.out.println("Sorted Array using Deterministic QuickSort:");
            printArray(deterministicArr);
            System.out.println("Time taken by Deterministic QuickSort: " + (endTime - startTime) + " ns");
    
            // Randomized QuickSort
            int[] randomizedArr = arr.clone();
            startTime = System.nanoTime();
            randomizedQuickSort(randomizedArr, 0, n - 1);
            endTime = System.nanoTime();
            System.out.println("Sorted Array using Randomized QuickSort:");
            printArray(randomizedArr);
            System.out.println("Time taken by Randomized QuickSort: " + (endTime - startTime) + " ns");
        }
    }
    