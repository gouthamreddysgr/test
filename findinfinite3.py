def find_in_infinite_array(A, x):
    low = 0
    high = 1
    while A[high] == float('inf') or x > A[high]:
        low = high
        high *= 2
    while low <= high:
        mid = (low + high) // 2
        if A[mid] == x:
            return mid
        elif A[mid] < x:
            low = mid + 1
        else:
            high = mid - 1
        if A[low] == float('inf'):
            return -1
    return -1
print(find_in_infinite_array([5,6,7,9,10,13,15,20,23,'inf','inf','inf'], 20))