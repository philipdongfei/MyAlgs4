#include <stdio.h>
#include <stdlib.h>

#define swap(a, b) { char *t = x[a];\
                    x[a]=x[b];x[b]=t;}
#define i2c(i) x[i][depth]
#define min(x, y) (x<y?x:y)
#define max(x, y) (x>y?x:y) 
#define MAX_LENGTH 256


void vecswap(int i, int j, int n, char *x[])
{
    while (n-- > 0){
        swap(i, j);
        i++;
        j++;
    }
}

void ssort1(char *x[], int n, int depth)
{
    int a, b, c, d, r, v;
    if (n <= 1)
        return;
    a = rand() % n;
    swap(0, a);
    v = i2c(0);
    a = b = 1;
    c = d = n-1;
    for (;;){
        while (b <= c && (r = i2c(b)-v) <= 0){
            if (r == 0) {swap(a, b); a++;}
            b++;
        }
        while (b <= c && (r = i2c(c)-v) >= 0){
            if (r == 0) {swap(c, d); d--;}
            c--;
        }
        if (b > c ) break;
        swap(b, c);
        b++;
        c--;
    }
    r = min(a, b-a); vecswap(0, b-r, r, x);
    r = min(d-c, n-d-1); vecswap(b, n-r, r, x);
    r = b-a; ssort1(x, r, depth);
    if (i2c(r) != 0)
        ssort1(x + r, a + n - d - 1, depth+1);
    r = d-c; ssort1(x+n-r, r, depth);
}

void ssort1main(char *x[], int n)
{
    for (int i = 0; i < n; i++)
        printf("%s  ", x[i]);
    printf("\nsort:\n");
    ssort1(x, n, 0);
}

int main(void)
{
    char *x[MAX_LENGTH] = {"jo", "vicent", "tom", "gigi", "lily",
                "susan", "peter", "bob", "ron", "jason", };
    //char **pX;
    //pX = (char**)&x;
    ssort1main(x, 10);

    for (int i = 0; i < 10; i++)
        printf("%s  ", x[i]);
    printf("\n");


    return 0;
}

