mod remove_elements {
    // https://leetcode.com/problems/remove-element/
    pub fn remove_element(nums: &mut Vec<i32>, val: i32) -> i32 {
        let mut nums_size = nums.len();
        let mut i = 0;
        while i < nums_size {
            if nums[i] == val {
                nums.remove(i);
                nums_size -= 1;
            } else {
                i += 1;
            }
        }

        i as i32
    }

    #[cfg(test)]
    mod test {
        use super::*;

        #[test]
        fn test_first() {
            let mut numbers = [3, 2, 2, 3].to_vec();
            let val = 3;
            let k = remove_element(&mut numbers, val);
            assert_eq!(2, k);
        }
    }
}