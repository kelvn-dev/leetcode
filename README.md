**LeetCode is less about the number of problems you have solved and more about how many patterns you know.**
***
![](images/image.webp)

# Note

- Normal binary: left <= right
- Modified binary: left < right
- 2 pointer: left < right

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