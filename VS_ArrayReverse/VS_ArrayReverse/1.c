#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>

void init(int arr[],int size) {
	for (int i = 0; i < size; i++) {
		arr[i] = i;
	}
}

void empty(int arr[], int size) {
	for (int i = 0; i < size; i++) {
		arr[i] = 0;
	}
}
void reverse(int arr[],int size) {
	for (int i = 0; i < size / 2; i++) {
		int temp = arr[i];
		arr[i] = arr[size - i - 1];
		arr[size - i - 1] = temp;
	}
}
void output(int arr[], int size) {
	for (int i = 0; i < size; i++) {
		printf("%d ", arr[i]);
	}
	printf("\n");
}
int main() {
	int arr[7];
	init(arr, sizeof(arr) / sizeof(arr[0]));
	reverse(arr, sizeof(arr) / sizeof(arr[0]));
	output(arr, sizeof(arr) / sizeof(arr[0]));
	system("pause");
}