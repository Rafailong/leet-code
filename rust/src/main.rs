fn main() {
    println!("Hello, world!");

    // let mut nums = [1, 1, 2].to_vec();
    // let mut nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4].to_vec();
    // let k = remove_duplicates(&mut nums);

    // https://leetcode.com/problems/remove-element/
    let mut nums = [3, 2, 2, 3].to_vec();
    let val = 3;
    let k = remove_elements(&mut nums, val);
    println!("k = {}", k);
    println!("nums after removal: {:?}", nums);
}

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