mod str_str {
    // https://leetcode.com/problems/implement-strstr/
    pub fn str_str(haystack: String, needle: String) -> i32 {
        haystack.find(needle.as_str())
            .map(|uz| uz as i32)
            .unwrap_or(-1)
    }

    #[cfg(test)]
    mod test {
        use super::*;

        #[test]
        fn test_first() {
            let haystack = String::from("hello");
            let needle = String::from("ll");
            assert_eq!(str_str(haystack, needle), 2);
        }
    }
}