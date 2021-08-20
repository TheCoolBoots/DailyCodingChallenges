class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        
        numnums = len(nums1) + len(nums2)

        newArray = []

        nums1Index = 0
        nums2Index = 0
        
        for i in range(0, numnums - 1):
            if(nums1[nums1Index] < nums2[nums2Index] and (nums1Index + 1) < len(nums1)):
                newArray.append(nums1[nums1Index])
                nums1Index += 1
            else:
                newArray.append(nums2[nums2Index])
                nums2Index += 1

        if numnums % 2 == 0:
            return (newArray[numnums//2] + newArray[numnums//2 - 1])/2
        else:
            return newArray[numnums//2]
            
                

        