#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int* twoSum(int* nums, int numsSize, int target) {
	int* a[2] = { 0 };
	for (int i = 0; i<numsSize; i++) {
		for (int j = i + 1; j<numsSize; j++) {
			if (nums[j] == target - nums[i])
			{
				a[0] = i;
				a[1] = j;
			}
		}
	}
	return &a;
}
int main() {
	int a[] = { 2,7,11,15 };
	int *t = twoSum(&a,4, 9);
	printf("%d  %d", t[0], t[1]);
	system("pause");
}