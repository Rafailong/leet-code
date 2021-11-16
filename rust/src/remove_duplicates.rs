mod remove_duplicates {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        let mut nums_size = nums.len();

        // when nums is empty
        if nums_size == 0 { return 0; }

        // nums contains only 1 element
        if nums_size < 2 { return 1; }

        let mut i = 0;
        let mut j = 1;

        while j < nums_size {
            // println!("i = {}", i);
            // println!("j = {}", j);

            let a = nums[i];
            let b = nums[j];

            // println!("a = {}", a);
            // println!("b = {}", b);

            if a == b {
                // println!("nums before removal: {:?}", nums);
                nums.remove(j);
                nums_size -= 1;
                // println!("nums after removal: {:?}", nums);
            } else {
                i += 1;
                j += 1;
            }

            // println!("---------------------------")
        }

        j as i32
    }

    #[cfg(test)]
    mod test {
        use super::*;

        #[test]
        fn test_first() {
            let mut numbers = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4].to_vec();
            let k = remove_duplicates(&mut numbers);
            assert_eq!(5, k);
        }
    }
}