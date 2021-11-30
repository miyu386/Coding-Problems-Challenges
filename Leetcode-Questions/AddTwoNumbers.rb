# Definition for singly-linked list.
# class ListNode
#     attr_accessor :val, :next
#     def initialize(val = 0, _next = nil)
#         @val = val
#         @next = _next
#     end
# end
# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
    nodeOne=l1
    nodeTwo=l2
    extra=0
    headVal = nodeOne.val + nodeTwo.val
    
    if headVal > 9
       carry = 1 
       headVal -= 10
    end
    
    sumNode = ListNode.new(headVal)
    curr = sumNode
    nodeOne = nodeOne.next
    nodeTwo = nodeTwo.next

    while nodeOne!=nil || nodeTwo!=nil || carry==1
        localSum = 0
        if carry==1
            localSum = 1
        end
        carry = 0

        if nodeOne!=nil
          localSum += nodeOne.val
          nodeOne = nodeOne.next
        end

        if nodeTwo!=nil
          localSum += nodeTwo.val
          nodeTwo = nodeTwo.next
        end

        if localSum > 9
          localSum = localSum - 10
          carry = 1
        end

        curr.next = ListNode.new(localSum)
        curr = curr.next

    end 

    return sumNode
        
end