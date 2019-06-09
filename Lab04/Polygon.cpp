#include <iostream>
#include <cmath>

using namespace std;

int main()
{
	cout << "Program generuje punkty dla wielokatow wpisanych w kolo" << endl;
	cout << "-------------------------------------------------------" << endl << endl;
	int size, angle;
	double px1, py1, px, py;
	while(true)
	{
		cout << "Podaj promien kola: ";
		cin >> size;
		
		cout << "Podaj ilosc katow: ";
		cin >> angle;
		
		cout << "Wygenerowalem punkty: " << endl;
		px1 = size * cos(0);
		py1 = size * sin(0);
		
		cout << px1 << ", " << py1 << endl;
		for(int i = 1; i < angle; i++)
		{
			px = size * cos(i * 2 * M_PI / angle);
			py = size * sin(i * 2 * M_PI / angle);
			cout << px << ", " << py << endl;
		}
		cout << px1 << ", " << py1 << endl;
		cout << endl;
	}
}
