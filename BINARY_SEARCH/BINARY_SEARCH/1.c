#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

int binarySearch(int* a,int val,int arr_size) {
	int left = 0;
	int right = arr_size - 1;
	int mid = 0;
	while (left <= right){
		mid = (right - left) / 2 + left;
		if (a[mid] > val ) {
			right = mid - 1;
		}
		else if(a[mid] < val){
			left = mid + 1;
		}
		else
		{
			return mid;
		}
	}
	return -1;
}
int main() {
	int b[] = { 1,2,3,4,5,6,7,8,9,10 };
	printf("%d\n", binarySearch(&b,11, sizeof(b) / sizeof(b[0])));
	system("pause");
	return 0;
}