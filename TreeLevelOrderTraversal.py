# Definition for a binary tree node.
import unittest
from typing import List

'''
given:
    3
   / \
  9  20
    /  \
   15   7

output:
[
  [3],
  [9,20],
  [15,7]
]
'''
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class MyTreeNode:
    def __init__(self, val=0, left=None, right=None, level=0):
        self.level = level
        self.val = val
        self.left = left
        self.right = right

    def __eq__(self, other):
        if self is None and other is None:
            return True
        return (self.val == other.val) and (self.left.__eq__(other.left)) and (self.right.__eq__(other.right))

# the required function for the Leetcode challenge
def level_order(root: TreeNode) -> List[List[int]]:

    # add a level variable to every node and enqueue new tree
    queue = [generate_my_tree(root)]
    output = []

    # break when there are no more elements in the queue
    while len(queue) != 0:

        # dequeue the first node in the queue
        curr = queue.pop(0)

        # skip if leaf node
        if curr is None:
            continue

        # enqueue the left and right children
        queue.append(curr.left)
        queue.append(curr.right)

        # if the level doesn't exist yet, create it in the output list
        try:
            output[curr.level].append(curr.val)
        except IndexError:
            output.append([curr.val])


def generate_my_tree(root: TreeNode, level=0) -> MyTreeNode:
    if root is None:
        return None
    return MyTreeNode(root.val, generate_my_tree(root.left, level+1), generate_my_tree(root.right, level+1), level)


class testTreeLevelOrderTraversal(unittest.TestCase):

    def testGenerateMyTree(self):
        self.assertTrue(generate_my_tree(TreeNode(3, TreeNode(2), TreeNode(5)))
                        == MyTreeNode(3, MyTreeNode(2), MyTreeNode(5)))
        pass

    def testListAdd(self):
        l1 = [1, 2, None, None, None, 3]
        l2 = []
        l2.insert(0, 1)
        l2.insert(1, 2)
        l2.insert(5, 3)
        self.assertEqual(l1, l2)