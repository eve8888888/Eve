#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<math.h>
int main() {
	int count = 0;
	for (int i = 101; i <= 200; i+=2) {
		if (is_prime(i)) {
			count++;
			printf("%d ", i);
		}
	}
	printf("\n¹²%d¸ö\n", count);
	system("pause");
}
int is_prime(int num) {
	for (int i = 2; i <= sqrt(num); i++) {
		if (num % i == 0) {
			return 0;
		}
	}
	return 1;
}