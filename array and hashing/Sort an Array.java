class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        heapify(nums);
        deleteAll(nums);
    }

    private void heapify(int[] nums) {
        int numsLength = nums.length;
        int leafStartIndex = numsLength / 2;
        for (int i = leafStartIndex - 1; i >= 0; i--) {
            applyHeapify(nums, i, numsLength);
        }
    }

    private void deleteAll(int[] nums) {
        int numsLength = nums.length;
        while (numsLength > 0) {
            swap(nums, 0, numsLength - 1);
            numsLength--;
            applyHeapify(nums, 0, numsLength);
        }
    }

    private void applyHeapify(int[] nums, int index, int numsLength) {
        while(index < numsLength) {
            int maxValue = nums[index];
            int leftChildIndex = 2 * index + 1;
            int rightChildIndex = 2 * index + 2;

            if (leftChildIndex < numsLength) {
                maxValue = Math.max(maxValue, nums[leftChildIndex]);
            }
            if (rightChildIndex < numsLength) {
                maxValue = Math.max(maxValue, nums[rightChildIndex]);
            }

            if (maxValue > nums[index]) {
                if (leftChildIndex < numsLength && maxValue == nums[leftChildIndex]) {
                    swap(nums, index, leftChildIndex);
                    index = leftChildIndex;
                } else if (rightChildIndex < numsLength && maxValue == nums[rightChildIndex]) {
                    swap(nums, index, rightChildIndex);
                    index = rightChildIndex;
                }
            } else {
                break;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}