class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] nextGreater = new int[10001];

        for(int i = nums2.length-1; i >= 0; i--) {
            while(!stack.isEmpty() && stack.peek() <= nums2[i]) {
                stack.pop();
            }
            if(stack.isEmpty()) nextGreater[nums2[i]] = -1;
            else nextGreater[nums2[i]] = stack.peek();
            stack.push(nums2[i]);
        }

        for(int i=0; i<nums1.length; i++) {
            nums1[i] = nextGreater[nums1[i]];
        }

        return nums1;
    }
}
// Topics -> Stack, TC: O(n), SC: O(n), LC-496