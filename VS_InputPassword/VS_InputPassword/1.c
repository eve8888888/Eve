#define _CRT_SECURE_NO_WARNINGS 1
#include<stdio.h>
#include<stdlib.h>
int main() {
	char password[20] = "123456";
	int n = 3;
	char pwd[20] = "";
	for (int i = 0; i < 3;i++){
		printf("���������룺(ʣ��%d��)\n", 2 - i);
		scanf("%s", pwd);
		if (strcmp(pwd, password) != 0) {
			
			if (i == 2) {
				printf("�Ѿ�����3�Σ��˳�����\n");
				break;
			}
			printf("����������������룺\n");
		}
		else 
		{
			printf("������ȷ��\n");
			break;
		}

	}
	system("pause");
	return 0;
}
