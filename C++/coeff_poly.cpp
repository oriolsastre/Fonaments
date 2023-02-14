#include <iostream>
using namespace std;
int* coeff_poly(int n);

int main (){
	
	int n;
	bool seguir = true;
	char yn;
	while(seguir){
		cout << "Enter integer n to compute the coefficients of (x+y)^n: ";
		cin >> n;
		int* coeff = coeff_poly(n);
		for(int i=0;i<n+1;i++){
			cout << coeff[i] << '\n';
		}
		cout << "Do you want to compute more coefficeints? (y/n)" << '\n';
		cin >> yn;
		if(yn!='y'){
			cout << "Ok, bye!";
			seguir = false;
		}
	}
}

int* coeff_poly(int n){
	if(n==1){
		int* coeff = new int [2];
		coeff[0] = coeff[1] = 1;
		return coeff;
	} else {
		int* prev_coeff = coeff_poly(n-1);
		int* coeff = new int[n+1];
		coeff[0] = 1;
		for(int i=1;i<n;i++){
			coeff[i] = prev_coeff[i-1]+prev_coeff[i];
		}
		coeff[n] = 1;
		delete prev_coeff;
		return coeff;
	}
}

