#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
#include<math.h>

#define NUM 10
int a[NUM] = {0};
int sum = 0;
void output() {
	int k;
	for (k = 0; k < NUM; k++) {
		printf("%d  ", a[k]);
	}
	printf("\n");
}
int check1(int j, int i) {
	int k;
	for (k = 0; k <= i; k++) {
		if (a[k] == j) {
			return 0;
		}
	}
	return 1;
}
int check2(int x) {
	int k, n;
	n = sqrt(x);
	for (k = 2; k <= n; k++) {
		if (x % k == 0) {
			return 0;
		}
	}
	return 1;
}
int check3(int j, int i) {
	if (i != NUM -1) {
		return (check2(j + a[i - 1]));
	}
	else {
		return (check2(j + a[i - 1]) && check2(j + a[0]));
	}
}
void ttry(int i) {
	int k;
	for (k = 1; k <= NUM; k++) {
		if (check1(k, i) == 1 && check3(k, i) == 1) {
			a[i] = k;
			if (i == NUM - 1) {
				output();
				sum++;
			}
			else {
				ttry(i + 1);
			}
			a[i] = 0;
			
		}
	}
}


int main() {
	int k;
	a[0] = 1;
	ttry(1);
	printf("¹² %d ÖÖ\n", sum);
	system("pause");
	return 0;
}