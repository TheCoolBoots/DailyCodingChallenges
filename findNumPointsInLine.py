import math
import unittest
from typing import List


def maxPoints(points: List[List[int]]) -> int:
    if len(points) <= 1:
        return 0
    lines = getListOfLines(points)
    maxNumOnLine = 0
    for line in lines:
        current = getNumPtsOnLine(line[0], line[1], points)
        if current > maxNumOnLine:
            maxNumOnLine = current
    return maxNumOnLine


def getListOfLines(points: List[List[int]]) -> List[List[int]]:
    lines = set()
    for index, startPt in enumerate(points):
        for i in range(index + 1, len(points)):
            if (points[i][0] - startPt[0]) == 0:
                lines.add(('x', points[i][0]))
            else:
                m = (points[i][1] - startPt[1]) / (points[i][0] - startPt[0])
                b = startPt[1] - (m * startPt[0])
                lines.add((m, b))
    return lines


def getNumPtsOnLine(m, b, points):
    num = 0;
    if m == 'x':
        for point in points:
            if (point[0] == b):
                num += 1
    else:
        for point in points:
            temp1 = m * point[0]
            temp = (m * point[0] + b)
            if math.isclose(point[1], m * point[0] + b):
                num += 1;
    return num


class TestPointsOnLine(unittest.TestCase):

    def testBasic(self):
        self.assertEqual(maxPoints([[1, 2], [2, 3]]), 2)

    def testDoublePts(self):
        self.assertEqual(maxPoints([[1, 2], [1, 2], [2, 3]]), 3)

    def testManyLines(self):
        self.assertEqual(maxPoints([[1, 2], [2, 3], [3, 4], [0, 0], [1, 1]]), 3)

    def testEmpty(self):
        self.assertEqual(maxPoints([[]]), 0)  # no points means no lines means no points on a line

    def testSinglePt(self):
        self.assertEqual(maxPoints([[1, 2]]), 0)  # no lines means no points on a line

    def testNegativeSlope(self):
        self.assertEqual(maxPoints([[0, 0], [-1, -1], [-2, -2], [2, 3]]), 3)

    def testFloats(self):
        self.assertEqual(maxPoints([[1.1, 2.2], [2.2, 3.3], [3.3, 4.4], [0, 0], [1, 1]]), 3)
