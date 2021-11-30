# @param {Integer[]} nums
# @param {Integer} target
# @return {Integer[]}
def search_range(nums, target)
    
    start_index = 0
    end_index = nums.length - 1
    output = []
    
    while start_index < nums.length
        if nums[start_index] == target
            output[0] = start_index
            break
        end
        start_index += 1
    end
    
    while end_index >= 0
        if nums[end_index] == target
            output[1] = end_index
            break
        end
        end_index -= 1
    end
    
    output.empty? ? [-1, -1] : output
    
end