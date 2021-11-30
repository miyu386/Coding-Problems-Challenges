# @param {String} s
# @return {Integer}
def length_of_longest_substring(s) 
    max = 0
    start_index = -1
    map = {}
    
    s.chars.each_with_index do |c, i|
        
        if current_index=map[c] and current_index > start_index 
            start_index = current_index
        end
        
        map[c] = i
        new_length = i - start_index
        max = new_length if max < new_length
        
    end
    max
end