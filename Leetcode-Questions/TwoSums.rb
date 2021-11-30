# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def two_sum(nums, target)
  table = {}
  nums.each_with_index do |num, index|
    n = target - num
    if table.include?(n)
      return [table[n], index]
    else
      table[num] = index
    end
  end
end