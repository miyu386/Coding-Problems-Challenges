# @param {Integer[]} height
# @return {Integer}
def max_area(height)
    p1=0
    p2=height.size-1
    area=0
    
    while p1<p2
        h=[height[p1],height[p2]].min
        l=p2-p1
        area=[area,h*l].max
    
        if height[p1]<height[p2]
            p1+=1
        else
            p2-=1
        end 
    end
    area
end