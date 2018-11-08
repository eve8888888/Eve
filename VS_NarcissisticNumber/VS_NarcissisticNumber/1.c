#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int is_NarcissisticNumber(int i) {
	int sum = 0;
	int n = i;
	while (n >= 1) {
		int re = (n % 10) *  (n % 10) * (n % 10);
		sum += re;
		n = n / 10;
	}
	if (sum == i) {
		return 1;
	}	
	else
	{
		return 0;
	}
	
}

int main() {
	for (int i = 0; i <= 999; i++) {
		if(is_NarcissisticNumber(i) == 1)
			printf("%d  ", i);
	}
	system("pause");
	return 0;
}