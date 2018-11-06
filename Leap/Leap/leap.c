#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	for (int year = 1000; year <= 2000; year++) {
		if (is_leap(year)) {
			printf("%d ", year);
		}
	}
	system("pause");
}
int is_leap(int year) {
	if ((year % 4 == 0 && year % 100 != 0) || year % 400 ==0) {
		return 1;
	}
	else {
		return 0;
	}
}