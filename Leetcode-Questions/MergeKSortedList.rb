# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode[]} lists
# @return {ListNode}
def merge_k_lists(lists)
    nodes = []
    lists.each do |i|
        while i
            nodes << i
            i = i&.next
        end
    end

    nodes = nodes.sort_by(&:val)
    dummy = curr_node = ListNode.new()
    nodes.each do |node|
        curr_node.next = node
        curr_node = curr_node.next
    end

    dummy.next
    
end