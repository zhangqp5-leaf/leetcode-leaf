const nums = [100,4,200,1,3,2];
const longNums = [0,3,7,2,5,8,4,6,0,1]

/**
 * @param {number[]} nums
 * @return {number}
 */
var longestConsecutive = function(nums) {
  if (!nums.length) {
    return 0;
  }
  const numSet = new Set(nums);
  let re = 1;
  for (const num of numSet) {
    if (!numSet.has(num + 1)) {
      let currentRe = 1, currentNum = num - 1;
      while(numSet.has(currentNum)) {
        currentRe += 1;
        currentNum -= 1;
      }

      re = Math.max(re, currentRe);
    }
  }
  return re;
};

longestConsecutive(nums);
console.log(longestConsecutive(nums));
console.log(longestConsecutive(longNums));