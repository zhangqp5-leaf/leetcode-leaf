function groupAnagrams(strs) {
  const _map = new Map();
  const res = [];
  let j = 0;
  for (let i = 0; i < strs.length; i++) {
    const _sorted = getSortRe(strs[i]);
    if (_map.has(_sorted)) {
      res[_map.get(_sorted)].push(strs[i]);
    } else {
      _map.set(_sorted, j);
      res[j] = [strs[i]];
      j = j + 1;
    }
  }
  return res;
};

function getSortRe(str) {
  let re = Array.from(str);
  re.sort();
  return re.toString();
}

const a = ["eat", "tea", "tan", "ate", "nat", "bat"];
console.log(groupAnagrams(a));