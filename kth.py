def kth(arr1, arr2, n, m, k):
 
    if n == 1 or m == 1:
        if m == 1:
            arr2, arr1 = arr1, arr2
            m = n
        if k == 1:
            return min(arr1[0], arr2[0])
        elif k == m + 1:
            return max(arr1[0], arr2[0])
        else:
            if arr2[k - 1] < arr1[0]:
                return arr2[k - 1]
            else:
                return max(arr1[0], arr2[k - 2])
 
    mid1 = (n - 1)//2
    mid2 = (m - 1)//2
 
    if mid1+mid2+1 < k:
        if arr1[mid1] < arr2[mid2]:
            return kth(arr1[mid1 + 1:], arr2, n - mid1 - 1, m, k - mid1 - 1)
        else:
            return kth(arr1, arr2[mid2 + 1:], n, m - mid2 - 1, k - mid2 - 1)
    else:
        if arr1[mid1] < arr2[mid2]:
            return kth(arr1, arr2[:mid2 + 1], n, mid2 + 1, k)
        else:
            return kth(arr1[:mid1 + 1], arr2, mid1 + 1, m, k)
 
 
if __name__ == "__main__":
    arr1 = [2, 3, 6, 7, 9]
    arr2 = [1, 4, 8, 10]
    k = 1
    print(kth(arr1, arr2, 5, 4, k))