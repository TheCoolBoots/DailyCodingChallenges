def constructSequence(num, lowerEnd, upperEnd):
    # WRITE YOUR CODE HERE
    # constructSequence(1, 1, 1) = -1
    # constructSequence(2, 0, 1) = -1    if num < 3, -1
    # constructSequence(3, 0, 1) = [0, 1, 0]
    # constructSequence(4, 0, 1) = -1   if num > (range + 2), -1
    # constructSequence(11, 1, 9) = [10, 11, 10, 9 ...]
    # constructSequence(4, 0, 2) = [1, 2, 1, 0]
    # constructSequence(4, 0, 3) = [2, 3, 2, 1]
    # constructSequence(5, 0, 2) = [0, 1, 2, 1, 0]

    if num < 3:
        return [-1]

    7 0 3

    [3 2 1 0 - 1 - 2 - 3]
    [2 3 2 1 0 - 1 - 2]
    [1 2 3 2 1 0 - 1]
    [0 1 2 3 2 1 0]

    return [upperEnd-1] + list(range(upperEnd, upperEnd - num + 1, -1))


print(constructSequence(5, 0, 4))
print(constructSequence(4, 0, 2))
print(constructSequence(10, -1, 6))
templst = [1, 2, 3, 4]
print(templst[0: -1])
