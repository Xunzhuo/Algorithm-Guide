#include "stdio.h"
#include "string.h"
#define maxn 200002

int wa[maxn],wb[maxn],wv[maxn],ws[maxn];
int cmp(int *r,int a,int b,int l)
{return r[a]==r[b]&&r[a+l]==r[b+l];}
void da(int *r,int *sa,int n,int m)
{
     int i,j,p,*x=wa,*y=wb,*t;
     for(i=0;i<m;i++) ws[i]=0;
     for(i=0;i<n;i++) ws[x[i]=r[i]]++;
     for(i=1;i<m;i++) ws[i]+=ws[i-1];
     for(i=n-1;i>=0;i--) sa[--ws[x[i]]]=i;
     for(j=1,p=1;p<n;j*=2,m=p)
     {
       for(p=0,i=n-j;i<n;i++) y[p++]=i;
       for(i=0;i<n;i++) if(sa[i]>=j) y[p++]=sa[i]-j;
       for(i=0;i<n;i++) wv[i]=x[y[i]];
       for(i=0;i<m;i++) ws[i]=0;
       for(i=0;i<n;i++) ws[wv[i]]++;
       for(i=1;i<m;i++) ws[i]+=ws[i-1];
       for(i=n-1;i>=0;i--) sa[--ws[wv[i]]]=y[i];
       for(t=x,x=y,y=t,p=1,x[sa[0]]=0,i=1;i<n;i++)
       x[sa[i]]=cmp(y,sa[i-1],sa[i],j)?p-1:p++;
     }
     return;
}
int rank[maxn],height[maxn];
void calheight(int *r,int *sa,int n)
{
     int i,j,k=0;
     for(i=1;i<=n;i++) rank[sa[i]]=i;
     for(i=0;i<n;height[rank[i++]]=k)
     for(k?k--:0,j=sa[rank[i]-1];r[i+k]==r[j+k];k++);
     return;
}

int r[maxn],sa[maxn];
char s[maxn];
int f[maxn];
int a[maxn],b[maxn],c;
long long ss,ans;
int main()
{
    int i,k,l,n,t;
    scanf("%d",&k);
    while(k!=0)
    {
      scanf("%s",s);
      l=strlen(s);
      s[l]=1;
      scanf("%s",s+l+1);
      n=strlen(s);
      for(i=0;i<n;i++) r[i]=s[i];
      r[n]=0;
      da(r,sa,n+1,128);
      calheight(r,sa,n);
      for(i=2;i<=n;i++)
      {
        f[i]=sa[i]<l;
        height[i]-=k-1;
        if(height[i]<0) height[i]=0;
      }
      height[n+1]=0;
      a[0]=-1;ans=0;
      for(t=0;t<=1;t++)
      for(c=0,ss=0,i=2;i<=n;i++)
      {
        if(f[i]!=t) ans+=ss;
        c++;
        a[c]=height[i+1];
        b[c]=f[i]==t;
        ss+=(long long)a[c]*b[c];
        while(a[c-1]>=a[c])
        {
          ss-=(long long)(a[c-1]-a[c])*b[c-1];
          a[c-1]=a[c];
          b[c-1]+=b[c];
          c--;
        }
      }
      printf("%I64d\n",ans);
      scanf("%d",&k);
    }
    return 0;
}
