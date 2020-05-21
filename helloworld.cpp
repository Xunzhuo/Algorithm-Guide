#include <stdio.h>
 
void alien_say (char * p)
{
while (putchar (*(p += *(p + 1) - *p)));
}
 
int main()
{
return alien_say ("BETHO! Altec oh liryom(a loadjudas!) dowd."), 0;
}