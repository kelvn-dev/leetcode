**LeetCode is less about the number of problems you have solved and more about how many patterns you know.**
***
![](images/image.webp)

# Note

- binary: left <= right
- 2 pointer: left < right

capacity for lowercase letters: 26
capacity for digit: 10
capacity for alphanumeric characters: 26 + 26 + 10
capacity for standard ascii: 128
capacity for extended ascii: 128 * 2

# Problems to learn by heart

## RotateArray

Rotating an array is actually reversing parts of the array

Steps:
- Reverse the whole array
- Reverse the first k elements
- Reverse the remaining n-k elements

![](images/RotateArray.png)

## RotateImage

Steps:
- Transpose (chuyển vị):
  - Draw a line down diagonal (Vẽ một đường chéo xuống)
    ![](images/RotateImage-diagonal.png)
  - Swap symmetrical elements ([i][j] -> [j][i])
    ![](images/RotateImage-symmetrical-swap.png)
- Reverse each row

## FindPeakElement & FindMinimumInRotatedSortedArray

These 2 problems is contrasting