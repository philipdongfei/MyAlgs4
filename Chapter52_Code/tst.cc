#include <stdio.h>
#include <stdlib.h>
#include <string.h>

typedef struct tnode *Tptr;
typedef struct tnode {
    char splitchar;
    Tptr lokid, eqkid, hikid;
} Tnode;

char *srcharr[100000];
int srchtop, nodecnt;
Tptr root = 0;

int search1(char *s)
{
    Tptr p = 0;
    p = root;
    while (p){
        if (*s < p->splitchar)
            p = p->lokid;
        else if (*s == p->splitchar){
            if (*s++ == 0)
                return 1;
            p = p->eqkid;

        } else
            p = p->hikid;
    }
    return 0;
}

Tptr insert1(Tptr p, char *s)
{
    if (p == 0){
        p = (Tptr)malloc(sizeof(Tnode));
        p->splitchar = *s;
        p->lokid = p->eqkid = p->hikid = 0;
    }
    if (*s < p->splitchar)
        p->lokid = insert1(p->lokid, s);
    else if (*s == p->splitchar){
        if (*s != 0)
            p->eqkid = insert1(p->eqkid, ++s);
    } else
        p->hikid = insert1(p->hikid, s);
    return p;
}

void pmsearch(Tptr p, char *s)
{
    if (!p) return;
    nodecnt++;
    if (*s == '.' || *s < p->splitchar)
        pmsearch(p->lokid, s);
    if (*s == '.' || *s == p->splitchar)
        if (p->splitchar && *s)
            pmsearch(p->eqkid, s+1);
    if (*s == 0 && p->splitchar == 0)
        srcharr[srchtop++] = 
            (char*)p->eqkid;
    if (*s == '.' || *s > p->splitchar)
        pmsearch(p->hikid, s);
}

void nearsearch(Tptr p, char *s, int d)
{
    if(!p || d < 0) return;
    nodecnt++;
    if (d > 0 || *s < p->splitchar)
        nearsearch(p->lokid, s, d);
    if (p->splitchar == 0){
        if ((int)strlen(s) < d)
            srcharr[srchtop++] = 
                (char*)p->eqkid;
    } else
        nearsearch(p->eqkid, *s ? s+1 : s,
                (*s == p->splitchar) ? d : d-1);
    if (d > 0 || *s > p->splitchar)
        nearsearch(p->hikid, s, d);
}


int main(void)
{
    char s, a;
    for (int i = 0; i < 10; i++)
    {
        scanf("%c", &s);
        root = insert1(root, &s);
    }
    nodecnt = 0;
    printf("find: ");
    scanf("%c", &a);
    if (search1(&a) == 1)
        printf("true\n");
    else
        printf("false\n");

    return 0;
}
